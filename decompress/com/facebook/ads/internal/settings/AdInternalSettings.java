// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.settings;

import com.facebook.ads.internal.dynamicloading.DynamicLoader;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import androidx.annotation.Keep;

@Keep
public class AdInternalSettings
{
    private static final String BOOL_AUTOPLAY_ON_MOBILE_KEY = "BOOL_AUTOPLAY_ON_MOBILE_KEY";
    private static final String BOOL_DEBUGGER_STATE_KEY = "BOOL_DEBUGGER_STATE_KEY";
    private static final String BOOL_DEBUG_BUILD_KEY = "BOOL_DEBUG_BUILD_KEY";
    private static final String BOOL_EXPLICIT_TEST_MODE_KEY = "BOOL_EXPLICIT_TEST_MODE_KEY";
    public static final String BOOL_MIXED_AUDIENCE_KEY = "BOOL_MIXED_AUDIENCE_KEY";
    private static final String BOOL_VIDEO_AUTOPLAY_KEY = "BOOL_VIDEO_AUTOPLAY_KEY";
    private static final String BOOL_VISIBLE_ANIMATION_KEY = "BOOL_VISIBLE_ANIMATION_KEY";
    public static final String DATA_PROCESSING_OPTIONS_COUNTRY_KEY = "DATA_PROCESSING_OPTIONS_COUNTRY_KEY";
    public static final String DATA_PROCESSING_OPTIONS_KEY = "DATA_PROCESSING_OPTIONS_KEY";
    public static final String DATA_PROCESSING_OPTIONS_STATE_KEY = "DATA_PROCESSING_OPTIONS_STATE_KEY";
    private static final String LIST_TEST_DEVICES_KEY = "LIST_TEST_DEVICES_KEY";
    public static final String SRL_INTEGRATION_ERROR_MODE_KEY = "SRL_INTEGRATION_ERROR_MODE_KEY";
    private static final String STR_MEDIATION_SERVICE_KEY = "STR_MEDIATION_SERVICE_KEY";
    private static final String STR_URL_PREFIX_KEY = "STR_URL_PREFIX_KEY";
    public static final String TEST_AD_TYPE_KEY = "TEST_AD_TYPE_KEY";
    public static final AtomicBoolean sDataProcessingOptionsUpdate;
    public static final MultithreadedBundleWrapper sSettingsBundle;
    
    static {
        sSettingsBundle = new MultithreadedBundleWrapper();
        sDataProcessingOptionsUpdate = new AtomicBoolean(false);
    }
    
    public static void addTestDevice(final String s) {
        getTestDevicesList().add(s);
    }
    
    public static void addTestDevices(final Collection<String> collection) {
        getTestDevicesList().addAll(collection);
    }
    
    public static void clearTestDevices() {
        getTestDevicesList().clear();
    }
    
    public static String getMediationService() {
        return AdInternalSettings.sSettingsBundle.getString("STR_MEDIATION_SERVICE_KEY", null);
    }
    
    public static ArrayList<String> getTestDevicesList() {
        final MultithreadedBundleWrapper sSettingsBundle = AdInternalSettings.sSettingsBundle;
        ArrayList<String> stringArrayList;
        if ((stringArrayList = sSettingsBundle.getStringArrayList("LIST_TEST_DEVICES_KEY")) == null) {
            stringArrayList = new ArrayList<String>();
            sSettingsBundle.putStringArrayList("LIST_TEST_DEVICES_KEY", stringArrayList);
        }
        return stringArrayList;
    }
    
    public static String getUrlPrefix() {
        return AdInternalSettings.sSettingsBundle.getString("STR_URL_PREFIX_KEY", null);
    }
    
    public static boolean isDebugBuild() {
        return AdInternalSettings.sSettingsBundle.getBoolean("BOOL_DEBUG_BUILD_KEY", false);
    }
    
    public static boolean isDebuggerOn() {
        return AdInternalSettings.sSettingsBundle.getBoolean("BOOL_DEBUGGER_STATE_KEY", false);
    }
    
    public static boolean isExplicitTestMode() {
        return AdInternalSettings.sSettingsBundle.getBoolean("BOOL_EXPLICIT_TEST_MODE_KEY", false);
    }
    
    public static boolean isTestMode(final Context context) {
        return DynamicLoaderFactory.makeLoader(context).createAdSettingsApi().isTestMode(context);
    }
    
    public static boolean isVideoAutoplay() {
        return AdInternalSettings.sSettingsBundle.getBoolean("BOOL_VIDEO_AUTOPLAY_KEY");
    }
    
    public static boolean isVideoAutoplayOnMobile() {
        return AdInternalSettings.sSettingsBundle.getBoolean("BOOL_AUTOPLAY_ON_MOBILE_KEY", false);
    }
    
    public static boolean isVisibleAnimation() {
        return AdInternalSettings.sSettingsBundle.getBoolean("BOOL_VISIBLE_ANIMATION_KEY", false);
    }
    
    public static void setDataProcessingOptions(final String[] array, final Integer n, final Integer n2) {
        final MultithreadedBundleWrapper sSettingsBundle = AdInternalSettings.sSettingsBundle;
        synchronized (sSettingsBundle) {
            AdInternalSettings.sDataProcessingOptionsUpdate.set(true);
            sSettingsBundle.putStringArray("DATA_PROCESSING_OPTIONS_KEY", array);
            sSettingsBundle.putInteger("DATA_PROCESSING_OPTIONS_COUNTRY_KEY", n);
            sSettingsBundle.putInteger("DATA_PROCESSING_OPTIONS_STATE_KEY", n2);
        }
    }
    
    public static void setDebugBuild(final boolean b) {
        final DynamicLoader dynamicLoader = DynamicLoaderFactory.getDynamicLoader();
        if (dynamicLoader != null && b) {
            dynamicLoader.createAdSettingsApi().turnOnDebugger();
        }
        AdInternalSettings.sSettingsBundle.putBoolean("BOOL_DEBUG_BUILD_KEY", b);
    }
    
    public static void setMediationService(final String s) {
        AdInternalSettings.sSettingsBundle.putString("STR_MEDIATION_SERVICE_KEY", s);
    }
    
    public static void setTestMode(final boolean b) {
        AdInternalSettings.sSettingsBundle.putBoolean("BOOL_EXPLICIT_TEST_MODE_KEY", b);
    }
    
    public static void setUrlPrefix(final String s) {
        AdInternalSettings.sSettingsBundle.putString("STR_URL_PREFIX_KEY", s);
    }
    
    public static void setVideoAutoplay(final boolean b) {
        AdInternalSettings.sSettingsBundle.putBoolean("BOOL_VIDEO_AUTOPLAY_KEY", b);
    }
    
    public static void setVideoAutoplayOnMobile(final boolean b) {
        AdInternalSettings.sSettingsBundle.putBoolean("BOOL_AUTOPLAY_ON_MOBILE_KEY", b);
    }
    
    public static void setVisibleAnimation(final boolean b) {
        AdInternalSettings.sSettingsBundle.putBoolean("BOOL_VISIBLE_ANIMATION_KEY", b);
    }
    
    public static void turnOnSDKDebugger(final Context context) {
        final DynamicLoader dynamicLoader = DynamicLoaderFactory.getDynamicLoader();
        if (dynamicLoader != null) {
            dynamicLoader.createAdSettingsApi().turnOnDebugger();
        }
        else {
            AdInternalSettings.sSettingsBundle.putBoolean("BOOL_DEBUGGER_STATE_KEY", true);
        }
    }
}
