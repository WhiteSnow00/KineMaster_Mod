// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import com.google.android.exoplayer2.util.Util;

final class r extends BaseAudioProcessor
{
    private int i;
    private int j;
    private boolean k;
    private int l;
    private byte[] m;
    private int n;
    private long o;
    
    public r() {
        this.m = Util.f;
    }
    
    @Override
    public ByteBuffer a() {
        if (super.c()) {
            final int n = this.n;
            if (n > 0) {
                this.k(n).put(this.m, 0, this.n).flip();
                this.n = 0;
            }
        }
        return super.a();
    }
    
    @Override
    public void b(final ByteBuffer byteBuffer) {
        final int position = byteBuffer.position();
        final int limit = byteBuffer.limit();
        final int n = limit - position;
        if (n == 0) {
            return;
        }
        final int min = Math.min(n, this.l);
        this.o += min / super.b.d;
        this.l -= min;
        byteBuffer.position(position + min);
        if (this.l > 0) {
            return;
        }
        final int n2 = n - min;
        final int n3 = this.n + n2 - this.m.length;
        final ByteBuffer k = this.k(n3);
        final int q = Util.q(n3, 0, this.n);
        k.put(this.m, 0, q);
        final int q2 = Util.q(n3 - q, 0, n2);
        byteBuffer.limit(byteBuffer.position() + q2);
        k.put(byteBuffer);
        byteBuffer.limit(limit);
        final int n4 = n2 - q2;
        final int n5 = this.n - q;
        this.n = n5;
        final byte[] m = this.m;
        System.arraycopy(m, q, m, 0, n5);
        byteBuffer.get(this.m, this.n, n4);
        this.n += n4;
        k.flip();
    }
    
    @Override
    public boolean c() {
        return super.c() && this.n == 0;
    }
    
    public AudioFormat g(final AudioFormat audioFormat) throws UnhandledAudioFormatException {
        if (audioFormat.c == 2) {
            this.k = true;
            Object e = audioFormat;
            if (this.i == 0) {
                if (this.j != 0) {
                    e = audioFormat;
                }
                else {
                    e = AudioFormat.e;
                }
            }
            return (AudioFormat)e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }
    
    @Override
    protected void h() {
        if (this.k) {
            this.k = false;
            final int j = this.j;
            final int d = super.b.d;
            this.m = new byte[j * d];
            this.l = this.i * d;
        }
        this.n = 0;
    }
    
    @Override
    protected void i() {
        if (this.k) {
            final int n = this.n;
            if (n > 0) {
                this.o += n / super.b.d;
            }
            this.n = 0;
        }
    }
    
    @Override
    protected void j() {
        this.m = Util.f;
    }
    
    public long l() {
        return this.o;
    }
    
    public void m() {
        this.o = 0L;
    }
    
    public void n(final int i, final int j) {
        this.i = i;
        this.j = j;
    }
}
