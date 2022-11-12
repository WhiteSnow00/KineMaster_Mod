// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor.ogg;

import java.io.IOException;
import com.google.common.collect.ImmutableList;
import java.util.List;
import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.ParserException;
import java.util.Arrays;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.extractor.VorbisUtil;

final class h extends g
{
    private a n;
    private int o;
    private boolean p;
    private VorbisUtil.VorbisIdHeader q;
    private VorbisUtil.CommentHeader r;
    
    static void n(final ParsableByteArray parsableByteArray, final long n) {
        if (parsableByteArray.b() < parsableByteArray.f() + 4) {
            parsableByteArray.M(Arrays.copyOf(parsableByteArray.d(), parsableByteArray.f() + 4));
        }
        else {
            parsableByteArray.O(parsableByteArray.f() + 4);
        }
        final byte[] d = parsableByteArray.d();
        d[parsableByteArray.f() - 4] = (byte)(n & 0xFFL);
        d[parsableByteArray.f() - 3] = (byte)(n >>> 8 & 0xFFL);
        d[parsableByteArray.f() - 2] = (byte)(n >>> 16 & 0xFFL);
        d[parsableByteArray.f() - 1] = (byte)(n >>> 24 & 0xFFL);
    }
    
    private static int o(final byte b, final a a) {
        int n;
        if (!a.d[p(b, a.e, 1)].a) {
            n = a.a.g;
        }
        else {
            n = a.a.h;
        }
        return n;
    }
    
    static int p(final byte b, final int n, final int n2) {
        return b >> n2 & 255 >>> 8 - n;
    }
    
    public static boolean r(final ParsableByteArray parsableByteArray) {
        try {
            return VorbisUtil.m(1, parsableByteArray, true);
        }
        catch (final ParserException ex) {
            return false;
        }
    }
    
    @Override
    protected void e(final long n) {
        super.e(n);
        int g = 0;
        this.p = (n != 0L);
        final VorbisUtil.VorbisIdHeader q = this.q;
        if (q != null) {
            g = q.g;
        }
        this.o = g;
    }
    
    @Override
    protected long f(final ParsableByteArray parsableByteArray) {
        final byte[] d = parsableByteArray.d();
        int n = 0;
        if ((d[0] & 0x1) == 0x1) {
            return -1L;
        }
        final int o = o(parsableByteArray.d()[0], Assertions.i(this.n));
        if (this.p) {
            n = (this.o + o) / 4;
        }
        final long n2 = n;
        n(parsableByteArray, n2);
        this.p = true;
        this.o = o;
        return n2;
    }
    
    @Override
    protected boolean i(final ParsableByteArray parsableByteArray, final long n, final b b) throws IOException {
        if (this.n != null) {
            Assertions.e(b.a);
            return false;
        }
        final a q = this.q(parsableByteArray);
        if ((this.n = q) == null) {
            return true;
        }
        final VorbisUtil.VorbisIdHeader a = q.a;
        final ArrayList list = new ArrayList();
        list.add(a.j);
        list.add(q.c);
        b.a = new Format.Builder().e0("audio/vorbis").G(a.e).Z(a.d).H(a.b).f0(a.c).T(list).X(VorbisUtil.c((List<String>)ImmutableList.copyOf((Object[])q.b.b))).E();
        return true;
    }
    
    @Override
    protected void l(final boolean b) {
        super.l(b);
        if (b) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }
    
    a q(final ParsableByteArray parsableByteArray) throws IOException {
        final VorbisUtil.VorbisIdHeader q = this.q;
        if (q == null) {
            this.q = VorbisUtil.k(parsableByteArray);
            return null;
        }
        final VorbisUtil.CommentHeader r = this.r;
        if (r == null) {
            this.r = VorbisUtil.i(parsableByteArray);
            return null;
        }
        final byte[] array = new byte[parsableByteArray.f()];
        System.arraycopy(parsableByteArray.d(), 0, array, 0, parsableByteArray.f());
        final VorbisUtil.Mode[] l = VorbisUtil.l(parsableByteArray, q.b);
        return new a(q, r, array, l, VorbisUtil.a(l.length - 1));
    }
    
    static final class a
    {
        public final VorbisUtil.VorbisIdHeader a;
        public final VorbisUtil.CommentHeader b;
        public final byte[] c;
        public final VorbisUtil.Mode[] d;
        public final int e;
        
        public a(final VorbisUtil.VorbisIdHeader a, final VorbisUtil.CommentHeader b, final byte[] c, final VorbisUtil.Mode[] d, final int e) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
        }
    }
}
