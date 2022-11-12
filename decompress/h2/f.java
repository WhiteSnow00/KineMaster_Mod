// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import java.io.FileInputStream;
import java.io.InputStream;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import android.os.ParcelFileDescriptor;
import c2.b;
import u2.d;
import c2.e;
import java.io.File;

public class f<Data> implements n<File, Data>
{
    private final d<Data> a;
    
    public f(final d<Data> a) {
        this.a = a;
    }
    
    @Override
    public /* bridge */ boolean a(final Object o) {
        return this.d((File)o);
    }
    
    @Override
    public /* bridge */ n.a b(final Object o, final int n, final int n2, final c2.e e) {
        return this.c((File)o, n, n2, e);
    }
    
    public n.a<Data> c(final File file, final int n, final int n2, final c2.e e) {
        return (n.a<Data>)new n.a(new u2.d(file), new c<Object>(file, (d<Object>)this.a));
    }
    
    public boolean d(final File file) {
        return true;
    }
    
    public static class a<Data> implements o<File, Data>
    {
        private final d<Data> a;
        
        public a(final d<Data> a) {
            this.a = a;
        }
        
        @Override
        public final n<File, Data> b(final r r) {
            return new f<Data>(this.a);
        }
    }
    
    public static class b extends a<ParcelFileDescriptor>
    {
        public b() {
            super(new d<ParcelFileDescriptor>() {
                @Override
                public Class<ParcelFileDescriptor> a() {
                    return ParcelFileDescriptor.class;
                }
                
                @Override
                public /* bridge */ void b(final Object o) throws IOException {
                    this.d((ParcelFileDescriptor)o);
                }
                
                @Override
                public /* bridge */ Object c(final File file) throws FileNotFoundException {
                    return this.e(file);
                }
                
                public void d(final ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                    parcelFileDescriptor.close();
                }
                
                public ParcelFileDescriptor e(final File file) throws FileNotFoundException {
                    return ParcelFileDescriptor.open(file, 268435456);
                }
            });
        }
    }
    
    public interface d<Data>
    {
        Class<Data> a();
        
        void b(final Data p0) throws IOException;
        
        Data c(final File p0) throws FileNotFoundException;
    }
    
    private static final class c<Data> implements com.bumptech.glide.load.data.d<Data>
    {
        private final File a;
        private final f.d<Data> b;
        private Data c;
        
        c(final File a, final f.d<Data> b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public Class<Data> a() {
            return this.b.a();
        }
        
        @Override
        public void b() {
            final Data c = this.c;
            if (c == null) {
                return;
            }
            try {
                this.b.b(c);
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
        public void e(final Priority priority, final a<? super Data> a) {
            try {
                a.f(this.c = this.b.c(this.a));
            }
            catch (final FileNotFoundException ex) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", (Throwable)ex);
                }
                a.c(ex);
            }
        }
    }
    
    public static class e extends a<InputStream>
    {
        public e() {
            super(new d<InputStream>() {
                @Override
                public Class<InputStream> a() {
                    return InputStream.class;
                }
                
                @Override
                public /* bridge */ void b(final Object o) throws IOException {
                    this.d((InputStream)o);
                }
                
                @Override
                public /* bridge */ Object c(final File file) throws FileNotFoundException {
                    return this.e(file);
                }
                
                public void d(final InputStream inputStream) throws IOException {
                    inputStream.close();
                }
                
                public InputStream e(final File file) throws FileNotFoundException {
                    return new FileInputStream(file);
                }
            });
        }
    }
}
