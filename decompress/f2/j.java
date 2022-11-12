// 
// Decompiled by Procyon v0.6.0
// 

package f2;

import w2.c;
import v2.l;
import v2.k;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import w2.a;
import androidx.core.util.e;
import c2.b;
import v2.h;

public class j
{
    private final h<c2.b, String> a;
    private final e<b> b;
    
    public j() {
        this.a = new h<c2.b, String>(1000L);
        this.b = w2.a.d(10, (a.d<b>)new a.d<b>() {
            final j a;
            
            @Override
            public /* bridge */ Object a() {
                return this.b();
            }
            
            public b b() {
                try {
                    return new b(MessageDigest.getInstance("SHA-256"));
                }
                catch (final NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    
    private String a(final c2.b b) {
        final b b2 = k.d(this.b.a());
        try {
            b.b(b2.a);
            return l.x(b2.a.digest());
        }
        finally {
            this.b.b(b2);
        }
    }
    
    public String b(final c2.b b) {
        Object o = this.a;
        synchronized (o) {
            final String s = this.a.g(b);
            monitorexit(o);
            o = s;
            if (s == null) {
                o = this.a(b);
            }
            synchronized (this.a) {
                this.a.k(b, (String)o);
                return (String)o;
            }
        }
    }
    
    private static final class b implements f
    {
        final MessageDigest a;
        private final c b;
        
        b(final MessageDigest a) {
            this.b = c.a();
            this.a = a;
        }
        
        @Override
        public c d() {
            return this.b;
        }
    }
}
