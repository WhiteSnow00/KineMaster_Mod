// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.bench.Benchmark;
import android.content.res.Configuration;
import android.content.Context;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.api.AdViewApi;
import androidx.annotation.Keep;
import android.widget.RelativeLayout;

@Keep
public class AdView extends RelativeLayout implements Ad
{
    private final AdViewApi mAdViewApi;
    private final AdViewParentApi mAdViewParentApi;
    
    @Benchmark
    public AdView(final Context context, final String s, final AdSize adSize) {
        super(context);
        final AdViewParentApi mAdViewParentApi = new AdViewParentApi() {
            final AdView a;
            
            @Benchmark
            @Override
            public void onConfigurationChanged(final Configuration configuration) {
                AdView.access$001(this.a, configuration);
            }
        };
        this.mAdViewParentApi = mAdViewParentApi;
        this.mAdViewApi = DynamicLoaderFactory.makeLoader(context).createAdViewApi(context, s, adSize, mAdViewParentApi, this);
    }
    
    @Benchmark
    public AdView(final Context context, final String s, final String s2) throws Exception {
        super(context);
        final AdViewParentApi mAdViewParentApi = new AdViewParentApi() {
            final AdView a;
            
            @Benchmark
            @Override
            public void onConfigurationChanged(final Configuration configuration) {
                AdView.access$001(this.a, configuration);
            }
        };
        this.mAdViewParentApi = mAdViewParentApi;
        this.mAdViewApi = DynamicLoaderFactory.makeLoader(context).createAdViewApi(context, s, s2, mAdViewParentApi, this);
    }
    
    static void access$001(final AdView adView, final Configuration configuration) {
        adView.onConfigurationChanged(configuration);
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public AdViewLoadConfigBuilder buildLoadAdConfig() {
        return this.mAdViewApi.buildLoadAdConfig();
    }
    
    public void destroy() {
        this.mAdViewApi.destroy();
    }
    
    public String getPlacementId() {
        return this.mAdViewApi.getPlacementId();
    }
    
    public boolean isAdInvalidated() {
        return this.mAdViewApi.isAdInvalidated();
    }
    
    @Benchmark
    public void loadAd() {
        this.mAdViewApi.loadAd();
    }
    
    @Benchmark
    public void loadAd(final AdViewLoadConfig adViewLoadConfig) {
        this.mAdViewApi.loadAd(adViewLoadConfig);
    }
    
    protected void onConfigurationChanged(final Configuration configuration) {
        this.mAdViewApi.onConfigurationChanged(configuration);
    }
    
    @Deprecated
    public void setExtraHints(final ExtraHints extraHints) {
        this.mAdViewApi.setExtraHints(extraHints);
    }
    
    @Keep
    public interface AdViewLoadConfig extends LoadAdConfig
    {
    }
    
    @Keep
    public interface AdViewLoadConfigBuilder extends LoadConfigBuilder
    {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        default /* bridge */ LoadAdConfig build() {
            return this.build();
        }
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        AdViewLoadConfig build();
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        AdViewLoadConfigBuilder withAdListener(final AdListener p0);
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        default /* bridge */ LoadConfigBuilder withBid(final String s) {
            return this.withBid(s);
        }
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        AdViewLoadConfigBuilder withBid(final String p0);
    }
}
