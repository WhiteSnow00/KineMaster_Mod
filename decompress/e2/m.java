// 
// Decompiled by Procyon v0.6.0
// 

package e2;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.Arrays;
import java.util.NavigableMap;
import java.util.Map;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;

public class m implements k
{
    private static final Bitmap$Config[] d;
    private static final Bitmap$Config[] e;
    private static final Bitmap$Config[] f;
    private static final Bitmap$Config[] g;
    private static final Bitmap$Config[] h;
    private final c a;
    private final g<b, Bitmap> b;
    private final Map<Bitmap$Config, NavigableMap<Integer, Integer>> c;
    
    static {
        final Bitmap$Config[] array = Arrays.copyOf(new Bitmap$Config[] { Bitmap$Config.ARGB_8888, null }, 3);
        array[array.length - 1] = Bitmap$Config.RGBA_F16;
        d = array;
        e = array;
        f = new Bitmap$Config[] { Bitmap$Config.RGB_565 };
        g = new Bitmap$Config[] { Bitmap$Config.ARGB_4444 };
        h = new Bitmap$Config[] { Bitmap$Config.ALPHA_8 };
    }
    
    public m() {
        this.a = new c();
        this.b = new g<b, Bitmap>();
        this.c = new HashMap<Bitmap$Config, NavigableMap<Integer, Integer>>();
    }
    
    private void f(final Integer n, final Bitmap bitmap) {
        final NavigableMap<Integer, Integer> j = this.j(bitmap.getConfig());
        final Integer n2 = j.get(n);
        if (n2 != null) {
            if (n2 == 1) {
                j.remove(n);
            }
            else {
                j.put(n, n2 - 1);
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Tried to decrement empty size, size: ");
        sb.append(n);
        sb.append(", removed: ");
        sb.append(this.a(bitmap));
        sb.append(", this: ");
        sb.append(this);
        throw new NullPointerException(sb.toString());
    }
    
    private b g(final int n, final Bitmap$Config bitmap$Config) {
        final b e = this.a.e(n, bitmap$Config);
        final Bitmap$Config[] i = i(bitmap$Config);
        final int length = i.length;
        int n2 = 0;
        l e2;
        while (true) {
            e2 = e;
            if (n2 >= length) {
                break;
            }
            final Bitmap$Config bitmap$Config2 = i[n2];
            final Integer n3 = this.j(bitmap$Config2).ceilingKey(n);
            if (n3 != null && n3 <= n * 8) {
                if (n3 == n) {
                    if (bitmap$Config2 == null) {
                        e2 = e;
                        if (bitmap$Config == null) {
                            break;
                        }
                    }
                    else {
                        e2 = e;
                        if (bitmap$Config2.equals((Object)bitmap$Config)) {
                            break;
                        }
                    }
                }
                this.a.c(e);
                e2 = this.a.e(n3, bitmap$Config2);
                break;
            }
            ++n2;
        }
        return (b)e2;
    }
    
    static String h(final int n, final Bitmap$Config bitmap$Config) {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(n);
        sb.append("](");
        sb.append(bitmap$Config);
        sb.append(")");
        return sb.toString();
    }
    
    private static Bitmap$Config[] i(final Bitmap$Config bitmap$Config) {
        if (Bitmap$Config.RGBA_F16.equals((Object)bitmap$Config)) {
            return m.e;
        }
        final int n = m$a.a[bitmap$Config.ordinal()];
        if (n == 1) {
            return m.d;
        }
        if (n == 2) {
            return m.f;
        }
        if (n == 3) {
            return m.g;
        }
        if (n != 4) {
            return new Bitmap$Config[] { bitmap$Config };
        }
        return m.h;
    }
    
    private NavigableMap<Integer, Integer> j(final Bitmap$Config bitmap$Config) {
        NavigableMap navigableMap;
        if ((navigableMap = this.c.get(bitmap$Config)) == null) {
            navigableMap = new TreeMap();
            this.c.put(bitmap$Config, navigableMap);
        }
        return navigableMap;
    }
    
    @Override
    public String a(final Bitmap bitmap) {
        return h(v2.l.h(bitmap), bitmap.getConfig());
    }
    
    @Override
    public String b(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        return h(v2.l.g(n, n2, bitmap$Config), bitmap$Config);
    }
    
    @Override
    public void c(final Bitmap bitmap) {
        final b e = this.a.e(v2.l.h(bitmap), bitmap.getConfig());
        this.b.d(e, bitmap);
        final NavigableMap<Integer, Integer> j = this.j(bitmap.getConfig());
        final Integer n = j.get(e.b);
        final int b = e.b;
        int n2 = 1;
        if (n != null) {
            n2 = 1 + n;
        }
        j.put(b, n2);
    }
    
    @Override
    public Bitmap d(final int n, final int n2, final Bitmap$Config bitmap$Config) {
        final b g = this.g(v2.l.g(n, n2, bitmap$Config), bitmap$Config);
        final Bitmap bitmap = this.b.a(g);
        if (bitmap != null) {
            this.f(g.b, bitmap);
            bitmap.reconfigure(n, n2, bitmap$Config);
        }
        return bitmap;
    }
    
    @Override
    public int e(final Bitmap bitmap) {
        return v2.l.h(bitmap);
    }
    
    @Override
    public Bitmap removeLast() {
        final Bitmap bitmap = this.b.f();
        if (bitmap != null) {
            this.f(v2.l.h(bitmap), bitmap);
        }
        return bitmap;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.b);
        sb.append(", sortedSizes=(");
        for (final Map.Entry<Object, V> entry : this.c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
    
    static final class b implements l
    {
        private final c a;
        int b;
        private Bitmap$Config c;
        
        public b(final c a) {
            this.a = a;
        }
        
        @Override
        public void a() {
            this.a.c(this);
        }
        
        public void b(final int b, final Bitmap$Config c) {
            this.b = b;
            this.c = c;
        }
        
        @Override
        public boolean equals(final Object o) {
            final boolean b = o instanceof b;
            boolean b3;
            final boolean b2 = b3 = false;
            if (b) {
                final b b4 = (b)o;
                b3 = b2;
                if (this.b == b4.b) {
                    b3 = b2;
                    if (v2.l.d(this.c, b4.c)) {
                        b3 = true;
                    }
                }
            }
            return b3;
        }
        
        @Override
        public int hashCode() {
            final int b = this.b;
            final Bitmap$Config c = this.c;
            int hashCode;
            if (c != null) {
                hashCode = c.hashCode();
            }
            else {
                hashCode = 0;
            }
            return b * 31 + hashCode;
        }
        
        @Override
        public String toString() {
            return m.h(this.b, this.c);
        }
    }
    
    static class c extends e2.c<b>
    {
        protected /* bridge */ l a() {
            return this.d();
        }
        
        protected b d() {
            return new b(this);
        }
        
        public b e(final int n, final Bitmap$Config bitmap$Config) {
            final b b = this.b();
            b.b(n, bitmap$Config);
            return b;
        }
    }
}
