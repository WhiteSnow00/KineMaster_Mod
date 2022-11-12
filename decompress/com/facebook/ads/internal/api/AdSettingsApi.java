// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.api;

import android.content.Context;
import androidx.annotation.Keep;

@Keep
public interface AdSettingsApi
{
    boolean isTestMode(final Context p0);
    
    void turnOnDebugger();
}
