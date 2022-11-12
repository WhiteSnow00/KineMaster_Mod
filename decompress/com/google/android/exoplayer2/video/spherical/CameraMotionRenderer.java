// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.BaseRenderer;

public final class CameraMotionRenderer extends BaseRenderer
{
    private long A;
    private CameraMotionListener B;
    private long C;
    private final DecoderInputBuffer y;
    private final ParsableByteArray z;
    
    public CameraMotionRenderer() {
        super(6);
        this.y = new DecoderInputBuffer(1);
        this.z = new ParsableByteArray();
    }
    
    private float[] X(final ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.z.N(byteBuffer.array(), byteBuffer.limit());
        this.z.P(byteBuffer.arrayOffset() + 4);
        final float[] array = new float[3];
        for (int i = 0; i < 3; ++i) {
            array[i] = Float.intBitsToFloat(this.z.q());
        }
        return array;
    }
    
    private void Y() {
        final CameraMotionListener b = this.B;
        if (b != null) {
            b.d();
        }
    }
    
    @Override
    public void A(final long n, final long n2) {
        while (!this.h() && this.C < 100000L + n) {
            this.y.h();
            if (this.U(this.I(), this.y, 0) != -4) {
                break;
            }
            if (this.y.n()) {
                break;
            }
            final DecoderInputBuffer y = this.y;
            this.C = y.f;
            if (this.B == null) {
                continue;
            }
            if (y.m()) {
                continue;
            }
            this.y.t();
            final float[] x = this.X(Util.j(this.y.d));
            if (x == null) {
                continue;
            }
            Util.j(this.B).b(this.C - this.A, x);
        }
    }
    
    @Override
    protected void N() {
        this.Y();
    }
    
    @Override
    protected void P(final long n, final boolean b) {
        this.C = Long.MIN_VALUE;
        this.Y();
    }
    
    @Override
    protected void T(final Format[] array, final long n, final long a) {
        this.A = a;
    }
    
    @Override
    public int a(final Format format) {
        int n;
        if ("application/x-camera-motion".equals(format.w)) {
            n = RendererCapabilities.o(4);
        }
        else {
            n = RendererCapabilities.o(0);
        }
        return n;
    }
    
    @Override
    public boolean c() {
        return this.h();
    }
    
    @Override
    public String getName() {
        return "CameraMotionRenderer";
    }
    
    @Override
    public boolean isReady() {
        return true;
    }
    
    @Override
    public void p(final int n, final Object o) throws ExoPlaybackException {
        if (n == 8) {
            this.B = (CameraMotionListener)o;
        }
        else {
            super.p(n, o);
        }
    }
}
