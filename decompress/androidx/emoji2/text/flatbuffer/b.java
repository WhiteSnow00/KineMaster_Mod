// 
// Decompiled by Procyon v0.6.0
// 

package androidx.emoji2.text.flatbuffer;

import java.nio.ByteOrder;
import java.nio.ByteBuffer;

public final class b extends c
{
    public static b h(final ByteBuffer byteBuffer) {
        return i(byteBuffer, new b());
    }
    
    public static b i(final ByteBuffer byteBuffer, final b b) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return b.f(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
    
    public b f(final int n, final ByteBuffer byteBuffer) {
        this.g(n, byteBuffer);
        return this;
    }
    
    public void g(final int n, final ByteBuffer byteBuffer) {
        this.c(n, byteBuffer);
    }
    
    public a j(a f, final int n) {
        final int b = this.b(6);
        if (b != 0) {
            f = f.f(this.a(this.d(b) + n * 4), super.b);
        }
        else {
            f = null;
        }
        return f;
    }
    
    public int k() {
        final int b = this.b(6);
        int e;
        if (b != 0) {
            e = this.e(b);
        }
        else {
            e = 0;
        }
        return e;
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
}
