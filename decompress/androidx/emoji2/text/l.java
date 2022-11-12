// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import java.nio.ByteOrder;
import androidx.emoji2.text.flatbuffer.b;
import java.nio.ByteBuffer;
import java.io.IOException;

class l
{
    private static b a(final c c) throws IOException {
        c.a(4);
        final int unsignedShort = c.readUnsignedShort();
        if (unsignedShort <= 100) {
            c.a(6);
            final int n = 0;
            while (true) {
                for (int i = 0; i < unsignedShort; ++i) {
                    final int b = c.b();
                    c.a(4);
                    final long c2 = c.c();
                    c.a(4);
                    if (1835365473 == b) {
                        if (c2 != -1L) {
                            c.a((int)(c2 - c.getPosition()));
                            c.a(12);
                            final long c3 = c.c();
                            for (int n2 = n; n2 < c3; ++n2) {
                                final int b2 = c.b();
                                final long c4 = c.c();
                                final long c5 = c.c();
                                if (1164798569 == b2 || 1701669481 == b2) {
                                    return new b(c4 + c2, c5);
                                }
                            }
                        }
                        throw new IOException("Cannot read metadata.");
                    }
                }
                final long c2 = -1L;
                continue;
            }
        }
        throw new IOException("Cannot read metadata.");
    }
    
    static androidx.emoji2.text.flatbuffer.b b(ByteBuffer duplicate) throws IOException {
        duplicate = duplicate.duplicate();
        duplicate.position((int)a((c)new a(duplicate)).a());
        return androidx.emoji2.text.flatbuffer.b.h(duplicate);
    }
    
    static long c(final int n) {
        return (long)n & 0xFFFFFFFFL;
    }
    
    static int d(final short n) {
        return n & 0xFFFF;
    }
    
    private static class a implements c
    {
        private final ByteBuffer a;
        
        a(final ByteBuffer a) {
            (this.a = a).order(ByteOrder.BIG_ENDIAN);
        }
        
        @Override
        public void a(final int n) throws IOException {
            final ByteBuffer a = this.a;
            a.position(a.position() + n);
        }
        
        @Override
        public int b() throws IOException {
            return this.a.getInt();
        }
        
        @Override
        public long c() throws IOException {
            return l.c(this.a.getInt());
        }
        
        @Override
        public long getPosition() {
            return this.a.position();
        }
        
        @Override
        public int readUnsignedShort() throws IOException {
            return l.d(this.a.getShort());
        }
    }
    
    private interface c
    {
        void a(final int p0) throws IOException;
        
        int b() throws IOException;
        
        long c() throws IOException;
        
        long getPosition();
        
        int readUnsignedShort() throws IOException;
    }
    
    private static class b
    {
        private final long a;
        private final long b;
        
        b(final long a, final long b) {
            this.a = a;
            this.b = b;
        }
        
        long a() {
            return this.a;
        }
    }
}
