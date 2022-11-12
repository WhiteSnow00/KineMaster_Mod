// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.FullScreenContentCallback;

public final class zzaz extends zzcf
{
    private final FullScreenContentCallback a;
    
    public zzaz(final FullScreenContentCallback a) {
        this.a = a;
    }
    
    public final void zzb() {
        final FullScreenContentCallback a = this.a;
        if (a != null) {
            a.onAdClicked();
        }
    }
    
    public final void zzc() {
        final FullScreenContentCallback a = this.a;
        if (a != null) {
            a.onAdDismissedFullScreenContent();
        }
    }
    
    public final void zzd(final zze zze) {
        final FullScreenContentCallback a = this.a;
        if (a != null) {
            a.onAdFailedToShowFullScreenContent(zze.K1());
        }
    }
    
    public final void zze() {
        final FullScreenContentCallback a = this.a;
        if (a != null) {
            a.onAdImpression();
        }
    }
    
    public final void zzf() {
        final FullScreenContentCallback a = this.a;
        if (a != null) {
            a.onAdShowedFullScreenContent();
        }
    }
}
