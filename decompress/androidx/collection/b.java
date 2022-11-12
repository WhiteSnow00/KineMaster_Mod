// 
// Decompiled by Procyon v0.6.0
// 

package androidx.collection;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public final class b<E> implements Collection<E>, Set<E>
{
    private static final int[] e;
    private static final Object[] f;
    private static Object[] g;
    private static int h;
    private static Object[] i;
    private static int j;
    private int[] a;
    Object[] b;
    int c;
    private f<E, E> d;
    
    static {
        e = new int[0];
        f = new Object[0];
    }
    
    public b() {
        this(0);
    }
    
    public b(final int n) {
        if (n == 0) {
            this.a = androidx.collection.b.e;
            this.b = androidx.collection.b.f;
        }
        else {
            this.a(n);
        }
        this.c = 0;
    }
    
    private void a(final int n) {
        Label_0145: {
            if (n == 8) {
                synchronized (b.class) {
                    final Object[] i = androidx.collection.b.i;
                    if (i != null) {
                        this.b = i;
                        androidx.collection.b.i = (Object[])i[0];
                        this.a = (int[])i[1];
                        i[0] = (i[1] = null);
                        --androidx.collection.b.j;
                        return;
                    }
                    break Label_0145;
                }
            }
            if (n == 4) {
                synchronized (b.class) {
                    final Object[] g = androidx.collection.b.g;
                    if (g != null) {
                        this.b = g;
                        androidx.collection.b.g = (Object[])g[0];
                        this.a = (int[])g[1];
                        g[0] = (g[1] = null);
                        --androidx.collection.b.h;
                        return;
                    }
                }
            }
        }
        this.a = new int[n];
        this.b = new Object[n];
    }
    
    private static void e(final int[] array, final Object[] array2, int i) {
        if (array.length == 8) {
            synchronized (b.class) {
                if (b.j < 10) {
                    array2[0] = b.i;
                    array2[1] = array;
                    --i;
                    while (i >= 2) {
                        array2[i] = null;
                        --i;
                    }
                    b.i = array2;
                    ++b.j;
                }
                return;
            }
        }
        if (array.length == 4) {
            synchronized (b.class) {
                if (b.h < 10) {
                    array2[0] = b.g;
                    array2[1] = array;
                    --i;
                    while (i >= 2) {
                        array2[i] = null;
                        --i;
                    }
                    b.g = array2;
                    ++b.h;
                }
            }
        }
    }
    
    private f<E, E> f() {
        if (this.d == null) {
            this.d = new f<E, E>(this) {
                final b d;
                
                @Override
                protected void a() {
                    this.d.clear();
                }
                
                @Override
                protected Object b(final int n, final int n2) {
                    return this.d.b[n];
                }
                
                @Override
                protected Map<E, E> c() {
                    throw new UnsupportedOperationException("not a map");
                }
                
                @Override
                protected int d() {
                    return this.d.c;
                }
                
                @Override
                protected int e(final Object o) {
                    return this.d.indexOf(o);
                }
                
                @Override
                protected int f(final Object o) {
                    return this.d.indexOf(o);
                }
                
                @Override
                protected void g(final E e, final E e2) {
                    this.d.add(e);
                }
                
                @Override
                protected void h(final int n) {
                    this.d.m(n);
                }
                
                @Override
                protected E i(final int n, final E e) {
                    throw new UnsupportedOperationException("not a map");
                }
            };
        }
        return this.d;
    }
    
    private int g(final Object o, final int n) {
        final int c = this.c;
        if (c == 0) {
            return -1;
        }
        final int a = androidx.collection.c.a(this.a, c, n);
        if (a < 0) {
            return a;
        }
        if (o.equals(this.b[a])) {
            return a;
        }
        int n2;
        for (n2 = a + 1; n2 < c && this.a[n2] == n; ++n2) {
            if (o.equals(this.b[n2])) {
                return n2;
            }
        }
        for (int n3 = a - 1; n3 >= 0 && this.a[n3] == n; --n3) {
            if (o.equals(this.b[n3])) {
                return n3;
            }
        }
        return ~n2;
    }
    
    private int k() {
        final int c = this.c;
        if (c == 0) {
            return -1;
        }
        int a = androidx.collection.c.a(this.a, c, 0);
        if (a < 0) {
            return a;
        }
        if (this.b[a] == null) {
            return a;
        }
        int n;
        for (n = a + 1; n < c && this.a[n] == 0; ++n) {
            if (this.b[n] == null) {
                return n;
            }
        }
        --a;
        while (a >= 0 && this.a[a] == 0) {
            if (this.b[a] == null) {
                return a;
            }
            --a;
        }
        return ~n;
    }
    
    @Override
    public boolean add(final E e) {
        int n;
        int hashCode;
        if (e == null) {
            n = this.k();
            hashCode = 0;
        }
        else {
            hashCode = e.hashCode();
            n = this.g(e, hashCode);
        }
        if (n >= 0) {
            return false;
        }
        final int n2 = ~n;
        final int c = this.c;
        final int[] a = this.a;
        if (c >= a.length) {
            int n3 = 4;
            if (c >= 8) {
                n3 = (c >> 1) + c;
            }
            else if (c >= 4) {
                n3 = 8;
            }
            final Object[] b = this.b;
            this.a(n3);
            final int[] a2 = this.a;
            if (a2.length > 0) {
                System.arraycopy(a, 0, a2, 0, a.length);
                System.arraycopy(b, 0, this.b, 0, b.length);
            }
            e(a, b, this.c);
        }
        final int c2 = this.c;
        if (n2 < c2) {
            final int[] a3 = this.a;
            final int n4 = n2 + 1;
            System.arraycopy(a3, n2, a3, n4, c2 - n2);
            final Object[] b2 = this.b;
            System.arraycopy(b2, n2, b2, n4, this.c - n2);
        }
        this.a[n2] = hashCode;
        this.b[n2] = e;
        ++this.c;
        return true;
    }
    
    @Override
    public boolean addAll(final Collection<? extends E> collection) {
        this.b(this.c + collection.size());
        final Iterator iterator = collection.iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            b |= this.add(iterator.next());
        }
        return b;
    }
    
    public void b(int c) {
        final int[] a = this.a;
        if (a.length < c) {
            final Object[] b = this.b;
            this.a(c);
            c = this.c;
            if (c > 0) {
                System.arraycopy(a, 0, this.a, 0, c);
                System.arraycopy(b, 0, this.b, 0, this.c);
            }
            e(a, b, this.c);
        }
    }
    
    @Override
    public void clear() {
        final int c = this.c;
        if (c != 0) {
            e(this.a, this.b, c);
            this.a = androidx.collection.b.e;
            this.b = androidx.collection.b.f;
            this.c = 0;
        }
    }
    
    @Override
    public boolean contains(final Object o) {
        return this.indexOf(o) >= 0;
    }
    
    @Override
    public boolean containsAll(final Collection<?> collection) {
        final Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!this.contains(iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Set)) {
            return false;
        }
        final Set set = (Set)o;
        if (this.size() != set.size()) {
            return false;
        }
        int i = 0;
        try {
            while (i < this.c) {
                if (!set.contains(this.n(i))) {
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
    
    @Override
    public int hashCode() {
        final int[] a = this.a;
        final int c = this.c;
        int i = 0;
        int n = 0;
        while (i < c) {
            n += a[i];
            ++i;
        }
        return n;
    }
    
    public int indexOf(final Object o) {
        int n;
        if (o == null) {
            n = this.k();
        }
        else {
            n = this.g(o, o.hashCode());
        }
        return n;
    }
    
    @Override
    public boolean isEmpty() {
        return this.c <= 0;
    }
    
    @Override
    public Iterator<E> iterator() {
        return this.f().m().iterator();
    }
    
    public E m(final int n) {
        final Object[] b = this.b;
        final Object o = b[n];
        final int c = this.c;
        if (c <= 1) {
            e(this.a, b, c);
            this.a = androidx.collection.b.e;
            this.b = androidx.collection.b.f;
            this.c = 0;
        }
        else {
            final int[] a = this.a;
            final int length = a.length;
            int n2 = 8;
            if (length > 8 && c < a.length / 3) {
                if (c > 8) {
                    n2 = c + (c >> 1);
                }
                this.a(n2);
                --this.c;
                if (n > 0) {
                    System.arraycopy(a, 0, this.a, 0, n);
                    System.arraycopy(b, 0, this.b, 0, n);
                }
                final int c2 = this.c;
                if (n < c2) {
                    final int n3 = n + 1;
                    System.arraycopy(a, n3, this.a, n, c2 - n);
                    System.arraycopy(b, n3, this.b, n, this.c - n);
                }
            }
            else {
                final int c3 = c - 1;
                if (n < (this.c = c3)) {
                    final int n4 = n + 1;
                    System.arraycopy(a, n4, a, n, c3 - n);
                    final Object[] b2 = this.b;
                    System.arraycopy(b2, n4, b2, n, this.c - n);
                }
                this.b[this.c] = null;
            }
        }
        return (E)o;
    }
    
    public E n(final int n) {
        return (E)this.b[n];
    }
    
    @Override
    public boolean remove(final Object o) {
        final int index = this.indexOf(o);
        if (index >= 0) {
            this.m(index);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean removeAll(final Collection<?> collection) {
        final Iterator<?> iterator = collection.iterator();
        boolean b = false;
        while (iterator.hasNext()) {
            b |= this.remove(iterator.next());
        }
        return b;
    }
    
    @Override
    public boolean retainAll(final Collection<?> collection) {
        int i = this.c - 1;
        boolean b = false;
        while (i >= 0) {
            if (!collection.contains(this.b[i])) {
                this.m(i);
                b = true;
            }
            --i;
        }
        return b;
    }
    
    @Override
    public int size() {
        return this.c;
    }
    
    @Override
    public Object[] toArray() {
        final int c = this.c;
        final Object[] array = new Object[c];
        System.arraycopy(this.b, 0, array, 0, c);
        return array;
    }
    
    @Override
    public <T> T[] toArray(final T[] array) {
        Object[] array2 = array;
        if (array.length < this.c) {
            array2 = (Object[])Array.newInstance(array.getClass().getComponentType(), this.c);
        }
        System.arraycopy(this.b, 0, array2, 0, this.c);
        final int length = ((T[])array2).length;
        final int c = this.c;
        if (length > c) {
            array2[c] = null;
        }
        return (T[])array2;
    }
    
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        final StringBuilder sb = new StringBuilder(this.c * 14);
        sb.append('{');
        for (int i = 0; i < this.c; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            final E n = this.n(i);
            if (n != this) {
                sb.append(n);
            }
            else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
