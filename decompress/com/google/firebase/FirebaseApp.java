// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.os.Looper;
import android.os.Handler;
import android.app.Application;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.atomic.AtomicReference;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.Base64Utils;
import java.nio.charset.Charset;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.firebase.events.Publisher;
import androidx.core.os.m;
import android.text.TextUtils;
import com.google.android.gms.common.util.ProcessUtils;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import android.util.Log;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import java.util.Collection;
import android.app.Service;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.CopyOnWriteArrayList;
import androidx.collection.a;
import java.util.List;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.DataCollectionConfigStorage;
import com.google.firebase.components.Lazy;
import java.util.concurrent.atomic.AtomicBoolean;
import com.google.firebase.components.ComponentRuntime;
import android.content.Context;
import java.util.Map;
import java.util.concurrent.Executor;

public class FirebaseApp
{
    private static final Object k;
    private static final Executor l;
    static final Map<String, FirebaseApp> m;
    private final Context a;
    private final String b;
    private final FirebaseOptions c;
    private final ComponentRuntime d;
    private final AtomicBoolean e;
    private final AtomicBoolean f;
    private final Lazy<DataCollectionConfigStorage> g;
    private final Provider<DefaultHeartBeatController> h;
    private final List<BackgroundStateChangeListener> i;
    private final List<FirebaseAppLifecycleListener> j;
    
    static {
        k = new Object();
        l = new c(null);
        m = new a<String, FirebaseApp>();
    }
    
    protected FirebaseApp(final Context context, final String s, final FirebaseOptions firebaseOptions) {
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean();
        this.i = new CopyOnWriteArrayList<BackgroundStateChangeListener>();
        this.j = new CopyOnWriteArrayList<FirebaseAppLifecycleListener>();
        this.a = Preconditions.k(context);
        this.b = Preconditions.g(s);
        this.c = Preconditions.k(firebaseOptions);
        final ComponentRuntime e = ComponentRuntime.i(FirebaseApp.l).d(ComponentDiscovery.c(context, ComponentDiscoveryService.class).b()).c(new FirebaseCommonRegistrar()).b(Component.p(context, Context.class, (Class<? super Context>[])new Class[0])).b(Component.p(this, FirebaseApp.class, (Class<? super FirebaseApp>[])new Class[0])).b(Component.p(firebaseOptions, FirebaseOptions.class, (Class<? super FirebaseOptions>[])new Class[0])).e();
        this.d = e;
        this.g = new Lazy<DataCollectionConfigStorage>((com.google.firebase.inject.Provider<DataCollectionConfigStorage>)new com.google.firebase.b(this, context));
        this.h = e.d(DefaultHeartBeatController.class);
        this.g((BackgroundStateChangeListener)new com.google.firebase.a(this));
    }
    
