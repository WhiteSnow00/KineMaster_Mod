// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSpec;
import g4.a;

public interface CacheKeyFactory
{
    public static final CacheKeyFactory a = g4.a.b;
    
    default String b(final DataSpec dataSpec) {
        final String i = dataSpec.i;
        String string;
        if (i != null) {
            string = i;
        }
        else {
            string = dataSpec.a.toString();
        }
        return string;
    }
    
    default String c(final DataSpec dataSpec) {
        return b(dataSpec);
    }
    
    String a(final DataSpec p0);
}
