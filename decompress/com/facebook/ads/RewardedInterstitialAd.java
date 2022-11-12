// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import android.content.Context;
import com.facebook.ads.internal.api.RewardedInterstitialAdApi;
import androidx.annotation.Keep;

@Keep
public class RewardedInterstitialAd implements FullScreenAd
{
    public static final int UNSET_VIDEO_DURATION = -1;
    private final RewardedInterstitialAdApi mRewardedInterstitialAdApi;
    
    @Benchmark
    public RewardedInterstitialAd(final Context context, final String s) {
        this.mRewardedInterstitialAdApi = DynamicLoaderFactory.makeLoader(context).createRewardedInterstitialAd(context, s, this);
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    @Override
    public /* bridge */ LoadConfigBuilder buildLoadAdConfig() {
        return this.buildLoadAdConfig();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    @Override
    public RewardedInterstitialAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mRewardedInterstitialAdApi.buildLoadAdConfig();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    @Override
    public /* bridge */ ShowConfigBuilder buildShowAdConfig() {
        return this.buildShowAdConfig();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public RewardedInterstitialAdShowConfigBuilder buildShowAdConfig() {
        return this.mRewardedInterstitialAdApi.buildShowAdConfig();
    }
    
    @Override
    public void destroy() {
        this.mRewardedInterstitialAdApi.destroy();
    }
    
    @Override
    public String getPlacementId() {
        return this.mRewardedInterstitialAdApi.getPlacementId();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public int getVideoDuration() {
        return this.mRewardedInterstitialAdApi.getVideoDuration();
    }
    
    @Override
    public boolean isAdInvalidated() {
        return this.mRewardedInterstitialAdApi.isAdInvalidated();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean isAdLoaded() {
        return this.mRewardedInterstitialAdApi.isAdLoaded();
    }
    
    @Override
    public void loadAd() {
        this.mRewardedInterstitialAdApi.loadAd();
    }
    
    @Benchmark
    public void loadAd(final RewardedInterstitialLoadAdConfig rewardedInterstitialLoadAdConfig) {
        this.mRewardedInterstitialAdApi.loadAd(rewardedInterstitialLoadAdConfig);
    }
    
    @Deprecated
    @Override
    public void setExtraHints(final ExtraHints extraHints) {
        this.mRewardedInterstitialAdApi.setExtraHints(extraHints);
    }
    
    @Override
    public boolean show() {
        return this.mRewardedInterstitialAdApi.show();
    }
    
    @Benchmark
    public boolean show(final RewardedInterstitialShowAdConfig rewardedInterstitialShowAdConfig) {
        return this.mRewardedInterstitialAdApi.show(rewardedInterstitialShowAdConfig);
    }
    
    @Keep
    public interface RewardedInterstitialAdLoadConfigBuilder extends LoadConfigBuilder
    {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        default /* bridge */ LoadAdConfig build() {
            return this.build();
        }
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedInterstitialLoadAdConfig build();
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedInterstitialAdLoadConfigBuilder withAdListener(final RewardedInterstitialAdListener p0);
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        default /* bridge */ LoadConfigBuilder withBid(final String s) {
            return this.withBid(s);
        }
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedInterstitialAdLoadConfigBuilder withBid(final String p0);
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedInterstitialAdLoadConfigBuilder withFailOnCacheFailureEnabled(final boolean p0);
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedInterstitialAdLoadConfigBuilder withRewardData(final RewardData p0);
    }
    
    @Keep
    public interface RewardedInterstitialAdShowConfigBuilder extends ShowConfigBuilder
    {
        default /* bridge */ ShowAdConfig build() {
            return this.build();
        }
        
        RewardedInterstitialShowAdConfig build();
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedInterstitialAdShowConfigBuilder withAppOrientation(final int p0);
    }
    
    @Keep
    public interface RewardedInterstitialLoadAdConfig extends LoadAdConfig
    {
    }
    
    @Keep
    public interface RewardedInterstitialShowAdConfig extends ShowAdConfig
    {
    }
}
