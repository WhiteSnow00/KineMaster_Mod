// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.Clock;
import com.google.common.base.Function;

public final class e implements Function
{
    public static final e a;
    
    static {
        a = new e();
    }
    
    private e() {
    }
    
    public final Object apply(final Object o) {
        return new DefaultAnalyticsCollector((Clock)o);
    }
}
