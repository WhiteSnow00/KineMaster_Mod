// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import java.io.InputStream;
import android.os.ParcelFileDescriptor;
import android.content.res.AssetFileDescriptor;
import c2.e;
import java.io.File;
import android.text.TextUtils;
import android.net.Uri;

public class u<Data> implements n<String, Data>
{
    private final n<Uri, Data> a;
    
    public u(final n<Uri, Data> a) {
        this.a = a;
    }
    
    private static Uri e(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return null;
        }
        Uri uri;
        if (s.charAt(0) == '/') {
            uri = f(s);
        }
        else {
            final Uri parse = Uri.parse(s);
            if (parse.getScheme() == null) {
                uri = f(s);
            }
            else {
                uri = parse;
            }
        }
        return uri;
    }
    
    private static Uri f(final String s) {
        return Uri.fromFile(new File(s));
    }
    
    @Override
    public /* bridge */ boolean a(final Object o) {
        return this.d((String)o);
    }
    
    @Override
    public /* bridge */ n.a b(final Object o, final int n, final int n2, final e e) {
        return this.c((String)o, n, n2, e);
    }
    
    public n.a<Data> c(final String s, final int n, final int n2, final e e) {
        final Uri e2 = e(s);
        if (e2 != null && this.a.a(e2)) {
            return this.a.b(e2, n, n2, e);
        }
        return null;
    }
    
    public boolean d(final String s) {
        return true;
    }
    
    public static final class a implements o<String, AssetFileDescriptor>
    {
        @Override
        public n<String, AssetFileDescriptor> b(final r r) {
            return new u<AssetFileDescriptor>((n<Uri, AssetFileDescriptor>)r.d(Uri.class, (Class<Data>)AssetFileDescriptor.class));
        }
    }
    
    public static class b implements o<String, ParcelFileDescriptor>
    {
        @Override
        public n<String, ParcelFileDescriptor> b(final r r) {
            return new u<ParcelFileDescriptor>((n<Uri, ParcelFileDescriptor>)r.d(Uri.class, (Class<Data>)ParcelFileDescriptor.class));
        }
    }
    
    public static class c implements o<String, InputStream>
    {
        @Override
        public n<String, InputStream> b(final r r) {
            return new u<InputStream>((n<Uri, InputStream>)r.d(Uri.class, (Class<Data>)InputStream.class));
        }
    }
}
