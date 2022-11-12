// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.parser.moshi;

import qc.f;
import okio.ByteString;
import qc.r;
import java.util.Arrays;
import qc.h;
import java.io.IOException;
import qc.g;
import java.io.Closeable;

public abstract class JsonReader implements Closeable
{
    private static final String[] g;
    int a;
    int[] b;
    String[] c;
    int[] d;
    boolean e;
    boolean f;
    
    static {
        g = new String[128];
        for (int i = 0; i <= 31; ++i) {
            JsonReader.g[i] = String.format("\\u%04x", i);
        }
        final String[] g2 = JsonReader.g;
        g2[34] = "\\\"";
        g2[92] = "\\\\";
        g2[9] = "\\t";
        g2[8] = "\\b";
        g2[10] = "\\n";
        g2[13] = "\\r";
        g2[12] = "\\f";
    }
    
    JsonReader() {
        this.b = new int[32];
        this.c = new String[32];
        this.d = new int[32];
    }
    
    private static void O(final g g, final String s) throws IOException {
        final String[] g2 = JsonReader.g;
        g.writeByte(34);
        final int length = s.length();
        int i = 0;
        int n = 0;
        while (i < length) {
            final char char1 = s.charAt(i);
            int n2 = 0;
            Label_0126: {
                String s2;
                if (char1 < '\u0080') {
                    if ((s2 = g2[char1]) == null) {
                        n2 = n;
                        break Label_0126;
                    }
                }
                else if (char1 == '\u2028') {
                    s2 = "\\u2028";
                }
                else {
                    n2 = n;
                    if (char1 != '\u2029') {
                        break Label_0126;
                    }
                    s2 = "\\u2029";
                }
                if (n < i) {
                    g.d0(s, n, i);
                }
                g.Y(s2);
                n2 = i + 1;
            }
            ++i;
            n = n2;
        }
        if (n < length) {
            g.d0(s, n, length);
        }
        g.writeByte(34);
    }
    
    static void a(final g g, final String s) throws IOException {
        O(g, s);
    }
    
    public static JsonReader t(final h h) {
        return new b(h);
    }
    
    final void E(final int n) {
        final int a = this.a;
        final int[] b = this.b;
        if (a == b.length) {
            if (a == 256) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Nesting too deep at ");
                sb.append(this.getPath());
                throw new JsonDataException(sb.toString());
            }
            this.b = Arrays.copyOf(b, b.length * 2);
            final String[] c = this.c;
            this.c = Arrays.copyOf(c, c.length * 2);
            final int[] d = this.d;
            this.d = Arrays.copyOf(d, d.length * 2);
        }
        this.b[this.a++] = n;
    }
    
    public abstract int F(final a p0) throws IOException;
    
    public abstract void L() throws IOException;
    
    public abstract void M() throws IOException;
    
    final JsonEncodingException V(final String s) throws JsonEncodingException {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(" at path ");
        sb.append(this.getPath());
        throw new JsonEncodingException(sb.toString());
    }
    
    public abstract void c() throws IOException;
    
    public abstract void d() throws IOException;
    
    public abstract void e() throws IOException;
    
    public final String getPath() {
        return com.airbnb.lottie.parser.moshi.a.a(this.a, this.b, this.c, this.d);
    }
    
    public abstract void h() throws IOException;
    
    public abstract boolean i() throws IOException;
    
    public abstract boolean j() throws IOException;
    
    public abstract double k() throws IOException;
    
    public abstract int l() throws IOException;
    
    public abstract String r() throws IOException;
    
    public abstract String s() throws IOException;
    
    public abstract Token u() throws IOException;
    
    public enum Token
    {
        private static final Token[] $VALUES;
        
        BEGIN_ARRAY, 
        BEGIN_OBJECT, 
        BOOLEAN, 
        END_ARRAY, 
        END_DOCUMENT, 
        END_OBJECT, 
        NAME, 
        NULL, 
        NUMBER, 
        STRING;
    }
    
    public static final class a
    {
        final String[] a;
        final r b;
        
        private a(final String[] a, final r b) {
            this.a = a;
            this.b = b;
        }
        
        public static a a(final String... array) {
            try {
                final ByteString[] array2 = new ByteString[array.length];
                final f f = new f();
                for (int i = 0; i < array.length; ++i) {
                    JsonReader.a((g)f, array[i]);
                    f.readByte();
                    array2[i] = f.j1();
                }
                return new a(array.clone(), r.n(array2));
            }
            catch (final IOException ex) {
                throw new AssertionError((Object)ex);
            }
        }
    }
}
