// 
// Decompiled by Procyon v0.6.0
// 

package j2;

import java.security.MessageDigest;
import com.bumptech.glide.load.engine.s;
import android.content.Context;
import c2.h;

public final class c<T> implements h<T>
{
    private static final h<?> b;
    
    static {
        b = new c<Object>();
    }
    
    private c() {
    }
    
    public static <T> c<T> c() {
        return (c)c.b;
    }
    
    @Override
    public s<T> a(final Context context, final s<T> s, final int n, final int n2) {
        return s;
    }
    
    @Override
    public void b(final MessageDigest messageDigest) {
    }
}
