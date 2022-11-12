// 
// Decompiled by Procyon v0.6.0
// 

package b2;

import java.util.Iterator;
import java.nio.ByteOrder;
import android.util.Log;
import java.util.Arrays;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import java.nio.ByteBuffer;

public class e implements a
{
    private static final String u = "e";
    private int[] a;
    private final int[] b;
    private final a c;
    private ByteBuffer d;
    private byte[] e;
    private short[] f;
    private byte[] g;
    private byte[] h;
    private byte[] i;
    private int[] j;
    private int k;
    private c l;
    private Bitmap m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    private Boolean s;
    private Bitmap$Config t;
    
    public e(final a c) {
        this.b = new int[256];
        this.t = Bitmap$Config.ARGB_8888;
        this.c = c;
        this.l = new c();
    }
    
    public e(final a a, final c c, final ByteBuffer byteBuffer, final int n) {
        this(a);
        this.s(c, byteBuffer, n);
    }
    
    private int k(int i, final int n, int n2) {
        int j = i;
        int n3 = 0;
        int n5;
        int n4 = n5 = 0;
        int n7;
        int n6 = n7 = n5;
        while (j < this.p + i) {
            final byte[] k = this.i;
            if (j >= k.length || j >= n) {
                break;
            }
            final int n8 = this.a[k[j] & 0xFF];
            int n9 = n3;
            int n10 = n4;
            int n11 = n5;
            int n12 = n6;
            int n13 = n7;
            if (n8 != 0) {
                n9 = n3 + (n8 >> 24 & 0xFF);
                n10 = n4 + (n8 >> 16 & 0xFF);
                n11 = n5 + (n8 >> 8 & 0xFF);
                n12 = n6 + (n8 & 0xFF);
                n13 = n7 + 1;
            }
            ++j;
            n3 = n9;
            n4 = n10;
            n5 = n11;
            n6 = n12;
            n7 = n13;
        }
        final int n14 = i += n2;
        int n15 = n4;
        int n16 = n3;
        while (i < this.p + n14) {
            final byte[] l = this.i;
            if (i >= l.length || i >= n) {
                break;
            }
            n2 = l[i];
            final int n17 = this.a[n2 & 0xFF];
            int n18 = n16;
            int n19 = n15;
            int n20 = n5;
            int n21 = n6;
            n2 = n7;
            if (n17 != 0) {
                n18 = n16 + (n17 >> 24 & 0xFF);
                n19 = n15 + (n17 >> 16 & 0xFF);
                n20 = n5 + (n17 >> 8 & 0xFF);
                n21 = n6 + (n17 & 0xFF);
                n2 = n7 + 1;
            }
            ++i;
            n16 = n18;
            n15 = n19;
            n5 = n20;
            n6 = n21;
            n7 = n2;
        }
        if (n7 == 0) {
            return 0;
        }
        return n16 / n7 << 24 | n15 / n7 << 16 | n5 / n7 << 8 | n6 / n7;
    }
    
