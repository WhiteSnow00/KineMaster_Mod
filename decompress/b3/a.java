// 
// Decompiled by Procyon v0.6.0
// 

package b3;

import com.fasterxml.jackson.core.util.InternCache;
import com.fasterxml.jackson.core.JsonFactory;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class a
{
    private final a a;
    private final AtomicReference<a> b;
    private final int c;
    private boolean d;
    private final boolean e;
    private int[] f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private String[] l;
    private int m;
    private int n;
    private transient boolean o;
    private boolean p;
    
    private a(final int n, final boolean d, int c, final boolean e) {
        this.a = null;
        this.c = c;
        this.d = d;
        this.e = e;
        c = 16;
        int n2;
        if (n < 16) {
            n2 = c;
        }
        else {
            n2 = n;
            if ((n - 1 & n) != 0x0) {
                while ((n2 = c) < n) {
                    c += c;
                }
            }
        }
        this.b = new AtomicReference<a>(b3.a.a.a(n2));
    }
    
    private a(final a a, final boolean d, int a2, final boolean e, final a a3) {
        this.a = a;
        this.c = a2;
        this.d = d;
        this.e = e;
        this.b = null;
        this.k = a3.b;
        a2 = a3.a;
        this.g = a2;
        a2 <<= 2;
        this.h = a2;
        this.i = a2 + (a2 >> 1);
        this.j = a3.c;
        this.f = a3.d;
        this.l = a3.e;
        this.m = a3.f;
        this.n = a3.g;
        this.o = false;
        this.p = true;
    }
    
    public static a A() {
        final long currentTimeMillis = System.currentTimeMillis();
        return B((int)currentTimeMillis + (int)(currentTimeMillis >>> 32) | 0x1);
    }
    
    protected static a B(final int n) {
        return new a(64, true, n, true);
    }
    
    private void I(a a) {
        final int b = a.b;
        final a a2 = this.b.get();
        if (b == a2.b) {
            return;
        }
        if (b > 6000) {
            a = a.a(64);
        }
        this.b.compareAndSet(a2, a);
    }
    
    private void J(final boolean b) {
        this.k = 0;
        this.m = this.j();
        this.n = this.g << 3;
        if (b) {
            Arrays.fill(this.f, 0);
            Arrays.fill(this.l, null);
        }
    }
    
    private void L() {
        this.o = false;
        this.p = false;
        final int[] f = this.f;
        final String[] l = this.l;
        final int g = this.g;
        final int k = this.k;
        final int g2 = g + g;
        final int m = this.m;
        if (g2 > 65536) {
            this.J(true);
            return;
        }
        this.f = new int[f.length + (g << 3)];
        this.g = g2;
        final int h = g2 << 2;
        this.h = h;
        this.i = h + (h >> 1);
        this.j = c(g2);
        this.l = new String[l.length << 1];
        this.J(false);
        int[] array = new int[16];
        int i = 0;
        int n = 0;
        while (i < m) {
            final int n2 = f[i + 3];
            int[] array2;
            if (n2 == 0) {
                array2 = array;
            }
            else {
                ++n;
                final String s = l[i >> 2];
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            array2 = array;
                            if (n2 > array.length) {
                                array2 = new int[n2];
                            }
                            System.arraycopy(f, f[i + 1], array2, 0, n2);
                            this.v(s, array2, n2);
                        }
                        else {
                            array[0] = f[i];
                            array[1] = f[i + 1];
                            array[2] = f[i + 2];
                            this.v(s, array, 3);
                            array2 = array;
                        }
                    }
                    else {
                        array[0] = f[i];
                        array[1] = f[i + 1];
                        this.v(s, array, 2);
                        array2 = array;
                    }
                }
                else {
                    array[0] = f[i];
                    this.v(s, array, 1);
                    array2 = array;
                }
            }
            i += 4;
            array = array2;
        }
        if (n == k) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Failed rehash(): old count=");
        sb.append(k);
        sb.append(", copyCount=");
        sb.append(n);
        throw new IllegalStateException(sb.toString());
    }
    
    private int a(final int[] array, final int n) {
        final int n2 = this.n;
        final int n3 = n2 + n;
        final int[] f = this.f;
        if (n3 > f.length) {
            this.f = Arrays.copyOf(this.f, this.f.length + Math.max(n3 - f.length, Math.min(4096, this.g)));
        }
        System.arraycopy(array, 0, this.f, n2, n);
        this.n += n;
        return n2;
    }
    
    private final int b(final int n) {
        return (n & this.g - 1) << 2;
    }
    
    static int c(int n) {
        n >>= 2;
        if (n < 64) {
            return 4;
        }
        if (n <= 256) {
            return 5;
        }
        if (n <= 1024) {
            return 6;
        }
        return 7;
    }
    
    private int d(int i) {
        i = this.b(i);
        final int[] f = this.f;
        if (f[i + 3] == 0) {
            return i;
        }
        final int n = this.h + (i >> 3 << 2);
        if (f[n + 3] == 0) {
            return n;
        }
        for (int j = this.i, k = this.j; i < (1 << k) + (i = j + (i >> k + 2 << k)); i += 4) {
            if (f[i + 3] == 0) {
                return i;
            }
        }
        final int m = this.m;
        i = m + 4;
        if ((this.m = i) >= this.g << 3) {
            if (this.e) {
                this.i();
            }
            this.o = true;
        }
        return m;
    }
    
    private String e(int i, final int n) {
        final int j = this.i;
        final int k = this.j;
        final int n2 = j + (i >> k + 2 << k);
        final int[] f = this.f;
        int n3;
        for (i = n2; i < (1 << k) + n2; i += 4) {
            n3 = f[i + 3];
            if (n == f[i] && n3) {
                return this.l[i >> 2];
            }
            if (n3 == 0) {
                return null;
            }
        }
        for (i = this.j(); i < this.m; i += 4) {
            if (n == f[i] && 1 == f[i + 3]) {
                return this.l[i >> 2];
            }
        }
        return null;
    }
    
    private String f(int i, final int n, final int n2) {
        final int j = this.i;
        final int k = this.j;
        final int n3 = j + (i >> k + 2 << k);
        final int[] f = this.f;
        int n4;
        for (i = n3; i < (1 << k) + n3; i += 4) {
            n4 = f[i + 3];
            if (n == f[i] && n2 == f[i + 1] && 2 == n4) {
                return this.l[i >> 2];
            }
            if (n4 == 0) {
                return null;
            }
        }
        for (i = this.j(); i < this.m; i += 4) {
            if (n == f[i] && n2 == f[i + 1] && 2 == f[i + 3]) {
                return this.l[i >> 2];
            }
        }
        return null;
    }
    
    private String g(int i, final int n, final int n2, final int n3) {
        final int j = this.i;
        final int k = this.j;
        final int n4 = j + (i >> k + 2 << k);
        final int[] f = this.f;
        int n5;
        for (i = n4; i < (1 << k) + n4; i += 4) {
            n5 = f[i + 3];
            if (n == f[i] && n2 == f[i + 1] && n3 == f[i + 2] && 3 == n5) {
                return this.l[i >> 2];
            }
            if (n5 == 0) {
                return null;
            }
        }
        for (i = this.j(); i < this.m; i += 4) {
            if (n == f[i] && n2 == f[i + 1] && n3 == f[i + 2] && 3 == f[i + 3]) {
                return this.l[i >> 2];
            }
        }
        return null;
    }
    
    private String h(int i, final int n, final int[] array, final int n2) {
        final int j = this.i;
        final int k = this.j;
        final int n3 = j + (i >> k + 2 << k);
        final int[] f = this.f;
        int n4;
        for (i = n3; i < (1 << k) + n3; i += 4) {
            n4 = f[i + 3];
            if (n == f[i] && n2 == n4 && this.k(array, n2, f[i + 1])) {
                return this.l[i >> 2];
            }
            if (n4 == 0) {
                return null;
            }
        }
        for (i = this.j(); i < this.m; i += 4) {
            if (n == f[i] && n2 == f[i + 3] && this.k(array, n2, f[i + 1])) {
                return this.l[i >> 2];
            }
        }
        return null;
    }
    
    private final int j() {
        final int g = this.g;
        return (g << 3) - g;
    }
    
    private boolean k(final int[] array, int n, int n2) {
        final int[] f = this.f;
        Label_0154: {
            Label_0126: {
                Label_0098: {
                    switch (n) {
                        default: {
                            return this.l(array, n, n2);
                        }
                        case 8: {
                            if (array[0] != f[n2]) {
                                return false;
                            }
                            n = 1;
                            ++n2;
                            break;
                        }
                        case 7: {
                            n = 0;
                            break;
                        }
                        case 6: {
                            n = 0;
                            break Label_0098;
                        }
                        case 5: {
                            n = 0;
                            break Label_0126;
                        }
                        case 4: {
                            n = 0;
                            break Label_0154;
                        }
                    }
                    final int n3 = n + 1;
                    if (array[n] != f[n2]) {
                        return false;
                    }
                    ++n2;
                    n = n3;
                }
                final int n4 = n + 1;
                if (array[n] != f[n2]) {
                    return false;
                }
                ++n2;
                n = n4;
            }
            final int n5 = n + 1;
            if (array[n] != f[n2]) {
                return false;
            }
            ++n2;
            n = n5;
        }
        final int n6 = n + 1;
        final int n7 = array[n];
        n = n2 + 1;
        if (n7 != f[n2]) {
            return false;
        }
        n2 = n6 + 1;
        final int n8 = array[n6];
        final int n9 = n + 1;
        return n8 == f[n] && array[n2] == f[n9] && array[n2 + 1] == f[n9 + 1];
    }
    
    private boolean l(final int[] array, final int n, int n2) {
        int n3 = 0;
        while (true) {
            final int n4 = n3 + 1;
            if (array[n3] != this.f[n2]) {
                return false;
            }
            if (n4 >= n) {
                return true;
            }
            n3 = n4;
            ++n2;
        }
    }
    
    private void m() {
        if (this.k > this.g >> 1) {
            final int m = this.m;
            final int j = this.j();
            final int k = this.k;
            if (m - j >> 2 > k + 1 >> 7 || k > this.g * 0.8) {
                this.o = true;
            }
        }
    }
    
    private void n() {
        if (this.p) {
            final int[] f = this.f;
            this.f = Arrays.copyOf(f, f.length);
            final String[] l = this.l;
            this.l = Arrays.copyOf(l, l.length);
            this.p = false;
            this.m();
        }
        if (this.o) {
            this.L();
        }
    }
    
    static int o(final a a) {
        return a.g;
    }
    
    static int p(final a a) {
        return a.k;
    }
    
    static int q(final a a) {
        return a.j;
    }
    
    static int[] r(final a a) {
        return a.f;
    }
    
    static String[] s(final a a) {
        return a.l;
    }
    
    static int t(final a a) {
        return a.m;
    }
    
    static int u(final a a) {
        return a.n;
    }
    
    public String C(final int n) {
        final int b = this.b(this.w(n));
        final int[] f = this.f;
        final int n2 = f[b + 3];
        if (n2 == 1) {
            if (f[b] == n) {
                return this.l[b >> 2];
            }
        }
        else if (n2 == 0) {
            return null;
        }
        final int n3 = this.h + (b >> 3 << 2);
        final int n4 = f[n3 + 3];
        if (n4 == 1) {
            if (f[n3] == n) {
                return this.l[n3 >> 2];
            }
        }
        else if (n4 == 0) {
            return null;
        }
        return this.e(b, n);
    }
    
    public String D(final int n, final int n2) {
        final int b = this.b(this.x(n, n2));
        final int[] f = this.f;
        final int n3 = f[b + 3];
        if (n3 == 2) {
            if (n == f[b] && n2 == f[b + 1]) {
                return this.l[b >> 2];
            }
        }
        else if (n3 == 0) {
            return null;
        }
        final int n4 = this.h + (b >> 3 << 2);
        final int n5 = f[n4 + 3];
        if (n5 == 2) {
            if (n == f[n4] && n2 == f[n4 + 1]) {
                return this.l[n4 >> 2];
            }
        }
        else if (n5 == 0) {
            return null;
        }
        return this.f(b, n, n2);
    }
    
    public String E(final int n, final int n2, final int n3) {
        final int b = this.b(this.y(n, n2, n3));
        final int[] f = this.f;
        final int n4 = f[b + 3];
        if (n4 == 3) {
            if (n == f[b] && f[b + 1] == n2 && f[b + 2] == n3) {
                return this.l[b >> 2];
            }
        }
        else if (n4 == 0) {
            return null;
        }
        final int n5 = this.h + (b >> 3 << 2);
        final int n6 = f[n5 + 3];
        if (n6 == 3) {
            if (n == f[n5] && f[n5 + 1] == n2 && f[n5 + 2] == n3) {
                return this.l[n5 >> 2];
            }
        }
        else if (n6 == 0) {
            return null;
        }
        return this.g(b, n, n2, n3);
    }
    
    public String F(final int[] array, final int n) {
        if (n < 4) {
            if (n == 1) {
                return this.C(array[0]);
            }
            if (n == 2) {
                return this.D(array[0], array[1]);
            }
            if (n != 3) {
                return "";
            }
            return this.E(array[0], array[1], array[2]);
        }
        else {
            final int z = this.z(array, n);
            final int b = this.b(z);
            final int[] f = this.f;
            final int n2 = f[b + 3];
            if (z == f[b] && n2 == n && this.k(array, n, f[b + 1])) {
                return this.l[b >> 2];
            }
            if (n2 == 0) {
                return null;
            }
            final int n3 = this.h + (b >> 3 << 2);
            final int n4 = f[n3 + 3];
            if (z == f[n3] && n4 == n && this.k(array, n, f[n3 + 1])) {
                return this.l[n3 >> 2];
            }
            return this.h(b, z, array, n);
        }
    }
    
    public a G(final int n) {
        return new a(this, JsonFactory.Feature.INTERN_FIELD_NAMES.enabledIn(n), this.c, JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW.enabledIn(n), this.b.get());
    }
    
    public boolean H() {
        return this.p ^ true;
    }
    
    public int K() {
        final int h = this.h;
        int n = 0;
        int n2;
        for (int i = 3; i < h; i += 4, n = n2) {
            n2 = n;
            if (this.f[i] != 0) {
                n2 = n + 1;
            }
        }
        return n;
    }
    
    public void M() {
        if (this.a != null && this.H()) {
            this.a.I(new a(this));
            this.p = true;
        }
    }
    
    public int N() {
        int i = this.h + 3;
        final int j = this.i;
        int n = 0;
        while (i < j) {
            int n2 = n;
            if (this.f[i] != 0) {
                n2 = n + 1;
            }
            i += 4;
            n = n2;
        }
        return n;
    }
    
    public int O() {
        return this.m - this.j() >> 2;
    }
    
    public int P() {
        final int n = this.i + 3;
        final int g = this.g;
        int n2 = 0;
        int n3;
        for (int i = n; i < g + n; i += 4, n2 = n3) {
            n3 = n2;
            if (this.f[i] != 0) {
                n3 = n2 + 1;
            }
        }
        return n2;
    }
    
    public int Q() {
        final int g = this.g;
        int i = 3;
        int n = 0;
        while (i < g << 3) {
            int n2 = n;
            if (this.f[i] != 0) {
                n2 = n + 1;
            }
            i += 4;
            n = n2;
        }
        return n;
    }
    
    protected void i() {
        if (this.g <= 1024) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Spill-over slots in symbol table with ");
        sb.append(this.k);
        sb.append(" entries, hash area of ");
        sb.append(this.g);
        sb.append(" slots is now full (all ");
        sb.append(this.g >> 3);
        sb.append(" slots -- suspect a DoS attack based on hash collisions.");
        sb.append(" You can disable the check via `JsonFactory.Feature.FAIL_ON_SYMBOL_HASH_OVERFLOW`");
        throw new IllegalStateException(sb.toString());
    }
    
    @Override
    public String toString() {
        final int k = this.K();
        final int n = this.N();
        final int p = this.P();
        final int o = this.O();
        return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", a.class.getName(), this.k, this.g, k, n, p, o, k + n + p + o, this.Q());
    }
    
    public String v(final String s, final int[] array, int n) {
        this.n();
        String intern = s;
        if (this.d) {
            intern = InternCache.instance.intern(s);
        }
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    final int z = this.z(array, n);
                    final int d = this.d(z);
                    this.f[d] = z;
                    final int a = this.a(array, n);
                    final int[] f = this.f;
                    f[d + 1] = a;
                    f[d + 3] = n;
                    n = d;
                }
                else {
                    n = this.d(this.y(array[0], array[1], array[2]));
                    final int[] f2 = this.f;
                    f2[n] = array[0];
                    f2[n + 1] = array[1];
                    f2[n + 2] = array[2];
                    f2[n + 3] = 3;
                }
            }
            else {
                n = this.d(this.x(array[0], array[1]));
                final int[] f3 = this.f;
                f3[n] = array[0];
                f3[n + 1] = array[1];
                f3[n + 3] = 2;
            }
        }
        else {
            n = this.d(this.w(array[0]));
            final int[] f4 = this.f;
            f4[n] = array[0];
            f4[n + 3] = 1;
        }
        this.l[n >> 2] = intern;
        ++this.k;
        this.m();
        return intern;
    }
    
    public int w(int n) {
        n ^= this.c;
        n += n >>> 16;
        n ^= n << 3;
        return n + (n >>> 12);
    }
    
    public int x(int n, final int n2) {
        n += n >>> 15;
        n = ((n ^ n >>> 9) + n2 * 33 ^ this.c);
        n += n >>> 16;
        n ^= n >>> 4;
        return n + (n << 3);
    }
    
    public int y(int n, final int n2, final int n3) {
        n ^= this.c;
        n = ((n + (n >>> 9)) * 31 + n2) * 33;
        n = (n + (n >>> 15) ^ n3);
        n += n >>> 4;
        n += n >>> 15;
        return n ^ n << 9;
    }
    
    public int z(final int[] array, int n) {
        if (n >= 4) {
            final int n2 = array[0] ^ this.c;
            final int n3 = n2 + (n2 >>> 9) + array[1];
            final int n4 = (n3 + (n3 >>> 15)) * 33 ^ array[2];
            int n5 = n4 + (n4 >>> 4);
            for (int i = 3; i < n; ++i) {
                final int n6 = array[i];
                n5 += (n6 ^ n6 >> 21);
            }
            n = n5 * 65599;
            n += n >>> 19;
            return n << 5 ^ n;
        }
        throw new IllegalArgumentException();
    }
    
    private static final class a
    {
        public final int a;
        public final int b;
        public final int c;
        public final int[] d;
        public final String[] e;
        public final int f;
        public final int g;
        
        public a(final int a, final int b, final int c, final int[] d, final String[] e, final int f, final int g) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.e = e;
            this.f = f;
            this.g = g;
        }
        
        public a(final b3.a a) {
            this.a = b3.a.o(a);
            this.b = b3.a.p(a);
            this.c = b3.a.q(a);
            this.d = b3.a.r(a);
            this.e = b3.a.s(a);
            this.f = b3.a.t(a);
            this.g = b3.a.u(a);
        }
        
        public static a a(final int n) {
            final int n2 = n << 3;
            return new a(n, 0, b3.a.c(n), new int[n2], new String[n << 1], n2 - n, n2);
        }
    }
}
