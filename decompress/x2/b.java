// 
// Decompiled by Procyon v0.6.0
// 

package x2;

import com.fasterxml.jackson.core.JsonParseException;
import java.util.Arrays;
import com.fasterxml.jackson.core.io.f;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonParser;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.JsonToken;
import z2.d;

public abstract class b extends c
{
    protected int A;
    protected int B;
    protected long C;
    protected int D;
    protected int E;
    protected long F;
    protected int G;
    protected int H;
    protected d I;
    protected JsonToken J;
    protected final com.fasterxml.jackson.core.util.d K;
    protected char[] L;
    protected boolean M;
    protected byte[] N;
    protected int O;
    protected int P;
    protected long Q;
    protected double R;
    protected BigInteger S;
    protected BigDecimal T;
    protected boolean U;
    protected int V;
    protected int W;
    protected int X;
    protected final com.fasterxml.jackson.core.io.c y;
    protected boolean z;
    
    protected b(final com.fasterxml.jackson.core.io.c y, final int n) {
        super(n);
        this.D = 1;
        this.G = 1;
        this.O = 0;
        this.y = y;
        this.K = y.i();
        z2.b f;
        if (Feature.STRICT_DUPLICATE_DETECTION.enabledIn(n)) {
            f = z2.b.f(this);
        }
        else {
            f = null;
        }
        this.I = z2.d.l(f);
    }
    
