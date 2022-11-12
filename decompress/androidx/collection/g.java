// 
// Decompiled by Procyon v0.6.0
// 

package androidx.collection;

import java.util.Map;
import java.util.ConcurrentModificationException;

public class g<K, V>
{
    static Object[] d;
    static int e;
    static Object[] f;
    static int g;
    int[] a;
    Object[] b;
    int c;
    
    public g() {
        this.a = androidx.collection.c.a;
        this.b = androidx.collection.c.c;
        this.c = 0;
    }
    
    public g(final int n) {
        if (n == 0) {
            this.a = androidx.collection.c.a;
            this.b = androidx.collection.c.c;
        }
        else {
            this.a(n);
        }
        this.c = 0;
    }
    
    public g(final g<K, V> g) {
        this();
        if (g != null) {
            this.j((g<? extends K, ? extends V>)g);
        }
    }
    
    private void a(final int n) {
        Label_0145: {
            if (n == 8) {
                synchronized (g.class) {
                    final Object[] f = androidx.collection.g.f;
                    if (f != null) {
                        this.b = f;
                        androidx.collection.g.f = (Object[])f[0];
                        this.a = (int[])f[1];
                        f[0] = (f[1] = null);
                        --androidx.collection.g.g;
                        return;
                    }
                    break Label_0145;
                }
            }
            if (n == 4) {
                synchronized (g.class) {
                    final Object[] d = androidx.collection.g.d;
                    if (d != null) {
                        this.b = d;
                        androidx.collection.g.d = (Object[])d[0];
                        this.a = (int[])d[1];
                        d[0] = (d[1] = null);
                        --androidx.collection.g.e;
                        return;
                    }
                }
            }
        }
        this.a = new int[n];
        this.b = new Object[n << 1];
    }
    
    private static int b(final int[] array, int a, final int n) {
        try {
            a = c.a(array, a, n);
            return a;
        }
        catch (final ArrayIndexOutOfBoundsException ex) {
            throw new ConcurrentModificationException();
        }
    }
    
    private static void d(final int[] array, final Object[] array2, int i) {
        if (array.length == 8) {
            synchronized (g.class) {
                if (androidx.collection.g.g < 10) {
                    array2[0] = androidx.collection.g.f;
                    array2[1] = array;
                    for (i = (i << 1) - 1; i >= 2; --i) {
                        array2[i] = null;
                    }
                    androidx.collection.g.f = array2;
                    ++androidx.collection.g.g;
                }
                return;
            }
        }
        if (array.length == 4) {
            synchronized (g.class) {
                if (androidx.collection.g.e < 10) {
                    array2[0] = androidx.collection.g.d;
                    array2[1] = array;
                    for (i = (i << 1) - 1; i >= 2; --i) {
                        array2[i] = null;
                    }
                    androidx.collection.g.d = array2;
                    ++androidx.collection.g.e;
                }
            }
        }
    }
    
    public void c(final int n) {
        final int c = this.c;
        final int[] a = this.a;
        if (a.length < n) {
            final Object[] b = this.b;
            this.a(n);
            if (this.c > 0) {
                System.arraycopy(a, 0, this.a, 0, c);
                System.arraycopy(b, 0, this.b, 0, c << 1);
            }
            d(a, b, c);
        }
        if (this.c == c) {
            return;
        }
        throw new ConcurrentModificationException();
    }
    
    public void clear() {
        final int c = this.c;
        if (c > 0) {
            final int[] a = this.a;
            final Object[] b = this.b;
            this.a = androidx.collection.c.a;
            this.b = androidx.collection.c.c;
            this.c = 0;
            d(a, b, c);
        }
        if (this.c <= 0) {
            return;
        }
        throw new ConcurrentModificationException();
    }
    
    public boolean containsKey(final Object o) {
        return this.f(o) >= 0;
    }
    
    public boolean containsValue(final Object o) {
        return this.h(o) >= 0;
    }
    
