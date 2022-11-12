// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.analytics;

import android.media.metrics.LogSessionId;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class PlayerId
{
    public static final PlayerId b;
    private final a a;
    
    static {
        PlayerId b2;
        if (Util.a < 31) {
            b2 = new PlayerId();
        }
        else {
            b2 = new PlayerId(a.b);
        }
        b = b2;
    }
    
    public PlayerId() {
        this((a)null);
        Assertions.g(Util.a < 31);
    }
    
    public PlayerId(final LogSessionId logSessionId) {
        this(new a(logSessionId));
    }
    
    private PlayerId(final a a) {
        this.a = a;
    }
    
    public LogSessionId a() {
        return Assertions.e(this.a).a;
    }
    
    private static final class a
    {
        public static final a b;
        public final LogSessionId a;
        
        static {
            b = new a(LogSessionId.LOG_SESSION_ID_NONE);
        }
        
        public a(final LogSessionId a) {
            this.a = a;
        }
    }
}
