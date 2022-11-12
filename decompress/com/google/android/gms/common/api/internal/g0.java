// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zak;

final class g0 implements Runnable
{
    final zak a;
    final zact b;
    
    g0(final zact b, final zak a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public final void run() {
        zact.q1(this.b, this.a);
    }
}
