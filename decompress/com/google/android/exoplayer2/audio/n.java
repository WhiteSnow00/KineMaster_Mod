// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class n implements Executor
{
    public final Handler a;
    
    public n(final Handler a) {
        this.a = a;
    }
    
    @Override
    public final void execute(final Runnable runnable) {
        this.a.post(runnable);
    }
}
