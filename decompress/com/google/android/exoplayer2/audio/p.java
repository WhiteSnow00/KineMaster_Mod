// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

final class p extends BaseAudioProcessor
{
    @Override
    public void b(final ByteBuffer byteBuffer) {
        int i = byteBuffer.position();
        final int limit = byteBuffer.limit();
        final int n = limit - i;
        final int c = super.b.c;
        int n2 = n;
        int n3 = 0;
        Label_0096: {
            Label_0092: {
                if (c != 3) {
                    if (c != 4) {
                        n3 = n;
                        if (c == 268435456) {
                            break Label_0096;
                        }
                        if (c == 536870912) {
                            n2 = n / 3;
                            break Label_0092;
                        }
                        if (c != 805306368) {
                            throw new IllegalStateException();
                        }
                    }
                    n3 = n / 2;
                    break Label_0096;
                }
            }
            n3 = n2 * 2;
        }
        final ByteBuffer k = this.k(n3);
        final int c2 = super.b.c;
        int j = i;
        if (c2 != 3) {
            int l = i;
            if (c2 != 4) {
                int n4 = i;
                if (c2 != 268435456) {
                    int n5 = i;
                    if (c2 != 536870912) {
                        if (c2 != 805306368) {
                            throw new IllegalStateException();
                        }
                        while (i < limit) {
                            k.put(byteBuffer.get(i + 2));
                            k.put(byteBuffer.get(i + 3));
                            i += 4;
                        }
                    }
                    else {
                        while (n5 < limit) {
                            k.put(byteBuffer.get(n5 + 1));
                            k.put(byteBuffer.get(n5 + 2));
                            n5 += 3;
                        }
                    }
                }
                else {
                    while (n4 < limit) {
                        k.put(byteBuffer.get(n4 + 1));
                        k.put(byteBuffer.get(n4));
                        n4 += 2;
                    }
                }
            }
            else {
                while (l < limit) {
                    final short n6 = (short)(Util.p(byteBuffer.getFloat(l), -1.0f, 1.0f) * 32767.0f);
                    k.put((byte)(n6 & 0xFF));
                    k.put((byte)(n6 >> 8 & 0xFF));
                    l += 4;
                }
            }
        }
        else {
            while (j < limit) {
                k.put((byte)0);
                k.put((byte)((byteBuffer.get(j) & 0xFF) - 128));
                ++j;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        k.flip();
    }
    
    public AudioFormat g(AudioFormat e) throws UnhandledAudioFormatException {
        final int c = e.c;
        if (c != 3 && c != 2 && c != 268435456 && c != 536870912 && c != 805306368 && c != 4) {
            throw new AudioProcessor.UnhandledAudioFormatException(e);
        }
        if (c != 2) {
            e = new AudioProcessor.AudioFormat(e.a, e.b, 2);
        }
        else {
            e = AudioFormat.e;
        }
        return e;
    }
}
