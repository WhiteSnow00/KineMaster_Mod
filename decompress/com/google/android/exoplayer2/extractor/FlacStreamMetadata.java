// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import java.util.List;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.metadata.Metadata;

public final class FlacStreamMetadata
{
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;
    public final long j;
    public final SeekTable k;
    private final Metadata l;
    
    private FlacStreamMetadata(final int a, final int b, final int c, final int d, final int e, final int g, final int h, final long j, final SeekTable k, final Metadata l) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = j(e);
        this.g = g;
        this.h = h;
        this.i = e(h);
        this.j = j;
        this.k = k;
        this.l = l;
    }
    
    public FlacStreamMetadata(final byte[] array, int h) {
        final ParsableBitArray parsableBitArray = new ParsableBitArray(array);
        parsableBitArray.p(h * 8);
        this.a = parsableBitArray.h(16);
        this.b = parsableBitArray.h(16);
        this.c = parsableBitArray.h(24);
        this.d = parsableBitArray.h(24);
        h = parsableBitArray.h(20);
        this.e = h;
        this.f = j(h);
        this.g = parsableBitArray.h(3) + 1;
        h = parsableBitArray.h(5) + 1;
        this.h = h;
        this.i = e(h);
        this.j = parsableBitArray.j(36);
        this.k = null;
        this.l = null;
    }
    
    private static int e(final int n) {
        if (n == 8) {
            return 1;
        }
        if (n == 12) {
            return 2;
        }
        if (n == 16) {
            return 4;
        }
        if (n == 20) {
            return 5;
        }
        if (n != 24) {
            return -1;
        }
        return 6;
    }
    
    private static int j(final int n) {
        switch (n) {
            default: {
                return -1;
            }
            case 192000: {
                return 3;
            }
            case 176400: {
                return 2;
            }
            case 96000: {
                return 11;
            }
            case 88200: {
                return 1;
            }
            case 48000: {
                return 10;
            }
            case 44100: {
                return 9;
            }
            case 32000: {
                return 8;
            }
            case 24000: {
                return 7;
            }
            case 22050: {
                return 6;
            }
            case 16000: {
                return 5;
            }
            case 8000: {
                return 4;
            }
        }
    }
    
    public FlacStreamMetadata a(final List<PictureFrame> list) {
        return new FlacStreamMetadata(this.a, this.b, this.c, this.d, this.e, this.g, this.h, this.j, this.k, this.h(new Metadata((List<? extends Metadata.Entry>)list)));
    }
    
    public FlacStreamMetadata b(final SeekTable seekTable) {
        return new FlacStreamMetadata(this.a, this.b, this.c, this.d, this.e, this.g, this.h, this.j, seekTable, this.l);
    }
    
    public FlacStreamMetadata c(final List<String> list) {
        return new FlacStreamMetadata(this.a, this.b, this.c, this.d, this.e, this.g, this.h, this.j, this.k, this.h(VorbisUtil.c(list)));
    }
    
    public long d() {
        final int d = this.d;
        long n;
        long n2;
        if (d > 0) {
            n = (d + (long)this.c) / 2L;
            n2 = 1L;
        }
        else {
            final int a = this.a;
            long n3;
            if (a == this.b && a > 0) {
                n3 = a;
            }
            else {
                n3 = 4096L;
            }
            n = n3 * this.g * this.h / 8L;
            n2 = 64L;
        }
        return n + n2;
    }
    
    public long f() {
        final long j = this.j;
        long n;
        if (j == 0L) {
            n = -9223372036854775807L;
        }
        else {
            n = j * 1000000L / this.e;
        }
        return n;
    }
    
    public Format g(final byte[] array, Metadata h) {
        array[4] = -128;
        int d = this.d;
        if (d <= 0) {
            d = -1;
        }
        h = this.h(h);
        return new Format.Builder().e0("audio/flac").W(d).H(this.g).f0(this.e).T(Collections.singletonList(array)).X(h).E();
    }
    
    public Metadata h(Metadata b) {
        final Metadata l = this.l;
        if (l != null) {
            b = l.b(b);
        }
        return b;
    }
    
    public long i(final long n) {
        return Util.r(n * this.e / 1000000L, 0L, this.j - 1L);
    }
    
    public static class SeekTable
    {
        public final long[] a;
        public final long[] b;
        
        public SeekTable(final long[] a, final long[] b) {
            this.a = a;
            this.b = b;
        }
    }
}
