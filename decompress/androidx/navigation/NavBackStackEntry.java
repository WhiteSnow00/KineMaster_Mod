// 
// Decompiled by Procyon v0.6.0
// 

package androidx.navigation;

import androidx.lifecycle.l0;
import java.util.UUID;
import androidx.lifecycle.g0;
import androidx.lifecycle.q0;
import u0.c;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.o0;
import android.app.Application;
import java.util.Iterator;
import java.util.Set;
import androidx.lifecycle.i0;
import kotlin.jvm.internal.o;
import kotlin.a;
import kotlin.jvm.internal.i;
import ka.j;
import u0.d;
import androidx.lifecycle.t;
import androidx.lifecycle.Lifecycle;
import android.os.Bundle;
import android.content.Context;
import kotlin.Metadata;
import u0.e;
import androidx.lifecycle.k;
import androidx.lifecycle.r0;
import androidx.lifecycle.r;

@Metadata(bv = {}, d1 = { "\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 W2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003\u001c 'BS\b\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010&\u001a\u00020\u001f\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010.\u001a\u00020,\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00107\u001a\u000203\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\bS\u0010TB\u001d\b\u0017\u0012\u0006\u0010U\u001a\u00020\u0000\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\bS\u0010VJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\b\u0010\u000b\u001a\u00020\tH\u0007J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0019\u0010+\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010-R\u0016\u00102\u001a\u0004\u0018\u00010/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0017\u00107\u001a\u0002038\u0006¢\u0006\f\n\u0004\b\"\u00104\u001a\u0004\b5\u00106R\u0016\u00108\u001a\u0004\u0018\u00010\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010(R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010=R*\u0010D\u001a\u00020,2\u0006\u0010?\u001a\u00020,8G@GX\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010-\u001a\u0004\b:\u0010A\"\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\b0\u0010HR\u001b\u0010N\u001a\u00020J8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010G\u001a\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010Q¨\u0006X" }, d2 = { "Landroidx/navigation/NavBackStackEntry;", "Landroidx/lifecycle/r;", "Landroidx/lifecycle/r0;", "Landroidx/lifecycle/k;", "Lu0/e;", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "Landroidx/lifecycle/Lifecycle$Event;", "event", "Lka/r;", "j", "n", "Landroidx/lifecycle/q0;", "getViewModelStore", "Landroidx/lifecycle/o0$b;", "getDefaultViewModelProviderFactory", "Lk0/a;", "getDefaultViewModelCreationExtras", "Landroid/os/Bundle;", "outBundle", "k", "", "other", "", "equals", "", "hashCode", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Landroidx/navigation/NavDestination;", "b", "Landroidx/navigation/NavDestination;", "f", "()Landroidx/navigation/NavDestination;", "l", "(Landroidx/navigation/NavDestination;)V", "destination", "c", "Landroid/os/Bundle;", "d", "()Landroid/os/Bundle;", "arguments", "Landroidx/lifecycle/Lifecycle$State;", "Landroidx/lifecycle/Lifecycle$State;", "hostLifecycleState", "Landroidx/navigation/u;", "e", "Landroidx/navigation/u;", "viewModelStoreProvider", "", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "id", "savedState", "Landroidx/lifecycle/t;", "h", "Landroidx/lifecycle/t;", "lifecycle", "Z", "savedStateRegistryAttached", "maxState", "x", "()Landroidx/lifecycle/Lifecycle$State;", "m", "(Landroidx/lifecycle/Lifecycle$State;)V", "maxLifecycle", "Landroidx/lifecycle/i0;", "defaultFactory$delegate", "Lka/j;", "()Landroidx/lifecycle/i0;", "defaultFactory", "Landroidx/lifecycle/g0;", "savedStateHandle$delegate", "i", "()Landroidx/lifecycle/g0;", "savedStateHandle", "Lu0/c;", "getSavedStateRegistry", "()Lu0/c;", "savedStateRegistry", "<init>", "(Landroid/content/Context;Landroidx/navigation/NavDestination;Landroid/os/Bundle;Landroidx/lifecycle/Lifecycle$State;Landroidx/navigation/u;Ljava/lang/String;Landroid/os/Bundle;)V", "entry", "(Landroidx/navigation/NavBackStackEntry;Landroid/os/Bundle;)V", "y", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
public final class NavBackStackEntry implements r, r0, k, e
{
    public static final a y;
    private final Context a;
    private NavDestination b;
    private final Bundle c;
    private Lifecycle.State d;
    private final u e;
    private final String f;
    private final Bundle g;
    private t h;
    private final d i;
    private boolean j;
    private final j p;
    private final j w;
    private Lifecycle.State x;
    
    static {
        y = new a(null);
    }
    
    private NavBackStackEntry(final Context a, final NavDestination b, final Bundle c, final Lifecycle.State d, final u e, final String f, final Bundle g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = new t(this);
        this.i = u0.d.d.a(this);
        this.p = kotlin.a.b((sa.a)new NavBackStackEntry$defaultFactory.NavBackStackEntry$defaultFactory$2(this));
        this.w = kotlin.a.b((sa.a)new NavBackStackEntry$savedStateHandle.NavBackStackEntry$savedStateHandle$2(this));
        this.x = Lifecycle.State.INITIALIZED;
    }
    
    public NavBackStackEntry(final Context context, final NavDestination navDestination, final Bundle bundle, final Lifecycle.State state, final u u, final String s, final Bundle bundle2, final i i) {
        this(context, navDestination, bundle, state, u, s, bundle2);
    }
    
    public NavBackStackEntry(final NavBackStackEntry navBackStackEntry, final Bundle bundle) {
        o.g((Object)navBackStackEntry, "entry");
        this(navBackStackEntry.a, navBackStackEntry.b, bundle, navBackStackEntry.d, navBackStackEntry.e, navBackStackEntry.f, navBackStackEntry.g);
        this.d = navBackStackEntry.d;
        this.m(navBackStackEntry.x);
    }
    
    public static final Context a(final NavBackStackEntry navBackStackEntry) {
        return navBackStackEntry.a;
    }
    
    public static final t b(final NavBackStackEntry navBackStackEntry) {
        return navBackStackEntry.h;
    }
    
    public static final boolean c(final NavBackStackEntry navBackStackEntry) {
        return navBackStackEntry.j;
    }
    
    private final i0 e() {
        return (i0)this.p.getValue();
    }
    
    public final Bundle d() {
        return this.c;
    }
    
    @Override
    public boolean equals(Object value) {
        boolean b2;
        final boolean b = b2 = false;
        if (value != null) {
            if (!(value instanceof NavBackStackEntry)) {
                b2 = b;
            }
            else {
                final String f = this.f;
                final NavBackStackEntry navBackStackEntry = (NavBackStackEntry)value;
                b2 = b;
                if (o.b((Object)f, (Object)navBackStackEntry.f)) {
                    b2 = b;
                    if (o.b((Object)this.b, (Object)navBackStackEntry.b)) {
                        b2 = b;
                        if (o.b((Object)this.h, (Object)navBackStackEntry.h)) {
                            b2 = b;
                            if (o.b((Object)this.getSavedStateRegistry(), (Object)navBackStackEntry.getSavedStateRegistry())) {
                                if (!o.b((Object)this.c, (Object)navBackStackEntry.c)) {
                                    final Bundle c = this.c;
                                    boolean b3 = false;
                                    Label_0238: {
                                        if (c != null) {
                                            final Set keySet = c.keySet();
                                            if (keySet != null) {
                                                int n = 0;
                                                Label_0226: {
                                                    if (!keySet.isEmpty()) {
                                                        for (final String s : keySet) {
                                                            final Object value2 = this.c.get(s);
                                                            final Bundle c2 = navBackStackEntry.c;
                                                            if (c2 != null) {
                                                                value = c2.get(s);
                                                            }
                                                            else {
                                                                value = null;
                                                            }
                                                            if (!o.b(value2, value)) {
                                                                n = 0;
                                                                break Label_0226;
                                                            }
                                                        }
                                                    }
                                                    n = 1;
                                                }
                                                if (n == 1) {
                                                    b3 = true;
                                                    break Label_0238;
                                                }
                                            }
                                        }
                                        b3 = false;
                                    }
                                    b2 = b;
                                    if (!b3) {
                                        return b2;
                                    }
                                }
                                b2 = true;
                            }
                        }
                    }
                }
            }
        }
        return b2;
    }
    
    public final NavDestination f() {
        return this.b;
    }
    
    public final String g() {
        return this.f;
    }
    
    @Override
    public k0.a getDefaultViewModelCreationExtras() {
        Application application = null;
        final k0.d d = new k0.d(null, 1, null);
        final Context a = this.a;
        Object applicationContext;
        if (a != null) {
            applicationContext = a.getApplicationContext();
        }
        else {
            applicationContext = null;
        }
        if (applicationContext instanceof Application) {
            application = (Application)applicationContext;
        }
        if (application != null) {
            d.c(o0.a.h, application);
        }
        d.c(SavedStateHandleSupport.a, this);
        d.c(SavedStateHandleSupport.b, this);
        final Bundle c = this.c;
        if (c != null) {
            d.c(SavedStateHandleSupport.c, c);
        }
        return d;
    }
    
    @Override
    public o0.b getDefaultViewModelProviderFactory() {
        return this.e();
    }
    
    @Override
    public Lifecycle getLifecycle() {
        return this.h;
    }
    
    @Override
    public u0.c getSavedStateRegistry() {
        return this.i.b();
    }
    
    @Override
    public q0 getViewModelStore() {
        if (!this.j) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).".toString());
        }
        if (this.h.b() == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.".toString());
        }
        final u e = this.e;
        if (e != null) {
            return e.g(this.f);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.".toString());
    }
    
    public final Lifecycle.State h() {
        return this.x;
    }
    
    @Override
    public int hashCode() {
        int n = this.f.hashCode() * 31 + this.b.hashCode();
        final Bundle c = this.c;
        int n2 = n;
        if (c != null) {
            final Set keySet = c.keySet();
            n2 = n;
            if (keySet != null) {
                final Iterator iterator = keySet.iterator();
                while (true) {
                    n2 = n;
                    if (!iterator.hasNext()) {
                        break;
                    }
                    final Object value = this.c.get((String)iterator.next());
                    int hashCode;
                    if (value != null) {
                        hashCode = value.hashCode();
                    }
                    else {
                        hashCode = 0;
                    }
                    n = n * 31 + hashCode;
                }
            }
        }
        return (n2 * 31 + this.h.hashCode()) * 31 + this.getSavedStateRegistry().hashCode();
    }
    
    public final g0 i() {
        return (g0)this.w.getValue();
    }
    
    public final void j(final Lifecycle.Event event) {
        o.g((Object)event, "event");
        final Lifecycle.State targetState = event.getTargetState();
        o.f((Object)targetState, "event.targetState");
        this.d = targetState;
        this.n();
    }
    
    public final void k(final Bundle bundle) {
        o.g((Object)bundle, "outBundle");
        this.i.e(bundle);
    }
    
    public final void l(final NavDestination b) {
        o.g((Object)b, "<set-?>");
        this.b = b;
    }
    
    public final void m(final Lifecycle.State x) {
        o.g((Object)x, "maxState");
        this.x = x;
        this.n();
    }
    
    public final void n() {
        if (!this.j) {
            this.i.c();
            this.j = true;
            if (this.e != null) {
                SavedStateHandleSupport.c(this);
            }
            this.i.d(this.g);
        }
        if (this.d.ordinal() < this.x.ordinal()) {
            this.h.o(this.d);
        }
        else {
            this.h.o(this.x);
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JR\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0013" }, d2 = { "Landroidx/navigation/NavBackStackEntry$a;", "", "Landroid/content/Context;", "context", "Landroidx/navigation/NavDestination;", "destination", "Landroid/os/Bundle;", "arguments", "Landroidx/lifecycle/Lifecycle$State;", "hostLifecycleState", "Landroidx/navigation/u;", "viewModelStoreProvider", "", "id", "savedState", "Landroidx/navigation/NavBackStackEntry;", "a", "<init>", "()V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    public static final class a
    {
        private a() {
        }
        
        public a(final i i) {
            this();
        }
        
        public static NavBackStackEntry b(final a a, final Context context, final NavDestination navDestination, Bundle bundle, Lifecycle.State created, u u, String string, Bundle bundle2, final int n, final Object o) {
            if ((n & 0x4) != 0x0) {
                bundle = null;
            }
            if ((n & 0x8) != 0x0) {
                created = Lifecycle.State.CREATED;
            }
            if ((n & 0x10) != 0x0) {
                u = null;
            }
            if ((n & 0x20) != 0x0) {
                string = UUID.randomUUID().toString();
                o.f((Object)string, "randomUUID().toString()");
            }
            if ((n & 0x40) != 0x0) {
                bundle2 = null;
            }
            return a.a(context, navDestination, bundle, created, u, string, bundle2);
        }
        
        public final NavBackStackEntry a(final Context context, final NavDestination navDestination, final Bundle bundle, final Lifecycle.State state, final u u, final String s, final Bundle bundle2) {
            o.g((Object)navDestination, "destination");
            o.g((Object)state, "hostLifecycleState");
            o.g((Object)s, "id");
            return new NavBackStackEntry(context, navDestination, bundle, state, u, s, bundle2, null);
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u0010" }, d2 = { "Landroidx/navigation/NavBackStackEntry$b;", "Landroidx/lifecycle/a;", "Landroidx/lifecycle/l0;", "T", "", "key", "Ljava/lang/Class;", "modelClass", "Landroidx/lifecycle/g0;", "handle", "e", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/g0;)Landroidx/lifecycle/l0;", "Lu0/e;", "owner", "<init>", "(Lu0/e;)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    private static final class b extends androidx.lifecycle.a
    {
        public b(final e e) {
            o.g((Object)e, "owner");
            super(e, null);
        }
        
        @Override
        protected <T extends l0> T e(final String s, final Class<T> clazz, final g0 g0) {
            o.g((Object)s, "key");
            o.g((Object)clazz, "modelClass");
            o.g((Object)g0, "handle");
            return (T)new NavBackStackEntry.c(g0);
        }
    }
    
    @Metadata(bv = {}, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n" }, d2 = { "Landroidx/navigation/NavBackStackEntry$c;", "Landroidx/lifecycle/l0;", "Landroidx/lifecycle/g0;", "a", "Landroidx/lifecycle/g0;", "h", "()Landroidx/lifecycle/g0;", "handle", "<init>", "(Landroidx/lifecycle/g0;)V", "navigation-common_release" }, k = 1, mv = { 1, 6, 0 })
    private static final class c extends l0
    {
        private final g0 a;
        
        public c(final g0 a) {
            o.g((Object)a, "handle");
            this.a = a;
        }
        
        public final g0 h() {
            return this.a;
        }
    }
}
