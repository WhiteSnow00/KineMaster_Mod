// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mkv;

import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;

final class e
{
    private static final long[] d;
    private final byte[] a;
    private int b;
    private int c;
    
    static {
        d = new long[] { 128L, 64L, 32L, 16L, 8L, 4L, 2L, 1L };
    }
    
    public e() {
        this.a = new byte[8];
    }
    
    public static long a(final byte[] array, final int n, final boolean b) {
        long n3;
        final long n2 = n3 = ((long)array[0] & 0xFFL);
        if (b) {
            n3 = (n2 & ~e.d[n - 1]);
        }
        for (int i = 1; i < n; ++i) {
            n3 = (n3 << 8 | ((long)array[i] & 0xFFL));
        }
        return n3;
    }
    
    public static int c(int n) {
        int n2 = 0;
        while (true) {
            final long[] d = e.d;
            if (n2 >= d.length) {
                n = -1;
                break;
            }
            if ((d[n2] & (long)n) != 0x0L) {
                n = n2 + 1;
                break;
            }
            ++n2;
        }
        return n;
    }
    
    public int b() {
        return this.c;
    }
    
    public long d(final ExtractorInput extractorInput, final boolean b, final boolean b2, final int n) throws IOException {
        if (this.b == 0) {
            if (!extractorInput.i(this.a, 0, 1, b)) {
                return -1L;
            }
            if ((this.c = c(this.a[0] & 0xFF)) == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.b = 1;
        }
        final int c = this.c;
        if (c > n) {
            this.b = 0;
            return -2L;
        }
        if (c != 1) {
            extractorInput.readFully(this.a, 1, c - 1);
        }
        this.b = 0;
        return a(this.a, this.c, b2);
    }
    
    public void e() {
        this.b = 0;
        this.c = 0;
    }
}
