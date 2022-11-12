// 
// Decompiled by Procyon v0.6.0
// 

package z2;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.util.d;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import com.fasterxml.jackson.core.io.c;
import com.fasterxml.jackson.core.io.a;
import com.fasterxml.jackson.core.JsonParser;
import java.io.Reader;
import x2.b;

public class g extends b
{
    protected static final int h0;
    protected static final int[] i0;
    protected Reader Y;
    protected char[] Z;
    protected boolean a0;
    protected final b3.b b0;
    protected final int c0;
    protected boolean d0;
    protected long e0;
    protected int f0;
    protected int g0;
    
    static {
        h0 = Feature.ALLOW_TRAILING_COMMA.getMask();
        i0 = a.g();
    }
    
    public g(final com.fasterxml.jackson.core.io.c c, final int n, final Reader y, final com.fasterxml.jackson.core.c c2, final b3.b b0) {
        super(c, n);
        this.Y = y;
        this.Z = c.f();
        super.A = 0;
        super.B = 0;
        this.b0 = b0;
        this.c0 = b0.p();
        this.a0 = true;
    }
    
    public g(final com.fasterxml.jackson.core.io.c c, final int n, final Reader y, final com.fasterxml.jackson.core.c c2, final b3.b b0, final char[] z, final int a, final int b2, final boolean a2) {
        super(c, n);
        this.Y = y;
        this.Z = z;
        super.A = a;
        super.B = b2;
        this.b0 = b0;
        this.c0 = b0.p();
        this.a0 = a2;
    }
    
    private final void C1(final String s, final int n, final int n2) throws IOException {
        if (Character.isJavaIdentifierPart((char)n2)) {
            this.g2(s.substring(0, n));
        }
    }
    
    private void E1(final int n) throws JsonParseException {
        if (n == 93) {
            this.u2();
            if (!super.I.d()) {
                this.d1(n, '}');
            }
            super.I = super.I.i();
            super.c = JsonToken.END_ARRAY;
        }
        if (n == 125) {
            this.u2();
            if (!super.I.e()) {
                this.d1(n, ']');
            }
            super.I = super.I.i();
            super.c = JsonToken.END_OBJECT;
        }
    }
    
    private String Q1(int n, int n2, final int[] array) throws IOException {
        super.K.z(this.Z, n, super.A - n);
        char[] array2 = super.K.r();
        n = super.K.s();
        final int length = array.length;
        while (true) {
            while (super.A < super.B || this.S1()) {
                final char c = this.Z[super.A];
                if (c <= length) {
                    if (array[c] != 0) {
                        break;
                    }
                }
                else if (!Character.isJavaIdentifierPart(c)) {
                    break;
                }
                ++super.A;
                n2 = n2 * 33 + c;
                final int n3 = n + 1;
                array2[n] = c;
                if (n3 >= array2.length) {
                    array2 = super.K.p();
                    n = 0;
                    continue;
                }
                n = n3;
                continue;
                super.K.D(n);
                final d k = super.K;
                final char[] t = k.t();
                final int u = k.u();
                n = k.E();
                return this.b0.o(t, u, n, n2);
            }
            continue;
        }
    }
    
