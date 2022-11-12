// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.zaj;

final class q implements zaj
{
    final zabe a;
    
    q(final zabe a) {
        this.a = a;
    }
    
    @Override
    public final boolean isConnected() {
        return this.a.t();
    }
}
