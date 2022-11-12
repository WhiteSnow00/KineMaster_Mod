// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

public final class g implements Runnable
{
    public final DefaultDrmSessionManager.d a;
    
    public g(final DefaultDrmSessionManager.d a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        DefaultDrmSessionManager.d.c(this.a);
    }
}
