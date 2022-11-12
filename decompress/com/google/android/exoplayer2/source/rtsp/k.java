// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

public final class k implements EventListener
{
    public final h.d a;
    
    public k(final h.d a) {
        this.a = a;
    }
    
    @Override
    public final void a(final String s, final RtpDataChannel rtpDataChannel) {
        com.google.android.exoplayer2.source.rtsp.h.d.a(this.a, s, rtpDataChannel);
    }
}
