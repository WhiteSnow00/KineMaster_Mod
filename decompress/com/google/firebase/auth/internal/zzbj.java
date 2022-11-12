// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.internal.firebase_auth_api.zzg;
import android.os.Looper;
import android.os.Handler;
import java.util.concurrent.Executor;

public final class zzbj implements Executor
{
    private static final zzbj b;
    private final Handler a;
    
    static {
        b = new zzbj();
    }
    
    private zzbj() {
        this.a = (Handler)new zzg(Looper.getMainLooper());
    }
    
    public static zzbj a() {
        return zzbj.b;
    }
    
    @Override
    public final void execute(final Runnable runnable) {
        this.a.post(runnable);
    }
}
