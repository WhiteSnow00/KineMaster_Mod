// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Consumer;

public final class b implements Consumer
{
    public final int a;
    
    public b(final int a) {
        this.a = a;
    }
    
    @Override
    public final void accept(final Object o) {
        DefaultDrmSession.k(this.a, (DrmSessionEventListener.EventDispatcher)o);
    }
}
