// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ThreadFactory;

@KeepForSdk
public class NumberedThreadFactory implements ThreadFactory
{
    private final String a;
    private final AtomicInteger b;
    private final ThreadFactory c;
    
    @KeepForSdk
    public NumberedThreadFactory(final String a) {
        this.b = new AtomicInteger();
        this.c = Executors.defaultThreadFactory();
        Preconditions.l(a, "Name must not be null");
        this.a = a;
    }
    
    @Override
    public final Thread newThread(final Runnable runnable) {
        final Thread thread = this.c.newThread(new a(runnable, 0));
        final String a = this.a;
        final int andIncrement = this.b.getAndIncrement();
        final StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        thread.setName(sb.toString());
        return thread;
    }
}
