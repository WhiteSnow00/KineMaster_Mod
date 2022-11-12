// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import java.util.EnumSet;
import androidx.annotation.Keep;

@Keep
public enum CacheFlag
{
    private static final CacheFlag[] $VALUES;
    public static final EnumSet<CacheFlag> ALL;
    
    ICON, 
    IMAGE, 
    NONE, 
    VIDEO;
    
    static {
        ALL = EnumSet.allOf(CacheFlag.class);
    }
}
