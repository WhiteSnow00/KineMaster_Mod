// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Consumer;

public final class d implements Consumer
{
    public static final d a;
    
    static {
        a = new d();
    }
    
    private d() {
    }
    
    @Override
    public final void accept(final Object o) {
        ((DrmSessionEventListener.EventDispatcher)o).h();
    }
}
