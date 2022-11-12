// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.app;

import java.util.ArrayDeque;
import android.os.Message;
import android.content.pm.ServiceInfo;
import java.util.List;
import android.content.pm.ResolveInfo;
import android.os.DeadObjectException;
import java.util.Iterator;
import android.util.Log;
import android.content.Intent;
import java.util.HashMap;
import java.util.Map;
import android.os.Handler;
import android.os.HandlerThread;
import android.content.ServiceConnection;
import android.os.Handler$Callback;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import android.app.NotificationChannel;
import android.os.Bundle;
import android.app.Notification;
import android.content.ComponentName;
import android.provider.Settings$Secure;
import java.util.HashSet;
import android.app.NotificationManager;
import android.content.Context;
import java.util.Set;

public final class o
{
    private static final Object c;
    private static String d;
    private static Set<String> e;
    private static final Object f;
    private static c g;
    private final Context a;
    private final NotificationManager b;
    
    static {
        c = new Object();
        o.e = new HashSet<String>();
        f = new Object();
    }
    
    private o(final Context a) {
        this.a = a;
        this.b = (NotificationManager)a.getSystemService("notification");
    }
    
    public static o c(final Context context) {
        return new o(context);
    }
    
    public static Set<String> d(Context c) {
        final String string = Settings$Secure.getString(c.getContentResolver(), "enabled_notification_listeners");
        c = (Context)o.c;
        monitorenter(c);
        Label_0105: {
            if (string == null) {
                break Label_0105;
            }
            try {
                if (!string.equals(o.d)) {
                    final String[] split = string.split(":", -1);
                    final HashSet e = new HashSet(split.length);
                    for (int length = split.length, i = 0; i < length; ++i) {
                        final ComponentName unflattenFromString = ComponentName.unflattenFromString(split[i]);
                        if (unflattenFromString != null) {
                            e.add((Object)unflattenFromString.getPackageName());
                        }
                    }
                    o.e = (Set<String>)e;
                    o.d = string;
                }
                return o.e;
            }
            finally {
                monitorexit(c);
            }
        }
    }
    
    private void f(final d d) {
        synchronized (o.f) {
            if (o.g == null) {
                o.g = new c(this.a.getApplicationContext());
            }
            o.g.h(d);
        }
    }
    
    private static boolean g(final Notification notification) {
        final Bundle a = l.a(notification);
        return a != null && a.getBoolean("android.support.useSideChannel");
    }
    
    public boolean a() {
        return this.b.areNotificationsEnabled();
    }
    
    public void b(final NotificationChannel notificationChannel) {
        this.b.createNotificationChannel(notificationChannel);
    }
    
    public void e(final String s, final int n, final Notification notification) {
        if (g(notification)) {
            this.f((d)new a(this.a.getPackageName(), n, s, notification));
            this.b.cancel(s, n);
        }
        else {
            this.b.notify(s, n, notification);
        }
    }
    
    private static class a implements d
    {
        final String a;
        final int b;
        final String c;
        final Notification d;
        
        a(final String a, final int b, final String c, final Notification d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        @Override
        public void a(final INotificationSideChannel notificationSideChannel) throws RemoteException {
            notificationSideChannel.notify(this.a, this.b, this.c, this.d);
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("NotifyTask[");
            sb.append("packageName:");
            sb.append(this.a);
            sb.append(", id:");
            sb.append(this.b);
            sb.append(", tag:");
            sb.append(this.c);
            sb.append("]");
            return sb.toString();
        }
    }
    
    private interface d
    {
        void a(final INotificationSideChannel p0) throws RemoteException;
    }
    
    private static class b
    {
        final ComponentName a;
        final IBinder b;
        
        b(final ComponentName a, final IBinder b) {
            this.a = a;
            this.b = b;
        }
    }
    
    private static class c implements Handler$Callback, ServiceConnection
    {
        private final Context a;
        private final HandlerThread b;
        private final Handler c;
        private final Map<ComponentName, a> d;
        private Set<String> e;
        
        c(final Context a) {
            this.d = new HashMap<ComponentName, a>();
            this.e = new HashSet<String>();
            this.a = a;
            final HandlerThread b = new HandlerThread("NotificationManagerCompat");
            (this.b = b).start();
            this.c = new Handler(b.getLooper(), (Handler$Callback)this);
        }
        
        private boolean a(final a a) {
            if (a.b) {
                return true;
            }
            final boolean bindService = this.a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(a.a), (ServiceConnection)this, 33);
            a.b = bindService;
            if (bindService) {
                a.e = 0;
            }
            else {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unable to bind to listener ");
                sb.append(a.a);
                Log.w("NotifManCompat", sb.toString());
                this.a.unbindService((ServiceConnection)this);
            }
            return a.b;
        }
        
        private void b(final a a) {
            if (a.b) {
                this.a.unbindService((ServiceConnection)this);
                a.b = false;
            }
            a.c = null;
        }
        
        private void c(final d d) {
            this.j();
            for (final a a : this.d.values()) {
                a.d.add(d);
                this.g(a);
            }
        }
        
        private void d(final ComponentName componentName) {
            final a a = this.d.get(componentName);
            if (a != null) {
                this.g(a);
            }
        }
        
