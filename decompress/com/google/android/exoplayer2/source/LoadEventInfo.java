// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.concurrent.atomic.AtomicLong;

public final class LoadEventInfo
{
    private static final AtomicLong h;
    public final long a;
    public final DataSpec b;
    public final Uri c;
    public final Map<String, List<String>> d;
    public final long e;
    public final long f;
    public final long g;
    
    static {
        h = new AtomicLong();
    }
    
    public LoadEventInfo(final long n, final DataSpec dataSpec, final long n2) {
        this(n, dataSpec, dataSpec.a, Collections.emptyMap(), n2, 0L, 0L);
    }
    
    public LoadEventInfo(final long a, final DataSpec b, final Uri c, final Map<String, List<String>> d, final long e, final long f, final long g) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public static long a() {
        return LoadEventInfo.h.getAndIncrement();
    }
}
