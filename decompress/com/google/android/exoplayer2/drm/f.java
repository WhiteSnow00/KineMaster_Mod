// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Consumer;

public final class f implements Consumer
{
    public static final f a;
    
    static {
        a = new f();
    }
    
    private f() {
    }
    
    @Override
    public final void accept(final Object o) {
        ((DrmSessionEventListener.EventDispatcher)o).j();
    }
}
