// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import java.io.IOException;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.util.Assertions;

public final class TrueHdSampleRechunker
{
    private final byte[] a;
    private boolean b;
    private int c;
    private long d;
    private int e;
    private int f;
    private int g;
    
    public TrueHdSampleRechunker() {
        this.a = new byte[10];
    }
    
    public void a(final TrackOutput trackOutput, final TrackOutput.CryptoData cryptoData) {
        if (this.c > 0) {
            trackOutput.e(this.d, this.e, this.f, this.g, cryptoData);
            this.c = 0;
        }
    }
    
    public void b() {
        this.b = false;
        this.c = 0;
    }
    
    public void c(final TrackOutput trackOutput, final long d, final int e, final int n, final int g, final TrackOutput.CryptoData cryptoData) {
        Assertions.h(this.g <= n + g, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (!this.b) {
            return;
        }
        final int c = this.c;
        final int c2 = c + 1;
        this.c = c2;
        if (c == 0) {
            this.d = d;
            this.e = e;
            this.f = 0;
        }
        this.f += n;
        this.g = g;
        if (c2 >= 16) {
            this.a(trackOutput, cryptoData);
        }
    }
    
    public void d(final ExtractorInput extractorInput) throws IOException {
        if (this.b) {
            return;
        }
        extractorInput.r(this.a, 0, 10);
        extractorInput.h();
        if (Ac3Util.i(this.a) == 0) {
            return;
        }
        this.b = true;
    }
}
