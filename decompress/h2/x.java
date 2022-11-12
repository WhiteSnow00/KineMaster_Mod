// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import java.io.InputStream;
import c2.e;
import java.util.Collections;
import java.util.Collection;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;
import android.net.Uri;

public class x<Data> implements n<Uri, Data>
{
    private static final Set<String> b;
    private final n<g, Data> a;
    
    static {
        b = Collections.unmodifiableSet((Set<? extends String>)new HashSet<String>(Arrays.asList("http", "https")));
    }
    
    public x(final n<g, Data> a) {
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
        return this.a.b(new g(uri.toString()), n, n2, e);
    }
    
    public boolean d(final Uri uri) {
        return x.b.contains(uri.getScheme());
    }
    
    public static class a implements o<Uri, InputStream>
    {
        @Override
        public n<Uri, InputStream> b(final r r) {
            return new x<InputStream>((n<g, InputStream>)r.d(g.class, (Class<Data>)InputStream.class));
        }
    }
}
