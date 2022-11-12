// 
// Decompiled by Procyon v0.6.0
// 

package androidx.recyclerview.widget;

import java.util.List;
import androidx.core.util.f;
import java.util.ArrayList;
import androidx.core.util.e;

final class a implements r.a
{
    private e<b> a;
    final ArrayList<b> b;
    final ArrayList<b> c;
    final a d;
    Runnable e;
    final boolean f;
    final r g;
    private int h;
    
    a(final a a) {
        this(a, false);
    }
    
    a(final a d, final boolean f) {
        this.a = new f<b>(30);
        this.b = new ArrayList<b>();
        this.c = new ArrayList<b>();
        this.h = 0;
        this.d = d;
        this.f = f;
        this.g = new r((r.a)this);
    }
    
    private void c(final b b) {
        this.v(b);
    }
    
    private void d(final b b) {
        this.v(b);
    }
    
    private void f(final b b) {
        final int b2 = b.b;
        int n = b.d + b2;
        int n2 = -1;
        int i = b2;
        int n3 = 0;
        while (i < n) {
            boolean b4;
            if (this.d.f(i) == null && !this.h(i)) {
                boolean b3;
                if (n2 == 1) {
                    this.v(this.a(2, b2, n3, null));
                    b3 = true;
                }
                else {
                    b3 = false;
                }
                final int n4 = 0;
                b4 = b3;
                n2 = n4;
            }
            else {
                if (n2 == 0) {
                    this.k(this.a(2, b2, n3, null));
                    b4 = true;
                }
                else {
                    b4 = false;
                }
                n2 = 1;
            }
            int n5;
            if (b4) {
                i -= n3;
                n -= n3;
                n5 = 1;
            }
            else {
                n5 = n3 + 1;
            }
            ++i;
            n3 = n5;
        }
        b a = b;
        if (n3 != b.d) {
            this.b(b);
            a = this.a(2, b2, n3, null);
        }
        if (n2 == 0) {
            this.k(a);
        }
        else {
            this.v(a);
        }
    }
    
    private void g(final b b) {
        final int b2 = b.b;
        final int d = b.d;
        int n = 0;
        int n2 = -1;
        int n3 = b2;
        int n6;
        int n9;
        for (int i = b2; i < d + b2; ++i, n2 = n6, n = n9) {
            int n7;
            if (this.d.f(i) == null && !this.h(i)) {
                int n4 = n3;
                int n5 = n;
                if (n2 == 1) {
                    this.v(this.a(4, n3, n, b.c));
                    n4 = i;
                    n5 = 0;
                }
                n6 = 0;
                n3 = n4;
                n7 = n5;
            }
            else {
                int n8 = n3;
                n7 = n;
                if (n2 == 0) {
                    this.k(this.a(4, n3, n, b.c));
                    n8 = i;
                    n7 = 0;
                }
                n6 = 1;
                n3 = n8;
            }
            n9 = n7 + 1;
        }
        b a = b;
        if (n != b.d) {
            final Object c = b.c;
            this.b(b);
            a = this.a(4, n3, n, c);
        }
        if (n2 == 0) {
            this.k(a);
        }
        else {
            this.v(a);
        }
    }
    
