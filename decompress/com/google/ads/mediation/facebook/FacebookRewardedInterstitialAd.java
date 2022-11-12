// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads.mediation.facebook;

import com.facebook.ads.AdExperienceType;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;

public class FacebookRewardedInterstitialAd extends FacebookRewardedAd
{
    public FacebookRewardedInterstitialAd(final MediationRewardedAdConfiguration mediationRewardedAdConfiguration, final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        super(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }
    
    @Override
    AdExperienceType e() {
        return AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED_INTERSTITIAL;
    }
}
