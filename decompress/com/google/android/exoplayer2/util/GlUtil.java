// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import android.content.Context;
import android.opengl.EGL14;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import android.opengl.GLU;
import android.opengl.GLES20;

public final class GlUtil
{
    public static boolean a = false;
    private static final int[] b;
    private static final int[] c;
    private static final int[] d;
    private static final int[] e;
    
    static {
        b = new int[] { 12344 };
        c = new int[] { 12445, 13120, 12344 };
        d = new int[] { 12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344 };
        e = new int[] { 12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344 };
    }
    
    private GlUtil() {
    }
    
    public static void a(final int n, final int n2) {
        GLES20.glBindTexture(n, n2);
        c();
        GLES20.glTexParameteri(n, 10240, 9729);
        c();
        GLES20.glTexParameteri(n, 10241, 9729);
        c();
        GLES20.glTexParameteri(n, 10242, 33071);
        c();
        GLES20.glTexParameteri(n, 10243, 33071);
        c();
    }
    
    private static void b(final boolean b, final String s) {
        if (!b) {
            j(s);
        }
    }
    
    public static void c() {
        int n = 0;
        while (true) {
            final int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("glError: ");
            sb.append(GLU.gluErrorString(glGetError));
            Log.c("GlUtil", sb.toString());
            n = glGetError;
        }
        if (n != 0) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("glError: ");
            sb2.append(GLU.gluErrorString(n));
            j(sb2.toString());
        }
    }
    
    public static FloatBuffer d(final int n) {
        return ByteBuffer.allocateDirect(n * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }
    
    public static FloatBuffer e(final float[] array) {
        return (FloatBuffer)d(array.length).put(array).flip();
    }
    
    public static int f() {
        final int g = g();
        a(36197, g);
        return g;
    }
    
    private static int g() {
        b(Util.c(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT) ^ true, "No current context");
        final int[] array = { 0 };
        GLES20.glGenTextures(1, array, 0);
        c();
        return array[0];
    }
    
    public static boolean h(final Context context) {
        final int a = Util.a;
        final boolean b = false;
        if (a < 24) {
            return false;
        }
        if (a < 26 && ("samsung".equals(Util.c) || "XT1650".equals(Util.d))) {
            return false;
        }
        if (a < 26 && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            return false;
        }
        final String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
        boolean b2 = b;
        if (eglQueryString != null) {
            b2 = b;
            if (eglQueryString.contains("EGL_EXT_protected_content")) {
                b2 = true;
            }
        }
        return b2;
    }
    
    public static boolean i() {
        final int a = Util.a;
        final boolean b = false;
        if (a < 17) {
            return false;
        }
        final String eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
        boolean b2 = b;
        if (eglQueryString != null) {
            b2 = b;
            if (eglQueryString.contains("EGL_KHR_surfaceless_context")) {
                b2 = true;
            }
        }
        return b2;
    }
    
    static void j(final String s) {
        if (!GlUtil.a) {
            Log.c("GlUtil", s);
            return;
        }
        throw new GlException(s);
    }
    
    public static final class GlException extends RuntimeException
    {
        public GlException(final String s) {
            super(s);
        }
    }
}
