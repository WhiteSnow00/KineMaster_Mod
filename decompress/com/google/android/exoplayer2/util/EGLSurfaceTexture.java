// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.opengl.GLES20;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.graphics.SurfaceTexture;
import android.opengl.EGLSurface;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.os.Handler;
import android.graphics.SurfaceTexture$OnFrameAvailableListener;

public final class EGLSurfaceTexture implements SurfaceTexture$OnFrameAvailableListener, Runnable
{
    private static final int[] h;
    private final Handler a;
    private final int[] b;
    private final TextureImageListener c;
    private EGLDisplay d;
    private EGLContext e;
    private EGLSurface f;
    private SurfaceTexture g;
    
    static {
        h = new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344 };
    }
    
    public EGLSurfaceTexture(final Handler handler) {
        this(handler, null);
    }
    
    public EGLSurfaceTexture(final Handler a, final TextureImageListener c) {
        this.a = a;
        this.c = c;
        this.b = new int[1];
    }
    
    private static EGLConfig a(final EGLDisplay eglDisplay) {
        final EGLConfig[] array = { null };
        final int[] array2 = { 0 };
        final boolean eglChooseConfig = EGL14.eglChooseConfig(eglDisplay, EGLSurfaceTexture.h, 0, array, 0, 1, array2, 0);
        if (eglChooseConfig && array2[0] > 0 && array[0] != null) {
            return array[0];
        }
        throw new GlException(Util.C("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", eglChooseConfig, array2[0], array[0]), (EGLSurfaceTexture$a)null);
    }
    
    private static EGLContext b(final EGLDisplay eglDisplay, final EGLConfig eglConfig, final int n) {
        int[] array;
        if (n == 0) {
            final int[] array2;
            array = (array2 = new int[3]);
            array2[0] = 12440;
            array2[array2[1] = 2] = 12344;
        }
        else {
            final int[] array3;
            array = (array3 = new int[5]);
            array3[0] = 12440;
            array3[array3[1] = 2] = 12992;
            array3[3] = 1;
            array3[4] = 12344;
        }
        final EGLContext eglCreateContext = EGL14.eglCreateContext(eglDisplay, eglConfig, EGL14.EGL_NO_CONTEXT, array, 0);
        if (eglCreateContext != null) {
            return eglCreateContext;
        }
        throw new GlException("eglCreateContext failed", (EGLSurfaceTexture$a)null);
    }
    
    private static EGLSurface c(final EGLDisplay eglDisplay, final EGLConfig eglConfig, final EGLContext eglContext, final int n) {
        EGLSurface eglSurface;
        if (n == 1) {
            eglSurface = EGL14.EGL_NO_SURFACE;
        }
        else {
            int[] array;
            if (n == 2) {
                final int[] array2;
                array = (array2 = new int[7]);
                array2[0] = 12375;
                array2[1] = 1;
                array2[2] = 12374;
                array2[3] = 1;
                array2[4] = 12992;
                array2[5] = 1;
                array2[6] = 12344;
            }
            else {
                final int[] array3;
                array = (array3 = new int[5]);
                array3[0] = 12375;
                array3[1] = 1;
                array3[2] = 12374;
                array3[3] = 1;
                array3[4] = 12344;
            }
            eglSurface = EGL14.eglCreatePbufferSurface(eglDisplay, eglConfig, array, 0);
            if (eglSurface == null) {
                throw new GlException("eglCreatePbufferSurface failed", (EGLSurfaceTexture$a)null);
            }
        }
        if (EGL14.eglMakeCurrent(eglDisplay, eglSurface, eglSurface, eglContext)) {
            return eglSurface;
        }
        throw new GlException("eglMakeCurrent failed", (EGLSurfaceTexture$a)null);
    }
    
    private void d() {
        final TextureImageListener c = this.c;
        if (c != null) {
            c.a();
        }
    }
    
    private static void e(final int[] array) {
        GLES20.glGenTextures(1, array, 0);
        GlUtil.c();
    }
    
    private static EGLDisplay f() {
        final EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay == null) {
            throw new GlException("eglGetDisplay failed", (EGLSurfaceTexture$a)null);
        }
        final int[] array = new int[2];
        if (EGL14.eglInitialize(eglGetDisplay, array, 0, array, 1)) {
            return eglGetDisplay;
        }
        throw new GlException("eglInitialize failed", (EGLSurfaceTexture$a)null);
    }
    
    public SurfaceTexture g() {
        return Assertions.e(this.g);
    }
    
    public void h(final int n) {
        final EGLDisplay f = f();
        this.d = f;
        final EGLConfig a = a(f);
        final EGLContext b = b(this.d, a, n);
        this.e = b;
        this.f = c(this.d, a, b, n);
        e(this.b);
        (this.g = new SurfaceTexture(this.b[0])).setOnFrameAvailableListener((SurfaceTexture$OnFrameAvailableListener)this);
    }
    
    public void i() {
        this.a.removeCallbacks((Runnable)this);
        try {
            final SurfaceTexture g = this.g;
            if (g != null) {
                g.release();
                GLES20.glDeleteTextures(1, this.b, 0);
            }
        }
        finally {
            final EGLDisplay d = this.d;
            if (d != null && !d.equals((Object)EGL14.EGL_NO_DISPLAY)) {
                final EGLDisplay d2 = this.d;
                final EGLSurface egl_NO_SURFACE = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(d2, egl_NO_SURFACE, egl_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            }
            final EGLSurface f = this.f;
            if (f != null && !f.equals((Object)EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.d, this.f);
            }
            final EGLContext e = this.e;
            if (e != null) {
                EGL14.eglDestroyContext(this.d, e);
            }
            if (Util.a >= 19) {
                EGL14.eglReleaseThread();
            }
            final EGLDisplay d3 = this.d;
            if (d3 != null && !d3.equals((Object)EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.d);
            }
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
        }
    }
    
    public void onFrameAvailable(final SurfaceTexture surfaceTexture) {
        this.a.post((Runnable)this);
    }
    
    public void run() {
        this.d();
        final SurfaceTexture g = this.g;
        if (g == null) {
            return;
        }
        try {
            g.updateTexImage();
        }
        catch (final RuntimeException ex) {}
    }
    
    public static final class GlException extends RuntimeException
    {
        private GlException(final String s) {
            super(s);
        }
        
        GlException(final String s, final EGLSurfaceTexture$a object) {
            this(s);
        }
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface SecureMode {
    }
    
    public interface TextureImageListener
    {
        void a();
    }
}
