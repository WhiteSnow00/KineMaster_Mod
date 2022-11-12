// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdsd;

public final class zzk implements Runnable
{
    public final zzz a;
    public final zzdsd[] b;
    
    public zzk(final zzz a, final zzdsd[] b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        this.a.u1(this.b);
    }
}
