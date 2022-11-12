// 
// Decompiled by Procyon v0.6.0
// 

package z2;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.JsonParseException;
import java.io.IOException;
import com.fasterxml.jackson.core.io.c;
import com.fasterxml.jackson.core.JsonParser;
import java.io.InputStream;
import b3.a;
import x2.b;

public class j extends b
{
    private static final int[] i0;
    protected static final int[] j0;
    protected static final int k0;
    protected final a Y;
    protected int[] Z;
    protected boolean a0;
    private int b0;
    protected int c0;
    protected int d0;
    protected int e0;
    protected InputStream f0;
    protected byte[] g0;
    protected boolean h0;
    
    static {
        i0 = com.fasterxml.jackson.core.io.a.i();
        j0 = com.fasterxml.jackson.core.io.a.g();
        k0 = Feature.ALLOW_TRAILING_COMMA.getMask();
    }
    
    public j(final com.fasterxml.jackson.core.io.c c, final int n, final InputStream f0, final com.fasterxml.jackson.core.c c2, final a y, final byte[] g0, final int n2, final int b, final boolean h0) {
        super(c, n);
        this.Z = new int[16];
        this.f0 = f0;
        this.Y = y;
        this.g0 = g0;
        super.A = n2;
        super.B = b;
        super.E = n2;
        super.C = -n2;
        this.h0 = h0;
    }
    
    private final void B2() throws IOException {
        if (super.A >= super.B) {
            this.Z1();
        }
        final byte[] g0 = this.g0;
        final int a = super.A;
        final int a2 = a + 1;
        super.A = a2;
        final byte b = g0[a];
        if ((b & 0xC0) != 0x80) {
            this.r2(b & 0xFF, a2);
        }
    }
    
    private final void C1(final String s, final int n, final int n2) throws IOException {
        if (Character.isJavaIdentifierPart((char)this.L1(n2))) {
            this.s2(s.substring(0, n));
        }
    }
    
    private final void C2() throws IOException {
        if (super.A >= super.B) {
            this.Z1();
        }
        final byte[] g0 = this.g0;
        final int a = super.A;
        final int a2 = a + 1;
        super.A = a2;
        final byte b = g0[a];
        if ((b & 0xC0) != 0x80) {
            this.r2(b & 0xFF, a2);
        }
        if (super.A >= super.B) {
            this.Z1();
        }
        final byte[] g2 = this.g0;
        final int a3 = super.A;
        final int a4 = a3 + 1;
        super.A = a4;
        final byte b2 = g2[a3];
        if ((b2 & 0xC0) != 0x80) {
            this.r2(b2 & 0xFF, a4);
        }
    }
    
    private final void D2(int a) throws IOException {
        if (super.A >= super.B) {
            this.Z1();
        }
        final byte[] g0 = this.g0;
        final int a2 = super.A;
        a = a2 + 1;
        super.A = a;
        final byte b = g0[a2];
        if ((b & 0xC0) != 0x80) {
            this.r2(b & 0xFF, a);
        }
        if (super.A >= super.B) {
            this.Z1();
        }
        final byte[] g2 = this.g0;
        final int a3 = super.A;
        a = a3 + 1;
        super.A = a;
        final byte b2 = g2[a3];
        if ((b2 & 0xC0) != 0x80) {
            this.r2(b2 & 0xFF, a);
        }
        if (super.A >= super.B) {
            this.Z1();
        }
        final byte[] g3 = this.g0;
        final int a4 = super.A;
        a = a4 + 1;
        super.A = a;
        final byte b3 = g3[a4];
        if ((b3 & 0xC0) != 0x80) {
            this.r2(b3 & 0xFF, a);
        }
    }
    
    private final void E1() throws JsonParseException {
        this.J2();
        if (!super.I.d()) {
            this.d1(93, '}');
        }
        super.I = super.I.i();
    }
    
    private final int E2() throws IOException {
        while (true) {
            final int a = super.A;
            if (a >= super.B) {
                return this.F2();
            }
            final byte[] g0 = this.g0;
            final int n = a + 1;
            super.A = n;
            final int n2 = g0[a] & 0xFF;
            if (n2 > 32) {
                if (n2 != 47 && n2 != 35) {
                    return n2;
                }
                super.A = n - 1;
                return this.F2();
            }
            else {
                if (n2 == 32) {
                    continue;
                }
                if (n2 == 10) {
                    ++super.D;
                    super.E = n;
                }
                else if (n2 == 13) {
                    this.v2();
                }
                else {
                    if (n2 == 9) {
                        continue;
                    }
                    this.r0(n2);
                }
            }
        }
    }
    
    private final void F1() throws JsonParseException {
        this.J2();
        if (!super.I.e()) {
            this.d1(125, ']');
        }
        super.I = super.I.i();
    }
    
