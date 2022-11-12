// 
// Decompiled by Procyon v0.6.0
// 

package a3;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import z2.d;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.c;
import b3.a;

public abstract class b extends x2.b
{
    protected static final String[] o0;
    protected static final double[] p0;
    protected final a Y;
    protected int[] Z;
    protected int a0;
    protected int b0;
    protected int c0;
    protected int d0;
    protected int e0;
    protected int f0;
    protected int g0;
    protected int h0;
    protected int i0;
    protected int j0;
    protected boolean k0;
    protected int l0;
    protected int m0;
    protected int n0;
    
    static {
        o0 = new String[] { "NaN", "Infinity", "+Infinity", "-Infinity" };
        p0 = new double[] { Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };
    }
    
    public b(final com.fasterxml.jackson.core.io.c c, final int n, final a y) {
        super(c, n);
        this.Z = new int[8];
        this.k0 = false;
        this.m0 = 0;
        this.n0 = 1;
        this.Y = y;
        super.c = null;
        this.g0 = 0;
        this.h0 = 1;
    }
    
    protected static final int R1(int n, final int n2) {
        if (n2 != 4) {
            n |= -1 << (n2 << 3);
        }
        return n;
    }
    
    protected final String C1(final int[] array, final int n, final int n2) throws JsonParseException {
        final int n3 = (n << 2) - 4 + n2;
        int n5;
        if (n2 < 4) {
            final int n4 = n - 1;
            n5 = array[n4];
            array[n4] = n5 << (4 - n2 << 3);
        }
        else {
            n5 = 0;
        }
        char[] array2 = super.K.m();
        int i = 0;
        int n6 = 0;
        while (i < n3) {
            final int n7 = array[i >> 2] >> (3 - (i & 0x3) << 3) & 0xFF;
            final int n8 = i + 1;
            char[] o = array2;
            i = n8;
            int n9 = n6;
            int n10;
            if ((n10 = n7) > 127) {
                int n11;
                int n12;
                if ((n7 & 0xE0) == 0xC0) {
                    n11 = (n7 & 0x1F);
                    n12 = 1;
                }
                else if ((n7 & 0xF0) == 0xE0) {
                    n11 = (n7 & 0xF);
                    n12 = 2;
                }
                else if ((n7 & 0xF8) == 0xF0) {
                    n11 = (n7 & 0x7);
                    n12 = 3;
                }
                else {
                    this.T1(n7);
                    n11 = 1;
                    n12 = 1;
                }
                if (n8 + n12 > n3) {
                    this.f0(" in field name", JsonToken.FIELD_NAME);
                }
                final int n13 = array[n8 >> 2] >> (3 - (n8 & 0x3) << 3);
                final int n14 = n8 + 1;
                if ((n13 & 0xC0) != 0x80) {
                    this.U1(n13);
                }
                int n15 = (n13 & 0x3F) | n11 << 6;
                int n17;
                if (n12 > 1) {
                    final int n16 = array[n14 >> 2] >> (3 - (n14 & 0x3) << 3);
                    n17 = n14 + 1;
                    if ((n16 & 0xC0) != 0x80) {
                        this.U1(n16);
                    }
                    n15 = ((n16 & 0x3F) | n15 << 6);
                    if (n12 > 2) {
                        final int n18 = array[n17 >> 2] >> (3 - (n17 & 0x3) << 3);
                        ++n17;
                        if ((n18 & 0xC0) != 0x80) {
                            this.U1(n18 & 0xFF);
                        }
                        n15 = (n15 << 6 | (n18 & 0x3F));
                    }
                }
                else {
                    n17 = n14;
                }
                o = array2;
                i = n17;
                n9 = n6;
                n10 = n15;
                if (n12 > 2) {
                    final int n19 = n15 - 65536;
                    o = array2;
                    if (n6 >= array2.length) {
                        o = super.K.o();
                    }
                    o[n6] = (char)((n19 >> 10) + 55296);
                    n10 = ((n19 & 0x3FF) | 0xDC00);
                    n9 = n6 + 1;
                    i = n17;
                }
            }
            array2 = o;
            if (n9 >= o.length) {
                array2 = super.K.o();
            }
            array2[n9] = (char)n10;
            n6 = n9 + 1;
        }
        final String s = new String(array2, 0, n6);
        if (n2 < 4) {
            array[n - 1] = n5;
        }
        return this.Y.v(s, array, n);
    }
    
    protected final JsonToken E1() throws IOException {
        if (!super.I.d()) {
            this.d1(93, '}');
        }
        final d n = super.I.n();
        super.I = n;
        int n2;
        if (n.e()) {
            n2 = 3;
        }
        else if (n.d()) {
            n2 = 6;
        }
        else {
            n2 = 1;
        }
        this.g0 = n2;
        this.h0 = n2;
        return super.c = JsonToken.END_ARRAY;
    }
    
