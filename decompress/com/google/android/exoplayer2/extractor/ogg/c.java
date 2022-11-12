// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ogg;

import java.util.Arrays;
import java.io.IOException;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class c
{
    private final d a;
    private final ParsableByteArray b;
    private int c;
    private int d;
    private boolean e;
    
    c() {
        this.a = new d();
        this.b = new ParsableByteArray(new byte[65025], 0);
        this.c = -1;
    }
    
    private int a(final int n) {
        int n2 = 0;
        this.d = 0;
        int i;
        int n3;
        do {
            final int d = this.d;
            final d a = this.a;
            n3 = n2;
            if (n + d >= a.g) {
                break;
            }
            final int[] j = a.j;
            this.d = d + 1;
            i = j[d + n];
            n3 = (n2 += i);
        } while (i == 255);
        return n3;
    }
    
    public d b() {
        return this.a;
    }
    
    public ParsableByteArray c() {
        return this.b;
    }
    
    public boolean d(final ExtractorInput extractorInput) throws IOException {
        Assertions.g(extractorInput != null);
        if (this.e) {
            this.e = false;
            this.b.L(0);
        }
        while (!this.e) {
            if (this.c < 0) {
                if (!this.a.c(extractorInput) || !this.a.a(extractorInput, true)) {
                    return false;
                }
                final d a = this.a;
                int h = a.h;
                int c;
                if ((a.b & 0x1) == 0x1 && this.b.f() == 0) {
                    h += this.a(0);
                    c = this.d + 0;
                }
                else {
                    c = 0;
                }
                if (!ExtractorUtil.e(extractorInput, h)) {
                    return false;
                }
                this.c = c;
            }
            final int a2 = this.a(this.c);
            final int n = this.c + this.d;
            if (a2 > 0) {
                final ParsableByteArray b = this.b;
                b.c(b.f() + a2);
                if (!ExtractorUtil.d(extractorInput, this.b.d(), this.b.f(), a2)) {
                    return false;
                }
                final ParsableByteArray b2 = this.b;
                b2.O(b2.f() + a2);
                this.e = (this.a.j[n - 1] != 255);
            }
            int c2;
            if ((c2 = n) == this.a.g) {
                c2 = -1;
            }
            this.c = c2;
        }
        return true;
    }
    
    public void e() {
        this.a.b();
        this.b.L(0);
        this.c = -1;
        this.e = false;
    }
    
    public void f() {
        if (this.b.d().length == 65025) {
            return;
        }
        final ParsableByteArray b = this.b;
        b.N(Arrays.copyOf(b.d(), Math.max(65025, this.b.f())), this.b.f());
    }
}