    private void S0(final int n) throws IOException {
        while (true) {
            if (n == 16) {
                try {
                    this.T = this.K.h();
                    this.O = 16;
                    return;
                    this.R = this.K.i();
                    this.O = 8;
                }
                catch (final NumberFormatException ex) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Malformed numeric value '");
                    sb.append(this.K.l());
                    sb.append("'");
                    this.y0(sb.toString(), ex);
                }
                return;
            }
            continue;
        }
    }
    
    private void Y0(int n) throws IOException {
        final String l = this.K.l();
        try {
            final int v = this.V;
            final char[] t = this.K.t();
            final int u = this.K.u();
            final boolean u2 = this.U;
            n = u;
            if (u2) {
                n = u + 1;
            }
            if (com.fasterxml.jackson.core.io.f.b(t, n, v, u2)) {
                this.Q = Long.parseLong(l);
                this.O = 2;
            }
            else {
                this.S = new BigInteger(l);
                this.O = 4;
            }
        }
        catch (final NumberFormatException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Malformed numeric value '");
            sb.append(l);
            sb.append("'");
            this.y0(sb.toString(), ex);
        }
    }
    
    protected static int[] s1(final int[] array, final int n) {
        if (array == null) {
            return new int[n];
        }
        return Arrays.copyOf(array, array.length + n);
    }
    
    protected final JsonToken A1(final boolean u, final int v, final int w, final int x) {
        this.U = u;
        this.V = v;
        this.W = w;
        this.X = x;
        this.O = 0;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }
    
    protected final JsonToken B1(final boolean u, final int v) {
        this.U = u;
        this.V = v;
        this.W = 0;
        this.X = 0;
        this.O = 0;
        return JsonToken.VALUE_NUMBER_INT;
    }
    
    protected abstract void J0() throws IOException;
    
    protected final int K0() throws JsonParseException {
        this.V();
        return -1;
    }
    
    protected Object L0() {
        if (Feature.INCLUDE_SOURCE_IN_LOCATION.enabledIn(super.a)) {
            return this.y.k();
        }
        return null;
    }
    
    protected int N0() throws IOException {
        if (super.c == JsonToken.VALUE_NUMBER_INT && this.V <= 9) {
            final int j = this.K.j(this.U);
            this.P = j;
            this.O = 1;
            return j;
        }
        this.R0(1);
        if ((this.O & 0x1) == 0x0) {
            this.n1();
        }
        return this.P;
    }
    
    protected void R0(final int n) throws IOException {
        final JsonToken c = super.c;
        if (c == JsonToken.VALUE_NUMBER_INT) {
            final int v = this.V;
            if (v <= 9) {
                this.P = this.K.j(this.U);
                this.O = 1;
                return;
            }
            if (v <= 18) {
                final long k = this.K.k(this.U);
                if (v == 10) {
                    if (this.U) {
                        if (k >= -2147483648L) {
                            this.P = (int)k;
                            this.O = 1;
                            return;
                        }
                    }
                    else if (k <= 2147483647L) {
                        this.P = (int)k;
                        this.O = 1;
                        return;
                    }
                }
                this.Q = k;
                this.O = 2;
                return;
            }
            this.Y0(n);
        }
        else {
            if (c == JsonToken.VALUE_NUMBER_FLOAT) {
                this.S0(n);
                return;
            }
            this.a0("Current token (%s) not numeric, can not use numeric value accessors", c);
        }
    }
    
    @Override
    protected void V() throws JsonParseException {
        if (!this.I.f()) {
            String s;
            if (this.I.d()) {
                s = "Array";
            }
            else {
                s = "Object";
            }
            this.f0(String.format(": expected close marker for %s (start marker at %s)", s, this.I.o(this.L0())), null);
        }
    }
    
    protected void a1() throws IOException {
        this.K.v();
        final char[] l = this.L;
        if (l != null) {
            this.L = null;
            this.y.n(l);
        }
    }
    
    @Override
    public BigInteger c() throws IOException {
        final int o = this.O;
        if ((o & 0x4) == 0x0) {
            if (o == 0) {
                this.R0(4);
            }
            if ((this.O & 0x4) == 0x0) {
                this.h1();
            }
        }
        return this.S;
    }
    
    @Override
    public void close() throws IOException {
        if (!this.z) {
            this.A = Math.max(this.A, this.B);
            this.z = true;
            try {
                this.J0();
            }
            finally {
                this.a1();
            }
        }
    }
    
    protected void d1(final int n, final char c) throws JsonParseException {
        final d r1 = this.r1();
        this.Z(String.format("Unexpected close marker '%s': expected '%c' (for %s starting at %s)", (char)n, c, r1.g(), r1.o(this.L0())));
    }
    
    protected void g1() throws IOException {
        final int o = this.O;
        if ((o & 0x8) != 0x0) {
            this.T = com.fasterxml.jackson.core.io.f.c(this.u());
        }
        else if ((o & 0x4) != 0x0) {
            this.T = new BigDecimal(this.S);
        }
        else if ((o & 0x2) != 0x0) {
            this.T = BigDecimal.valueOf(this.Q);
        }
        else if ((o & 0x1) != 0x0) {
            this.T = BigDecimal.valueOf(this.P);
        }
        else {
            this.m0();
        }
        this.O |= 0x10;
    }
    
    @Override
    public String h() throws IOException {
        final JsonToken c = super.c;
        if (c == JsonToken.START_OBJECT || c == JsonToken.START_ARRAY) {
            final d n = this.I.n();
            if (n != null) {
                return n.b();
            }
        }
        return this.I.b();
    }
    
    protected void h1() throws IOException {
        final int o = this.O;
        if ((o & 0x10) != 0x0) {
            this.S = this.T.toBigInteger();
        }
        else if ((o & 0x2) != 0x0) {
            this.S = BigInteger.valueOf(this.Q);
        }
        else if ((o & 0x1) != 0x0) {
            this.S = BigInteger.valueOf(this.P);
        }
        else if ((o & 0x8) != 0x0) {
            this.S = BigDecimal.valueOf(this.R).toBigInteger();
        }
        else {
            this.m0();
        }
        this.O |= 0x4;
    }
    
    @Override
    public BigDecimal j() throws IOException {
        final int o = this.O;
        if ((o & 0x10) == 0x0) {
            if (o == 0) {
                this.R0(16);
            }
            if ((this.O & 0x10) == 0x0) {
                this.g1();
            }
        }
        return this.T;
    }
    
    @Override
    public double k() throws IOException {
        final int o = this.O;
        if ((o & 0x8) == 0x0) {
            if (o == 0) {
                this.R0(8);
            }
            if ((this.O & 0x8) == 0x0) {
                this.k1();
            }
        }
        return this.R;
    }
    
    protected void k1() throws IOException {
        final int o = this.O;
        if ((o & 0x10) != 0x0) {
            this.R = this.T.doubleValue();
        }
        else if ((o & 0x4) != 0x0) {
            this.R = this.S.doubleValue();
        }
        else if ((o & 0x2) != 0x0) {
            this.R = (double)this.Q;
        }
        else if ((o & 0x1) != 0x0) {
            this.R = this.P;
        }
        else {
            this.m0();
        }
        this.O |= 0x8;
    }
    
    @Override
    public float l() throws IOException {
        return (float)this.k();
    }
    
    protected void n1() throws IOException {
        final int o = this.O;
        if ((o & 0x2) != 0x0) {
            final long q = this.Q;
            final int p = (int)q;
            if (p != q) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Numeric value (");
                sb.append(this.u());
                sb.append(") out of range of int");
                this.Z(sb.toString());
            }
            this.P = p;
        }
        else if ((o & 0x4) != 0x0) {
            if (x2.c.f.compareTo(this.S) > 0 || x2.c.g.compareTo(this.S) < 0) {
                this.C0();
            }
            this.P = this.S.intValue();
        }
        else if ((o & 0x8) != 0x0) {
            final double r = this.R;
            if (r < -2.147483648E9 || r > 2.147483647E9) {
                this.C0();
            }
            this.P = (int)this.R;
        }
        else if ((o & 0x10) != 0x0) {
            if (x2.c.w.compareTo(this.T) > 0 || x2.c.x.compareTo(this.T) < 0) {
                this.C0();
            }
            this.P = this.T.intValue();
        }
        else {
            this.m0();
        }
        this.O |= 0x1;
    }
    
    protected void p1() throws IOException {
        final int o = this.O;
        if ((o & 0x1) != 0x0) {
            this.Q = this.P;
        }
        else if ((o & 0x4) != 0x0) {
            if (x2.c.h.compareTo(this.S) > 0 || x2.c.i.compareTo(this.S) < 0) {
                this.F0();
            }
            this.Q = this.S.longValue();
        }
        else if ((o & 0x8) != 0x0) {
            final double r = this.R;
            if (r < -9.223372036854776E18 || r > 9.223372036854776E18) {
                this.F0();
            }
            this.Q = (long)this.R;
        }
        else if ((o & 0x10) != 0x0) {
            if (x2.c.j.compareTo(this.T) > 0 || x2.c.p.compareTo(this.T) < 0) {
                this.F0();
            }
            this.Q = this.T.longValue();
        }
        else {
            this.m0();
        }
        this.O |= 0x2;
    }
    
    @Override
    public int r() throws IOException {
        final int o = this.O;
        if ((o & 0x1) == 0x0) {
            if (o == 0) {
                return this.N0();
            }
            if ((o & 0x1) == 0x0) {
                this.n1();
            }
        }
        return this.P;
    }
    
    public d r1() {
        return this.I;
    }
    
    @Override
    public long s() throws IOException {
        final int o = this.O;
        if ((o & 0x2) == 0x0) {
            if (o == 0) {
                this.R0(2);
            }
            if ((this.O & 0x2) == 0x0) {
                this.p1();
            }
        }
        return this.Q;
    }
    
    protected final JsonToken w1(final boolean b, final int n, final int n2, final int n3) {
        if (n2 < 1 && n3 < 1) {
            return this.B1(b, n);
        }
        return this.A1(b, n, n2, n3);
    }
    
    protected final JsonToken y1(final String s, final double r) {
        this.K.A(s);
        this.R = r;
        this.O = 8;
        return JsonToken.VALUE_NUMBER_FLOAT;
    }
}
