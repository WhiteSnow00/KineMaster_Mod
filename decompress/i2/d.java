// 
// Decompiled by Procyon v0.6.0
// 

package i2;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import android.database.Cursor;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import android.provider.MediaStore;
import android.os.Environment;
import java.io.InputStream;
import android.os.ParcelFileDescriptor;
import h2.r;
import h2.o;
import android.os.Build$VERSION;
import c2.b;
import c2.e;
import java.io.File;
import android.content.Context;
import android.net.Uri;
import h2.n;

public final class d<DataT> implements n<Uri, DataT>
{
    private final Context a;
    private final n<File, DataT> b;
    private final n<Uri, DataT> c;
    private final Class<DataT> d;
    
    d(final Context context, final n<File, DataT> b, final n<Uri, DataT> c, final Class<DataT> d) {
        this.a = context.getApplicationContext();
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public /* bridge */ boolean a(final Object o) {
        return this.d((Uri)o);
    }
    
    @Override
    public /* bridge */ n.a b(final Object o, final int n, final int n2, final e e) {
        return this.c((Uri)o, n, n2, e);
    }
    
    public n.a<DataT> c(final Uri uri, final int n, final int n2, final e e) {
        return (n.a<DataT>)new n.a(new d(uri), new d<Object>(this.a, (n<File, Object>)this.b, (n<Uri, Object>)this.c, uri, n, n2, e, (Class<Object>)this.d));
    }
    
    public boolean d(final Uri uri) {
        return Build$VERSION.SDK_INT >= 29 && d2.b.b(uri);
    }
    
    private abstract static class a<DataT> implements o<Uri, DataT>
    {
        private final Context a;
        private final Class<DataT> b;
        
        a(final Context a, final Class<DataT> b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public final n<Uri, DataT> b(final r r) {
            return new d<DataT>(this.a, (n<File, DataT>)r.d(File.class, (Class<DataT>)this.b), (n<Uri, DataT>)r.d(Uri.class, (Class<DataT>)this.b), this.b);
        }
    }
    
    public static final class b extends a<ParcelFileDescriptor>
    {
        public b(final Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }
    
    public static final class c extends a<InputStream>
    {
        public c(final Context context) {
            super(context, InputStream.class);
        }
    }
    
    private static final class d<DataT> implements com.bumptech.glide.load.data.d<DataT>
    {
        private static final String[] p;
        private final Context a;
        private final n<File, DataT> b;
        private final n<Uri, DataT> c;
        private final Uri d;
        private final int e;
        private final int f;
        private final e g;
        private final Class<DataT> h;
        private volatile boolean i;
        private volatile com.bumptech.glide.load.data.d<DataT> j;
        
        static {
            p = new String[] { "_data" };
        }
        
        d(final Context context, final n<File, DataT> b, final n<Uri, DataT> c, final Uri d, final int e, final int f, final e g, final Class<DataT> h) {
            this.a = context.getApplicationContext();
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
            this.h = h;
        }
        
        private n.a<DataT> c() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.b.b(this.h(this.d), this.e, this.f, this.g);
            }
            Uri uri;
            if (this.g()) {
                uri = MediaStore.setRequireOriginal(this.d);
            }
            else {
                uri = this.d;
            }
            return this.c.b(uri, this.e, this.f, this.g);
        }
        
        private com.bumptech.glide.load.data.d<DataT> f() throws FileNotFoundException {
            final n.a<DataT> c = this.c();
            com.bumptech.glide.load.data.d<DataT> c2;
            if (c != null) {
                c2 = c.c;
            }
            else {
                c2 = null;
            }
            return c2;
        }
        
        private boolean g() {
            return this.a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }
        
        private File h(final Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                final Cursor query = this.a.getContentResolver().query(uri, i2.d.d.p, (String)null, (String[])null, (String)null);
                if (query != null) {
                    cursor = query;
                    if (query.moveToFirst()) {
                        cursor = query;
                        final String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        cursor = query;
                        if (!TextUtils.isEmpty((CharSequence)string)) {
                            cursor = query;
                            final File file = new File(string);
                            query.close();
                            return file;
                        }
                        cursor = query;
                        cursor = query;
                        cursor = query;
                        final StringBuilder sb = new StringBuilder();
                        cursor = query;
                        sb.append("File path was empty in media store for: ");
                        cursor = query;
                        sb.append(uri);
                        cursor = query;
                        final FileNotFoundException ex = new FileNotFoundException(sb.toString());
                        cursor = query;
                        throw ex;
                    }
                }
                cursor = query;
                cursor = query;
                cursor = query;
                final StringBuilder sb2 = new StringBuilder();
                cursor = query;
                sb2.append("Failed to media store entry for: ");
                cursor = query;
                sb2.append(uri);
                cursor = query;
                final FileNotFoundException ex2 = new FileNotFoundException(sb2.toString());
                cursor = query;
                throw ex2;
            }
            finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        
        @Override
        public Class<DataT> a() {
            return this.h;
        }
        
        @Override
        public void b() {
            final com.bumptech.glide.load.data.d<DataT> j = this.j;
            if (j != null) {
                j.b();
            }
        }
        
        @Override
        public void cancel() {
            this.i = true;
            final com.bumptech.glide.load.data.d<DataT> j = this.j;
            if (j != null) {
                j.cancel();
            }
        }
        
        @Override
        public DataSource d() {
            return DataSource.LOCAL;
        }
        
        @Override
        public void e(final Priority priority, final com.bumptech.glide.load.data.d.a<? super DataT> a) {
            try {
                final com.bumptech.glide.load.data.d<DataT> f = this.f();
                if (f == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Failed to build fetcher for: ");
                    sb.append(this.d);
                    a.c(new IllegalArgumentException(sb.toString()));
                    return;
                }
                this.j = f;
                if (this.i) {
                    this.cancel();
                }
                else {
                    f.e(priority, a);
                }
            }
            catch (final FileNotFoundException ex) {
                a.c(ex);
            }
        }
    }
}