    protected final JsonToken F1() throws IOException {
        if (!super.I.e()) {
            this.d1(125, ']');
        }
        final d n = super.I.n();
        super.I = n;
        int n2;
        if (n.e()) {
            n2 = 3;
        }
        else if (n.d()) {
            n2 = 6;
        }
        else {
            n2 = 1;
        }
        this.g0 = n2;
        this.h0 = n2;
        return super.c = JsonToken.END_OBJECT;
    }
    
    @Override
    protected void J0() throws IOException {
        this.m0 = 0;
        super.B = 0;
    }
    
    protected final JsonToken K1() throws IOException {
        this.g0 = 7;
        if (!super.I.f()) {
            this.V();
        }
        this.close();
        return super.c = null;
    }
    
    protected final JsonToken L1(final String s) throws IOException {
        this.g0 = 4;
        super.I.q(s);
        return super.c = JsonToken.FIELD_NAME;
    }
    
    protected final String M1(int r1, final int n) throws JsonParseException {
        r1 = R1(r1, n);
        final String c = this.Y.C(r1);
        if (c != null) {
            return c;
        }
        final int[] z = this.Z;
        z[0] = r1;
        return this.C1(z, 1, n);
    }
    
    protected final String N1(final int n, int r1, final int n2) throws JsonParseException {
        r1 = R1(r1, n2);
        final String d = this.Y.D(n, r1);
        if (d != null) {
            return d;
        }
        final int[] z = this.Z;
        z[0] = n;
        z[1] = r1;
        return this.C1(z, 2, n2);
    }
    
    protected final String O1(final int n, final int n2, int r1, final int n3) throws JsonParseException {
        r1 = R1(r1, n3);
        final String e = this.Y.E(n, n2, r1);
        if (e != null) {
            return e;
        }
        final int[] z = this.Z;
        z[0] = n;
        z[1] = n2;
        z[2] = R1(r1, n3);
        return this.C1(z, 3, n3);
    }
    
    protected final String P1(final JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        final int id = jsonToken.id();
        if (id == -1) {
            return null;
        }
        if (id == 5) {
            return super.I.b();
        }
        if (id != 6 && id != 7 && id != 8) {
            return jsonToken.asString();
        }
        return super.K.l();
    }
    
    protected final String Q1(final int n) {
        return b.o0[n];
    }
    
    protected void S1(final int n) throws JsonParseException {
        if (n < 32) {
            this.r0(n);
        }
        this.T1(n);
    }
    
    protected void T1(final int n) throws JsonParseException {
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-8 start byte 0x");
        sb.append(Integer.toHexString(n));
        this.Z(sb.toString());
    }
    
    protected void U1(final int n) throws JsonParseException {
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-8 middle byte 0x");
        sb.append(Integer.toHexString(n));
        this.Z(sb.toString());
    }
    
    protected void V1(final int n, final int a) throws JsonParseException {
        super.A = a;
        this.U1(n);
    }
    
    protected final JsonToken W1() throws IOException {
        super.I = super.I.j(-1, -1);
        this.g0 = 5;
        this.h0 = 6;
        return super.c = JsonToken.START_ARRAY;
    }
    
    protected final JsonToken X1() throws IOException {
        super.I = super.I.k(-1, -1);
        this.g0 = 2;
        this.h0 = 3;
        return super.c = JsonToken.START_OBJECT;
    }
    
    protected final void Y1() {
        super.G = Math.max(super.D, this.n0);
        final int a = super.A;
        super.H = a - super.E;
        super.F = super.C + (a - this.m0);
    }
    
    protected final JsonToken Z1(final JsonToken c) throws IOException {
        this.g0 = this.h0;
        return super.c = c;
    }
    
    @Override
    protected void a1() throws IOException {
        super.a1();
        this.Y.M();
    }
    
    protected final JsonToken a2(final int p2, final String s) throws IOException {
        super.K.A(s);
        super.V = s.length();
        super.O = 1;
        super.P = p2;
        this.g0 = this.h0;
        return super.c = JsonToken.VALUE_NUMBER_INT;
    }
    
    protected final JsonToken b2(final int n) throws IOException {
        final String s = b.o0[n];
        super.K.A(s);
        if (!this.E(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            this.a0("Non-standard token '%s': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow", s);
        }
        super.V = 0;
        super.O = 8;
        super.R = b.p0[n];
        this.g0 = this.h0;
        return super.c = JsonToken.VALUE_NUMBER_FLOAT;
    }
    
    @Override
    public JsonLocation e() {
        return new JsonLocation(this.L0(), super.C + (super.A - this.m0), -1L, Math.max(super.D, this.n0), super.A - super.E + 1);
    }
    
    @Override
    public String u() throws IOException {
        final JsonToken c = super.c;
        if (c == JsonToken.VALUE_STRING) {
            return super.K.l();
        }
        return this.P1(c);
    }
}
