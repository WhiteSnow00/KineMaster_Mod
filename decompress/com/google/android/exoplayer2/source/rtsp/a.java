// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

public final class a implements Runnable
{
    public final RtpDataLoadable a;
    public final String b;
    public final RtpDataChannel c;
    
    public a(final RtpDataLoadable a, final String b, final RtpDataChannel c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final void run() {
        RtpDataLoadable.b(this.a, this.b, this.c);
    }
}
