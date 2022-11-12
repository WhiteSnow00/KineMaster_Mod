// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.BuildConfig;
import android.content.Context;
import androidx.annotation.Keep;

@Keep
public class BuildConfigApi
{
    static final String UNITY_SHARED_PREFERENCES_SUFIX = ".v2.playerprefs";
    static final String UNITY_TAG = "an_isUnitySDK";
    static final String UNITY_VERSION_SUFIX = "-unity";
    
    public static String getVersionName(final Context context) {
        if (isUnity(context)) {
            final StringBuilder sb = new StringBuilder();
            sb.append(BuildConfig.VERSION_NAME);
            sb.append("-unity");
            return sb.toString();
        }
        return BuildConfig.VERSION_NAME;
    }
    
    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }
    
    private static boolean isUnity(final Context context) {
        final StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".v2.playerprefs");
        final String string = sb.toString();
        boolean b = false;
        if (context.getSharedPreferences(string, 0).contains("an_isUnitySDK") || context.getSharedPreferences(context.getPackageName(), 0).contains("an_isUnitySDK")) {
            b = true;
        }
        return b;
    }
}
