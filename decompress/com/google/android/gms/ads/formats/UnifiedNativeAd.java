// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.MediaContent;
import java.util.List;
import android.os.Bundle;

@Deprecated
public abstract class UnifiedNativeAd
{
    public abstract void cancelUnconfirmedClick();
    
    public abstract void destroy();
    
    public abstract void enableCustomClickGesture();
    
    public abstract NativeAd.AdChoicesInfo getAdChoicesInfo();
    
    public abstract String getAdvertiser();
    
    public abstract String getBody();
    
    public abstract String getCallToAction();
    
    public abstract Bundle getExtras();
    
    public abstract String getHeadline();
    
    public abstract NativeAd.Image getIcon();
    
    public abstract List<NativeAd.Image> getImages();
    
    public abstract MediaContent getMediaContent();
    
    @Deprecated
    public abstract String getMediationAdapterClassName();
    
    public abstract List<MuteThisAdReason> getMuteThisAdReasons();
    
    public abstract String getPrice();
    
    public abstract ResponseInfo getResponseInfo();
    
    public abstract Double getStarRating();
    
    public abstract String getStore();
    
    @Deprecated
    public abstract VideoController getVideoController();
    
    public abstract boolean isCustomClickGestureEnabled();
    
    public abstract boolean isCustomMuteThisAdEnabled();
    
    public abstract void muteThisAd(final MuteThisAdReason p0);
    
    @KeepForSdk
    public abstract void performClick(final Bundle p0);
    
    public abstract void recordCustomClickGesture();
    
    @KeepForSdk
    public abstract boolean recordImpression(final Bundle p0);
    
    @KeepForSdk
    public abstract void reportTouchEvent(final Bundle p0);
    
    public abstract void setMuteThisAdListener(final MuteThisAdListener p0);
    
    public abstract void setOnPaidEventListener(final OnPaidEventListener p0);
    
    public abstract void setUnconfirmedClickListener(final UnconfirmedClickListener p0);
    
    public abstract Object zza();
    
    @Deprecated
    public interface OnUnifiedNativeAdLoadedListener
    {
        void c(final UnifiedNativeAd p0);
    }
    
    @Deprecated
    public interface UnconfirmedClickListener
    {
        void a(final String p0);
        
        void b();
    }
}
