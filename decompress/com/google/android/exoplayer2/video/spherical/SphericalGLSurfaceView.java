// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video.spherical;

import javax.microedition.khronos.egl.EGLConfig;
import android.opengl.GLES20;
import android.view.MotionEvent;
import javax.microedition.khronos.opengles.GL10;
import android.graphics.PointF;
import android.opengl.Matrix;
import i4.a;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import android.hardware.SensorEventListener;
import i4.b;
import java.util.Iterator;
import android.view.View$OnTouchListener;
import android.opengl.GLSurfaceView$Renderer;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Looper;
import android.util.AttributeSet;
import android.content.Context;
import android.view.Surface;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import java.util.concurrent.CopyOnWriteArrayList;
import android.opengl.GLSurfaceView;

public final class SphericalGLSurfaceView extends GLSurfaceView
{
    private final CopyOnWriteArrayList<VideoSurfaceListener> a;
    private final SensorManager b;
    private final Sensor c;
    private final OrientationListener d;
    private final Handler e;
    private final TouchTracker f;
    private final e g;
    private SurfaceTexture h;
    private Surface i;
    private boolean j;
    private boolean p;
    private boolean w;
    
    public SphericalGLSurfaceView(final Context context) {
        this(context, null);
    }
    
    public SphericalGLSurfaceView(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = new CopyOnWriteArrayList<VideoSurfaceListener>();
        this.e = new Handler(Looper.getMainLooper());
        final SensorManager b = Assertions.e(context.getSystemService("sensor"));
        this.b = b;
        Sensor defaultSensor;
        if (Util.a >= 18) {
            defaultSensor = b.getDefaultSensor(15);
        }
        else {
            defaultSensor = null;
        }
        Sensor defaultSensor2 = defaultSensor;
        if (defaultSensor == null) {
            defaultSensor2 = b.getDefaultSensor(11);
        }
        this.c = defaultSensor2;
        final e g = new e();
        this.g = g;
        final a renderer = new a(g);
        final TouchTracker touchTracker = new TouchTracker(context, (TouchTracker.Listener)renderer, 25.0f);
        this.f = touchTracker;
        this.d = new OrientationListener(Assertions.e(context.getSystemService("window")).getDefaultDisplay(), new OrientationListener.Listener[] { touchTracker, renderer });
        this.j = true;
        this.setEGLContextClientVersion(2);
        this.setRenderer((GLSurfaceView$Renderer)renderer);
        this.setOnTouchListener((View$OnTouchListener)touchTracker);
    }
    
    public static void a(final SphericalGLSurfaceView sphericalGLSurfaceView, final SurfaceTexture surfaceTexture) {
        sphericalGLSurfaceView.f(surfaceTexture);
    }
    
    public static void b(final SphericalGLSurfaceView sphericalGLSurfaceView) {
        sphericalGLSurfaceView.e();
    }
    
    static void c(final SphericalGLSurfaceView sphericalGLSurfaceView, final SurfaceTexture surfaceTexture) {
        sphericalGLSurfaceView.g(surfaceTexture);
    }
    
    private void e() {
        final Surface i = this.i;
        if (i != null) {
            final Iterator<VideoSurfaceListener> iterator = this.a.iterator();
            while (iterator.hasNext()) {
                iterator.next().u(i);
            }
        }
        h(this.h, i);
        this.h = null;
        this.i = null;
    }
    
