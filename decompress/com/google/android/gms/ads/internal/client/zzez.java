// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

public final class zzez extends zzdd
{
    private final OnPaidEventListener a;
    
    public zzez(final OnPaidEventListener a) {
        this.a = a;
    }
    
    public final void Y0(final zzs zzs) {
        final OnPaidEventListener a = this.a;
        if (a != null) {
            a.a(AdValue.a(zzs.b, zzs.c, zzs.d));
        }
    }
}
