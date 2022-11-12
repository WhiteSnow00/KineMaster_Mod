// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import com.bumptech.glide.load.data.m;
import java.io.InputStream;
import com.bumptech.glide.load.data.h;
import android.content.res.AssetFileDescriptor;
import c2.b;
import u2.d;
import c2.e;
import android.content.res.AssetManager;
import android.net.Uri;

public class a<Data> implements n<Uri, Data>
{
    private static final int c = 22;
    private final AssetManager a;
    private final a<Data> b;
    
    public a(final AssetManager a, final a<Data> b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public /* bridge */ boolean a(final Object o) {
        return this.d((Uri)o);
    }
    
    @Override
    public /* bridge */ n.a b(final Object o, final int n, final int n2, final e e) {
        return this.c((Uri)o, n, n2, e);
    }
    
    public n.a<Data> c(final Uri uri, final int n, final int n2, final e e) {
        return (n.a<Data>)new n.a(new d(uri), (com.bumptech.glide.load.data.d<Object>)this.b.a(this.a, uri.toString().substring(h2.a.c)));
    }
    
    public boolean d(final Uri uri) {
        final boolean equals = "file".equals(uri.getScheme());
        boolean b2;
        final boolean b = b2 = false;
        if (equals) {
            b2 = b;
            if (!uri.getPathSegments().isEmpty()) {
                b2 = b;
                if ("android_asset".equals(uri.getPathSegments().get(0))) {
                    b2 = true;
                }
            }
        }
        return b2;
    }
    
    public interface a<Data>
    {
        com.bumptech.glide.load.data.d<Data> a(final AssetManager p0, final String p1);
    }
    
    public static class b implements o<Uri, AssetFileDescriptor>, a<AssetFileDescriptor>
    {
        private final AssetManager a;
        
        public b(final AssetManager a) {
            this.a = a;
        }
        
        @Override
        public com.bumptech.glide.load.data.d<AssetFileDescriptor> a(final AssetManager assetManager, final String s) {
            return new h(assetManager, s);
        }
        
        @Override
        public n<Uri, AssetFileDescriptor> b(final r r) {
            return new a<AssetFileDescriptor>(this.a, (a<AssetFileDescriptor>)this);
        }
    }
    
    public static class c implements o<Uri, InputStream>, a<InputStream>
    {
        private final AssetManager a;
        
        public c(final AssetManager a) {
            this.a = a;
        }
        
        @Override
        public com.bumptech.glide.load.data.d<InputStream> a(final AssetManager assetManager, final String s) {
            return new m(assetManager, s);
        }
        
        @Override
        public n<Uri, InputStream> b(final r r) {
            return new a<InputStream>(this.a, (a<InputStream>)this);
        }
    }
}
