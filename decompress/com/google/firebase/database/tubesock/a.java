// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.tubesock;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.Charset;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.List;

class a
{
    static b a(final byte b) {
        if (b == 2) {
            return (b)new a();
        }
        return (b)new c();
    }
    
    static class a implements b
    {
        private List<byte[]> a;
        private int b;
        
        a() {
            this.b = 0;
            this.a = new ArrayList<byte[]>();
        }
        
        @Override
        public boolean a(final byte[] array) {
            this.a.add(array);
            this.b += array.length;
            return true;
        }
        
        @Override
        public WebSocketMessage b() {
            final byte[] array = new byte[this.b];
            int i = 0;
            int n = 0;
            while (i < this.a.size()) {
                final byte[] array2 = this.a.get(i);
                System.arraycopy(array2, 0, array, n, array2.length);
                n += array2.length;
                ++i;
            }
            return new WebSocketMessage(array);
        }
    }
    
    interface b
    {
        boolean a(final byte[] p0);
        
        WebSocketMessage b();
    }
    
    static class c implements b
    {
        private static ThreadLocal<CharsetDecoder> c;
        private static ThreadLocal<CharsetEncoder> d;
        private StringBuilder a;
        private ByteBuffer b;
        
        static {
            com.google.firebase.database.tubesock.a.c.c = new ThreadLocal<CharsetDecoder>() {
                protected CharsetDecoder a() {
                    final CharsetDecoder decoder = Charset.forName("UTF8").newDecoder();
                    decoder.onMalformedInput(CodingErrorAction.REPORT);
                    decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
                    return decoder;
                }
                
                @Override
                protected /* bridge */ Object initialValue() {
                    return this.a();
                }
            };
            com.google.firebase.database.tubesock.a.c.d = new ThreadLocal<CharsetEncoder>() {
                protected CharsetEncoder a() {
                    final CharsetEncoder encoder = Charset.forName("UTF8").newEncoder();
                    encoder.onMalformedInput(CodingErrorAction.REPORT);
                    encoder.onUnmappableCharacter(CodingErrorAction.REPORT);
                    return encoder;
                }
                
                @Override
                protected /* bridge */ Object initialValue() {
                    return this.a();
                }
            };
        }
        
        c() {
            this.a = new StringBuilder();
        }
        
        private String c(final byte[] array) {
            try {
                return com.google.firebase.database.tubesock.a.c.c.get().decode(ByteBuffer.wrap(array)).toString();
            }
            catch (final CharacterCodingException ex) {
                return null;
            }
        }
        
        @Override
        public boolean a(final byte[] array) {
            final String c = this.c(array);
            if (c != null) {
                this.a.append(c);
                return true;
            }
            return false;
        }
        
        @Override
        public WebSocketMessage b() {
            if (this.b != null) {
                return null;
            }
            return new WebSocketMessage(this.a.toString());
        }
    }
}
