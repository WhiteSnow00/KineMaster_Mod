// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.common.collect.ImmutableList$Builder;

public final class g1 implements Runnable
{
    public final h1 a;
    public final ImmutableList$Builder b;
    public final MediaSource.MediaPeriodId c;
    
    public g1(final h1 a, final ImmutableList$Builder b, final MediaSource.MediaPeriodId c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        h1.a(this.a, this.b, this.c);
    }
}
