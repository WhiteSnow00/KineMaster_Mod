// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.avi;

import java.io.IOException;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.extractor.SeekMap;
import java.util.Arrays;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.TrackOutput;

final class d
{
    protected final TrackOutput a;
    private final int b;
    private final int c;
    private final long d;
    private final int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long[] k;
    private int[] l;
    
    public d(int d, final int n, final long d2, int e, final TrackOutput a) {
        boolean b = true;
        if (n != 1) {
            b = (n == 2 && b);
        }
        Assertions.a(b);
        this.d = d2;
        this.e = e;
        this.a = a;
        if (n == 2) {
            e = 1667497984;
        }
        else {
            e = 1651965952;
        }
        this.b = d(d, e);
        if (n == 2) {
            d = d(d, 1650720768);
        }
        else {
            d = -1;
        }
        this.c = d;
        this.k = new long[512];
        this.l = new int[512];
    }
    
    private static int d(final int n, final int n2) {
        return n % 10 + 48 << 8 | n / 10 + 48 | n2;
    }
    
    private long e(final int n) {
        return this.d * n / this.e;
    }
    
    private SeekPoint h(final int n) {
        return new SeekPoint(this.l[n] * this.g(), this.k[n]);
    }
    
    public void a() {
        ++this.h;
    }
    
    public void b(final long n) {
        if (this.j == this.l.length) {
            final long[] k = this.k;
            this.k = Arrays.copyOf(k, k.length * 3 / 2);
            final int[] l = this.l;
            this.l = Arrays.copyOf(l, l.length * 3 / 2);
        }
        final long[] i = this.k;
        final int j = this.j;
        i[j] = n;
        this.l[j] = this.i;
        this.j = j + 1;
    }
    
    public void c() {
        this.k = Arrays.copyOf(this.k, this.j);
        this.l = Arrays.copyOf(this.l, this.j);
    }
    
    public long f() {
        return this.e(this.h);
    }
    
    public long g() {
        return this.e(1);
    }
    
    public SeekMap.SeekPoints i(final long n) {
        final int n2 = (int)(n / this.g());
        final int h = Util.h(this.l, n2, true, true);
        if (this.l[h] == n2) {
            return new SeekMap.SeekPoints(this.h(h));
        }
        final SeekPoint h2 = this.h(h);
        final int n3 = h + 1;
        if (n3 < this.k.length) {
            return new SeekMap.SeekPoints(h2, this.h(n3));
        }
        return new SeekMap.SeekPoints(h2);
    }
    
    public boolean j(final int n) {
        return this.b == n || this.c == n;
    }
    
    public void k() {
        ++this.i;
    }
    
    public boolean l() {
        return Arrays.binarySearch(this.l, this.h) >= 0;
    }
    
    public boolean m(final ExtractorInput extractorInput) throws IOException {
        final int g = this.g;
        final TrackOutput a = this.a;
        boolean b = false;
        final int g2 = g - a.b(extractorInput, g, false);
        this.g = g2;
        if (g2 == 0) {
            b = true;
        }
        if (b) {
            if (this.f > 0) {
                this.a.e(this.f(), this.l() ? 1 : 0, this.f, 0, null);
            }
            this.a();
        }
        return b;
    }
    
    public void n(final int n) {
        this.f = n;
        this.g = n;
    }
    
    public void o(final long n) {
        if (this.j == 0) {
            this.h = 0;
        }
        else {
            this.h = this.l[Util.i(this.k, n, true, true)];
        }
    }
}