    int e(final Object o, final int n) {
        final int c = this.c;
        if (c == 0) {
            return -1;
        }
        final int b = b(this.a, c, n);
        if (b < 0) {
            return b;
        }
        if (o.equals(this.b[b << 1])) {
            return b;
        }
        int n2;
        for (n2 = b + 1; n2 < c && this.a[n2] == n; ++n2) {
            if (o.equals(this.b[n2 << 1])) {
                return n2;
            }
        }
        for (int n3 = b - 1; n3 >= 0 && this.a[n3] == n; --n3) {
            if (o.equals(this.b[n3 << 1])) {
                return n3;
            }
        }
        return ~n2;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof g) {
            final g g = (g)o;
            if (this.size() != g.size()) {
                return false;
            }
            int i = 0;
            try {
                while (i < this.c) {
                    final K j = this.i(i);
                    o = this.m(i);
                    final Object value = g.get(j);
                    if (o == null) {
                        if (value != null || !g.containsKey(j)) {
                            return false;
                        }
                    }
                    else if (!o.equals(value)) {
                        return false;
                    }
                    ++i;
                }
                return true;
            }
            catch (final NullPointerException | ClassCastException ex) {
                return false;
            }
        }
        if (!(o instanceof Map)) {
            return false;
        }
        final Map map = (Map)o;
        if (this.size() != map.size()) {
            return false;
        }
        int k = 0;
        try {
            while (k < this.c) {
                final K l = this.i(k);
                final V m = this.m(k);
                o = map.get(l);
                if (m == null) {
                    if (o != null || !map.containsKey(l)) {
                        return false;
                    }
                }
                else if (!m.equals(o)) {
                    return false;
                }
                ++k;
            }
            return true;
        }
        catch (final NullPointerException | ClassCastException ex2) {
            return false;
        }
    }
    
    public int f(final Object o) {
        int n;
        if (o == null) {
            n = this.g();
        }
        else {
            n = this.e(o, o.hashCode());
        }
        return n;
    }
    
    int g() {
        final int c = this.c;
        if (c == 0) {
            return -1;
        }
        final int b = b(this.a, c, 0);
        if (b < 0) {
            return b;
        }
        if (this.b[b << 1] == null) {
            return b;
        }
        int n;
        for (n = b + 1; n < c && this.a[n] == 0; ++n) {
            if (this.b[n << 1] == null) {
                return n;
            }
        }
        for (int n2 = b - 1; n2 >= 0 && this.a[n2] == 0; --n2) {
            if (this.b[n2 << 1] == null) {
                return n2;
            }
        }
        return ~n;
    }
    
    public V get(final Object o) {
        return this.getOrDefault(o, null);
    }
    
    public V getOrDefault(final Object o, V v) {
        final int f = this.f(o);
        if (f >= 0) {
            v = (V)this.b[(f << 1) + 1];
        }
        return v;
    }
    
    int h(final Object o) {
        final int n = this.c * 2;
        final Object[] b = this.b;
        if (o == null) {
            for (int i = 1; i < n; i += 2) {
                if (b[i] == null) {
                    return i >> 1;
                }
            }
        }
        else {
            for (int j = 1; j < n; j += 2) {
                if (o.equals(b[j])) {
                    return j >> 1;
                }
            }
        }
        return -1;
    }
    
    @Override
    public int hashCode() {
        final int[] a = this.a;
        final Object[] b = this.b;
        final int c = this.c;
        int n = 1;
        int i = 0;
        int n2 = 0;
        while (i < c) {
            final Object o = b[n];
            final int n3 = a[i];
            int hashCode;
            if (o == null) {
                hashCode = 0;
            }
            else {
                hashCode = o.hashCode();
            }
            n2 += (hashCode ^ n3);
            ++i;
            n += 2;
        }
        return n2;
    }
    
    public K i(final int n) {
        return (K)this.b[n << 1];
    }
    
    public boolean isEmpty() {
        return this.c <= 0;
    }
    
    public void j(final g<? extends K, ? extends V> g) {
        final int c = g.c;
        this.c(this.c + c);
        final int c2 = this.c;
        int i = 0;
        if (c2 == 0) {
            if (c > 0) {
                System.arraycopy(g.a, 0, this.a, 0, c);
                System.arraycopy(g.b, 0, this.b, 0, c << 1);
                this.c = c;
            }
        }
        else {
            while (i < c) {
                this.put(g.i(i), g.m(i));
                ++i;
            }
        }
    }
    
    public V k(int c) {
        final Object[] b = this.b;
        final int n = c << 1;
        final Object o = b[n + 1];
        final int c2 = this.c;
        final int n2 = 0;
        if (c2 <= 1) {
            d(this.a, b, c2);
            this.a = c.a;
            this.b = c.c;
            c = n2;
        }
        else {
            final int n3 = c2 - 1;
            final int[] a = this.a;
            final int length = a.length;
            int n4 = 8;
            if (length > 8 && c2 < a.length / 3) {
                if (c2 > 8) {
                    n4 = c2 + (c2 >> 1);
                }
                this.a(n4);
                if (c2 != this.c) {
                    throw new ConcurrentModificationException();
                }
                if (c > 0) {
                    System.arraycopy(a, 0, this.a, 0, c);
                    System.arraycopy(b, 0, this.b, 0, n);
                }
                if (c < n3) {
                    final int n5 = c + 1;
                    final int[] a2 = this.a;
                    final int n6 = n3 - c;
                    System.arraycopy(a, n5, a2, c, n6);
                    System.arraycopy(b, n5 << 1, this.b, n, n6 << 1);
                }
            }
            else {
                if (c < n3) {
                    final int n7 = c + 1;
                    final int n8 = n3 - c;
                    System.arraycopy(a, n7, a, c, n8);
                    final Object[] b2 = this.b;
                    System.arraycopy(b2, n7 << 1, b2, n, n8 << 1);
                }
                final Object[] b3 = this.b;
                c = n3 << 1;
                b3[c + 1] = (b3[c] = null);
            }
            c = n3;
        }
        if (c2 == this.c) {
            this.c = c;
            return (V)o;
        }
        throw new ConcurrentModificationException();
    }
    
    public V l(int n, final V v) {
        n = (n << 1) + 1;
        final Object[] b = this.b;
        final Object o = b[n];
        b[n] = v;
        return (V)o;
    }
    
    public V m(final int n) {
        return (V)this.b[(n << 1) + 1];
    }
    
    public V put(final K k, final V v) {
        final int c = this.c;
        int n;
        int hashCode;
        if (k == null) {
            n = this.g();
            hashCode = 0;
        }
        else {
            hashCode = k.hashCode();
            n = this.e(k, hashCode);
        }
        if (n >= 0) {
            final int n2 = (n << 1) + 1;
            final Object[] b = this.b;
            final Object o = b[n2];
            b[n2] = v;
            return (V)o;
        }
        final int n3 = ~n;
        final int[] a = this.a;
        if (c >= a.length) {
            int n4 = 4;
            if (c >= 8) {
                n4 = (c >> 1) + c;
            }
            else if (c >= 4) {
                n4 = 8;
            }
            final Object[] b2 = this.b;
            this.a(n4);
            if (c != this.c) {
                throw new ConcurrentModificationException();
            }
            final int[] a2 = this.a;
            if (a2.length > 0) {
                System.arraycopy(a, 0, a2, 0, a.length);
                System.arraycopy(b2, 0, this.b, 0, b2.length);
            }
            d(a, b2, c);
        }
        if (n3 < c) {
            final int[] a3 = this.a;
            final int n5 = n3 + 1;
            System.arraycopy(a3, n3, a3, n5, c - n3);
            final Object[] b3 = this.b;
            System.arraycopy(b3, n3 << 1, b3, n5 << 1, this.c - n3 << 1);
        }
        final int c2 = this.c;
        if (c == c2) {
            final int[] a4 = this.a;
            if (n3 < a4.length) {
                a4[n3] = hashCode;
                final Object[] b4 = this.b;
                final int n6 = n3 << 1;
                b4[n6] = k;
                b4[n6 + 1] = v;
                this.c = c2 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }
    
    public V putIfAbsent(final K k, final V v) {
        Object o;
        if ((o = this.get(k)) == null) {
            o = this.put(k, v);
        }
        return (V)o;
    }
    
    public V remove(final Object o) {
        final int f = this.f(o);
        if (f >= 0) {
            return this.k(f);
        }
        return null;
    }
    
    public boolean remove(Object m, final Object o) {
        final int f = this.f(m);
        if (f >= 0) {
            m = this.m(f);
            if (o == m || (o != null && o.equals(m))) {
                this.k(f);
                return true;
            }
        }
        return false;
    }
    
    public V replace(final K k, final V v) {
        final int f = this.f(k);
        if (f >= 0) {
            return this.l(f, v);
        }
        return null;
    }
    
    public boolean replace(final K k, final V v, final V v2) {
        final int f = this.f(k);
        if (f >= 0) {
            final V m = this.m(f);
            if (m == v || (v != null && v.equals(m))) {
                this.l(f, v2);
                return true;
            }
        }
        return false;
    }
    
    public int size() {
        return this.c;
    }
    
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        final StringBuilder sb = new StringBuilder(this.c * 28);
        sb.append('{');
        for (int i = 0; i < this.c; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            final K j = this.i(i);
            if (j != this) {
                sb.append(j);
            }
            else {
                sb.append("(this Map)");
            }
            sb.append('=');
            final V m = this.m(i);
            if (m != this) {
                sb.append(m);
            }
            else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
