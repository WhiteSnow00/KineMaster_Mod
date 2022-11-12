// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.ExtraHints;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.Ad;
import com.facebook.proguard.annotations.DoNotStripAny;
import androidx.annotation.Keep;
import com.facebook.ads.FullScreenAd;

@Keep
@DoNotStripAny
public interface RewardedVideoAdApi extends FullScreenAd
{
    default /* bridge */ LoadConfigBuilder buildLoadAdConfig() {
        return this.buildLoadAdConfig();
    }
    
    RewardedVideoAd.RewardedVideoAdLoadConfigBuilder buildLoadAdConfig();
    
    default /* bridge */ ShowConfigBuilder buildShowAdConfig() {
        return this.buildShowAdConfig();
    }
    
    RewardedVideoAd.RewardedVideoAdShowConfigBuilder buildShowAdConfig();
    
    void destroy();
    
    String getPlacementId();
    
    int getVideoDuration();
    
    boolean isAdLoaded();
    
    void loadAd();
    
    void loadAd(final RewardedVideoAd.RewardedVideoLoadAdConfig p0);
    
    void registerAdCompanionView(final AdCompanionView p0);
    
    @Deprecated
    void setExtraHints(final ExtraHints p0);
    
    boolean show();
    
    boolean show(final RewardedVideoAd.RewardedVideoShowAdConfig p0);
    
    void unregisterAdCompanionView();
}
