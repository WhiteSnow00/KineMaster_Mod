// 
// Decompiled by Procyon v0.6.0
// 

package k2;

import java.io.IOException;
import java.nio.ByteBuffer;
import com.bumptech.glide.load.data.e;

public class a implements e<ByteBuffer>
{
    private final ByteBuffer a;
    
    public a(final ByteBuffer a) {
        this.a = a;
    }
    
    @Override
    public /* bridge */ Object a() throws IOException {
        return this.c();
    }
    
    @Override
    public void b() {
    }
    
    public ByteBuffer c() {
        this.a.position(0);
        return this.a;
    }
    
    public static class a implements e.a<ByteBuffer>
    {
        @Override
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
        
        @Override
        public /* bridge */ e b(final Object o) {
            return this.c((ByteBuffer)o);
        }
        
        public e<ByteBuffer> c(final ByteBuffer byteBuffer) {
            return new k2.a(byteBuffer);
        }
    }
}
