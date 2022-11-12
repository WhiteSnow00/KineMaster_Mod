// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import android.content.ComponentName;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.internal.Preconditions;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.content.ServiceConnection;

@KeepForSdk
public class BlockingServiceConnection implements ServiceConnection
{
    boolean a;
    private final BlockingQueue b;
    
    public BlockingServiceConnection() {
        this.a = false;
        this.b = new LinkedBlockingQueue();
    }
    
    @KeepForSdk
    public IBinder a() throws InterruptedException {
        Preconditions.j("BlockingServiceConnection.getService() called on main thread");
        if (!this.a) {
            this.a = true;
            return this.b.take();
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }
    
    @KeepForSdk
    public IBinder b(final long n, final TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        Preconditions.j("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.a = true;
        final IBinder binder = this.b.poll(n, timeUnit);
        if (binder != null) {
            return binder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }
    
    public final void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        this.b.add(binder);
    }
    
    public final void onServiceDisconnected(final ComponentName componentName) {
    }
}