    private void f(final SurfaceTexture h) {
        final SurfaceTexture h2 = this.h;
        final Surface i = this.i;
        final Surface j = new Surface(h);
        this.h = h;
        this.i = j;
        final Iterator<VideoSurfaceListener> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            iterator.next().v(j);
        }
        h(h2, i);
    }
    
    private void g(final SurfaceTexture surfaceTexture) {
        this.e.post((Runnable)new b(this, surfaceTexture));
    }
    
    private static void h(final SurfaceTexture surfaceTexture, final Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }
    
    private void j() {
        final boolean w = this.j && this.p;
        final Sensor c = this.c;
        if (c != null) {
            if (w != this.w) {
                if (w) {
                    this.b.registerListener((SensorEventListener)this.d, c, 0);
                }
                else {
                    this.b.unregisterListener((SensorEventListener)this.d);
                }
                this.w = w;
            }
        }
    }
    
    public void d(final VideoSurfaceListener videoSurfaceListener) {
        this.a.add(videoSurfaceListener);
    }
    
    public CameraMotionListener getCameraMotionListener() {
        return this.g;
    }
    
    public VideoFrameMetadataListener getVideoFrameMetadataListener() {
        return this.g;
    }
    
    public Surface getVideoSurface() {
        return this.i;
    }
    
    public void i(final VideoSurfaceListener videoSurfaceListener) {
        this.a.remove(videoSurfaceListener);
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e.post((Runnable)new i4.a(this));
    }
    
    public void onPause() {
        this.p = false;
        this.j();
        super.onPause();
    }
    
    public void onResume() {
        super.onResume();
        this.p = true;
        this.j();
    }
    
    public void setDefaultStereoMode(final int n) {
        this.g.h(n);
    }
    
    public void setUseSensorRotation(final boolean j) {
        this.j = j;
        this.j();
    }
    
    public interface VideoSurfaceListener
    {
        void u(final Surface p0);
        
        void v(final Surface p0);
    }
    
    final class a implements GLSurfaceView$Renderer, TouchTracker.Listener, OrientationListener.Listener
    {
        private final e a;
        private final float[] b;
        private final float[] c;
        private final float[] d;
        private final float[] e;
        private final float[] f;
        private float g;
        private float h;
        private final float[] i;
        private final float[] j;
        final SphericalGLSurfaceView p;
        
        public a(final SphericalGLSurfaceView p2, final e a) {
            this.p = p2;
            this.b = new float[16];
            this.c = new float[16];
            final float[] d = new float[16];
            this.d = d;
            final float[] e = new float[16];
            this.e = e;
            final float[] f = new float[16];
            this.f = f;
            this.i = new float[16];
            this.j = new float[16];
            this.a = a;
            Matrix.setIdentityM(d, 0);
            Matrix.setIdentityM(e, 0);
            Matrix.setIdentityM(f, 0);
            this.h = 3.1415927f;
        }
        
        private float c(final float n) {
            if (n > 1.0f) {
                return (float)(Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0)) / n)) * 2.0);
            }
            return 90.0f;
        }
        
        private void d() {
            Matrix.setRotateM(this.e, 0, -this.g, (float)Math.cos(this.h), (float)Math.sin(this.h), 0.0f);
        }
        
        public void a(final float[] array, final float n) {
            synchronized (this) {
                final float[] d = this.d;
                System.arraycopy(array, 0, d, 0, d.length);
                this.h = -n;
                this.d();
            }
        }
        
        public void b(final PointF pointF) {
            synchronized (this) {
                this.g = pointF.y;
                this.d();
                Matrix.setRotateM(this.f, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
            }
        }
        
        public void onDrawFrame(final GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.j, 0, this.d, 0, this.f, 0);
                Matrix.multiplyMM(this.i, 0, this.e, 0, this.j, 0);
                monitorexit(this);
                Matrix.multiplyMM(this.c, 0, this.b, 0, this.i, 0);
                this.a.e(this.c, false);
            }
        }
        
        public boolean onSingleTapUp(final MotionEvent motionEvent) {
            return this.p.performClick();
        }
        
        public void onSurfaceChanged(final GL10 gl10, final int n, final int n2) {
            GLES20.glViewport(0, 0, n, n2);
            final float n3 = n / (float)n2;
            Matrix.perspectiveM(this.b, 0, this.c(n3), n3, 0.1f, 100.0f);
        }
        
        public void onSurfaceCreated(final GL10 gl10, final EGLConfig eglConfig) {
            synchronized (this) {
                SphericalGLSurfaceView.c(this.p, this.a.f());
            }
        }
    }
}
