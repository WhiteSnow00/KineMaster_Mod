// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import android.util.Pair;
import java.util.Map;

public final class WidevineUtil
{
    private WidevineUtil() {
    }
    
    private static long a(final Map<String, String> map, final String s) {
        if (map == null) {
            return -9223372036854775807L;
        }
        try {
            final String s2 = map.get(s);
            if (s2 != null) {
                return Long.parseLong(s2);
            }
            return -9223372036854775807L;
        }
        catch (final NumberFormatException ex) {
            return -9223372036854775807L;
        }
    }
    
    public static Pair<Long, Long> b(final DrmSession drmSession) {
        final Map<String, String> h = drmSession.h();
        if (h == null) {
            return null;
        }
        return (Pair<Long, Long>)new Pair((Object)a(h, "LicenseDurationRemaining"), (Object)a(h, "PlaybackDurationRemaining"));
    }
}
