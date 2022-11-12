// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.util.common;

import android.os.Bundle;
import android.app.Application;
import android.content.Context;
import java.util.Collections;
import java.util.WeakHashMap;
import android.app.Activity;
import java.util.Map;
import androidx.annotation.Keep;
import android.app.Application$ActivityLifecycleCallbacks;

@Keep
public class ANActivityLifecycleCallbacksListener implements Application$ActivityLifecycleCallbacks
{
    public static final int ACTIVITY_CREATED = 1;
    public static final int ACTIVITY_DESTROYED = 6;
    public static final int ACTIVITY_PAUSED = 4;
    public static final int ACTIVITY_RESUMED = 3;
    public static final int ACTIVITY_STARTED = 2;
    public static final int ACTIVITY_STOPPED = 5;
    private static ANActivityLifecycleCallbacksListener sANActivityLifecycleCallbacksListener;
    private static final Map<Activity, Integer> sActivityStateMap;
    
    static {
        sActivityStateMap = Collections.synchronizedMap(new WeakHashMap<Activity, Integer>());
    }
    
    public static ANActivityLifecycleCallbacksListener getANActivityLifecycleCallbacksListener() {
        synchronized (ANActivityLifecycleCallbacksListener.class) {
            return ANActivityLifecycleCallbacksListener.sANActivityLifecycleCallbacksListener;
        }
    }
    
    public static void registerActivityCallbacks(final Context context) {
        final Context applicationContext = context.getApplicationContext();
        synchronized (ANActivityLifecycleCallbacksListener.class) {
            if (applicationContext instanceof Application && ANActivityLifecycleCallbacksListener.sANActivityLifecycleCallbacksListener == null) {
                ((Application)applicationContext).registerActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)(ANActivityLifecycleCallbacksListener.sANActivityLifecycleCallbacksListener = new ANActivityLifecycleCallbacksListener()));
            }
        }
    }
    
    public static void unregisterActivityCallbacks(Context applicationContext) {
        applicationContext = applicationContext.getApplicationContext();
        synchronized (ANActivityLifecycleCallbacksListener.class) {
            if (applicationContext instanceof Application) {
                ((Application)applicationContext).unregisterActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)ANActivityLifecycleCallbacksListener.sANActivityLifecycleCallbacksListener);
                ANActivityLifecycleCallbacksListener.sANActivityLifecycleCallbacksListener = null;
            }
        }
    }
    
    public Map<Activity, Integer> getActivityStateMap() {
        return ANActivityLifecycleCallbacksListener.sActivityStateMap;
    }
    
    public void onActivityCreated(final Activity activity, final Bundle bundle) {
        ANActivityLifecycleCallbacksListener.sActivityStateMap.put(activity, 1);
    }
    
    public void onActivityDestroyed(final Activity activity) {
        ANActivityLifecycleCallbacksListener.sActivityStateMap.put(activity, 6);
    }
    
    public void onActivityPaused(final Activity activity) {
        ANActivityLifecycleCallbacksListener.sActivityStateMap.put(activity, 4);
    }
    
    public void onActivityResumed(final Activity activity) {
        ANActivityLifecycleCallbacksListener.sActivityStateMap.put(activity, 3);
    }
    
    public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
    }
    
    public void onActivityStarted(final Activity activity) {
        ANActivityLifecycleCallbacksListener.sActivityStateMap.put(activity, 2);
    }
    
    public void onActivityStopped(final Activity activity) {
        ANActivityLifecycleCallbacksListener.sActivityStateMap.put(activity, 5);
    }
}
