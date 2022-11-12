// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import android.util.Log;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;

public final class RtpPcmReader implements RtpPayloadReader
{
    private final RtpPayloadFormat a;
    private TrackOutput b;
    private long c;
    private long d;
    private int e;
    
    public RtpPcmReader(final RtpPayloadFormat a) {
        this.a = a;
        this.c = -9223372036854775807L;
        this.d = 0L;
        this.e = -1;
    }
    
    private static long e(final long n, final long n2, final long n3, final int n4) {
        return n + Util.O0(n2 - n3, 1000000L, n4);
    }
    
    @Override
    public void a(final long c, final long d) {
        this.c = c;
        this.d = d;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray, long e, final int e2, final boolean b) {
        Assertions.e(this.b);
        final int e3 = this.e;
        if (e3 != -1) {
            final int b2 = RtpPacket.b(e3);
            if (e2 != b2) {
                Log.w("RtpPcmReader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", b2, e2));
            }
        }
        e = e(this.d, e, this.c, this.a.b);
        final int a = parsableByteArray.a();
        this.b.c(parsableByteArray, a);
        this.b.e(e, 1, a, 0, null);
        this.e = e2;
    }
    
    @Override
    public void c(final ExtractorOutput extractorOutput, final int n) {
        (this.b = extractorOutput.e(n, 1)).d(this.a.c);
    }
    
    @Override
    public void d(final long c, final int n) {
        this.c = c;
    }
}
