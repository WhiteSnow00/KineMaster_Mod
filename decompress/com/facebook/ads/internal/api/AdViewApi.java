// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.ExtraHints;
import android.content.res.Configuration;
import com.facebook.ads.AdView;
import com.facebook.proguard.annotations.DoNotStripAny;
import androidx.annotation.Keep;
import com.facebook.ads.Ad;

@Keep
@DoNotStripAny
public interface AdViewApi extends AdViewParentApi, Ad
{
    AdView.AdViewLoadConfigBuilder buildLoadAdConfig();
    
    void loadAd(final AdView.AdViewLoadConfig p0);
    
    void onConfigurationChanged(final Configuration p0);
    
    @Deprecated
    void setExtraHints(final ExtraHints p0);
}
