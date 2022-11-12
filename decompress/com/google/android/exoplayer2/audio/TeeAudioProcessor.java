// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.io.IOException;
import com.google.android.exoplayer2.util.Util;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public final class TeeAudioProcessor extends BaseAudioProcessor
{
    private final AudioBufferSink i;
    
    private void l() {
        if (this.isActive()) {
            final AudioBufferSink i = this.i;
            final AudioFormat b = super.b;
            i.b(b.a, b.b, b.c);
        }
    }
    
    @Override
    public void b(final ByteBuffer byteBuffer) {
        final int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            return;
        }
        this.i.a(byteBuffer.asReadOnlyBuffer());
        this.k(remaining).put(byteBuffer).flip();
    }
    
    public AudioFormat g(final AudioFormat audioFormat) {
        return audioFormat;
    }
    
    @Override
    protected void h() {
        this.l();
    }
    
    @Override
    protected void i() {
        this.l();
    }
    
    @Override
    protected void j() {
        this.l();
    }
    
    public interface AudioBufferSink
    {
        void a(final ByteBuffer p0);
        
        void b(final int p0, final int p1, final int p2);
    }
    
    public static final class WavFileAudioBufferSink implements AudioBufferSink
    {
        private final String a;
        private final byte[] b;
        private final ByteBuffer c;
        private int d;
        private int e;
        private int f;
        private RandomAccessFile g;
        private int h;
        private int i;
        
        private String c() {
            return Util.C("%s-%04d.wav", this.a, this.h++);
        }
        
        private void d() throws IOException {
            if (this.g != null) {
                return;
            }
            final RandomAccessFile g = new RandomAccessFile(this.c(), "rw");
            this.g(g);
            this.g = g;
            this.i = 44;
        }
        
        private void e() throws IOException {
            final RandomAccessFile g = this.g;
            if (g == null) {
                return;
            }
            try {
                this.c.clear();
                this.c.putInt(this.i - 8);
                g.seek(4L);
                g.write(this.b, 0, 4);
                this.c.clear();
                this.c.putInt(this.i - 44);
                g.seek(40L);
                g.write(this.b, 0, 4);
            }
            catch (final IOException ex) {
                Log.j("WaveFileAudioBufferSink", "Error updating file size", ex);
            }
            try {
                g.close();
            }
            finally {
                this.g = null;
            }
        }
        
        private void f(final ByteBuffer byteBuffer) throws IOException {
            final RandomAccessFile randomAccessFile = Assertions.e(this.g);
            while (byteBuffer.hasRemaining()) {
                final int min = Math.min(byteBuffer.remaining(), this.b.length);
                byteBuffer.get(this.b, 0, min);
                randomAccessFile.write(this.b, 0, min);
                this.i += min;
            }
        }
        
        private void g(final RandomAccessFile randomAccessFile) throws IOException {
            randomAccessFile.writeInt(1380533830);
            randomAccessFile.writeInt(-1);
            randomAccessFile.writeInt(1463899717);
            randomAccessFile.writeInt(1718449184);
            this.c.clear();
            this.c.putInt(16);
            this.c.putShort((short)WavUtil.b(this.f));
            this.c.putShort((short)this.e);
            this.c.putInt(this.d);
            final int e0 = Util.e0(this.f, this.e);
            this.c.putInt(this.d * e0);
            this.c.putShort((short)e0);
            this.c.putShort((short)(e0 * 8 / this.e));
            randomAccessFile.write(this.b, 0, this.c.position());
            randomAccessFile.writeInt(1684108385);
            randomAccessFile.writeInt(-1);
        }
        
        @Override
        public void a(final ByteBuffer byteBuffer) {
            try {
                this.d();
                this.f(byteBuffer);
            }
            catch (final IOException ex) {
                Log.d("WaveFileAudioBufferSink", "Error writing data", ex);
            }
        }
        
        @Override
        public void b(final int d, final int e, final int f) {
            try {
                this.e();
            }
            catch (final IOException ex) {
                Log.d("WaveFileAudioBufferSink", "Error resetting", ex);
            }
            this.d = d;
            this.e = e;
            this.f = f;
        }
    }
}
