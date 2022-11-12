// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.mp4;

import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class h
{
    public c a;
    public long b;
    public long c;
    public long d;
    public int e;
    public int f;
    public long[] g;
    public int[] h;
    public int[] i;
    public long[] j;
    public boolean[] k;
    public boolean l;
    public boolean[] m;
    public TrackEncryptionBox n;
    public final ParsableByteArray o;
    public boolean p;
    public long q;
    public boolean r;
    
    public h() {
        this.g = new long[0];
        this.h = new int[0];
        this.i = new int[0];
        this.j = new long[0];
        this.k = new boolean[0];
        this.m = new boolean[0];
        this.o = new ParsableByteArray();
    }
    
    public void a(final ExtractorInput extractorInput) throws IOException {
        extractorInput.readFully(this.o.d(), 0, this.o.f());
        this.o.P(0);
        this.p = false;
    }
    
    public void b(final ParsableByteArray parsableByteArray) {
        parsableByteArray.j(this.o.d(), 0, this.o.f());
        this.o.P(0);
        this.p = false;
    }
    
    public long c(final int n) {
        return this.j[n];
    }
    
    public void d(final int n) {
        this.o.L(n);
        this.l = true;
        this.p = true;
    }
    
    public void e(int e, final int f) {
        this.e = e;
        this.f = f;
        if (this.h.length < e) {
            this.g = new long[e];
            this.h = new int[e];
        }
        if (this.i.length < f) {
            e = f * 125 / 100;
            this.i = new int[e];
            this.j = new long[e];
            this.k = new boolean[e];
            this.m = new boolean[e];
        }
    }
    
    public void f() {
        this.e = 0;
        this.q = 0L;
        this.r = false;
        this.l = false;
        this.p = false;
        this.n = null;
    }
    
    public boolean g(final int n) {
        return this.l && this.m[n];
    }
}
