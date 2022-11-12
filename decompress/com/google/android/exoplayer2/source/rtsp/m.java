// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import java.util.List;

public final class m implements Runnable
{
    public final RtspMessageChannel.e a;
    public final byte[] b;
    public final List c;
    
    public m(final RtspMessageChannel.e a, final byte[] b, final List c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        RtspMessageChannel.e.a(this.a, this.b, this.c);
    }
}
