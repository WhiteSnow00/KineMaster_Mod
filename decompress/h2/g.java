// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import java.util.Map;
import java.security.MessageDigest;
import java.net.MalformedURLException;
import android.net.Uri;
import android.text.TextUtils;
import v2.k;
import java.net.URL;
import c2.b;

public class g implements b
{
    private final h b;
    private final URL c;
    private final String d;
    private String e;
    private URL f;
    private volatile byte[] g;
    private int h;
    
    public g(final String s) {
        this(s, h2.h.b);
    }
    
    public g(final String s, final h h) {
        this.c = null;
        this.d = k.b(s);
        this.b = k.d(h);
    }
    
    public g(final URL url) {
        this(url, h2.h.b);
    }
    
    public g(final URL url, final h h) {
        this.c = k.d(url);
        this.d = null;
        this.b = k.d(h);
    }
    
    private byte[] d() {
        if (this.g == null) {
            this.g = this.c().getBytes(c2.b.a);
        }
        return this.g;
    }
    
    private String f() {
        if (TextUtils.isEmpty((CharSequence)this.e)) {
            String s;
            if (TextUtils.isEmpty((CharSequence)(s = this.d))) {
                s = k.d(this.c).toString();
            }
            this.e = Uri.encode(s, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.e;
    }
    
    private URL g() throws MalformedURLException {
        if (this.f == null) {
            this.f = new URL(this.f());
        }
        return this.f;
    }
    
    @Override
    public void b(final MessageDigest messageDigest) {
        messageDigest.update(this.d());
    }
    
    public String c() {
        String s = this.d;
        if (s == null) {
            s = k.d(this.c).toString();
        }
        return s;
    }
    
    public Map<String, String> e() {
        return this.b.a();
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof g;
        boolean b3;
        final boolean b2 = b3 = false;
        if (b) {
            final g g = (g)o;
            b3 = b2;
            if (this.c().equals(g.c())) {
                b3 = b2;
                if (this.b.equals(g.b)) {
                    b3 = true;
                }
            }
        }
        return b3;
    }
    
    public URL h() throws MalformedURLException {
        return this.g();
    }
    
    @Override
    public int hashCode() {
        if (this.h == 0) {
            final int hashCode = this.c().hashCode();
            this.h = hashCode;
            this.h = hashCode * 31 + this.b.hashCode();
        }
        return this.h;
    }
    
    @Override
    public String toString() {
        return this.c();
    }
}
