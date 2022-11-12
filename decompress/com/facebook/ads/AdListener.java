// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import com.facebook.ads.internal.bench.Benchmark;
import androidx.annotation.Keep;

@Keep
public interface AdListener
{
    @Benchmark
    void onAdClicked(final Ad p0);
    
    @Benchmark
    void onAdLoaded(final Ad p0);
    
    @Benchmark
    void onError(final Ad p0, final AdError p1);
    
    @Benchmark
    void onLoggingImpression(final Ad p0);
}
