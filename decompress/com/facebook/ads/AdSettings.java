// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import android.content.Context;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import java.io.Serializable;
import java.util.Collection;
import com.facebook.ads.internal.settings.AdInternalSettings;
import androidx.annotation.Keep;

@Keep
public class AdSettings
{
    public static final boolean DEBUG = false;
    
    public static void addTestDevice(final String s) {
        AdInternalSettings.addTestDevice(s);
    }
    
    public static void addTestDevices(final Collection<String> collection) {
        AdInternalSettings.addTestDevices(collection);
    }
    
    public static void clearTestDevices() {
        AdInternalSettings.clearTestDevices();
    }
    
    public static String getMediationService() {
        return AdInternalSettings.getMediationService();
    }
    
    public static TestAdType getTestAdType() {
        final MultithreadedBundleWrapper sSettingsBundle = AdInternalSettings.sSettingsBundle;
        final Serializable serializable = sSettingsBundle.getSerializable("TEST_AD_TYPE_KEY");
        if (serializable != null && serializable instanceof TestAdType) {
            return (TestAdType)serializable;
        }
        final TestAdType default1 = TestAdType.DEFAULT;
        sSettingsBundle.putSerializable("TEST_AD_TYPE_KEY", default1);
        return default1;
    }
    
    public static String getUrlPrefix() {
        return AdInternalSettings.getUrlPrefix();
    }
    
    public static boolean isMixedAudience() {
        return AdInternalSettings.sSettingsBundle.getBoolean("BOOL_MIXED_AUDIENCE_KEY", false);
    }
    
    public static boolean isTestMode(final Context context) {
        return AdInternalSettings.isTestMode(context);
    }
    
    public static boolean isVideoAutoplay() {
        return AdInternalSettings.isVideoAutoplay();
    }
    
    public static boolean isVideoAutoplayOnMobile() {
        return AdInternalSettings.isVideoAutoplayOnMobile();
    }
    
    public static void setDataProcessingOptions(final String[] array) {
        AdInternalSettings.setDataProcessingOptions(array, null, null);
    }
    
    public static void setDataProcessingOptions(final String[] array, final int n, final int n2) {
        AdInternalSettings.setDataProcessingOptions(array, n, n2);
    }
    
    public static void setDebugBuild(final boolean debugBuild) {
        AdInternalSettings.setDebugBuild(debugBuild);
    }
    
    public static void setIntegrationErrorMode(final IntegrationErrorMode integrationErrorMode) {
        AdInternalSettings.sSettingsBundle.putSerializable("SRL_INTEGRATION_ERROR_MODE_KEY", integrationErrorMode);
    }
    
    public static void setMediationService(final String mediationService) {
        AdInternalSettings.setMediationService(mediationService);
    }
    
    public static void setMixedAudience(final boolean b) {
        AdInternalSettings.sSettingsBundle.putBoolean("BOOL_MIXED_AUDIENCE_KEY", b);
    }
    
    public static void setTestAdType(final TestAdType testAdType) {
        AdInternalSettings.sSettingsBundle.putSerializable("TEST_AD_TYPE_KEY", testAdType);
    }
    
    public static void setTestMode(final boolean testMode) {
        AdInternalSettings.setTestMode(testMode);
    }
    
    public static void setUrlPrefix(final String urlPrefix) {
        AdInternalSettings.setUrlPrefix(urlPrefix);
    }
    
    public static void setVideoAutoplay(final boolean videoAutoplay) {
        AdInternalSettings.setVideoAutoplay(videoAutoplay);
    }
    
    public static void setVideoAutoplayOnMobile(final boolean videoAutoplayOnMobile) {
        AdInternalSettings.setVideoAutoplayOnMobile(videoAutoplayOnMobile);
    }
    
    public static void setVisibleAnimation(final boolean visibleAnimation) {
        AdInternalSettings.setVisibleAnimation(visibleAnimation);
    }
    
    public static void turnOnSDKDebugger(final Context context) {
        AdInternalSettings.turnOnSDKDebugger(context);
    }
    
    @Keep
    public enum IntegrationErrorMode
    {
        private static final IntegrationErrorMode[] $VALUES;
        
        INTEGRATION_ERROR_CALLBACK_MODE, 
        INTEGRATION_ERROR_CRASH_DEBUG_MODE;
        
        public static final long serialVersionUID = 1L;
    }
    
    @Keep
    public enum TestAdType
    {
        private static final TestAdType[] $VALUES;
        
        CAROUSEL_IMG_SQUARE_APP_INSTALL("CAROUSEL_IMG_SQUARE_APP_INSTALL", "Carousel App install"), 
        CAROUSEL_IMG_SQUARE_LINK("CAROUSEL_IMG_SQUARE_LINK", "Carousel link"), 
        DEFAULT("DEFAULT", "Default"), 
        IMG_16_9_APP_INSTALL("IMG_16_9_APP_INSTALL", "Image App install"), 
        IMG_16_9_LINK("IMG_16_9_LINK", "Image link"), 
        PLAYABLE("PLAYABLE", "Playable ad"), 
        VIDEO_HD_16_9_15S_APP_INSTALL("VID_HD_16_9_15S_APP_INSTALL", "Video 15 sec App install"), 
        VIDEO_HD_16_9_15S_LINK("VID_HD_16_9_15S_LINK", "Video 15 sec link"), 
        VIDEO_HD_16_9_46S_APP_INSTALL("VID_HD_16_9_46S_APP_INSTALL", "Video 46 sec App install"), 
        VIDEO_HD_16_9_46S_LINK("VID_HD_16_9_46S_LINK", "Video 46 sec link"), 
        VIDEO_HD_9_16_39S_APP_INSTALL("VID_HD_9_16_39S_APP_INSTALL", "Video 39 sec App install"), 
        VIDEO_HD_9_16_39S_LINK("VID_HD_9_16_39S_LINK", "Video 39 sec link");
        
        public static final long serialVersionUID = 1L;
        private final String adTypeString;
        private final String humanReadable;
        
        private TestAdType(final String adTypeString, final String humanReadable) {
            this.adTypeString = adTypeString;
            this.humanReadable = humanReadable;
        }
        
        public String getAdTypeString() {
            return this.adTypeString;
        }
        
        public String getHumanReadable() {
            return this.humanReadable;
        }
    }
}
