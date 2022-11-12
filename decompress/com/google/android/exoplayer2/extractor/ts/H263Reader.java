// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Collections;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import java.util.Arrays;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class H263Reader implements ElementaryStreamReader
{
    private static final float[] l;
    private final f a;
    private final ParsableByteArray b;
    private final boolean[] c;
    private final a d;
    private final com.google.android.exoplayer2.extractor.ts.a e;
    private b f;
    private long g;
    private String h;
    private TrackOutput i;
    private boolean j;
    private long k;
    
    static {
        l = new float[] { 1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f };
    }
    
    public H263Reader() {
        this(null);
    }
    
    H263Reader(final f a) {
        this.a = a;
        this.c = new boolean[4];
        this.d = new a(128);
        this.k = -9223372036854775807L;
        if (a != null) {
            this.e = new com.google.android.exoplayer2.extractor.ts.a(178, 128);
            this.b = new ParsableByteArray();
        }
        else {
            this.e = null;
            this.b = null;
        }
    }
    
    private static Format a(final a a, int i, final String s) {
        final byte[] copy = Arrays.copyOf(a.e, a.c);
        final ParsableBitArray parsableBitArray = new ParsableBitArray(copy);
        parsableBitArray.s(i);
        parsableBitArray.s(4);
        parsableBitArray.q();
        parsableBitArray.r(8);
        if (parsableBitArray.g()) {
            parsableBitArray.r(4);
            parsableBitArray.r(3);
        }
        i = parsableBitArray.h(4);
        float n = 1.0f;
        if (i == 15) {
            final int h = parsableBitArray.h(8);
            i = parsableBitArray.h(8);
            if (i == 0) {
                Log.i("H263Reader", "Invalid aspect ratio");
            }
            else {
                n = h / (float)i;
            }
        }
        else {
            final float[] l = H263Reader.l;
            if (i < l.length) {
                n = l[i];
            }
            else {
                Log.i("H263Reader", "Invalid aspect ratio");
            }
        }
        if (parsableBitArray.g()) {
            parsableBitArray.r(2);
            parsableBitArray.r(1);
            if (parsableBitArray.g()) {
                parsableBitArray.r(15);
                parsableBitArray.q();
                parsableBitArray.r(15);
                parsableBitArray.q();
                parsableBitArray.r(15);
                parsableBitArray.q();
                parsableBitArray.r(3);
                parsableBitArray.r(11);
                parsableBitArray.q();
                parsableBitArray.r(15);
                parsableBitArray.q();
            }
        }
        if (parsableBitArray.h(2) != 0) {
            Log.i("H263Reader", "Unhandled video object layer shape");
        }
        parsableBitArray.q();
        i = parsableBitArray.h(16);
        parsableBitArray.q();
        if (parsableBitArray.g()) {
            if (i == 0) {
                Log.i("H263Reader", "Invalid vop_increment_time_resolution");
            }
            else {
                --i;
                int n2 = 0;
                while (i > 0) {
                    ++n2;
                    i >>= 1;
                }
                parsableBitArray.r(n2);
            }
        }
        parsableBitArray.q();
        final int h2 = parsableBitArray.h(13);
        parsableBitArray.q();
        i = parsableBitArray.h(13);
        parsableBitArray.q();
        parsableBitArray.q();
        return new Format.Builder().S(s).e0("video/mp4v-es").j0(h2).Q(i).a0(n).T(Collections.singletonList(copy)).E();
    }
    
    @Override
    public void b(final ParsableByteArray parsableByteArray) {
        Assertions.i(this.f);
        Assertions.i(this.i);
        int e = parsableByteArray.e();
        final int f = parsableByteArray.f();
        final byte[] d = parsableByteArray.d();
        this.g += parsableByteArray.a();
        this.i.c(parsableByteArray, parsableByteArray.a());
        while (true) {
            final int c = NalUnitUtil.c(d, e, f, this.c);
            if (c == f) {
                break;
            }
            final byte[] d2 = parsableByteArray.d();
            final int n = c + 3;
            final int n2 = d2[n] & 0xFF;
            final int n3 = c - e;
            final boolean j = this.j;
            final int n4 = 0;
            if (!j) {
                if (n3 > 0) {
                    this.d.a(d, e, c);
                }
                int n5;
                if (n3 < 0) {
                    n5 = -n3;
                }
                else {
                    n5 = 0;
                }
                if (this.d.b(n2, n5)) {
                    final TrackOutput i = this.i;
                    final a d3 = this.d;
                    i.d(a(d3, d3.d, Assertions.e(this.h)));
                    this.j = true;
                }
            }
            this.f.a(d, e, c);
            final com.google.android.exoplayer2.extractor.ts.a e2 = this.e;
            if (e2 != null) {
                int n6;
                if (n3 > 0) {
                    e2.a(d, e, c);
                    n6 = n4;
                }
                else {
                    n6 = -n3;
                }
                if (this.e.b(n6)) {
                    final com.google.android.exoplayer2.extractor.ts.a e3 = this.e;
                    Util.j(this.b).N(this.e.d, NalUnitUtil.q(e3.d, e3.e));
                    Util.j(this.a).a(this.k, this.b);
                }
                if (n2 == 178 && parsableByteArray.d()[c + 2] == 1) {
                    this.e.e(n2);
                }
            }
            final int n7 = f - c;
            this.f.b(this.g - n7, n7, this.j);
            this.f.c(n2, this.k);
            e = n;
        }
        if (!this.j) {
            this.d.a(d, e, f);
        }
        this.f.a(d, e, f);
        final com.google.android.exoplayer2.extractor.ts.a e4 = this.e;
        if (e4 != null) {
            e4.a(d, e, f);
        }
    }
    
    @Override
    public void c() {
        NalUnitUtil.a(this.c);
        this.d.c();
        final b f = this.f;
        if (f != null) {
            f.d();
        }
        final com.google.android.exoplayer2.extractor.ts.a e = this.e;
        if (e != null) {
            e.d();
        }
        this.g = 0L;
        this.k = -9223372036854775807L;
    }
    
    @Override
    public void d(final ExtractorOutput extractorOutput, final TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.a();
        this.h = trackIdGenerator.b();
        final TrackOutput e = extractorOutput.e(trackIdGenerator.c(), 2);
        this.i = e;
        this.f = new b(e);
        final f a = this.a;
        if (a != null) {
            a.b(extractorOutput, trackIdGenerator);
        }
    }
    
    @Override
    public void e() {
    }
    
    @Override
    public void f(final long k, final int n) {
        if (k != -9223372036854775807L) {
            this.k = k;
        }
    }
    
    private static final class a
    {
        private static final byte[] f;
        private boolean a;
        private int b;
        public int c;
        public int d;
        public byte[] e;
        
        static {
            f = new byte[] { 0, 0, 1 };
        }
        
        public a(final int n) {
            this.e = new byte[n];
        }
        
        public void a(final byte[] array, final int n, int c) {
            if (!this.a) {
                return;
            }
            final int n2 = c - n;
            final byte[] e = this.e;
            final int length = e.length;
            c = this.c;
            if (length < c + n2) {
                this.e = Arrays.copyOf(e, (c + n2) * 2);
            }
            System.arraycopy(array, n, this.e, this.c, n2);
            this.c += n2;
        }
        
        public boolean b(final int n, final int n2) {
            final int b = this.b;
            if (b != 0) {
                if (b != 1) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4) {
                                throw new IllegalStateException();
                            }
                            if (n == 179 || n == 181) {
                                this.c -= n2;
                                this.a = false;
                                return true;
                            }
                        }
                        else if ((n & 0xF0) != 0x20) {
                            Log.i("H263Reader", "Unexpected start code value");
                            this.c();
                        }
                        else {
                            this.d = this.c;
                            this.b = 4;
                        }
                    }
                    else if (n > 31) {
                        Log.i("H263Reader", "Unexpected start code value");
                        this.c();
                    }
                    else {
                        this.b = 3;
                    }
                }
                else if (n != 181) {
                    Log.i("H263Reader", "Unexpected start code value");
                    this.c();
                }
                else {
                    this.b = 2;
                }
            }
            else if (n == 176) {
                this.b = 1;
                this.a = true;
            }
            final byte[] f = H263Reader.a.f;
            this.a(f, 0, f.length);
            return false;
        }
        
        public void c() {
            this.a = false;
            this.c = 0;
            this.b = 0;
        }
    }
    
    private static final class b
    {
        private final TrackOutput a;
        private boolean b;
        private boolean c;
        private boolean d;
        private int e;
        private int f;
        private long g;
        private long h;
        
        public b(final TrackOutput a) {
            this.a = a;
        }
        
        public void a(final byte[] array, final int n, final int n2) {
            if (this.c) {
                final int f = this.f;
                final int n3 = n + 1 - f;
                if (n3 < n2) {
                    this.d = ((array[n3] & 0xC0) >> 6 == 0);
                    this.c = false;
                }
                else {
                    this.f = f + (n2 - n);
                }
            }
        }
        
        public void b(final long g, final int n, final boolean b) {
            if (this.e == 182 && b && this.b) {
                final long h = this.h;
                if (h != -9223372036854775807L) {
                    this.a.e(h, this.d ? 1 : 0, (int)(g - this.g), n, null);
                }
            }
            if (this.e != 179) {
                this.g = g;
            }
        }
        
        public void c(final int e, final long h) {
            this.e = e;
            this.d = false;
            final boolean b = true;
            this.b = (e == 182 || e == 179);
            this.c = (e == 182 && b);
            this.f = 0;
            this.h = h;
        }
        
        public void d() {
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = -1;
        }
    }
}