    private final int F2() throws IOException {
        while (super.A < super.B || this.Y1()) {
            final byte[] g0 = this.g0;
            final int a = super.A;
            final int n = a + 1;
            super.A = n;
            final int n2 = g0[a] & 0xFF;
            if (n2 > 32) {
                if (n2 == 47) {
                    this.y2();
                }
                else {
                    if (n2 == 35 && this.I2()) {
                        continue;
                    }
                    return n2;
                }
            }
            else {
                if (n2 == 32) {
                    continue;
                }
                if (n2 == 10) {
                    ++super.D;
                    super.E = n;
                }
                else if (n2 == 13) {
                    this.v2();
                }
                else {
                    if (n2 == 9) {
                        continue;
                    }
                    this.r0(n2);
                }
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unexpected end-of-input within/between ");
        sb.append(super.I.g());
        sb.append(" entries");
        throw this.a(sb.toString());
    }
    
    private final int G2() throws IOException {
        if (super.A >= super.B && !this.Y1()) {
            return this.K0();
        }
        final byte[] g0 = this.g0;
        final int a = super.A;
        final int n = a + 1;
        super.A = n;
        final int n2 = g0[a] & 0xFF;
        if (n2 > 32) {
            if (n2 != 47 && n2 != 35) {
                return n2;
            }
            super.A = n - 1;
            return this.H2();
        }
        else {
            if (n2 != 32) {
                if (n2 == 10) {
                    ++super.D;
                    super.E = n;
                }
                else if (n2 == 13) {
                    this.v2();
                }
                else if (n2 != 9) {
                    this.r0(n2);
                }
            }
            while (true) {
                final int a2 = super.A;
                if (a2 >= super.B) {
                    return this.H2();
                }
                final byte[] g2 = this.g0;
                final int n3 = a2 + 1;
                super.A = n3;
                final int n4 = g2[a2] & 0xFF;
                if (n4 > 32) {
                    if (n4 != 47 && n4 != 35) {
                        return n4;
                    }
                    super.A = n3 - 1;
                    return this.H2();
                }
                else {
                    if (n4 == 32) {
                        continue;
                    }
                    if (n4 == 10) {
                        ++super.D;
                        super.E = n3;
                    }
                    else if (n4 == 13) {
                        this.v2();
                    }
                    else {
                        if (n4 == 9) {
                            continue;
                        }
                        this.r0(n4);
                    }
                }
            }
        }
    }
    
    private final int H2() throws IOException {
        while (super.A < super.B || this.Y1()) {
            final byte[] g0 = this.g0;
            final int a = super.A;
            final int n = a + 1;
            super.A = n;
            final int n2 = g0[a] & 0xFF;
            if (n2 > 32) {
                if (n2 == 47) {
                    this.y2();
                }
                else {
                    if (n2 == 35 && this.I2()) {
                        continue;
                    }
                    return n2;
                }
            }
            else {
                if (n2 == 32) {
                    continue;
                }
                if (n2 == 10) {
                    ++super.D;
                    super.E = n;
                }
                else if (n2 == 13) {
                    this.v2();
                }
                else {
                    if (n2 == 9) {
                        continue;
                    }
                    this.r0(n2);
                }
            }
        }
        return this.K0();
    }
    
    private final boolean I2() throws IOException {
        if (!this.E(Feature.ALLOW_YAML_COMMENTS)) {
            return false;
        }
        this.z2();
        return true;
    }
    
    private final void J2() {
        super.G = super.D;
        final int a = super.A;
        super.F = super.C + a;
        super.H = a - super.E;
    }
    
    private final JsonToken K1(final int n) throws JsonParseException {
        if (n == 125) {
            this.F1();
            return super.c = JsonToken.END_OBJECT;
        }
        this.E1();
        return super.c = JsonToken.END_ARRAY;
    }
    
    private final void K2() {
        this.d0 = super.D;
        final int a = super.A;
        this.c0 = a;
        this.e0 = a - super.E;
    }
    
    private final int L2() throws IOException {
        if (super.A >= super.B && !this.Y1()) {
            return 48;
        }
        final int n = this.g0[super.A] & 0xFF;
        if (n >= 48 && n <= 57) {
            if (!this.E(Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
                this.B0("Leading zeroes not allowed");
            }
            ++super.A;
            int n2;
            if ((n2 = n) == 48) {
                n2 = n;
                while (super.A < super.B || this.Y1()) {
                    final byte[] g0 = this.g0;
                    final int a = super.A;
                    final int n3 = g0[a] & 0xFF;
                    if (n3 < 48 || n3 > 57) {
                        return 48;
                    }
                    super.A = a + 1;
                    if ((n2 = n3) != 48) {
                        n2 = n3;
                        break;
                    }
                }
            }
            return n2;
        }
        return 48;
    }
    
    private final void M2(final int n) throws IOException {
        final int n2 = super.A + 1;
        super.A = n2;
        if (n != 9) {
            if (n != 10) {
                if (n == 13) {
                    this.v2();
                    return;
                }
                if (n != 32) {
                    this.i0(n);
                }
            }
            else {
                ++super.D;
                super.E = n2;
            }
        }
    }
    
    private final int N1(final int n) throws IOException {
        if (super.A >= super.B) {
            this.Z1();
        }
        final byte[] g0 = this.g0;
        final int a = super.A;
        final int a2 = a + 1;
        super.A = a2;
        final byte b = g0[a];
        if ((b & 0xC0) != 0x80) {
            this.r2(b & 0xFF, a2);
        }
        return (n & 0x1F) << 6 | (b & 0x3F);
    }
    
    private final String N2(final int[] array, final int n, final int n2) throws JsonParseException {
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
                    this.p2(n7);
                    n11 = 1;
                    n12 = 1;
                }
                if (n8 + n12 > n3) {
                    this.f0(" in field name", JsonToken.FIELD_NAME);
                }
                final int n13 = array[n8 >> 2] >> (3 - (n8 & 0x3) << 3);
                final int n14 = n8 + 1;
                if ((n13 & 0xC0) != 0x80) {
                    this.q2(n13);
                }
                int n15 = (n13 & 0x3F) | n11 << 6;
                int n17;
                if (n12 > 1) {
                    final int n16 = array[n14 >> 2] >> (3 - (n14 & 0x3) << 3);
                    n17 = n14 + 1;
                    if ((n16 & 0xC0) != 0x80) {
                        this.q2(n16);
                    }
                    n15 = ((n16 & 0x3F) | n15 << 6);
                    if (n12 > 2) {
                        final int n18 = array[n17 >> 2] >> (3 - (n17 & 0x3) << 3);
                        ++n17;
                        if ((n18 & 0xC0) != 0x80) {
                            this.q2(n18 & 0xFF);
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
    
    private final int O1(final int n) throws IOException {
        if (super.A >= super.B) {
            this.Z1();
        }
        final byte[] g0 = this.g0;
        final int a = super.A;
        final int a2 = a + 1;
        super.A = a2;
        final byte b = g0[a];
        if ((b & 0xC0) != 0x80) {
            this.r2(b & 0xFF, a2);
        }
        if (super.A >= super.B) {
            this.Z1();
        }
        final byte[] g2 = this.g0;
        final int a3 = super.A;
        final int a4 = a3 + 1;
        super.A = a4;
        final byte b2 = g2[a3];
        if ((b2 & 0xC0) != 0x80) {
            this.r2(b2 & 0xFF, a4);
        }
        return ((n & 0xF) << 6 | (b & 0x3F)) << 6 | (b2 & 0x3F);
    }
    
    private final String O2(int h2, final int n) throws JsonParseException {
        h2 = h2(h2, n);
        final String c = this.Y.C(h2);
        if (c != null) {
            return c;
        }
        final int[] z = this.Z;
        z[0] = h2;
        return this.N2(z, 1, n);
    }
    
    private final int P1(final int n) throws IOException {
        final byte[] g0 = this.g0;
        final int a = super.A;
        final int a2 = a + 1;
        super.A = a2;
        final byte b = g0[a];
        if ((b & 0xC0) != 0x80) {
            this.r2(b & 0xFF, a2);
        }
        final byte[] g2 = this.g0;
        final int a3 = super.A;
        final int a4 = a3 + 1;
        super.A = a4;
        final byte b2 = g2[a3];
        if ((b2 & 0xC0) != 0x80) {
            this.r2(b2 & 0xFF, a4);
        }
        return ((n & 0xF) << 6 | (b & 0x3F)) << 6 | (b2 & 0x3F);
    }
    
    private final String P2(final int n, int h2, final int n2) throws JsonParseException {
        h2 = h2(h2, n2);
        final String d = this.Y.D(n, h2);
        if (d != null) {
            return d;
        }
        final int[] z = this.Z;
        z[0] = n;
        z[1] = h2;
        return this.N2(z, 2, n2);
    }
    
    private final int Q1(final int n) throws IOException {
        if (super.A >= super.B) {
            this.Z1();
        }
        final byte[] g0 = this.g0;
        final int a = super.A;
        final int a2 = a + 1;
        super.A = a2;
        final byte b = g0[a];
        if ((b & 0xC0) != 0x80) {
            this.r2(b & 0xFF, a2);
        }
        if (super.A >= super.B) {
            this.Z1();
        }
        final byte[] g2 = this.g0;
        final int a3 = super.A;
        final int a4 = a3 + 1;
        super.A = a4;
        final byte b2 = g2[a3];
        if ((b2 & 0xC0) != 0x80) {
            this.r2(b2 & 0xFF, a4);
        }
        if (super.A >= super.B) {
            this.Z1();
        }
        final byte[] g3 = this.g0;
        final int a5 = super.A;
        final int a6 = a5 + 1;
        super.A = a6;
        final byte b3 = g3[a5];
        if ((b3 & 0xC0) != 0x80) {
            this.r2(b3 & 0xFF, a6);
        }
        return ((((n & 0x7) << 6 | (b & 0x3F)) << 6 | (b2 & 0x3F)) << 6 | (b3 & 0x3F)) - 65536;
    }
    
    private final String Q2(final int n, final int n2, int h2, final int n3) throws JsonParseException {
        h2 = h2(h2, n3);
        final String e = this.Y.E(n, n2, h2);
        if (e != null) {
            return e;
        }
        final int[] z = this.Z;
        z[0] = n;
        z[1] = n2;
        z[2] = h2(h2, n3);
        return this.N2(z, 3, n3);
    }
    
    private final String R2(final int[] array, final int n, final int n2, final int n3) throws JsonParseException {
        int[] s1 = array;
        if (n >= array.length) {
            s1 = b.s1(array, array.length);
            this.Z = s1;
        }
        final int n4 = n + 1;
        s1[n] = h2(n2, n3);
        final String f = this.Y.F(s1, n4);
        if (f == null) {
            return this.N2(s1, n4, n3);
        }
        return f;
    }
    
    private final void S1(char[] array, int a) throws IOException {
        final int[] i0 = j.i0;
        final byte[] g0 = this.g0;
        int n2 = 0;
    Block_5:
        while (true) {
            int j;
            if ((j = super.A) >= super.B) {
                this.Z1();
                j = super.A;
            }
            final int length = array.length;
            final int n = 0;
            if ((n2 = a) >= length) {
                array = super.K.p();
                n2 = 0;
            }
            while (j < Math.min(super.B, array.length - n2 + j)) {
                a = j + 1;
                final int n3 = g0[j] & 0xFF;
                if (i0[n3] != 0) {
                    super.A = a;
                    if (n3 == 34) {
                        break Block_5;
                    }
                    final int n4 = i0[n3];
                    if (n4 != 1) {
                        if (n4 != 2) {
                            if (n4 != 3) {
                                if (n4 != 4) {
                                    if (n3 < 32) {
                                        this.t0(n3, "string value");
                                        a = n3;
                                    }
                                    else {
                                        this.o2(n3);
                                        a = n3;
                                    }
                                }
                                else {
                                    final int q1 = this.Q1(n3);
                                    a = n2 + 1;
                                    array[n2] = (char)(0xD800 | q1 >> 10);
                                    if (a >= array.length) {
                                        array = super.K.p();
                                        n2 = 0;
                                    }
                                    else {
                                        n2 = a;
                                    }
                                    a = ((q1 & 0x3FF) | 0xDC00);
                                }
                            }
                            else if (super.B - a >= 2) {
                                a = this.P1(n3);
                            }
                            else {
                                a = this.O1(n3);
                            }
                        }
                        else {
                            a = this.N1(n3);
                        }
                    }
                    else {
                        a = this.M1();
                    }
                    if (n2 >= array.length) {
                        array = super.K.p();
                        n2 = n;
                    }
                    final int n5 = n2 + 1;
                    array[n2] = (char)a;
                    a = n5;
                    continue Block_5;
                }
                else {
                    array[n2] = (char)n3;
                    j = a;
                    ++n2;
                }
            }
            super.A = j;
            a = n2;
        }
        super.K.D(n2);
    }
    
    private int S2() throws IOException {
        if (super.A >= super.B) {
            this.Z1();
        }
        return this.g0[super.A++] & 0xFF;
    }
    
    private final String X2(final int n, final int n2, final int n3) throws IOException {
        return this.T2(this.Z, 0, n, n2, n3);
    }
    
    private final String Y2(final int n, final int n2, final int n3, final int n4) throws IOException {
        final int[] z = this.Z;
        z[0] = n;
        return this.T2(z, 1, n2, n3, n4);
    }
    
    private final String Z2(final int n, final int n2, final int n3, final int n4, final int n5) throws IOException {
        final int[] z = this.Z;
        z[0] = n;
        z[1] = n2;
        return this.T2(z, 2, n3, n4, n5);
    }
    
    private final void d2(final String s, int n) throws IOException {
        int n2;
        int a;
        do {
            if ((super.A >= super.B && !this.Y1()) || this.g0[super.A] != s.charAt(n)) {
                this.s2(s.substring(0, n));
            }
            a = super.A + 1;
            super.A = a;
            n2 = n + 1;
        } while ((n = n2) < s.length());
        if (a >= super.B && !this.Y1()) {
            return;
        }
        n = (this.g0[super.A] & 0xFF);
        if (n >= 48 && n != 93 && n != 125) {
            this.C1(s, n2, n);
        }
    }
    
    private final JsonToken f2() {
        super.M = false;
        final JsonToken j = super.J;
        super.J = null;
        if (j == JsonToken.START_ARRAY) {
            super.I = super.I.j(super.G, super.H);
        }
        else if (j == JsonToken.START_OBJECT) {
            super.I = super.I.k(super.G, super.H);
        }
        return super.c = j;
    }
    
    private final JsonToken g2(final int n) throws IOException {
        if (n == 34) {
            this.a0 = true;
            return super.c = JsonToken.VALUE_STRING;
        }
        if (n == 45) {
            return super.c = this.l2();
        }
        if (n == 91) {
            super.I = super.I.j(super.G, super.H);
            return super.c = JsonToken.START_ARRAY;
        }
        if (n == 102) {
            this.a2();
            return super.c = JsonToken.VALUE_FALSE;
        }
        if (n == 110) {
            this.b2();
            return super.c = JsonToken.VALUE_NULL;
        }
        if (n == 116) {
            this.e2();
            return super.c = JsonToken.VALUE_TRUE;
        }
        if (n == 123) {
            super.I = super.I.k(super.G, super.H);
            return super.c = JsonToken.START_OBJECT;
        }
        switch (n) {
            default: {
                return super.c = this.X1(n);
            }
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57: {
                return super.c = this.n2(n);
            }
        }
    }
    
    private static final int h2(int n, final int n2) {
        if (n2 != 4) {
            n |= -1 << (n2 << 3);
        }
        return n;
    }
    
    private final JsonToken j2(char[] array, int n, int n2, final boolean b, final int n3) throws IOException {
        int n4 = 0;
        int n9 = 0;
        char[] array2 = null;
        int n10 = 0;
        int n11 = 0;
        Label_0239: {
            if (n2 == 46) {
                char[] p5 = array;
                int n5;
                if ((n5 = n) >= array.length) {
                    p5 = super.K.p();
                    n5 = 0;
                }
                p5[n5] = (char)n2;
                n = n5 + 1;
                int n6 = 0;
                int n7 = n2;
                n2 = n;
                array = p5;
                while (true) {
                    while (super.A < super.B || this.Y1()) {
                        final byte[] g0 = this.g0;
                        n = super.A++;
                        n7 = (g0[n] & 0xFF);
                        if (n7 >= 48 && n7 <= 57) {
                            ++n6;
                            char[] p6 = array;
                            if ((n = n2) >= array.length) {
                                p6 = super.K.p();
                                n = 0;
                            }
                            p6[n] = (char)n7;
                            n2 = n + 1;
                            array = p6;
                        }
                        else {
                            final int n8 = 0;
                            n9 = n6;
                            n = n8;
                            array2 = array;
                            n10 = n2;
                            n11 = n7;
                            if (n6 == 0) {
                                this.G0(n7, "Decimal point not followed by a digit");
                                n9 = n6;
                                n = n8;
                                array2 = array;
                                n10 = n2;
                                n11 = n7;
                            }
                            break Label_0239;
                        }
                    }
                    final int n8 = 1;
                    continue;
                }
            }
            n9 = 0;
            final int n12 = 0;
            n11 = n2;
            n10 = n;
            array2 = array;
            n = n12;
        }
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        Label_0611: {
            if (n11 != 101) {
                n13 = n;
                n14 = n10;
                if ((n15 = n11) != 69) {
                    break Label_0611;
                }
            }
            array = array2;
            if ((n2 = n10) >= array2.length) {
                array = super.K.p();
                n2 = 0;
            }
            final int n16 = n2 + 1;
            array[n2] = (char)n11;
            if (super.A >= super.B) {
                this.Z1();
            }
            final byte[] g2 = this.g0;
            n2 = super.A++;
            final int n17 = g2[n2] & 0xFF;
            while (true) {
                Label_0375: {
                    if (n17 == 45) {
                        break Label_0375;
                    }
                    n2 = n16;
                    char[] p7 = array;
                    int n18;
                    if ((n18 = n17) == 43) {
                        break Label_0375;
                    }
                    int n19 = 0;
                    while (n18 >= 48 && n18 <= 57) {
                        ++n19;
                        int n20 = n2;
                        array = p7;
                        if (n2 >= p7.length) {
                            array = super.K.p();
                            n20 = 0;
                        }
                        n2 = n20 + 1;
                        array[n20] = (char)n18;
                        if (super.A >= super.B && !this.Y1()) {
                            n = 1;
                            break;
                        }
                        n18 = (this.g0[super.A++] & 0xFF);
                        p7 = array;
                    }
                    n4 = n19;
                    n13 = n;
                    n14 = n2;
                    n15 = n18;
                    if (n19 == 0) {
                        this.G0(n18, "Exponent indicator not followed by a digit");
                        n15 = n18;
                        n14 = n2;
                        n13 = n;
                        n4 = n19;
                    }
                    break Label_0611;
                }
                n2 = n16;
                char[] p7 = array;
                if (n16 >= array.length) {
                    p7 = super.K.p();
                    n2 = 0;
                }
                p7[n2] = (char)n17;
                if (super.A >= super.B) {
                    this.Z1();
                }
                int n18 = this.g0[super.A++] & 0xFF;
                ++n2;
                continue;
            }
        }
        if (n13 == 0) {
            --super.A;
            if (super.I.f()) {
                this.M2(n15);
            }
        }
        super.K.D(n14);
        return this.A1(b, n3, n9, n4);
    }
    
    private final JsonToken m2(char[] array, int n, final boolean b, int n2) throws IOException {
        while (super.A < super.B || this.Y1()) {
            final byte[] g0 = this.g0;
            final int a = super.A;
            final int a2 = a + 1;
            super.A = a2;
            final int n3 = g0[a] & 0xFF;
            if (n3 <= 57 && n3 >= 48) {
                char[] p4 = array;
                int n4;
                if ((n4 = n) >= array.length) {
                    p4 = super.K.p();
                    n4 = 0;
                }
                p4[n4] = (char)n3;
                ++n2;
                n = n4 + 1;
                array = p4;
            }
            else {
                if (n3 != 46 && n3 != 101 && n3 != 69) {
                    super.A = a2 - 1;
                    super.K.D(n);
                    if (super.I.f()) {
                        final byte[] g2 = this.g0;
                        n = super.A++;
                        this.M2(g2[n] & 0xFF);
                    }
                    return this.B1(b, n2);
                }
                return this.j2(array, n, n3, b, n2);
            }
        }
        super.K.D(n);
        return this.B1(b, n2);
    }
    
    private final void u2() throws IOException {
        final int[] f = com.fasterxml.jackson.core.io.a.f();
        while (super.A < super.B || this.Y1()) {
            final byte[] g0 = this.g0;
            final int a = super.A;
            final int n = a + 1;
            super.A = n;
            final int n2 = g0[a] & 0xFF;
            final int n3 = f[n2];
            if (n3 != 0) {
                if (n3 != 2) {
                    if (n3 != 3) {
                        if (n3 != 4) {
                            if (n3 != 10) {
                                if (n3 != 13) {
                                    if (n3 != 42) {
                                        this.o2(n2);
                                    }
                                    else {
                                        if (n >= super.B && !this.Y1()) {
                                            break;
                                        }
                                        final byte[] g2 = this.g0;
                                        final int a2 = super.A;
                                        if (g2[a2] == 47) {
                                            super.A = a2 + 1;
                                            return;
                                        }
                                        continue;
                                    }
                                }
                                else {
                                    this.v2();
                                }
                            }
                            else {
                                ++super.D;
                                super.E = n;
                            }
                        }
                        else {
                            this.D2(n2);
                        }
                    }
                    else {
                        this.C2();
                    }
                }
                else {
                    this.B2();
                }
            }
        }
        this.f0(" in a comment", null);
    }
    
    private final int w2() throws IOException {
        final int a = super.A;
        if (a + 4 >= super.B) {
            return this.x2(false);
        }
        final byte[] g0 = this.g0;
        final byte b = g0[a];
        if (b == 58) {
            final int a2 = a + 1;
            super.A = a2;
            final byte b2 = g0[a2];
            if (b2 <= 32) {
                if (b2 == 32 || b2 == 9) {
                    final int a3 = a2 + 1;
                    super.A = a3;
                    final byte b3 = g0[a3];
                    if (b3 > 32) {
                        if (b3 != 47 && b3 != 35) {
                            super.A = a3 + 1;
                            return b3;
                        }
                        return this.x2(true);
                    }
                }
                return this.x2(true);
            }
            if (b2 != 47 && b2 != 35) {
                super.A = a2 + 1;
                return b2;
            }
            return this.x2(true);
        }
        else {
            byte b4;
            if (b == 32 || (b4 = b) == 9) {
                final int a4 = a + 1;
                super.A = a4;
                b4 = g0[a4];
            }
            if (b4 != 58) {
                return this.x2(false);
            }
            int n = super.A + 1;
            super.A = n;
            final byte b5 = g0[n];
            if (b5 <= 32) {
                if (b5 == 32 || b5 == 9) {
                    ++n;
                    super.A = n;
                    final byte b6 = g0[n];
                    if (b6 > 32) {
                        if (b6 != 47 && b6 != 35) {
                            super.A = n + 1;
                            return b6;
                        }
                        return this.x2(true);
                    }
                }
                return this.x2(true);
            }
            if (b5 != 47 && b5 != 35) {
                super.A = n + 1;
                return b5;
            }
            return this.x2(true);
        }
    }
    
    private final int x2(boolean b) throws IOException {
        while (super.A < super.B || this.Y1()) {
            final byte[] g0 = this.g0;
            final int a = super.A;
            final int n = a + 1;
            super.A = n;
            final int n2 = g0[a] & 0xFF;
            if (n2 > 32) {
                if (n2 == 47) {
                    this.y2();
                }
                else {
                    if (n2 == 35 && this.I2()) {
                        continue;
                    }
                    if (b) {
                        return n2;
                    }
                    if (n2 != 58) {
                        this.l0(n2, "was expecting a colon to separate field name and value");
                    }
                    b = true;
                }
            }
            else {
                if (n2 == 32) {
                    continue;
                }
                if (n2 == 10) {
                    ++super.D;
                    super.E = n;
                }
                else if (n2 == 13) {
                    this.v2();
                }
                else {
                    if (n2 == 9) {
                        continue;
                    }
                    this.r0(n2);
                }
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(" within/between ");
        sb.append(super.I.g());
        sb.append(" entries");
        this.f0(sb.toString(), null);
        return -1;
    }
    
    private final void y2() throws IOException {
        if (!this.E(Feature.ALLOW_COMMENTS)) {
            this.l0(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (super.A >= super.B && !this.Y1()) {
            this.f0(" in a comment", null);
        }
        final int n = this.g0[super.A++] & 0xFF;
        if (n == 47) {
            this.z2();
        }
        else if (n == 42) {
            this.u2();
        }
        else {
            this.l0(n, "was expecting either '*' or '/' for a comment");
        }
    }
    
    private final void z2() throws IOException {
        final int[] f = com.fasterxml.jackson.core.io.a.f();
        while (super.A < super.B || this.Y1()) {
            final byte[] g0 = this.g0;
            final int a = super.A;
            final int n = a + 1;
            super.A = n;
            final int n2 = g0[a] & 0xFF;
            final int n3 = f[n2];
            if (n3 != 0) {
                if (n3 != 2) {
                    if (n3 != 3) {
                        if (n3 != 4) {
                            if (n3 == 10) {
                                ++super.D;
                                super.E = n;
                                return;
                            }
                            if (n3 == 13) {
                                this.v2();
                                return;
                            }
                            if (n3 == 42 || n3 >= 0) {
                                continue;
                            }
                            this.o2(n2);
                        }
                        else {
                            this.D2(n2);
                        }
                    }
                    else {
                        this.C2();
                    }
                }
                else {
                    this.B2();
                }
            }
        }
    }
    
    protected void A2() throws IOException {
        this.a0 = false;
        final int[] i0 = j.i0;
        final byte[] g0 = this.g0;
    Block_4:
        while (true) {
            final int a = super.A;
            final int b = super.B;
            int j = a;
            int b2 = b;
            if (a >= b) {
                this.Z1();
                j = super.A;
                b2 = super.B;
            }
            while (j < b2) {
                final int a2 = j + 1;
                final int n = g0[j] & 0xFF;
                if (i0[n] != 0) {
                    super.A = a2;
                    if (n == 34) {
                        break Block_4;
                    }
                    final int n2 = i0[n];
                    if (n2 == 1) {
                        this.M1();
                        continue Block_4;
                    }
                    if (n2 == 2) {
                        this.B2();
                        continue Block_4;
                    }
                    if (n2 == 3) {
                        this.C2();
                        continue Block_4;
                    }
                    if (n2 == 4) {
                        this.D2(n);
                        continue Block_4;
                    }
                    if (n < 32) {
                        this.t0(n, "string value");
                        continue Block_4;
                    }
                    this.o2(n);
                    continue Block_4;
                }
                else {
                    j = a2;
                }
            }
            super.A = j;
        }
    }
    
    @Override
    public JsonToken F() throws IOException {
        final JsonToken c = super.c;
        final JsonToken field_NAME = JsonToken.FIELD_NAME;
        if (c == field_NAME) {
            return this.f2();
        }
        super.O = 0;
        if (this.a0) {
            this.A2();
        }
        final int g2 = this.G2();
        if (g2 < 0) {
            this.close();
            return super.c = null;
        }
        super.N = null;
        if (g2 == 93) {
            this.E1();
            return super.c = JsonToken.END_ARRAY;
        }
        if (g2 == 125) {
            this.F1();
            return super.c = JsonToken.END_OBJECT;
        }
        int e2 = g2;
        if (super.I.m()) {
            if (g2 != 44) {
                final StringBuilder sb = new StringBuilder();
                sb.append("was expecting comma to separate ");
                sb.append(super.I.g());
                sb.append(" entries");
                this.l0(g2, sb.toString());
            }
            final int n = e2 = this.E2();
            if ((super.a & j.k0) != 0x0 && (n == 93 || (e2 = n) == 125)) {
                return this.K1(n);
            }
        }
        if (!super.I.e()) {
            this.J2();
            return this.g2(e2);
        }
        this.K2();
        super.I.q(this.k2(e2));
        super.c = field_NAME;
        final int w2 = this.w2();
        this.J2();
        if (w2 == 34) {
            this.a0 = true;
            super.J = JsonToken.VALUE_STRING;
            return super.c;
        }
        JsonToken j;
        if (w2 != 45) {
            if (w2 != 91) {
                if (w2 != 102) {
                    if (w2 != 110) {
                        if (w2 != 116) {
                            if (w2 != 123) {
                                switch (w2) {
                                    default: {
                                        j = this.X1(w2);
                                        break;
                                    }
                                    case 48:
                                    case 49:
                                    case 50:
                                    case 51:
                                    case 52:
                                    case 53:
                                    case 54:
                                    case 55:
                                    case 56:
                                    case 57: {
                                        j = this.n2(w2);
                                        break;
                                    }
                                }
                            }
                            else {
                                j = JsonToken.START_OBJECT;
                            }
                        }
                        else {
                            this.e2();
                            j = JsonToken.VALUE_TRUE;
                        }
                    }
                    else {
                        this.b2();
                        j = JsonToken.VALUE_NULL;
                    }
                }
                else {
                    this.a2();
                    j = JsonToken.VALUE_FALSE;
                }
            }
            else {
                j = JsonToken.START_ARRAY;
            }
        }
        else {
            j = this.l2();
        }
        super.J = j;
        return super.c;
    }
    
    @Override
    protected void J0() throws IOException {
        if (this.f0 != null) {
            if (super.y.l() || this.E(Feature.AUTO_CLOSE_SOURCE)) {
                this.f0.close();
            }
            this.f0 = null;
        }
    }
    
    protected int L1(int n) throws IOException {
        final int n2 = n &= 0xFF;
        if (n2 > 127) {
            int n3 = 0;
            Label_0091: {
                if ((n2 & 0xE0) == 0xC0) {
                    n = (n2 & 0x1F);
                }
                else {
                    if ((n2 & 0xF0) == 0xE0) {
                        n = (n2 & 0xF);
                        n3 = 2;
                        break Label_0091;
                    }
                    if ((n2 & 0xF8) == 0xF0) {
                        n = (n2 & 0x7);
                        n3 = 3;
                        break Label_0091;
                    }
                    this.p2(n2 & 0xFF);
                    n = n2;
                }
                n3 = 1;
            }
            final int s2 = this.S2();
            if ((s2 & 0xC0) != 0x80) {
                this.q2(s2 & 0xFF);
            }
            final int n4 = n = (n << 6 | (s2 & 0x3F));
            if (n3 > 1) {
                n = this.S2();
                if ((n & 0xC0) != 0x80) {
                    this.q2(n & 0xFF);
                }
                final int n5 = n = (n4 << 6 | (n & 0x3F));
                if (n3 > 2) {
                    n = this.S2();
                    if ((n & 0xC0) != 0x80) {
                        this.q2(n & 0xFF);
                    }
                    n = (n5 << 6 | (n & 0x3F));
                }
            }
        }
        return n;
    }
    
    protected char M1() throws IOException {
        if (super.A >= super.B && !this.Y1()) {
            this.f0(" in character escape sequence", JsonToken.VALUE_STRING);
        }
        final byte b = this.g0[super.A++];
        if (b == 34 || b == 47 || b == 92) {
            return (char)b;
        }
        if (b == 98) {
            return '\b';
        }
        if (b == 102) {
            return '\f';
        }
        if (b == 110) {
            return '\n';
        }
        if (b == 114) {
            return '\r';
        }
        if (b == 116) {
            return '\t';
        }
        if (b != 117) {
            return this.W((char)this.L1(b));
        }
        int i = 0;
        int n = 0;
        while (i < 4) {
            if (super.A >= super.B && !this.Y1()) {
                this.f0(" in character escape sequence", JsonToken.VALUE_STRING);
            }
            final byte b2 = this.g0[super.A++];
            final int b3 = com.fasterxml.jackson.core.io.a.b(b2);
            if (b3 < 0) {
                this.l0(b2, "expected a hex-digit for character escape sequence");
            }
            n = (n << 4 | b3);
            ++i;
        }
        return (char)n;
    }
    
    protected String R1() throws IOException {
        int i;
        if ((i = super.A) >= super.B) {
            this.Z1();
            i = super.A;
        }
        int n = 0;
        final char[] m = super.K.m();
        final int[] i2 = j.i0;
        final int min = Math.min(super.B, m.length + i);
        final byte[] g0 = this.g0;
        while (i < min) {
            final int n2 = g0[i] & 0xFF;
            if (i2[n2] != 0) {
                if (n2 == 34) {
                    super.A = i + 1;
                    return super.K.C(n);
                }
                break;
            }
            else {
                ++i;
                m[n] = (char)n2;
                ++n;
            }
        }
        super.A = i;
        this.S1(m, n);
        return super.K.l();
    }
    
    protected final String T1(final JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        final int id = jsonToken.id();
        if (id == 5) {
            return super.I.b();
        }
        if (id != 6 && id != 7 && id != 8) {
            return jsonToken.asString();
        }
        return super.K.l();
    }
    
    protected final String T2(int[] array, int n, int n2, int n3, int n4) throws IOException {
        final int[] j0 = j.j0;
        int m1 = n3;
        while (true) {
            int[] array2 = array;
            int n5 = n;
            int n6 = n2;
            n3 = m1;
            int n7 = n4;
            if (j0[m1] != 0) {
                if (m1 == 34) {
                    break;
                }
                if (m1 != 92) {
                    this.t0(m1, "name");
                }
                else {
                    m1 = this.M1();
                }
                array2 = array;
                n5 = n;
                n6 = n2;
                n3 = m1;
                n7 = n4;
                if (m1 > 127) {
                    final int n8 = 0;
                    int[] s1 = array;
                    n3 = n;
                    int n9 = n2;
                    int n10;
                    if ((n10 = n4) >= 4) {
                        s1 = array;
                        if (n >= array.length) {
                            s1 = b.s1(array, array.length);
                            this.Z = s1;
                        }
                        s1[n] = n2;
                        n3 = n + 1;
                        n9 = 0;
                        n10 = 0;
                    }
                    if (m1 < 2048) {
                        n = (n9 << 8 | (m1 >> 6 | 0xC0));
                        n2 = n10 + 1;
                        array = s1;
                        n5 = n3;
                    }
                    else {
                        n2 = (n9 << 8 | (m1 >> 12 | 0xE0));
                        n = n10 + 1;
                        if (n >= 4) {
                            array = s1;
                            if (n3 >= s1.length) {
                                array = b.s1(s1, s1.length);
                                this.Z = array;
                            }
                            array[n3] = n2;
                            ++n3;
                            n = 0;
                            n2 = n8;
                        }
                        else {
                            array = s1;
                        }
                        n4 = (n2 << 8 | ((m1 >> 6 & 0x3F) | 0x80));
                        n2 = n + 1;
                        n = n4;
                        n5 = n3;
                    }
                    n3 = ((m1 & 0x3F) | 0x80);
                    n7 = n2;
                    n6 = n;
                    array2 = array;
                }
            }
            if (n7 < 4) {
                n4 = n7 + 1;
                n2 = (n6 << 8 | n3);
                array = array2;
                n = n5;
            }
            else {
                array = array2;
                if (n5 >= array2.length) {
                    array = b.s1(array2, array2.length);
                    this.Z = array;
                }
                array[n5] = n6;
                n2 = n3;
                n = n5 + 1;
                n4 = 1;
            }
            if (super.A >= super.B && !this.Y1()) {
                this.f0(" in field name", JsonToken.FIELD_NAME);
            }
            final byte[] g0 = this.g0;
            n3 = super.A++;
            m1 = (g0[n3] & 0xFF);
        }
        int[] s2 = array;
        n3 = n;
        if (n4 > 0) {
            s2 = array;
            if (n >= array.length) {
                s2 = b.s1(array, array.length);
                this.Z = s2;
            }
            s2[n] = h2(n2, n4);
            n3 = n + 1;
        }
        String s3;
        if ((s3 = this.Y.F(s2, n3)) == null) {
            s3 = this.N2(s2, n3, n4);
        }
        return s3;
    }
    
    protected JsonToken U1() throws IOException {
        char[] array = super.K.m();
        final int[] i0 = j.i0;
        final byte[] g0 = this.g0;
        int n = 0;
        int n4 = 0;
    Label_0022:
        while (true) {
            if (super.A >= super.B) {
                this.Z1();
            }
            char[] array2 = array;
            int n2;
            if ((n2 = n) >= array.length) {
                array2 = super.K.p();
                n2 = 0;
            }
            final int b = super.B;
            final int n3 = super.A + (array2.length - n2);
            n4 = n2;
            int n5;
            if (n3 < (n5 = b)) {
                n5 = n3;
                n4 = n2;
            }
            int a2;
            int n6;
            while (true) {
                final int a = super.A;
                array = array2;
                n = n4;
                if (a >= n5) {
                    continue Label_0022;
                }
                a2 = a + 1;
                super.A = a2;
                n6 = (g0[a] & 0xFF);
                if (n6 == 39 || i0[n6] != 0) {
                    break;
                }
                array2[n4] = (char)n6;
                ++n4;
            }
            if (n6 == 39) {
                break;
            }
            final int n7 = i0[n6];
            if (n7 != 1) {
                if (n7 != 2) {
                    if (n7 != 3) {
                        if (n7 != 4) {
                            if (n6 < 32) {
                                this.t0(n6, "string value");
                            }
                            this.o2(n6);
                        }
                        else {
                            final int q1 = this.Q1(n6);
                            final int n8 = n4 + 1;
                            array2[n4] = (char)(0xD800 | q1 >> 10);
                            if (n8 >= array2.length) {
                                array2 = super.K.p();
                                n4 = 0;
                            }
                            else {
                                n4 = n8;
                            }
                            n6 = (0xDC00 | (q1 & 0x3FF));
                        }
                    }
                    else if (super.B - a2 >= 2) {
                        n6 = this.P1(n6);
                    }
                    else {
                        n6 = this.O1(n6);
                    }
                }
                else {
                    n6 = this.N1(n6);
                }
            }
            else {
                n6 = this.M1();
            }
            array = array2;
            int n9 = n4;
            if (n4 >= array2.length) {
                array = super.K.p();
                n9 = 0;
            }
            array[n9] = (char)n6;
            n = n9 + 1;
        }
        super.K.D(n4);
        return JsonToken.VALUE_STRING;
    }
    
    protected final String U2(int n, int a, int n2) throws IOException {
        final int[] z = this.Z;
        z[0] = this.b0;
        z[1] = a;
        z[2] = n2;
        final byte[] g0 = this.g0;
        final int[] j0 = j.j0;
        n2 = 3;
        a = n;
        n = n2;
        while (true) {
            final int a2 = super.A;
            if (a2 + 4 > super.B) {
                return this.T2(this.Z, n, 0, a, 0);
            }
            n2 = a2 + 1;
            super.A = n2;
            final int n3 = g0[a2] & 0xFF;
            if (j0[n3] != 0) {
                if (n3 == 34) {
                    return this.R2(this.Z, n, a, 1);
                }
                return this.T2(this.Z, n, a, n3, 1);
            }
            else {
                final int n4 = a << 8 | n3;
                a = n2 + 1;
                super.A = a;
                n2 = (g0[n2] & 0xFF);
                if (j0[n2] != 0) {
                    if (n2 == 34) {
                        return this.R2(this.Z, n, n4, 2);
                    }
                    return this.T2(this.Z, n, n4, n2, 2);
                }
                else {
                    final int n5 = n4 << 8 | n2;
                    n2 = a + 1;
                    super.A = n2;
                    a = (g0[a] & 0xFF);
                    if (j0[a] != 0) {
                        if (a == 34) {
                            return this.R2(this.Z, n, n5, 3);
                        }
                        return this.T2(this.Z, n, n5, a, 3);
                    }
                    else {
                        final int n6 = n5 << 8 | a;
                        super.A = n2 + 1;
                        a = (g0[n2] & 0xFF);
                        if (j0[a] != 0) {
                            if (a == 34) {
                                return this.R2(this.Z, n, n6, 4);
                            }
                            return this.T2(this.Z, n, n6, a, 4);
                        }
                        else {
                            final int[] z2 = this.Z;
                            if (n >= z2.length) {
                                this.Z = b.s1(z2, n);
                            }
                            this.Z[n] = n6;
                            ++n;
                        }
                    }
                }
            }
        }
    }
    
    protected JsonToken V1(int n, final boolean b) throws IOException {
        int n2;
        while (true) {
            n2 = n;
            if (n != 73) {
                break;
            }
            if (super.A >= super.B && !this.Y1()) {
                this.g0(JsonToken.VALUE_NUMBER_FLOAT);
            }
            final byte[] g0 = this.g0;
            n = super.A++;
            n = g0[n];
            String s;
            if (n == 78) {
                if (b) {
                    s = "-INF";
                }
                else {
                    s = "+INF";
                }
            }
            else {
                if ((n2 = n) != 110) {
                    break;
                }
                if (b) {
                    s = "-Infinity";
                }
                else {
                    s = "+Infinity";
                }
            }
            this.c2(s, 3);
            if (this.E(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                double n3;
                if (b) {
                    n3 = Double.NEGATIVE_INFINITY;
                }
                else {
                    n3 = Double.POSITIVE_INFINITY;
                }
                return this.y1(s, n3);
            }
            this.a0("Non-standard token '%s': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow", s);
        }
        this.G0(n2, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }
    
    protected final String V2(int a) throws IOException {
        final byte[] g0 = this.g0;
        final int[] j0 = j.j0;
        final int a2 = super.A;
        final int a3 = a2 + 1;
        super.A = a3;
        final int n = g0[a2] & 0xFF;
        if (j0[n] != 0) {
            if (n == 34) {
                return this.P2(this.b0, a, 1);
            }
            return this.Y2(this.b0, a, n, 1);
        }
        else {
            final int n2 = a << 8 | n;
            a = a3 + 1;
            super.A = a;
            final int n3 = g0[a3] & 0xFF;
            if (j0[n3] != 0) {
                if (n3 == 34) {
                    return this.P2(this.b0, n2, 2);
                }
                return this.Y2(this.b0, n2, n3, 2);
            }
            else {
                final int n4 = n2 << 8 | n3;
                final int a4 = a + 1;
                super.A = a4;
                a = (g0[a] & 0xFF);
                if (j0[a] != 0) {
                    if (a == 34) {
                        return this.P2(this.b0, n4, 3);
                    }
                    return this.Y2(this.b0, n4, a, 3);
                }
                else {
                    a |= n4 << 8;
                    super.A = a4 + 1;
                    final int n5 = g0[a4] & 0xFF;
                    if (j0[n5] == 0) {
                        return this.W2(n5, a);
                    }
                    if (n5 == 34) {
                        return this.P2(this.b0, a, 4);
                    }
                    return this.Y2(this.b0, a, n5, 4);
                }
            }
        }
    }
    
    protected String W1(int n) throws IOException {
        if (n == 39 && this.E(Feature.ALLOW_SINGLE_QUOTES)) {
            return this.i2();
        }
        if (!this.E(Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            this.l0((char)this.L1(n), "was expecting double-quote to start field name");
        }
        final int[] j = com.fasterxml.jackson.core.io.a.j();
        if (j[n] != 0) {
            this.l0(n, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int[] z = this.Z;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5;
        while (true) {
            if (n2 < 4) {
                ++n2;
                n |= n4 << 8;
                n5 = n2;
            }
            else {
                int[] s1 = z;
                if (n3 >= z.length) {
                    s1 = b.s1(z, z.length);
                    this.Z = s1;
                }
                s1[n3] = n4;
                ++n3;
                n5 = 1;
                z = s1;
            }
            if (super.A >= super.B && !this.Y1()) {
                this.f0(" in field name", JsonToken.FIELD_NAME);
            }
            final byte[] g0 = this.g0;
            final int a = super.A;
            final int n6 = g0[a] & 0xFF;
            if (j[n6] != 0) {
                break;
            }
            super.A = a + 1;
            n2 = n5;
            n4 = n;
            n = n6;
        }
        int[] s2 = z;
        int n7 = n3;
        if (n5 > 0) {
            s2 = z;
            if (n3 >= z.length) {
                s2 = b.s1(z, z.length);
                this.Z = s2;
            }
            s2[n3] = n;
            n7 = n3 + 1;
        }
        String s3;
        if ((s3 = this.Y.F(s2, n7)) == null) {
            s3 = this.N2(s2, n7, n5);
        }
        return s3;
    }
    
    protected final String W2(int a, final int n) throws IOException {
        final byte[] g0 = this.g0;
        final int[] j0 = j.j0;
        final int a2 = super.A;
        final int a3 = a2 + 1;
        super.A = a3;
        final int n2 = g0[a2] & 0xFF;
        if (j0[n2] != 0) {
            if (n2 == 34) {
                return this.Q2(this.b0, n, a, 1);
            }
            return this.Z2(this.b0, n, a, n2, 1);
        }
        else {
            final int n3 = a << 8 | n2;
            a = a3 + 1;
            super.A = a;
            final int n4 = g0[a3] & 0xFF;
            if (j0[n4] != 0) {
                if (n4 == 34) {
                    return this.Q2(this.b0, n, n3, 2);
                }
                return this.Z2(this.b0, n, n3, n4, 2);
            }
            else {
                final int n5 = n3 << 8 | n4;
                final int a4 = a + 1;
                super.A = a4;
                a = (g0[a] & 0xFF);
                if (j0[a] != 0) {
                    if (a == 34) {
                        return this.Q2(this.b0, n, n5, 3);
                    }
                    return this.Z2(this.b0, n, n5, a, 3);
                }
                else {
                    a |= n5 << 8;
                    super.A = a4 + 1;
                    final int n6 = g0[a4] & 0xFF;
                    if (j0[n6] == 0) {
                        return this.U2(n6, n, a);
                    }
                    if (n6 == 34) {
                        return this.Q2(this.b0, n, a, 4);
                    }
                    return this.Z2(this.b0, n, a, n6, 4);
                }
            }
        }
    }
    
    protected JsonToken X1(int n) throws IOException {
        Label_0241: {
            if (n != 39) {
                if (n != 73) {
                    if (n != 78) {
                        Label_0137: {
                            if (n != 93) {
                                if (n == 125) {
                                    break Label_0137;
                                }
                                if (n == 43) {
                                    if (super.A >= super.B && !this.Y1()) {
                                        this.g0(JsonToken.VALUE_NUMBER_INT);
                                    }
                                    final byte[] g0 = this.g0;
                                    n = super.A++;
                                    return this.V1(g0[n] & 0xFF, false);
                                }
                                if (n != 44) {
                                    break Label_0241;
                                }
                            }
                            else if (!super.I.d()) {
                                break Label_0241;
                            }
                            if (this.E(Feature.ALLOW_MISSING_VALUES)) {
                                --super.A;
                                return JsonToken.VALUE_NULL;
                            }
                        }
                        this.l0(n, "expected a value");
                    }
                    else {
                        this.c2("NaN", 1);
                        if (this.E(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                            return this.y1("NaN", Double.NaN);
                        }
                        this.Z("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                        break Label_0241;
                    }
                }
                else {
                    this.c2("Infinity", 1);
                    if (this.E(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                        return this.y1("Infinity", Double.POSITIVE_INFINITY);
                    }
                    this.Z("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    break Label_0241;
                }
            }
            if (this.E(Feature.ALLOW_SINGLE_QUOTES)) {
                return this.U1();
            }
        }
        if (Character.isJavaIdentifierStart(n)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append((char)n);
            this.t2(sb.toString(), "('true', 'false' or 'null')");
        }
        this.l0(n, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }
    
    protected final boolean Y1() throws IOException {
        final int b = super.B;
        super.C += b;
        super.E -= b;
        this.c0 -= b;
        final InputStream f0 = this.f0;
        if (f0 != null) {
            final byte[] g0 = this.g0;
            final int length = g0.length;
            if (length == 0) {
                return false;
            }
            final int read = f0.read(g0, 0, length);
            if (read > 0) {
                super.A = 0;
                super.B = read;
                return true;
            }
            this.J0();
            if (read == 0) {
                final StringBuilder sb = new StringBuilder();
                sb.append("InputStream.read() returned 0 characters when trying to read ");
                sb.append(this.g0.length);
                sb.append(" bytes");
                throw new IOException(sb.toString());
            }
        }
        return false;
    }
    
    protected void Z1() throws IOException {
        if (!this.Y1()) {
            this.e0();
        }
    }
    
    @Override
    protected void a1() throws IOException {
        super.a1();
        this.Y.M();
        if (this.h0) {
            final byte[] g0 = this.g0;
            if (g0 != null) {
                this.g0 = x2.c.d;
                super.y.o(g0);
            }
        }
    }
    
    protected final void a2() throws IOException {
        final int a = super.A;
        if (a + 4 < super.B) {
            final byte[] g0 = this.g0;
            final int n = a + 1;
            if (g0[a] == 97) {
                final int n2 = n + 1;
                if (g0[n] == 108) {
                    final int n3 = n2 + 1;
                    if (g0[n2] == 115) {
                        final int a2 = n3 + 1;
                        if (g0[n3] == 101) {
                            final int n4 = g0[a2] & 0xFF;
                            if (n4 < 48 || n4 == 93 || n4 == 125) {
                                super.A = a2;
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.d2("false", 1);
    }
    
    protected String a3() throws IOException {
        if (super.A >= super.B && !this.Y1()) {
            this.f0(": was expecting closing '\"' for name", JsonToken.FIELD_NAME);
        }
        final int n = this.g0[super.A++] & 0xFF;
        if (n == 34) {
            return "";
        }
        return this.T2(this.Z, 0, 0, n, 0);
    }
    
    protected final void b2() throws IOException {
        final int a = super.A;
        if (a + 3 < super.B) {
            final byte[] g0 = this.g0;
            final int n = a + 1;
            if (g0[a] == 117) {
                final int n2 = n + 1;
                if (g0[n] == 108) {
                    final int a2 = n2 + 1;
                    if (g0[n2] == 108) {
                        final int n3 = g0[a2] & 0xFF;
                        if (n3 < 48 || n3 == 93 || n3 == 125) {
                            super.A = a2;
                            return;
                        }
                    }
                }
            }
        }
        this.d2("null", 1);
    }
    
    protected final void c2(final String s, int n) throws IOException {
        final int length = s.length();
        int n2 = n;
        if (super.A + length >= super.B) {
            this.d2(s, n);
            return;
        }
        int a;
        do {
            if (this.g0[super.A] != s.charAt(n2)) {
                this.s2(s.substring(0, n2));
            }
            a = super.A + 1;
            super.A = a;
            n = n2 + 1;
        } while ((n2 = n) < length);
        final int n3 = this.g0[a] & 0xFF;
        if (n3 >= 48 && n3 != 93 && n3 != 125) {
            this.C1(s, n, n3);
        }
    }
    
    @Override
    public JsonLocation e() {
        return new JsonLocation(this.L0(), super.C + super.A, -1L, super.D, super.A - super.E + 1);
    }
    
    protected final void e2() throws IOException {
        final int a = super.A;
        if (a + 3 < super.B) {
            final byte[] g0 = this.g0;
            final int n = a + 1;
            if (g0[a] == 114) {
                final int n2 = n + 1;
                if (g0[n] == 117) {
                    final int a2 = n2 + 1;
                    if (g0[n2] == 101) {
                        final int n3 = g0[a2] & 0xFF;
                        if (n3 < 48 || n3 == 93 || n3 == 125) {
                            super.A = a2;
                            return;
                        }
                    }
                }
            }
        }
        this.d2("true", 1);
    }
    
    protected String i2() throws IOException {
        if (super.A >= super.B && !this.Y1()) {
            this.f0(": was expecting closing ''' for field name", JsonToken.FIELD_NAME);
        }
        int i = this.g0[super.A++] & 0xFF;
        if (i == 39) {
            return "";
        }
        int[] z = this.Z;
        final int[] j0 = j.j0;
        int n = 0;
        int n3;
        int n2 = n3 = 0;
        while (i != 39) {
            int n4 = i;
            int[] array = z;
            int n5 = n;
            int n6 = n2;
            int n7 = n3;
            if (j0[i] != 0) {
                n4 = i;
                array = z;
                n5 = n;
                n6 = n2;
                n7 = n3;
                if (i != 34) {
                    int m1;
                    if (i != 92) {
                        this.t0(i, "name");
                        m1 = i;
                    }
                    else {
                        m1 = this.M1();
                    }
                    n4 = m1;
                    array = z;
                    n5 = n;
                    n6 = n2;
                    n7 = n3;
                    if (m1 > 127) {
                        int[] s1 = z;
                        int n8 = n;
                        int n9 = n2;
                        int n10 = n3;
                        if (n >= 4) {
                            s1 = z;
                            if (n2 >= z.length) {
                                s1 = b.s1(z, z.length);
                                this.Z = s1;
                            }
                            s1[n2] = n3;
                            n10 = 0;
                            n9 = n2 + 1;
                            n8 = 0;
                        }
                        int n11;
                        int n12;
                        int[] s2;
                        if (m1 < 2048) {
                            n11 = (n10 << 8 | (m1 >> 6 | 0xC0));
                            n12 = n8 + 1;
                            s2 = s1;
                        }
                        else {
                            final int n13 = n10 << 8 | (m1 >> 12 | 0xE0);
                            ++n8;
                            s2 = s1;
                            int n14 = n8;
                            int n15 = n9;
                            int n16 = n13;
                            if (n8 >= 4) {
                                s2 = s1;
                                if (n9 >= s1.length) {
                                    s2 = b.s1(s1, s1.length);
                                    this.Z = s2;
                                }
                                s2[n9] = n13;
                                n16 = 0;
                                n15 = n9 + 1;
                                n14 = 0;
                            }
                            n11 = (n16 << 8 | ((m1 >> 6 & 0x3F) | 0x80));
                            ++n14;
                            n9 = n15;
                            n12 = n14;
                        }
                        n4 = ((m1 & 0x3F) | 0x80);
                        n7 = n11;
                        n6 = n9;
                        n5 = n12;
                        array = s2;
                    }
                }
            }
            if (n5 < 4) {
                n = n5 + 1;
                n3 = (n4 | n7 << 8);
                z = array;
                n2 = n6;
            }
            else {
                z = array;
                if (n6 >= array.length) {
                    z = b.s1(array, array.length);
                    this.Z = z;
                }
                z[n6] = n7;
                n3 = n4;
                n2 = n6 + 1;
                n = 1;
            }
            if (super.A >= super.B && !this.Y1()) {
                this.f0(" in field name", JsonToken.FIELD_NAME);
            }
            i = (this.g0[super.A++] & 0xFF);
        }
        int[] s3 = z;
        int n17 = n2;
        if (n > 0) {
            s3 = z;
            if (n2 >= z.length) {
                s3 = b.s1(z, z.length);
                this.Z = s3;
            }
            s3[n2] = h2(n3, n);
            n17 = n2 + 1;
        }
        String s4;
        if ((s4 = this.Y.F(s3, n17)) == null) {
            s4 = this.N2(s3, n17, n);
        }
        return s4;
    }
    
    protected final String k2(int a) throws IOException {
        if (a != 34) {
            return this.W1(a);
        }
        a = super.A;
        if (a + 13 > super.B) {
            return this.a3();
        }
        final byte[] g0 = this.g0;
        final int[] j0 = j.j0;
        final int a2 = a + 1;
        super.A = a2;
        a = (g0[a] & 0xFF);
        if (j0[a] == 0) {
            final int a3 = a2 + 1;
            super.A = a3;
            final int n = g0[a2] & 0xFF;
            if (j0[n] == 0) {
                final int n2 = a << 8 | n;
                a = a3 + 1;
                super.A = a;
                final int n3 = g0[a3] & 0xFF;
                if (j0[n3] == 0) {
                    final int n4 = n2 << 8 | n3;
                    final int a4 = a + 1;
                    super.A = a4;
                    a = (g0[a] & 0xFF);
                    if (j0[a] == 0) {
                        a |= n4 << 8;
                        super.A = a4 + 1;
                        final int n5 = g0[a4] & 0xFF;
                        if (j0[n5] == 0) {
                            this.b0 = a;
                            return this.V2(n5);
                        }
                        if (n5 == 34) {
                            return this.O2(a, 4);
                        }
                        return this.X2(a, n5, 4);
                    }
                    else {
                        if (a == 34) {
                            return this.O2(n4, 3);
                        }
                        return this.X2(n4, a, 3);
                    }
                }
                else {
                    if (n3 == 34) {
                        return this.O2(n2, 2);
                    }
                    return this.X2(n2, n3, 2);
                }
            }
            else {
                if (n == 34) {
                    return this.O2(a, 1);
                }
                return this.X2(a, n, 1);
            }
        }
        else {
            if (a == 34) {
                return "";
            }
            return this.X2(0, a, 0);
        }
    }
    
    protected JsonToken l2() throws IOException {
        final char[] m = super.K.m();
        m[0] = '-';
        if (super.A >= super.B) {
            this.Z1();
        }
        final int n = this.g0[super.A++] & 0xFF;
        int l2;
        if (n <= 48) {
            if (n != 48) {
                return this.V1(n, true);
            }
            l2 = this.L2();
        }
        else if ((l2 = n) > 57) {
            return this.V1(n, true);
        }
        int n2 = 2;
        m[1] = (char)l2;
        final int min = Math.min(super.B, super.A + m.length - 2);
        int n3 = 1;
        while (true) {
            final int a = super.A;
            if (a >= min) {
                return this.m2(m, n2, true, n3);
            }
            final byte[] g0 = this.g0;
            final int a2 = a + 1;
            super.A = a2;
            final int n4 = g0[a] & 0xFF;
            if (n4 >= 48 && n4 <= 57) {
                ++n3;
                m[n2] = (char)n4;
                ++n2;
            }
            else {
                if (n4 != 46 && n4 != 101 && n4 != 69) {
                    super.A = a2 - 1;
                    super.K.D(n2);
                    if (super.I.f()) {
                        this.M2(n4);
                    }
                    return this.B1(true, n3);
                }
                return this.j2(m, n2, n4, true, n3);
            }
        }
    }
    
    protected JsonToken n2(int n) throws IOException {
        final char[] m = super.K.m();
        int l2 = n;
        if (n == 48) {
            l2 = this.L2();
        }
        m[0] = (char)l2;
        final int min = Math.min(super.B, super.A + m.length - 1);
        n = 1;
        int n2 = 1;
        while (true) {
            final int a = super.A;
            if (a >= min) {
                return this.m2(m, n, false, n2);
            }
            final byte[] g0 = this.g0;
            final int a2 = a + 1;
            super.A = a2;
            final int n3 = g0[a] & 0xFF;
            if (n3 >= 48 && n3 <= 57) {
                ++n2;
                m[n] = (char)n3;
                ++n;
            }
            else {
                if (n3 != 46 && n3 != 101 && n3 != 69) {
                    super.A = a2 - 1;
                    super.K.D(n);
                    if (super.I.f()) {
                        this.M2(n3);
                    }
                    return this.B1(false, n2);
                }
                return this.j2(m, n, n3, false, n2);
            }
        }
    }
    
    protected void o2(final int n) throws JsonParseException {
        if (n < 32) {
            this.r0(n);
        }
        this.p2(n);
    }
    
    protected void p2(final int n) throws JsonParseException {
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-8 start byte 0x");
        sb.append(Integer.toHexString(n));
        this.Z(sb.toString());
    }
    
    protected void q2(final int n) throws JsonParseException {
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-8 middle byte 0x");
        sb.append(Integer.toHexString(n));
        this.Z(sb.toString());
    }
    
    protected void r2(final int n, final int a) throws JsonParseException {
        super.A = a;
        this.q2(n);
    }
    
    protected void s2(final String s) throws IOException {
        this.t2(s, "'null', 'true', 'false' or NaN");
    }
    
    protected void t2(final String s, final String s2) throws IOException {
        final StringBuilder sb = new StringBuilder(s);
        while (super.A < super.B || this.Y1()) {
            final char c = (char)this.L1(this.g0[super.A++]);
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            sb.append(c);
            if (sb.length() >= 256) {
                sb.append("...");
                break;
            }
        }
        this.c0("Unrecognized token '%s': was expecting %s", sb, s2);
    }
    
    @Override
    public String u() throws IOException {
        final JsonToken c = super.c;
        if (c != JsonToken.VALUE_STRING) {
            return this.T1(c);
        }
        if (this.a0) {
            this.a0 = false;
            return this.R1();
        }
        return super.K.l();
    }
    
    protected final void v2() throws IOException {
        if (super.A < super.B || this.Y1()) {
            final byte[] g0 = this.g0;
            final int a = super.A;
            if (g0[a] == 10) {
                super.A = a + 1;
            }
        }
        ++super.D;
        super.E = super.A;
    }
}
