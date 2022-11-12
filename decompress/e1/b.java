// 
// Decompiled by Procyon v0.6.0
// 

package e1;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

public final class b
{
    private final Set<a> a;
    
    public b() {
        this.a = new HashSet<a>();
    }
    
    public void a(final Uri uri, final boolean b) {
        this.a.add(new a(uri, b));
    }
    
    public Set<a> b() {
        return this.a;
    }
    
    public int c() {
        return this.a.size();
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && b.class == o.getClass() && this.a.equals(((b)o).a));
    }
    
    @Override
    public int hashCode() {
        return this.a.hashCode();
    }
    
    public static final class a
    {
        private final Uri a;
        private final boolean b;
        
        a(final Uri a, final boolean b) {
            this.a = a;
            this.b = b;
        }
        
        public Uri a() {
            return this.a;
        }
        
        public boolean b() {
            return this.b;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (o != null && a.class == o.getClass()) {
                final a a = (a)o;
                if (this.b != a.b || !this.a.equals((Object)a.a)) {
                    b = false;
                }
                return b;
            }
            return false;
        }
        
        @Override
        public int hashCode() {
            return this.a.hashCode() * 31 + (this.b ? 1 : 0);
        }
    }
}
