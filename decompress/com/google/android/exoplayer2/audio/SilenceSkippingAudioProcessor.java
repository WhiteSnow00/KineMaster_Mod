// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;

public final class SilenceSkippingAudioProcessor extends BaseAudioProcessor
{
    private final long i;
    private final long j;
    private final short k;
    private int l;
    private boolean m;
    private byte[] n;
    private byte[] o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private long t;
    
    public SilenceSkippingAudioProcessor() {
        this(150000L, 20000L, (short)1024);
    }
    
    public SilenceSkippingAudioProcessor(final long i, final long j, final short k) {
        Assertions.a(j <= i);
        this.i = i;
        this.j = j;
        this.k = k;
        final byte[] f = Util.f;
        this.n = f;
        this.o = f;
    }
    
    private int l(final long n) {
        return (int)(n * super.b.a / 1000000L);
    }
    
    private int m(final ByteBuffer byteBuffer) {
        for (int i = byteBuffer.limit() - 2; i >= byteBuffer.position(); i -= 2) {
            if (Math.abs(byteBuffer.getShort(i)) > this.k) {
                final int l = this.l;
                return i / l * l + l;
            }
        }
        return byteBuffer.position();
    }
    
    private int n(final ByteBuffer byteBuffer) {
        for (int i = byteBuffer.position(); i < byteBuffer.limit(); i += 2) {
            if (Math.abs(byteBuffer.getShort(i)) > this.k) {
                final int l = this.l;
                return l * (i / l);
            }
        }
        return byteBuffer.limit();
    }
    
    private void p(final ByteBuffer byteBuffer) {
        final int remaining = byteBuffer.remaining();
        this.k(remaining).put(byteBuffer).flip();
        if (remaining > 0) {
            this.s = true;
        }
    }
    
    private void q(final byte[] array, final int n) {
        this.k(n).put(array, 0, n).flip();
        if (n > 0) {
            this.s = true;
        }
    }
    
    private void r(final ByteBuffer byteBuffer) {
        final int limit = byteBuffer.limit();
        final int n = this.n(byteBuffer);
        final int n2 = n - byteBuffer.position();
        final byte[] n3 = this.n;
        final int length = n3.length;
        final int q = this.q;
        final int n4 = length - q;
        if (n < limit && n2 < n4) {
            this.q(n3, q);
            this.q = 0;
            this.p = 0;
        }
        else {
            final int min = Math.min(n2, n4);
            byteBuffer.limit(byteBuffer.position() + min);
            byteBuffer.get(this.n, this.q, min);
            final int q2 = this.q + min;
            this.q = q2;
            final byte[] n5 = this.n;
            if (q2 == n5.length) {
                if (this.s) {
                    this.q(n5, this.r);
                    this.t += (this.q - this.r * 2) / this.l;
                }
                else {
                    this.t += (q2 - this.r) / this.l;
                }
                this.v(byteBuffer, this.n, this.q);
                this.q = 0;
                this.p = 2;
            }
            byteBuffer.limit(limit);
        }
    }
    
    private void s(final ByteBuffer byteBuffer) {
        final int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.n.length));
        final int m = this.m(byteBuffer);
        if (m == byteBuffer.position()) {
            this.p = 1;
        }
        else {
            byteBuffer.limit(m);
            this.p(byteBuffer);
        }
        byteBuffer.limit(limit);
    }
    
    private void t(final ByteBuffer byteBuffer) {
        final int limit = byteBuffer.limit();
        final int n = this.n(byteBuffer);
        byteBuffer.limit(n);
        this.t += byteBuffer.remaining() / this.l;
        this.v(byteBuffer, this.o, this.r);
        if (n < limit) {
            this.q(this.o, this.r);
            this.p = 0;
            byteBuffer.limit(limit);
        }
    }
    
    private void v(final ByteBuffer byteBuffer, final byte[] array, final int n) {
        final int min = Math.min(byteBuffer.remaining(), this.r);
        final int n2 = this.r - min;
        System.arraycopy(array, n - n2, this.o, 0, n2);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.o, n2, min);
    }
    
    @Override
    public void b(final ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !this.f()) {
            final int p = this.p;
            if (p != 0) {
                if (p != 1) {
                    if (p != 2) {
                        throw new IllegalStateException();
                    }
                    this.t(byteBuffer);
                }
                else {
                    this.r(byteBuffer);
                }
            }
            else {
                this.s(byteBuffer);
            }
        }
    }
    
    public AudioFormat g(AudioFormat e) throws UnhandledAudioFormatException {
        if (e.c == 2) {
            if (!this.m) {
                e = AudioFormat.e;
            }
            return e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(e);
    }
    
    @Override
    protected void h() {
        if (this.m) {
            this.l = super.b.d;
            final int n = this.l(this.i) * this.l;
            if (this.n.length != n) {
                this.n = new byte[n];
            }
            final int r = this.l(this.j) * this.l;
            if (this.o.length != (this.r = r)) {
                this.o = new byte[r];
            }
        }
        this.p = 0;
        this.t = 0L;
        this.q = 0;
        this.s = false;
    }
    
    @Override
    protected void i() {
        final int q = this.q;
        if (q > 0) {
            this.q(this.n, q);
        }
        if (!this.s) {
            this.t += this.r / this.l;
        }
    }
    
    @Override
    public boolean isActive() {
        return this.m;
    }
    
    @Override
    protected void j() {
        this.m = false;
        this.r = 0;
        final byte[] f = Util.f;
        this.n = f;
        this.o = f;
    }
    
    public long o() {
        return this.t;
    }
    
    public void u(final boolean m) {
        this.m = m;
    }
}
