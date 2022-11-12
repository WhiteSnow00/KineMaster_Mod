// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads.mediation.facebook;

import com.google.android.gms.ads.rewarded.RewardItem;

public class FacebookReward implements RewardItem
{
    @Override
    public int getAmount() {
        return 1;
    }
    
    @Override
    public String getType() {
        return "";
    }
}
