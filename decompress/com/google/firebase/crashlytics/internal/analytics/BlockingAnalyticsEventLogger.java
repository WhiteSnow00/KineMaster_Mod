// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.analytics;

import com.google.firebase.crashlytics.internal.Logger;
import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger
{
    private final CrashlyticsOriginAnalyticsEventLogger a;
    private final int b;
    private final TimeUnit c;
    private final Object d;
    private CountDownLatch e;
    private boolean f;
    
    public BlockingAnalyticsEventLogger(final CrashlyticsOriginAnalyticsEventLogger a, final int b, final TimeUnit c) {
        this.d = new Object();
        this.f = false;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public void a(final String s, final Bundle bundle) {
        synchronized (this.d) {
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Logging event ");
            sb.append(s);
            sb.append(" to Firebase Analytics with params ");
            sb.append(bundle);
            f.i(sb.toString());
            this.e = new CountDownLatch(1);
            this.f = false;
            this.a.a(s, bundle);
            Logger.f().i("Awaiting app exception callback from Analytics...");
            try {
                if (this.e.await(this.b, this.c)) {
                    this.f = true;
                    Logger.f().i("App exception callback received from Analytics listener.");
                }
                else {
                    Logger.f().k("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                }
            }
            catch (final InterruptedException ex) {
                Logger.f().d("Interrupted while awaiting app exception callback from Analytics listener.");
            }
            this.e = null;
        }
    }
    
    @Override
    public void onEvent(final String s, final Bundle bundle) {
        final CountDownLatch e = this.e;
        if (e == null) {
            return;
        }
        if ("_ae".equals(s)) {
            e.countDown();
        }
    }
}
