// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.nio.ByteBuffer;

public final class SonicAudioProcessor implements AudioProcessor
{
    private int b;
    private float c;
    private float d;
    private AudioFormat e;
    private AudioFormat f;
    private AudioFormat g;
    private AudioFormat h;
    private boolean i;
    private q j;
    private ByteBuffer k;
    private ShortBuffer l;
    private ByteBuffer m;
    private long n;
    private long o;
    private boolean p;
    
    public SonicAudioProcessor() {
        this.c = 1.0f;
        this.d = 1.0f;
        final AudioFormat e = AudioFormat.e;
        this.e = e;
        this.f = e;
        this.g = e;
        this.h = e;
        final ByteBuffer a = AudioProcessor.a;
        this.k = a;
        this.l = a.asShortBuffer();
        this.m = a;
        this.b = -1;
    }
    
    @Override
    public ByteBuffer a() {
        final q j = this.j;
        if (j != null) {
            final int k = j.k();
            if (k > 0) {
                if (this.k.capacity() < k) {
                    final ByteBuffer order = ByteBuffer.allocateDirect(k).order(ByteOrder.nativeOrder());
                    this.k = order;
                    this.l = order.asShortBuffer();
                }
                else {
                    this.k.clear();
                    this.l.clear();
                }
                j.j(this.l);
                this.o += k;
                this.k.limit(k);
                this.m = this.k;
            }
        }
        final ByteBuffer m = this.m;
        this.m = AudioProcessor.a;
        return m;
    }
    
    @Override
    public void b(final ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        final q q = Assertions.e(this.j);
        final ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        final int remaining = byteBuffer.remaining();
        this.n += remaining;
        q.t(shortBuffer);
        byteBuffer.position(byteBuffer.position() + remaining);
    }
    
    @Override
    public boolean c() {
        if (this.p) {
            final q j = this.j;
            if (j == null || j.k() == 0) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public AudioFormat d(final AudioFormat e) throws UnhandledAudioFormatException {
        if (e.c == 2) {
            int n;
            if ((n = this.b) == -1) {
                n = e.a;
            }
            this.e = e;
            final AudioFormat f = new AudioFormat(n, e.b, 2);
            this.f = f;
            this.i = true;
            return f;
        }
        throw new UnhandledAudioFormatException(e);
    }
    
    @Override
    public void e() {
        final q j = this.j;
        if (j != null) {
            j.s();
        }
        this.p = true;
    }
    
    public long f(long n) {
        if (this.o >= 1024L) {
            final long n2 = this.n - Assertions.e(this.j).l();
            final int a = this.h.a;
            final int a2 = this.g.a;
            if (a == a2) {
                n = Util.O0(n, n2, this.o);
            }
            else {
                n = Util.O0(n, n2 * a, this.o * a2);
            }
            return n;
        }
        return (long)(this.c * (double)n);
    }
    
    @Override
    public void flush() {
        if (this.isActive()) {
            final AudioFormat e = this.e;
            this.g = e;
            final AudioFormat f = this.f;
            this.h = f;
            if (this.i) {
                this.j = new q(e.a, e.b, this.c, this.d, f.a);
            }
            else {
                final q j = this.j;
                if (j != null) {
                    j.i();
                }
            }
        }
        this.m = AudioProcessor.a;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }
    
    public void g(final float d) {
        if (this.d != d) {
            this.d = d;
            this.i = true;
        }
    }
    
    public void h(final float c) {
        if (this.c != c) {
            this.c = c;
            this.i = true;
        }
    }
    
    @Override
    public boolean isActive() {
        return this.f.a != -1 && (Math.abs(this.c - 1.0f) >= 1.0E-4f || Math.abs(this.d - 1.0f) >= 1.0E-4f || this.f.a != this.e.a);
    }
    
    @Override
    public void reset() {
        this.c = 1.0f;
        this.d = 1.0f;
        final AudioFormat e = AudioFormat.e;
        this.e = e;
        this.f = e;
        this.g = e;
        this.h = e;
        final ByteBuffer a = AudioProcessor.a;
        this.k = a;
        this.l = a.asShortBuffer();
        this.m = a;
        this.b = -1;
        this.i = false;
        this.j = null;
        this.n = 0L;
        this.o = 0L;
        this.p = false;
    }
}
