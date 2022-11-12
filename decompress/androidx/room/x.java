// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import java.util.Set;
import android.os.RemoteException;
import android.util.Log;
import android.os.IBinder;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.Executor;
import android.content.Context;

class x
{
    final Context a;
    final String b;
    int c;
    final w d;
    final w.c e;
    t f;
    final Executor g;
    final s h;
    final AtomicBoolean i;
    final ServiceConnection j;
    final Runnable k;
    final Runnable l;
    
    x(Context applicationContext, final String b, final Intent intent, final w d, final Executor g) {
        this.h = new s.a() {
            final x a;
            
            public void m(final String[] array) {
                this.a.g.execute(new Runnable(this, array) {
                    final String[] a;
                    final x$a b;
                    
                    @Override
                    public void run() {
                        this.b.a.d.h(this.a);
                    }
                });
            }
        };
        this.i = new AtomicBoolean(false);
        final ServiceConnection j = (ServiceConnection)new ServiceConnection() {
            final x a;
            
            public void onServiceConnected(final ComponentName componentName, final IBinder binder) {
                this.a.f = t.a.M0(binder);
                final x a = this.a;
                a.g.execute(a.k);
            }
            
            public void onServiceDisconnected(final ComponentName componentName) {
                final x a = this.a;
                a.g.execute(a.l);
                this.a.f = null;
            }
        };
        this.j = (ServiceConnection)j;
        this.k = new Runnable() {
            final x a;
            
            @Override
            public void run() {
                try {
                    final x a = this.a;
                    final t f = a.f;
                    if (f != null) {
                        a.c = f.B0(a.h, a.b);
                        final x a2 = this.a;
                        a2.d.a(a2.e);
                    }
                }
                catch (final RemoteException ex) {
                    Log.w("ROOM", "Cannot register multi-instance invalidation callback", (Throwable)ex);
                }
            }
        };
        this.l = new Runnable() {
            final x a;
            
            @Override
            public void run() {
                final x a = this.a;
                a.d.l(a.e);
            }
        };
        applicationContext = applicationContext.getApplicationContext();
        this.a = applicationContext;
        this.b = b;
        this.d = d;
        this.g = g;
        this.e = new w.c(this, d.a.keySet().toArray(new String[0])) {
            final x a;
            
            @Override
            boolean isRemote() {
                return true;
            }
            
            @Override
            public void onInvalidated(final Set<String> set) {
                if (this.a.i.get()) {
                    return;
                }
                try {
                    final x a = this.a;
                    final t f = a.f;
                    if (f != null) {
                        f.g0(a.c, set.toArray(new String[0]));
                    }
                }
                catch (final RemoteException ex) {
                    Log.w("ROOM", "Cannot broadcast invalidation", (Throwable)ex);
                }
            }
        };
        applicationContext.bindService(intent, (ServiceConnection)j, 1);
    }
    
    void a() {
        if (this.i.compareAndSet(false, true)) {
            this.d.l(this.e);
            try {
                final t f = this.f;
                if (f != null) {
                    f.o1(this.h, this.c);
                }
            }
            catch (final RemoteException ex) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", (Throwable)ex);
            }
            this.a.unbindService(this.j);
        }
    }
}
