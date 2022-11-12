// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;

public final class zzg extends zzbe
{
    private final AdListener a;
    
    public zzg(final AdListener a) {
        this.a = a;
    }
    
    public final AdListener M0() {
        return this.a;
    }
    
    public final void zzc() {
        final AdListener a = this.a;
        if (a != null) {
            a.onAdClicked();
        }
    }
    
    public final void zzd() {
        final AdListener a = this.a;
        if (a != null) {
            a.onAdClosed();
        }
    }
    
    public final void zze(final int n) {
    }
    
    public final void zzf(final zze zze) {
        final AdListener a = this.a;
        if (a != null) {
            a.onAdFailedToLoad(zze.L1());
        }
    }
    
    public final void zzg() {
        final AdListener a = this.a;
        if (a != null) {
            a.onAdImpression();
        }
    }
    
    public final void zzh() {
    }
    
    public final void zzi() {
        final AdListener a = this.a;
        if (a != null) {
            a.onAdLoaded();
        }
    }
    
    public final void zzj() {
        final AdListener a = this.a;
        if (a != null) {
            a.onAdOpened();
        }
    }
}
