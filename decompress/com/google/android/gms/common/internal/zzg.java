// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;
import android.os.Bundle;

public final class zzg extends i
{
    final BaseGmsClient g;
    
    public zzg(final BaseGmsClient g, final int n, final Bundle bundle) {
        super(this.g = g, n, null);
    }
    
    @Override
    protected final void f(final ConnectionResult connectionResult) {
        if (this.g.enableLocalFallback() && BaseGmsClient.zzo((BaseGmsClient<IInterface>)this.g)) {
            BaseGmsClient.zzk((BaseGmsClient<IInterface>)this.g, 16);
            return;
        }
        this.g.zzc.a(connectionResult);
        this.g.onConnectionFailed(connectionResult);
    }
    
    @Override
    protected final boolean g() {
        this.g.zzc.a(ConnectionResult.e);
        return true;
    }
}
