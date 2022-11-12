// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class i
{
    private static final Comparator<d> a;
    
    static {
        a = new Comparator<d>() {
            public int a(final d d, final d d2) {
                return d.a - d2.a;
            }
            
            @Override
            public /* bridge */ int compare(final Object o, final Object o2) {
                return this.a((d)o, (d)o2);
            }
        };
    }
    
    private static i a(final h h, final b b, final c c, final c c2, final int n) {
        final boolean b2 = (h.b() - h.a()) % 2 == 0;
        final int b3 = h.b();
        final int a = h.a();
        int i;
        for (int n2 = i = -n; i <= n; i += 2) {
            int b4;
            int b5;
            if (i != n2 && (i == n || c2.b(i + 1) >= c2.b(i - 1))) {
                b4 = c2.b(i - 1);
                b5 = b4 - 1;
            }
            else {
                b4 = (b5 = c2.b(i + 1));
            }
            int b6 = h.d - (h.b - b5 - i);
            int d;
            if (n != 0 && b5 == b4) {
                d = b6 + 1;
            }
            else {
                d = b6;
            }
            while (b5 > h.a && b6 > h.c && b.b(b5 - 1, b6 - 1)) {
                --b5;
                --b6;
            }
            c2.c(i, b5);
            if (b2) {
                final int n3 = b3 - a - i;
                if (n3 >= n2 && n3 <= n && c.b(n3) >= b5) {
                    final i j = new i();
                    j.a = b5;
                    j.b = b6;
                    j.c = b4;
                    j.d = d;
                    j.e = true;
                    return j;
                }
            }
        }
        return null;
    }
    
    public static e b(final b b) {
        return c(b, true);
    }
    
    public static e c(final b b, final boolean b2) {
        final int e = b.e();
        final int d = b.d();
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        list2.add(new h(0, e, 0, d));
        final int n = (e + d + 1) / 2 * 2 + 1;
        final c c = new c(n);
        final c c2 = new c(n);
        final ArrayList list3 = new ArrayList();
        while (!list2.isEmpty()) {
            final h h = (h)list2.remove(list2.size() - 1);
            final i e2 = e(h, b, c, c2);
            if (e2 != null) {
                if (e2.a() > 0) {
                    list.add(e2.d());
                }
                Object o;
                if (list3.isEmpty()) {
                    o = new h();
                }
                else {
                    o = list3.remove(list3.size() - 1);
                }
                ((h)o).a = h.a;
                ((h)o).c = h.c;
                ((h)o).b = e2.a;
                ((h)o).d = e2.b;
                list2.add(o);
                h.b = h.b;
                h.d = h.d;
                h.a = e2.c;
                h.c = e2.d;
                list2.add(h);
            }
            else {
                list3.add(h);
            }
        }
        Collections.sort((List<Object>)list, (Comparator<? super Object>)i.a);
        return new e(b, list, c.a(), c2.a(), b2);
    }
    
    private static i d(final h h, final b b, final c c, final c c2, final int n) {
        final int abs = Math.abs(h.b() - h.a());
        boolean b2 = true;
        if (abs % 2 != 1) {
            b2 = false;
        }
        final int b3 = h.b();
        final int a = h.a();
        int i;
        for (int n2 = i = -n; i <= n; i += 2) {
            int b4;
            int b5;
            if (i != n2 && (i == n || c.b(i + 1) <= c.b(i - 1))) {
                b4 = c.b(i - 1);
                b5 = b4 + 1;
            }
            else {
                b4 = (b5 = c.b(i + 1));
            }
            int d = h.c + (b5 - h.a) - i;
            int b6;
            if (n != 0 && b5 == b4) {
                b6 = d - 1;
            }
            else {
                b6 = d;
            }
            while (b5 < h.b && d < h.d && b.b(b5, d)) {
                ++b5;
                ++d;
            }
            c.c(i, b5);
            if (b2) {
                final int n3 = b3 - a - i;
                if (n3 >= n2 + 1 && n3 <= n - 1 && c2.b(n3) <= b5) {
                    final i j = new i();
                    j.a = b4;
                    j.b = b6;
                    j.c = b5;
                    j.d = d;
                    j.e = false;
                    return j;
                }
            }
        }
        return null;
    }
    
    private static i e(final h h, final b b, final c c, final c c2) {
        if (h.b() >= 1) {
            if (h.a() >= 1) {
                final int n = (h.b() + h.a() + 1) / 2;
                c.c(1, h.a);
                c2.c(1, h.b);
                for (int i = 0; i < n; ++i) {
                    final i d = d(h, b, c, c2, i);
                    if (d != null) {
                        return d;
                    }
                    final i a = a(h, b, c, c2, i);
                    if (a != null) {
                        return a;
                    }
                }
            }
        }
        return null;
    }
    
    public abstract static class b
    {
        public abstract boolean a(final int p0, final int p1);
        
        public abstract boolean b(final int p0, final int p1);
        
        public abstract Object c(final int p0, final int p1);
        
        public abstract int d();
        
        public abstract int e();
    }
    
    static class c
    {
        private final int[] a;
        private final int b;
        
        c(final int n) {
            final int[] a = new int[n];
            this.a = a;
            this.b = a.length / 2;
        }
        
        int[] a() {
            return this.a;
        }
        
        int b(final int n) {
            return this.a[n + this.b];
        }
        
        void c(final int n, final int n2) {
            this.a[n + this.b] = n2;
        }
    }
    
    static class d
    {
        public final int a;
        public final int b;
        public final int c;
        
        d(final int a, final int b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        int a() {
            return this.a + this.c;
        }
        
        int b() {
            return this.b + this.c;
        }
    }
    
    public static class e
    {
        private final List<d> a;
        private final int[] b;
        private final int[] c;
        private final b d;
        private final int e;
        private final int f;
        private final boolean g;
        
        e(final b d, final List<d> a, final int[] b, final int[] c, final boolean g) {
            this.a = a;
            this.b = b;
            this.c = c;
            Arrays.fill(b, 0);
            Arrays.fill(c, 0);
            this.d = d;
            this.e = d.e();
            this.f = d.d();
            this.g = g;
            this.a();
            this.e();
        }
        
        private void a() {
            d d;
            if (this.a.isEmpty()) {
                d = null;
            }
            else {
                d = this.a.get(0);
            }
            if (d == null || d.a != 0 || d.b != 0) {
                this.a.add(0, new d(0, 0, 0));
            }
            this.a.add(new d(this.e, this.f, 0));
        }
        
        private void d(final int n) {
            final int size = this.a.size();
            int i = 0;
            int j = 0;
            while (i < size) {
                d d;
                for (d = this.a.get(i); j < d.b; ++j) {
                    if (this.c[j] == 0 && this.d.b(n, j)) {
                        int n2;
                        if (this.d.a(n, j)) {
                            n2 = 8;
                        }
                        else {
                            n2 = 4;
                        }
                        this.b[n] = (j << 4 | n2);
                        this.c[j] = (n << 4 | n2);
                        return;
                    }
                }
                j = d.b();
                ++i;
            }
        }
        
        private void e() {
            for (final d d : this.a) {
                for (int i = 0; i < d.c; ++i) {
                    final int n = d.a + i;
                    final int n2 = d.b + i;
                    int n3;
                    if (this.d.a(n, n2)) {
                        n3 = 1;
                    }
                    else {
                        n3 = 2;
                    }
                    this.b[n] = (n2 << 4 | n3);
                    this.c[n2] = (n << 4 | n3);
                }
            }
            if (this.g) {
                this.f();
            }
        }
        
        private void f() {
            final Iterator<d> iterator = this.a.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                d d;
                for (d = iterator.next(); i < d.a; ++i) {
                    if (this.b[i] == 0) {
                        this.d(i);
                    }
                }
                i = d.a();
            }
        }
        
        private static g g(final Collection<g> collection, final int n, final boolean b) {
            final Iterator<g> iterator = collection.iterator();
            while (true) {
                while (iterator.hasNext()) {
                    final g g = iterator.next();
                    if (g.a == n && g.c == b) {
                        iterator.remove();
                        while (iterator.hasNext()) {
                            final g g2 = iterator.next();
                            if (b) {
                                --g2.b;
                            }
                            else {
                                ++g2.b;
                            }
                        }
                        return g;
                    }
                }
                final g g = null;
                continue;
            }
        }
        
        public int b(int n) {
            if (n < 0 || n >= this.e) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Index out of bounds - passed position = ");
                sb.append(n);
                sb.append(", old list size = ");
                sb.append(this.e);
                throw new IndexOutOfBoundsException(sb.toString());
            }
            n = this.b[n];
            if ((n & 0xF) == 0x0) {
                return -1;
            }
            return n >> 4;
        }
        
        public void c(final p p) {
            androidx.recyclerview.widget.e e;
            if (p instanceof androidx.recyclerview.widget.e) {
                e = (androidx.recyclerview.widget.e)p;
            }
            else {
                e = new androidx.recyclerview.widget.e(p);
            }
            int e2 = this.e;
            final ArrayDeque<g> arrayDeque = new ArrayDeque<g>();
            int n = this.e;
            int n2 = this.f;
            for (int i = this.a.size() - 1; i >= 0; --i) {
                final d d = this.a.get(i);
                final int a = d.a();
                final int b = d.b();
                int n3 = n;
                int n4 = e2;
                int n5;
                int j;
                while (true) {
                    n5 = 0;
                    e2 = n4;
                    j = n2;
                    if (n3 <= a) {
                        break;
                    }
                    final int n6 = n3 - 1;
                    final int n7 = this.b[n6];
                    if ((n7 & 0xC) != 0x0) {
                        final int n8 = n7 >> 4;
                        final g g = g(arrayDeque, n8, false);
                        if (g != null) {
                            final int n9 = n4 - g.b - 1;
                            e.d(n6, n9);
                            n3 = n6;
                            if ((n7 & 0x4) == 0x0) {
                                continue;
                            }
                            e.c(n9, 1, this.d.c(n6, n8));
                            n3 = n6;
                        }
                        else {
                            arrayDeque.add(new g(n6, n4 - n6 - 1, true));
                            n3 = n6;
                        }
                    }
                    else {
                        e.b(n6, 1);
                        --n4;
                        n3 = n6;
                    }
                }
                while (j > b) {
                    final int n10 = j - 1;
                    final int n11 = this.c[n10];
                    if ((n11 & 0xC) != 0x0) {
                        final int n12 = n11 >> 4;
                        final g g2 = g(arrayDeque, n12, true);
                        if (g2 == null) {
                            arrayDeque.add(new g(n10, e2 - n3, false));
                            j = n10;
                        }
                        else {
                            e.d(e2 - g2.b - 1, n3);
                            j = n10;
                            if ((n11 & 0x4) == 0x0) {
                                continue;
                            }
                            e.c(n3, 1, this.d.c(n12, n10));
                            j = n10;
                        }
                    }
                    else {
                        e.a(n3, 1);
                        ++e2;
                        j = n10;
                    }
                }
                int a2 = d.a;
                int b2 = d.b;
                for (int k = n5; k < d.c; ++k) {
                    if ((this.b[a2] & 0xF) == 0x2) {
                        e.c(a2, 1, this.d.c(a2, b2));
                    }
                    ++a2;
                    ++b2;
                }
                n = d.a;
                n2 = d.b;
            }
            e.e();
        }
    }
    
    public abstract static class f<T>
    {
        public abstract boolean areContentsTheSame(final T p0, final T p1);
        
        public abstract boolean areItemsTheSame(final T p0, final T p1);
        
        public Object getChangePayload(final T t, final T t2) {
            return null;
        }
    }
    
    private static class g
    {
        int a;
        int b;
        boolean c;
        
        g(final int a, final int b, final boolean c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    static class h
    {
        int a;
        int b;
        int c;
        int d;
        
        public h() {
        }
        
        public h(final int a, final int b, final int c, final int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        int a() {
            return this.d - this.c;
        }
        
        int b() {
            return this.b - this.a;
        }
    }
    
    static class i
    {
        public int a;
        public int b;
        public int c;
        public int d;
        public boolean e;
        
        int a() {
            return Math.min(this.c - this.a, this.d - this.b);
        }
        
        boolean b() {
            return this.d - this.b != this.c - this.a;
        }
        
        boolean c() {
            return this.d - this.b > this.c - this.a;
        }
        
        d d() {
            if (!this.b()) {
                final int a = this.a;
                return new d(a, this.b, this.c - a);
            }
            if (this.e) {
                return new d(this.a, this.b, this.a());
            }
            if (this.c()) {
                return new d(this.a, this.b + 1, this.a());
            }
            return new d(this.a + 1, this.b, this.a());
        }
    }
}
