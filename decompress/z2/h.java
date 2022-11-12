// 
// Decompiled by Procyon v0.6.0
// 

package z2;

import com.fasterxml.jackson.core.JsonLocation;
import java.io.EOFException;
import com.fasterxml.jackson.core.JsonParser;
import java.util.Arrays;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import com.fasterxml.jackson.core.io.c;
import java.io.DataInput;
import b3.a;
import x2.b;

public class h extends b
{
    private static final int[] e0;
    protected static final int[] f0;
    protected final a Y;
    protected int[] Z;
    protected boolean a0;
    private int b0;
    protected DataInput c0;
    protected int d0;
    
    static {
        e0 = com.fasterxml.jackson.core.io.a.i();
        f0 = com.fasterxml.jackson.core.io.a.g();
    }
    
    public h(final com.fasterxml.jackson.core.io.c c, final int n, final DataInput c2, final com.fasterxml.jackson.core.c c3, final a y, final int d0) {
        super(c, n);
        this.Z = new int[16];
        this.Y = y;
        this.c0 = c2;
        this.d0 = d0;
    }
    
    private final void A2() throws IOException {
        final int d0 = this.d0;
        if (d0 <= 32) {
            this.d0 = -1;
            if (d0 == 13 || d0 == 10) {
                ++super.D;
            }
            return;
        }
        this.i0(d0);
    }
    
