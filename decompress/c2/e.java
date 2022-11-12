// 
// Decompiled by Procyon v0.6.0
// 

package c2;

import androidx.collection.g;
import java.security.MessageDigest;
import androidx.collection.a;

public final class e implements b
{
    private final a<d<?>, Object> b;
    
    public e() {
        this.b = new v2.b<d<?>, Object>();
    }
    
    private static <T> void f(final d<T> d, final Object o, final MessageDigest messageDigest) {
        d.g((T)o, messageDigest);
    }
    
    @Override
    public void b(final MessageDigest messageDigest) {
        for (int i = 0; i < this.b.size(); ++i) {
            f((d<Object>)this.b.i(i), this.b.m(i), messageDigest);
        }
    }
    
    public <T> T c(final d<T> d) {
        Object o;
        if (this.b.containsKey(d)) {
            o = this.b.get(d);
        }
        else {
            o = d.c();
        }
        return (T)o;
    }
    
    public void d(final e e) {
        this.b.j((g<?, ?>)e.b);
    }
    
    public <T> e e(final d<T> d, final T t) {
        this.b.put(d, t);
        return this;
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof e && this.b.equals(((e)o).b);
    }
    
    @Override
    public int hashCode() {
        return this.b.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Options{values=");
        sb.append(this.b);
        sb.append('}');
        return sb.toString();
    }
}
