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

final class e
{
    private final int a;
    private final TimestampAdjuster b;
    private final ParsableByteArray c;
    private boolean d;
    private boolean e;
    private boolean f;
    private long g;
    private long h;
    private long i;
    
    e(final int a) {
        this.a = a;
        this.b = new TimestampAdjuster(0L);
        this.g = -9223372036854775807L;
        this.h = -9223372036854775807L;
        this.i = -9223372036854775807L;
        this.c = new ParsableByteArray();
    }
    
    private int a(final ExtractorInput extractorInput) {
        this.c.M(Util.f);
        this.d = true;
        extractorInput.h();
        return 0;
    }
    
    private int f(final ExtractorInput extractorInput, final PositionHolder positionHolder, final int n) throws IOException {
        final int n2 = (int)Math.min(this.a, extractorInput.getLength());
        final long position = extractorInput.getPosition();
        final long a = 0;
        if (position != a) {
            positionHolder.a = a;
            return 1;
        }
        this.c.L(n2);
        extractorInput.h();
        extractorInput.r(this.c.d(), 0, n2);
        this.g = this.g(this.c, n);
        this.e = true;
        return 0;
    }
    
    private long g(final ParsableByteArray parsableByteArray, final int n) {
        for (int i = parsableByteArray.e(); i < parsableByteArray.f(); ++i) {
            if (parsableByteArray.d()[i] == 71) {
                final long c = TsUtil.c(parsableByteArray, i, n);
                if (c != -9223372036854775807L) {
                    return c;
                }
            }
        }
        return -9223372036854775807L;
    }
    
    private int h(final ExtractorInput extractorInput, final PositionHolder positionHolder, final int n) throws IOException {
        final long length = extractorInput.getLength();
        final int n2 = (int)Math.min(this.a, length);
        final long a = length - n2;
        if (extractorInput.getPosition() != a) {
            positionHolder.a = a;
            return 1;
        }
        this.c.L(n2);
        extractorInput.h();
        extractorInput.r(this.c.d(), 0, n2);
        this.h = this.i(this.c, n);
        this.f = true;
        return 0;
    }
    
    private long i(final ParsableByteArray parsableByteArray, final int n) {
        final int e = parsableByteArray.e();
        final int f = parsableByteArray.f();
        for (int i = f - 188; i >= e; --i) {
            if (TsUtil.b(parsableByteArray.d(), e, f, i)) {
                final long c = TsUtil.c(parsableByteArray, i, n);
                if (c != -9223372036854775807L) {
                    return c;
                }
            }
        }
        return -9223372036854775807L;
    }
    
    public long b() {
        return this.i;
    }
    
    public TimestampAdjuster c() {
        return this.b;
    }
    
    public boolean d() {
        return this.d;
    }
    
    public int e(final ExtractorInput extractorInput, final PositionHolder positionHolder, final int n) throws IOException {
        if (n <= 0) {
            return this.a(extractorInput);
        }
        if (!this.f) {
            return this.h(extractorInput, positionHolder, n);
        }
        if (this.h == -9223372036854775807L) {
            return this.a(extractorInput);
        }
        if (!this.e) {
            return this.f(extractorInput, positionHolder, n);
        }
        final long g = this.g;
        if (g == -9223372036854775807L) {
            return this.a(extractorInput);
        }
        final long i = this.b.b(this.h) - this.b.b(g);
        this.i = i;
        if (i < 0L) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid duration: ");
            sb.append(this.i);
            sb.append(". Using TIME_UNSET instead.");
            Log.i("TsDurationReader", sb.toString());
            this.i = -9223372036854775807L;
        }
        return this.a(extractorInput);
    }
}
