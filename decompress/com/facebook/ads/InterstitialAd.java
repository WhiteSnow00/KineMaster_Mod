// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import java.util.EnumSet;
import com.facebook.ads.internal.util.common.Preconditions;
import com.facebook.ads.internal.api.AdCompanionView;
import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import android.content.Context;
import com.facebook.ads.internal.api.InterstitialAdApi;
import androidx.annotation.Keep;

@Keep
public class InterstitialAd implements FullScreenAd
{
    private final InterstitialAdApi mInterstitialAdApi;
    
    @Benchmark
    public InterstitialAd(final Context context, final String s) {
        this.mInterstitialAdApi = DynamicLoaderFactory.makeLoader(context).createInterstitialAd(context, s, this);
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    @Override
    public /* bridge */ LoadConfigBuilder buildLoadAdConfig() {
        return this.buildLoadAdConfig();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    @Override
    public InterstitialAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mInterstitialAdApi.buildLoadAdConfig();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    @Override
    public /* bridge */ ShowConfigBuilder buildShowAdConfig() {
        return this.buildShowAdConfig();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public InterstitialAdShowConfigBuilder buildShowAdConfig() {
        return this.mInterstitialAdApi.buildShowAdConfig();
    }
    
    @Override
    public void destroy() {
        this.mInterstitialAdApi.destroy();
    }
    
    @Override
    public String getPlacementId() {
        return this.mInterstitialAdApi.getPlacementId();
    }
    
    @Override
    public boolean isAdInvalidated() {
        return this.mInterstitialAdApi.isAdInvalidated();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean isAdLoaded() {
        return this.mInterstitialAdApi.isAdLoaded();
    }
    
    @Override
    public void loadAd() {
        this.mInterstitialAdApi.loadAd();
    }
    
    public void loadAd(final InterstitialLoadAdConfig interstitialLoadAdConfig) {
        this.mInterstitialAdApi.loadAd(interstitialLoadAdConfig);
    }
    
    public void registerAdCompanionView(final AdCompanionView adCompanionView) {
        Preconditions.checkIsOnMainThread();
        this.mInterstitialAdApi.registerAdCompanionView(adCompanionView);
    }
    
    @Deprecated
    @Override
    public void setExtraHints(final ExtraHints extraHints) {
        this.mInterstitialAdApi.setExtraHints(extraHints);
    }
    
    @Benchmark
    @Override
    public boolean show() {
        return this.mInterstitialAdApi.show();
    }
    
    @Benchmark
    public boolean show(final InterstitialShowAdConfig interstitialShowAdConfig) {
        return this.mInterstitialAdApi.show(interstitialShowAdConfig);
    }
    
    public void unregisterAdCompanionView() {
        Preconditions.checkIsOnMainThread();
        this.mInterstitialAdApi.unregisterAdCompanionView();
    }
    
    @Keep
    public interface InterstitialAdLoadConfigBuilder extends LoadConfigBuilder
    {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        default /* bridge */ LoadAdConfig build() {
            return this.build();
        }
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialLoadAdConfig build();
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialAdLoadConfigBuilder withAdCompanionView(final boolean p0);
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialAdLoadConfigBuilder withAdListener(final InterstitialAdListener p0);
        
        default /* bridge */ LoadConfigBuilder withBid(final String s) {
            return this.withBid(s);
        }
        
        InterstitialAdLoadConfigBuilder withBid(final String p0);
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialAdLoadConfigBuilder withCacheFlags(final EnumSet<CacheFlag> p0);
        
        InterstitialAdLoadConfigBuilder withRewardData(final RewardData p0);
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialAdLoadConfigBuilder withRewardedAdListener(final RewardedAdListener p0);
    }
    
    @Keep
    public interface InterstitialAdShowConfigBuilder extends ShowConfigBuilder
    {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        default /* bridge */ ShowAdConfig build() {
            return this.build();
        }
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        InterstitialShowAdConfig build();
    }
    
    @Keep
    public interface InterstitialLoadAdConfig extends LoadAdConfig
    {
    }
    
    @Keep
    public interface InterstitialShowAdConfig extends ShowAdConfig
    {
    }
}
