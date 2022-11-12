// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdwb;

public final class zzi implements Runnable
{
    public final zzz a;
    public final String b;
    public final String c;
    public final zzdwb d;
    
    public zzi(final zzz a, final String b, final String c, final zzdwb d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public final void run() {
        this.a.v1(this.b, this.c, this.d);
    }
}