    private final String B2(final int[] array, final int n, final int n2) throws JsonParseException {
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
                    this.j2(n7);
                    n11 = 1;
                    n12 = 1;
                }
                if (n8 + n12 > n3) {
                    this.f0(" in field name", JsonToken.FIELD_NAME);
                }
                final int n13 = array[n8 >> 2] >> (3 - (n8 & 0x3) << 3);
                final int n14 = n8 + 1;
                if ((n13 & 0xC0) != 0x80) {
                    this.k2(n13);
                }
                int n15 = (n13 & 0x3F) | n11 << 6;
                int n17;
                if (n12 > 1) {
                    final int n16 = array[n14 >> 2] >> (3 - (n14 & 0x3) << 3);
                    n17 = n14 + 1;
                    if ((n16 & 0xC0) != 0x80) {
                        this.k2(n16);
                    }
                    n15 = ((n16 & 0x3F) | n15 << 6);
                    if (n12 > 2) {
                        final int n18 = array[n17 >> 2] >> (3 - (n17 & 0x3) << 3);
                        ++n17;
                        if ((n18 & 0xC0) != 0x80) {
                            this.k2(n18 & 0xFF);
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
    
    private final void C1(final String s, final int n, final int n2) throws IOException {
        final char c = (char)this.F1(n2);
        if (Character.isJavaIdentifierPart(c)) {
            this.l2(c, s.substring(0, n));
        }
    }
    
    private final String C2(int g2, final int n) throws JsonParseException {
        g2 = G2(g2, n);
        final String c = this.Y.C(g2);
        if (c != null) {
            return c;
        }
        final int[] z = this.Z;
        z[0] = g2;
        return this.B2(z, 1, n);
    }
    
    private final String D2(final int n, int g2, final int n2) throws JsonParseException {
        g2 = G2(g2, n2);
        final String d = this.Y.D(n, g2);
        if (d != null) {
            return d;
        }
        final int[] z = this.Z;
        z[0] = n;
        z[1] = g2;
        return this.B2(z, 2, n2);
    }
    
    private void E1(final int n) throws JsonParseException {
        if (n == 93) {
            if (!super.I.d()) {
                this.d1(n, '}');
            }
            super.I = super.I.i();
            super.c = JsonToken.END_ARRAY;
        }
        if (n == 125) {
            if (!super.I.e()) {
                this.d1(n, ']');
            }
            super.I = super.I.i();
            super.c = JsonToken.END_OBJECT;
        }
    }
    
    private final String E2(final int n, final int n2, int g2, final int n3) throws JsonParseException {
        g2 = G2(g2, n3);
        final String e = this.Y.E(n, n2, g2);
        if (e != null) {
            return e;
        }
        final int[] z = this.Z;
        z[0] = n;
        z[1] = n2;
        z[2] = G2(g2, n3);
        return this.B2(z, 3, n3);
    }
    
    private final String F2(final int[] array, final int n, final int n2, final int n3) throws JsonParseException {
        int[] r1 = array;
        if (n >= array.length) {
            r1 = R1(array, array.length);
            this.Z = r1;
        }
        final int n4 = n + 1;
        r1[n] = G2(n2, n3);
        final String f = this.Y.F(r1, n4);
        if (f == null) {
            return this.B2(r1, n4, n3);
        }
        return f;
    }
    
    private static final int G2(int n, final int n2) {
        if (n2 != 4) {
            n |= -1 << (n2 << 3);
        }
        return n;
    }
    
    private final String I2(final int n, final int n2, final int n3) throws IOException {
        return this.H2(this.Z, 0, n, n2, n3);
    }
    
    private final String J2(final int n, final int n2, final int n3, final int n4) throws IOException {
        final int[] z = this.Z;
        z[0] = n;
        return this.H2(z, 1, n2, n3, n4);
    }
    
    private final String K2(final int n, final int n2, final int n3, final int n4, final int n5) throws IOException {
        final int[] z = this.Z;
        z[0] = n;
        z[1] = n2;
        return this.H2(z, 2, n3, n4, n5);
    }
    
    private final int L1(final int n) throws IOException {
        final int unsignedByte = this.c0.readUnsignedByte();
        if ((unsignedByte & 0xC0) != 0x80) {
            this.k2(unsignedByte & 0xFF);
        }
        return (n & 0x1F) << 6 | (unsignedByte & 0x3F);
    }
    
    private final int M1(final int n) throws IOException {
        final int unsignedByte = this.c0.readUnsignedByte();
        if ((unsignedByte & 0xC0) != 0x80) {
            this.k2(unsignedByte & 0xFF);
        }
        final int unsignedByte2 = this.c0.readUnsignedByte();
        if ((unsignedByte2 & 0xC0) != 0x80) {
            this.k2(unsignedByte2 & 0xFF);
        }
        return ((n & 0xF) << 6 | (unsignedByte & 0x3F)) << 6 | (unsignedByte2 & 0x3F);
    }
    
    private final int N1(final int n) throws IOException {
        final int unsignedByte = this.c0.readUnsignedByte();
        if ((unsignedByte & 0xC0) != 0x80) {
            this.k2(unsignedByte & 0xFF);
        }
        final int unsignedByte2 = this.c0.readUnsignedByte();
        if ((unsignedByte2 & 0xC0) != 0x80) {
            this.k2(unsignedByte2 & 0xFF);
        }
        final int unsignedByte3 = this.c0.readUnsignedByte();
        if ((unsignedByte3 & 0xC0) != 0x80) {
            this.k2(unsignedByte3 & 0xFF);
        }
        return ((((n & 0x7) << 6 | (unsignedByte & 0x3F)) << 6 | (unsignedByte2 & 0x3F)) << 6 | (unsignedByte3 & 0x3F)) - 65536;
    }
    
    private String O1() throws IOException {
        final char[] m = super.K.m();
        final int[] e0 = h.e0;
        final int length = m.length;
        int n = 0;
        while (true) {
            final int unsignedByte = this.c0.readUnsignedByte();
            if (e0[unsignedByte] != 0) {
                if (unsignedByte == 34) {
                    return super.K.C(n);
                }
                this.P1(m, n, unsignedByte);
                return super.K.l();
            }
            else {
                final int n2 = n + 1;
                m[n] = (char)unsignedByte;
                if (n2 >= length) {
                    this.P1(m, n2, this.c0.readUnsignedByte());
                    return super.K.l();
                }
                n = n2;
            }
        }
    }
    
    private final void P1(char[] array, int n, int n2) throws IOException {
        final int[] e0 = h.e0;
        final int length = array.length;
        int n3 = n2;
        n2 = n;
        n = length;
        while (true) {
            final int n4 = e0[n3];
            final int n5 = 0;
            if (n4 == 0) {
                int n6;
                int length2;
                if ((n6 = n2) >= (length2 = n)) {
                    array = super.K.p();
                    length2 = array.length;
                    n6 = 0;
                }
                array[n6] = (char)n3;
                n3 = this.c0.readUnsignedByte();
                n2 = n6 + 1;
                n = length2;
            }
            else {
                if (n3 == 34) {
                    break;
                }
                final int n7 = e0[n3];
                if (n7 != 1) {
                    if (n7 != 2) {
                        if (n7 != 3) {
                            if (n7 != 4) {
                                if (n3 < 32) {
                                    this.t0(n3, "string value");
                                }
                                else {
                                    this.i2(n3);
                                }
                            }
                            else {
                                final int n8 = this.N1(n3);
                                final int n9 = n2 + 1;
                                array[n2] = (char)(0xD800 | n8 >> 10);
                                if (n9 >= array.length) {
                                    array = super.K.p();
                                    n = array.length;
                                    n2 = 0;
                                }
                                else {
                                    n2 = n9;
                                }
                                n3 = ((n8 & 0x3FF) | 0xDC00);
                            }
                        }
                        else {
                            n3 = this.M1(n3);
                        }
                    }
                    else {
                        n3 = this.L1(n3);
                    }
                }
                else {
                    n3 = this.K1();
                }
                if (n2 >= array.length) {
                    array = super.K.p();
                    n = array.length;
                    n2 = n5;
                }
                final int n10 = n2 + 1;
                array[n2] = (char)n3;
                n3 = this.c0.readUnsignedByte();
                n2 = n10;
            }
        }
        super.K.D(n2);
    }
    
    private static int[] R1(final int[] array, final int n) {
        if (array == null) {
            return new int[n];
        }
        return Arrays.copyOf(array, array.length + n);
    }
    
    private final int U1() throws IOException {
        int unsignedByte;
        final int n = unsignedByte = this.c0.readUnsignedByte();
        if (n >= 48) {
            if (n > 57) {
                unsignedByte = n;
            }
            else {
                int unsignedByte2 = n;
                if (!this.E(Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
                    this.B0("Leading zeroes not allowed");
                    unsignedByte2 = n;
                }
                while ((unsignedByte = unsignedByte2) == 48) {
                    unsignedByte2 = this.c0.readUnsignedByte();
                }
            }
        }
        return unsignedByte;
    }
    
    private final JsonToken Y1() {
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
    
    private final JsonToken Z1(final int n) throws IOException {
        if (n == 34) {
            this.a0 = true;
            return super.c = JsonToken.VALUE_STRING;
        }
        if (n == 45) {
            return super.c = this.g2();
        }
        if (n == 91) {
            super.I = super.I.j(super.G, super.H);
            return super.c = JsonToken.START_ARRAY;
        }
        if (n == 102) {
            this.X1("false", 1);
            return super.c = JsonToken.VALUE_FALSE;
        }
        if (n == 110) {
            this.X1("null", 1);
            return super.c = JsonToken.VALUE_NULL;
        }
        if (n == 116) {
            this.X1("true", 1);
            return super.c = JsonToken.VALUE_TRUE;
        }
        if (n == 123) {
            super.I = super.I.k(super.G, super.H);
            return super.c = JsonToken.START_OBJECT;
        }
        switch (n) {
            default: {
                return super.c = this.W1(n);
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
                return super.c = this.h2(n);
            }
        }
    }
    
    private final JsonToken b2(char[] p5, int n, int n2, final boolean b, final int n3) throws IOException {
        int n4 = 0;
        int n6;
        char[] array;
        if (n2 == 46) {
            p5[n] = (char)n2;
            n2 = 0;
            ++n;
            int unsignedByte;
            while (true) {
                unsignedByte = this.c0.readUnsignedByte();
                if (unsignedByte < 48 || unsignedByte > 57) {
                    break;
                }
                final int n5 = n2 + 1;
                char[] p6 = p5;
                if ((n2 = n) >= p5.length) {
                    p6 = super.K.p();
                    n2 = 0;
                }
                p6[n2] = (char)unsignedByte;
                n = n2 + 1;
                p5 = p6;
                n2 = n5;
            }
            if (n2 == 0) {
                this.G0(unsignedByte, "Decimal point not followed by a digit");
            }
            n6 = n2;
            n2 = unsignedByte;
            array = p5;
        }
        else {
            n6 = 0;
            array = p5;
        }
        int n7 = 0;
        int d0 = 0;
        Label_0359: {
            if (n2 != 101) {
                n7 = n;
                if ((d0 = n2) != 69) {
                    break Label_0359;
                }
            }
            p5 = array;
            int n8;
            if ((n8 = n) >= array.length) {
                p5 = super.K.p();
                n8 = 0;
            }
            final int n9 = n8 + 1;
            p5[n8] = (char)n2;
            n2 = this.c0.readUnsignedByte();
            int n10;
            if (n2 != 45 && n2 != 43) {
                n = n9;
                n10 = 0;
            }
            else {
                n = n9;
                char[] p7 = p5;
                if (n9 >= p5.length) {
                    p7 = super.K.p();
                    n = 0;
                }
                p7[n] = (char)n2;
                n2 = this.c0.readUnsignedByte();
                n10 = 0;
                ++n;
                p5 = p7;
            }
            while (n2 <= 57 && n2 >= 48) {
                final int n11 = n10 + 1;
                char[] p8 = p5;
                int n12;
                if ((n12 = n) >= p5.length) {
                    p8 = super.K.p();
                    n12 = 0;
                }
                p8[n12] = (char)n2;
                n2 = this.c0.readUnsignedByte();
                n = n12 + 1;
                n10 = n11;
                p5 = p8;
            }
            if (n10 == 0) {
                this.G0(n2, "Exponent indicator not followed by a digit");
            }
            n4 = n10;
            d0 = n2;
            n7 = n;
        }
        this.d0 = d0;
        if (super.I.f()) {
            this.A2();
        }
        super.K.D(n7);
        return this.A1(b, n3, n6, n4);
    }
    
    private final String c2(int n, int n2, int n3) throws IOException {
        final int[] z = this.Z;
        z[0] = this.b0;
        z[1] = n2;
        z[2] = n3;
        final int[] f0 = h.f0;
        n2 = n;
        n = 3;
        while (true) {
            n3 = this.c0.readUnsignedByte();
            if (f0[n3] != 0) {
                if (n3 == 34) {
                    return this.F2(this.Z, n, n2, 1);
                }
                return this.H2(this.Z, n, n2, n3, 1);
            }
            else {
                n3 |= n2 << 8;
                n2 = this.c0.readUnsignedByte();
                if (f0[n2] != 0) {
                    if (n2 == 34) {
                        return this.F2(this.Z, n, n3, 2);
                    }
                    return this.H2(this.Z, n, n3, n2, 2);
                }
                else {
                    n2 |= n3 << 8;
                    n3 = this.c0.readUnsignedByte();
                    if (f0[n3] != 0) {
                        if (n3 == 34) {
                            return this.F2(this.Z, n, n2, 3);
                        }
                        return this.H2(this.Z, n, n2, n3, 3);
                    }
                    else {
                        n3 |= n2 << 8;
                        n2 = this.c0.readUnsignedByte();
                        if (f0[n2] != 0) {
                            if (n2 == 34) {
                                return this.F2(this.Z, n, n3, 4);
                            }
                            return this.H2(this.Z, n, n3, n2, 4);
                        }
                        else {
                            final int[] z2 = this.Z;
                            if (n >= z2.length) {
                                this.Z = R1(z2, n);
                            }
                            this.Z[n] = n3;
                            ++n;
                        }
                    }
                }
            }
        }
    }
    
    private final String d2(int n) throws IOException {
        final int[] f0 = h.f0;
        final int unsignedByte = this.c0.readUnsignedByte();
        if (f0[unsignedByte] != 0) {
            if (unsignedByte == 34) {
                return this.D2(this.b0, n, 1);
            }
            return this.J2(this.b0, n, unsignedByte, 1);
        }
        else {
            n = (n << 8 | unsignedByte);
            final int unsignedByte2 = this.c0.readUnsignedByte();
            if (f0[unsignedByte2] != 0) {
                if (unsignedByte2 == 34) {
                    return this.D2(this.b0, n, 2);
                }
                return this.J2(this.b0, n, unsignedByte2, 2);
            }
            else {
                n = (n << 8 | unsignedByte2);
                final int unsignedByte3 = this.c0.readUnsignedByte();
                if (f0[unsignedByte3] != 0) {
                    if (unsignedByte3 == 34) {
                        return this.D2(this.b0, n, 3);
                    }
                    return this.J2(this.b0, n, unsignedByte3, 3);
                }
                else {
                    n = (n << 8 | unsignedByte3);
                    final int unsignedByte4 = this.c0.readUnsignedByte();
                    if (f0[unsignedByte4] == 0) {
                        return this.e2(unsignedByte4, n);
                    }
                    if (unsignedByte4 == 34) {
                        return this.D2(this.b0, n, 4);
                    }
                    return this.J2(this.b0, n, unsignedByte4, 4);
                }
            }
        }
    }
    
    private final String e2(int n, final int n2) throws IOException {
        final int[] f0 = h.f0;
        final int unsignedByte = this.c0.readUnsignedByte();
        if (f0[unsignedByte] != 0) {
            if (unsignedByte == 34) {
                return this.E2(this.b0, n2, n, 1);
            }
            return this.K2(this.b0, n2, n, unsignedByte, 1);
        }
        else {
            final int n3 = n << 8 | unsignedByte;
            n = this.c0.readUnsignedByte();
            if (f0[n] != 0) {
                if (n == 34) {
                    return this.E2(this.b0, n2, n3, 2);
                }
                return this.K2(this.b0, n2, n3, n, 2);
            }
            else {
                n |= n3 << 8;
                final int unsignedByte2 = this.c0.readUnsignedByte();
                if (f0[unsignedByte2] != 0) {
                    if (unsignedByte2 == 34) {
                        return this.E2(this.b0, n2, n, 3);
                    }
                    return this.K2(this.b0, n2, n, unsignedByte2, 3);
                }
                else {
                    final int n4 = n << 8 | unsignedByte2;
                    n = this.c0.readUnsignedByte();
                    if (f0[n] == 0) {
                        return this.c2(n, n2, n4);
                    }
                    if (n == 34) {
                        return this.E2(this.b0, n2, n4, 4);
                    }
                    return this.K2(this.b0, n2, n4, n, 4);
                }
            }
        }
    }
    
    private void k2(final int n) throws JsonParseException {
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-8 middle byte 0x");
        sb.append(Integer.toHexString(n));
        this.Z(sb.toString());
    }
    
    private final void n2() throws IOException {
        final int[] f = com.fasterxml.jackson.core.io.a.f();
        int n = this.c0.readUnsignedByte();
        while (true) {
            final int n2 = f[n];
            if (n2 != 0) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            if (n2 != 10 && n2 != 13) {
                                if (n2 != 42) {
                                    this.i2(n);
                                }
                                else {
                                    if ((n = this.c0.readUnsignedByte()) == 47) {
                                        break;
                                    }
                                    continue;
                                }
                            }
                            else {
                                ++super.D;
                            }
                        }
                        else {
                            this.v2();
                        }
                    }
                    else {
                        this.u2();
                    }
                }
                else {
                    this.t2();
                }
            }
            n = this.c0.readUnsignedByte();
        }
    }
    
    private final int o2() throws IOException {
        int n = this.d0;
        if (n < 0) {
            n = this.c0.readUnsignedByte();
        }
        else {
            this.d0 = -1;
        }
        if (n == 58) {
            final int unsignedByte = this.c0.readUnsignedByte();
            if (unsignedByte <= 32) {
                int n2;
                if (unsignedByte == 32 || (n2 = unsignedByte) == 9) {
                    final int unsignedByte2 = this.c0.readUnsignedByte();
                    if ((n2 = unsignedByte2) > 32) {
                        if (unsignedByte2 != 47 && unsignedByte2 != 35) {
                            return unsignedByte2;
                        }
                        return this.p2(unsignedByte2, true);
                    }
                }
                return this.p2(n2, true);
            }
            if (unsignedByte != 47 && unsignedByte != 35) {
                return unsignedByte;
            }
            return this.p2(unsignedByte, true);
        }
        else {
            int unsignedByte3;
            if (n == 32 || (unsignedByte3 = n) == 9) {
                unsignedByte3 = this.c0.readUnsignedByte();
            }
            if (unsignedByte3 != 58) {
                return this.p2(unsignedByte3, false);
            }
            final int unsignedByte4 = this.c0.readUnsignedByte();
            if (unsignedByte4 <= 32) {
                int n3;
                if (unsignedByte4 == 32 || (n3 = unsignedByte4) == 9) {
                    final int unsignedByte5 = this.c0.readUnsignedByte();
                    if ((n3 = unsignedByte5) > 32) {
                        if (unsignedByte5 != 47 && unsignedByte5 != 35) {
                            return unsignedByte5;
                        }
                        return this.p2(unsignedByte5, true);
                    }
                }
                return this.p2(n3, true);
            }
            if (unsignedByte4 != 47 && unsignedByte4 != 35) {
                return unsignedByte4;
            }
            return this.p2(unsignedByte4, true);
        }
    }
    
    private final int p2(int unsignedByte, final boolean b) throws IOException {
        int n = b ? 1 : 0;
        while (true) {
            int n2 = 0;
            Label_0092: {
                if (unsignedByte > 32) {
                    if (unsignedByte == 47) {
                        this.q2();
                        n2 = n;
                    }
                    else if (unsignedByte == 35 && this.z2()) {
                        n2 = n;
                    }
                    else {
                        if (n != 0) {
                            break;
                        }
                        if (unsignedByte != 58) {
                            this.l0(unsignedByte, "was expecting a colon to separate field name and value");
                        }
                        n2 = 1;
                    }
                }
                else {
                    if (unsignedByte != 13) {
                        n2 = n;
                        if (unsignedByte != 10) {
                            break Label_0092;
                        }
                    }
                    ++super.D;
                    n2 = n;
                }
            }
            unsignedByte = this.c0.readUnsignedByte();
            n = n2;
        }
        return unsignedByte;
    }
    
    private final void q2() throws IOException {
        if (!this.E(Feature.ALLOW_COMMENTS)) {
            this.l0(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        final int unsignedByte = this.c0.readUnsignedByte();
        if (unsignedByte == 47) {
            this.r2();
        }
        else if (unsignedByte == 42) {
            this.n2();
        }
        else {
            this.l0(unsignedByte, "was expecting either '*' or '/' for a comment");
        }
    }
    
    private final void r2() throws IOException {
        final int[] f = com.fasterxml.jackson.core.io.a.f();
        while (true) {
            final int unsignedByte = this.c0.readUnsignedByte();
            final int n = f[unsignedByte];
            if (n != 0) {
                if (n != 2) {
                    if (n != 3) {
                        if (n != 4) {
                            if (n == 10 || n == 13) {
                                break;
                            }
                            if (n == 42 || n >= 0) {
                                continue;
                            }
                            this.i2(unsignedByte);
                        }
                        else {
                            this.v2();
                        }
                    }
                    else {
                        this.u2();
                    }
                }
                else {
                    this.t2();
                }
            }
        }
        ++super.D;
    }
    
    private final void t2() throws IOException {
        final int unsignedByte = this.c0.readUnsignedByte();
        if ((unsignedByte & 0xC0) != 0x80) {
            this.k2(unsignedByte & 0xFF);
        }
    }
    
    private final void u2() throws IOException {
        final int unsignedByte = this.c0.readUnsignedByte();
        if ((unsignedByte & 0xC0) != 0x80) {
            this.k2(unsignedByte & 0xFF);
        }
        final int unsignedByte2 = this.c0.readUnsignedByte();
        if ((unsignedByte2 & 0xC0) != 0x80) {
            this.k2(unsignedByte2 & 0xFF);
        }
    }
    
    private final void v2() throws IOException {
        final int unsignedByte = this.c0.readUnsignedByte();
        if ((unsignedByte & 0xC0) != 0x80) {
            this.k2(unsignedByte & 0xFF);
        }
        final int unsignedByte2 = this.c0.readUnsignedByte();
        if ((unsignedByte2 & 0xC0) != 0x80) {
            this.k2(unsignedByte2 & 0xFF);
        }
        final int unsignedByte3 = this.c0.readUnsignedByte();
        if ((unsignedByte3 & 0xC0) != 0x80) {
            this.k2(unsignedByte3 & 0xFF);
        }
    }
    
    private final int w2() throws IOException {
        int i = this.d0;
        if (i < 0) {
            i = this.c0.readUnsignedByte();
        }
        else {
            this.d0 = -1;
        }
        while (i <= 32) {
            if (i == 13 || i == 10) {
                ++super.D;
            }
            i = this.c0.readUnsignedByte();
        }
        if (i != 47 && i != 35) {
            return i;
        }
        return this.x2(i);
    }
    
    private final int x2(int unsignedByte) throws IOException {
        while (true) {
            if (unsignedByte > 32) {
                if (unsignedByte == 47) {
                    this.q2();
                }
                else if (unsignedByte != 35 || !this.z2()) {
                    break;
                }
            }
            else if (unsignedByte == 13 || unsignedByte == 10) {
                ++super.D;
            }
            unsignedByte = this.c0.readUnsignedByte();
        }
        return unsignedByte;
    }
    
    private final int y2() throws IOException {
        int i = this.d0;
        while (true) {
            if (i < 0) {
                try {
                    i = this.c0.readUnsignedByte();
                    break Label_0033;
                }
                catch (final EOFException ex) {
                    return this.K0();
                }
            }
            Label_0028: {
                break Label_0028;
                while (i <= 32) {
                    if (i == 13 || i == 10) {
                        ++super.D;
                    }
                    try {
                        i = this.c0.readUnsignedByte();
                    }
                    catch (final EOFException ex2) {
                        return this.K0();
                    }
                }
                if (i != 47 && i != 35) {
                    return i;
                }
                return this.x2(i);
            }
            this.d0 = -1;
            continue;
        }
    }
    
    private final boolean z2() throws IOException {
        if (!this.E(Feature.ALLOW_YAML_COMMENTS)) {
            return false;
        }
        this.r2();
        return true;
    }
    
    @Override
    public JsonToken F() throws IOException {
        if (super.z) {
            return null;
        }
        final JsonToken c = super.c;
        final JsonToken field_NAME = JsonToken.FIELD_NAME;
        if (c == field_NAME) {
            return this.Y1();
        }
        super.O = 0;
        if (this.a0) {
            this.s2();
        }
        final int y2 = this.y2();
        if (y2 < 0) {
            this.close();
            return super.c = null;
        }
        super.N = null;
        super.G = super.D;
        if (y2 == 93 || y2 == 125) {
            this.E1(y2);
            return super.c;
        }
        int w2 = y2;
        if (super.I.m()) {
            if (y2 != 44) {
                final StringBuilder sb = new StringBuilder();
                sb.append("was expecting comma to separate ");
                sb.append(super.I.g());
                sb.append(" entries");
                this.l0(y2, sb.toString());
            }
            final int n = w2 = this.w2();
            if (Feature.ALLOW_TRAILING_COMMA.enabledIn(super.a) && (n == 93 || (w2 = n) == 125)) {
                this.E1(n);
                return super.c;
            }
        }
        if (!super.I.e()) {
            return this.Z1(w2);
        }
        super.I.q(this.f2(w2));
        super.c = field_NAME;
        final int o2 = this.o2();
        if (o2 == 34) {
            this.a0 = true;
            super.J = JsonToken.VALUE_STRING;
            return super.c;
        }
        JsonToken j;
        if (o2 != 45) {
            if (o2 != 91) {
                if (o2 != 102) {
                    if (o2 != 110) {
                        if (o2 != 116) {
                            if (o2 != 123) {
                                switch (o2) {
                                    default: {
                                        j = this.W1(o2);
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
                                        j = this.h2(o2);
                                        break;
                                    }
                                }
                            }
                            else {
                                j = JsonToken.START_OBJECT;
                            }
                        }
                        else {
                            this.X1("true", 1);
                            j = JsonToken.VALUE_TRUE;
                        }
                    }
                    else {
                        this.X1("null", 1);
                        j = JsonToken.VALUE_NULL;
                    }
                }
                else {
                    this.X1("false", 1);
                    j = JsonToken.VALUE_FALSE;
                }
            }
            else {
                j = JsonToken.START_ARRAY;
            }
        }
        else {
            j = this.g2();
        }
        super.J = j;
        return super.c;
    }
    
    protected int F1(int n) throws IOException {
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
                    this.j2(n2 & 0xFF);
                    n = n2;
                }
                n3 = 1;
            }
            final int unsignedByte = this.c0.readUnsignedByte();
            if ((unsignedByte & 0xC0) != 0x80) {
                this.k2(unsignedByte & 0xFF);
            }
            final int n4 = n = (n << 6 | (unsignedByte & 0x3F));
            if (n3 > 1) {
                n = this.c0.readUnsignedByte();
                if ((n & 0xC0) != 0x80) {
                    this.k2(n & 0xFF);
                }
                final int n5 = n = (n4 << 6 | (n & 0x3F));
                if (n3 > 2) {
                    n = this.c0.readUnsignedByte();
                    if ((n & 0xC0) != 0x80) {
                        this.k2(n & 0xFF);
                    }
                    n = (n5 << 6 | (n & 0x3F));
                }
            }
        }
        return n;
    }
    
