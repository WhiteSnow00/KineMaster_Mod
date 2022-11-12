// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.video;

import javax.microedition.khronos.egl.EGLConfig;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import com.google.android.exoplayer2.util.Assertions;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLES20;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.GlProgram;
import java.util.concurrent.atomic.AtomicReference;
import java.nio.FloatBuffer;
import com.google.android.exoplayer2.decoder.VideoDecoderOutputBuffer;
import android.opengl.GLSurfaceView$Renderer;
import android.util.AttributeSet;
import android.content.Context;
import android.opengl.GLSurfaceView;

public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements VideoDecoderOutputBufferRenderer
{
    private final a a;
    
    public VideoDecoderGLSurfaceView(final Context context) {
        this(context, null);
    }
    
    public VideoDecoderGLSurfaceView(final Context context, final AttributeSet set) {
        super(context, set);
        final a a = new a(this);
        this.a = a;
        this.setPreserveEGLContextOnPause(true);
        this.setEGLContextClientVersion(2);
        this.setRenderer((GLSurfaceView$Renderer)a);
        this.setRenderMode(0);
    }
    
    @Deprecated
    public VideoDecoderOutputBufferRenderer getVideoDecoderOutputBufferRenderer() {
        return this;
    }
    
    public void setOutputBuffer(final VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.a.a(videoDecoderOutputBuffer);
    }
    
    private static final class a implements GLSurfaceView$Renderer
    {
        private static final float[] p;
        private static final float[] w;
        private static final float[] x;
        private static final String[] y;
        private static final FloatBuffer z;
        private final GLSurfaceView a;
        private final int[] b;
        private final int[] c;
        private final int[] d;
        private final int[] e;
        private final AtomicReference<VideoDecoderOutputBuffer> f;
        private final FloatBuffer[] g;
        private GlProgram h;
        private int i;
        private VideoDecoderOutputBuffer j;
        
        static {
            p = new float[] { 1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f };
            w = new float[] { 1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f };
            x = new float[] { 1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f };
            y = new String[] { "y_tex", "u_tex", "v_tex" };
            z = GlUtil.e(new float[] { -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f });
        }
        
        public a(final GLSurfaceView a) {
            this.a = a;
            this.b = new int[3];
            this.c = new int[3];
            this.d = new int[3];
            this.e = new int[3];
            this.f = new AtomicReference<VideoDecoderOutputBuffer>();
            this.g = new FloatBuffer[3];
            for (int i = 0; i < 3; ++i) {
                this.d[i] = (this.e[i] = -1);
            }
        }
        
        private void b() {
            final int[] b = this.b;
            int i = 0;
            GLES20.glGenTextures(3, b, 0);
            while (i < 3) {
                GLES20.glUniform1i(this.h.j(VideoDecoderGLSurfaceView.a.y[i]), i);
                GLES20.glActiveTexture(33984 + i);
                GlUtil.a(3553, this.b[i]);
                ++i;
            }
            GlUtil.c();
        }
        
        public void a(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
            videoDecoderOutputBuffer = this.f.getAndSet(videoDecoderOutputBuffer);
            if (videoDecoderOutputBuffer != null) {
                videoDecoderOutputBuffer.r();
            }
            this.a.requestRender();
        }
        
        public void onDrawFrame(final GL10 gl10) {
            final VideoDecoderOutputBuffer j = this.f.getAndSet(null);
            if (j == null && this.j == null) {
                return;
            }
            if (j != null) {
                final VideoDecoderOutputBuffer i = this.j;
                if (i != null) {
                    i.r();
                }
                this.j = j;
            }
            final VideoDecoderOutputBuffer videoDecoderOutputBuffer = Assertions.e(this.j);
            float[] array = VideoDecoderGLSurfaceView.a.w;
            final int k = videoDecoderOutputBuffer.i;
            if (k != 1) {
                if (k == 3) {
                    array = VideoDecoderGLSurfaceView.a.x;
                }
            }
            else {
                array = VideoDecoderGLSurfaceView.a.p;
            }
            GLES20.glUniformMatrix3fv(this.i, 1, false, array, 0);
            final int[] array2 = Assertions.e(videoDecoderOutputBuffer.h);
            final ByteBuffer[] array3 = Assertions.e(videoDecoderOutputBuffer.g);
            for (int l = 0; l < 3; ++l) {
                int f;
                if (l == 0) {
                    f = videoDecoderOutputBuffer.f;
                }
                else {
                    f = (videoDecoderOutputBuffer.f + 1) / 2;
                }
                GLES20.glActiveTexture(33984 + l);
                GLES20.glBindTexture(3553, this.b[l]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, 6409, array2[l], f, 0, 6409, 5121, (Buffer)array3[l]);
            }
            final int[] array4 = { videoDecoderOutputBuffer.e, 0, 0 };
            array4[1] = (array4[2] = (array4[0] + 1) / 2);
            for (int n = 0; n < 3; ++n) {
                if (this.d[n] != array4[n] || this.e[n] != array2[n]) {
                    Assertions.g(array2[n] != 0);
                    final float n2 = array4[n] / (float)array2[n];
                    this.g[n] = GlUtil.e(new float[] { 0.0f, 0.0f, 0.0f, 1.0f, n2, 0.0f, n2, 1.0f });
                    GLES20.glVertexAttribPointer(this.c[n], 2, 5126, false, 0, (Buffer)this.g[n]);
                    this.d[n] = array4[n];
                    this.e[n] = array2[n];
                }
            }
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            GlUtil.c();
        }
        
        public void onSurfaceChanged(final GL10 gl10, final int n, final int n2) {
            GLES20.glViewport(0, 0, n, n2);
        }
        
        public void onSurfaceCreated(final GL10 gl10, final EGLConfig eglConfig) {
            final GlProgram h = new GlProgram("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.h = h;
            GLES20.glVertexAttribPointer(h.e("in_pos"), 2, 5126, false, 0, (Buffer)VideoDecoderGLSurfaceView.a.z);
            this.c[0] = this.h.e("in_tc_y");
            this.c[1] = this.h.e("in_tc_u");
            this.c[2] = this.h.e("in_tc_v");
            this.i = this.h.j("mColorConversion");
            GlUtil.c();
            this.b();
            GlUtil.c();
        }
    }
}
