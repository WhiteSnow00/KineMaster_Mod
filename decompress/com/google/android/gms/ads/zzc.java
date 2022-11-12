// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzbyx;

public final class zzc implements Runnable
{
    public final BaseAdView a;
    public final AdRequest b;
    
    public zzc(final BaseAdView a, final AdRequest b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        final BaseAdView a = this.a;
        final AdRequest b = this.b;
        try {
            a.a.p(b.a());
        }
        catch (final IllegalStateException ex) {
            zzbyx.zza(a.getContext()).zzd((Throwable)ex, "BaseAdView.loadAd");
        }
    }
}
