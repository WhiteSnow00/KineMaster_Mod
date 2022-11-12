// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import java.util.List;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.internal.util.common.Preconditions;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.api.InitSettingsBuilder;
import android.content.Context;
import androidx.annotation.Keep;

@Keep
public final class AudienceNetworkAds
{
    public static final String TAG = "FBAudienceNetwork";
    
    private AudienceNetworkAds() {
    }
    
    public static InitSettingsBuilder buildInitSettings(final Context context) {
        return (InitSettingsBuilder)new com.facebook.ads.internal.api.InitSettingsBuilder(context);
    }
    
    public static int getAdFormatForPlacement(final Context context, final String s) {
        return DynamicLoaderFactory.makeLoader(context).createAudienceNetworkAdsApi().getAdFormatForPlacement(s);
    }
    
    public static void initialize(final Context context) {
        Preconditions.checkNotNull(context, "Context can not be null.");
        DynamicLoaderFactory.initialize(context, null, null, false);
    }
    
    public static boolean isInitialized(final Context context) {
        return DynamicLoaderFactory.getDynamicLoader() != null && DynamicLoaderFactory.makeLoader(context).createAudienceNetworkAdsApi().isInitialized();
    }
    
    @Retention(RetentionPolicy.SOURCE)
    @Keep
    public @interface AdFormat {
        public static final int BANNER = 1;
        public static final int INTERSTITIAL = 2;
        public static final int NATIVE = 4;
        public static final int NATIVE_BANNER = 5;
        public static final int REWARDED_VIDEO = 6;
        public static final int UNKNOWN = 0;
    }
    
    @Keep
    public interface InitListener
    {
        void onInitialized(final InitResult p0);
    }
    
    @Keep
    public interface InitResult
    {
        String getMessage();
        
        boolean isSuccess();
    }
    
    @Keep
    public interface InitSettingsBuilder
    {
        void initialize();
        
        InitSettingsBuilder withInitListener(final InitListener p0);
        
        InitSettingsBuilder withMediationService(final String p0);
        
        InitSettingsBuilder withPlacementIds(final List<String> p0);
    }
}
