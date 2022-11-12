// 
// Decompiled by Procyon v0.6.0
// 

package c2;

import java.security.MessageDigest;
import java.util.Iterator;
import com.bumptech.glide.load.engine.s;
import android.content.Context;
import java.util.Arrays;
import java.util.Collection;

public class c<T> implements h<T>
{
    private final Collection<? extends h<T>> b;
    
    @SafeVarargs
    public c(final h<T>... array) {
        if (array.length != 0) {
            this.b = Arrays.asList(array);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
    
    @Override
    public s<T> a(final Context context, final s<T> s, final int n, final int n2) {
        final Iterator<? extends h<T>> iterator = this.b.iterator();
        s<T> s2 = s;
        while (iterator.hasNext()) {
            final s<T> a = ((h<T>)iterator.next()).a(context, s2, n, n2);
            if (s2 != null && !s2.equals(s) && !s2.equals(a)) {
                s2.b();
            }
            s2 = a;
        }
        return s2;
    }
    
    @Override
    public void b(final MessageDigest messageDigest) {
        final Iterator<? extends h<T>> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            ((h<?>)iterator.next()).b(messageDigest);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof c && this.b.equals(((c)o).b);
    }
    
    @Override
    public int hashCode() {
        return this.b.hashCode();
    }
}
