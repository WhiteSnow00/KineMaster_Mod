// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

public final class n implements Runnable
{
    public final DrmSessionEventListener.EventDispatcher a;
    public final DrmSessionEventListener b;
    public final int c;
    
    public n(final DrmSessionEventListener.EventDispatcher a, final DrmSessionEventListener b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        DrmSessionEventListener.EventDispatcher.f(this.a, this.b, this.c);
    }
}