    private void A(final boolean b) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        final Iterator<BackgroundStateChangeListener> iterator = this.i.iterator();
        while (iterator.hasNext()) {
            iterator.next().a(b);
        }
    }
    
    public static void a(final FirebaseApp firebaseApp, final boolean b) {
        firebaseApp.y(b);
    }
    
    public static DataCollectionConfigStorage b(final FirebaseApp firebaseApp, final Context context) {
        return firebaseApp.x(context);
    }
    
    static Object c() {
        return FirebaseApp.k;
    }
    
    static void d(final FirebaseApp firebaseApp) {
        firebaseApp.r();
    }
    
    static AtomicBoolean e(final FirebaseApp firebaseApp) {
        return firebaseApp.e;
    }
    
    static void f(final FirebaseApp firebaseApp, final boolean b) {
        firebaseApp.A(b);
    }
    
    private void i() {
        Preconditions.p(this.f.get() ^ true, "FirebaseApp was deleted");
    }
    
    private static List<String> k() {
        final ArrayList list = new ArrayList();
        synchronized (FirebaseApp.k) {
            final Iterator<FirebaseApp> iterator = FirebaseApp.m.values().iterator();
            while (iterator.hasNext()) {
                list.add(iterator.next().o());
            }
            monitorexit(FirebaseApp.k);
            Collections.sort((List<Comparable>)list);
            return list;
        }
    }
    
    public static FirebaseApp m() {
        synchronized (FirebaseApp.k) {
            final FirebaseApp firebaseApp = FirebaseApp.m.get("[DEFAULT]");
            if (firebaseApp != null) {
                return firebaseApp;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Default FirebaseApp is not initialized in this process ");
            sb.append(ProcessUtils.a());
            sb.append(". Make sure to call FirebaseApp.initializeApp(Context) first.");
            throw new IllegalStateException(sb.toString());
        }
    }
    
    public static FirebaseApp n(final String s) {
        synchronized (FirebaseApp.k) {
            final FirebaseApp firebaseApp = FirebaseApp.m.get(z(s));
            if (firebaseApp != null) {
                ((DefaultHeartBeatController)firebaseApp.h.get()).n();
                return firebaseApp;
            }
            final List<String> k = k();
            String string;
            if (k.isEmpty()) {
                string = "";
            }
            else {
                final StringBuilder sb = new StringBuilder();
                sb.append("Available app names: ");
                sb.append(TextUtils.join((CharSequence)", ", (Iterable)k));
                string = sb.toString();
            }
            throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", s, string));
        }
    }
    
    private void r() {
        if (androidx.core.os.m.a(this.a) ^ true) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            sb.append(this.o());
            Log.i("FirebaseApp", sb.toString());
            FirebaseApp.d.a(this.a);
        }
        else {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Device unlocked: initializing all Firebase APIs for app ");
            sb2.append(this.o());
            Log.i("FirebaseApp", sb2.toString());
            this.d.l(this.w());
            ((DefaultHeartBeatController)this.h.get()).n();
        }
    }
    
    public static FirebaseApp s(final Context context) {
        synchronized (FirebaseApp.k) {
            if (FirebaseApp.m.containsKey("[DEFAULT]")) {
                return m();
            }
            final FirebaseOptions a = FirebaseOptions.a(context);
            if (a == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return t(context, a);
        }
    }
    
    public static FirebaseApp t(final Context context, final FirebaseOptions firebaseOptions) {
        return u(context, firebaseOptions, "[DEFAULT]");
    }
    
    public static FirebaseApp u(Context applicationContext, final FirebaseOptions firebaseOptions, String z) {
        b.b(applicationContext);
        z = z(z);
        if (applicationContext.getApplicationContext() != null) {
            applicationContext = applicationContext.getApplicationContext();
        }
        synchronized (FirebaseApp.k) {
            final Map<String, FirebaseApp> m = FirebaseApp.m;
            final boolean b = !m.containsKey(z);
            final StringBuilder sb = new StringBuilder();
            sb.append("FirebaseApp name ");
            sb.append(z);
            sb.append(" already exists!");
            Preconditions.p(b, sb.toString());
            Preconditions.l(applicationContext, "Application context cannot be null.");
            final FirebaseApp firebaseApp = new FirebaseApp(applicationContext, z, firebaseOptions);
            m.put(z, firebaseApp);
            monitorexit(FirebaseApp.k);
            firebaseApp.r();
            return firebaseApp;
        }
    }
    
    private DataCollectionConfigStorage x(final Context context) {
        return new DataCollectionConfigStorage(context, this.q(), (Publisher)this.d.a(Publisher.class));
    }
    
    private void y(final boolean b) {
        if (!b) {
            ((DefaultHeartBeatController)this.h.get()).n();
        }
    }
    
    private static String z(final String s) {
        return s.trim();
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof FirebaseApp && this.b.equals(((FirebaseApp)o).o());
    }
    
    @KeepForSdk
    public void g(final BackgroundStateChangeListener backgroundStateChangeListener) {
        this.i();
        if (this.e.get() && BackgroundDetector.b().d()) {
            backgroundStateChangeListener.a(true);
        }
        this.i.add(backgroundStateChangeListener);
    }
    
    @KeepForSdk
    public void h(final FirebaseAppLifecycleListener firebaseAppLifecycleListener) {
        this.i();
        Preconditions.k(firebaseAppLifecycleListener);
        this.j.add(firebaseAppLifecycleListener);
    }
    
    @Override
    public int hashCode() {
        return this.b.hashCode();
    }
    
    @KeepForSdk
    public <T> T j(final Class<T> clazz) {
        this.i();
        return (T)this.d.a(clazz);
    }
    
    public Context l() {
        this.i();
        return this.a;
    }
    
    public String o() {
        this.i();
        return this.b;
    }
    
    public FirebaseOptions p() {
        this.i();
        return this.c;
    }
    
    @KeepForSdk
    public String q() {
        final StringBuilder sb = new StringBuilder();
        sb.append(Base64Utils.e(this.o().getBytes(Charset.defaultCharset())));
        sb.append("+");
        sb.append(Base64Utils.e(this.p().c().getBytes(Charset.defaultCharset())));
        return sb.toString();
    }
    
    @Override
    public String toString() {
        return Objects.d(this).a("name", this.b).a("options", this.c).toString();
    }
    
    @KeepForSdk
    public boolean v() {
        this.i();
        return this.g.get().b();
    }
    
    @KeepForSdk
    public boolean w() {
        return "[DEFAULT]".equals(this.o());
    }
    
    @KeepForSdk
    public interface BackgroundStateChangeListener
    {
        @KeepForSdk
        void a(final boolean p0);
    }
    
    private static class b implements BackgroundDetector.BackgroundStateChangeListener
    {
        private static AtomicReference<b> a;
        
        static {
            b.a = new AtomicReference<b>();
        }
        
        static void b(final Context context) {
            c(context);
        }
        
        private static void c(final Context context) {
            if (PlatformVersion.a()) {
                if (context.getApplicationContext() instanceof Application) {
                    final Application application = (Application)context.getApplicationContext();
                    if (b.a.get() == null) {
                        final b b = new b();
                        if (FirebaseApp.b.a.compareAndSet(null, b)) {
                            BackgroundDetector.c(application);
                            BackgroundDetector.b().a((BackgroundDetector.BackgroundStateChangeListener)b);
                        }
                    }
                }
            }
        }
        
        @Override
        public void a(final boolean b) {
            synchronized (FirebaseApp.c()) {
                for (final FirebaseApp firebaseApp : new ArrayList(FirebaseApp.m.values())) {
                    if (FirebaseApp.e(firebaseApp).get()) {
                        FirebaseApp.f(firebaseApp, b);
                    }
                }
            }
        }
    }
    
    private static class c implements Executor
    {
        private static final Handler a;
        
        static {
            a = new Handler(Looper.getMainLooper());
        }
        
        private c() {
        }
        
        c(final FirebaseApp$a object) {
            this();
        }
        
        @Override
        public void execute(final Runnable runnable) {
            c.a.post(runnable);
        }
    }
    
    private static class d extends BroadcastReceiver
    {
        private static AtomicReference<d> b;
        private final Context a;
        
        static {
            d.b = new AtomicReference<d>();
        }
        
        public d(final Context a) {
            this.a = a;
        }
        
        static void a(final Context context) {
            b(context);
        }
        
        private static void b(final Context context) {
            if (d.b.get() == null) {
                final d d = new d(context);
                if (FirebaseApp.d.b.compareAndSet(null, d)) {
                    context.registerReceiver((BroadcastReceiver)d, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }
        
        public void c() {
            this.a.unregisterReceiver((BroadcastReceiver)this);
        }
        
        public void onReceive(final Context context, final Intent intent) {
            synchronized (FirebaseApp.c()) {
                final Iterator<FirebaseApp> iterator = FirebaseApp.m.values().iterator();
                while (iterator.hasNext()) {
                    FirebaseApp.d(iterator.next());
                }
                monitorexit(FirebaseApp.c());
                this.c();
            }
        }
    }
}
