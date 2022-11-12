// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class c
{
    protected int a;
    protected ByteBuffer b;
    private int c;
    private int d;
    d e;
    
    public c() {
        this.e = androidx.emoji2.text.flatbuffer.d.a();
    }
    
    protected int a(final int n) {
        return n + this.b.getInt(n);
    }
    
    protected int b(int short1) {
        if (short1 < this.d) {
            short1 = this.b.getShort(this.c + short1);
        }
        else {
            short1 = 0;
        }
        return short1;
    }
    
    protected void c(int n, final ByteBuffer b) {
        this.b = b;
        if (b != null) {
            this.a = n;
            n -= b.getInt(n);
            this.c = n;
            this.d = this.b.getShort(n);
        }
        else {
            this.a = 0;
            this.c = 0;
            this.d = 0;
        }
    }
    
    protected int d(int n) {
        n += this.a;
        return n + this.b.getInt(n) + 4;
    }
    
    protected int e(int n) {
        n += this.a;
        return this.b.getInt(n + this.b.getInt(n));
    }
}
