// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.mediacodec;

import com.google.common.base.Supplier;

public final class b implements Supplier
{
    public final int a;
    
    public b(final int a) {
        this.a = a;
    }
    
    public final Object get() {
        return AsynchronousMediaCodecAdapter.Factory.b(this.a);
    }
}
