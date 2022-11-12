// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.AdError;

public interface MediationRewardedAdCallback extends MediationAdCallback
{
    void onAdFailedToShow(final AdError p0);
    
    void onUserEarnedReward(final RewardItem p0);
    
    void onVideoComplete();
    
    void onVideoStart();
}
