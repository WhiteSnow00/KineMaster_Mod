// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text;

import android.util.SparseArray;
import androidx.core.util.h;
import java.io.IOException;
import androidx.core.os.l;
import java.nio.ByteBuffer;
import android.graphics.Typeface;
import androidx.emoji2.text.flatbuffer.b;

public final class m
{
    private final b a;
    private final char[] b;
    private final a c;
    private final Typeface d;
    
    private m(final Typeface d, final b a) {
        this.d = d;
        this.a = a;
        this.c = new a(1024);
        this.b = new char[a.k() * 2];
        this.a(a);
    }
    
    private void a(final b b) {
        for (int k = b.k(), i = 0; i < k; ++i) {
            final g g = new g(this, i);
            Character.toChars(g.f(), this.b, i * 2);
            this.h(g);
        }
    }
    
    public static m b(final Typeface typeface, final ByteBuffer byteBuffer) throws IOException {
        try {
            l.a("EmojiCompat.MetadataRepo.create");
            return new m(typeface, androidx.emoji2.text.l.b(byteBuffer));
        }
        finally {
            l.b();
        }
    }
    
    public char[] c() {
        return this.b;
    }
    
    public b d() {
        return this.a;
    }
    
    int e() {
        return this.a.l();
    }
    
    a f() {
        return this.c;
    }
    
    Typeface g() {
        return this.d;
    }
    
    void h(final g g) {
        h.h(g, "emoji metadata cannot be null");
        h.b(g.c() > 0, "invalid metadata codepoint length");
        this.c.c(g, 0, g.c() - 1);
    }
    
    static class a
    {
        private final SparseArray<a> a;
        private g b;
        
        private a() {
            this(1);
        }
        
        a(final int n) {
            this.a = (SparseArray<a>)new SparseArray(n);
        }
        
        a a(final int n) {
            final SparseArray<a> a = this.a;
            a a2;
            if (a == null) {
                a2 = null;
            }
            else {
                a2 = (a)a.get(n);
            }
            return a2;
        }
        
        final g b() {
            return this.b;
        }
        
        void c(final g b, final int n, final int n2) {
            a a;
            if ((a = this.a(b.b(n))) == null) {
                a = new a();
                this.a.put(b.b(n), (Object)a);
            }
            if (n2 > n) {
                a.c(b, n + 1, n2);
            }
            else {
                a.b = b;
            }
        }
    }
}
