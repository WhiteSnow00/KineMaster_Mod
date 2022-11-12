// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.NativeAdLayout;
import androidx.annotation.Keep;

@Keep
public interface NativeAdLayoutApi extends AdComponentViewApiProvider
{
    void initialize(final NativeAdLayout p0);
    
    void setMaxWidth(final int p0);
    
    void setMinWidth(final int p0);
}
