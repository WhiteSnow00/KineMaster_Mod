// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.upstream;

import java.util.Comparator;

public final class e implements Comparator
{
    public static final e a;
    
    static {
        a = new e();
    }
    
    private e() {
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        return SlidingPercentile.b((SlidingPercentile.b)o, (SlidingPercentile.b)o2);
    }
}