    private void l(final b b) {
        final int[] j = this.j;
        final int d = b.d;
        final int p = this.p;
        final int n = d / p;
        int n2 = b.b / p;
        int n3 = b.c / p;
        final int n4 = b.a / p;
        final boolean b2 = this.k == 0;
        final int r = this.r;
        final int q = this.q;
        final byte[] i = this.i;
        final int[] a = this.a;
        Boolean s = this.s;
        int n5 = 8;
        int k = 0;
        int n6 = 0;
        int n7 = 1;
        while (k < n) {
            int n8;
            int n9;
            if (b.e) {
                if (n6 >= n) {
                    if (++n7 != 2) {
                        if (n7 != 3) {
                            if (n7 == 4) {
                                n6 = 1;
                                n5 = 2;
                            }
                        }
                        else {
                            n5 = 4;
                            n6 = 2;
                        }
                    }
                    else {
                        n6 = 4;
                    }
                }
                n8 = n6 + n5;
                n9 = n7;
            }
            else {
                n8 = n6;
                n6 = k;
                n9 = n7;
            }
            final int n10 = n6 + n2;
            final boolean b3 = p == 1;
            Boolean b4 = null;
            int n26 = 0;
            int n27 = 0;
            Label_0496: {
                int n18;
                if (n10 < q) {
                    final int n11 = n10 * r;
                    final int n12 = n11 + n4;
                    final int n13 = n12 + n3;
                    final int n14 = n11 + r;
                    int n15;
                    if (n14 < (n15 = n13)) {
                        n15 = n14;
                    }
                    int n16 = k * p * b.c;
                    if (b3) {
                        int n17 = n12;
                        while (true) {
                            n18 = n2;
                            b4 = s;
                            if (n17 >= n15) {
                                break;
                            }
                            final int n19 = a[i[n16] & 0xFF];
                            Boolean true;
                            if (n19 != 0) {
                                j[n17] = n19;
                                true = s;
                            }
                            else {
                                true = s;
                                if (b2 && (true = s) == null) {
                                    true = Boolean.TRUE;
                                }
                            }
                            n16 += p;
                            ++n17;
                            s = true;
                        }
                    }
                    else {
                        final int n20 = n2;
                        final int n21 = n12;
                        int n22 = n16;
                        final int n23 = n3;
                        int n24 = n21;
                        while (true) {
                            final int n25 = n22;
                            n26 = n20;
                            b4 = s;
                            n27 = n23;
                            if (n24 >= n15) {
                                break Label_0496;
                            }
                            final int l = this.k(n25, (n15 - n12) * p + n16, b.c);
                            Boolean true2;
                            if (l != 0) {
                                j[n24] = l;
                                true2 = s;
                            }
                            else {
                                true2 = s;
                                if (b2 && (true2 = s) == null) {
                                    true2 = Boolean.TRUE;
                                }
                            }
                            n22 = n25 + p;
                            ++n24;
                            s = true2;
                        }
                    }
                }
                else {
                    b4 = s;
                    n18 = n2;
                }
                n26 = n18;
                n27 = n3;
            }
            s = b4;
            ++k;
            n2 = n26;
            n6 = n8;
            n3 = n27;
            n7 = n9;
        }
        if (this.s == null) {
            this.s = (s != null && s);
        }
    }
    
    private void m(final b b) {
        final int[] j = this.j;
        final int d = b.d;
        final int b2 = b.b;
        final int c = b.c;
        final int a = b.a;
        final boolean b3 = this.k == 0;
        final int r = this.r;
        final byte[] i = this.i;
        final int[] a2 = this.a;
        int k = 0;
        int n = -1;
        while (k < d) {
            final int n2 = (k + b2) * r;
            int l = n2 + a;
            final int n3 = l + c;
            final int n4 = n2 + r;
            int n5;
            if (n4 < (n5 = n3)) {
                n5 = n4;
            }
            int n6 = b.c * k;
            while (l < n5) {
                final byte b4 = i[n6];
                final int n7 = b4 & 0xFF;
                int n8;
                if (n7 != (n8 = n)) {
                    final int n9 = a2[n7];
                    if (n9 != 0) {
                        j[l] = n9;
                        n8 = n;
                    }
                    else {
                        n8 = b4;
                    }
                }
                ++n6;
                ++l;
                n = n8;
            }
            ++k;
        }
        final Boolean s = this.s;
        this.s = ((s != null && s) || (this.s == null && b3 && n != -1));
    }
    
