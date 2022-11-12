// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import java.io.InputStream;
import com.bumptech.glide.load.data.i;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.data.a;
import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import c2.b;
import u2.d;
import c2.e;
import java.util.Collections;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import android.net.Uri;

public class w<Data> implements n<Uri, Data>
{
    private static final Set<String> b;
    private final c<Data> a;
    
    static {
        b = Collections.unmodifiableSet((Set<? extends String>)new HashSet<String>(Arrays.asList("file", "android.resource", "content")));
    }
    
    public w(final c<Data> a) {
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
    
    public n.a<Data> c(final Uri uri, final int n, final int n2, final e e) {
        return (n.a<Data>)new n.a(new u2.d(uri), (com.bumptech.glide.load.data.d<Object>)this.a.a(uri));
    }
    
    public boolean d(final Uri uri) {
        return w.b.contains(uri.getScheme());
    }
    
    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor>
    {
        private final ContentResolver a;
        
        public a(final ContentResolver a) {
            this.a = a;
        }
        
        @Override
        public com.bumptech.glide.load.data.d<AssetFileDescriptor> a(final Uri uri) {
            return new com.bumptech.glide.load.data.a(this.a, uri);
        }
        
        @Override
        public n<Uri, AssetFileDescriptor> b(final r r) {
            return new w<AssetFileDescriptor>((c<AssetFileDescriptor>)this);
        }
    }
    
    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor>
    {
        private final ContentResolver a;
        
        public b(final ContentResolver a) {
            this.a = a;
        }
        
        @Override
        public com.bumptech.glide.load.data.d<ParcelFileDescriptor> a(final Uri uri) {
            return new i(this.a, uri);
        }
        
        @Override
        public n<Uri, ParcelFileDescriptor> b(final r r) {
            return new w<ParcelFileDescriptor>((c<ParcelFileDescriptor>)this);
        }
    }
    
    public interface c<Data>
    {
        com.bumptech.glide.load.data.d<Data> a(final Uri p0);
    }
    
    public static class d implements o<Uri, InputStream>, c<InputStream>
    {
        private final ContentResolver a;
        
        public d(final ContentResolver a) {
            this.a = a;
        }
        
        @Override
        public com.bumptech.glide.load.data.d<InputStream> a(final Uri uri) {
            return new com.bumptech.glide.load.data.n(this.a, uri);
        }
        
        @Override
        public n<Uri, InputStream> b(final r r) {
            return new w<InputStream>((c<InputStream>)this);
        }
    }
}
