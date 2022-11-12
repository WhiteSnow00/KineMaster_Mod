// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import com.google.common.base.Supplier;

public final class v0 implements Supplier
{
    public final ExoPlayerImplInternal a;
    
    public v0(final ExoPlayerImplInternal a) {
        this.a = a;
    }
    
    public final Object get() {
        return ExoPlayerImplInternal.d(this.a);
    }
}
