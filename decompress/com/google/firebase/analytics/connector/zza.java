// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.analytics.connector;

import java.util.concurrent.Executor;

public final class zza implements Executor
{
    public static final zza a;
    
    static {
        a = new zza();
    }
    
    private zza() {
    }
    
    @Override
    public final void execute(final Runnable runnable) {
        runnable.run();
    }
}
