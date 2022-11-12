// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video.spherical;

import java.nio.FloatBuffer;
import java.nio.Buffer;
import com.google.android.exoplayer2.util.GlUtil;
import android.opengl.GLES20;
import com.google.android.exoplayer2.util.GlProgram;

final class c
{
    private static final float[] j;
    private static final float[] k;
    private static final float[] l;
    private static final float[] m;
    private static final float[] n;
    private int a;
    private a b;
    private a c;
    private GlProgram d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    
    static {
        j = new float[] { 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f };
        k = new float[] { 1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f };
        l = new float[] { 1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f };
        m = new float[] { 0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f };
        n = new float[] { 0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f };
    }
    
    public static boolean c(final Projection projection) {
        final Projection.Mesh a = projection.a;
        final Projection.Mesh b = projection.b;
        final int b2 = a.b();
        boolean b4;
        final boolean b3 = b4 = false;
        if (b2 == 1) {
            b4 = b3;
            if (a.a(0).a == 0) {
                b4 = b3;
                if (b.b() == 1) {
                    b4 = b3;
                    if (b.a(0).a == 0) {
                        b4 = true;
                    }
                }
            }
        }
        return b4;
    }
    
    public void a(final int n, final float[] array, final boolean b) {
        a a;
        if (b) {
            a = this.c;
        }
        else {
            a = this.b;
        }
        if (a == null) {
            return;
        }
        final int a2 = this.a;
        float[] array2;
        if (a2 == 1) {
            if (b) {
                array2 = com.google.android.exoplayer2.video.spherical.c.l;
            }
            else {
                array2 = com.google.android.exoplayer2.video.spherical.c.k;
            }
        }
        else if (a2 == 2) {
            if (b) {
                array2 = com.google.android.exoplayer2.video.spherical.c.n;
            }
            else {
                array2 = com.google.android.exoplayer2.video.spherical.c.m;
            }
        }
        else {
            array2 = com.google.android.exoplayer2.video.spherical.c.j;
        }
        GLES20.glUniformMatrix3fv(this.f, 1, false, array2, 0);
        GLES20.glUniformMatrix4fv(this.e, 1, false, array, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, n);
        GLES20.glUniform1i(this.i, 0);
        GlUtil.c();
        GLES20.glVertexAttribPointer(this.g, 3, 5126, false, 12, (Buffer)com.google.android.exoplayer2.video.spherical.c.a.a(a));
        GlUtil.c();
        GLES20.glVertexAttribPointer(this.h, 2, 5126, false, 8, (Buffer)com.google.android.exoplayer2.video.spherical.c.a.b(a));
        GlUtil.c();
        GLES20.glDrawArrays(com.google.android.exoplayer2.video.spherical.c.a.c(a), 0, com.google.android.exoplayer2.video.spherical.c.a.d(a));
        GlUtil.c();
    }
    
    public void b() {
        final GlProgram d = new GlProgram("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
        this.d = d;
        this.e = d.j("uMvpMatrix");
        this.f = this.d.j("uTexMatrix");
        this.g = this.d.e("aPosition");
        this.h = this.d.e("aTexCoords");
        this.i = this.d.j("uTexture");
    }
    
    public void d(final Projection projection) {
        if (!c(projection)) {
            return;
        }
        this.a = projection.c;
        final a b = new a(projection.a.a(0));
        this.b = b;
        a c;
        if (projection.d) {
            c = b;
        }
        else {
            c = new a(projection.b.a(0));
        }
        this.c = c;
    }
    
    private static class a
    {
        private final int a;
        private final FloatBuffer b;
        private final FloatBuffer c;
        private final int d;
        
        public a(final Projection.SubMesh subMesh) {
            this.a = subMesh.a();
            this.b = GlUtil.e(subMesh.c);
            this.c = GlUtil.e(subMesh.d);
            final int b = subMesh.b;
            if (b != 1) {
                if (b != 2) {
                    this.d = 4;
                }
                else {
                    this.d = 6;
                }
            }
            else {
                this.d = 5;
            }
        }
        
        static FloatBuffer a(final a a) {
            return a.b;
        }
        
        static FloatBuffer b(final a a) {
            return a.c;
        }
        
        static int c(final a a) {
            return a.d;
        }
        
        static int d(final a a) {
            return a.a;
        }
    }
}
