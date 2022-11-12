// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Consumer;

public final class c implements Consumer
{
    public final Exception a;
    
    public c(final Exception a) {
        this.a = a;
    }
    
    @Override
    public final void accept(final Object o) {
        DefaultDrmSession.j(this.a, (DrmSessionEventListener.EventDispatcher)o);
    }
}