    protected final String H2(int[] array, int n, int n2, int n3, int n4) throws IOException {
        final int[] f0 = h.f0;
        int n5 = n3;
        while (true) {
            int[] array2 = array;
            int n6 = n;
            int n7 = n2;
            n3 = n5;
            int n8 = n4;
            if (f0[n5] != 0) {
                if (n5 == 34) {
                    break;
                }
                if (n5 != 92) {
                    this.t0(n5, "name");
                }
                else {
                    n5 = this.K1();
                }
                array2 = array;
                n6 = n;
                n7 = n2;
                n3 = n5;
                n8 = n4;
                if (n5 > 127) {
                    final int n9 = 0;
                    int[] r1 = array;
                    n3 = n;
                    int n10 = n2;
                    int n11;
                    if ((n11 = n4) >= 4) {
                        r1 = array;
                        if (n >= array.length) {
                            r1 = R1(array, array.length);
                            this.Z = r1;
                        }
                        r1[n] = n2;
                        n3 = n + 1;
                        n10 = 0;
                        n11 = 0;
                    }
                    if (n5 < 2048) {
                        n = (n10 << 8 | (n5 >> 6 | 0xC0));
                        n2 = n11 + 1;
                        array = r1;
                        n6 = n3;
                    }
                    else {
                        n2 = (n10 << 8 | (n5 >> 12 | 0xE0));
                        n = n11 + 1;
                        if (n >= 4) {
                            array = r1;
                            if (n3 >= r1.length) {
                                array = R1(r1, r1.length);
                                this.Z = array;
                            }
                            array[n3] = n2;
                            ++n3;
                            n = 0;
                            n2 = n9;
                        }
                        else {
                            array = r1;
                        }
                        n4 = (n2 << 8 | ((n5 >> 6 & 0x3F) | 0x80));
                        n2 = n + 1;
                        n = n4;
                        n6 = n3;
                    }
                    n3 = ((n5 & 0x3F) | 0x80);
                    n8 = n2;
                    n7 = n;
                    array2 = array;
                }
            }
            if (n8 < 4) {
                n4 = n8 + 1;
                n2 = (n7 << 8 | n3);
                array = array2;
                n = n6;
            }
            else {
                array = array2;
                if (n6 >= array2.length) {
                    array = R1(array2, array2.length);
                    this.Z = array;
                }
                array[n6] = n7;
                n2 = n3;
                n = n6 + 1;
                n4 = 1;
            }
            n5 = this.c0.readUnsignedByte();
        }
        int[] r2 = array;
        n3 = n;
        if (n4 > 0) {
            r2 = array;
            if (n >= array.length) {
                r2 = R1(array, array.length);
                this.Z = r2;
            }
            r2[n] = G2(n2, n4);
            n3 = n + 1;
        }
        String s;
        if ((s = this.Y.F(r2, n3)) == null) {
            s = this.B2(r2, n3, n4);
        }
        return s;
    }
    
