// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

final class o extends BaseAudioProcessor
{
    private static final int i;
    
    static {
        i = Float.floatToIntBits(Float.NaN);
    }
    
    private static void l(int n, final ByteBuffer byteBuffer) {
        if ((n = Float.floatToIntBits((float)(n * 4.656612875245797E-10))) == o.i) {
            n = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(n);
    }
    
    @Override
    public void b(final ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        final int limit = byteBuffer.limit();
        final int n = limit - position;
        final int c = super.b.c;
        ByteBuffer byteBuffer2;
        if (c != 536870912) {
            if (c != 805306368) {
                throw new IllegalStateException();
            }
            final ByteBuffer k = this.k(n);
            while (true) {
                byteBuffer2 = k;
                if (position >= limit) {
                    break;
                }
                l((byteBuffer.get(position) & 0xFF) | (byteBuffer.get(position + 1) & 0xFF) << 8 | (byteBuffer.get(position + 2) & 0xFF) << 16 | (byteBuffer.get(position + 3) & 0xFF) << 24, k);
                position += 4;
            }
        }
        else {
            final ByteBuffer i = this.k(n / 3 * 4);
            while (true) {
                byteBuffer2 = i;
                if (position >= limit) {
                    break;
                }
                l((byteBuffer.get(position) & 0xFF) << 8 | (byteBuffer.get(position + 1) & 0xFF) << 16 | (byteBuffer.get(position + 2) & 0xFF) << 24, i);
                position += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }
    
    public AudioFormat g(AudioFormat e) throws UnhandledAudioFormatException {
        final int c = e.c;
        if (Util.t0(c)) {
            if (c != 4) {
                e = new AudioProcessor.AudioFormat(e.a, e.b, 4);
            }
            else {
                e = AudioFormat.e;
            }
            return e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(e);
    }
}
