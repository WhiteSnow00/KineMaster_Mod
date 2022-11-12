// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public final class a extends c
{
    public a f(final int n, final ByteBuffer byteBuffer) {
        this.g(n, byteBuffer);
        return this;
    }
    
    public void g(final int n, final ByteBuffer byteBuffer) {
        this.c(n, byteBuffer);
    }
    
    public int h(int int1) {
        final int b = this.b(16);
        if (b != 0) {
            int1 = super.b.getInt(this.d(b) + int1 * 4);
        }
        else {
            int1 = 0;
        }
        return int1;
    }
    
    public int i() {
        final int b = this.b(16);
        int e;
        if (b != 0) {
            e = this.e(b);
        }
        else {
            e = 0;
        }
        return e;
    }
    
    public boolean j() {
        final int b = this.b(6);
        boolean b2 = false;
        if (b != 0) {
            b2 = b2;
            if (super.b.get(b + super.a) != 0) {
                b2 = true;
            }
        }
        return b2;
    }
    
    public short k() {
        final int b = this.b(14);
        short short1;
        if (b != 0) {
            short1 = super.b.getShort(b + super.a);
        }
        else {
            short1 = 0;
        }
        return short1;
    }
    
    public int l() {
        final int b = this.b(4);
        int int1;
        if (b != 0) {
            int1 = super.b.getInt(b + super.a);
        }
        else {
            int1 = 0;
        }
        return int1;
    }
    
    public short m() {
        final int b = this.b(8);
        short short1;
        if (b != 0) {
            short1 = super.b.getShort(b + super.a);
        }
        else {
            short1 = 0;
        }
        return short1;
    }
    
    public short n() {
        final int b = this.b(12);
        short short1;
        if (b != 0) {
            short1 = super.b.getShort(b + super.a);
        }
        else {
            short1 = 0;
        }
        return short1;
    }
}
