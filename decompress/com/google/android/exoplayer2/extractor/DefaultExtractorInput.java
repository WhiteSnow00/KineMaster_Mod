// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.extractor;

import java.io.IOException;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.upstream.DataReader;

public final class DefaultExtractorInput implements ExtractorInput
{
    private final byte[] a;
    private final DataReader b;
    private final long c;
    private long d;
    private byte[] e;
    private int f;
    private int g;
    
    static {
        ExoPlayerLibraryInfo.a("goog.exo.extractor");
    }
    
    public DefaultExtractorInput(final DataReader b, final long d, final long c) {
        this.b = b;
        this.d = d;
        this.c = c;
        this.e = new byte[65536];
        this.a = new byte[4096];
    }
    
    private void j(final int n) {
        if (n != -1) {
            this.d += n;
        }
    }
    
    private void s(int q) {
        q += this.f;
        final byte[] e = this.e;
        if (q > e.length) {
            q = Util.q(e.length * 2, 65536 + q, q + 524288);
            this.e = Arrays.copyOf(this.e, q);
        }
    }
    
    private int t(final byte[] array, final int n, int min) {
        final int g = this.g;
        if (g == 0) {
            return 0;
        }
        min = Math.min(g, min);
        System.arraycopy(this.e, 0, array, n, min);
        this.x(min);
        return min;
    }
    
    private int u(final byte[] array, int read, final int n, final int n2, final boolean b) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        read = this.b.read(array, read + n2, n - n2);
        if (read != -1) {
            return n2 + read;
        }
        if (n2 == 0 && b) {
            return -1;
        }
        throw new EOFException();
    }
    
    private int v(int min) {
        min = Math.min(this.g, min);
        this.x(min);
        return min;
    }
    
    private void x(final int n) {
        final int g = this.g - n;
        this.g = g;
        this.f = 0;
        final byte[] e = this.e;
        byte[] e2;
        if (g < e.length - 524288) {
            e2 = new byte[65536 + g];
        }
        else {
            e2 = e;
        }
        System.arraycopy(e, n, e2, 0, g);
        this.e = e2;
    }
    
    @Override
    public int a(final int n) throws IOException {
        int n2;
        if ((n2 = this.v(n)) == 0) {
            final byte[] a = this.a;
            n2 = this.u(a, 0, Math.min(n, a.length), 0, true);
        }
        this.j(n2);
        return n2;
    }
    
    @Override
    public boolean f(final byte[] array, final int n, final int n2, final boolean b) throws IOException {
        if (!this.p(n2, b)) {
            return false;
        }
        System.arraycopy(this.e, this.f - n2, array, n, n2);
        return true;
    }
    
    @Override
    public long getLength() {
        return this.c;
    }
    
    @Override
    public long getPosition() {
        return this.d;
    }
    
    @Override
    public void h() {
        this.f = 0;
    }
    
    @Override
    public boolean i(final byte[] array, final int n, final int n2, final boolean b) throws IOException {
        int n3;
        for (n3 = this.t(array, n, n2); n3 < n2 && n3 != -1; n3 = this.u(array, n, n2, n3, b)) {}
        this.j(n3);
        return n3 != -1;
    }
    
    @Override
    public long k() {
        return this.d + this.f;
    }
    
    @Override
    public void m(final int n) throws IOException {
        this.p(n, false);
    }
    
    @Override
    public int n(final byte[] array, final int n, int n2) throws IOException {
        this.s(n2);
        final int g = this.g;
        final int f = this.f;
        final int n3 = g - f;
        if (n3 == 0) {
            n2 = this.u(this.e, f, n2, 0, true);
            if (n2 == -1) {
                return -1;
            }
            this.g += n2;
        }
        else {
            n2 = Math.min(n2, n3);
        }
        System.arraycopy(this.e, this.f, array, n, n2);
        this.f += n2;
        return n2;
    }
    
    @Override
    public void o(final int n) throws IOException {
        this.w(n, false);
    }
    
    @Override
    public boolean p(final int n, final boolean b) throws IOException {
        this.s(n);
        int i = this.g - this.f;
        while (i < n) {
            i = this.u(this.e, this.f, n, i, b);
            if (i == -1) {
                return false;
            }
            this.g = this.f + i;
        }
        this.f += n;
        return true;
    }
    
    @Override
    public void r(final byte[] array, final int n, final int n2) throws IOException {
        this.f(array, n, n2, false);
    }
    
    @Override
    public int read(final byte[] array, final int n, final int n2) throws IOException {
        int n3;
        if ((n3 = this.t(array, n, n2)) == 0) {
            n3 = this.u(array, n, n2, 0, true);
        }
        this.j(n3);
        return n3;
    }
    
    @Override
    public void readFully(final byte[] array, final int n, final int n2) throws IOException {
        this.i(array, n, n2, false);
    }
    
    public boolean w(final int n, final boolean b) throws IOException {
        int n2;
        for (n2 = this.v(n); n2 < n && n2 != -1; n2 = this.u(this.a, -n2, Math.min(n, this.a.length + n2), n2, b)) {}
        this.j(n2);
        return n2 != -1;
    }
}
