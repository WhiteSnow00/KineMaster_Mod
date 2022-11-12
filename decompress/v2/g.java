// 
// Decompiled by Procyon v0.6.0
// 

package v2;

import android.os.SystemClock;

public final class g
{
    private static final double a;
    
    static {
        a = 1.0 / Math.pow(10.0, 6.0);
    }
    
    public static double a(final long n) {
        return (b() - n) * g.a;
    }
    
    public static long b() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
