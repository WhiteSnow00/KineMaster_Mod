// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.util.Consumer;

public final class x implements Consumer
{
    public static final x a;
    
    static {
        a = new x();
    }
    
    private x() {
    }
    
    @Override
    public final void accept(final Object o) {
        SampleQueue.g((SampleQueue.c)o);
    }
}
