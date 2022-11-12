// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.ExtraHints;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.Ad;
import com.facebook.proguard.annotations.DoNotStripAny;
import androidx.annotation.Keep;
import com.facebook.ads.FullScreenAd;

@Keep
@DoNotStripAny
public interface InterstitialAdApi extends FullScreenAd
{
    default /* bridge */ LoadConfigBuilder buildLoadAdConfig() {
        return this.buildLoadAdConfig();
    }
    
    InterstitialAd.InterstitialAdLoadConfigBuilder buildLoadAdConfig();
    
    default /* bridge */ ShowConfigBuilder buildShowAdConfig() {
        return this.buildShowAdConfig();
    }
    
    InterstitialAd.InterstitialAdShowConfigBuilder buildShowAdConfig();
    
    boolean isAdLoaded();
    
    void loadAd(final InterstitialAd.InterstitialLoadAdConfig p0);
    
    void registerAdCompanionView(final AdCompanionView p0);
    
    @Deprecated
    void setExtraHints(final ExtraHints p0);
    
    boolean show();
    
    boolean show(final InterstitialAd.InterstitialShowAdConfig p0);
    
    void unregisterAdCompanionView();
}
