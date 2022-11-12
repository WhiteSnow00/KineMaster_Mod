// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics;

import android.os.Handler;
import androidx.core.content.res.f;
import android.content.res.Resources;
import androidx.core.content.res.d;
import androidx.core.provider.g;
import android.os.CancellationSignal;
import android.content.Context;
import android.os.Build$VERSION;
import android.graphics.Typeface;
import androidx.collection.e;

public class h
{
    private static final m a;
    private static final e<String, Typeface> b;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 29) {
            a = new l();
        }
        else if (sdk_INT >= 28) {
            a = new k();
        }
        else {
            a = new j();
        }
        b = new e<String, Typeface>(16);
    }
    
    public static Typeface a(final Context context, final Typeface typeface, final int n) {
        if (context != null) {
            return Typeface.create(typeface, n);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }
    
    public static Typeface b(final Context context, final CancellationSignal cancellationSignal, final g.b[] array, final int n) {
        return h.a.b(context, cancellationSignal, array, n);
    }
    
    public static Typeface c(final Context context, final d.b b, final Resources resources, final int n, final String s, final int n2, final int n3, final f.e e, Handler e2, final boolean b2) {
        Typeface typeface;
        if (b instanceof d.e) {
            final d.e e3 = (d.e)b;
            final Typeface g = g(e3.c());
            if (g != null) {
                if (e != null) {
                    e.d(g, e2);
                }
                return g;
            }
            final boolean b3 = b2 ? (e3.a() == 0) : (e == null);
            int d;
            if (b2) {
                d = e3.d();
            }
            else {
                d = -1;
            }
            e2 = f.e.e(e2);
            typeface = androidx.core.provider.g.c(context, e3.b(), n3, b3, d, e2, (g.c)new a(e));
        }
        else {
            final Typeface typeface2 = typeface = h.a.a(context, (d.c)b, resources, n3);
            if (e != null) {
                if (typeface2 != null) {
                    e.d(typeface2, e2);
                    typeface = typeface2;
                }
                else {
                    e.c(-3, e2);
                    typeface = typeface2;
                }
            }
        }
        if (typeface != null) {
            h.b.put(e(resources, n, s, n2, n3), typeface);
        }
        return typeface;
    }
    
    public static Typeface d(final Context context, final Resources resources, final int n, final String s, final int n2, final int n3) {
        final Typeface c = h.a.c(context, resources, n, s, n3);
        if (c != null) {
            h.b.put(e(resources, n, s, n2, n3), c);
        }
        return c;
    }
    
    private static String e(final Resources resources, final int n, final String s, final int n2, final int n3) {
        final StringBuilder sb = new StringBuilder(resources.getResourcePackageName(n));
        sb.append('-');
        sb.append(s);
        sb.append('-');
        sb.append(n2);
        sb.append('-');
        sb.append(n);
        sb.append('-');
        sb.append(n3);
        return sb.toString();
    }
    
    public static Typeface f(final Resources resources, final int n, final String s, final int n2, final int n3) {
        return h.b.get(e(resources, n, s, n2, n3));
    }
    
    private static Typeface g(final String s) {
        Typeface typeface2;
        final Typeface typeface = typeface2 = null;
        if (s != null) {
            if (s.isEmpty()) {
                typeface2 = typeface;
            }
            else {
                final Typeface create = Typeface.create(s, 0);
                final Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
                typeface2 = typeface;
                if (create != null) {
                    typeface2 = typeface;
                    if (!create.equals((Object)create2)) {
                        typeface2 = create;
                    }
                }
            }
        }
        return typeface2;
    }
    
    public static class a extends c
    {
        private f.e a;
        
        public a(final f.e a) {
            this.a = a;
        }
        
        @Override
        public void a(final int n) {
            final f.e a = this.a;
            if (a != null) {
                a.h(n);
            }
        }
        
        @Override
        public void b(final Typeface typeface) {
            final f.e a = this.a;
            if (a != null) {
                a.i(typeface);
            }
        }
    }
}
