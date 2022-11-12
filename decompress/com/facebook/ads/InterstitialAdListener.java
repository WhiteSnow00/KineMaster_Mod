// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
public interface InterstitialAdListener extends AdListener
{
    void onInterstitialDismissed(final Ad p0);
    
    void onInterstitialDisplayed(final Ad p0);
}
