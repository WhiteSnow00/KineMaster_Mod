// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.FilterInputStream;

public final class g extends FilterInputStream
{
    private static final byte[] c;
    private static final int d;
    private static final int e;
    private final byte a;
    private int b;
    
    static {
        final byte[] array;
        final byte[] c2 = array = new byte[29];
        array[0] = -1;
        array[1] = -31;
        array[2] = 0;
        array[3] = 28;
        array[4] = 69;
        array[5] = 120;
        array[6] = 105;
        array[7] = 102;
        array[9] = (array[8] = 0);
        array[11] = (array[10] = 77);
        array[12] = 0;
        array[14] = (array[13] = 0);
        array[16] = (array[15] = 0);
        array[17] = 8;
        array[18] = 0;
        array[20] = (array[19] = 1);
        array[21] = 18;
        array[22] = 0;
        array[23] = 2;
        array[24] = 0;
        array[26] = (array[25] = 0);
        array[27] = 1;
        array[28] = 0;
        c = c2;
        e = (d = c2.length) + 2;
    }
    
    public g(final InputStream inputStream, final int n) {
        super(inputStream);
        if (n >= -1 && n <= 8) {
            this.a = (byte)n;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Cannot add invalid orientation: ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
    
    @Override
    public void mark(final int n) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean markSupported() {
        return false;
    }
    
    @Override
    public int read() throws IOException {
        final int b = this.b;
        int n = 0;
        Label_0055: {
            if (b >= 2) {
                final int e = g.e;
                if (b <= e) {
                    if (b == e) {
                        n = this.a;
                        break Label_0055;
                    }
                    n = (g.c[b - 2] & 0xFF);
                    break Label_0055;
                }
            }
            n = super.read();
        }
        if (n != -1) {
            ++this.b;
        }
        return n;
    }
    
    @Override
    public int read(final byte[] array, int n, int min) throws IOException {
        final int b = this.b;
        final int e = g.e;
        if (b > e) {
            n = super.read(array, n, min);
        }
        else if (b == e) {
            array[n] = this.a;
            n = 1;
        }
        else if (b < 2) {
            n = super.read(array, n, 2 - b);
        }
        else {
            min = Math.min(e - b, min);
            System.arraycopy(g.c, this.b - 2, array, n, min);
            n = min;
        }
        if (n > 0) {
            this.b += n;
        }
        return n;
    }
    
    @Override
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public long skip(long skip) throws IOException {
        skip = super.skip(skip);
        if (skip > 0L) {
            this.b += (int)skip;
        }
        return skip;
    }
}
