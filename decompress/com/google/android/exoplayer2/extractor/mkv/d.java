// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mkv;

import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class d
{
    private final ParsableByteArray a;
    private int b;
    
    public d() {
        this.a = new ParsableByteArray(8);
    }
    
    private long a(final ExtractorInput extractorInput) throws IOException {
        final byte[] d = this.a.d();
        final int n = 0;
        extractorInput.r(d, 0, 1);
        final int n2 = this.a.d()[0] & 0xFF;
        if (n2 == 0) {
            return Long.MIN_VALUE;
        }
        int n3;
        int n4;
        for (n3 = 128, n4 = 0; (n2 & n3) == 0x0; n3 >>= 1, ++n4) {}
        final int n5 = n2 & ~n3;
        extractorInput.r(this.a.d(), 1, n4);
        int i;
        int n6;
        byte[] d2;
        for (i = n, n6 = n5; i < n4; ++i, n6 = (d2[i] & 0xFF) + (n6 << 8)) {
            d2 = this.a.d();
        }
        this.b += n4 + 1;
        return n6;
    }
    
    public boolean b(final ExtractorInput extractorInput) throws IOException {
        final long length = extractorInput.getLength();
        final long n = lcmp(length, -1L);
        long n2 = 1024L;
        if (n != 0) {
            if (length > 1024L) {
                n2 = n2;
            }
            else {
                n2 = length;
            }
        }
        final int n3 = (int)n2;
        final byte[] d = this.a.d();
        final boolean b = false;
        extractorInput.r(d, 0, 4);
        long f = this.a.F();
        this.b = 4;
        while (f != 440786851L) {
            if (++this.b == n3) {
                return false;
            }
            extractorInput.r(this.a.d(), 0, 1);
            f = ((f << 8 & 0xFFFFFFFFFFFFFF00L) | (long)(this.a.d()[0] & 0xFF));
        }
        final long a = this.a(extractorInput);
        final long n4 = this.b;
        boolean b2 = b;
        if (a != Long.MIN_VALUE) {
            if (n != 0 && n4 + a >= length) {
                b2 = b;
            }
            else {
                while (true) {
                    final int b3 = this.b;
                    final long n5 = b3;
                    final long n6 = n4 + a;
                    if (n5 < n6) {
                        if (this.a(extractorInput) == Long.MIN_VALUE) {
                            return false;
                        }
                        final long a2 = this.a(extractorInput);
                        final long n7 = lcmp(a2, 0L);
                        if (n7 < 0 || a2 > 2147483647L) {
                            return false;
                        }
                        if (n7 == 0) {
                            continue;
                        }
                        final int n8 = (int)a2;
                        extractorInput.m(n8);
                        this.b += n8;
                    }
                    else {
                        b2 = b;
                        if (b3 == n6) {
                            b2 = true;
                            break;
                        }
                        break;
                    }
                }
            }
        }
        return b2;
    }
}
