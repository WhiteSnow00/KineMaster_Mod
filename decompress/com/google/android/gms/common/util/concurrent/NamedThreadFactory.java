// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ThreadFactory;

@KeepForSdk
public class NamedThreadFactory implements ThreadFactory
{
    private final String a;
    private final ThreadFactory b;
    
    @KeepForSdk
    public NamedThreadFactory(final String a) {
        this.b = Executors.defaultThreadFactory();
        Preconditions.l(a, "Name must not be null");
        this.a = a;
    }
    
    @Override
    public final Thread newThread(final Runnable runnable) {
        final Thread thread = this.b.newThread(new a(runnable, 0));
        thread.setName(this.a);
        return thread;
    }
}
