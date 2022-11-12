// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.decoder;

import android.media.MediaCodec$CryptoInfo$Pattern;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import android.media.MediaCodec$CryptoInfo;

public final class CryptoInfo
{
    public byte[] a;
    public byte[] b;
    public int c;
    public int[] d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    private final MediaCodec$CryptoInfo i;
    private final b j;
    
    public CryptoInfo() {
        final MediaCodec$CryptoInfo i = new MediaCodec$CryptoInfo();
        this.i = i;
        final int a = Util.a;
        b j = null;
        if (a >= 24) {
            j = new b(i, null);
        }
        this.j = j;
    }
    
    public MediaCodec$CryptoInfo a() {
        return this.i;
    }
    
    public void b(final int n) {
        if (n == 0) {
            return;
        }
        if (this.d == null) {
            final int[] array = { 0 };
            this.d = array;
            this.i.numBytesOfClearData = array;
        }
        final int[] d = this.d;
        d[0] += n;
    }
    
    public void c(final int n, final int[] array, final int[] array2, final byte[] array3, final byte[] array4, final int n2, final int g, final int h) {
        this.f = n;
        this.d = array;
        this.e = array2;
        this.b = array3;
        this.a = array4;
        this.c = n2;
        this.g = g;
        this.h = h;
        final MediaCodec$CryptoInfo i = this.i;
        i.numSubSamples = n;
        i.numBytesOfClearData = array;
        i.numBytesOfEncryptedData = array2;
        i.key = array3;
        i.iv = array4;
        i.mode = n2;
        if (Util.a >= 24) {
            CryptoInfo.b.a(Assertions.e(this.j), g, h);
        }
    }
    
    private static final class b
    {
        private final MediaCodec$CryptoInfo a;
        private final MediaCodec$CryptoInfo$Pattern b;
        
        private b(final MediaCodec$CryptoInfo a) {
            this.a = a;
            this.b = new MediaCodec$CryptoInfo$Pattern(0, 0);
        }
        
        b(final MediaCodec$CryptoInfo mediaCodec$CryptoInfo, final CryptoInfo$a object) {
            this(mediaCodec$CryptoInfo);
        }
        
        static void a(final b b, final int n, final int n2) {
            b.b(n, n2);
        }
        
        private void b(final int n, final int n2) {
            this.b.set(n, n2);
            this.a.setPattern(this.b);
        }
    }
}
