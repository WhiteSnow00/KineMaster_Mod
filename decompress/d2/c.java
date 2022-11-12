// 
// Decompiled by Procyon v0.6.0
// 

package d2;

import android.provider.MediaStore$Video$Thumbnails;
import android.provider.MediaStore$Images$Thumbnails;
import android.database.Cursor;
import android.content.ContentResolver;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import java.io.IOException;
import java.io.FileNotFoundException;
import com.bumptech.glide.load.data.g;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;
import com.bumptech.glide.load.data.d;

public class c implements d<InputStream>
{
    private final Uri a;
    private final e b;
    private InputStream c;
    
    c(final Uri a, final e b) {
        this.a = a;
        this.b = b;
    }
    
    private static c c(final Context context, final Uri uri, final d2.d d) {
        return new c(uri, new e(com.bumptech.glide.c.c(context).j().g(), d, com.bumptech.glide.c.c(context).e(), context.getContentResolver()));
    }
    
    public static c f(final Context context, final Uri uri) {
        return c(context, uri, new a(context.getContentResolver()));
    }
    
    public static c g(final Context context, final Uri uri) {
        return c(context, uri, new b(context.getContentResolver()));
    }
    
    private InputStream h() throws FileNotFoundException {
        final InputStream d = this.b.d(this.a);
        int a;
        if (d != null) {
            a = this.b.a(this.a);
        }
        else {
            a = -1;
        }
        InputStream inputStream = d;
        if (a != -1) {
            inputStream = new g(d, a);
        }
        return inputStream;
    }
    
    @Override
    public Class<InputStream> a() {
        return InputStream.class;
    }
    
    @Override
    public void b() {
        final InputStream c = this.c;
        if (c == null) {
            return;
        }
        try {
            c.close();
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
    public void e(final Priority priority, final d.a<? super InputStream> a) {
        try {
            a.f(this.c = this.h());
        }
        catch (final FileNotFoundException ex) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", (Throwable)ex);
            }
            a.c(ex);
        }
    }
    
    static class a implements d
    {
        private static final String[] b;
        private final ContentResolver a;
        
        static {
            b = new String[] { "_data" };
        }
        
        a(final ContentResolver a) {
            this.a = a;
        }
        
        @Override
        public Cursor a(final Uri uri) {
            return this.a.query(MediaStore$Images$Thumbnails.EXTERNAL_CONTENT_URI, d2.c.a.b, "kind = 1 AND image_id = ?", new String[] { uri.getLastPathSegment() }, (String)null);
        }
    }
    
    static class b implements d
    {
        private static final String[] b;
        private final ContentResolver a;
        
        static {
            b = new String[] { "_data" };
        }
        
        b(final ContentResolver a) {
            this.a = a;
        }
        
        @Override
        public Cursor a(final Uri uri) {
            return this.a.query(MediaStore$Video$Thumbnails.EXTERNAL_CONTENT_URI, d2.c.b.b, "kind = 1 AND video_id = ?", new String[] { uri.getLastPathSegment() }, (String)null);
        }
    }
}
