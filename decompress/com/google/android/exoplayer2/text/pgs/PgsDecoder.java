// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.text.pgs;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import java.util.Arrays;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Util;
import java.util.zip.Inflater;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;

public final class PgsDecoder extends SimpleSubtitleDecoder
{
    private final ParsableByteArray o;
    private final ParsableByteArray p;
    private final a q;
    private Inflater r;
    
    public PgsDecoder() {
        super("PgsDecoder");
        this.o = new ParsableByteArray();
        this.p = new ParsableByteArray();
        this.q = new a();
    }
    
    private void B(final ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() > 0 && parsableByteArray.h() == 120) {
            if (this.r == null) {
                this.r = new Inflater();
            }
            if (Util.r0(parsableByteArray, this.p, this.r)) {
                parsableByteArray.N(this.p.d(), this.p.f());
            }
        }
    }
    
    private static Cue C(final ParsableByteArray parsableByteArray, final a a) {
        final int f = parsableByteArray.f();
        final int d = parsableByteArray.D();
        final int j = parsableByteArray.J();
        final int n = parsableByteArray.e() + j;
        final Cue cue = null;
        if (n > f) {
            parsableByteArray.P(f);
            return null;
        }
        Cue cue2 = null;
        if (d != 128) {
            switch (d) {
                default: {
                    cue2 = cue;
                    break;
                }
                case 22: {
                    PgsDecoder.a.c(a, parsableByteArray, j);
                    cue2 = cue;
                    break;
                }
                case 21: {
                    PgsDecoder.a.b(a, parsableByteArray, j);
                    cue2 = cue;
                    break;
                }
                case 20: {
                    PgsDecoder.a.a(a, parsableByteArray, j);
                    cue2 = cue;
                    break;
                }
            }
        }
        else {
            final Cue d2 = a.d();
            a.h();
            cue2 = d2;
        }
        parsableByteArray.P(n);
        return cue2;
    }
    
    @Override
    protected Subtitle z(final byte[] array, final int n, final boolean b) throws SubtitleDecoderException {
        this.o.N(array, n);
        this.B(this.o);
        this.q.h();
        final ArrayList list = new ArrayList();
        while (this.o.a() >= 3) {
            final Cue c = C(this.o, this.q);
            if (c != null) {
                list.add(c);
            }
        }
        return new com.google.android.exoplayer2.text.pgs.a((List<Cue>)Collections.unmodifiableList((List<?>)list));
    }
    
    private static final class a
    {
        private final ParsableByteArray a;
        private final int[] b;
        private boolean c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        
        public a() {
            this.a = new ParsableByteArray();
            this.b = new int[256];
        }
        
        static void a(final a a, final ParsableByteArray parsableByteArray, final int n) {
            a.g(parsableByteArray, n);
        }
        
        static void b(final a a, final ParsableByteArray parsableByteArray, final int n) {
            a.e(parsableByteArray, n);
        }
        
        static void c(final a a, final ParsableByteArray parsableByteArray, final int n) {
            a.f(parsableByteArray, n);
        }
        
        private void e(final ParsableByteArray parsableByteArray, int n) {
            if (n < 4) {
                return;
            }
            parsableByteArray.Q(3);
            final boolean b = (parsableByteArray.D() & 0x80) != 0x0;
            final int n2 = n -= 4;
            if (b) {
                if (n2 < 7) {
                    return;
                }
                n = parsableByteArray.G();
                if (n < 4) {
                    return;
                }
                this.h = parsableByteArray.J();
                this.i = parsableByteArray.J();
                this.a.L(n - 4);
                n = n2 - 7;
            }
            final int e = this.a.e();
            final int f = this.a.f();
            if (e < f && n > 0) {
                n = Math.min(n, f - e);
                parsableByteArray.j(this.a.d(), e, n);
                this.a.P(e + n);
            }
        }
        
        private void f(final ParsableByteArray parsableByteArray, final int n) {
            if (n < 19) {
                return;
            }
            this.d = parsableByteArray.J();
            this.e = parsableByteArray.J();
            parsableByteArray.Q(11);
            this.f = parsableByteArray.J();
            this.g = parsableByteArray.J();
        }
        
        private void g(final ParsableByteArray parsableByteArray, int i) {
            if (i % 5 != 2) {
                return;
            }
            parsableByteArray.Q(2);
            Arrays.fill(this.b, 0);
            int n;
            int d;
            int d2;
            int d3;
            int d4;
            int d5;
            double n2;
            double n3;
            int n4;
            double n5;
            for (n = i / 5, i = 0; i < n; ++i) {
                d = parsableByteArray.D();
                d2 = parsableByteArray.D();
                d3 = parsableByteArray.D();
                d4 = parsableByteArray.D();
                d5 = parsableByteArray.D();
                n2 = d2;
                n3 = d3 - 128;
                n4 = (int)(1.402 * n3 + n2);
                n5 = d4 - 128;
                this.b[d] = (Util.q((int)(n2 + n5 * 1.772), 0, 255) | (Util.q((int)(n2 - 0.34414 * n5 - n3 * 0.71414), 0, 255) << 8 | (d5 << 24 | Util.q(n4, 0, 255) << 16)));
            }
            this.c = true;
        }
        
        public Cue d() {
            if (this.d != 0 && this.e != 0 && this.h != 0 && this.i != 0 && this.a.f() != 0 && this.a.e() == this.a.f() && this.c) {
                this.a.P(0);
                final int n = this.h * this.i;
                final int[] array = new int[n];
                int i = 0;
                while (i < n) {
                    final int d = this.a.D();
                    if (d != 0) {
                        final int n2 = i + 1;
                        array[i] = this.b[d];
                        i = n2;
                    }
                    else {
                        final int d2 = this.a.D();
                        if (d2 == 0) {
                            continue;
                        }
                        int n3;
                        if ((d2 & 0x40) == 0x0) {
                            n3 = (d2 & 0x3F);
                        }
                        else {
                            n3 = ((d2 & 0x3F) << 8 | this.a.D());
                        }
                        int n4;
                        if ((d2 & 0x80) == 0x0) {
                            n4 = 0;
                        }
                        else {
                            n4 = this.b[this.a.D()];
                        }
                        final int n5 = n3 + i;
                        Arrays.fill(array, i, n5, n4);
                        i = n5;
                    }
                }
                return new Cue.Builder().f(Bitmap.createBitmap(array, this.h, this.i, Bitmap$Config.ARGB_8888)).k(this.f / (float)this.d).l(0).h(this.g / (float)this.e, 0).i(0).n(this.h / (float)this.d).g(this.i / (float)this.e).a();
            }
            return null;
        }
        
        public void h() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.a.L(0);
            this.c = false;
        }
    }
}
