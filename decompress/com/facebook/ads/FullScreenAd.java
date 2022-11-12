// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import androidx.annotation.Keep;

public interface FullScreenAd extends Ad
{
    LoadConfigBuilder buildLoadAdConfig();
    
    ShowConfigBuilder buildShowAdConfig();
    
    boolean show();
    
    @Keep
    public interface ShowAdConfig
    {
    }
    
    @Keep
    public interface ShowConfigBuilder
    {
        ShowAdConfig build();
    }
}
