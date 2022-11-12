// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

public final class j implements Runnable
{
    public final MediaSourceEventListener.EventDispatcher a;
    public final MediaSourceEventListener b;
    public final LoadEventInfo c;
    public final MediaLoadData d;
    
    public j(final MediaSourceEventListener.EventDispatcher a, final MediaSourceEventListener b, final LoadEventInfo c, final MediaLoadData d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public final void run() {
        MediaSourceEventListener.EventDispatcher.c(this.a, this.b, this.c, this.d);
    }
}
