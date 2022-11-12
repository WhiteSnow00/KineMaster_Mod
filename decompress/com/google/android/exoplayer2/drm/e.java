// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Consumer;

public final class e implements Consumer
{
    public static final e a;
    
    static {
        a = new e();
    }
    
    private e() {
    }
    
    @Override
    public final void accept(final Object o) {
        ((DrmSessionEventListener.EventDispatcher)o).i();
    }
}
