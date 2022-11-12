// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import android.content.Context;
import androidx.annotation.Keep;

@Keep
public interface AudienceNetworkAdsApi
{
    public static final int BANNER = 1;
    public static final int INTERSTITIAL = 2;
    public static final int NATIVE = 4;
    public static final int NATIVE_BANNER = 5;
    public static final int REWARDED_VIDEO = 6;
    public static final int UNKNOWN = 0;
    
    int getAdFormatForPlacement(final String p0);
    
    void initialize(final Context p0, final MultithreadedBundleWrapper p1, final AudienceNetworkAds.InitListener p2);
    
    boolean isInitialized();
    
    void onContentProviderCreated(final Context p0);
}