    private final void T1() throws IOException {
        int a = super.A;
        if (a + 4 < super.B) {
            final char[] z = this.Z;
            if (z[a] == 'a') {
                ++a;
                if (z[a] == 'l') {
                    ++a;
                    if (z[a] == 's') {
                        ++a;
                        if (z[a] == 'e') {
                            ++a;
                            final char c = z[a];
                            if (c < '0' || c == ']' || c == '}') {
                                super.A = a;
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.V1("false", 1);
    }
    
    private final void U1() throws IOException {
        int a = super.A;
        if (a + 3 < super.B) {
            final char[] z = this.Z;
            if (z[a] == 'u') {
                ++a;
                if (z[a] == 'l') {
                    ++a;
                    if (z[a] == 'l') {
                        ++a;
                        final char c = z[a];
                        if (c < '0' || c == ']' || c == '}') {
                            super.A = a;
                            return;
                        }
                    }
                }
            }
        }
        this.V1("null", 1);
    }
    
    private final void W1(final String s, int n) throws IOException {
        int n2;
        int a;
        do {
            if ((super.A >= super.B && !this.S1()) || this.Z[super.A] != s.charAt(n)) {
                this.g2(s.substring(0, n));
            }
            a = super.A + 1;
            super.A = a;
            n2 = n + 1;
        } while ((n = n2) < s.length());
        if (a >= super.B && !this.S1()) {
            return;
        }
        n = this.Z[super.A];
        if (n >= 48 && n != 93 && n != 125) {
            this.C1(s, n2, n);
        }
    }
    
    private final void X1() throws IOException {
        int a = super.A;
        if (a + 3 < super.B) {
            final char[] z = this.Z;
            if (z[a] == 'r') {
                ++a;
                if (z[a] == 'u') {
                    ++a;
                    if (z[a] == 'e') {
                        ++a;
                        final char c = z[a];
                        if (c < '0' || c == ']' || c == '}') {
                            super.A = a;
                            return;
                        }
                    }
                }
            }
        }
        this.V1("true", 1);
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
    
    private final JsonToken a2(int a, final int a2, int n, final boolean b, final int n2) throws IOException {
        final int b2 = super.B;
        final int n3 = 0;
        int n4 = 0;
        final int n5 = 0;
        int n6 = 0;
        Label_0119: {
            if (a == 46) {
                a = 0;
                for (int i = n; i < b2; i = n) {
                    final char[] z = this.Z;
                    n = i + 1;
                    n6 = z[i];
                    if (n6 < 48 || n6 > 57) {
                        if (a == 0) {
                            this.G0(n6, "Decimal point not followed by a digit");
                        }
                        final int n7 = a;
                        a = n;
                        n = n7;
                        break Label_0119;
                    }
                    ++a;
                }
                return this.e2(b, a2);
            }
            final int n8 = n;
            n = 0;
            n6 = a;
            a = n8;
        }
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        Label_0346: {
            if (n6 != 101) {
                n9 = a;
                n10 = n6;
                n11 = n;
                if (n6 != 69) {
                    break Label_0346;
                }
            }
            if (a >= b2) {
                super.A = a2;
                return this.e2(b, a2);
            }
            final char[] z2 = this.Z;
            final int n12 = a + 1;
            int n13 = z2[a];
            int n14;
            if (n13 != 45 && n13 != 43) {
                a = n12;
                n14 = n5;
            }
            else {
                if (n12 >= b2) {
                    super.A = a2;
                    return this.e2(b, a2);
                }
                a = n12 + 1;
                n13 = z2[n12];
                n14 = n3;
            }
            while (true) {
                if (n13 <= 57 && n13 >= 48) {
                    ++n14;
                    if (a >= b2) {
                        super.A = a2;
                        return this.e2(b, a2);
                    }
                    final char[] z3 = this.Z;
                    final int n15 = a + 1;
                    final char c = z3[a];
                    a = n15;
                    n13 = c;
                    continue;
                }
                else {
                    n4 = n14;
                    n9 = a;
                    n10 = n13;
                    n11 = n;
                    if (n14 == 0) {
                        this.G0(n13, "Exponent indicator not followed by a digit");
                        n11 = n;
                        n10 = n13;
                        n9 = a;
                        n4 = n14;
                    }
                }
                break;
            }
        }
        a = n9 - 1;
        super.A = a;
        if (super.I.f()) {
            this.y2(n10);
        }
        super.K.z(this.Z, a2, a - a2);
        return this.A1(b, n2, n11, n4);
    }
    
    private String c2(int n, int n2, int e) throws IOException {
        super.K.z(this.Z, n, super.A - n);
        char[] array = super.K.r();
        n = super.K.s();
        while (true) {
            if (super.A >= super.B && !this.S1()) {
                this.f0(" in field name", JsonToken.FIELD_NAME);
            }
            final char c = this.Z[super.A++];
            char f1;
            if ((f1 = c) <= '\\') {
                if (c == '\\') {
                    f1 = this.F1();
                }
                else if ((f1 = c) <= e) {
                    if (c == e) {
                        break;
                    }
                    if ((f1 = c) < ' ') {
                        this.t0(c, "name");
                        f1 = c;
                    }
                }
            }
            n2 = n2 * 33 + f1;
            final int n3 = n + 1;
            array[n] = f1;
            if (n3 >= array.length) {
                array = super.K.p();
                n = 0;
            }
            else {
                n = n3;
            }
        }
        super.K.D(n);
        final d k = super.K;
        final char[] t = k.t();
        n = k.u();
        e = k.E();
        return this.b0.o(t, n, e, n2);
    }
    
    private final JsonToken e2(final boolean b, int a) throws IOException {
        int a2 = a;
        if (b) {
            a2 = a + 1;
        }
        super.A = a2;
        char[] m = super.K.m();
        final int n = 0;
        int n2;
        if (b) {
            m[0] = '-';
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        a = super.A;
        char a3;
        if (a < super.B) {
            final char[] z = this.Z;
            super.A = a + 1;
            a3 = z[a];
        }
        else {
            a3 = this.A2("No digit following minus sign", JsonToken.VALUE_NUMBER_INT);
        }
        char x2 = a3;
        if (a3 == '0') {
            x2 = this.x2();
        }
        int n3 = 0;
        char c = x2;
        while (true) {
        Label_0447_Outer:
            while (c >= '0' && c <= '9') {
                ++n3;
                int n4 = n2;
                char[] p2 = m;
                if (n2 >= m.length) {
                    p2 = super.K.p();
                    n4 = 0;
                }
                a = n4 + 1;
                p2[n4] = c;
                if (super.A >= super.B && !this.S1()) {
                    c = '\0';
                    final int n5 = 1;
                    n2 = a;
                    final int n6 = n3;
                    a = n5;
                    if (n6 == 0) {
                        return this.O1(c, b);
                    }
                    char c3 = '\0';
                    int n11 = 0;
                    char[] array2 = null;
                    Label_0508: {
                        if (c == '.') {
                            int n7 = n2;
                            char[] p3 = p2;
                            if (n2 >= p2.length) {
                                p3 = super.K.p();
                                n7 = 0;
                            }
                            p3[n7] = c;
                            ++n7;
                            int n8 = 0;
                            char[] array = p3;
                            while (true) {
                                while (super.A < super.B || this.S1()) {
                                    final char c2 = c = this.Z[super.A++];
                                    int n9 = a;
                                    if (c2 >= '0') {
                                        if (c2 <= '9') {
                                            ++n8;
                                            int n10 = n7;
                                            char[] p4 = array;
                                            if (n7 >= array.length) {
                                                p4 = super.K.p();
                                                n10 = 0;
                                            }
                                            p4[n10] = c2;
                                            n7 = n10 + 1;
                                            c = c2;
                                            array = p4;
                                            continue Label_0447_Outer;
                                        }
                                        c = c2;
                                        n9 = a;
                                    }
                                    n2 = n7;
                                    c3 = c;
                                    a = n9;
                                    n11 = n8;
                                    array2 = array;
                                    if (n8 == 0) {
                                        this.G0(c, "Decimal point not followed by a digit");
                                        n2 = n7;
                                        c3 = c;
                                        a = n9;
                                        n11 = n8;
                                        array2 = array;
                                    }
                                    break Label_0508;
                                }
                                int n9 = 1;
                                continue;
                            }
                        }
                        n11 = 0;
                        array2 = p2;
                        c3 = c;
                    }
                    int n12 = 0;
                    int n13 = 0;
                    char c4 = '\0';
                    int n14 = 0;
                    Label_0926: {
                        if (c3 != 'e') {
                            n12 = n;
                            n13 = n2;
                            c4 = c3;
                            n14 = a;
                            if (c3 != 'E') {
                                break Label_0926;
                            }
                        }
                        int n15 = n2;
                        char[] p5 = array2;
                        if (n2 >= array2.length) {
                            p5 = super.K.p();
                            n15 = 0;
                        }
                        final int n16 = n15 + 1;
                        p5[n15] = c3;
                        final int a4 = super.A;
                        char z3;
                        if (a4 < super.B) {
                            final char[] z2 = this.Z;
                            super.A = a4 + 1;
                            z3 = z2[a4];
                        }
                        else {
                            z3 = this.z2("expected a digit for number exponent");
                        }
                        while (true) {
                            Label_0660: {
                                if (z3 == '-') {
                                    break Label_0660;
                                }
                                char z4 = z3;
                                int n17 = n16;
                                char[] p6 = p5;
                                if (z3 == '+') {
                                    break Label_0660;
                                }
                                int n18 = 0;
                                while (true) {
                                    while (z4 <= '9' && z4 >= '0') {
                                        final int n19 = n18 + 1;
                                        int n20 = n17;
                                        char[] p7 = p6;
                                        if (n17 >= p6.length) {
                                            p7 = super.K.p();
                                            n20 = 0;
                                        }
                                        final int n21 = n20 + 1;
                                        p7[n20] = z4;
                                        if (super.A >= super.B && !this.S1()) {
                                            a = n19;
                                            final int n22 = 1;
                                            n12 = a;
                                            n13 = n21;
                                            c4 = z4;
                                            n14 = n22;
                                            if (a == 0) {
                                                this.G0(z4, "Exponent indicator not followed by a digit");
                                                n14 = n22;
                                                c4 = z4;
                                                n13 = n21;
                                                n12 = a;
                                            }
                                            break Label_0926;
                                        }
                                        else {
                                            z4 = this.Z[super.A++];
                                            n17 = n21;
                                            n18 = n19;
                                            p6 = p7;
                                        }
                                    }
                                    final int n23 = n18;
                                    final int n21 = n17;
                                    final int n22 = a;
                                    a = n23;
                                    continue;
                                }
                            }
                            int n17 = n16;
                            char[] p6 = p5;
                            if (n16 >= p5.length) {
                                p6 = super.K.p();
                                n17 = 0;
                            }
                            p6[n17] = z3;
                            final int a5 = super.A;
                            if (a5 < super.B) {
                                final char[] z5 = this.Z;
                                super.A = a5 + 1;
                                final char z4 = z5[a5];
                            }
                            else {
                                final char z4 = this.z2("expected a digit for number exponent");
                            }
                            ++n17;
                            continue;
                        }
                    }
                    if (n14 == 0) {
                        --super.A;
                        if (super.I.f()) {
                            this.y2(c4);
                        }
                    }
                    super.K.D(n13);
                    return this.w1(b, n6, n11, n12);
                }
                else {
                    c = this.Z[super.A++];
                    n2 = a;
                    m = p2;
                }
            }
            a = 0;
            char[] p2 = m;
            final int n6 = n3;
            continue;
        }
    }
    
    private final int i2() throws IOException {
        while (super.A < super.B || this.S1()) {
            final char[] z = this.Z;
            final int a = super.A;
            final int n = a + 1;
            super.A = n;
            final char c = z[a];
            if (c > ' ') {
                if (c == '/') {
                    this.o2();
                }
                else {
                    if (c == '#' && this.t2()) {
                        continue;
                    }
                    return c;
                }
            }
            else {
                if (c >= ' ') {
                    continue;
                }
                if (c == '\n') {
                    ++super.D;
                    super.E = n;
                }
                else if (c == '\r') {
                    this.k2();
                }
                else {
                    if (c == '\t') {
                        continue;
                    }
                    this.r0(c);
                }
            }
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unexpected end-of-input within/between ");
        sb.append(super.I.g());
        sb.append(" entries");
        throw this.a(sb.toString());
    }
    
    private void j2() throws IOException {
        while (super.A < super.B || this.S1()) {
            final char[] z = this.Z;
            final int a = super.A;
            final int n = a + 1;
            super.A = n;
            final char c = z[a];
            if (c <= '*') {
                if (c == '*') {
                    if (n >= super.B && !this.S1()) {
                        break;
                    }
                    final char[] z2 = this.Z;
                    final int a2 = super.A;
                    if (z2[a2] == '/') {
                        super.A = a2 + 1;
                        return;
                    }
                    continue;
                }
                else {
                    if (c >= ' ') {
                        continue;
                    }
                    if (c == '\n') {
                        ++super.D;
                        super.E = n;
                    }
                    else if (c == '\r') {
                        this.k2();
                    }
                    else {
                        if (c == '\t') {
                            continue;
                        }
                        this.r0(c);
                    }
                }
            }
        }
        this.f0(" in a comment", null);
    }
    
    private final int l2() throws IOException {
        final int a = super.A;
        if (a + 4 >= super.B) {
            return this.m2(false);
        }
        final char[] z = this.Z;
        final char c = z[a];
        if (c == ':') {
            int n = a + 1;
            super.A = n;
            final char c2 = z[n];
            if (c2 <= ' ') {
                if (c2 == ' ' || c2 == '\t') {
                    ++n;
                    super.A = n;
                    final char c3 = z[n];
                    if (c3 > ' ') {
                        if (c3 != '/' && c3 != '#') {
                            super.A = n + 1;
                            return c3;
                        }
                        return this.m2(true);
                    }
                }
                return this.m2(true);
            }
            if (c2 != '/' && c2 != '#') {
                super.A = n + 1;
                return c2;
            }
            return this.m2(true);
        }
        else {
            char c4;
            if (c == ' ' || (c4 = c) == '\t') {
                final int a2 = a + 1;
                super.A = a2;
                c4 = z[a2];
            }
            if (c4 != ':') {
                return this.m2(false);
            }
            int n2 = super.A + 1;
            super.A = n2;
            final char c5 = z[n2];
            if (c5 <= ' ') {
                if (c5 == ' ' || c5 == '\t') {
                    ++n2;
                    super.A = n2;
                    final char c6 = z[n2];
                    if (c6 > ' ') {
                        if (c6 != '/' && c6 != '#') {
                            super.A = n2 + 1;
                            return c6;
                        }
                        return this.m2(true);
                    }
                }
                return this.m2(true);
            }
            if (c5 != '/' && c5 != '#') {
                super.A = n2 + 1;
                return c5;
            }
            return this.m2(true);
        }
    }
    
    private final int m2(boolean b) throws IOException {
        while (super.A < super.B || this.S1()) {
            final char[] z = this.Z;
            final int a = super.A;
            final int n = a + 1;
            super.A = n;
            final char c = z[a];
            if (c > ' ') {
                if (c == '/') {
                    this.o2();
                }
                else {
                    if (c == '#' && this.t2()) {
                        continue;
                    }
                    if (b) {
                        return c;
                    }
                    if (c != ':') {
                        this.l0(c, "was expecting a colon to separate field name and value");
                    }
                    b = true;
                }
            }
            else {
                if (c >= ' ') {
                    continue;
                }
                if (c == '\n') {
                    ++super.D;
                    super.E = n;
                }
                else if (c == '\r') {
                    this.k2();
                }
                else {
                    if (c == '\t') {
                        continue;
                    }
                    this.r0(c);
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
    
    private final int n2(int n) throws IOException {
        if (n != 44) {
            final StringBuilder sb = new StringBuilder();
            sb.append("was expecting comma to separate ");
            sb.append(super.I.g());
            sb.append(" entries");
            this.l0(n, sb.toString());
        }
        while (true) {
            final int a = super.A;
            if (a >= super.B) {
                return this.i2();
            }
            final char[] z = this.Z;
            n = a + 1;
            super.A = n;
            final char c = z[a];
            if (c > ' ') {
                if (c != '/' && c != '#') {
                    return c;
                }
                super.A = n - 1;
                return this.i2();
            }
            else {
                if (c >= ' ') {
                    continue;
                }
                if (c == '\n') {
                    ++super.D;
                    super.E = n;
                }
                else if (c == '\r') {
                    this.k2();
                }
                else {
                    if (c == '\t') {
                        continue;
                    }
                    this.r0(c);
                }
            }
        }
    }
    
    private void o2() throws IOException {
        if (!this.E(Feature.ALLOW_COMMENTS)) {
            this.l0(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (super.A >= super.B && !this.S1()) {
            this.f0(" in a comment", null);
        }
        final char c = this.Z[super.A++];
        if (c == '/') {
            this.p2();
        }
        else if (c == '*') {
            this.j2();
        }
        else {
            this.l0(c, "was expecting either '*' or '/' for a comment");
        }
    }
    
    private void p2() throws IOException {
        while (super.A < super.B || this.S1()) {
            final char[] z = this.Z;
            final int a = super.A;
            final int n = a + 1;
            super.A = n;
            final char c = z[a];
            if (c < ' ') {
                if (c == '\n') {
                    ++super.D;
                    super.E = n;
                    break;
                }
                if (c == '\r') {
                    this.k2();
                    break;
                }
                if (c == '\t') {
                    continue;
                }
                this.r0(c);
            }
        }
    }
    
    private final int r2() throws IOException {
        if (super.A >= super.B && !this.S1()) {
            return this.K0();
        }
        final char[] z = this.Z;
        final int a = super.A;
        final int n = a + 1;
        super.A = n;
        final char c = z[a];
        if (c > ' ') {
            if (c != '/' && c != '#') {
                return c;
            }
            super.A = n - 1;
            return this.s2();
        }
        else {
            if (c != ' ') {
                if (c == '\n') {
                    ++super.D;
                    super.E = n;
                }
                else if (c == '\r') {
                    this.k2();
                }
                else if (c != '\t') {
                    this.r0(c);
                }
            }
            while (true) {
                final int a2 = super.A;
                if (a2 >= super.B) {
                    return this.s2();
                }
                final char[] z2 = this.Z;
                final int n2 = a2 + 1;
                super.A = n2;
                final char c2 = z2[a2];
                if (c2 > ' ') {
                    if (c2 != '/' && c2 != '#') {
                        return c2;
                    }
                    super.A = n2 - 1;
                    return this.s2();
                }
                else {
                    if (c2 == ' ') {
                        continue;
                    }
                    if (c2 == '\n') {
                        ++super.D;
                        super.E = n2;
                    }
                    else if (c2 == '\r') {
                        this.k2();
                    }
                    else {
                        if (c2 == '\t') {
                            continue;
                        }
                        this.r0(c2);
                    }
                }
            }
        }
    }
    
    private int s2() throws IOException {
        while (super.A < super.B || this.S1()) {
            final char[] z = this.Z;
            final int a = super.A;
            final int n = a + 1;
            super.A = n;
            final char c = z[a];
            if (c > ' ') {
                if (c == '/') {
                    this.o2();
                }
                else {
                    if (c == '#' && this.t2()) {
                        continue;
                    }
                    return c;
                }
            }
            else {
                if (c == ' ') {
                    continue;
                }
                if (c == '\n') {
                    ++super.D;
                    super.E = n;
                }
                else if (c == '\r') {
                    this.k2();
                }
                else {
                    if (c == '\t') {
                        continue;
                    }
                    this.r0(c);
                }
            }
        }
        return this.K0();
    }
    
    private boolean t2() throws IOException {
        if (!this.E(Feature.ALLOW_YAML_COMMENTS)) {
            return false;
        }
        this.p2();
        return true;
    }
    
    private final void u2() {
        final int a = super.A;
        super.F = super.C + a;
        super.G = super.D;
        super.H = a - super.E;
    }
    
    private final void v2() {
        final int a = super.A;
        this.e0 = a;
        this.f0 = super.D;
        this.g0 = a - super.E;
    }
    
    private char w2() throws IOException {
        if (super.A >= super.B && !this.S1()) {
            return '0';
        }
        final char c = this.Z[super.A];
        if (c >= '0' && c <= '9') {
            if (!this.E(Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
                this.B0("Leading zeroes not allowed");
            }
            ++super.A;
            char c2;
            if ((c2 = c) == '0') {
                c2 = c;
                while (super.A < super.B || this.S1()) {
                    final char[] z = this.Z;
                    final int a = super.A;
                    final char c3 = z[a];
                    if (c3 < '0' || c3 > '9') {
                        return '0';
                    }
                    super.A = a + 1;
                    if ((c2 = c3) != '0') {
                        c2 = c3;
                        break;
                    }
                }
            }
            return c2;
        }
        return '0';
    }
    
    private final char x2() throws IOException {
        final int a = super.A;
        if (a < super.B) {
            final char c = this.Z[a];
            if (c < '0' || c > '9') {
                return '0';
            }
        }
        return this.w2();
    }
    
    private final void y2(final int n) throws IOException {
        final int n2 = super.A + 1;
        super.A = n2;
        if (n != 9) {
            if (n != 10) {
                if (n == 13) {
                    this.k2();
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
    
    protected char A2(final String s, final JsonToken jsonToken) throws IOException {
        if (super.A >= super.B && !this.S1()) {
            this.f0(s, jsonToken);
        }
        return this.Z[super.A++];
    }
    
    @Override
    public final JsonToken F() throws IOException {
        final JsonToken c = super.c;
        final JsonToken field_NAME = JsonToken.FIELD_NAME;
        if (c == field_NAME) {
            return this.Y1();
        }
        super.O = 0;
        if (this.d0) {
            this.q2();
        }
        final int r2 = this.r2();
        if (r2 < 0) {
            this.close();
            return super.c = null;
        }
        super.N = null;
        if (r2 == 93 || r2 == 125) {
            this.E1(r2);
            return super.c;
        }
        int n2 = r2;
        if (super.I.m()) {
            final int n3 = n2 = this.n2(r2);
            if ((super.a & g.h0) != 0x0 && (n3 == 93 || (n2 = n3) == 125)) {
                this.E1(n3);
                return super.c;
            }
        }
        final boolean e = super.I.e();
        int l2 = n2;
        if (e) {
            this.v2();
            String s;
            if (n2 == 34) {
                s = this.b2();
            }
            else {
                s = this.P1(n2);
            }
            super.I.q(s);
            super.c = field_NAME;
            l2 = this.l2();
        }
        this.u2();
        JsonToken jsonToken = null;
        Label_0448: {
            if (l2 != 34) {
                if (l2 != 45) {
                    if (l2 != 91) {
                        if (l2 != 102) {
                            if (l2 != 110) {
                                if (l2 != 116) {
                                    if (l2 == 123) {
                                        if (!e) {
                                            super.I = super.I.k(super.G, super.H);
                                        }
                                        jsonToken = JsonToken.START_OBJECT;
                                        break Label_0448;
                                    }
                                    if (l2 != 125) {
                                        switch (l2) {
                                            default: {
                                                jsonToken = this.R1(l2);
                                                break Label_0448;
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
                                                jsonToken = this.f2(l2);
                                                break Label_0448;
                                            }
                                        }
                                    }
                                    else {
                                        this.l0(l2, "expected a value");
                                    }
                                }
                                this.X1();
                                jsonToken = JsonToken.VALUE_TRUE;
                            }
                            else {
                                this.U1();
                                jsonToken = JsonToken.VALUE_NULL;
                            }
                        }
                        else {
                            this.T1();
                            jsonToken = JsonToken.VALUE_FALSE;
                        }
                    }
                    else {
                        if (!e) {
                            super.I = super.I.j(super.G, super.H);
                        }
                        jsonToken = JsonToken.START_ARRAY;
                    }
                }
                else {
                    jsonToken = this.d2();
                }
            }
            else {
                this.d0 = true;
                jsonToken = JsonToken.VALUE_STRING;
            }
        }
        if (e) {
            super.J = jsonToken;
            return super.c;
        }
        return super.c = jsonToken;
    }
    
    protected char F1() throws IOException {
        if (super.A >= super.B && !this.S1()) {
            this.f0(" in character escape sequence", JsonToken.VALUE_STRING);
        }
        final char c = this.Z[super.A++];
        char c2;
        if ((c2 = c) != '\"' && (c2 = c) != '/' && (c2 = c) != '\\') {
            if (c != 'b') {
                if (c == 'f') {
                    return '\f';
                }
                if (c == 'n') {
                    return '\n';
                }
                if (c == 'r') {
                    return '\r';
                }
                if (c == 't') {
                    return '\t';
                }
                if (c != 'u') {
                    return this.W(c);
                }
                int i = 0;
                int n = 0;
                while (i < 4) {
                    if (super.A >= super.B && !this.S1()) {
                        this.f0(" in character escape sequence", JsonToken.VALUE_STRING);
                    }
                    final char c3 = this.Z[super.A++];
                    final int b = com.fasterxml.jackson.core.io.a.b(c3);
                    if (b < 0) {
                        this.l0(c3, "expected a hex-digit for character escape sequence");
                    }
                    n = (n << 4 | b);
                    ++i;
                }
                return (char)n;
            }
            else {
                c2 = '\b';
            }
        }
        return c2;
    }
    
    @Override
    protected void J0() throws IOException {
        if (this.Y != null) {
            if (super.y.l() || this.E(Feature.AUTO_CLOSE_SOURCE)) {
                this.Y.close();
            }
            this.Y = null;
        }
    }
    
    protected final void K1() throws IOException {
        int a = super.A;
        final int b = super.B;
        int a2 = a;
        if (a < b) {
            final int[] i0 = g.i0;
            final int length = i0.length;
            do {
                final char[] z = this.Z;
                final char c = z[a];
                if (c < length && i0[c] != 0) {
                    a2 = a;
                    if (c == '\"') {
                        final d k = super.K;
                        final int a3 = super.A;
                        k.z(z, a3, a - a3);
                        super.A = a + 1;
                        return;
                    }
                    break;
                }
                else {
                    a2 = a + 1;
                }
            } while ((a = a2) < b);
        }
        final d j = super.K;
        final char[] z2 = this.Z;
        final int a4 = super.A;
        j.x(z2, a4, a2 - a4);
        super.A = a2;
        this.L1();
    }
    
    protected void L1() throws IOException {
        char[] r = super.K.r();
        int s = super.K.s();
        final int[] i0 = g.i0;
        final int length = i0.length;
        while (true) {
            if (super.A >= super.B && !this.S1()) {
                this.f0(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
            }
            final char c = this.Z[super.A++];
            char f1;
            if ((f1 = c) < length) {
                f1 = c;
                if (i0[c] != 0) {
                    if (c == '\"') {
                        break;
                    }
                    if (c == '\\') {
                        f1 = this.F1();
                    }
                    else if ((f1 = c) < ' ') {
                        this.t0(c, "string value");
                        f1 = c;
                    }
                }
            }
            char[] p = r;
            int n;
            if ((n = s) >= r.length) {
                p = super.K.p();
                n = 0;
            }
            p[n] = f1;
            s = n + 1;
            r = p;
        }
        super.K.D(s);
    }
    
    protected final String M1(final JsonToken jsonToken) {
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
    
    protected JsonToken N1() throws IOException {
        char[] m = super.K.m();
        int s = super.K.s();
        while (true) {
            if (super.A >= super.B && !this.S1()) {
                this.f0(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
            }
            final char c = this.Z[super.A++];
            char f1;
            if ((f1 = c) <= '\\') {
                if (c == '\\') {
                    f1 = this.F1();
                }
                else if ((f1 = c) <= '\'') {
                    if (c == '\'') {
                        break;
                    }
                    if ((f1 = c) < ' ') {
                        this.t0(c, "string value");
                        f1 = c;
                    }
                }
            }
            char[] p = m;
            int n;
            if ((n = s) >= m.length) {
                p = super.K.p();
                n = 0;
            }
            p[n] = f1;
            s = n + 1;
            m = p;
        }
        super.K.D(s);
        return JsonToken.VALUE_STRING;
    }
    
    protected JsonToken O1(int n, final boolean b) throws IOException {
        int n2 = n;
        if (n == 73) {
            if (super.A >= super.B && !this.S1()) {
                this.g0(JsonToken.VALUE_NUMBER_INT);
            }
            final char[] z = this.Z;
            n = super.A++;
            n = z[n];
            double n3 = Double.NEGATIVE_INFINITY;
            if (n == 78) {
                String s;
                if (b) {
                    s = "-INF";
                }
                else {
                    s = "+INF";
                }
                this.V1(s, 3);
                if (this.E(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    if (!b) {
                        n3 = Double.POSITIVE_INFINITY;
                    }
                    return this.y1(s, n3);
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Non-standard token '");
                sb.append(s);
                sb.append("': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                this.Z(sb.toString());
                n2 = n;
            }
            else if ((n2 = n) == 110) {
                String s2;
                if (b) {
                    s2 = "-Infinity";
                }
                else {
                    s2 = "+Infinity";
                }
                this.V1(s2, 3);
                if (this.E(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                    if (!b) {
                        n3 = Double.POSITIVE_INFINITY;
                    }
                    return this.y1(s2, n3);
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Non-standard token '");
                sb2.append(s2);
                sb2.append("': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                this.Z(sb2.toString());
                n2 = n;
            }
        }
        this.G0(n2, "expected digit (0-9) to follow minus sign, for valid numeric value");
        return null;
    }
    
    protected String P1(int a) throws IOException {
        if (a == 39 && this.E(Feature.ALLOW_SINGLE_QUOTES)) {
            return this.Z1();
        }
        if (!this.E(Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            this.l0(a, "was expecting double-quote to start field name");
        }
        final int[] h = a.h();
        final int length = h.length;
        boolean javaIdentifierPart;
        if (a < length) {
            javaIdentifierPart = (h[a] == 0);
        }
        else {
            javaIdentifierPart = Character.isJavaIdentifierPart((char)a);
        }
        if (!javaIdentifierPart) {
            this.l0(a, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        final int a2 = super.A;
        int c0 = this.c0;
        final int b = super.B;
        int n = c0;
        if ((a = a2) < b) {
            a = a2;
            int n2;
            do {
                final char[] z = this.Z;
                final char c2 = z[a];
                if (c2 < length) {
                    if (h[c2] != 0) {
                        final int n3 = super.A - 1;
                        super.A = a;
                        return this.b0.o(z, n3, a - n3, c0);
                    }
                }
                else if (!Character.isJavaIdentifierPart(c2)) {
                    final int n4 = super.A - 1;
                    super.A = a;
                    return this.b0.o(this.Z, n4, a - n4, c0);
                }
                n = c0 * 33 + c2;
                n2 = a + 1;
                c0 = n;
            } while ((a = n2) < b);
            a = n2;
        }
        final int a3 = super.A;
        super.A = a;
        return this.Q1(a3 - 1, n, h);
    }
    
    protected JsonToken R1(int n) throws IOException {
        Label_0220: {
            if (n != 39) {
                if (n != 73) {
                    if (n != 78) {
                        if (n != 93) {
                            if (n == 43) {
                                if (super.A >= super.B && !this.S1()) {
                                    this.g0(JsonToken.VALUE_NUMBER_INT);
                                }
                                final char[] z = this.Z;
                                n = super.A++;
                                return this.O1(z[n], false);
                            }
                            if (n != 44) {
                                break Label_0220;
                            }
                        }
                        else if (!super.I.d()) {
                            break Label_0220;
                        }
                        if (this.E(Feature.ALLOW_MISSING_VALUES)) {
                            --super.A;
                            return JsonToken.VALUE_NULL;
                        }
                    }
                    else {
                        this.V1("NaN", 1);
                        if (this.E(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                            return this.y1("NaN", Double.NaN);
                        }
                        this.Z("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                    }
                }
                else {
                    this.V1("Infinity", 1);
                    if (this.E(Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                        return this.y1("Infinity", Double.POSITIVE_INFINITY);
                    }
                    this.Z("Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                }
            }
            else if (this.E(Feature.ALLOW_SINGLE_QUOTES)) {
                return this.N1();
            }
        }
        if (Character.isJavaIdentifierStart(n)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append((char)n);
            this.h2(sb.toString(), "('true', 'false' or 'null')");
        }
        this.l0(n, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }
    
    protected boolean S1() throws IOException {
        final int b = super.B;
        final long c = super.C;
        final long n = b;
        super.C = c + n;
        super.E -= b;
        this.e0 -= n;
        final Reader y = this.Y;
        if (y != null) {
            final char[] z = this.Z;
            final int read = y.read(z, 0, z.length);
            if (read > 0) {
                super.A = 0;
                super.B = read;
                return true;
            }
            this.J0();
            if (read == 0) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Reader returned 0 characters when trying to read ");
                sb.append(super.B);
                throw new IOException(sb.toString());
            }
        }
        return false;
    }
    
    protected final void V1(final String s, int n) throws IOException {
        final int length = s.length();
        int n2 = n;
        if (super.A + length >= super.B) {
            this.W1(s, n);
            return;
        }
        int a;
        do {
            if (this.Z[super.A] != s.charAt(n2)) {
                this.g2(s.substring(0, n2));
            }
            a = super.A + 1;
            super.A = a;
            n = n2 + 1;
        } while ((n2 = n) < length);
        final char c = this.Z[a];
        if (c >= '0' && c != ']' && c != '}') {
            this.C1(s, n, c);
        }
    }
    
    protected String Z1() throws IOException {
        final int a = super.A;
        final int c0 = this.c0;
        final int b = super.B;
        int a2 = a;
        int n = c0;
        Label_0131: {
            if (a < b) {
                final int[] i0 = g.i0;
                final int length = i0.length;
                n = c0;
                a2 = a;
                int j;
                int n2;
                do {
                    final char[] z = this.Z;
                    final char c2 = z[a2];
                    if (c2 == '\'') {
                        final int a3 = super.A;
                        super.A = a2 + 1;
                        return this.b0.o(z, a3, a2 - a3, n);
                    }
                    if (c2 < length && i0[c2] != 0) {
                        break Label_0131;
                    }
                    n2 = n * 33 + c2;
                    j = ++a2;
                    n = n2;
                } while (j < b);
                n = n2;
                a2 = j;
            }
        }
        final int a4 = super.A;
        super.A = a2;
        return this.c2(a4, n, 39);
    }
    
    @Override
    protected void a1() throws IOException {
        super.a1();
        this.b0.u();
        if (this.a0) {
            final char[] z = this.Z;
            if (z != null) {
                this.Z = null;
                super.y.p(z);
            }
        }
    }
    
    protected final String b2() throws IOException {
        int i = super.A;
        int c0 = this.c0;
        final int[] i2 = g.i0;
        while (i < super.B) {
            final char[] z = this.Z;
            final char c2 = z[i];
            if (c2 < i2.length && i2[c2] != 0) {
                if (c2 == '\"') {
                    final int a = super.A;
                    super.A = i + 1;
                    return this.b0.o(z, a, i - a, c0);
                }
                break;
            }
            else {
                c0 = c0 * 33 + c2;
                ++i;
            }
        }
        final int a2 = super.A;
        super.A = i;
        return this.c2(a2, c0, 34);
    }
    
    protected final JsonToken d2() throws IOException {
        final int a = super.A;
        final int n = a - 1;
        final int b = super.B;
        if (a >= b) {
            return this.e2(true, n);
        }
        final char[] z = this.Z;
        int i = a + 1;
        final char c = z[a];
        if (c > '9' || c < '0') {
            super.A = i;
            return this.O1(c, true);
        }
        if (c == '0') {
            return this.e2(true, n);
        }
        int n2 = 1;
        while (i < b) {
            final char[] z2 = this.Z;
            int n3 = i + 1;
            final char c2 = z2[i];
            if (c2 >= '0' && c2 <= '9') {
                ++n2;
                i = n3;
            }
            else {
                if (c2 != '.' && c2 != 'e' && c2 != 'E') {
                    --n3;
                    super.A = n3;
                    if (super.I.f()) {
                        this.y2(c2);
                    }
                    super.K.z(this.Z, n, n3 - n);
                    return this.B1(true, n2);
                }
                super.A = n3;
                return this.a2(c2, n, n3, true, n2);
            }
        }
        return this.e2(true, n);
    }
    
    @Override
    public JsonLocation e() {
        return new JsonLocation(this.L0(), -1L, super.A + super.C, super.D, super.A - super.E + 1);
    }
    
    protected final JsonToken f2(int n) throws IOException {
        int i = super.A;
        final int a = i - 1;
        final int b = super.B;
        if (n == 48) {
            return this.e2(false, a);
        }
        n = 1;
        while (i < b) {
            final char[] z = this.Z;
            int n2 = i + 1;
            final char c = z[i];
            if (c >= '0' && c <= '9') {
                ++n;
                i = n2;
            }
            else {
                if (c != '.' && c != 'e' && c != 'E') {
                    --n2;
                    super.A = n2;
                    if (super.I.f()) {
                        this.y2(c);
                    }
                    super.K.z(this.Z, a, n2 - a);
                    return this.B1(false, n);
                }
                super.A = n2;
                return this.a2(c, a, n2, false, n);
            }
        }
        super.A = a;
        return this.e2(false, a);
    }
    
    protected void g2(final String s) throws IOException {
        this.h2(s, "'null', 'true', 'false' or NaN");
    }
    
    protected void h2(final String s, final String s2) throws IOException {
        final StringBuilder sb = new StringBuilder(s);
        while (super.A < super.B || this.S1()) {
            final char c = this.Z[super.A];
            if (!Character.isJavaIdentifierPart(c)) {
                break;
            }
            ++super.A;
            sb.append(c);
            if (sb.length() >= 256) {
                sb.append("...");
                break;
            }
        }
        this.c0("Unrecognized token '%s': was expecting %s", sb, s2);
    }
    
    protected final void k2() throws IOException {
        if (super.A < super.B || this.S1()) {
            final char[] z = this.Z;
            final int a = super.A;
            if (z[a] == '\n') {
                super.A = a + 1;
            }
        }
        ++super.D;
        super.E = super.A;
    }
    
    protected final void q2() throws IOException {
        this.d0 = false;
        int n = super.A;
        int n2 = super.B;
        final char[] z = this.Z;
        while (true) {
            int a = n;
            int b = n2;
            if (n >= n2) {
                super.A = n;
                if (!this.S1()) {
                    this.f0(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
                }
                a = super.A;
                b = super.B;
            }
            n = a + 1;
            final char c = z[a];
            if (c <= '\\') {
                if (c == '\\') {
                    super.A = n;
                    this.F1();
                    n = super.A;
                    n2 = super.B;
                    continue;
                }
                if (c <= '\"') {
                    if (c == '\"') {
                        break;
                    }
                    if (c < ' ') {
                        super.A = n;
                        this.t0(c, "string value");
                    }
                }
            }
            n2 = b;
        }
        super.A = n;
    }
    
    @Override
    public final String u() throws IOException {
        final JsonToken c = super.c;
        if (c == JsonToken.VALUE_STRING) {
            if (this.d0) {
                this.d0 = false;
                this.K1();
            }
            return super.K.l();
        }
        return this.M1(c);
    }
    
    @Deprecated
    protected char z2(final String s) throws IOException {
        return this.A2(s, null);
    }
}
