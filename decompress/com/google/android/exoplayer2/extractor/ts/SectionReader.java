// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class SectionReader implements TsPayloadReader
{
    private final SectionPayloadReader a;
    private final ParsableByteArray b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    
    public SectionReader(final SectionPayloadReader a) {
        this.a = a;
        this.b = new ParsableByteArray(32);
    }
    
    @Override
    public void a(final TimestampAdjuster timestampAdjuster, final ExtractorOutput extractorOutput, final TrackIdGenerator trackIdGenerator) {
        this.a.a(timestampAdjuster, extractorOutput, trackIdGenerator);
        this.f = true;
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray, int d) {
        if ((d & 0x1) != 0x0) {
            d = 1;
        }
        else {
            d = 0;
        }
        int n;
        if (d != 0) {
            n = parsableByteArray.e() + parsableByteArray.D();
        }
        else {
            n = -1;
        }
        if (this.f) {
            if (d == 0) {
                return;
            }
            this.f = false;
            parsableByteArray.P(n);
            this.d = 0;
        }
        while (parsableByteArray.a() > 0) {
            d = this.d;
            if (d < 3) {
                if (d == 0) {
                    d = parsableByteArray.D();
                    parsableByteArray.P(parsableByteArray.e() - 1);
                    if (d == 255) {
                        this.f = true;
                        return;
                    }
                }
                d = Math.min(parsableByteArray.a(), 3 - this.d);
                parsableByteArray.j(this.b.d(), this.d, d);
                d += this.d;
                if ((this.d = d) != 3) {
                    continue;
                }
                this.b.P(0);
                this.b.O(3);
                this.b.Q(1);
                d = this.b.D();
                final int d2 = this.b.D();
                this.e = ((d & 0x80) != 0x0);
                this.c = ((d & 0xF) << 8 | d2) + 3;
                final int b = this.b.b();
                d = this.c;
                if (b >= d) {
                    continue;
                }
                d = Math.min(4098, Math.max(d, this.b.b() * 2));
                this.b.c(d);
            }
            else {
                d = Math.min(parsableByteArray.a(), this.c - this.d);
                parsableByteArray.j(this.b.d(), this.d, d);
                final int d3 = this.d + d;
                this.d = d3;
                d = this.c;
                if (d3 != d) {
                    continue;
                }
                if (this.e) {
                    if (Util.t(this.b.d(), 0, this.c, -1) != 0) {
                        this.f = true;
                        return;
                    }
                    this.b.O(this.c - 4);
                }
                else {
                    this.b.O(d);
                }
                this.b.P(0);
                this.a.b(this.b);
                this.d = 0;
            }
        }
    }
    
    @Override
    public void c() {
        this.f = true;
    }
}
