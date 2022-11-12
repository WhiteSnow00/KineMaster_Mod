// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads.mediation;

import com.google.android.gms.ads.formats.zze;
import com.google.android.gms.ads.formats.zzg;
import java.util.Map;
import android.view.View;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

final class a extends UnifiedNativeAdMapper
{
    private final UnifiedNativeAd s;
    
    public a(final UnifiedNativeAd s) {
        this.s = s;
        this.z(s.getHeadline());
        this.B(s.getImages());
        this.v(s.getBody());
        this.A(s.getIcon());
        this.w(s.getCallToAction());
        this.u(s.getAdvertiser());
        this.G(s.getStarRating());
        this.H(s.getStore());
        this.F(s.getPrice());
        this.N(s.zza());
        this.E(true);
        this.D(true);
        this.O(s.getVideoController());
    }
    
    @Override
    public final void I(final View view, final Map<String, View> map, final Map<String, View> map2) {
        if (view instanceof zzg) {
            final zzg zzg = (zzg)view;
            throw null;
        }
        if (zze.a.get(view) == null) {
            return;
        }
        throw null;
    }
}
