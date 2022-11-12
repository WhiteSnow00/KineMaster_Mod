// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadFactory;

final class b0 implements ThreadFactory
{
    private final ThreadFactory a;
    private final AtomicInteger b;
    
    b0(final d d) {
        this.a = Executors.defaultThreadFactory();
        this.b = new AtomicInteger(1);
    }
    
    @Override
    public final Thread newThread(final Runnable runnable) {
        final Thread thread = this.a.newThread(runnable);
        final int andIncrement = this.b.getAndIncrement();
        final StringBuilder sb = new StringBuilder();
        sb.append("PlayBillingLibrary-");
        sb.append(andIncrement);
        thread.setName(sb.toString());
        return thread;
    }
}
