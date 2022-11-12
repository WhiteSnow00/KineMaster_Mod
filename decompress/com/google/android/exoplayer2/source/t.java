// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.extractor.SeekMap;

public final class t implements Runnable
{
    public final u a;
    public final SeekMap b;
    
    public t(final u a, final SeekMap b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        u.t(this.a, this.b);
    }
}
