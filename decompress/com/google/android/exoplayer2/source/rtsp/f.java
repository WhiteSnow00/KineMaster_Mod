// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import java.util.List;

public final class f implements Runnable
{
    public final RtspClient.c a;
    public final List b;
    
    public f(final RtspClient.c a, final List b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        RtspClient.c.d(this.a, this.b);
    }
}
