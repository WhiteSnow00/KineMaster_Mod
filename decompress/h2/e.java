// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import java.io.ByteArrayInputStream;
import android.util.Base64;
import java.io.InputStream;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;
import c2.b;
import u2.d;

public final class e<Model, Data> implements n<Model, Data>
{
    private final a<Data> a;
    
    public e(final a<Data> a) {
        this.a = a;
    }
    
    @Override
    public boolean a(final Model model) {
        return model.toString().startsWith("data:image");
    }
    
    @Override
    public n.a<Data> b(final Model model, final int n, final int n2, final c2.e e) {
        return (n.a<Data>)new n.a(new d(model), new b<Object>(model.toString(), (a<Object>)this.a));
    }
    
    public interface a<Data>
    {
        Class<Data> a();
        
        void b(final Data p0) throws IOException;
        
        Data c(final String p0) throws IllegalArgumentException;
    }
    
    private static final class b<Data> implements d<Data>
    {
        private final String a;
        private final e.a<Data> b;
        private Data c;
        
        b(final String a, final e.a<Data> b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public Class<Data> a() {
            return this.b.a();
        }
        
        @Override
        public void b() {
            try {
                this.b.b(this.c);
            }
            catch (final IOException ex) {}
        }
        
        @Override
        public void cancel() {
        }
        
        @Override
        public DataSource d() {
            return DataSource.LOCAL;
        }
        
        @Override
        public void e(final Priority priority, final d.a<? super Data> a) {
            try {
                a.f(this.c = this.b.c(this.a));
            }
            catch (final IllegalArgumentException ex) {
                a.c(ex);
            }
        }
    }
    
    public static final class c<Model> implements o<Model, InputStream>
    {
        private final a<InputStream> a;
        
        public c() {
            this.a = new a<InputStream>(this) {
                final c a;
                
                @Override
                public Class<InputStream> a() {
                    return InputStream.class;
                }
                
                @Override
                public /* bridge */ void b(final Object o) throws IOException {
                    this.d((InputStream)o);
                }
                
                @Override
                public /* bridge */ Object c(final String s) throws IllegalArgumentException {
                    return this.e(s);
                }
                
                public void d(final InputStream inputStream) throws IOException {
                    inputStream.close();
                }
                
                public InputStream e(final String s) {
                    if (!s.startsWith("data:image")) {
                        throw new IllegalArgumentException("Not a valid image data URL.");
                    }
                    final int index = s.indexOf(44);
                    if (index == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    }
                    if (s.substring(0, index).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(s.substring(index + 1), 0));
                    }
                    throw new IllegalArgumentException("Not a base64 image data URL.");
                }
            };
        }
        
        @Override
        public n<Model, InputStream> b(final r r) {
            return new e<Model, InputStream>(this.a);
        }
    }
}
