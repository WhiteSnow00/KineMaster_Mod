// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class zabk implements Executor
{
    public final Handler a;
    
    public zabk(final Handler a) {
        this.a = a;
    }
    
    @Override
    public final void execute(final Runnable runnable) {
        this.a.post(runnable);
    }
}
