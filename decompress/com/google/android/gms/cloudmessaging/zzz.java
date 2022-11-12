// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import java.util.concurrent.Executor;

public final class zzz implements Executor
{
    public static final zzz a;
    
    static {
        a = new zzz();
    }
    
    private zzz() {
    }
    
    @Override
    public final void execute(final Runnable runnable) {
        runnable.run();
    }
}
