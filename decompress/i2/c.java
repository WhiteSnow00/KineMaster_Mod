// 
// Decompiled by Procyon v0.6.0
// 

package i2;

import h2.r;
import h2.o;
import u2.d;
import d2.b;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import c2.e;
import android.content.Context;
import java.io.InputStream;
import android.net.Uri;
import h2.n;

public class c implements n<Uri, InputStream>
{
    private final Context a;
    
    public c(final Context context) {
        this.a = context.getApplicationContext();
    }
    
    private boolean e(final e e) {
        final Long n = e.c(VideoDecoder.d);
        return n != null && n == -1L;
    }
    
    @Override
    public /* bridge */ boolean a(final Object o) {
        return this.d((Uri)o);
    }
    
    @Override
    public /* bridge */ n.a b(final Object o, final int n, final int n2, final e e) {
        return this.c((Uri)o, n, n2, e);
    }
    
    public n.a<InputStream> c(final Uri uri, final int n, final int n2, final e e) {
        if (b.d(n, n2) && this.e(e)) {
            return (n.a<InputStream>)new n.a(new d(uri), (com.bumptech.glide.load.data.d<Object>)d2.c.g(this.a, uri));
        }
        return null;
    }
    
    public boolean d(final Uri uri) {
        return b.c(uri);
    }
    
    public static class a implements o<Uri, InputStream>
    {
        private final Context a;
        
        public a(final Context a) {
            this.a = a;
        }
        
        @Override
        public n<Uri, InputStream> b(final r r) {
            return new c(this.a);
        }
    }
}
