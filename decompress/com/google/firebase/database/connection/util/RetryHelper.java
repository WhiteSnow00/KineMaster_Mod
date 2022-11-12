// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.connection.util;

import com.google.firebase.database.logging.Logger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ScheduledFuture;
import java.util.Random;
import com.google.firebase.database.logging.LogWrapper;
import java.util.concurrent.ScheduledExecutorService;

public class RetryHelper
{
    private final ScheduledExecutorService a;
    private final LogWrapper b;
    private final long c;
    private final long d;
    private final double e;
    private final double f;
    private final Random g;
    private ScheduledFuture<?> h;
    private long i;
    private boolean j;
    
    private RetryHelper(final ScheduledExecutorService a, final LogWrapper b, final long c, final long d, final double f, final double e) {
        this.g = new Random();
        this.j = true;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.f = f;
        this.e = e;
    }
    
    RetryHelper(final ScheduledExecutorService scheduledExecutorService, final LogWrapper logWrapper, final long n, final long n2, final double n3, final double n4, final RetryHelper$a runnable) {
        this(scheduledExecutorService, logWrapper, n, n2, n3, n4);
    }
    
    static ScheduledFuture a(final RetryHelper retryHelper, final ScheduledFuture h) {
        return retryHelper.h = h;
    }
    
    public void b() {
        if (this.h != null) {
            this.b.b("Cancelling existing retry attempt", new Object[0]);
            this.h.cancel(false);
            this.h = null;
        }
        else {
            this.b.b("No existing retry attempt to cancel", new Object[0]);
        }
        this.i = 0L;
    }
    
    public void c(final Runnable runnable) {
        final Runnable runnable2 = new Runnable(this, runnable) {
            final Runnable a;
            final RetryHelper b;
            
            @Override
            public void run() {
                RetryHelper.a(this.b, null);
                this.a.run();
            }
        };
        if (this.h != null) {
            this.b.b("Cancelling previous scheduled retry", new Object[0]);
            this.h.cancel(false);
            this.h = null;
        }
        final boolean j = this.j;
        long n = 0L;
        if (!j) {
            final long i = this.i;
            if (i == 0L) {
                this.i = this.c;
            }
            else {
                this.i = Math.min((long)(i * this.f), this.d);
            }
            final double e = this.e;
            final long k = this.i;
            n = (long)((1.0 - e) * k + e * k * this.g.nextDouble());
        }
        this.j = false;
        this.b.b("Scheduling retry in %dms", n);
        this.h = this.a.schedule(runnable2, n, TimeUnit.MILLISECONDS);
    }
    
    public void d() {
        this.i = this.d;
    }
    
    public void e() {
        this.j = true;
        this.i = 0L;
    }
    
    public static class Builder
    {
        private final ScheduledExecutorService a;
        private long b;
        private double c;
        private long d;
        private double e;
        private final LogWrapper f;
        
        public Builder(final ScheduledExecutorService a, final Logger logger, final String s) {
            this.b = 1000L;
            this.c = 0.5;
            this.d = 30000L;
            this.e = 1.3;
            this.a = a;
            this.f = new LogWrapper(logger, s);
        }
        
        public RetryHelper a() {
            return new RetryHelper(this.a, this.f, this.b, this.d, this.e, this.c, null);
        }
        
        public Builder b(final double c) {
            if (c >= 0.0 && c <= 1.0) {
                this.c = c;
                return this;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Argument out of range: ");
            sb.append(c);
            throw new IllegalArgumentException(sb.toString());
        }
        
        public Builder c(final long d) {
            this.d = d;
            return this;
        }
        
        public Builder d(final long b) {
            this.b = b;
            return this;
        }
        
        public Builder e(final double e) {
            this.e = e;
            return this;
        }
    }
}
