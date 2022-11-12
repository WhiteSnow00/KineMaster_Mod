// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

public final class o implements Runnable
{
    public final DrmSessionEventListener.EventDispatcher a;
    public final DrmSessionEventListener b;
    public final Exception c;
    
    public o(final DrmSessionEventListener.EventDispatcher a, final DrmSessionEventListener b, final Exception c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        DrmSessionEventListener.EventDispatcher.e(this.a, this.b, this.c);
    }
}
