// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.util.Log;
import android.os.IInterface;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzd extends zzab
{
    private BaseGmsClient a;
    private final int b;
    
    public zzd(final BaseGmsClient a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    public final void G(final int n, final IBinder binder, final Bundle bundle) {
        Preconditions.l(this.a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.a.onPostInitHandler(n, binder, bundle, this.b);
        this.a = null;
    }
    
    public final void W0(final int n, final IBinder binder, final zzj zzj) {
        final BaseGmsClient a = this.a;
        Preconditions.l(a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        Preconditions.k(zzj);
        BaseGmsClient.zzj((BaseGmsClient<IInterface>)a, zzj);
        this.G(n, binder, zzj.a);
    }
    
    public final void a(final int n, final Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", (Throwable)new Exception());
    }
}
