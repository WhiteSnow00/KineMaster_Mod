// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.Keep;

@Keep
public class AdSDKNotificationManager
{
    private static final List<AdSDKNotificationListener> sNotificationListeners;
    
    static {
        sNotificationListeners = Collections.synchronizedList(new ArrayList<AdSDKNotificationListener>());
    }
    
    public static void addSDKNotificationListener(final AdSDKNotificationListener adSDKNotificationListener) {
        final List<AdSDKNotificationListener> sNotificationListeners = AdSDKNotificationManager.sNotificationListeners;
        synchronized (sNotificationListeners) {
            sNotificationListeners.add(adSDKNotificationListener);
        }
    }
    
    public static List<AdSDKNotificationListener> getNotificationListeners() {
        return AdSDKNotificationManager.sNotificationListeners;
    }
    
    public static void removeSDKNotificationListener(final AdSDKNotificationListener adSDKNotificationListener) {
        final List<AdSDKNotificationListener> sNotificationListeners = AdSDKNotificationManager.sNotificationListeners;
        synchronized (sNotificationListeners) {
            sNotificationListeners.remove(adSDKNotificationListener);
        }
    }
}
