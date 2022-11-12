// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

final class m extends BaseAudioProcessor
{
    private int[] i;
    private int[] j;
    
    @Override
    public void b(final ByteBuffer byteBuffer) {
        final int[] array = Assertions.e(this.j);
        int i = byteBuffer.position();
        final int limit = byteBuffer.limit();
        final ByteBuffer k = this.k((limit - i) / super.b.d * super.c.d);
        while (i < limit) {
            for (int length = array.length, j = 0; j < length; ++j) {
                k.putShort(byteBuffer.getShort(array[j] * 2 + i));
            }
            i += super.b.d;
        }
        byteBuffer.position(limit);
        k.flip();
    }
    
    public AudioFormat g(AudioFormat e) throws UnhandledAudioFormatException {
        final int[] i = this.i;
        if (i == null) {
            return AudioFormat.e;
        }
        if (e.c == 2) {
            boolean b;
            if (e.b != i.length) {
                b = true;
            }
            else {
                b = false;
            }
            for (int j = 0; j < i.length; ++j) {
                final int n = i[j];
                if (n >= e.b) {
                    throw new AudioProcessor.UnhandledAudioFormatException(e);
                }
                b |= (n != j);
            }
            if (b) {
                e = new AudioProcessor.AudioFormat(e.a, i.length, 2);
            }
            else {
                e = AudioFormat.e;
            }
            return e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(e);
    }
    
    @Override
    protected void h() {
        this.j = this.i;
    }
    
    @Override
    protected void j() {
        this.j = null;
        this.i = null;
    }
    
    public void l(final int[] i) {
        this.i = i;
    }
}
