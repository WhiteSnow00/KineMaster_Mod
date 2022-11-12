// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import com.facebook.ads.internal.bench.Benchmark;
import androidx.annotation.Keep;

@Keep
public interface Ad
{
    @Benchmark
    void destroy();
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    String getPlacementId();
    
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    boolean isAdInvalidated();
    
    @Benchmark
    void loadAd();
    
    @Deprecated
    @Benchmark(failAtMillis = 5, warnAtMillis = 1)
    void setExtraHints(final ExtraHints p0);
    
    @Keep
    public interface LoadAdConfig
    {
    }
    
    @Keep
    public interface LoadConfigBuilder
    {
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        LoadAdConfig build();
        
        @Benchmark(failAtMillis = 5, warnAtMillis = 1)
        LoadConfigBuilder withBid(final String p0);
    }
}
