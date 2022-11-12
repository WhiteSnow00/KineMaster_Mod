// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import android.content.Context;
import androidx.annotation.Keep;
import com.facebook.ads.AudienceNetworkAds;

@Keep
public class InitSettingsBuilder implements AudienceNetworkAds.InitSettingsBuilder
{
    public static final String PLACEMENTS_KEY = "PLACEMENTS_KEY";
    private final Context mContext;
    private final MultithreadedBundleWrapper mInitSettings;
    private InitListener mInitializationListener;
    
    public InitSettingsBuilder(final Context mContext) {
        this.mInitSettings = new MultithreadedBundleWrapper();
        this.mContext = mContext;
    }
    
    @Override
    public void initialize() {
        DynamicLoaderFactory.initialize(this.mContext, this.mInitSettings, this.mInitializationListener, false);
    }
    
    @Override
    public /* bridge */ AudienceNetworkAds.InitSettingsBuilder withInitListener(final InitListener initListener) {
        return this.withInitListener(initListener);
    }
    
    public InitSettingsBuilder withInitListener(final InitListener mInitializationListener) {
        this.mInitializationListener = mInitializationListener;
        return this;
    }
    
    @Override
    public /* bridge */ AudienceNetworkAds.InitSettingsBuilder withMediationService(final String s) {
        return this.withMediationService(s);
    }
    
    public InitSettingsBuilder withMediationService(final String mediationService) {
        AdSettings.setMediationService(mediationService);
        return this;
    }
    
    @Override
    public /* bridge */ AudienceNetworkAds.InitSettingsBuilder withPlacementIds(final List list) {
        return this.withPlacementIds((List<String>)list);
    }
    
    public InitSettingsBuilder withPlacementIds(final List<String> list) {
        this.mInitSettings.putStringArrayList("PLACEMENTS_KEY", new ArrayList<String>(list));
        return this;
    }
}
