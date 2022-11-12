// 
// Decompiled by Procyon v0.6.0
// 

package b3;

import java.util.Arrays;
import com.fasterxml.jackson.core.util.InternCache;
import com.fasterxml.jackson.core.JsonFactory;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;

public final class b
{
    private final b a;
    private final AtomicReference<b> b;
    private final int c;
    private final int d;
    private boolean e;
    private String[] f;
    private a[] g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private BitSet m;
    
    private b(final int c) {
        this.a = null;
        this.c = c;
        this.e = true;
        this.d = -1;
        this.l = false;
        this.k = 0;
        this.b = new AtomicReference<b>(b3.b.b.a(64));
    }
    
    private b(final b a, int length, final int c, final b b) {
        this.a = a;
        this.c = c;
        this.b = null;
        this.d = length;
        this.e = JsonFactory.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(length);
        final String[] c2 = b.c;
        this.f = c2;
        this.g = b.d;
        this.h = b.a;
        this.k = b.b;
        length = c2.length;
        this.i = e(length);
        this.j = length - 1;
        this.l = true;
    }
    
    private String a(final char[] array, int c, int n, final int n2, int d) {
        if (this.l) {
            this.l();
            this.l = false;
        }
        else if (this.h >= this.i) {
            this.t();
            d = this.d(this.k(array, c, n));
        }
        String intern;
        final String s = intern = new String(array, c, n);
        if (JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(this.d)) {
            intern = InternCache.instance.intern(s);
        }
        ++this.h;
        final String[] f = this.f;
        if (f[d] == null) {
            f[d] = intern;
        }
        else {
            n = d >> 1;
            final a a = new a(intern, this.g[n]);
            c = a.c;
            if (c > 100) {
                this.c(n, a);
            }
            else {
                this.g[n] = a;
                this.k = Math.max(c, this.k);
            }
        }
        return intern;
    }
    
    private String b(final char[] array, final int n, final int n2, a b) {
        while (b != null) {
            final String a = b.a(array, n, n2);
            if (a != null) {
                return a;
            }
            b = b.b;
        }
        return null;
    }
    
    private void c(final int n, final a a) {
        final BitSet m = this.m;
        if (m == null) {
            (this.m = new BitSet()).set(n);
        }
        else if (m.get(n)) {
            if (JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(this.d)) {
                this.v(100);
            }
            this.e = false;
        }
        else {
            this.m.set(n);
        }
        this.f[n + n] = a.a;
        this.g[n] = null;
        this.h -= a.c;
        this.k = -1;
    }
    
    private static int e(final int n) {
        return n - (n >> 2);
    }
    
    static int f(final b b) {
        return b.h;
    }
    
    static int g(final b b) {
        return b.k;
    }
    
    static String[] h(final b b) {
        return b.f;
    }
    
    static a[] i(final b b) {
        return b.g;
    }
    
    private void l() {
        final String[] f = this.f;
        this.f = Arrays.copyOf(f, f.length);
        final a[] g = this.g;
        this.g = Arrays.copyOf(g, g.length);
    }
    
    public static b m() {
        final long currentTimeMillis = System.currentTimeMillis();
        return n((int)currentTimeMillis + (int)(currentTimeMillis >>> 32) | 0x1);
    }
    
    protected static b n(final int n) {
        return new b(n);
    }
    
    private void s(b a) {
        final int a2 = a.a;
        final b b = this.b.get();
        if (a2 == b.a) {
            return;
        }
        if (a2 > 12000) {
            a = b3.b.b.a(64);
        }
        this.b.compareAndSet(b, a);
    }
    
