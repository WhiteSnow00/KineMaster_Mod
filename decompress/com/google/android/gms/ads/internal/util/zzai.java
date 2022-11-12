// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzfvk;

public final class zzai implements Runnable
{
    public final zzas a;
    public final zzfvk b;
    
    public zzai(final zzas a, final zzfvk b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        this.a.c(this.b);
    }
}
