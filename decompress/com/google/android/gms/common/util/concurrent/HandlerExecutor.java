// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.internal.common.zzi;
import android.os.Looper;
import android.os.Handler;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.Executor;

@KeepForSdk
public class HandlerExecutor implements Executor
{
    private final Handler a;
    
    @KeepForSdk
    public HandlerExecutor(final Looper looper) {
        this.a = (Handler)new zzi(looper);
    }
    
    @Override
    public final void execute(final Runnable runnable) {
        this.a.post(runnable);
    }
}
