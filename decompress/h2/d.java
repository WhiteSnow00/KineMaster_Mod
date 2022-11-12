// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import java.io.IOException;
import android.util.Log;
import v2.a;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import c2.b;
import c2.e;
import java.nio.ByteBuffer;
import java.io.File;

public class d implements n<File, ByteBuffer>
{
    @Override
    public /* bridge */ boolean a(final Object o) {
        return this.d((File)o);
    }
    
    @Override
    public /* bridge */ n.a b(final Object o, final int n, final int n2, final e e) {
        return this.c((File)o, n, n2, e);
    }
    
    public n.a<ByteBuffer> c(final File file, final int n, final int n2, final e e) {
        return (n.a<ByteBuffer>)new n.a(new u2.d(file), (com.bumptech.glide.load.data.d<Object>)new a(file));
    }
    
    public boolean d(final File file) {
        return true;
    }
    
    private static final class a implements com.bumptech.glide.load.data.d<ByteBuffer>
    {
        private final File a;
        
        a(final File a) {
            this.a = a;
        }
        
        @Override
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
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
        public void e(final Priority priority, final com.bumptech.glide.load.data.d.a<? super ByteBuffer> a) {
            try {
                a.f(a.a(this.a));
            }
            catch (final IOException ex) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", (Throwable)ex);
                }
                a.c(ex);
            }
        }
    }
    
    public static class b implements o<File, ByteBuffer>
    {
        @Override
        public n<File, ByteBuffer> b(final r r) {
            return new d();
        }
    }
}
