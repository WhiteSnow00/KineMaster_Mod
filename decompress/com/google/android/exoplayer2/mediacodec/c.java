// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import com.google.common.base.Supplier;

public final class c implements Supplier
{
    public final int a;
    
    public c(final int a) {
        this.a = a;
    }
    
    public final Object get() {
        return AsynchronousMediaCodecAdapter.Factory.c(this.a);
    }
}
