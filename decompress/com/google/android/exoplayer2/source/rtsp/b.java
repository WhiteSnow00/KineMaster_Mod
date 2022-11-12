// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp;

import java.io.IOException;
import android.os.SystemClock;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.source.rtsp.reader.DefaultRtpPayloadReaderFactory;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.source.rtsp.reader.RtpPayloadReader;
import com.google.android.exoplayer2.extractor.Extractor;

final class b implements Extractor
{
    private final RtpPayloadReader a;
    private final ParsableByteArray b;
    private final ParsableByteArray c;
    private final int d;
    private final Object e;
    private final d f;
    private ExtractorOutput g;
    private boolean h;
    private volatile long i;
    private volatile int j;
    private boolean k;
    private long l;
    private long m;
    
    public b(final RtpPayloadFormat rtpPayloadFormat, final int d) {
        this.d = d;
        this.a = Assertions.e(new DefaultRtpPayloadReaderFactory().a(rtpPayloadFormat));
        this.b = new ParsableByteArray(65507);
        this.c = new ParsableByteArray();
        this.e = new Object();
        this.f = new d();
        this.i = -9223372036854775807L;
        this.j = -1;
        this.l = -9223372036854775807L;
        this.m = -9223372036854775807L;
    }
    
    private static long c(final long n) {
        return n - 30L;
    }
    
    @Override
    public void a(final long l, final long m) {
        synchronized (this.e) {
            this.l = l;
            this.m = m;
        }
    }
    
    @Override
    public void b(final ExtractorOutput g) {
        this.a.c(g, this.d);
        g.o();
        g.l(new SeekMap.Unseekable(-9223372036854775807L));
        this.g = g;
    }
    
    @Override
    public boolean d(final ExtractorInput extractorInput) {
        throw new UnsupportedOperationException("RTP packets are transmitted in a packet stream do not support sniffing.");
    }
    
    @Override
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        Assertions.e(this.g);
        final int read = extractorInput.read(this.b.d(), 0, 65507);
        if (read == -1) {
            return -1;
        }
        if (read == 0) {
            return 0;
        }
        this.b.P(0);
        this.b.O(read);
        final RtpPacket d = RtpPacket.d(this.b);
        if (d == null) {
            return 0;
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final long c = c(elapsedRealtime);
        this.f.e(d, elapsedRealtime);
        RtpPacket rtpPacket = this.f.f(c);
        if (rtpPacket == null) {
            return 0;
        }
        if (!this.h) {
            if (this.i == -9223372036854775807L) {
                this.i = rtpPacket.h;
            }
            if (this.j == -1) {
                this.j = rtpPacket.g;
            }
            this.a.d(this.i, this.j);
            this.h = true;
        }
        synchronized (this.e) {
            if (this.k) {
                if (this.l != -9223372036854775807L && this.m != -9223372036854775807L) {
                    this.f.g();
                    this.a.a(this.l, this.m);
                    this.k = false;
                    this.l = -9223372036854775807L;
                    this.m = -9223372036854775807L;
                }
            }
            else {
                do {
                    this.c.M(rtpPacket.k);
                    this.a.b(this.c, rtpPacket.h, rtpPacket.g, rtpPacket.e);
                } while ((rtpPacket = this.f.f(c)) != null);
            }
            return 0;
        }
    }
    
    public boolean f() {
        return this.h;
    }
    
    public void g() {
        synchronized (this.e) {
            this.k = true;
        }
    }
    
    public void h(final int j) {
        this.j = j;
    }
    
    public void i(final long i) {
        this.i = i;
    }
    
    @Override
    public void release() {
    }
}
