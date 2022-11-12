// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.util.Util;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;

public interface AudioProcessor
{
    public static final ByteBuffer a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());
    
    ByteBuffer a();
    
    void b(final ByteBuffer p0);
    
    boolean c();
    
    AudioFormat d(final AudioFormat p0) throws UnhandledAudioFormatException;
    
    void e();
    
    void flush();
    
    boolean isActive();
    
    void reset();
    
    public static final class AudioFormat
    {
        public static final AudioFormat e;
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        
        static {
            e = new AudioFormat(-1, -1, -1);
        }
        
        public AudioFormat(int e0, final int b, final int c) {
            this.a = e0;
            this.b = b;
            this.c = c;
            if (Util.u0(c)) {
                e0 = Util.e0(c, b);
            }
            else {
                e0 = -1;
            }
            this.d = e0;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("AudioFormat[sampleRate=");
            sb.append(this.a);
            sb.append(", channelCount=");
            sb.append(this.b);
            sb.append(", encoding=");
            sb.append(this.c);
            sb.append(']');
            return sb.toString();
        }
    }
    
    public static final class UnhandledAudioFormatException extends Exception
    {
        public UnhandledAudioFormatException(final AudioFormat audioFormat) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unhandled format: ");
            sb.append(audioFormat);
            super(sb.toString());
        }
    }
}
