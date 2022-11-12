// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
import java.io.EOFException;
import com.google.android.exoplayer2.upstream.DataReader;

public final class DummyTrackOutput implements TrackOutput
{
    private final byte[] a;
    
    public DummyTrackOutput() {
        this.a = new byte[4096];
    }
    
    @Override
    public int a(final DataReader dataReader, int n, final boolean b, final int n2) throws IOException {
        n = Math.min(this.a.length, n);
        n = dataReader.read(this.a, 0, n);
        if (n != -1) {
            return n;
        }
        if (b) {
            return -1;
        }
        throw new EOFException();
    }
    
    @Override
    public void d(final Format format) {
    }
    
    @Override
    public void e(final long n, final int n2, final int n3, final int n4, final CryptoData cryptoData) {
    }
    
    @Override
    public void f(final ParsableByteArray parsableByteArray, final int n, final int n2) {
        parsableByteArray.Q(n);
    }
}
