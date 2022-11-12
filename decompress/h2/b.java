// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.nio.ByteBuffer;
import u2.d;
import c2.e;

public class b<Data> implements n<byte[], Data>
{
    private final b<Data> a;
    
    public b(final b<Data> a) {
        this.a = a;
    }
    
    @Override
    public /* bridge */ boolean a(final Object o) {
        return this.d((byte[])o);
    }
    
    @Override
    public /* bridge */ n.a b(final Object o, final int n, final int n2, final e e) {
        return this.c((byte[])o, n, n2, e);
    }
    
    public n.a<Data> c(final byte[] array, final int n, final int n2, final e e) {
        return (n.a<Data>)new n.a(new u2.d(array), new c<Object>(array, (b<Object>)this.a));
    }
    
    public boolean d(final byte[] array) {
        return true;
    }
    
    public static class a implements o<byte[], ByteBuffer>
    {
        @Override
        public n<byte[], ByteBuffer> b(final r r) {
            return new b<ByteBuffer>((b<ByteBuffer>)new b<ByteBuffer>(this) {
                final a a;
                
                @Override
                public Class<ByteBuffer> a() {
                    return ByteBuffer.class;
                }
                
                @Override
                public /* bridge */ Object b(final byte[] array) {
                    return this.c(array);
                }
                
                public ByteBuffer c(final byte[] array) {
                    return ByteBuffer.wrap(array);
                }
            });
        }
    }
    
    public interface b<Data>
    {
        Class<Data> a();
        
        Data b(final byte[] p0);
    }
    
    private static class c<Data> implements com.bumptech.glide.load.data.d<Data>
    {
        private final byte[] a;
        private final b<Data> b;
        
        c(final byte[] a, final b<Data> b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public Class<Data> a() {
            return this.b.a();
        }
        
        @Override
        public void b() {
        }
        
        @Override
        public void cancel() {
        }
        
        @Override
        public DataSource d() {
            return DataSource.LOCAL;
        }
        
        @Override
        public void e(final Priority priority, final a<? super Data> a) {
            a.f(this.b.b(this.a));
        }
    }
    
    public static class d implements o<byte[], InputStream>
    {
        @Override
        public n<byte[], InputStream> b(final r r) {
            return new b<InputStream>((b<InputStream>)new b<InputStream>(this) {
                final d a;
                
                @Override
                public Class<InputStream> a() {
                    return InputStream.class;
                }
                
                @Override
                public /* bridge */ Object b(final byte[] array) {
                    return this.c(array);
                }
                
                public InputStream c(final byte[] array) {
                    return new ByteArrayInputStream(array);
                }
            });
        }
    }
}
