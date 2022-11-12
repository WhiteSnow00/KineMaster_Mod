// 
// Decompiled by Procyon v0.6.0
// 

package a3;

import com.fasterxml.jackson.core.util.f;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.c;

public class a extends b
{
    private static final int[] r0;
    protected static final int[] s0;
    protected byte[] q0;
    
    static {
        r0 = com.fasterxml.jackson.core.io.a.i();
        s0 = com.fasterxml.jackson.core.io.a.g();
    }
    
    public a(final com.fasterxml.jackson.core.io.c c, final int n, final b3.a a) {
        super(c, n, a);
        this.q0 = x2.c.d;
    }
    
    private final JsonToken F2() throws IOException {
        final int[] r0 = a.r0;
        final byte[] q0 = this.q0;
        char[] array = super.K.q();
        int n = super.K.s();
        int i = super.A;
        final int b = super.B;
    Label_0039:
        while (i < super.B) {
            final int length = array.length;
            final int n2 = 0;
            boolean b2 = false;
            char[] array2 = array;
            int n3;
            if ((n3 = n) >= length) {
                array2 = super.K.p();
                n3 = 0;
            }
            final int min = Math.min(super.B, array2.length - n3 + i);
            int n4 = i;
            int a;
            int n5;
            while (true) {
                array = array2;
                n = n3;
                i = n4;
                if (n4 >= min) {
                    continue Label_0039;
                }
                a = n4 + 1;
                n5 = (q0[n4] & 0xFF);
                if (r0[n5] != 0) {
                    break;
                }
                array2[n3] = (char)n5;
                ++n3;
                n4 = a;
            }
            if (n5 == 34) {
                super.A = a;
                super.K.D(n3);
                return this.Z1(JsonToken.VALUE_STRING);
            }
            if (a >= b - 5) {
                super.A = a;
                super.K.D(n3);
                final int n6 = r0[n5];
                if (a < super.B) {
                    b2 = true;
                }
                if (!this.f2(n5, n6, b2)) {
                    super.j0 = 40;
                    return super.c = JsonToken.NOT_AVAILABLE;
                }
                array = super.K.q();
                n = super.K.s();
                i = super.A;
            }
            else {
                final int n7 = r0[n5];
                if (n7 != 1) {
                    if (n7 != 2) {
                        if (n7 != 3) {
                            if (n7 != 4) {
                                if (n5 < 32) {
                                    this.t0(n5, "string value");
                                }
                                else {
                                    this.S1(n5);
                                }
                            }
                            else {
                                final byte[] q2 = this.q0;
                                final int n8 = a + 1;
                                final byte b3 = q2[a];
                                final int n9 = n8 + 1;
                                final int k2 = this.k2(n5, b3, q2[n8], q2[n9]);
                                final int n10 = n3 + 1;
                                array2[n3] = (char)(0xD800 | k2 >> 10);
                                if (n10 >= array2.length) {
                                    array2 = super.K.p();
                                    n3 = 0;
                                }
                                else {
                                    n3 = n10;
                                }
                                n5 = ((k2 & 0x3FF) | 0xDC00);
                                a = n9 + 1;
                            }
                        }
                        else {
                            final byte[] q3 = this.q0;
                            final int n11 = a + 1;
                            n5 = this.j2(n5, q3[a], q3[n11]);
                            a = n11 + 1;
                        }
                    }
                    else {
                        n5 = this.i2(n5, this.q0[a]);
                        ++a;
                    }
                }
                else {
                    super.A = a;
                    n5 = this.d2();
                    a = super.A;
                }
                if (n3 >= array2.length) {
                    array2 = super.K.p();
                    n3 = n2;
                }
                final int n12 = n3 + 1;
                array2[n3] = (char)n5;
                i = a;
                array = array2;
                n = n12;
            }
        }
        super.A = i;
        super.i0 = 40;
        super.K.D(n);
        return super.c = JsonToken.NOT_AVAILABLE;
    }
    
    private JsonToken I2(int a0, int c0, int d0) throws IOException {
        int[] z = super.Z;
        final int[] j = com.fasterxml.jackson.core.io.a.j();
        while (true) {
            final int a2 = super.A;
            if (a2 >= super.B) {
                super.a0 = a0;
                super.c0 = c0;
                super.d0 = d0;
                super.i0 = 10;
                return super.c = JsonToken.NOT_AVAILABLE;
            }
            final int n = this.q0[a2] & 0xFF;
            if (j[n] != 0) {
                int[] s1 = z;
                int n2 = a0;
                if (d0 > 0) {
                    s1 = z;
                    if (a0 >= z.length) {
                        s1 = x2.b.s1(z, z.length);
                        super.Z = s1;
                    }
                    s1[a0] = c0;
                    n2 = a0 + 1;
                }
                String s2;
                if ((s2 = super.Y.F(s1, n2)) == null) {
                    s2 = this.C1(s1, n2, d0);
                }
                return this.L1(s2);
            }
            super.A = a2 + 1;
            if (d0 < 4) {
                ++d0;
                c0 = (c0 << 8 | n);
            }
            else {
                int[] s3 = z;
                if (a0 >= z.length) {
                    s3 = x2.b.s1(z, z.length);
                    super.Z = s3;
                }
                s3[a0] = c0;
                c0 = n;
                d0 = 1;
                ++a0;
                z = s3;
            }
        }
    }
    