    private void n(final b b) {
        if (b != null) {
            this.d.position(b.j);
        }
        int n;
        int n2;
        if (b == null) {
            final c l = this.l;
            n = l.f;
            n2 = l.g;
        }
        else {
            n = b.c;
            n2 = b.d;
        }
        final int n3 = n * n2;
        final byte[] i = this.i;
        if (i == null || i.length < n3) {
            this.i = this.c.b(n3);
        }
        final byte[] j = this.i;
        if (this.f == null) {
            this.f = new short[4096];
        }
        final short[] f = this.f;
        if (this.g == null) {
            this.g = new byte[4096];
        }
        final byte[] g = this.g;
        if (this.h == null) {
            this.h = new byte[4097];
        }
        final byte[] h = this.h;
        final int r = this.r();
        final int n4 = 1 << r;
        final int n5 = n4 + 2;
        final int n6 = r + 1;
        final int n7 = (1 << n6) - 1;
        int k = 0;
        for (int n8 = 0; n8 < n4; ++n8) {
            f[n8] = 0;
            g[n8] = (byte)n8;
        }
        final byte[] e = this.e;
        final int n9 = n6;
        int n10 = n5;
        int n11 = n7;
        final int n12 = 0;
        final int n14;
        int n13 = n14 = 0;
        final int n16;
        final int n15 = n16 = n14;
        int n17 = n16;
        final int n18 = -1;
        int n19 = n17;
        int n20 = n9;
        int n21 = n18;
        int n22 = n16;
        int n23 = n15;
        int n24 = n14;
        int n25 = n12;
        int n26 = n5;
        final int n27 = n6;
        while (k < n3) {
            int q;
            if ((q = n25) == 0) {
                q = this.q();
                if (q <= 0) {
                    this.o = 3;
                    break;
                }
                n13 = 0;
            }
            final int n28 = n23 + ((e[n13] & 0xFF) << n24);
            final int n29 = n13 + 1;
            final int n30 = q - 1;
            final int n31 = n24 + 8;
            final int n32 = n10;
            final int n33 = n21;
            int n34 = n22;
            int n35 = n28;
            int n36 = n20;
            int n37 = k;
            int n38 = n32;
            int n39 = n17;
            int n40 = n31;
            int n41 = n33;
            while (n40 >= n36) {
                final int n42 = n35 & n11;
                n35 >>= n36;
                n40 -= n36;
                if (n42 == n4) {
                    n11 = n7;
                    n36 = n27;
                    final int n43 = n26;
                    n41 = -1;
                    n38 = n26;
                    n26 = n43;
                }
                else {
                    if (n42 == n4 + 1) {
                        break;
                    }
                    if (n41 == -1) {
                        j[n34] = g[n42];
                        ++n34;
                        ++n37;
                        n41 = (n39 = n42);
                    }
                    else {
                        int n44;
                        int n45;
                        if (n42 >= n38) {
                            h[n19] = (byte)n39;
                            n44 = n19 + 1;
                            n45 = n41;
                        }
                        else {
                            final int n46 = n42;
                            n44 = n19;
                            n45 = n46;
                        }
                        while (n45 >= n4) {
                            h[n44] = g[n45];
                            ++n44;
                            n45 = f[n45];
                        }
                        final int n47 = g[n45] & 0xFF;
                        final byte b2 = (byte)n47;
                        j[n34] = b2;
                        n19 = n44;
                        while (true) {
                            ++n34;
                            ++n37;
                            if (n19 <= 0) {
                                break;
                            }
                            --n19;
                            j[n34] = h[n19];
                        }
                        int n48 = n38;
                        int n49 = n36;
                        int n50 = n11;
                        if (n38 < 4096) {
                            f[n38] = (short)n41;
                            g[n38] = b2;
                            final int n51 = n48 = n38 + 1;
                            n49 = n36;
                            n50 = n11;
                            if ((n51 & n11) == 0x0) {
                                n48 = n51;
                                n49 = n36;
                                n50 = n11;
                                if (n51 < 4096) {
                                    n49 = n36 + 1;
                                    n50 = n11 + n51;
                                    n48 = n51;
                                }
                            }
                        }
                        n41 = n42;
                        n39 = n47;
                        n38 = n48;
                        n36 = n49;
                        n11 = n50;
                    }
                }
            }
            final int n52 = n39;
            final int n53 = n36;
            k = n37;
            n25 = n30;
            n13 = n29;
            n24 = n40;
            n23 = n35;
            n22 = n34;
            n10 = n38;
            n21 = n41;
            n20 = n53;
            n17 = n52;
        }
        Arrays.fill(j, n22, n3, (byte)0);
    }
    