        private void e(final ComponentName componentName, final IBinder binder) {
            final a a = this.d.get(componentName);
            if (a != null) {
                a.c = INotificationSideChannel.Stub.asInterface(binder);
                a.e = 0;
                this.g(a);
            }
        }
        
        private void f(final ComponentName componentName) {
            final a a = this.d.get(componentName);
            if (a != null) {
                this.b(a);
            }
        }
        
        private void g(final a a) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Processing component ");
                sb.append(a.a);
                sb.append(", ");
                sb.append(a.d.size());
                sb.append(" queued tasks");
                Log.d("NotifManCompat", sb.toString());
            }
            if (a.d.isEmpty()) {
                return;
            }
            if (this.a(a) && a.c != null) {
                while (true) {
                    final d d = a.d.peek();
                    if (d == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Sending task ");
                            sb2.append(d);
                            Log.d("NotifManCompat", sb2.toString());
                        }
                        d.a(a.c);
                        a.d.remove();
                        continue;
                    }
                    catch (final RemoteException ex) {
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("RemoteException communicating with ");
                        sb3.append(a.a);
                        Log.w("NotifManCompat", sb3.toString(), (Throwable)ex);
                    }
                    catch (final DeadObjectException ex2) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            final StringBuilder sb4 = new StringBuilder();
                            sb4.append("Remote service has died: ");
                            sb4.append(a.a);
                            Log.d("NotifManCompat", sb4.toString());
                        }
                    }
                    break;
                }
                if (!a.d.isEmpty()) {
                    this.i(a);
                }
                return;
            }
            this.i(a);
        }
        
        private void i(final a a) {
            if (this.c.hasMessages(3, (Object)a.a)) {
                return;
            }
            final int e = a.e + 1;
            if ((a.e = e) > 6) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Giving up on delivering ");
                sb.append(a.d.size());
                sb.append(" tasks to ");
                sb.append(a.a);
                sb.append(" after ");
                sb.append(a.e);
                sb.append(" retries");
                Log.w("NotifManCompat", sb.toString());
                a.d.clear();
                return;
            }
            final int n = (1 << e - 1) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Scheduling retry for ");
                sb2.append(n);
                sb2.append(" ms");
                Log.d("NotifManCompat", sb2.toString());
            }
            this.c.sendMessageDelayed(this.c.obtainMessage(3, (Object)a.a), (long)n);
        }
        
        private void j() {
            final Set<String> d = o.d(this.a);
            if (d.equals(this.e)) {
                return;
            }
            this.e = d;
            final List queryIntentServices = this.a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            final HashSet set = new HashSet();
            for (final ResolveInfo resolveInfo : queryIntentServices) {
                if (!d.contains(resolveInfo.serviceInfo.packageName)) {
                    continue;
                }
                final ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                final ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                if (resolveInfo.serviceInfo.permission != null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Permission present on component ");
                    sb.append(componentName);
                    sb.append(", not adding listener record.");
                    Log.w("NotifManCompat", sb.toString());
                }
                else {
                    set.add(componentName);
                }
            }
            for (final ComponentName componentName2 : set) {
                if (!this.d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Adding listener record for ");
                        sb2.append(componentName2);
                        Log.d("NotifManCompat", sb2.toString());
                    }
                    this.d.put(componentName2, new a(componentName2));
                }
            }
            final Iterator<Map.Entry<ComponentName, a>> iterator3 = this.d.entrySet().iterator();
            while (iterator3.hasNext()) {
                final Map.Entry<Object, V> entry = (Map.Entry<Object, V>)iterator3.next();
                if (!set.contains(entry.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("Removing listener record for ");
                        sb3.append(entry.getKey());
                        Log.d("NotifManCompat", sb3.toString());
                    }
                    this.b((a)entry.getValue());
                    iterator3.remove();
                }
            }
        }
        
        public void h(final d d) {
            this.c.obtainMessage(0, (Object)d).sendToTarget();
        }
        
        public boolean handleMessage(final Message message) {
            final int what = message.what;
            if (what == 0) {
                this.c((d)message.obj);
                return true;
            }
            if (what == 1) {
                final b b = (b)message.obj;
                this.e(b.a, b.b);
                return true;
            }
            if (what == 2) {
                this.f((ComponentName)message.obj);
                return true;
            }
            if (what != 3) {
                return false;
            }
            this.d((ComponentName)message.obj);
            return true;
        }
        
        public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Connected to service ");
                sb.append(componentName);
                Log.d("NotifManCompat", sb.toString());
            }
            this.c.obtainMessage(1, (Object)new b(componentName, binder)).sendToTarget();
        }
        
        public void onServiceDisconnected(final ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Disconnected from service ");
                sb.append(componentName);
                Log.d("NotifManCompat", sb.toString());
            }
            this.c.obtainMessage(2, (Object)componentName).sendToTarget();
        }
        
        private static class a
        {
            final ComponentName a;
            boolean b;
            INotificationSideChannel c;
            ArrayDeque<d> d;
            int e;
            
            a(final ComponentName a) {
                this.b = false;
                this.d = new ArrayDeque<d>();
                this.e = 0;
                this.a = a;
            }
        }
    }
}
