// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.admanager;

import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzbs;
import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.common.internal.Preconditions;
import android.content.Context;
import com.google.android.gms.ads.BaseAdView;

public final class AdManagerAdView extends BaseAdView
{
    public AdManagerAdView(final Context context) {
        super(context, 0);
        Preconditions.l(context, "Context cannot be null");
    }
    
    final void e(final AdManagerAdRequest adManagerAdRequest) {
        try {
            super.a.p(adManagerAdRequest.a());
        }
        catch (final IllegalStateException ex) {
            zzbyx.zza(this.getContext()).zzd((Throwable)ex, "AdManagerAdView.loadAd");
        }
    }
    
    public final boolean f(final zzbs zzbs) {
        return super.a.B(zzbs);
    }
    
    public AdSize[] getAdSizes() {
        return super.a.a();
    }
    
    public AppEventListener getAppEventListener() {
        return super.a.k();
    }
    
    public VideoController getVideoController() {
        return super.a.i();
    }
    
    public VideoOptions getVideoOptions() {
        return super.a.j();
    }
    
    public void setAdSizes(final AdSize... array) {
        if (array != null && array.length > 0) {
            super.a.v(array);
            return;
        }
        throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
    }
    
    public void setAppEventListener(final AppEventListener appEventListener) {
        super.a.x(appEventListener);
    }
    
    public void setManualImpressionsEnabled(final boolean b) {
        super.a.y(b);
    }
    
    public void setVideoOptions(final VideoOptions videoOptions) {
        super.a.A(videoOptions);
    }
}