    private Bitmap p() {
        final Boolean s = this.s;
        Bitmap$Config bitmap$Config;
        if (s != null && !s) {
            bitmap$Config = this.t;
        }
        else {
            bitmap$Config = Bitmap$Config.ARGB_8888;
        }
        final Bitmap c = this.c.c(this.r, this.q, bitmap$Config);
        c.setHasAlpha(true);
        return c;
    }
    
    private int q() {
        final int r = this.r();
        if (r <= 0) {
            return r;
        }
        final ByteBuffer d = this.d;
        d.get(this.e, 0, Math.min(r, d.remaining()));
        return r;
    }
    
    private int r() {
        return this.d.get() & 0xFF;
    }
    
    private Bitmap t(final b b, final b b2) {
        final int[] j = this.j;
        final boolean b3 = false;
        if (b2 == null) {
            final Bitmap m = this.m;
            if (m != null) {
                this.c.a(m);
            }
            this.m = null;
            Arrays.fill(j, 0);
        }
        if (b2 != null && b2.g == 3 && this.m == null) {
            Arrays.fill(j, 0);
        }
        if (b2 != null) {
            final int g = b2.g;
            if (g > 0) {
                if (g == 2) {
                    int l = b3 ? 1 : 0;
                    if (!b.f) {
                        final c i = this.l;
                        l = i.l;
                        if (b.k != null && i.j == b.h) {
                            l = (b3 ? 1 : 0);
                        }
                    }
                    final int d = b2.d;
                    final int p2 = this.p;
                    final int n = d / p2;
                    final int n2 = b2.b / p2;
                    final int n3 = b2.c / p2;
                    int k = 0;
                    for (int n4 = b2.a / p2, r = this.r; k < n * r + (k = n2 * r + n4); k += this.r) {
                        for (int n5 = k; n5 < k + n3; ++n5) {
                            j[n5] = l;
                        }
                    }
                }
                else if (g == 3) {
                    final Bitmap m2 = this.m;
                    if (m2 != null) {
                        final int r2 = this.r;
                        m2.getPixels(j, 0, r2, 0, 0, r2, this.q);
                    }
                }
            }
        }
        this.n(b);
        if (!b.e && this.p == 1) {
            this.m(b);
        }
        else {
            this.l(b);
        }
        if (this.n) {
            final int g2 = b.g;
            if (g2 == 0 || g2 == 1) {
                if (this.m == null) {
                    this.m = this.p();
                }
                final Bitmap m3 = this.m;
                final int r3 = this.r;
                m3.setPixels(j, 0, r3, 0, 0, r3, this.q);
            }
        }
        final Bitmap p3 = this.p();
        final int r4 = this.r;
        p3.setPixels(j, 0, r4, 0, 0, r4, this.q);
        return p3;
    }
    
    @Override
    public ByteBuffer a() {
        return this.d;
    }
    