    private void t() {
        final String[] f = this.f;
        final int length = f.length;
        final int n = length + length;
        if (n > 65536) {
            this.h = 0;
            this.e = false;
            this.f = new String[64];
            this.g = new a[32];
            this.j = 63;
            this.l = false;
            return;
        }
        final a[] g = this.g;
        this.f = new String[n];
        this.g = new a[n >> 1];
        this.j = n - 1;
        this.i = e(n);
        int i = 0;
        int n3;
        int n2 = n3 = 0;
        while (i < length) {
            final String s = f[i];
            int n4 = n2;
            int max = n3;
            if (s != null) {
                n4 = n2 + 1;
                final int d = this.d(this.j(s));
                final String[] f2 = this.f;
                if (f2[d] == null) {
                    f2[d] = s;
                    max = n3;
                }
                else {
                    final int n5 = d >> 1;
                    final a a = new a(s, this.g[n5]);
                    this.g[n5] = a;
                    max = Math.max(n3, a.c);
                }
            }
            ++i;
            n2 = n4;
            n3 = max;
        }
        final int n6 = 0;
        int k = n3;
        int n7 = n2;
        int max2;
        for (int j = n6; j < length >> 1; ++j, k = max2) {
            a b = g[j];
            max2 = k;
            while (b != null) {
                ++n7;
                final String a2 = b.a;
                final int d2 = this.d(this.j(a2));
                final String[] f3 = this.f;
                if (f3[d2] == null) {
                    f3[d2] = a2;
                }
                else {
                    final int n8 = d2 >> 1;
                    final a a3 = new a(a2, this.g[n8]);
                    this.g[n8] = a3;
                    max2 = Math.max(max2, a3.c);
                }
                b = b.b;
            }
        }
        this.k = k;
        this.m = null;
        if (n7 == this.h) {
            return;
        }
        throw new IllegalStateException(String.format("Internal error on SymbolTable.rehash(): had %d entries; now have %d", this.h, n7));
    }
    
    public int d(int n) {
        n += n >>> 15;
        n ^= n << 7;
        return n + (n >>> 3) & this.j;
    }
    
    public int j(final String s) {
        final int length = s.length();
        int c = this.c;
        for (int i = 0; i < length; ++i) {
            c = c * 33 + s.charAt(i);
        }
        int n;
        if ((n = c) == 0) {
            n = 1;
        }
        return n;
    }
    
    public int k(final char[] array, int n, final int n2) {
        int c = this.c;
        for (int i = n; i < n2 + n; ++i) {
            c = c * 33 + array[i];
        }
        if ((n = c) == 0) {
            n = 1;
        }
        return n;
    }
    
    public String o(final char[] array, final int n, final int n2, final int n3) {
        if (n2 < 1) {
            return "";
        }
        if (!this.e) {
            return new String(array, n, n2);
        }
        final int d = this.d(n3);
        final String s = this.f[d];
        if (s != null) {
            if (s.length() == n2) {
                int n4 = 0;
                while (s.charAt(n4) == array[n + n4]) {
                    if (++n4 == n2) {
                        return s;
                    }
                }
            }
            final a a = this.g[d >> 1];
            if (a != null) {
                final String a2 = a.a(array, n, n2);
                if (a2 != null) {
                    return a2;
                }
                final String b = this.b(array, n, n2, a.b);
                if (b != null) {
                    return b;
                }
            }
        }
        return this.a(array, n, n2, n3, d);
    }
    
    public int p() {
        return this.c;
    }
    
    public b q(final int n) {
        return new b(this, n, this.c, this.b.get());
    }
    
    public boolean r() {
        return this.l ^ true;
    }
    
    public void u() {
        if (!this.r()) {
            return;
        }
        final b a = this.a;
        if (a != null && this.e) {
            a.s(new b(this));
            this.l = true;
        }
    }
    
    protected void v(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Longest collision chain in symbol table (of size ");
        sb.append(this.h);
        sb.append(") now exceeds maximum, ");
        sb.append(n);
        sb.append(" -- suspect a DoS attack based on hash collisions");
        throw new IllegalStateException(sb.toString());
    }
    
    static final class a
    {
        public final String a;
        public final a b;
        public final int c;
        
        public a(final String a, final a b) {
            this.a = a;
            this.b = b;
            int c = 1;
            if (b != null) {
                c = 1 + b.c;
            }
            this.c = c;
        }
        
        public String a(final char[] array, final int n, final int n2) {
            if (this.a.length() != n2) {
                return null;
            }
            int n3 = 0;
            while (this.a.charAt(n3) == array[n + n3]) {
                if (++n3 >= n2) {
                    return this.a;
                }
            }
            return null;
        }
    }
    
    private static final class b
    {
        final int a;
        final int b;
        final String[] c;
        final a[] d;
        
        public b(final int a, final int b, final String[] c, final a[] d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        public b(final b3.b b) {
            this.a = b3.b.f(b);
            this.b = b3.b.g(b);
            this.c = b3.b.h(b);
            this.d = b3.b.i(b);
        }
        
        public static b a(final int n) {
            return new b(0, 0, new String[n], new a[n >> 1]);
        }
    }
}
