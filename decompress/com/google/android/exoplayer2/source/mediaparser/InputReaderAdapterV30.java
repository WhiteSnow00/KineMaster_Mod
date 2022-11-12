// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.source.mediaparser;

import java.io.IOException;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.upstream.DataReader;
import android.media.MediaParser$SeekableInputReader;

public final class InputReaderAdapterV30 implements MediaParser$SeekableInputReader
{
    private DataReader a;
    private long b;
    private long c;
    private long d;
    
    public long a() {
        final long d = this.d;
        this.d = -1L;
        return d;
    }
    
    public void b(final long c) {
        this.c = c;
    }
    
    public void c(final DataReader a, final long b) {
        this.a = a;
        this.b = b;
        this.d = -1L;
    }
    
    public long getLength() {
        return this.b;
    }
    
    public long getPosition() {
        return this.c;
    }
    
    public int read(final byte[] array, int read, final int n) throws IOException {
        read = Util.j(this.a).read(array, read, n);
        this.c += read;
        return read;
    }
    
    public void seekToPosition(final long d) {
        this.d = d;
    }
}
