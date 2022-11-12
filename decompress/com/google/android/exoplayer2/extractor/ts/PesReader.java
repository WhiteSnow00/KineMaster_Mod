// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.ParsableBitArray;

public final class PesReader implements TsPayloadReader
{
    private final ElementaryStreamReader a;
    private final ParsableBitArray b;
    private int c;
    private int d;
    private TimestampAdjuster e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private long l;
    
    public PesReader(final ElementaryStreamReader a) {
        this.a = a;
        this.b = new ParsableBitArray(new byte[10]);
        this.c = 0;
    }
    
    private boolean d(final ParsableByteArray parsableByteArray, final byte[] array, final int n) {
        final int min = Math.min(parsableByteArray.a(), n - this.d);
        boolean b = true;
        if (min <= 0) {
            return true;
        }
        if (array == null) {
            parsableByteArray.Q(min);
        }
        else {
            parsableByteArray.j(array, this.d, min);
        }
        final int d = this.d + min;
        this.d = d;
        if (d != n) {
            b = false;
        }
        return b;
    }
    
    private boolean e() {
        this.b.p(0);
        final int h = this.b.h(24);
        if (h != 1) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unexpected start code prefix: ");
            sb.append(h);
            Log.i("PesReader", sb.toString());
            this.j = -1;
            return false;
        }
        this.b.r(8);
        final int h2 = this.b.h(16);
        this.b.r(5);
        this.k = this.b.g();
        this.b.r(2);
        this.f = this.b.g();
        this.g = this.b.g();
        this.b.r(6);
        final int h3 = this.b.h(8);
        this.i = h3;
        if (h2 == 0) {
            this.j = -1;
        }
        else if ((this.j = h2 + 6 - 9 - h3) < 0) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Found negative packet payload size: ");
            sb2.append(this.j);
            Log.i("PesReader", sb2.toString());
            this.j = -1;
        }
        return true;
    }
    
    private void f() {
        this.b.p(0);
        this.l = -9223372036854775807L;
        if (this.f) {
            this.b.r(4);
            final long n = this.b.h(3);
            this.b.r(1);
            final long n2 = this.b.h(15) << 15;
            this.b.r(1);
            final long n3 = this.b.h(15);
            this.b.r(1);
            if (!this.h && this.g) {
                this.b.r(4);
                final long n4 = this.b.h(3);
                this.b.r(1);
                final long n5 = this.b.h(15) << 15;
                this.b.r(1);
                final long n6 = this.b.h(15);
                this.b.r(1);
                this.e.b(n4 << 30 | n5 | n6);
                this.h = true;
            }
            this.l = this.e.b(n << 30 | n2 | n3);
        }
    }
    
    private void g(final int c) {
        this.c = c;
        this.d = 0;
    }
    
    @Override
    public void a(final TimestampAdjuster e, final ExtractorOutput extractorOutput, final TrackIdGenerator trackIdGenerator) {
        this.e = e;
        this.a.d(extractorOutput, trackIdGenerator);
    }
    
    @Override
    public final void b(final ParsableByteArray parsableByteArray, int j) throws ParserException {
        Assertions.i(this.e);
        int n = j;
        if ((j & 0x1) != 0x0) {
            final int c = this.c;
            if (c != 0 && c != 1) {
                if (c != 2) {
                    if (c != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.j != -1) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(this.j);
                        sb.append(" more bytes");
                        Log.i("PesReader", sb.toString());
                    }
                    this.a.e();
                }
                else {
                    Log.i("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            this.g(1);
            n = j;
        }
        while (parsableByteArray.a() > 0) {
            final int c2 = this.c;
            if (c2 != 0) {
                j = 0;
                final int n2 = 0;
                int n3 = 0;
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            throw new IllegalStateException();
                        }
                        final int a = parsableByteArray.a();
                        j = this.j;
                        if (j != -1) {
                            n3 = a - j;
                        }
                        j = a;
                        if (n3 > 0) {
                            j = a - n3;
                            parsableByteArray.O(parsableByteArray.e() + j);
                        }
                        this.a.b(parsableByteArray);
                        final int i = this.j;
                        if (i == -1) {
                            continue;
                        }
                        j = i - j;
                        if ((this.j = j) != 0) {
                            continue;
                        }
                        this.a.e();
                        this.g(1);
                    }
                    else {
                        if (!this.d(parsableByteArray, this.b.a, Math.min(10, this.i)) || !this.d(parsableByteArray, null, this.i)) {
                            continue;
                        }
                        this.f();
                        if (this.k) {
                            j = 4;
                        }
                        n |= j;
                        this.a.f(this.l, n);
                        this.g(3);
                    }
                }
                else {
                    if (!this.d(parsableByteArray, this.b.a, 9)) {
                        continue;
                    }
                    j = n2;
                    if (this.e()) {
                        j = 2;
                    }
                    this.g(j);
                }
            }
            else {
                parsableByteArray.Q(parsableByteArray.a());
            }
        }
    }
    
    @Override
    public final void c() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.a.c();
    }
}
