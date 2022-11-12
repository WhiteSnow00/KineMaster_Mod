// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import android.os.IInterface;
import android.os.Bundle;

abstract class i extends zzc
{
    public final int d;
    public final Bundle e;
    final BaseGmsClient f;
    
    protected i(final BaseGmsClient f, final int d, final Bundle e) {
        super(this.f = f, Boolean.TRUE);
        this.d = d;
        this.e = e;
    }
    
    @Override
    protected final /* bridge */ void a(final Object o) {
        final int d = this.d;
        PendingIntent pendingIntent = null;
        if (d == 0) {
            if (!this.g()) {
                BaseGmsClient.zzi((BaseGmsClient<IInterface>)this.f, 1, (IInterface)null);
                this.f(new ConnectionResult(8, null));
            }
            return;
        }
        BaseGmsClient.zzi((BaseGmsClient<IInterface>)this.f, 1, (IInterface)null);
        final Bundle e = this.e;
        if (e != null) {
            pendingIntent = (PendingIntent)e.getParcelable("pendingIntent");
        }
        this.f(new ConnectionResult(this.d, pendingIntent));
    }
    
    @Override
    protected final void b() {
    }
    
    protected abstract void f(final ConnectionResult p0);
    
    protected abstract boolean g();
}
