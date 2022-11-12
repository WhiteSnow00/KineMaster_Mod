// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.stats;

import android.content.ComponentName;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class LoggingConstants
{
    public static final ComponentName a;
    
    static {
        a = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
    }
    
    private LoggingConstants() {
    }
}
