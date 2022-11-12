// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.identifier;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.CountDownLatch;
import java.lang.ref.WeakReference;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class b extends Thread
{
    private final WeakReference<AdvertisingIdClient> a;
    private final long b;
    final CountDownLatch c;
    boolean d;
    
    public b(final AdvertisingIdClient advertisingIdClient, final long b) {
        this.a = new WeakReference<AdvertisingIdClient>(advertisingIdClient);
        this.b = b;
        this.c = new CountDownLatch(1);
        this.d = false;
        this.start();
    }
    
    private final void a() {
        final AdvertisingIdClient advertisingIdClient = this.a.get();
        if (advertisingIdClient != null) {
            advertisingIdClient.e();
            this.d = true;
        }
    }
    
    @Override
    public final void run() {
        try {
            if (!this.c.await(this.b, TimeUnit.MILLISECONDS)) {
                this.a();
            }
        }
        catch (final InterruptedException ex) {
            this.a();
        }
    }
}
