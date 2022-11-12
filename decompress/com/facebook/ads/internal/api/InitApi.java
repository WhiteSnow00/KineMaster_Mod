// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import android.content.Context;
import androidx.annotation.Keep;

@Keep
public interface InitApi
{
    public static final int INIT_TYPE_CONTENT_PROVIDER = 0;
    public static final int INIT_TYPE_INTERNAL_API = 3;
    public static final int INIT_TYPE_PUBLIC_API = 1;
    public static final int INIT_TYPE_REMOTE_PROCESS = 2;
    
    void initialize(final Context p0, final MultithreadedBundleWrapper p1, final AudienceNetworkAds.InitListener p2, final int p3);
    
    boolean isInitialized();
    
    void onAdLoadInvoked(final Context p0);
    
    void onContentProviderCreated(final Context p0);
}
