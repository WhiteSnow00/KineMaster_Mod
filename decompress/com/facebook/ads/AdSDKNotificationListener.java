// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import android.os.Bundle;
import androidx.annotation.Keep;

@Keep
public interface AdSDKNotificationListener
{
    public static final String ENCRYPTED_CPM_KEY = "encrypted_cpm";
    public static final String IMPRESSION_EVENT = "impression";
    
    void onAdEvent(final String p0, final Bundle p1);
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface SDKEventKey {
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface SDKEventType {
    }
}
