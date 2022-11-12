// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzflv;

final class a implements zzflv
{
    final zzi a;
    
    a(final zzi a) {
        this.a = a;
    }
    
    public final void zza(final int n, final long n2) {
        zzi.a(this.a).zzd(n, System.currentTimeMillis() - n2);
    }
    
    public final void zzb(final int n, final long n2, final String s) {
        zzi.a(this.a).zze(n, System.currentTimeMillis() - n2, s);
    }
}
