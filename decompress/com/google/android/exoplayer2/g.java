// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.content.Context;
import com.google.common.base.Supplier;

public final class g implements Supplier
{
    public final Context a;
    
    public g(final Context a) {
        this.a = a;
    }
    
    public final Object get() {
        return ExoPlayer.Builder.c(this.a);
    }
}
