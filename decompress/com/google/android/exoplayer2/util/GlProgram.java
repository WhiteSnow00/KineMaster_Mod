// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.util.HashMap;
import android.opengl.GLES20;
import java.util.Map;

public final class GlProgram
{
    private final int a;
    private final a[] b;
    private final b[] c;
    private final Map<String, a> d;
    private final Map<String, b> e;
    
    public GlProgram(final String s, final String s2) {
        final int glCreateProgram = GLES20.glCreateProgram();
        this.a = glCreateProgram;
        GlUtil.c();
        d(glCreateProgram, 35633, s);
        d(glCreateProgram, 35632, s2);
        GLES20.glLinkProgram(glCreateProgram);
        final int[] array = { 0 };
        GLES20.glGetProgramiv(glCreateProgram, 35714, array, 0);
        if (array[0] != 1) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unable to link shader program: \n");
            sb.append(GLES20.glGetProgramInfoLog(glCreateProgram));
            GlUtil.j(sb.toString());
        }
        GLES20.glUseProgram(glCreateProgram);
        this.d = new HashMap<String, a>();
        final int[] array2 = { 0 };
        GLES20.glGetProgramiv(glCreateProgram, 35721, array2, 0);
        this.b = new a[array2[0]];
        for (int i = 0; i < array2[0]; ++i) {
            final a a = GlProgram.a.a(this.a, i);
            this.b[i] = a;
            this.d.put(a.a, a);
        }
        this.e = new HashMap<String, b>();
        final int[] array3 = { 0 };
        GLES20.glGetProgramiv(this.a, 35718, array3, 0);
        this.c = new b[array3[0]];
        for (int j = 0; j < array3[0]; ++j) {
            final b a2 = GlProgram.b.a(this.a, j);
            this.c[j] = a2;
            this.e.put(a2.a, a2);
        }
        GlUtil.c();
    }
    
    static int a(final byte[] array) {
        return h(array);
    }
    
    static int b(final int n, final String s) {
        return f(n, s);
    }
    
    static int c(final int n, final String s) {
        return i(n, s);
    }
    
    private static void d(final int n, int glCreateShader, final String s) {
        glCreateShader = GLES20.glCreateShader(glCreateShader);
        GLES20.glShaderSource(glCreateShader, s);
        GLES20.glCompileShader(glCreateShader);
        final int[] array = { 0 };
        GLES20.glGetShaderiv(glCreateShader, 35713, array, 0);
        if (array[0] != 1) {
            final StringBuilder sb = new StringBuilder();
            sb.append(GLES20.glGetShaderInfoLog(glCreateShader));
            sb.append(", source: ");
            sb.append(s);
            GlUtil.j(sb.toString());
        }
        GLES20.glAttachShader(n, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        GlUtil.c();
    }
    
    private static int f(final int n, final String s) {
        return GLES20.glGetAttribLocation(n, s);
    }
    
    private int g(final String s) {
        return f(this.a, s);
    }
    
    private static int h(final byte[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == 0) {
                return i;
            }
        }
        return array.length;
    }
    
    private static int i(final int n, final String s) {
        return GLES20.glGetUniformLocation(n, s);
    }
    
    public int e(final String s) {
        final int g = this.g(s);
        GLES20.glEnableVertexAttribArray(g);
        GlUtil.c();
        return g;
    }
    
    public int j(final String s) {
        return i(this.a, s);
    }
    
    private static final class a
    {
        public final String a;
        private final int b;
        private final int c;
        
        private a(final String a, final int b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public static a a(final int n, final int n2) {
            final int[] array = { 0 };
            GLES20.glGetProgramiv(n, 35722, array, 0);
            final byte[] array2 = new byte[array[0]];
            GLES20.glGetActiveAttrib(n, n2, array[0], new int[1], 0, new int[1], 0, new int[1], 0, array2, 0);
            final String s = new String(array2, 0, GlProgram.a(array2));
            return new a(s, n2, GlProgram.b(n, s));
        }
    }
    
    private static final class b
    {
        public final String a;
        private final int b;
        private final int c;
        private final float[] d;
        
        private b(final String a, final int b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = new float[16];
        }
        
        public static b a(final int n, final int n2) {
            final int[] array = { 0 };
            GLES20.glGetProgramiv(n, 35719, array, 0);
            final int[] array2 = { 0 };
            final byte[] array3 = new byte[array[0]];
            GLES20.glGetActiveUniform(n, n2, array[0], new int[1], 0, new int[1], 0, array2, 0, array3, 0);
            final String s = new String(array3, 0, GlProgram.a(array3));
            return new b(s, GlProgram.c(n, s), array2[0]);
        }
    }
}
