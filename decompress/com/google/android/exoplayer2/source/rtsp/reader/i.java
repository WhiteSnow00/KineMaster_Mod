// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;

final class i implements RtpPayloadReader
{
    private final RtpPayloadFormat a;
    private TrackOutput b;
    private long c;
    private long d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    
    public i(final RtpPayloadFormat a) {
        this.a = a;
        this.c = -9223372036854775807L;
        this.d = 0L;
        this.e = -1;
        this.g = -1;
        this.h = -1;
        this.i = false;
        this.j = false;
    }
    
    private static long e(final long n, final long n2, final long n3) {
        return n + Util.O0(n2 - n3, 1000000L, 90000L);
    }
    
    private boolean f(final ParsableByteArray parsableByteArray, int i) {
        final int d = parsableByteArray.D();
        if (!this.i) {
            if ((d & 0x8) == 0x0) {
                Log.i("RtpVp9Reader", "First payload octet of the RTP packet is not the beginning of a new VP9 partition, Dropping current packet.");
                return false;
            }
            this.i = true;
        }
        else {
            final int b = RtpPacket.b(this.e);
            if (i != b) {
                Log.i("RtpVp9Reader", Util.C("Received RTP packet with unexpected sequence number. Expected: %d; received: %d. Dropping packet.", b, i));
                return false;
            }
        }
        if ((d & 0x80) != 0x0 && (parsableByteArray.D() & 0x80) != 0x0 && parsableByteArray.a() < 1) {
            return false;
        }
        i = (d & 0x10);
        Assertions.b(i == 0, "VP9 flexible mode is not supported.");
        if ((d & 0x20) != 0x0) {
            parsableByteArray.Q(1);
            if (parsableByteArray.a() < 1) {
                return false;
            }
            if (i == 0) {
                parsableByteArray.Q(1);
            }
        }
        if ((d & 0x2) != 0x0) {
            final int d2 = parsableByteArray.D();
            if ((d2 & 0x10) != 0x0) {
                final int n = (d2 >> 5 & 0x7) + 1;
                if (parsableByteArray.a() < n * 4) {
                    return false;
                }
                for (i = 0; i < n; ++i) {
                    this.g = parsableByteArray.J();
                    this.h = parsableByteArray.J();
                }
            }
            if ((d2 & 0x8) != 0x0) {
                final int d3 = parsableByteArray.D();
                if (parsableByteArray.a() < d3) {
                    return false;
                }
                int n2;
                for (i = 0; i < d3; ++i) {
                    n2 = (parsableByteArray.J() & 0xC) >> 2;
                    if (parsableByteArray.a() < n2) {
                        return false;
                    }
                    parsableByteArray.Q(n2);
                }
            }
        }
        return true;
    }
    
    @Override
    public void a(final long c, final long d) {
        this.c = c;
        this.f = 0;
        this.d = d;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray, long e, final int e2, final boolean b) {
        Assertions.i(this.b);
        if (this.f(parsableByteArray, e2)) {
            int n;
            if (this.f == 0 && this.i && (parsableByteArray.h() & 0x4) == 0x0) {
                n = 1;
            }
            else {
                n = 0;
            }
            if (!this.j) {
                final int g = this.g;
                if (g != -1) {
                    final int h = this.h;
                    if (h != -1) {
                        final Format c = this.a.c;
                        if (g != c.B || h != c.C) {
                            this.b.d(c.b().j0(this.g).Q(this.h).E());
                        }
                        this.j = true;
                    }
                }
            }
            final int a = parsableByteArray.a();
            this.b.c(parsableByteArray, a);
            this.f += a;
            if (b) {
                if (this.c == -9223372036854775807L) {
                    this.c = e;
                }
                e = e(this.d, e, this.c);
                this.b.e(e, n, this.f, 0, null);
                this.f = 0;
                this.i = false;
            }
            this.e = e2;
        }
    }
    
    @Override
    public void c(final ExtractorOutput extractorOutput, final int n) {
        (this.b = extractorOutput.e(n, 2)).d(this.a.c);
    }
    
    @Override
    public void d(final long n, final int n2) {
    }
}
