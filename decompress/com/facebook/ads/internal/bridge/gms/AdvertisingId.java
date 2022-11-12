// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.bridge.gms;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import android.content.Context;
import androidx.annotation.Keep;

@Keep
public class AdvertisingId
{
    private final String mId;
    private final boolean mLimitAdTracking;
    
    public AdvertisingId(final String mId, final boolean mLimitAdTracking) {
        this.mId = mId;
        this.mLimitAdTracking = mLimitAdTracking;
    }
    
    public static AdvertisingId getAdvertisingIdInfoDirectly(final Context context) {
        try {
            final AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo != null) {
                return new AdvertisingId(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
            }
            return null;
        }
        finally {
            return null;
        }
    }
    
    public String getId() {
        return this.mId;
    }
    
    public boolean isLimitAdTracking() {
        return this.mLimitAdTracking;
    }
}