    private boolean h(final int n) {
        for (int size = this.c.size(), i = 0; i < size; ++i) {
            final b b = this.c.get(i);
            final int a = b.a;
            if (a == 8) {
                if (this.n(b.d, i + 1) == n) {
                    return true;
                }
            }
            else if (a == 1) {
                for (int b2 = b.b, d = b.d, j = b2; j < d + b2; ++j) {
                    if (this.n(j, i + 1) == n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private void k(b a) {
        final int a2 = a.a;
        if (a2 != 1 && a2 != 8) {
            int z = this.z(a.b, a2);
            int b = a.b;
            final int a3 = a.a;
            int n;
            if (a3 != 2) {
                if (a3 != 4) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("op should be remove or update.");
                    sb.append(a);
                    throw new IllegalArgumentException(sb.toString());
                }
                n = 1;
            }
            else {
                n = 0;
            }
            int i = 1;
            int n2 = 1;
            while (i < a.d) {
                final int z2 = this.z(a.b + n * i, a.a);
                final int a4 = a.a;
                if ((a4 == 2) ? (z2 == z) : (a4 == 4 && z2 == z + 1)) {
                    ++n2;
                }
                else {
                    final b a5 = this.a(a4, z, n2, a.c);
                    this.l(a5, b);
                    this.b(a5);
                    int n3 = b;
                    if (a.a == 4) {
                        n3 = b + n2;
                    }
                    n2 = 1;
                    final int n4 = z2;
                    b = n3;
                    z = n4;
                }
                ++i;
            }
            final Object c = a.c;
            this.b(a);
            if (n2 > 0) {
                a = this.a(a.a, z, n2, c);
                this.l(a, b);
                this.b(a);
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    
    private void v(final b b) {
        this.c.add(b);
        final int a = b.a;
        if (a != 1) {
            if (a != 2) {
                if (a != 4) {
                    if (a != 8) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unknown update op type for ");
                        sb.append(b);
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.d.a(b.b, b.d);
                }
                else {
                    this.d.e(b.b, b.d, b.c);
                }
            }
            else {
                this.d.d(b.b, b.d);
            }
        }
        else {
            this.d.g(b.b, b.d);
        }
    }
    
    private int z(int i, int d) {
        int j = this.c.size() - 1;
        int n = i;
        while (j >= 0) {
            final b b = this.c.get(j);
            final int a = b.a;
            if (a == 8) {
                final int b2 = b.b;
                final int d2 = b.d;
                int n2;
                if (b2 < d2) {
                    n2 = b2;
                    i = d2;
                }
                else {
                    i = b2;
                    n2 = d2;
                }
                if (n >= n2 && n <= i) {
                    if (n2 == b2) {
                        if (d == 1) {
                            b.d = d2 + 1;
                        }
                        else if (d == 2) {
                            b.d = d2 - 1;
                        }
                        i = n + 1;
                    }
                    else {
                        if (d == 1) {
                            b.b = b2 + 1;
                        }
                        else if (d == 2) {
                            b.b = b2 - 1;
                        }
                        i = n - 1;
                    }
                }
                else if ((i = n) < b2) {
                    if (d == 1) {
                        b.b = b2 + 1;
                        b.d = d2 + 1;
                        i = n;
                    }
                    else {
                        i = n;
                        if (d == 2) {
                            b.b = b2 - 1;
                            b.d = d2 - 1;
                            i = n;
                        }
                    }
                }
            }
            else {
                final int b3 = b.b;
                if (b3 <= n) {
                    if (a == 1) {
                        i = n - b.d;
                    }
                    else {
                        i = n;
                        if (a == 2) {
                            i = n + b.d;
                        }
                    }
                }
                else if (d == 1) {
                    b.b = b3 + 1;
                    i = n;
                }
                else {
                    i = n;
                    if (d == 2) {
                        b.b = b3 - 1;
                        i = n;
                    }
                }
            }
            --j;
            n = i;
        }
        b b4;
        for (i = this.c.size() - 1; i >= 0; --i) {
            b4 = this.c.get(i);
            if (b4.a == 8) {
                d = b4.d;
                if (d == b4.b || d < 0) {
                    this.c.remove(i);
                    this.b(b4);
                }
            }
            else if (b4.d <= 0) {
                this.c.remove(i);
                this.b(b4);
            }
        }
        return n;
    }
    
    @Override
    public b a(final int a, final int b, final int d, final Object c) {
        final b b2 = this.a.a();
        b b3;
        if (b2 == null) {
            b3 = new b(a, b, d, c);
        }
        else {
            b2.a = a;
            b2.b = b;
            b2.d = d;
            b2.c = c;
            b3 = b2;
        }
        return b3;
    }
    
    @Override
    public void b(final b b) {
        if (!this.f) {
            b.c = null;
            this.a.b(b);
        }
    }
    
    public int e(int n) {
        final int size = this.b.size();
        int i = 0;
        int n2 = n;
        while (i < size) {
            final b b = this.b.get(i);
            n = b.a;
            if (n != 1) {
                if (n != 2) {
                    if (n != 8) {
                        n = n2;
                    }
                    else {
                        n = b.b;
                        if (n == n2) {
                            n = b.d;
                        }
                        else {
                            int n3;
                            if (n < (n3 = n2)) {
                                n3 = n2 - 1;
                            }
                            if (b.d <= (n = n3)) {
                                n = n3 + 1;
                            }
                        }
                    }
                }
                else {
                    final int b2 = b.b;
                    if (b2 <= (n = n2)) {
                        n = b.d;
                        if (b2 + n > n2) {
                            return -1;
                        }
                        n = n2 - n;
                    }
                }
            }
            else if (b.b <= (n = n2)) {
                n = n2 + b.d;
            }
            ++i;
            n2 = n;
        }
        return n2;
    }
    
    void i() {
        for (int size = this.c.size(), i = 0; i < size; ++i) {
            this.d.c(this.c.get(i));
        }
        this.x(this.c);
        this.h = 0;
    }
    
    void j() {
        this.i();
        for (int size = this.b.size(), i = 0; i < size; ++i) {
            final b b = this.b.get(i);
            final int a = b.a;
            if (a != 1) {
                if (a != 2) {
                    if (a != 4) {
                        if (a == 8) {
                            this.d.c(b);
                            this.d.a(b.b, b.d);
                        }
                    }
                    else {
                        this.d.c(b);
                        this.d.e(b.b, b.d, b.c);
                    }
                }
                else {
                    this.d.c(b);
                    this.d.h(b.b, b.d);
                }
            }
            else {
                this.d.c(b);
                this.d.g(b.b, b.d);
            }
            final Runnable e = this.e;
            if (e != null) {
                e.run();
            }
        }
        this.x(this.b);
        this.h = 0;
    }
    
    void l(final b b, final int n) {
        this.d.b(b);
        final int a = b.a;
        if (a != 2) {
            if (a != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.d.e(n, b.d, b.c);
        }
        else {
            this.d.h(n, b.d);
        }
    }
    
    int m(final int n) {
        return this.n(n, 0);
    }
    
    int n(int n, int n2) {
        final int size = this.c.size();
        int i = n2;
        n2 = n;
        while (i < size) {
            final b b = this.c.get(i);
            final int a = b.a;
            if (a == 8) {
                n = b.b;
                if (n == n2) {
                    n = b.d;
                }
                else {
                    int n3;
                    if (n < (n3 = n2)) {
                        n3 = n2 - 1;
                    }
                    if (b.d <= (n = n3)) {
                        n = n3 + 1;
                    }
                }
            }
            else {
                final int b2 = b.b;
                if (b2 <= (n = n2)) {
                    if (a == 2) {
                        n = b.d;
                        if (n2 < b2 + n) {
                            return -1;
                        }
                        n = n2 - n;
                    }
                    else {
                        n = n2;
                        if (a == 1) {
                            n = n2 + b.d;
                        }
                    }
                }
            }
            ++i;
            n2 = n;
        }
        return n2;
    }
    
    boolean o(final int n) {
        return (n & this.h) != 0x0;
    }
    
    boolean p() {
        return this.b.size() > 0;
    }
    
    boolean q() {
        return !this.c.isEmpty() && !this.b.isEmpty();
    }
    
    boolean r(final int n, final int n2, final Object o) {
        boolean b = false;
        if (n2 < 1) {
            return false;
        }
        this.b.add(this.a(4, n, n2, o));
        this.h |= 0x4;
        if (this.b.size() == 1) {
            b = true;
        }
        return b;
    }
    
    boolean s(final int n, final int n2) {
        boolean b = false;
        if (n2 < 1) {
            return false;
        }
        this.b.add(this.a(1, n, n2, null));
        this.h |= 0x1;
        if (this.b.size() == 1) {
            b = true;
        }
        return b;
    }
    
    boolean t(final int n, final int n2, final int n3) {
        boolean b = false;
        if (n == n2) {
            return false;
        }
        if (n3 == 1) {
            this.b.add(this.a(8, n, n2, null));
            this.h |= 0x8;
            if (this.b.size() == 1) {
                b = true;
            }
            return b;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }
    
    boolean u(final int n, final int n2) {
        boolean b = false;
        if (n2 < 1) {
            return false;
        }
        this.b.add(this.a(2, n, n2, null));
        this.h |= 0x2;
        if (this.b.size() == 1) {
            b = true;
        }
        return b;
    }
    
    void w() {
        this.g.b(this.b);
        for (int size = this.b.size(), i = 0; i < size; ++i) {
            final b b = this.b.get(i);
            final int a = b.a;
            if (a != 1) {
                if (a != 2) {
                    if (a != 4) {
                        if (a == 8) {
                            this.d(b);
                        }
                    }
                    else {
                        this.g(b);
                    }
                }
                else {
                    this.f(b);
                }
            }
            else {
                this.c(b);
            }
            final Runnable e = this.e;
            if (e != null) {
                e.run();
            }
        }
        this.b.clear();
    }
    
    void x(final List<b> list) {
        for (int size = list.size(), i = 0; i < size; ++i) {
            this.b((b)list.get(i));
        }
        list.clear();
    }
    
    void y() {
        this.x(this.b);
        this.x(this.c);
        this.h = 0;
    }
    
    interface a
    {
        void a(final int p0, final int p1);
        
        void b(final b p0);
        
        void c(final b p0);
        
        void d(final int p0, final int p1);
        
        void e(final int p0, final int p1, final Object p2);
        
        RecyclerView.c0 f(final int p0);
        
        void g(final int p0, final int p1);
        
        void h(final int p0, final int p1);
    }
    
    static final class b
    {
        int a;
        int b;
        Object c;
        int d;
        
        b(final int a, final int b, final int d, final Object c) {
            this.a = a;
            this.b = b;
            this.d = d;
            this.c = c;
        }
        
        String a() {
            final int a = this.a;
            if (a == 1) {
                return "add";
            }
            if (a == 2) {
                return "rm";
            }
            if (a == 4) {
                return "up";
            }
            if (a != 8) {
                return "??";
            }
            return "mv";
        }
        
        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof b)) {
                return false;
            }
            final b b = (b)o;
            final int a = this.a;
            if (a != b.a) {
                return false;
            }
            if (a == 8 && Math.abs(this.d - this.b) == 1 && this.d == b.b && this.b == b.d) {
                return true;
            }
            if (this.d != b.d) {
                return false;
            }
            if (this.b != b.b) {
                return false;
            }
            final Object c = this.c;
            if (c != null) {
                if (!c.equals(b.c)) {
                    return false;
                }
            }
            else if (b.c != null) {
                return false;
            }
            return true;
        }
        
        @Override
        public int hashCode() {
            return (this.a * 31 + this.b) * 31 + this.d;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            sb.append(this.a());
            sb.append(",s:");
            sb.append(this.b);
            sb.append("c:");
            sb.append(this.d);
            sb.append(",p:");
            sb.append(this.c);
            sb.append("]");
            return sb.toString();
        }
    }
}
