// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.common.base.Supplier;

public final class j implements Supplier
{
    public final MediaSource.Factory a;
    
    public j(final MediaSource.Factory a) {
        this.a = a;
    }
    
    public final Object get() {
        return ExoPlayer.Builder.a(this.a);
    }
}
