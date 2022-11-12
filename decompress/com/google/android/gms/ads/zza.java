// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzdr;

public final class zza implements Runnable
{
    public final AdLoader a;
    public final zzdr b;
    
    public zza(final AdLoader a, final zzdr b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        this.a.b(this.b);
    }
}
