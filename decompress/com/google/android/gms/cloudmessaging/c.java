// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.content.ComponentName;
import java.util.concurrent.TimeUnit;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import com.google.android.gms.common.stats.ConnectionTracker;
import android.util.Log;
import java.util.ArrayDeque;
import android.os.Handler;
import android.os.Handler$Callback;
import android.os.Looper;
import android.util.SparseArray;
import java.util.Queue;
import android.os.Messenger;
import javax.annotation.concurrent.GuardedBy;
import android.content.ServiceConnection;

final class c implements ServiceConnection
{
    @GuardedBy
    int a;
    final Messenger b;
    d c;
    @GuardedBy
    final Queue<f<?>> d;
    @GuardedBy
    final SparseArray<f<?>> e;
    final zzs f;
    
    c(final zzs f, final zzl zzl) {
        this.f = f;
        this.a = 0;
        this.b = new Messenger((Handler)new com.google.android.gms.internal.cloudmessaging.zzf(Looper.getMainLooper(), (Handler$Callback)new zzf(this)));
        this.d = new ArrayDeque<f<?>>();
        this.e = (SparseArray<f<?>>)new SparseArray();
    }
    
    final void a(final int n, final String s) {
        synchronized (this) {
            this.b(n, s, null);
        }
    }
    
    final void b(int i, final String s, final Throwable t) {
        synchronized (this) {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                final String value = String.valueOf(s);
                String concat;
                if (value.length() != 0) {
                    concat = "Disconnected: ".concat(value);
                }
                else {
                    concat = new String("Disconnected: ");
                }
                Log.d("MessengerIpcClient", concat);
            }
            final int a = this.a;
            if (a == 0) {
                throw new IllegalStateException();
            }
            if (a == 1 || a == 2) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.a = 4;
                ConnectionTracker.b().c(zzs.a(this.f), (ServiceConnection)this);
                final zzq zzq = new zzq(i, s, t);
                final Iterator<Object> iterator = this.d.iterator();
                while (iterator.hasNext()) {
                    iterator.next().c(zzq);
                }
                this.d.clear();
                for (i = 0; i < this.e.size(); ++i) {
                    ((f)this.e.valueAt(i)).c(zzq);
                }
                this.e.clear();
                return;
            }
            if (a != 3) {
                return;
            }
            this.a = 4;
        }
    }
    
    final void c() {
        zzs.e(this.f).execute(new zzh(this));
    }
    
    final void d() {
        synchronized (this) {
            if (this.a == 1) {
                this.a(1, "Timed out while binding");
            }
        }
    }
    
    final void e(final int n) {
        synchronized (this) {
            final f f = (f)this.e.get(n);
            if (f != null) {
                final StringBuilder sb = new StringBuilder(31);
                sb.append("Timing out request: ");
                sb.append(n);
                Log.w("MessengerIpcClient", sb.toString());
                this.e.remove(n);
                f.c(new zzq(3, "Timed out waiting for response", null));
                this.f();
            }
        }
    }
    
    final void f() {
        synchronized (this) {
            if (this.a == 2 && this.d.isEmpty() && this.e.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.a = 3;
                ConnectionTracker.b().c(zzs.a(this.f), (ServiceConnection)this);
            }
        }
    }
    
    final boolean g(final f<?> f) {
        synchronized (this) {
            final int a = this.a;
            if (a == 0) {
                this.d.add(f);
                Preconditions.o(this.a == 0);
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Starting bind to GmsCore");
                }
                this.a = 1;
                final Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                intent.setPackage("com.google.android.gms");
                try {
                    if (!ConnectionTracker.b().a(zzs.a(this.f), intent, (ServiceConnection)this, 1)) {
                        this.a(0, "Unable to bind to service");
                    }
                    else {
                        zzs.e(this.f).schedule(new zzi(this), 30L, TimeUnit.SECONDS);
                    }
                }
                catch (final SecurityException ex) {
                    this.b(0, "Unable to bind to service", ex);
                }
                return true;
            }
            if (a == 1) {
                this.d.add(f);
                return true;
            }
            if (a != 2) {
                return false;
            }
            this.d.add(f);
            this.c();
            return true;
        }
    }
    
    public final void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        zzs.e(this.f).execute(new zzj(this, binder));
    }
    
    public final void onServiceDisconnected(final ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        zzs.e(this.f).execute(new zzg(this));
    }
}
