// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import android.database.Cursor;
import java.io.FileNotFoundException;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import c2.b;
import u2.d;
import c2.e;
import android.content.Context;
import java.io.File;
import android.net.Uri;

public final class k implements n<Uri, File>
{
    private final Context a;
    
    public k(final Context a) {
        this.a = a;
    }
    
    @Override
    public /* bridge */ boolean a(final Object o) {
        return this.d((Uri)o);
    }
    
    @Override
    public /* bridge */ n.a b(final Object o, final int n, final int n2, final e e) {
        return this.c((Uri)o, n, n2, e);
    }
    
    public n.a<File> c(final Uri uri, final int n, final int n2, final e e) {
        return (n.a<File>)new n.a(new d(uri), (com.bumptech.glide.load.data.d<Object>)new b(this.a, uri));
    }
    
    public boolean d(final Uri uri) {
        return d2.b.b(uri);
    }
    
    public static final class a implements o<Uri, File>
    {
        private final Context a;
        
        public a(final Context a) {
            this.a = a;
        }
        
        @Override
        public n<Uri, File> b(final r r) {
            return new k(this.a);
        }
    }
    
    private static class b implements d<File>
    {
        private static final String[] c;
        private final Context a;
        private final Uri b;
        
        static {
            c = new String[] { "_data" };
        }
        
        b(final Context a, final Uri b) {
            this.a = a;
            this.b = b;
        }
        
        @Override
        public Class<File> a() {
            return File.class;
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
        public void e(final Priority priority, final d.a<? super File> a) {
            final Cursor query = this.a.getContentResolver().query(this.b, k.b.c, (String)null, (String[])null, (String)null);
            final String s = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                }
                finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty((CharSequence)s)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed to find file path for: ");
                sb.append(this.b);
                a.c(new FileNotFoundException(sb.toString()));
            }
            else {
                a.f(new File(s));
            }
        }
    }
}
