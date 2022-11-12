// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

public final class k implements Runnable
{
    public final DrmSessionEventListener.EventDispatcher a;
    public final DrmSessionEventListener b;
    
    public k(final DrmSessionEventListener.EventDispatcher a, final DrmSessionEventListener b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        DrmSessionEventListener.EventDispatcher.b(this.a, this.b);
    }
}
