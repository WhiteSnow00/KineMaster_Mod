// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

final class f0 implements Runnable
{
    final zact a;
    
    f0(final zact a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        zact.p1(this.a).c(new ConnectionResult(4));
    }
}
