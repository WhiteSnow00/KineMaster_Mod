// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.nativead;

import android.net.Uri;
import android.graphics.drawable.Drawable;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.MediaContent;
import java.util.List;
import android.os.Bundle;

public abstract class NativeAd
{
    public abstract void cancelUnconfirmedClick();
    
    public abstract void destroy();
    
    public abstract void enableCustomClickGesture();
    
    public abstract AdChoicesInfo getAdChoicesInfo();
    
    public abstract String getAdvertiser();
    
    public abstract String getBody();
    
    public abstract String getCallToAction();
    
    public abstract Bundle getExtras();
    
    public abstract String getHeadline();
    
    public abstract Image getIcon();
    
    public abstract List<Image> getImages();
    
    public abstract MediaContent getMediaContent();
    
    public abstract List<MuteThisAdReason> getMuteThisAdReasons();
    
    public abstract String getPrice();
    
    public abstract ResponseInfo getResponseInfo();
    
    public abstract Double getStarRating();
    
    public abstract String getStore();
    
    public abstract boolean isCustomClickGestureEnabled();
    
    public abstract boolean isCustomMuteThisAdEnabled();
    
    public abstract void muteThisAd(final MuteThisAdReason p0);
    
    public abstract void performClick(final Bundle p0);
    
    public abstract void recordCustomClickGesture();
    
    public abstract boolean recordImpression(final Bundle p0);
    
    public abstract void reportTouchEvent(final Bundle p0);
    
    public abstract void setMuteThisAdListener(final MuteThisAdListener p0);
    
    public abstract void setOnPaidEventListener(final OnPaidEventListener p0);
    
    public abstract void setUnconfirmedClickListener(final UnconfirmedClickListener p0);
    
    protected abstract Object zza();
    
    public abstract static class AdChoicesInfo
    {
        public abstract List<Image> getImages();
        
        public abstract CharSequence getText();
    }
    
    public abstract static class Image
    {
        public abstract Drawable getDrawable();
        
        public abstract double getScale();
        
        public abstract Uri getUri();
    }
    
    public interface OnNativeAdLoadedListener
    {
        void a(final NativeAd p0);
    }
    
    public interface UnconfirmedClickListener
    {
        void a(final String p0);
        
        void b();
    }
}
