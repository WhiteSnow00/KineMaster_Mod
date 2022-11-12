// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video.spherical;

import android.graphics.SurfaceTexture$OnFrameAvailableListener;
import android.opengl.Matrix;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import android.opengl.GLES20;
import android.media.MediaFormat;
import com.google.android.exoplayer2.Format;
import java.util.Arrays;
import android.graphics.SurfaceTexture;
import com.google.android.exoplayer2.util.TimedValueQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;

final class e implements VideoFrameMetadataListener, CameraMotionListener
{
    private final AtomicBoolean a;
    private final AtomicBoolean b;
    private final c c;
    private final a d;
    private final TimedValueQueue<Long> e;
    private final TimedValueQueue<Projection> f;
    private final float[] g;
    private final float[] h;
    private int i;
    private SurfaceTexture j;
    private volatile int p;
    private int w;
    private byte[] x;
    
    public e() {
        this.a = new AtomicBoolean();
        this.b = new AtomicBoolean(true);
        this.c = new c();
        this.d = new a();
        this.e = new TimedValueQueue<Long>();
        this.f = new TimedValueQueue<Projection>();
        this.g = new float[16];
        this.h = new float[16];
        this.p = 0;
        this.w = -1;
    }
    
    public static void c(final e e, final SurfaceTexture surfaceTexture) {
        e.g(surfaceTexture);
    }
    
    private void g(final SurfaceTexture surfaceTexture) {
        this.a.set(true);
    }
    
    private void i(final byte[] x, final int n, final long n2) {
        final byte[] x2 = this.x;
        final int w = this.w;
        this.x = x;
        int p3 = n;
        if (n == -1) {
            p3 = this.p;
        }
        this.w = p3;
        if (w == p3 && Arrays.equals(x2, this.x)) {
            return;
        }
        Projection projection = null;
        final byte[] x3 = this.x;
        if (x3 != null) {
            projection = com.google.android.exoplayer2.video.spherical.b.a(x3, this.w);
        }
        if (projection == null || !com.google.android.exoplayer2.video.spherical.c.c(projection)) {
            projection = Projection.b(this.w);
        }
        this.f.a(n2, projection);
    }
    
    @Override
    public void a(final long n, final long n2, final Format format, final MediaFormat mediaFormat) {
        this.e.a(n2, n);
        this.i(format.G, format.H, n2);
    }
    
    @Override
    public void b(final long n, final float[] array) {
        this.d.e(n, array);
    }
    
    @Override
    public void d() {
        this.e.c();
        this.d.d();
        this.b.set(true);
    }
    
    public void e(final float[] array, final boolean b) {
        GLES20.glClear(16384);
        GlUtil.c();
        if (this.a.compareAndSet(true, false)) {
            Assertions.e(this.j).updateTexImage();
            GlUtil.c();
            if (this.b.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.g, 0);
            }
            final long timestamp = this.j.getTimestamp();
            final Long n = this.e.g(timestamp);
            if (n != null) {
                this.d.c(this.g, n);
            }
            final Projection projection = this.f.j(timestamp);
            if (projection != null) {
                this.c.d(projection);
            }
        }
        Matrix.multiplyMM(this.h, 0, array, 0, this.g, 0);
        this.c.a(this.i, this.h, b);
    }
    
    public SurfaceTexture f() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        GlUtil.c();
        this.c.b();
        GlUtil.c();
        this.i = GlUtil.f();
        (this.j = new SurfaceTexture(this.i)).setOnFrameAvailableListener((SurfaceTexture$OnFrameAvailableListener)new d(this));
        return this.j;
    }
    
    public void h(final int p) {
        this.p = p;
    }
}
