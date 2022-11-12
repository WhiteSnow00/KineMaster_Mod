// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source;

import java.io.IOException;

public final class m implements Runnable
{
    public final MediaSourceEventListener.EventDispatcher a;
    public final MediaSourceEventListener b;
    public final LoadEventInfo c;
    public final MediaLoadData d;
    public final IOException e;
    public final boolean f;
    
    public m(final MediaSourceEventListener.EventDispatcher a, final MediaSourceEventListener b, final LoadEventInfo c, final MediaLoadData d, final IOException e, final boolean f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    @Override
    public final void run() {
        MediaSourceEventListener.EventDispatcher.b(this.a, this.b, this.c, this.d, this.e, this.f);
    }
}
