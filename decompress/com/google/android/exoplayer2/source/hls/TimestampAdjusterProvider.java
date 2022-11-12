// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.util.TimestampAdjuster;
import android.util.SparseArray;

public final class TimestampAdjusterProvider
{
    private final SparseArray<TimestampAdjuster> a;
    
    public TimestampAdjusterProvider() {
        this.a = (SparseArray<TimestampAdjuster>)new SparseArray();
    }
    
    public TimestampAdjuster a(final int n) {
        TimestampAdjuster timestampAdjuster;
        if ((timestampAdjuster = (TimestampAdjuster)this.a.get(n)) == null) {
            timestampAdjuster = new TimestampAdjuster(9223372036854775806L);
            this.a.put(n, (Object)timestampAdjuster);
        }
        return timestampAdjuster;
    }
    
    public void b() {
        this.a.clear();
    }
}
