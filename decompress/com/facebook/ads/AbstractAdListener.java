// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import androidx.annotation.Keep;

@Keep
public class AbstractAdListener implements InterstitialAdExtendedListener, RewardedVideoAdExtendedListener, RewardedInterstitialAdExtendedListener
{
    @Override
    public void onAdClicked(final Ad ad) {
    }
    
    @Override
    public void onAdLoaded(final Ad ad) {
    }
    
    @Override
    public void onError(final Ad ad, final AdError adError) {
    }
    
    @Override
    public void onInterstitialActivityDestroyed() {
    }
    
    @Override
    public void onInterstitialDismissed(final Ad ad) {
    }
    
    @Override
    public void onInterstitialDisplayed(final Ad ad) {
    }
    
    @Override
    public void onLoggingImpression(final Ad ad) {
    }
    
    @Override
    public void onRewardedAdCompleted() {
    }
    
    @Override
    public void onRewardedAdServerFailed() {
    }
    
    @Override
    public void onRewardedAdServerSucceeded() {
    }
    
    @Override
    public void onRewardedInterstitialActivityDestroyed() {
    }
    
    @Override
    public void onRewardedInterstitialClosed() {
    }
    
    @Override
    public void onRewardedInterstitialCompleted() {
    }
    
    @Override
    public void onRewardedVideoActivityDestroyed() {
    }
    
    @Override
    public void onRewardedVideoClosed() {
    }
    
    @Override
    public void onRewardedVideoCompleted() {
    }
}