    @Override
    protected void J0() throws IOException {
    }
    
    protected char K1() throws IOException {
        final int unsignedByte = this.c0.readUnsignedByte();
        if (unsignedByte == 34 || unsignedByte == 47 || unsignedByte == 92) {
            return (char)unsignedByte;
        }
        if (unsignedByte == 98) {
            return '\b';
        }
        if (unsignedByte == 102) {
            return '\f';
        }
        if (unsignedByte == 110) {
            return '\n';
        }
        if (unsignedByte == 114) {
            return '\r';
        }
        if (unsignedByte == 116) {
            return '\t';
        }
        if (unsignedByte != 117) {
            return this.W((char)this.F1(unsignedByte));
        }
        int i = 0;
        int n = 0;
        while (i < 4) {
            final int unsignedByte2 = this.c0.readUnsignedByte();
            final int b = com.fasterxml.jackson.core.io.a.b(unsignedByte2);
            if (b < 0) {
                this.l0(unsignedByte2, "expected a hex-digit for character escape sequence");
            }
            n = (n << 4 | b);
            ++i;
        }
        return (char)n;
    }
    
    protected final String Q1(final JsonToken jsonToken) {
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
    
    protected JsonToken S1() throws IOException {
        char[] array = super.K.m();
        final int[] e0 = h.e0;
        int n = 0;
        int n3 = 0;
    Block_2:
        while (true) {
            int n2 = array.length;
            char[] array2 = array;
            n3 = n;
            if (n >= array.length) {
                array2 = super.K.p();
                n2 = array2.length;
                n3 = 0;
            }
            int i;
            do {
                int n4 = this.c0.readUnsignedByte();
                if (n4 == 39) {
                    break Block_2;
                }
                if (e0[n4] != 0) {
                    final int n5 = e0[n4];
                    if (n5 != 1) {
                        if (n5 != 2) {
                            if (n5 != 3) {
                                if (n5 != 4) {
                                    if (n4 < 32) {
                                        this.t0(n4, "string value");
                                    }
                                    this.i2(n4);
                                }
                                else {
                                    final int n6 = this.N1(n4);
                                    final int n7 = n3 + 1;
                                    array2[n3] = (char)(0xD800 | n6 >> 10);
                                    if (n7 >= array2.length) {
                                        array2 = super.K.p();
                                        n3 = 0;
                                    }
                                    else {
                                        n3 = n7;
                                    }
                                    n4 = (0xDC00 | (n6 & 0x3FF));
                                }
                            }
                            else {
                                n4 = this.M1(n4);
                            }
                        }
                        else {
                            n4 = this.L1(n4);
                        }
                    }
                    else {
                        n4 = this.K1();
                    }
                    array = array2;
                    int n8 = n3;
                    if (n3 >= array2.length) {
                        array = super.K.p();
                        n8 = 0;
                    }
                    array[n8] = (char)n4;
                    n = n8 + 1;
                    continue Block_2;
                }
                i = n3 + 1;
                array2[n3] = (char)n4;
                n = (n3 = i);
            } while (i < n2);
            array = array2;
        }
        super.K.D(n3);
        return JsonToken.VALUE_STRING;
    }
    
    protected JsonToken T1(int unsignedByte, final boolean b) throws IOException {
        int n;
        while (true) {
            n = unsignedByte;
            if (unsignedByte != 73) {
                break;
            }
            unsignedByte = this.c0.readUnsignedByte();
            String s;
            if (unsignedByte == 78) {
                if (b) {
                    s = "-INF";
                }
                else {
                    s = "+INF";
                }
            }
            else {
                if ((n = unsignedByte) != 110) {
                    break;
                }
                if (b) {
                    s = "-Infinity";
                }
                else {
                    s = "+Infinity";
                }
            }
            this.X1(s, 3);
            if (this.E(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                double n2;
                if (b) {
                    n2 = Double.NEGATIVE_INFINITY;
                }
                else {
                    n2 = Double.POSITIVE_INFINITY;
                }
                return this.y1(s, n2);
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Non-standard token '");
            sb.append(s);
            sb.append("': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            this.Z(sb.toString());
        }
        this.G0(n, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }
    
    protected String V1(int n) throws IOException {
        if (n == 39 && this.E(Feature.ALLOW_SINGLE_QUOTES)) {
            return this.a2();
        }
        if (!this.E(Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            this.l0((char)this.F1(n), "was expecting double-quote to start field name");
        }
        final int[] j = com.fasterxml.jackson.core.io.a.j();
        if (j[n] != 0) {
            this.l0(n, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int[] z = this.Z;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int unsignedByte;
        int n5;
        int n6;
        int[] r1;
        int n7;
        do {
            if (n2 < 4) {
                n5 = n2 + 1;
                n6 = (n | n4 << 8);
                r1 = z;
                n7 = n3;
            }
            else {
                r1 = z;
                if (n3 >= z.length) {
                    r1 = R1(z, z.length);
                    this.Z = r1;
                }
                r1[n3] = n4;
                n7 = n3 + 1;
                n5 = 1;
                n6 = n;
            }
            unsignedByte = this.c0.readUnsignedByte();
            z = r1;
            n2 = n5;
            n3 = n7;
            n4 = n6;
            n = unsignedByte;
        } while (j[unsignedByte] == 0);
        this.d0 = unsignedByte;
        int[] r2 = r1;
        n = n7;
        if (n5 > 0) {
            r2 = r1;
            if (n7 >= r1.length) {
                r2 = R1(r1, r1.length);
                this.Z = r2;
            }
            r2[n7] = n6;
            n = n7 + 1;
        }
        String s;
        if ((s = this.Y.F(r2, n)) == null) {
            s = this.B2(r2, n, n5);
        }
        return s;
    }
    
    protected JsonToken W1(final int d0) throws IOException {
        Label_0196: {
            if (d0 != 39) {
                if (d0 != 73) {
                    if (d0 != 78) {
                        Label_0092: {
                            if (d0 != 93) {
                                if (d0 == 125) {
                                    break Label_0092;
                                }
                                if (d0 == 43) {
                                    return this.T1(this.c0.readUnsignedByte(), false);
                                }
                                if (d0 != 44) {
                                    break Label_0196;
                                }
                            }
                            else if (!super.I.d()) {
                                break Label_0196;
                            }
                            if (this.E(Feature.ALLOW_MISSING_VALUES)) {
                                this.d0 = d0;
                                return JsonToken.VALUE_NULL;
                            }
                        }
                        this.l0(d0, "expected a value");
                    }
                    else {
                        this.X1("NaN", 1);
                        if (this.E(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                            return this.y1("NaN", Double.NaN);
                        }
                        this.Z("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                        break Label_0196;
                    }
                }
                else {
                    this.X1("Infinity", 1);
                    if (this.E(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                        return this.y1("Infinity", Double.POSITIVE_INFINITY);
                    }
                    this.Z("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    break Label_0196;
                }
            }
            if (this.E(Feature.ALLOW_SINGLE_QUOTES)) {
                return this.S1();
            }
        }
        if (Character.isJavaIdentifierStart(d0)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append((char)d0);
            this.m2(d0, sb.toString(), "('true', 'false' or 'null')");
        }
        this.l0(d0, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }
    
    protected final void X1(final String s, int unsignedByte) throws IOException {
        int n;
        do {
            final int unsignedByte2 = this.c0.readUnsignedByte();
            if (unsignedByte2 != s.charAt(unsignedByte)) {
                this.l2(unsignedByte2, s.substring(0, unsignedByte));
            }
            n = unsignedByte + 1;
        } while ((unsignedByte = n) < s.length());
        unsignedByte = this.c0.readUnsignedByte();
        if (unsignedByte >= 48 && unsignedByte != 93 && unsignedByte != 125) {
            this.C1(s, n, unsignedByte);
        }
        this.d0 = unsignedByte;
    }
    
    @Override
    protected void a1() throws IOException {
        super.a1();
        this.Y.M();
    }
    
    protected String a2() throws IOException {
        int i = this.c0.readUnsignedByte();
        if (i == 39) {
            return "";
        }
        int[] z = this.Z;
        final int[] f0 = h.f0;
        int n = 0;
        int n3;
        int n2 = n3 = 0;
        while (i != 39) {
            int n4 = i;
            int[] array = z;
            int n5 = n;
            int n6 = n2;
            int n7 = n3;
            if (i != 34) {
                n4 = i;
                array = z;
                n5 = n;
                n6 = n2;
                n7 = n3;
                if (f0[i] != 0) {
                    int k1;
                    if (i != 92) {
                        this.t0(i, "name");
                        k1 = i;
                    }
                    else {
                        k1 = this.K1();
                    }
                    n4 = k1;
                    array = z;
                    n5 = n;
                    n6 = n2;
                    n7 = n3;
                    if (k1 > 127) {
                        int[] r1 = z;
                        int n8 = n;
                        int n9 = n2;
                        int n10 = n3;
                        if (n >= 4) {
                            r1 = z;
                            if (n2 >= z.length) {
                                r1 = R1(z, z.length);
                                this.Z = r1;
                            }
                            r1[n2] = n3;
                            n10 = 0;
                            n9 = n2 + 1;
                            n8 = 0;
                        }
                        int n11;
                        int n12;
                        int[] r2;
                        if (k1 < 2048) {
                            n11 = (n10 << 8 | (k1 >> 6 | 0xC0));
                            n12 = n8 + 1;
                            r2 = r1;
                        }
                        else {
                            final int n13 = n10 << 8 | (k1 >> 12 | 0xE0);
                            ++n8;
                            r2 = r1;
                            int n14 = n8;
                            int n15 = n9;
                            int n16 = n13;
                            if (n8 >= 4) {
                                r2 = r1;
                                if (n9 >= r1.length) {
                                    r2 = R1(r1, r1.length);
                                    this.Z = r2;
                                }
                                r2[n9] = n13;
                                n16 = 0;
                                n15 = n9 + 1;
                                n14 = 0;
                            }
                            n11 = (n16 << 8 | ((k1 >> 6 & 0x3F) | 0x80));
                            ++n14;
                            n9 = n15;
                            n12 = n14;
                        }
                        n4 = ((k1 & 0x3F) | 0x80);
                        n7 = n11;
                        n6 = n9;
                        n5 = n12;
                        array = r2;
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
                    z = R1(array, array.length);
                    this.Z = z;
                }
                z[n6] = n7;
                n3 = n4;
                n2 = n6 + 1;
                n = 1;
            }
            i = this.c0.readUnsignedByte();
        }
        int[] r3 = z;
        int n17 = n2;
        if (n > 0) {
            r3 = z;
            if (n2 >= z.length) {
                r3 = R1(z, z.length);
                this.Z = r3;
            }
            r3[n2] = G2(n3, n);
            n17 = n2 + 1;
        }
        String s;
        if ((s = this.Y.F(r3, n17)) == null) {
            s = this.B2(r3, n17, n);
        }
        return s;
    }
    
    @Override
    public JsonLocation e() {
        return new JsonLocation(this.L0(), -1L, -1L, super.D, -1);
    }
    
    protected final String f2(int unsignedByte) throws IOException {
        if (unsignedByte != 34) {
            return this.V1(unsignedByte);
        }
        final int[] f0 = h.f0;
        unsignedByte = this.c0.readUnsignedByte();
        if (f0[unsignedByte] == 0) {
            final int unsignedByte2 = this.c0.readUnsignedByte();
            if (f0[unsignedByte2] == 0) {
                unsignedByte = (unsignedByte << 8 | unsignedByte2);
                final int unsignedByte3 = this.c0.readUnsignedByte();
                if (f0[unsignedByte3] == 0) {
                    unsignedByte = (unsignedByte << 8 | unsignedByte3);
                    final int unsignedByte4 = this.c0.readUnsignedByte();
                    if (f0[unsignedByte4] == 0) {
                        unsignedByte = (unsignedByte << 8 | unsignedByte4);
                        final int unsignedByte5 = this.c0.readUnsignedByte();
                        if (f0[unsignedByte5] == 0) {
                            this.b0 = unsignedByte;
                            return this.d2(unsignedByte5);
                        }
                        if (unsignedByte5 == 34) {
                            return this.C2(unsignedByte, 4);
                        }
                        return this.I2(unsignedByte, unsignedByte5, 4);
                    }
                    else {
                        if (unsignedByte4 == 34) {
                            return this.C2(unsignedByte, 3);
                        }
                        return this.I2(unsignedByte, unsignedByte4, 3);
                    }
                }
                else {
                    if (unsignedByte3 == 34) {
                        return this.C2(unsignedByte, 2);
                    }
                    return this.I2(unsignedByte, unsignedByte3, 2);
                }
            }
            else {
                if (unsignedByte2 == 34) {
                    return this.C2(unsignedByte, 1);
                }
                return this.I2(unsignedByte, unsignedByte2, 1);
            }
        }
        else {
            if (unsignedByte == 34) {
                return "";
            }
            return this.I2(0, unsignedByte, 0);
        }
    }
    
    protected JsonToken g2() throws IOException {
        final char[] m = super.K.m();
        m[0] = '-';
        final int unsignedByte = this.c0.readUnsignedByte();
        m[1] = (char)unsignedByte;
        int d0;
        if (unsignedByte <= 48) {
            if (unsignedByte != 48) {
                return this.T1(unsignedByte, true);
            }
            d0 = this.U1();
        }
        else {
            if (unsignedByte > 57) {
                return this.T1(unsignedByte, true);
            }
            d0 = this.c0.readUnsignedByte();
        }
        int n = 2;
        int n2 = 1;
        while (d0 <= 57 && d0 >= 48) {
            ++n2;
            m[n] = (char)d0;
            d0 = this.c0.readUnsignedByte();
            ++n;
        }
        if (d0 != 46 && d0 != 101 && d0 != 69) {
            super.K.D(n);
            this.d0 = d0;
            if (super.I.f()) {
                this.A2();
            }
            return this.B1(true, n2);
        }
        return this.b2(m, n, d0, true, n2);
    }
    
    protected JsonToken h2(int n) throws IOException {
        final char[] m = super.K.m();
        final int n2 = 1;
        int d0;
        if (n == 48) {
            d0 = this.U1();
            if (d0 <= 57 && d0 >= 48) {
                n = 0;
            }
            else {
                m[0] = '0';
                n = n2;
            }
        }
        else {
            m[0] = (char)n;
            d0 = this.c0.readUnsignedByte();
            n = n2;
        }
        int n3 = n;
        while (d0 <= 57 && d0 >= 48) {
            ++n3;
            m[n] = (char)d0;
            d0 = this.c0.readUnsignedByte();
            ++n;
        }
        if (d0 != 46 && d0 != 101 && d0 != 69) {
            super.K.D(n);
            if (super.I.f()) {
                this.A2();
            }
            else {
                this.d0 = d0;
            }
            return this.B1(false, n3);
        }
        return this.b2(m, n, d0, false, n3);
    }
    
    protected void i2(final int n) throws JsonParseException {
        if (n < 32) {
            this.r0(n);
        }
        this.j2(n);
    }
    
    protected void j2(final int n) throws JsonParseException {
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid UTF-8 start byte 0x");
        sb.append(Integer.toHexString(n));
        this.Z(sb.toString());
    }
    
    protected void l2(final int n, final String s) throws IOException {
        this.m2(n, s, "'null', 'true', 'false' or NaN");
    }
    
    protected void m2(int unsignedByte, final String s, final String s2) throws IOException {
        final StringBuilder sb = new StringBuilder(s);
        while (true) {
            final char c = (char)this.F1(unsignedByte);
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            sb.append(c);
            unsignedByte = this.c0.readUnsignedByte();
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Unrecognized token '");
        sb2.append(sb.toString());
        sb2.append("': was expecting ");
        sb2.append(s2);
        this.Z(sb2.toString());
    }
    
    protected void s2() throws IOException {
        this.a0 = false;
        final int[] e0 = h.e0;
        while (true) {
            final int unsignedByte = this.c0.readUnsignedByte();
            if (e0[unsignedByte] != 0) {
                if (unsignedByte == 34) {
                    break;
                }
                final int n = e0[unsignedByte];
                if (n != 1) {
                    if (n != 2) {
                        if (n != 3) {
                            if (n != 4) {
                                if (unsignedByte < 32) {
                                    this.t0(unsignedByte, "string value");
                                }
                                else {
                                    this.i2(unsignedByte);
                                }
                            }
                            else {
                                this.v2();
                            }
                        }
                        else {
                            this.u2();
                        }
                    }
                    else {
                        this.t2();
                    }
                }
                else {
                    this.K1();
                }
            }
        }
    }
    
    @Override
    public String u() throws IOException {
        final JsonToken c = super.c;
        if (c != JsonToken.VALUE_STRING) {
            return this.Q1(c);
        }
        if (this.a0) {
            this.a0 = false;
            return this.O1();
        }
        return super.K.l();
    }
}
