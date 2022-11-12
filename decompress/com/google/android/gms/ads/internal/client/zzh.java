// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdLoadCallback;

public final class zzh extends zzbh
{
    private final AdLoadCallback a;
    private final Object b;
    
    public zzh(final AdLoadCallback a, final Object b) {
        this.a = a;
        this.b = b;
    }
    
    public final void zzb(final zze zze) {
        final AdLoadCallback a = this.a;
        if (a != null) {
            a.onAdFailedToLoad(zze.L1());
        }
    }
    
    public final void zzc() {
        final AdLoadCallback a = this.a;
        if (a != null) {
            final Object b = this.b;
            if (b != null) {
                a.onAdLoaded(b);
            }
        }
    }
}