    @Override
    public Bitmap b() {
        synchronized (this) {
            if (this.l.c <= 0 || this.k < 0) {
                final String u = b2.e.u;
                if (Log.isLoggable(u, 3)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Unable to decode frame, frameCount=");
                    sb.append(this.l.c);
                    sb.append(", framePointer=");
                    sb.append(this.k);
                    Log.d(u, sb.toString());
                }
                this.o = 1;
            }
            final int o = this.o;
            if (o == 1 || o == 2) {
                final String u2 = b2.e.u;
                if (Log.isLoggable(u2, 3)) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unable to decode frame, status=");
                    sb2.append(this.o);
                    Log.d(u2, sb2.toString());
                }
                return null;
            }
            this.o = 0;
            if (this.e == null) {
                this.e = this.c.b(255);
            }
            final b b = this.l.e.get(this.k);
            final int n = this.k - 1;
            b b2;
            if (n >= 0) {
                b2 = this.l.e.get(n);
            }
            else {
                b2 = null;
            }
            int[] a = b.k;
            if (a == null) {
                a = this.l.a;
            }
            this.a = a;
            if (a == null) {
                final String u3 = b2.e.u;
                if (Log.isLoggable(u3, 3)) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("No valid color table found for frame #");
                    sb3.append(this.k);
                    Log.d(u3, sb3.toString());
                }
                this.o = 1;
                return null;
            }
            if (b.f) {
                System.arraycopy(a, 0, this.b, 0, a.length);
                (this.a = this.b)[b.h] = 0;
                if (b.g == 2 && this.k == 0) {
                    this.s = Boolean.TRUE;
                }
            }
            return this.t(b, b2);
        }
    }
    
    @Override
    public void c() {
        this.k = (this.k + 1) % this.l.c;
    }
    
    @Override
    public void clear() {
        this.l = null;
        final byte[] i = this.i;
        if (i != null) {
            this.c.e(i);
        }
        final int[] j = this.j;
        if (j != null) {
            this.c.f(j);
        }
        final Bitmap m = this.m;
        if (m != null) {
            this.c.a(m);
        }
        this.m = null;
        this.d = null;
        this.s = null;
        final byte[] e = this.e;
        if (e != null) {
            this.c.e(e);
        }
    }
    
    @Override
    public int d() {
        return this.l.c;
    }
    
    @Override
    public void e(final Bitmap$Config t) {
        if (t != Bitmap$Config.ARGB_8888 && t != Bitmap$Config.RGB_565) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unsupported format: ");
            sb.append(t);
            sb.append(", must be one of ");
            sb.append(Bitmap$Config.ARGB_8888);
            sb.append(" or ");
            sb.append(Bitmap$Config.RGB_565);
            throw new IllegalArgumentException(sb.toString());
        }
        this.t = t;
    }
    
    @Override
    public int f() {
        final int m = this.l.m;
        if (m == -1) {
            return 1;
        }
        if (m == 0) {
            return 0;
        }
        return m + 1;
    }
    
    @Override
    public int g() {
        if (this.l.c > 0) {
            final int k = this.k;
            if (k >= 0) {
                return this.o(k);
            }
        }
        return 0;
    }
    
    @Override
    public void h() {
        this.k = -1;
    }
    
    @Override
    public int i() {
        return this.k;
    }
    
    @Override
    public int j() {
        return this.d.limit() + this.i.length + this.j.length * 4;
    }
    
    public int o(int i) {
        if (i >= 0) {
            final c l = this.l;
            if (i < l.c) {
                i = l.e.get(i).i;
                return i;
            }
        }
        i = -1;
        return i;
    }
    
    public void s(final c l, ByteBuffer readOnlyBuffer, int highestOneBit) {
        monitorenter(this);
        Label_0178: {
            if (highestOneBit > 0) {
                Label_0214: {
                    try {
                        highestOneBit = Integer.highestOneBit(highestOneBit);
                        this.o = 0;
                        this.l = l;
                        this.k = -1;
                        readOnlyBuffer = readOnlyBuffer.asReadOnlyBuffer();
                        (this.d = readOnlyBuffer).position(0);
                        this.d.order(ByteOrder.LITTLE_ENDIAN);
                        this.n = false;
                        final Iterator<b> iterator = l.e.iterator();
                        while (iterator.hasNext()) {
                            if (iterator.next().g == 3) {
                                this.n = true;
                                break;
                            }
                        }
                        this.p = highestOneBit;
                        final int f = l.f;
                        this.r = f / highestOneBit;
                        final int g = l.g;
                        this.q = g / highestOneBit;
                        this.i = this.c.b(f * g);
                        this.j = this.c.d(this.r * this.q);
                        monitorexit(this);
                        return;
                    }
                    finally {
                        break Label_0214;
                    }
                    break Label_0178;
                }
                monitorexit(this);
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Sample size must be >=0, not: ");
        sb.append(highestOneBit);
        throw new IllegalArgumentException(sb.toString());
    }
}
