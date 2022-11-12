// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

final class w implements Factory
{
    private final long a;
    
    public w(final long a) {
        this.a = a;
    }
    
    @Override
    public RtpDataChannel a(final int n) {
        final v v = new v(this.a);
        v.b(RtpUtils.a(n * 2));
        return v;
    }
}
