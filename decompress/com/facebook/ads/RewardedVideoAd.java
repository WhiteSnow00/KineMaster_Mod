// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import com.facebook.ads.internal.util.common.Preconditions;
import com.facebook.ads.internal.api.AdCompanionView;
import com.facebook.ads.internal.bench.Benchmark;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import android.content.Context;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import androidx.annotation.Keep;

@Keep
public class RewardedVideoAd implements FullScreenAd
{
    public static final int UNSET_VIDEO_DURATION = -1;
    private final RewardedVideoAdApi mRewardedVideoAdApi;
    
    @Benchmark
    public RewardedVideoAd(final Context context, final String s) {
        this.mRewardedVideoAdApi = DynamicLoaderFactory.makeLoader(context).createRewardedVideoAd(context, s, this);
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    @Override
    public /* bridge */ LoadConfigBuilder buildLoadAdConfig() {
        return this.buildLoadAdConfig();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    @Override
    public RewardedVideoAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mRewardedVideoAdApi.buildLoadAdConfig();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    @Override
    public /* bridge */ ShowConfigBuilder buildShowAdConfig() {
        return this.buildShowAdConfig();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public RewardedVideoAdShowConfigBuilder buildShowAdConfig() {
        return this.mRewardedVideoAdApi.buildShowAdConfig();
    }
    
    @Override
    public void destroy() {
        this.mRewardedVideoAdApi.destroy();
    }
    
    @Override
    public String getPlacementId() {
        return this.mRewardedVideoAdApi.getPlacementId();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public int getVideoDuration() {
        return this.mRewardedVideoAdApi.getVideoDuration();
    }
    
    @Override
    public boolean isAdInvalidated() {
        return this.mRewardedVideoAdApi.isAdInvalidated();
    }
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    public boolean isAdLoaded() {
        return this.mRewardedVideoAdApi.isAdLoaded();
    }
    
    @Override
    public void loadAd() {
        this.mRewardedVideoAdApi.loadAd();
    }
    
    @Benchmark
    public void loadAd(final RewardedVideoLoadAdConfig rewardedVideoLoadAdConfig) {
        this.mRewardedVideoAdApi.loadAd(rewardedVideoLoadAdConfig);
    }
    
    public void registerAdCompanionView(final AdCompanionView adCompanionView) {
        Preconditions.checkIsOnMainThread();
        this.mRewardedVideoAdApi.registerAdCompanionView(adCompanionView);
    }
    
    @Deprecated
    @Override
    public void setExtraHints(final ExtraHints extraHints) {
        this.mRewardedVideoAdApi.setExtraHints(extraHints);
    }
    
    @Override
    public boolean show() {
        return this.mRewardedVideoAdApi.show();
    }
    
    @Benchmark
    public boolean show(final RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        return this.mRewardedVideoAdApi.show(rewardedVideoShowAdConfig);
    }
    
    public void unregisterAdCompanionView() {
        Preconditions.checkIsOnMainThread();
        this.mRewardedVideoAdApi.unregisterAdCompanionView();
    }
    
    @Keep
    public interface RewardedVideoAdLoadConfigBuilder extends LoadConfigBuilder
    {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        default /* bridge */ LoadAdConfig build() {
            return this.build();
        }
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoLoadAdConfig build();
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withAdCompanionView(final boolean p0);
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withAdExperience(final AdExperienceType p0);
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withAdListener(final RewardedVideoAdListener p0);
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        default /* bridge */ LoadConfigBuilder withBid(final String s) {
            return this.withBid(s);
        }
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withBid(final String p0);
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withFailOnCacheFailureEnabled(final boolean p0);
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdLoadConfigBuilder withRewardData(final RewardData p0);
    }
    
    @Keep
    public interface RewardedVideoAdShowConfigBuilder extends ShowConfigBuilder
    {
        default /* bridge */ ShowAdConfig build() {
            return this.build();
        }
        
        RewardedVideoShowAdConfig build();
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        RewardedVideoAdShowConfigBuilder withAppOrientation(final int p0);
    }
    
    @Keep
    public interface RewardedVideoLoadAdConfig extends LoadAdConfig
    {
    }
    
    @Keep
    public interface RewardedVideoShowAdConfig extends ShowAdConfig
    {
    }
}
