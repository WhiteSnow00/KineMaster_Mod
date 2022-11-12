// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

public final class i implements Runnable
{
    public final DefaultDrmSession a;
    
    public i(final DefaultDrmSession a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        DefaultDrmSessionManager.f.c(this.a);
    }
}
