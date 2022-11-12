// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics;

import java.io.File;
import androidx.core.provider.g;
import android.os.CancellationSignal;
import android.graphics.Typeface;
import android.content.res.Resources;
import android.content.Context;
import androidx.core.content.res.d;
import java.util.concurrent.ConcurrentHashMap;

class m
{
    private ConcurrentHashMap<Long, d.c> a;
    
    m() {
        this.a = new ConcurrentHashMap<Long, d.c>();
    }
    
    private static <T> T d(final T[] array, int i, final b<T> b) {
        int n;
        if ((i & 0x1) == 0x0) {
            n = 400;
        }
        else {
            n = 700;
        }
        final boolean b2 = (i & 0x2) != 0x0;
        T t = null;
        int n2 = Integer.MAX_VALUE;
        int length;
        T t2;
        int abs;
        int n3;
        int n4;
        int n5;
        for (length = array.length, i = 0; i < length; ++i, n2 = n5) {
            t2 = array[i];
            abs = Math.abs(b.b(t2) - n);
            if (b.a(t2) == b2) {
                n3 = 0;
            }
            else {
                n3 = 1;
            }
            n4 = abs * 2 + n3;
            if (t == null || (n5 = n2) > n4) {
                t = t2;
                n5 = n4;
            }
        }
        return t;
    }
    
    public Typeface a(final Context context, final d.c c, final Resources resources, final int n) {
        throw null;
    }
    
    public Typeface b(final Context context, final CancellationSignal cancellationSignal, final g.b[] array, final int n) {
        throw null;
    }
    
    public Typeface c(Context d, final Resources resources, final int n, final String s, final int n2) {
        d = (Context)n.d(d);
        if (d == null) {
            return null;
        }
        try {
            if (!n.b((File)d, resources, n)) {
                return null;
            }
            return Typeface.createFromFile(((File)d).getPath());
        }
        catch (final RuntimeException ex) {
            return null;
        }
        finally {
            ((File)d).delete();
        }
    }
    
    protected g.b e(final g.b[] array, final int n) {
        return d(array, n, (b<g.b>)new b<g.b>(this) {
            final m a;
            
            @Override
            public /* bridge */ boolean a(final Object o) {
                return this.d((g.b)o);
            }
            
            @Override
            public /* bridge */ int b(final Object o) {
                return this.c((g.b)o);
            }
            
            public int c(final g.b b) {
                return b.e();
            }
            
            public boolean d(final g.b b) {
                return b.f();
            }
        });
    }
    
    private interface b<T>
    {
        boolean a(final T p0);
        
        int b(final T p0);
    }
}