    private JsonToken J2(final int n) throws IOException {
        if (n != 35) {
            if (n != 39) {
                if (n == 47) {
                    return this.a3(4);
                }
                if (n == 93) {
                    return this.E1();
                }
            }
            else if (this.E(Feature.ALLOW_SINGLE_QUOTES)) {
                return this.m2(0, 0, 0);
            }
        }
        else if (Feature.ALLOW_YAML_COMMENTS.enabledIn(super.a)) {
            return this.w2(4);
        }
        if (!this.E(Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            this.l0((char)n, "was expecting double-quote to start field name");
        }
        if (com.fasterxml.jackson.core.io.a.j()[n] != 0) {
            this.l0(n, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        return this.I2(0, n, 1);
    }
    
    private final JsonToken K2(int n, int n2, int n3) throws IOException {
        int[] z = super.Z;
        final int[] s0 = a.s0;
        while (true) {
            final int a = super.A;
            if (a >= super.B) {
                super.a0 = n;
                super.c0 = n2;
                super.d0 = n3;
                super.i0 = 7;
                return super.c = JsonToken.NOT_AVAILABLE;
            }
            final byte[] q0 = this.q0;
            super.A = a + 1;
            int c2 = q0[a] & 0xFF;
            int n4 = 0;
            Label_0163: {
                if (s0[c2] == 0) {
                    if (n3 >= 4) {
                        int[] s2 = z;
                        if (n >= z.length) {
                            s2 = x2.b.s1(z, z.length);
                            super.Z = s2;
                        }
                        n3 = n + 1;
                        s2[n] = n2;
                        n = n3;
                        n4 = c2;
                        z = s2;
                        break Label_0163;
                    }
                    n4 = c2;
                }
                else {
                    if (c2 == 34) {
                        if (n3 > 0) {
                            int[] s3 = z;
                            if (n >= z.length) {
                                s3 = x2.b.s1(z, z.length);
                                super.Z = s3;
                            }
                            s3[n] = b.R1(n2, n3);
                            n2 = n + 1;
                            z = s3;
                        }
                        else if ((n2 = n) == 0) {
                            return this.L1("");
                        }
                        String s4;
                        if ((s4 = super.Y.F(z, n2)) == null) {
                            s4 = this.C1(z, n2, n3);
                        }
                        return this.L1(s4);
                    }
                    if (c2 != 92) {
                        this.t0(c2, "name");
                    }
                    else if ((c2 = this.c2()) < 0) {
                        super.i0 = 8;
                        super.j0 = 7;
                        super.a0 = n;
                        super.c0 = n2;
                        super.d0 = n3;
                        return super.c = JsonToken.NOT_AVAILABLE;
                    }
                    int[] s5 = z;
                    if (n >= z.length) {
                        s5 = x2.b.s1(z, z.length);
                        super.Z = s5;
                    }
                    n4 = c2;
                    int n5 = n;
                    int n6 = n2;
                    int n7 = n3;
                    if (c2 > 127) {
                        final int n8 = 0;
                        int n9 = n;
                        int n10 = n2;
                        if ((n7 = n3) >= 4) {
                            s5[n] = n2;
                            n9 = n + 1;
                            n10 = 0;
                            n7 = 0;
                        }
                        if (c2 < 2048) {
                            n6 = (n10 << 8 | (c2 >> 6 | 0xC0));
                            ++n7;
                        }
                        else {
                            n2 = (n10 << 8 | (c2 >> 12 | 0xE0));
                            n = n7 + 1;
                            if (n >= 4) {
                                s5[n9] = n2;
                                ++n9;
                                n = 0;
                                n2 = n8;
                            }
                            n6 = (n2 << 8 | ((c2 >> 6 & 0x3F) | 0x80));
                            n7 = n + 1;
                        }
                        n = ((c2 & 0x3F) | 0x80);
                        n5 = n9;
                        n4 = n;
                    }
                    if (n7 >= 4) {
                        n = n5 + 1;
                        s5[n5] = n6;
                        z = s5;
                        break Label_0163;
                    }
                    z = s5;
                    n = n5;
                    n2 = n6;
                    n3 = n7;
                }
                ++n3;
                n2 = (n2 << 8 | n4);
                continue;
            }
            n3 = 1;
            n2 = n4;
        }
    }
    
    private final String L2(int a, int a2) throws IOException {
        final byte[] q0 = this.q0;
        final int[] s0 = a.s0;
        final int a3 = a + 1;
        a = (q0[a] & 0xFF);
        if (s0[a] == 0) {
            a2 = (a | a2 << 8);
            a = a3 + 1;
            final int n = q0[a3] & 0xFF;
            if (s0[n] == 0) {
                final int n2 = a2 << 8 | n;
                a2 = a + 1;
                a = (q0[a] & 0xFF);
                if (s0[a] == 0) {
                    a |= n2 << 8;
                    final int a4 = a2 + 1;
                    a2 = (q0[a2] & 0xFF);
                    if (s0[a2] == 0) {
                        return this.M2(a4, a2, a);
                    }
                    if (a2 == 34) {
                        super.A = a4;
                        return this.N1(super.b0, a, 4);
                    }
                    return null;
                }
                else {
                    if (a == 34) {
                        super.A = a2;
                        return this.N1(super.b0, n2, 3);
                    }
                    return null;
                }
            }
            else {
                if (n == 34) {
                    super.A = a;
                    return this.N1(super.b0, a2, 2);
                }
                return null;
            }
        }
        else {
            if (a == 34) {
                super.A = a3;
                return this.N1(super.b0, a2, 1);
            }
            return null;
        }
    }
    
    private final String M2(int a, int n, final int n2) throws IOException {
        final byte[] q0 = this.q0;
        final int[] s0 = a.s0;
        final int a2 = a + 1;
        a = (q0[a] & 0xFF);
        if (s0[a] != 0) {
            if (a == 34) {
                super.A = a2;
                return this.O1(super.b0, n2, n, 1);
            }
            return null;
        }
        else {
            n = (a | n << 8);
            a = a2 + 1;
            final int n3 = q0[a2] & 0xFF;
            if (s0[n3] != 0) {
                if (n3 == 34) {
                    super.A = a;
                    return this.O1(super.b0, n2, n, 2);
                }
                return null;
            }
            else {
                n = (n << 8 | n3);
                final int a3 = a + 1;
                a = (q0[a] & 0xFF);
                if (s0[a] != 0) {
                    if (a == 34) {
                        super.A = a3;
                        return this.O1(super.b0, n2, n, 3);
                    }
                    return null;
                }
                else {
                    if ((q0[a3] & 0xFF) == 0x22) {
                        super.A = a3 + 1;
                        return this.O1(super.b0, n2, n << 8 | a, 4);
                    }
                    return null;
                }
            }
        }
    }
    
    private final int O2(int a) throws IOException {
        int n;
        do {
            if (a != 32) {
                if (a == 10) {
                    ++super.D;
                    super.E = super.A;
                }
                else if (a == 13) {
                    ++super.n0;
                    super.E = super.A;
                }
                else if (a != 9) {
                    this.r0(a);
                }
            }
            a = super.A;
            if (a >= super.B) {
                super.c = JsonToken.NOT_AVAILABLE;
                return 0;
            }
            final byte[] q0 = this.q0;
            super.A = a + 1;
            n = (q0[a] & 0xFF);
        } while ((a = n) <= 32);
        return n;
    }
    
    private final JsonToken P2(final int i0) throws IOException {
        final int a = super.A;
        if (a >= super.B) {
            super.i0 = i0;
            return super.c = JsonToken.NOT_AVAILABLE;
        }
        final byte[] q0 = this.q0;
        super.A = a + 1;
        final int n = q0[a] & 0xFF;
        if (i0 == 4) {
            return this.T2(n);
        }
        if (i0 == 5) {
            return this.U2(n);
        }
        switch (i0) {
            default: {
                com.fasterxml.jackson.core.util.f.c();
                return null;
            }
            case 15: {
                return this.f3(n);
            }
            case 14: {
                return this.g3(n);
            }
            case 13: {
                return this.h3(n);
            }
            case 12: {
                return this.e3(n);
            }
        }
    }
    
    private final JsonToken R2(int i) throws IOException {
        final int n = i &= 0xFF;
        if (n == 239) {
            i = n;
            if (super.i0 != 1) {
                return this.o2(1);
            }
        }
        while (i <= 32) {
            if (i != 32) {
                if (i == 10) {
                    ++super.D;
                    super.E = super.A;
                }
                else if (i == 13) {
                    ++super.n0;
                    super.E = super.A;
                }
                else if (i != 9) {
                    this.r0(i);
                }
            }
            i = super.A;
            if (i >= super.B) {
                super.i0 = 3;
                if (super.z) {
                    return null;
                }
                if (super.k0) {
                    return this.K1();
                }
                return JsonToken.NOT_AVAILABLE;
            }
            else {
                final byte[] q0 = this.q0;
                super.A = i + 1;
                i = (q0[i] & 0xFF);
            }
        }
        return this.e3(i);
    }
    
    private final JsonToken T2(int o2) throws IOException {
        int n = o2;
        if (o2 <= 32) {
            o2 = this.O2(o2);
            if ((n = o2) <= 0) {
                super.i0 = 4;
                return super.c;
            }
        }
        this.Y1();
        if (n == 34) {
            if (super.A + 13 <= super.B) {
                final String l2 = this.l2();
                if (l2 != null) {
                    return this.L1(l2);
                }
            }
            return this.K2(0, 0, 0);
        }
        if (n == 125) {
            return this.F1();
        }
        return this.J2(n);
    }
    
    private final JsonToken U2(int n) throws IOException {
        int n2 = n;
        if (n <= 32) {
            n = this.O2(n);
            if ((n2 = n) <= 0) {
                super.i0 = 5;
                return super.c;
            }
        }
        if (n2 != 44) {
            if (n2 == 125) {
                return this.F1();
            }
            if (n2 == 35) {
                return this.w2(5);
            }
            if (n2 == 47) {
                return this.a3(5);
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("was expecting comma to separate ");
            sb.append(super.I.g());
            sb.append(" entries");
            this.l0(n2, sb.toString());
        }
        n = super.A;
        if (n >= super.B) {
            super.i0 = 4;
            return super.c = JsonToken.NOT_AVAILABLE;
        }
        final int n3 = this.q0[n];
        super.A = n + 1;
        if ((n = n3) <= 32 && (n = this.O2(n3)) <= 0) {
            super.i0 = 4;
            return super.c;
        }
        this.Y1();
        if (n == 34) {
            if (super.A + 13 <= super.B) {
                final String l2 = this.l2();
                if (l2 != null) {
                    return this.L1(l2);
                }
            }
            return this.K2(0, 0, 0);
        }
        if (n == 125 && Feature.ALLOW_TRAILING_COMMA.enabledIn(super.a)) {
            return this.F1();
        }
        return this.J2(n);
    }
    
    private final JsonToken a3(final int c0) throws IOException {
        if (!Feature.ALLOW_COMMENTS.enabledIn(super.a)) {
            this.l0(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        final int a = super.A;
        if (a >= super.B) {
            super.c0 = c0;
            super.i0 = 51;
            return super.c = JsonToken.NOT_AVAILABLE;
        }
        final byte[] q0 = this.q0;
        super.A = a + 1;
        final byte b = q0[a];
        if (b == 42) {
            return this.p2(c0, false);
        }
        if (b == 47) {
            return this.q2(c0);
        }
        this.l0(b & 0xFF, "was expecting either '*' or '/' for a comment");
        return null;
    }
    
    private final int c2() throws IOException {
        if (super.B - super.A < 5) {
            return this.e2(0, -1);
        }
        return this.d2();
    }
    
    private final int d2() throws IOException {
        final byte[] q0 = this.q0;
        final int a = super.A;
        final int a2 = a + 1;
        super.A = a2;
        final byte b = q0[a];
        if (b == 34 || b == 47 || b == 92) {
            return (char)b;
        }
        if (b == 98) {
            return 8;
        }
        if (b == 102) {
            return 12;
        }
        if (b == 110) {
            return 10;
        }
        if (b == 114) {
            return 13;
        }
        if (b == 116) {
            return 9;
        }
        if (b != 117) {
            return this.W((char)b);
        }
        super.A = a2 + 1;
        byte b2 = q0[a2];
        final int b3 = com.fasterxml.jackson.core.io.a.b(b2);
        if (b3 >= 0) {
            b2 = this.q0[super.A++];
            final int b4 = com.fasterxml.jackson.core.io.a.b(b2);
            if (b4 >= 0) {
                b2 = this.q0[super.A++];
                final int b5 = com.fasterxml.jackson.core.io.a.b(b2);
                if (b5 >= 0) {
                    b2 = this.q0[super.A++];
                    final int b6 = com.fasterxml.jackson.core.io.a.b(b2);
                    if (b6 >= 0) {
                        return ((b3 << 4 | b4) << 4 | b5) << 4 | b6;
                    }
                }
            }
        }
        this.l0(b2 & 0xFF, "expected a hex-digit for character escape sequence");
        return -1;
    }
    
    private int e2(int a, int b) throws IOException {
        final int a2 = super.A;
        final int b2 = super.B;
        if (a2 >= b2) {
            super.e0 = a;
            super.f0 = b;
            return -1;
        }
        final byte[] q0 = this.q0;
        final int a3 = a2 + 1;
        super.A = a3;
        byte b4;
        final byte b3 = b4 = q0[a2];
        int e0 = a;
        int f0;
        if ((f0 = b) == -1) {
            if (b3 == 34 || b3 == 47 || b3 == 92) {
                return b3;
            }
            if (b3 == 98) {
                return 8;
            }
            if (b3 == 102) {
                return 12;
            }
            if (b3 == 110) {
                return 10;
            }
            if (b3 == 114) {
                return 13;
            }
            if (b3 == 116) {
                return 9;
            }
            if (b3 != 117) {
                return this.W((char)b3);
            }
            if (a3 >= b2) {
                super.f0 = 0;
                super.e0 = 0;
                return -1;
            }
            super.A = a3 + 1;
            b4 = q0[a3];
            f0 = 0;
            e0 = a;
        }
        while (true) {
            a = (b4 & 0xFF);
            b = a.b(a);
            if (b < 0) {
                this.l0(a, "expected a hex-digit for character escape sequence");
            }
            e0 = (e0 << 4 | b);
            if (++f0 == 4) {
                return e0;
            }
            a = super.A;
            if (a >= super.B) {
                super.f0 = f0;
                super.e0 = e0;
                return -1;
            }
            final byte[] q2 = this.q0;
            super.A = a + 1;
            b4 = q2[a];
        }
    }
    
    private final JsonToken e3(int o2) throws IOException {
        int n = o2;
        if (o2 <= 32) {
            o2 = this.O2(o2);
            if ((n = o2) <= 0) {
                super.i0 = 12;
                return super.c;
            }
        }
        this.Y1();
        if (n == 34) {
            return this.b3();
        }
        if (n == 35) {
            return this.w2(12);
        }
        if (n == 45) {
            return this.W2();
        }
        if (n == 91) {
            return this.W1();
        }
        if (n == 93) {
            return this.E1();
        }
        if (n == 102) {
            return this.S2();
        }
        if (n == 110) {
            return this.X2();
        }
        if (n == 116) {
            return this.c3();
        }
        if (n == 123) {
            return this.X1();
        }
        if (n == 125) {
            return this.F1();
        }
        switch (n) {
            default: {
                return this.d3(false, n);
            }
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57: {
                return this.Z2(n);
            }
            case 48: {
                return this.Y2();
            }
            case 47: {
                return this.a3(12);
            }
        }
    }
    
    private final boolean f2(int n, int c0, final boolean b) throws IOException {
        if (c0 != 1) {
            if (c0 != 2) {
                if (c0 != 3) {
                    if (c0 != 4) {
                        if (n < 32) {
                            this.t0(n, "string value");
                        }
                        else {
                            this.S1(n);
                        }
                        super.K.a((char)n);
                        return true;
                    }
                    n &= 0x7;
                    if (b) {
                        final byte[] q0 = this.q0;
                        c0 = super.A++;
                        return this.h2(n, 1, q0[c0]);
                    }
                    super.c0 = n;
                    super.d0 = 1;
                    super.i0 = 44;
                    return false;
                }
                else {
                    c0 = (n & 0xF);
                    if (b) {
                        final byte[] q2 = this.q0;
                        n = super.A++;
                        return this.g2(c0, 1, q2[n]);
                    }
                    super.i0 = 43;
                    super.c0 = c0;
                    super.d0 = 1;
                    return false;
                }
            }
            else {
                if (b) {
                    final byte[] q3 = this.q0;
                    c0 = super.A++;
                    n = this.i2(n, q3[c0]);
                    super.K.a((char)n);
                    return true;
                }
                super.i0 = 42;
                super.c0 = n;
                return false;
            }
        }
        else {
            n = this.e2(0, -1);
            if (n < 0) {
                super.i0 = 41;
                return false;
            }
            super.K.a((char)n);
            return true;
        }
    }
    
    private final JsonToken f3(int o2) throws IOException {
        int n = o2;
        if (o2 <= 32) {
            o2 = this.O2(o2);
            if ((n = o2) <= 0) {
                super.i0 = 15;
                return super.c;
            }
        }
        this.Y1();
        if (n == 34) {
            return this.b3();
        }
        if (n == 35) {
            return this.w2(15);
        }
        if (n == 45) {
            return this.W2();
        }
        if (n != 91) {
            if (n != 93) {
                if (n == 102) {
                    return this.S2();
                }
                if (n == 110) {
                    return this.X2();
                }
                if (n == 116) {
                    return this.c3();
                }
                if (n == 123) {
                    return this.X1();
                }
                if (n != 125) {
                    switch (n) {
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57: {
                            return this.Z2(n);
                        }
                        case 48: {
                            return this.Y2();
                        }
                        case 47: {
                            return this.a3(15);
                        }
                    }
                }
                else if (this.E(Feature.ALLOW_TRAILING_COMMA)) {
                    return this.F1();
                }
            }
            else if (this.E(Feature.ALLOW_TRAILING_COMMA)) {
                return this.E1();
            }
            return this.d3(true, n);
        }
        return this.W1();
    }
    
    private final boolean g2(int a, final int n, final int n2) throws IOException {
        int c0 = a;
        int n3 = n2;
        if (n == 1) {
            if ((n2 & 0xC0) != 0x80) {
                this.V1(n2 & 0xFF, super.A);
            }
            c0 = (a << 6 | (n2 & 0x3F));
            a = super.A;
            if (a >= super.B) {
                super.i0 = 43;
                super.c0 = c0;
                super.d0 = 2;
                return false;
            }
            final byte[] q0 = this.q0;
            super.A = a + 1;
            n3 = q0[a];
        }
        if ((n3 & 0xC0) != 0x80) {
            this.V1(n3 & 0xFF, super.A);
        }
        super.K.a((char)(c0 << 6 | (n3 & 0x3F)));
        return true;
    }
    
    private final JsonToken g3(int n) throws IOException {
        int n2 = n;
        if (n <= 32) {
            n = this.O2(n);
            if ((n2 = n) <= 0) {
                super.i0 = 14;
                return super.c;
            }
        }
        if (n2 != 58) {
            if (n2 == 47) {
                return this.a3(14);
            }
            if (n2 == 35) {
                return this.w2(14);
            }
            this.l0(n2, "was expecting a colon to separate field name and value");
        }
        n = super.A;
        if (n >= super.B) {
            super.i0 = 12;
            return super.c = JsonToken.NOT_AVAILABLE;
        }
        final int n3 = this.q0[n];
        super.A = n + 1;
        if ((n = n3) <= 32 && (n = this.O2(n3)) <= 0) {
            super.i0 = 12;
            return super.c;
        }
        this.Y1();
        if (n == 34) {
            return this.b3();
        }
        if (n == 35) {
            return this.w2(12);
        }
        if (n == 45) {
            return this.W2();
        }
        if (n == 91) {
            return this.W1();
        }
        if (n == 102) {
            return this.S2();
        }
        if (n == 110) {
            return this.X2();
        }
        if (n == 116) {
            return this.c3();
        }
        if (n == 123) {
            return this.X1();
        }
        switch (n) {
            default: {
                return this.d3(false, n);
            }
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57: {
                return this.Z2(n);
            }
            case 48: {
                return this.Y2();
            }
            case 47: {
                return this.a3(12);
            }
        }
    }
    
    private final boolean h2(int n, int c0, final int n2) throws IOException {
        int c2 = n;
        int n3 = c0;
        int n4 = n2;
        if (c0 == 1) {
            if ((n2 & 0xC0) != 0x80) {
                this.V1(n2 & 0xFF, super.A);
            }
            c2 = (n << 6 | (n2 & 0x3F));
            n = super.A;
            if (n >= super.B) {
                super.i0 = 44;
                super.c0 = c2;
                super.d0 = 2;
                return false;
            }
            final byte[] q0 = this.q0;
            super.A = n + 1;
            n4 = q0[n];
            n3 = 2;
        }
        c0 = c2;
        n = n4;
        if (n3 == 2) {
            if ((n4 & 0xC0) != 0x80) {
                this.V1(n4 & 0xFF, super.A);
            }
            c0 = (c2 << 6 | (n4 & 0x3F));
            n = super.A;
            if (n >= super.B) {
                super.i0 = 44;
                super.c0 = c0;
                super.d0 = 3;
                return false;
            }
            final byte[] q2 = this.q0;
            super.A = n + 1;
            n = q2[n];
        }
        if ((n & 0xC0) != 0x80) {
            this.V1(n & 0xFF, super.A);
        }
        n = (c0 << 6 | (n & 0x3F)) - 65536;
        super.K.a((char)(0xD800 | n >> 10));
        super.K.a((char)((n & 0x3FF) | 0xDC00));
        return true;
    }
    
    private final JsonToken h3(int n) throws IOException {
        int n2 = n;
        if (n <= 32) {
            n = this.O2(n);
            if ((n2 = n) <= 0) {
                super.i0 = 13;
                return super.c;
            }
        }
        if (n2 != 44) {
            if (n2 == 93) {
                return this.E1();
            }
            if (n2 == 125) {
                return this.F1();
            }
            if (n2 == 47) {
                return this.a3(13);
            }
            if (n2 == 35) {
                return this.w2(13);
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("was expecting comma to separate ");
            sb.append(super.I.g());
            sb.append(" entries");
            this.l0(n2, sb.toString());
        }
        n = super.A;
        if (n >= super.B) {
            super.i0 = 15;
            return super.c = JsonToken.NOT_AVAILABLE;
        }
        final int n3 = this.q0[n];
        super.A = n + 1;
        if ((n = n3) <= 32 && (n = this.O2(n3)) <= 0) {
            super.i0 = 15;
            return super.c;
        }
        this.Y1();
        if (n == 34) {
            return this.b3();
        }
        if (n == 35) {
            return this.w2(15);
        }
        if (n == 45) {
            return this.W2();
        }
        if (n != 91) {
            if (n != 93) {
                if (n == 102) {
                    return this.S2();
                }
                if (n == 110) {
                    return this.X2();
                }
                if (n == 116) {
                    return this.c3();
                }
                if (n == 123) {
                    return this.X1();
                }
                if (n != 125) {
                    switch (n) {
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57: {
                            return this.Z2(n);
                        }
                        case 48: {
                            return this.Y2();
                        }
                        case 47: {
                            return this.a3(15);
                        }
                    }
                }
                else if (this.E(Feature.ALLOW_TRAILING_COMMA)) {
                    return this.F1();
                }
            }
            else if (this.E(Feature.ALLOW_TRAILING_COMMA)) {
                return this.E1();
            }
            return this.d3(true, n);
        }
        return this.W1();
    }
    
    private final int i2(final int n, final int n2) throws IOException {
        if ((n2 & 0xC0) != 0x80) {
            this.V1(n2 & 0xFF, super.A);
        }
        return (n & 0x1F) << 6 | (n2 & 0x3F);
    }
    
    private final int j2(final int n, final int n2, final int n3) throws IOException {
        if ((n2 & 0xC0) != 0x80) {
            this.V1(n2 & 0xFF, super.A);
        }
        if ((n3 & 0xC0) != 0x80) {
            this.V1(n3 & 0xFF, super.A);
        }
        return ((n & 0xF) << 6 | (n2 & 0x3F)) << 6 | (n3 & 0x3F);
    }
    
    private final int k2(final int n, final int n2, final int n3, final int n4) throws IOException {
        if ((n2 & 0xC0) != 0x80) {
            this.V1(n2 & 0xFF, super.A);
        }
        if ((n3 & 0xC0) != 0x80) {
            this.V1(n3 & 0xFF, super.A);
        }
        if ((n4 & 0xC0) != 0x80) {
            this.V1(n4 & 0xFF, super.A);
        }
        return ((((n & 0x7) << 6 | (n2 & 0x3F)) << 6 | (n3 & 0x3F)) << 6 | (n4 & 0x3F)) - 65536;
    }
    
    private final String l2() throws IOException {
        final byte[] q0 = this.q0;
        final int[] s0 = a.s0;
        final int a = super.A;
        final int a2 = a + 1;
        final int n = q0[a] & 0xFF;
        if (s0[n] == 0) {
            final int a3 = a2 + 1;
            final int n2 = q0[a2] & 0xFF;
            if (s0[n2] == 0) {
                final int n3 = n << 8 | n2;
                final int a4 = a3 + 1;
                final int n4 = q0[a3] & 0xFF;
                if (s0[n4] == 0) {
                    final int n5 = n3 << 8 | n4;
                    final int a5 = a4 + 1;
                    final int n6 = q0[a4] & 0xFF;
                    if (s0[n6] == 0) {
                        final int b0 = n5 << 8 | n6;
                        final int a6 = a5 + 1;
                        final int n7 = q0[a5] & 0xFF;
                        if (s0[n7] == 0) {
                            super.b0 = b0;
                            return this.L2(a6, n7);
                        }
                        if (n7 == 34) {
                            super.A = a6;
                            return this.M1(b0, 4);
                        }
                        return null;
                    }
                    else {
                        if (n6 == 34) {
                            super.A = a5;
                            return this.M1(n5, 3);
                        }
                        return null;
                    }
                }
                else {
                    if (n4 == 34) {
                        super.A = a4;
                        return this.M1(n3, 2);
                    }
                    return null;
                }
            }
            else {
                if (n2 == 34) {
                    super.A = a3;
                    return this.M1(n, 1);
                }
                return null;
            }
        }
        else {
            if (n == 34) {
                super.A = a2;
                return "";
            }
            return null;
        }
    }
    
    private JsonToken m2(int n, int n2, int n3) throws IOException {
        int[] z = super.Z;
        final int[] s0 = a.s0;
        while (true) {
            final int a = super.A;
            if (a >= super.B) {
                super.a0 = n;
                super.c0 = n2;
                super.d0 = n3;
                super.i0 = 9;
                return super.c = JsonToken.NOT_AVAILABLE;
            }
            final byte[] q0 = this.q0;
            super.A = a + 1;
            int c2 = q0[a] & 0xFF;
            if (c2 == 39) {
                if (n3 > 0) {
                    int[] s2 = z;
                    if (n >= z.length) {
                        s2 = x2.b.s1(z, z.length);
                        super.Z = s2;
                    }
                    s2[n] = b.R1(n2, n3);
                    n2 = n + 1;
                    z = s2;
                }
                else if ((n2 = n) == 0) {
                    return this.L1("");
                }
                String s3;
                if ((s3 = super.Y.F(z, n2)) == null) {
                    s3 = this.C1(z, n2, n3);
                }
                return this.L1(s3);
            }
            int[] s4 = z;
            int n4 = c2;
            int n5 = n;
            int n6 = n2;
            int n7 = n3;
            if (c2 != 34) {
                s4 = z;
                n4 = c2;
                n5 = n;
                n6 = n2;
                n7 = n3;
                if (s0[c2] != 0) {
                    if (c2 != 92) {
                        this.t0(c2, "name");
                    }
                    else if ((c2 = this.c2()) < 0) {
                        super.i0 = 8;
                        super.j0 = 9;
                        super.a0 = n;
                        super.c0 = n2;
                        super.d0 = n3;
                        return super.c = JsonToken.NOT_AVAILABLE;
                    }
                    s4 = z;
                    n4 = c2;
                    n5 = n;
                    n6 = n2;
                    n7 = n3;
                    if (c2 > 127) {
                        final int n8 = 0;
                        s4 = z;
                        int n9 = n;
                        int n10 = n2;
                        int n11;
                        if ((n11 = n3) >= 4) {
                            s4 = z;
                            if (n >= z.length) {
                                s4 = x2.b.s1(z, z.length);
                                super.Z = s4;
                            }
                            s4[n] = n2;
                            n9 = n + 1;
                            n10 = 0;
                            n11 = 0;
                        }
                        if (c2 < 2048) {
                            n = (n10 << 8 | (c2 >> 6 | 0xC0));
                            n2 = n11 + 1;
                        }
                        else {
                            n2 = (n10 << 8 | (c2 >> 12 | 0xE0));
                            n = n11 + 1;
                            int[] s5;
                            if (n >= 4) {
                                s5 = s4;
                                if (n9 >= s4.length) {
                                    s5 = x2.b.s1(s4, s4.length);
                                    super.Z = s5;
                                }
                                s5[n9] = n2;
                                ++n9;
                                n = 0;
                                n2 = n8;
                            }
                            else {
                                s5 = s4;
                            }
                            n3 = (n2 << 8 | ((c2 >> 6 & 0x3F) | 0x80));
                            n2 = n + 1;
                            n = n3;
                            s4 = s5;
                        }
                        n3 = ((c2 & 0x3F) | 0x80);
                        n7 = n2;
                        n6 = n;
                        n5 = n9;
                        n4 = n3;
                    }
                }
            }
            if (n7 < 4) {
                n3 = n7 + 1;
                n2 = (n6 << 8 | n4);
                z = s4;
                n = n5;
            }
            else {
                z = s4;
                if (n5 >= s4.length) {
                    z = x2.b.s1(s4, s4.length);
                    super.Z = z;
                }
                z[n5] = n6;
                n = n5 + 1;
                n2 = n4;
                n3 = 1;
            }
        }
    }
    
    private final JsonToken n2() throws IOException {
        final int[] r0 = a.r0;
        final byte[] q0 = this.q0;
        char[] array = super.K.q();
        int n = super.K.s();
        int i = super.A;
        final int b = super.B;
    Label_0039:
        while (i < super.B) {
            final int length = array.length;
            final int n2 = 0;
            boolean b2 = false;
            char[] array2 = array;
            int n3;
            if ((n3 = n) >= length) {
                array2 = super.K.p();
                n3 = 0;
            }
            final int min = Math.min(super.B, array2.length - n3 + i);
            int n4 = i;
            int a = 0;
            Block_16: {
                int n5;
                while (true) {
                    array = array2;
                    n = n3;
                    i = n4;
                    if (n4 >= min) {
                        continue Label_0039;
                    }
                    a = n4 + 1;
                    n5 = (q0[n4] & 0xFF);
                    if (r0[n5] != 0 && n5 != 34) {
                        break;
                    }
                    if (n5 == 39) {
                        break Block_16;
                    }
                    array2[n3] = (char)n5;
                    ++n3;
                    n4 = a;
                }
                if (a < b - 5) {
                    final int n6 = r0[n5];
                    if (n6 != 1) {
                        if (n6 != 2) {
                            if (n6 != 3) {
                                if (n6 != 4) {
                                    if (n5 < 32) {
                                        this.t0(n5, "string value");
                                    }
                                    else {
                                        this.S1(n5);
                                    }
                                }
                                else {
                                    final byte[] q2 = this.q0;
                                    final int n7 = a + 1;
                                    final byte b3 = q2[a];
                                    final int n8 = n7 + 1;
                                    final int k2 = this.k2(n5, b3, q2[n7], q2[n8]);
                                    final int n9 = n3 + 1;
                                    array2[n3] = (char)(0xD800 | k2 >> 10);
                                    if (n9 >= array2.length) {
                                        array2 = super.K.p();
                                        n3 = 0;
                                    }
                                    else {
                                        n3 = n9;
                                    }
                                    n5 = ((k2 & 0x3FF) | 0xDC00);
                                    a = n8 + 1;
                                }
                            }
                            else {
                                final byte[] q3 = this.q0;
                                final int n10 = a + 1;
                                n5 = this.j2(n5, q3[a], q3[n10]);
                                a = n10 + 1;
                            }
                        }
                        else {
                            n5 = this.i2(n5, this.q0[a]);
                            ++a;
                        }
                    }
                    else {
                        super.A = a;
                        n5 = this.d2();
                        a = super.A;
                    }
                    if (n3 >= array2.length) {
                        array = super.K.p();
                        n3 = n2;
                    }
                    else {
                        array = array2;
                    }
                    final int n11 = n3 + 1;
                    array[n3] = (char)n5;
                    i = a;
                    n = n11;
                    continue;
                }
                super.A = a;
                super.K.D(n3);
                final int n12 = r0[n5];
                if (a < super.B) {
                    b2 = true;
                }
                if (!this.f2(n5, n12, b2)) {
                    super.j0 = 45;
                    return super.c = JsonToken.NOT_AVAILABLE;
                }
                array = super.K.q();
                n = super.K.s();
                i = super.A;
                continue;
            }
            super.A = a;
            super.K.D(n3);
            return this.Z1(JsonToken.VALUE_STRING);
        }
        super.A = i;
        super.i0 = 45;
        super.K.D(n);
        return super.c = JsonToken.NOT_AVAILABLE;
    }
    
    private final JsonToken o2(int c0) throws IOException {
        while (true) {
            final int a = super.A;
            if (a >= super.B) {
                super.c0 = c0;
                super.i0 = 1;
                return super.c = JsonToken.NOT_AVAILABLE;
            }
            final byte[] q0 = this.q0;
            super.A = a + 1;
            final int n = q0[a] & 0xFF;
            if (c0 != 1) {
                if (c0 != 2) {
                    if (c0 == 3) {
                        super.C -= 3L;
                        return this.R2(n);
                    }
                }
                else if (n != 191) {
                    this.a0("Unexpected byte 0x%02x following 0xEF 0xBB; should get 0xBF as third byte of UTF-8 BOM", n);
                }
            }
            else if (n != 187) {
                this.a0("Unexpected byte 0x%02x following 0xEF; should get 0xBB as second byte UTF-8 BOM", n);
            }
            ++c0;
        }
    }
    
    private final JsonToken p2(final int c0, boolean b) throws IOException {
        while (true) {
            final int a = super.A;
            if (a >= super.B) {
                int i0;
                if (b) {
                    i0 = 52;
                }
                else {
                    i0 = 53;
                }
                super.i0 = i0;
                super.c0 = c0;
                return super.c = JsonToken.NOT_AVAILABLE;
            }
            final byte[] q0 = this.q0;
            final int e = a + 1;
            super.A = e;
            final int n = q0[a] & 0xFF;
            if (n < 32) {
                if (n == 10) {
                    ++super.D;
                    super.E = e;
                }
                else if (n == 13) {
                    ++super.n0;
                    super.E = e;
                }
                else if (n != 9) {
                    this.r0(n);
                }
            }
            else {
                if (n == 42) {
                    b = true;
                    continue;
                }
                if (n == 47 && b) {
                    return this.P2(c0);
                }
            }
            b = false;
        }
    }
    
    private final JsonToken q2(final int c0) throws IOException {
        while (true) {
            final int a = super.A;
            if (a >= super.B) {
                super.i0 = 54;
                super.c0 = c0;
                return super.c = JsonToken.NOT_AVAILABLE;
            }
            final byte[] q0 = this.q0;
            final int e = a + 1;
            super.A = e;
            final int n = q0[a] & 0xFF;
            if (n >= 32) {
                continue;
            }
            if (n == 10) {
                ++super.D;
                super.E = e;
                break;
            }
            if (n == 13) {
                ++super.n0;
                super.E = e;
                break;
            }
            if (n == 9) {
                continue;
            }
            this.r0(n);
        }
        return this.P2(c0);
    }
    
    private final JsonToken w2(final int c0) throws IOException {
        if (!Feature.ALLOW_YAML_COMMENTS.enabledIn(super.a)) {
            this.l0(35, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_YAML_COMMENTS' not enabled for parser)");
        }
        while (true) {
            final int a = super.A;
            if (a >= super.B) {
                super.i0 = 55;
                super.c0 = c0;
                return super.c = JsonToken.NOT_AVAILABLE;
            }
            final byte[] q0 = this.q0;
            final int e = a + 1;
            super.A = e;
            final int n = q0[a] & 0xFF;
            if (n >= 32) {
                continue;
            }
            if (n == 10) {
                ++super.D;
                super.E = e;
                break;
            }
            if (n == 13) {
                ++super.n0;
                super.E = e;
                break;
            }
            if (n == 9) {
                continue;
            }
            this.r0(n);
        }
        return this.P2(c0);
    }
    
    protected JsonToken A2(final int n, final int n2) throws IOException {
        final String q1 = this.Q1(n);
        if (n2 == q1.length()) {
            return this.b2(n);
        }
        super.K.w(q1, 0, n2);
        return this.s2();
    }
    
    protected JsonToken B2(char[] array, int n) throws IOException {
        int n2;
        if (super.U) {
            n2 = -1;
        }
        else {
            n2 = 0;
        }
        while (true) {
            final int a = super.A;
            if (a >= super.B) {
                super.i0 = 26;
                super.K.D(n);
                return super.c = JsonToken.NOT_AVAILABLE;
            }
            final int n3 = this.q0[a] & 0xFF;
            if (n3 < 48) {
                if (n3 == 46) {
                    super.V = n2 + n;
                    super.A = a + 1;
                    return this.V2(array, n, n3);
                }
                break;
            }
            else if (n3 > 57) {
                if (n3 != 101 && n3 != 69) {
                    break;
                }
                super.V = n2 + n;
                super.A = a + 1;
                return this.V2(array, n, n3);
            }
            else {
                super.A = a + 1;
                char[] o = array;
                if (n >= array.length) {
                    o = super.K.o();
                }
                o[n] = (char)n3;
                ++n;
                array = o;
            }
        }
        super.V = n2 + n;
        super.K.D(n);
        return this.Z1(JsonToken.VALUE_NUMBER_INT);
    }
    
    protected JsonToken C2() throws IOException {
        while (true) {
            final int a = super.A;
            if (a >= super.B) {
                super.i0 = 25;
                return super.c = JsonToken.NOT_AVAILABLE;
            }
            final byte[] q0 = this.q0;
            super.A = a + 1;
            final int n = q0[a] & 0xFF;
            if (n < 48) {
                if (n == 46) {
                    final char[] m = super.K.m();
                    m[0] = '-';
                    m[1] = '0';
                    super.V = 1;
                    return this.V2(m, 2, n);
                }
                break;
            }
            else if (n > 57) {
                if (n == 101 || n == 69) {
                    final char[] i = super.K.m();
                    i[0] = '-';
                    i[1] = '0';
                    super.V = 1;
                    return this.V2(i, 2, n);
                }
                if (n != 93 && n != 125) {
                    this.G0(n, "expected digit (0-9), decimal point (.) or exponent indicator (e/E) to follow '0'");
                    break;
                }
                break;
            }
            else {
                if (!this.E(Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
                    this.B0("Leading zeroes not allowed");
                }
                if (n == 48) {
                    continue;
                }
                final char[] j = super.K.m();
                j[0] = '-';
                j[1] = (char)n;
                super.V = 1;
                return this.B2(j, 2);
            }
        }
        --super.A;
        return this.a2(0, "0");
    }
    
    protected JsonToken D2() throws IOException {
        while (true) {
            final int a = super.A;
            if (a >= super.B) {
                super.i0 = 24;
                return super.c = JsonToken.NOT_AVAILABLE;
            }
            final byte[] q0 = this.q0;
            super.A = a + 1;
            final int n = q0[a] & 0xFF;
            if (n < 48) {
                if (n == 46) {
                    final char[] m = super.K.m();
                    m[0] = '0';
                    super.V = 1;
                    return this.V2(m, 1, n);
                }
                break;
            }
            else if (n > 57) {
                if (n == 101 || n == 69) {
                    final char[] i = super.K.m();
                    i[0] = '0';
                    super.V = 1;
                    return this.V2(i, 1, n);
                }
                if (n != 93 && n != 125) {
                    this.G0(n, "expected digit (0-9), decimal point (.) or exponent indicator (e/E) to follow '0'");
                    break;
                }
                break;
            }
            else {
                if (!this.E(Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
                    this.B0("Leading zeroes not allowed");
                }
                if (n == 48) {
                    continue;
                }
                final char[] j = super.K.m();
                j[0] = (char)n;
                super.V = 1;
                return this.B2(j, 1);
            }
        }
        --super.A;
        return this.a2(0, "0");
    }
    
    protected JsonToken E2(final int n) throws IOException {
        if (n <= 48) {
            if (n == 48) {
                return this.C2();
            }
            this.G0(n, "expected digit (0-9) to follow minus sign, for valid numeric value");
        }
        else if (n > 57) {
            if (n == 73) {
                return this.z2(3, 2);
            }
            this.G0(n, "expected digit (0-9) to follow minus sign, for valid numeric value");
        }
        final char[] m = super.K.m();
        m[0] = '-';
        m[1] = (char)n;
        super.V = 1;
        return this.B2(m, 2);
    }
    
    @Override
    public JsonToken F() throws IOException {
        final int a = super.A;
        if (a >= super.B) {
            if (super.z) {
                return null;
            }
            if (!super.k0) {
                return JsonToken.NOT_AVAILABLE;
            }
            if (super.c == JsonToken.NOT_AVAILABLE) {
                return this.H2();
            }
            return this.K1();
        }
        else {
            if (super.c == JsonToken.NOT_AVAILABLE) {
                return this.G2();
            }
            super.O = 0;
            super.F = super.C + a;
            super.N = null;
            final byte[] q0 = this.q0;
            super.A = a + 1;
            final int n = q0[a] & 0xFF;
            switch (super.g0) {
                default: {
                    com.fasterxml.jackson.core.util.f.c();
                    return null;
                }
                case 6: {
                    return this.h3(n);
                }
                case 5: {
                    return this.e3(n);
                }
                case 4: {
                    return this.g3(n);
                }
                case 3: {
                    return this.U2(n);
                }
                case 2: {
                    return this.T2(n);
                }
                case 1: {
                    return this.e3(n);
                }
                case 0: {
                    return this.R2(n);
                }
            }
        }
    }
    
    protected final JsonToken G2() throws IOException {
        final int i0 = super.i0;
        if (i0 == 1) {
            return this.o2(super.c0);
        }
        if (i0 == 4) {
            return this.T2(this.q0[super.A++] & 0xFF);
        }
        if (i0 == 5) {
            return this.U2(this.q0[super.A++] & 0xFF);
        }
        switch (i0) {
            default: {
                switch (i0) {
                    default: {
                        switch (i0) {
                            default: {
                                switch (i0) {
                                    default: {
                                        switch (i0) {
                                            default: {
                                                switch (i0) {
                                                    default: {
                                                        com.fasterxml.jackson.core.util.f.c();
                                                        return null;
                                                    }
                                                    case 55: {
                                                        return this.w2(super.c0);
                                                    }
                                                    case 54: {
                                                        return this.q2(super.c0);
                                                    }
                                                    case 53: {
                                                        return this.p2(super.c0, false);
                                                    }
                                                    case 52: {
                                                        return this.p2(super.c0, true);
                                                    }
                                                    case 51: {
                                                        return this.a3(super.c0);
                                                    }
                                                    case 50: {
                                                        return this.r2();
                                                    }
                                                }
                                                break;
                                            }
                                            case 45: {
                                                return this.n2();
                                            }
                                            case 44: {
                                                if (!this.h2(super.c0, super.d0, this.q0[super.A++])) {
                                                    return JsonToken.NOT_AVAILABLE;
                                                }
                                                if (super.j0 == 45) {
                                                    return this.n2();
                                                }
                                                return this.F2();
                                            }
                                            case 43: {
                                                if (!this.g2(super.c0, super.d0, this.q0[super.A++])) {
                                                    return JsonToken.NOT_AVAILABLE;
                                                }
                                                if (super.j0 == 45) {
                                                    return this.n2();
                                                }
                                                return this.F2();
                                            }
                                            case 42: {
                                                super.K.a((char)this.i2(super.c0, this.q0[super.A++]));
                                                if (super.j0 == 45) {
                                                    return this.n2();
                                                }
                                                return this.F2();
                                            }
                                            case 41: {
                                                final int e2 = this.e2(super.e0, super.f0);
                                                if (e2 < 0) {
                                                    return JsonToken.NOT_AVAILABLE;
                                                }
                                                super.K.a((char)e2);
                                                if (super.j0 == 45) {
                                                    return this.n2();
                                                }
                                                return this.F2();
                                            }
                                            case 40: {
                                                return this.F2();
                                            }
                                        }
                                        break;
                                    }
                                    case 32: {
                                        return this.u2(false, this.q0[super.A++] & 0xFF);
                                    }
                                    case 31: {
                                        return this.u2(true, this.q0[super.A++] & 0xFF);
                                    }
                                    case 30: {
                                        return this.v2();
                                    }
                                }
                                break;
                            }
                            case 26: {
                                return this.B2(super.K.q(), super.K.s());
                            }
                            case 25: {
                                return this.C2();
                            }
                            case 24: {
                                return this.D2();
                            }
                            case 23: {
                                return this.E2(this.q0[super.A++] & 0xFF);
                            }
                        }
                        break;
                    }
                    case 19: {
                        return this.z2(super.l0, super.c0);
                    }
                    case 18: {
                        return this.x2("false", super.c0, JsonToken.VALUE_FALSE);
                    }
                    case 17: {
                        return this.x2("true", super.c0, JsonToken.VALUE_TRUE);
                    }
                    case 16: {
                        return this.x2("null", super.c0, JsonToken.VALUE_NULL);
                    }
                    case 15: {
                        return this.f3(this.q0[super.A++] & 0xFF);
                    }
                    case 14: {
                        return this.g3(this.q0[super.A++] & 0xFF);
                    }
                    case 13: {
                        return this.h3(this.q0[super.A++] & 0xFF);
                    }
                    case 12: {
                        return this.e3(this.q0[super.A++] & 0xFF);
                    }
                }
                break;
            }
            case 10: {
                return this.I2(super.a0, super.c0, super.d0);
            }
            case 9: {
                return this.m2(super.a0, super.c0, super.d0);
            }
            case 8: {
                return this.t2();
            }
            case 7: {
                return this.K2(super.a0, super.c0, super.d0);
            }
        }
    }
    
    protected final JsonToken H2() throws IOException {
        final JsonToken c = super.c;
        final int i0 = super.i0;
        if (i0 == 3) {
            return this.K1();
        }
        if (i0 == 12) {
            return this.K1();
        }
        if (i0 == 50) {
            return this.s2();
        }
        switch (i0) {
            default: {
                switch (i0) {
                    default: {
                        Label_0206: {
                            switch (i0) {
                                default: {
                                    switch (i0) {
                                        default: {
                                            final StringBuilder sb = new StringBuilder();
                                            sb.append(": was expecting rest of token (internal state: ");
                                            sb.append(super.i0);
                                            sb.append(")");
                                            this.f0(sb.toString(), super.c);
                                            return c;
                                        }
                                        case 52:
                                        case 53: {
                                            break Label_0206;
                                        }
                                        case 54:
                                        case 55: {
                                            return this.K1();
                                        }
                                    }
                                    break;
                                }
                                case 31: {
                                    this.f0(": was expecting fraction after exponent marker", JsonToken.VALUE_NUMBER_FLOAT);
                                    break;
                                }
                                case 30: {
                                    super.X = 0;
                                }
                                case 32: {
                                    return this.Z1(JsonToken.VALUE_NUMBER_FLOAT);
                                }
                            }
                        }
                        this.f0(": was expecting closing '*/' for comment", JsonToken.NOT_AVAILABLE);
                        return this.K1();
                    }
                    case 26: {
                        int s = super.K.s();
                        if (super.U) {
                            --s;
                        }
                        super.V = s;
                        return this.Z1(JsonToken.VALUE_NUMBER_INT);
                    }
                    case 24:
                    case 25: {
                        return this.a2(0, "0");
                    }
                }
                break;
            }
            case 19: {
                return this.A2(super.l0, super.c0);
            }
            case 18: {
                return this.y2("false", super.c0, JsonToken.VALUE_FALSE);
            }
            case 17: {
                return this.y2("true", super.c0, JsonToken.VALUE_TRUE);
            }
            case 16: {
                return this.y2("null", super.c0, JsonToken.VALUE_NULL);
            }
        }
    }
    
    protected JsonToken N2(final String s) throws IOException {
        this.c0("Unrecognized token '%s': was expecting %s", super.K.l(), "'null', 'true' or 'false'");
        return JsonToken.NOT_AVAILABLE;
    }
    
    protected JsonToken Q2() throws IOException {
        int i = super.A;
        final char[] m = super.K.m();
        final int[] r0 = a.r0;
        final int min = Math.min(super.B, m.length + i);
        final byte[] q0 = this.q0;
        int n;
        int n2;
        for (n = 0; i < min; ++i, m[n] = (char)n2, ++n) {
            n2 = (q0[i] & 0xFF);
            if (n2 == 39) {
                super.A = i + 1;
                super.K.D(n);
                return this.Z1(JsonToken.VALUE_STRING);
            }
            if (r0[n2] != 0) {
                break;
            }
        }
        super.K.D(n);
        super.A = i;
        return this.n2();
    }
    
    protected JsonToken S2() throws IOException {
        final int a = super.A;
        if (a + 4 < super.B) {
            final byte[] q0 = this.q0;
            final int n = a + 1;
            if (q0[a] == 97) {
                final int n2 = n + 1;
                if (q0[n] == 108) {
                    final int n3 = n2 + 1;
                    if (q0[n2] == 115) {
                        final int a2 = n3 + 1;
                        if (q0[n3] == 101) {
                            final int n4 = q0[a2] & 0xFF;
                            if (n4 < 48 || n4 == 93 || n4 == 125) {
                                super.A = a2;
                                return this.Z1(JsonToken.VALUE_FALSE);
                            }
                        }
                    }
                }
            }
        }
        super.i0 = 18;
        return this.x2("false", 1, JsonToken.VALUE_FALSE);
    }
    
    protected JsonToken V2(char[] array, int n, int a) throws IOException {
        final int n2 = 0;
        final int n3 = 0;
        final int n4 = 0;
        int n6;
        char[] array2;
        int w2;
        if (a == 46) {
            char[] o = array;
            if (n >= array.length) {
                o = super.K.o();
            }
            o[n] = '.';
            a = n + 1;
            int w = 0;
            array = o;
            while (true) {
                n = super.A;
                if (n >= super.B) {
                    super.K.D(a);
                    super.i0 = 30;
                    super.W = w;
                    return super.c = JsonToken.NOT_AVAILABLE;
                }
                final byte[] q0 = this.q0;
                super.A = n + 1;
                n = q0[n];
                if (n >= 48 && n <= 57) {
                    char[] o2 = array;
                    if (a >= array.length) {
                        o2 = super.K.o();
                    }
                    o2[a] = (char)n;
                    ++w;
                    ++a;
                    array = o2;
                }
                else {
                    final int n5 = n6 = (n & 0xFF);
                    array2 = array;
                    n = a;
                    if ((w2 = w) == 0) {
                        this.G0(n5, "Decimal point not followed by a digit");
                        n6 = n5;
                        array2 = array;
                        n = a;
                        w2 = w;
                        break;
                    }
                    break;
                }
            }
        }
        else {
            w2 = 0;
            array2 = array;
            n6 = a;
        }
        super.W = w2;
        int n7 = 0;
        Label_0602: {
            if (n6 != 101) {
                a = n3;
                n7 = n;
                if (n6 != 69) {
                    break Label_0602;
                }
            }
            array = array2;
            if (n >= array2.length) {
                array = super.K.o();
            }
            final int n8 = n + 1;
            array[n] = (char)n6;
            n = super.A;
            if (n >= super.B) {
                super.K.D(n8);
                super.i0 = 31;
                super.X = 0;
                return super.c = JsonToken.NOT_AVAILABLE;
            }
            final byte[] q2 = this.q0;
            super.A = n + 1;
            final byte b = q2[n];
            while (true) {
                char[] array3 = null;
                byte b2 = 0;
                Label_0467: {
                    if (b != 45) {
                        a = n2;
                        array3 = array;
                        b2 = b;
                        n = n8;
                        if (b != 43) {
                            break Label_0467;
                        }
                    }
                    char[] o3 = array;
                    if (n8 >= array.length) {
                        o3 = super.K.o();
                    }
                    n = n8 + 1;
                    o3[n8] = (char)b;
                    a = super.A;
                    if (a >= super.B) {
                        super.K.D(n);
                        super.i0 = 32;
                        super.X = 0;
                        return super.c = JsonToken.NOT_AVAILABLE;
                    }
                    final byte[] q3 = this.q0;
                    super.A = a + 1;
                    b2 = q3[a];
                    array = o3;
                    a = n4;
                    array3 = array;
                }
                if (b2 >= 48 && b2 <= 57) {
                    ++a;
                    array = array3;
                    if (n >= array3.length) {
                        array = super.K.o();
                    }
                    final int n9 = n + 1;
                    array[n] = (char)b2;
                    n = super.A;
                    if (n >= super.B) {
                        super.K.D(n9);
                        super.i0 = 32;
                        super.X = a;
                        return super.c = JsonToken.NOT_AVAILABLE;
                    }
                    final byte[] q4 = this.q0;
                    super.A = n + 1;
                    b2 = q4[n];
                    n = n9;
                    continue;
                }
                else {
                    if (a == 0) {
                        this.G0(b2 & 0xFF, "Exponent indicator not followed by a digit");
                    }
                    n7 = n;
                }
                break;
            }
        }
        --super.A;
        super.K.D(n7);
        super.X = a;
        return this.Z1(JsonToken.VALUE_NUMBER_FLOAT);
    }
    
    protected JsonToken W2() throws IOException {
        super.U = true;
        final int a = super.A;
        if (a >= super.B) {
            super.i0 = 23;
            return super.c = JsonToken.NOT_AVAILABLE;
        }
        final byte[] q0 = this.q0;
        super.A = a + 1;
        final int n = q0[a] & 0xFF;
        int n2 = 2;
        if (n <= 48) {
            if (n == 48) {
                return this.C2();
            }
            this.G0(n, "expected digit (0-9) to follow minus sign, for valid numeric value");
        }
        else if (n > 57) {
            if (n == 73) {
                return this.z2(3, 2);
            }
            this.G0(n, "expected digit (0-9) to follow minus sign, for valid numeric value");
        }
        char[] m = super.K.m();
        m[0] = '-';
        m[1] = (char)n;
        final int a2 = super.A;
        if (a2 >= super.B) {
            super.i0 = 26;
            super.K.D(2);
            super.V = 1;
            return super.c = JsonToken.NOT_AVAILABLE;
        }
        int i = this.q0[a2];
        while (true) {
            while (i >= 48) {
                if (i > 57) {
                    if (i != 101 && i != 69) {
                        super.V = n2 - 1;
                        super.K.D(n2);
                        return this.Z1(JsonToken.VALUE_NUMBER_INT);
                    }
                    super.V = n2 - 1;
                    ++super.A;
                    return this.V2(m, n2, i);
                }
                else {
                    char[] o = m;
                    if (n2 >= m.length) {
                        o = super.K.o();
                    }
                    final int n3 = n2 + 1;
                    o[n2] = (char)i;
                    final int a3 = super.A + 1;
                    if ((super.A = a3) >= super.B) {
                        super.i0 = 26;
                        super.K.D(n3);
                        return super.c = JsonToken.NOT_AVAILABLE;
                    }
                    i = (this.q0[a3] & 0xFF);
                    n2 = n3;
                    m = o;
                }
            }
            if (i == 46) {
                super.V = n2 - 1;
                ++super.A;
                return this.V2(m, n2, i);
            }
            continue;
        }
    }
    
    protected JsonToken X2() throws IOException {
        final int a = super.A;
        if (a + 3 < super.B) {
            final byte[] q0 = this.q0;
            final int n = a + 1;
            if (q0[a] == 117) {
                final int n2 = n + 1;
                if (q0[n] == 108) {
                    final int a2 = n2 + 1;
                    if (q0[n2] == 108) {
                        final int n3 = q0[a2] & 0xFF;
                        if (n3 < 48 || n3 == 93 || n3 == 125) {
                            super.A = a2;
                            return this.Z1(JsonToken.VALUE_NULL);
                        }
                    }
                }
            }
        }
        super.i0 = 16;
        return this.x2("null", 1, JsonToken.VALUE_NULL);
    }
    
    protected JsonToken Y2() throws IOException {
        final int a = super.A;
        if (a >= super.B) {
            super.i0 = 24;
            return super.c = JsonToken.NOT_AVAILABLE;
        }
        final byte[] q0 = this.q0;
        final int n = a + 1;
        final int n2 = q0[a] & 0xFF;
        if (n2 < 48) {
            if (n2 == 46) {
                super.A = n;
                super.V = 1;
                final char[] m = super.K.m();
                m[0] = '0';
                return this.V2(m, 1, n2);
            }
        }
        else {
            if (n2 <= 57) {
                return this.D2();
            }
            if (n2 == 101 || n2 == 69) {
                super.A = n;
                super.V = 1;
                final char[] i = super.K.m();
                i[0] = '0';
                return this.V2(i, 1, n2);
            }
            if (n2 != 93 && n2 != 125) {
                this.G0(n2, "expected digit (0-9), decimal point (.) or exponent indicator (e/E) to follow '0'");
            }
        }
        return this.a2(0, "0");
    }
    
    protected JsonToken Z2(int a) throws IOException {
        super.U = false;
        char[] m = super.K.m();
        m[0] = (char)a;
        a = super.A;
        if (a >= super.B) {
            super.i0 = 26;
            super.K.D(1);
            return super.c = JsonToken.NOT_AVAILABLE;
        }
        int i = this.q0[a] & 0xFF;
        a = 1;
        while (true) {
            while (i >= 48) {
                if (i > 57) {
                    if (i != 101 && i != 69) {
                        super.V = a;
                        super.K.D(a);
                        return this.Z1(JsonToken.VALUE_NUMBER_INT);
                    }
                    super.V = a;
                    ++super.A;
                    return this.V2(m, a, i);
                }
                else {
                    char[] o = m;
                    if (a >= m.length) {
                        o = super.K.o();
                    }
                    final int n = a + 1;
                    o[a] = (char)i;
                    a = super.A + 1;
                    if ((super.A = a) >= super.B) {
                        super.i0 = 26;
                        super.K.D(n);
                        return super.c = JsonToken.NOT_AVAILABLE;
                    }
                    i = (this.q0[a] & 0xFF);
                    a = n;
                    m = o;
                }
            }
            if (i == 46) {
                super.V = a;
                ++super.A;
                return this.V2(m, a, i);
            }
            continue;
        }
    }
    
    protected JsonToken b3() throws IOException {
        int i = super.A;
        final char[] m = super.K.m();
        final int[] r0 = a.r0;
        final int min = Math.min(super.B, m.length + i);
        final byte[] q0 = this.q0;
        int n = 0;
        while (i < min) {
            final int n2 = q0[i] & 0xFF;
            if (r0[n2] != 0) {
                if (n2 == 34) {
                    super.A = i + 1;
                    super.K.D(n);
                    return this.Z1(JsonToken.VALUE_STRING);
                }
                break;
            }
            else {
                ++i;
                m[n] = (char)n2;
                ++n;
            }
        }
        super.K.D(n);
        super.A = i;
        return this.F2();
    }
    
    protected JsonToken c3() throws IOException {
        final int a = super.A;
        if (a + 3 < super.B) {
            final byte[] q0 = this.q0;
            final int n = a + 1;
            if (q0[a] == 114) {
                final int n2 = n + 1;
                if (q0[n] == 117) {
                    final int a2 = n2 + 1;
                    if (q0[n2] == 101) {
                        final int n3 = q0[a2] & 0xFF;
                        if (n3 < 48 || n3 == 93 || n3 == 125) {
                            super.A = a2;
                            return this.Z1(JsonToken.VALUE_TRUE);
                        }
                    }
                }
            }
        }
        super.i0 = 17;
        return this.x2("true", 1, JsonToken.VALUE_TRUE);
    }
    
    protected JsonToken d3(final boolean b, final int n) throws IOException {
        Label_0122: {
            if (n != 39) {
                if (n == 73) {
                    return this.z2(1, 1);
                }
                if (n == 78) {
                    return this.z2(0, 1);
                }
                if (n != 93) {
                    if (n == 125) {
                        break Label_0122;
                    }
                    if (n == 43) {
                        return this.z2(2, 1);
                    }
                    if (n != 44) {
                        break Label_0122;
                    }
                }
                else if (!super.I.d()) {
                    break Label_0122;
                }
                if (this.E(Feature.ALLOW_MISSING_VALUES)) {
                    --super.A;
                    return this.Z1(JsonToken.VALUE_NULL);
                }
            }
            else if (this.E(Feature.ALLOW_SINGLE_QUOTES)) {
                return this.Q2();
            }
        }
        this.l0(n, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }
    
    protected JsonToken r2() throws IOException {
        do {
            final int a = super.A;
            if (a >= super.B) {
                return super.c = JsonToken.NOT_AVAILABLE;
            }
            final byte[] q0 = this.q0;
            super.A = a + 1;
            final char c = (char)q0[a];
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            super.K.a(c);
        } while (super.K.E() < 256);
        return this.N2(super.K.l());
    }
    
    protected JsonToken s2() throws IOException {
        return this.N2(super.K.l());
    }
    
    protected final JsonToken t2() throws IOException {
        final int e2 = this.e2(super.e0, super.f0);
        if (e2 < 0) {
            super.i0 = 8;
            return JsonToken.NOT_AVAILABLE;
        }
        final int a0 = super.a0;
        final int[] z = super.Z;
        if (a0 >= z.length) {
            super.Z = x2.b.s1(z, 32);
        }
        final int c0 = super.c0;
        final int d0 = super.d0;
        final int n = 1;
        int n2 = e2;
        int n3 = c0;
        int n4 = d0;
        if (e2 > 127) {
            final int n5 = 0;
            int n6 = c0;
            int n7;
            if ((n7 = d0) >= 4) {
                super.Z[super.a0++] = c0;
                n6 = 0;
                n7 = 0;
            }
            int n8;
            int n9;
            if (e2 < 2048) {
                n8 = n6 << 8;
                n9 = (e2 >> 6 | 0xC0);
            }
            else {
                int n10 = n6 << 8 | (e2 >> 12 | 0xE0);
                if (++n7 >= 4) {
                    super.Z[super.a0++] = n10;
                    n7 = 0;
                    n10 = n5;
                }
                n8 = n10 << 8;
                n9 = ((e2 >> 6 & 0x3F) | 0x80);
            }
            n3 = (n8 | n9);
            n4 = n7 + 1;
            n2 = ((e2 & 0x3F) | 0x80);
        }
        int n11;
        if (n4 < 4) {
            n11 = 1 + n4;
            n2 |= n3 << 8;
        }
        else {
            super.Z[super.a0++] = n3;
            n11 = n;
        }
        if (super.j0 == 9) {
            return this.m2(super.a0, n2, n11);
        }
        return this.K2(super.a0, n2, n11);
    }
    
    protected JsonToken u2(final boolean b, int n) throws IOException {
        int n2 = n;
        if (b) {
            super.i0 = 32;
            if (n == 45 || (n2 = n) == 43) {
                super.K.a((char)n);
                n = super.A;
                if (n >= super.B) {
                    super.i0 = 32;
                    super.X = 0;
                    return JsonToken.NOT_AVAILABLE;
                }
                final byte[] q0 = this.q0;
                super.A = n + 1;
                n2 = q0[n];
            }
        }
        char[] q2 = super.K.q();
        n = super.K.s();
        int x = super.X;
        while (n2 >= 48 && n2 <= 57) {
            ++x;
            char[] o = q2;
            if (n >= q2.length) {
                o = super.K.o();
            }
            final int n3 = n + 1;
            o[n] = (char)n2;
            n = super.A;
            if (n >= super.B) {
                super.K.D(n3);
                super.X = x;
                return JsonToken.NOT_AVAILABLE;
            }
            final byte[] q3 = this.q0;
            super.A = n + 1;
            n2 = q3[n];
            n = n3;
            q2 = o;
        }
        if (x == 0) {
            this.G0(n2 & 0xFF, "Exponent indicator not followed by a digit");
        }
        --super.A;
        super.K.D(n);
        super.X = x;
        return this.Z1(JsonToken.VALUE_NUMBER_FLOAT);
    }
    
    protected JsonToken v2() throws IOException {
        int w = super.W;
        char[] q = super.K.q();
        int s = super.K.s();
        while (true) {
            final byte b = this.q0[super.A++];
            if (b >= 48 && b <= 57) {
                ++w;
                char[] o = q;
                if (s >= q.length) {
                    o = super.K.o();
                }
                final int n = s + 1;
                o[s] = (char)b;
                if (super.A >= super.B) {
                    super.K.D(n);
                    super.W = w;
                    return JsonToken.NOT_AVAILABLE;
                }
                s = n;
                q = o;
            }
            else {
                if (w == 0) {
                    this.G0(b, "Decimal point not followed by a digit");
                }
                super.W = w;
                super.K.D(s);
                if (b != 101 && b != 69) {
                    --super.A;
                    super.K.D(s);
                    super.X = 0;
                    return this.Z1(JsonToken.VALUE_NUMBER_FLOAT);
                }
                super.K.a((char)b);
                super.X = 0;
                final int a = super.A;
                if (a >= super.B) {
                    super.i0 = 31;
                    return JsonToken.NOT_AVAILABLE;
                }
                super.i0 = 32;
                final byte[] q2 = this.q0;
                super.A = a + 1;
                return this.u2(true, q2[a] & 0xFF);
            }
        }
    }
    
    protected JsonToken x2(final String s, int c0, final JsonToken jsonToken) throws IOException {
        final int length = s.length();
        while (true) {
            final int a = super.A;
            if (a >= super.B) {
                super.c0 = c0;
                return super.c = JsonToken.NOT_AVAILABLE;
            }
            final byte b = this.q0[a];
            if (c0 == length) {
                if (b < 48 || b == 93 || b == 125) {
                    return this.Z1(jsonToken);
                }
                break;
            }
            else {
                if (b != s.charAt(c0)) {
                    break;
                }
                ++c0;
                ++super.A;
            }
        }
        super.i0 = 50;
        super.K.w(s, 0, c0);
        return this.r2();
    }
    
    protected JsonToken y2(final String s, final int n, final JsonToken c) throws IOException {
        if (n == s.length()) {
            return super.c = c;
        }
        super.K.w(s, 0, n);
        return this.s2();
    }
    
    protected JsonToken z2(final int l0, int c0) throws IOException {
        final String q1 = this.Q1(l0);
        final int length = q1.length();
        while (true) {
            final int a = super.A;
            if (a >= super.B) {
                super.l0 = l0;
                super.c0 = c0;
                super.i0 = 19;
                return super.c = JsonToken.NOT_AVAILABLE;
            }
            final byte b = this.q0[a];
            if (c0 == length) {
                if (b < 48 || b == 93 || b == 125) {
                    return this.b2(l0);
                }
                break;
            }
            else {
                if (b != q1.charAt(c0)) {
                    break;
                }
                ++c0;
                ++super.A;
            }
        }
        super.i0 = 50;
        super.K.w(q1, 0, c0);
        return this.r2();
    }
}
