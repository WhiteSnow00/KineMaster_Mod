// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.Log;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

final class c
{
    private final TimestampAdjuster a;
    private final ParsableByteArray b;
    private boolean c;
    private boolean d;
    private boolean e;
    private long f;
    private long g;
    private long h;
    
    c() {
        this.a = new TimestampAdjuster(0L);
        this.f = -9223372036854775807L;
        this.g = -9223372036854775807L;
        this.h = -9223372036854775807L;
        this.b = new ParsableByteArray();
    }
    
    private static boolean a(final byte[] array) {
        boolean b = false;
        if ((array[0] & 0xC4) != 0x44) {
            return false;
        }
        if ((array[2] & 0x4) != 0x4) {
            return false;
        }
        if ((array[4] & 0x4) != 0x4) {
            return false;
        }
        if ((array[5] & 0x1) != 0x1) {
            return false;
        }
        if ((array[8] & 0x3) == 0x3) {
            b = true;
        }
        return b;
    }
    
    private int b(final ExtractorInput extractorInput) {
        this.b.M(Util.f);
        this.c = true;
        extractorInput.h();
        return 0;
    }
    
    private int f(final byte[] array, final int n) {
        return (array[n + 3] & 0xFF) | ((array[n] & 0xFF) << 24 | (array[n + 1] & 0xFF) << 16 | (array[n + 2] & 0xFF) << 8);
    }
    
    private int h(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        final int n = (int)Math.min(20000L, extractorInput.getLength());
        final long position = extractorInput.getPosition();
        final long a = 0;
        if (position != a) {
            positionHolder.a = a;
            return 1;
        }
        this.b.L(n);
        extractorInput.h();
        extractorInput.r(this.b.d(), 0, n);
        this.f = this.i(this.b);
        this.d = true;
        return 0;
    }
    
    private long i(final ParsableByteArray parsableByteArray) {
        for (int i = parsableByteArray.e(); i < parsableByteArray.f() - 3; ++i) {
            if (this.f(parsableByteArray.d(), i) == 442) {
                parsableByteArray.P(i + 4);
                final long l = l(parsableByteArray);
                if (l != -9223372036854775807L) {
                    return l;
                }
            }
        }
        return -9223372036854775807L;
    }
    
    private int j(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        final long length = extractorInput.getLength();
        final int n = (int)Math.min(20000L, length);
        final long a = length - n;
        if (extractorInput.getPosition() != a) {
            positionHolder.a = a;
            return 1;
        }
        this.b.L(n);
        extractorInput.h();
        extractorInput.r(this.b.d(), 0, n);
        this.g = this.k(this.b);
        this.e = true;
        return 0;
    }
    
    private long k(final ParsableByteArray parsableByteArray) {
        for (int e = parsableByteArray.e(), i = parsableByteArray.f() - 4; i >= e; --i) {
            if (this.f(parsableByteArray.d(), i) == 442) {
                parsableByteArray.P(i + 4);
                final long l = l(parsableByteArray);
                if (l != -9223372036854775807L) {
                    return l;
                }
            }
        }
        return -9223372036854775807L;
    }
    
    public static long l(final ParsableByteArray parsableByteArray) {
        final int e = parsableByteArray.e();
        if (parsableByteArray.a() < 9) {
            return -9223372036854775807L;
        }
        final byte[] array = new byte[9];
        parsableByteArray.j(array, 0, 9);
        parsableByteArray.P(e);
        if (!a(array)) {
            return -9223372036854775807L;
        }
        return m(array);
    }
    
    private static long m(final byte[] array) {
        return ((long)array[0] & 0x38L) >> 3 << 30 | ((long)array[0] & 0x3L) << 28 | ((long)array[1] & 0xFFL) << 20 | ((long)array[2] & 0xF8L) >> 3 << 15 | ((long)array[2] & 0x3L) << 13 | ((long)array[3] & 0xFFL) << 5 | ((long)array[4] & 0xF8L) >> 3;
    }
    
    public long c() {
        return this.h;
    }
    
    public TimestampAdjuster d() {
        return this.a;
    }
    
    public boolean e() {
        return this.c;
    }
    
    public int g(final ExtractorInput extractorInput, final PositionHolder positionHolder) throws IOException {
        if (!this.e) {
            return this.j(extractorInput, positionHolder);
        }
        if (this.g == -9223372036854775807L) {
            return this.b(extractorInput);
        }
        if (!this.d) {
            return this.h(extractorInput, positionHolder);
        }
        final long f = this.f;
        if (f == -9223372036854775807L) {
            return this.b(extractorInput);
        }
        final long h = this.a.b(this.g) - this.a.b(f);
        this.h = h;
        if (h < 0L) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid duration: ");
            sb.append(this.h);
            sb.append(". Using TIME_UNSET instead.");
            Log.i("PsDurationReader", sb.toString());
            this.h = -9223372036854775807L;
        }
        return this.b(extractorInput);
    }
}
