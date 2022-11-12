// 
// Decompiled by Procyon v0.6.0
// 

package i2;

import h2.r;
import h2.o;
import h2.g;
import java.io.InputStream;
import java.net.URL;
import h2.n;

public class e implements n<URL, InputStream>
{
    private final n<g, InputStream> a;
    
    public e(final n<g, InputStream> a) {
        this.a = a;
    }
    
    @Override
    public /* bridge */ boolean a(final Object o) {
        return this.d((URL)o);
    }
    
    @Override
    public /* bridge */ n.a b(final Object o, final int n, final int n2, final c2.e e) {
        return this.c((URL)o, n, n2, e);
    }
    
    public n.a<InputStream> c(final URL url, final int n, final int n2, final c2.e e) {
        return this.a.b(new g(url), n, n2, e);
    }
    
    public boolean d(final URL url) {
        return true;
    }
    
    public static class a implements o<URL, InputStream>
    {
        @Override
        public n<URL, InputStream> b(final r r) {
            return new e(r.d(g.class, InputStream.class));
        }
    }
}
