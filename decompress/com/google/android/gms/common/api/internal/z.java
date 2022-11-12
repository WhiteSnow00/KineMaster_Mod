// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.BaseGmsClient;

final class z implements SignOutCallbacks
{
    final zabq a;
    
    z(final zabq a) {
        this.a = a;
    }
    
    @Override
    public final void a() {
        GoogleApiManager.s(this.a.x).post((Runnable)new y(this));
    }
}
