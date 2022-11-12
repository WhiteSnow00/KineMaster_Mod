// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

public final class n implements Runnable
{
    public final MediaSourceEventListener.EventDispatcher a;
    public final MediaSourceEventListener b;
    public final MediaLoadData c;
    
    public n(final MediaSourceEventListener.EventDispatcher a, final MediaSourceEventListener b, final MediaLoadData c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        MediaSourceEventListener.EventDispatcher.d(this.a, this.b, this.c);
    }
}
