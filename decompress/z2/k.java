// 
// Decompiled by Procyon v0.6.0
// 

package z2;

import com.fasterxml.jackson.core.b;
import com.fasterxml.jackson.core.d;
import com.fasterxml.jackson.core.JsonGenerator;
import java.math.BigInteger;
import java.math.BigDecimal;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.g;
import com.fasterxml.jackson.core.JsonGenerationException;
import java.io.IOException;
import com.fasterxml.jackson.core.io.a;
import java.io.Writer;
import com.fasterxml.jackson.core.e;

public class k extends c
{
    protected static final char[] H;
    protected char[] A;
    protected int B;
    protected int C;
    protected int D;
    protected char[] E;
    protected e F;
    protected char[] G;
    protected final Writer y;
    protected char z;
    
    static {
        H = com.fasterxml.jackson.core.io.a.d();
    }
    
    public k(final com.fasterxml.jackson.core.io.c c, final int n, final com.fasterxml.jackson.core.c c2, final Writer y) {
        super(c, n, c2);
        this.z = '\"';
        this.y = y;
        final char[] d = c.d();
        this.A = d;
        this.D = d.length;
    }
    
    private char[] C0() {
        return this.E = new char[] { '\\', '\0', '\\', 'u', '0', '0', '\0', '\0', '\\', 'u', '\0', '\0', '\0', '\0' };
    }
    
    private int G0(char[] array, int n, int n2, char c, int n3) throws IOException, JsonGenerationException {
        if (n3 >= 0) {
            if (n > 1 && n < n2) {
                n -= 2;
                array[n] = '\\';
                array[n + 1] = (char)n3;
            }
            else {
                if ((array = this.E) == null) {
                    array = this.C0();
                }
                array[1] = (char)n3;
                this.y.write(array, 0, 2);
            }
            return n;
        }
        if (n3 != -2) {
            if (n > 5 && n < n2) {
                n -= 6;
                n2 = n + 1;
                array[n] = '\\';
                n = n2 + 1;
                array[n2] = 'u';
                if (c > '\u00ff') {
                    n3 = (c >> 8 & 0xFF);
                    n2 = n + 1;
                    final char[] h = k.H;
                    array[n] = h[n3 >> 4];
                    n = n2 + 1;
                    array[n2] = h[n3 & 0xF];
                    c &= '\u00ff';
                }
                else {
                    n2 = n + 1;
                    array[n] = '0';
                    n = n2 + 1;
                    array[n2] = '0';
                }
                n2 = n + 1;
                final char[] h2 = k.H;
                array[n] = h2[c >> 4];
                array[n2] = h2[c & '\u000f'];
                n = n2 - 5;
            }
            else {
                if ((array = this.E) == null) {
                    array = this.C0();
                }
                this.B = this.C;
                if (c > '\u00ff') {
                    n2 = (c >> 8 & 0xFF);
                    final int n4 = c & '\u00ff';
                    final char[] h3 = k.H;
                    array[10] = h3[n2 >> 4];
                    array[11] = h3[n2 & 0xF];
                    array[12] = h3[n4 >> 4];
                    array[13] = h3[n4 & 0xF];
                    this.y.write(array, 8, 6);
                }
                else {
                    final char[] h4 = k.H;
                    array[6] = h4[c >> 4];
                    array[7] = h4[c & '\u000f'];
                    this.y.write(array, 2, 6);
                }
            }
            return n;
        }
        final e f = this.F;
        String s;
        if (f == null) {
            s = super.j.getEscapeSequence(c).getValue();
        }
        else {
            s = f.getValue();
            this.F = null;
        }
        final int length = s.length();
        if (n >= length && n < n2) {
            n -= length;
            s.getChars(0, length, array, n);
        }
        else {
            this.y.write(s);
        }
        return n;
    }
    
    private void J0(char c, int b) throws IOException, JsonGenerationException {
        if (b >= 0) {
            int c2 = this.C;
            if (c2 >= 2) {
                c2 -= 2;
                this.B = c2;
                final char[] a = this.A;
                a[c2] = '\\';
                a[c2 + 1] = (char)b;
                return;
            }
            char[] array;
            if ((array = this.E) == null) {
                array = this.C0();
            }
            this.B = this.C;
            array[1] = (char)b;
            this.y.write(array, 0, 2);
        }
        else if (b != -2) {
            b = this.C;
            if (b >= 6) {
                final char[] a2 = this.A;
                b -= 6;
                a2[this.B = b] = '\\';
                ++b;
                a2[b] = 'u';
                if (c > '\u00ff') {
                    final int n = c >> 8 & 0xFF;
                    ++b;
                    final char[] h = k.H;
                    a2[b] = h[n >> 4];
                    ++b;
                    a2[b] = h[n & 0xF];
                    c &= '\u00ff';
                }
                else {
                    ++b;
                    a2[b] = '0';
                    ++b;
                    a2[b] = '0';
                }
                ++b;
                final char[] h2 = k.H;
                a2[b] = h2[c >> 4];
                a2[b + 1] = h2[c & '\u000f'];
                return;
            }
            char[] array2;
            if ((array2 = this.E) == null) {
                array2 = this.C0();
            }
            this.B = this.C;
            if (c > '\u00ff') {
                b = (c >> 8 & 0xFF);
                final int n2 = c & '\u00ff';
                final char[] h3 = k.H;
                array2[10] = h3[b >> 4];
                array2[11] = h3[b & 0xF];
                array2[12] = h3[n2 >> 4];
                array2[13] = h3[n2 & 0xF];
                this.y.write(array2, 8, 6);
            }
            else {
                final char[] h4 = k.H;
                array2[6] = h4[c >> 4];
                array2[7] = h4[c & '\u000f'];
                this.y.write(array2, 2, 6);
            }
        }
        else {
            final e f = this.F;
            String s;
            if (f == null) {
                s = super.j.getEscapeSequence(c).getValue();
            }
            else {
                s = f.getValue();
                this.F = null;
            }
            final int length = s.length();
            b = this.C;
            if (b >= length) {
                b -= length;
                this.B = b;
                s.getChars(0, length, this.A, b);
                return;
            }
            this.B = b;
            this.y.write(s);
        }
    }
    
    private void R0(final String s) throws IOException {
        this.F0();
        final int length = s.length();
        int n = 0;
        while (true) {
            int d;
            if (n + (d = this.D) > length) {
                d = length - n;
            }
            final int n2 = n + d;
            s.getChars(n, n2, this.A, 0);
            if (super.j != null) {
                this.n1(d);
            }
            else {
                final int i = super.i;
                if (i != 0) {
                    this.k1(d, i);
                }
                else {
                    this.h1(d);
                }
            }
            if (n2 >= length) {
                break;
            }
            n = n2;
        }
    }
    
    private final void S0() throws IOException {
        if (this.C + 4 >= this.D) {
            this.F0();
        }
        int c = this.C;
        final char[] a = this.A;
        a[c] = 'n';
        ++c;
        a[c] = 'u';
        ++c;
        a[c] = 'l';
        ++c;
        a[c] = 'l';
        this.C = c + 1;
    }
    
    private void a1(int p) throws IOException {
        if (this.C + 13 >= this.D) {
            this.F0();
        }
        final char[] a = this.A;
        final int c = this.C;
        final int c2 = c + 1;
        this.C = c2;
        a[c] = this.z;
        p = com.fasterxml.jackson.core.io.g.p(p, a, c2);
        final char[] a2 = this.A;
        this.C = p + 1;
        a2[p] = this.z;
    }
    
    private void d1(final long n) throws IOException {
        if (this.C + 23 >= this.D) {
            this.F0();
        }
        final char[] a = this.A;
        final int c = this.C;
        final int c2 = c + 1;
        this.C = c2;
        a[c] = this.z;
        final int r = com.fasterxml.jackson.core.io.g.r(n, a, c2);
        final char[] a2 = this.A;
        this.C = r + 1;
        a2[r] = this.z;
    }
    
    private void g1(final String s) throws IOException {
        if (this.C >= this.D) {
            this.F0();
        }
        this.A[this.C++] = this.z;
        this.V(s);
        if (this.C >= this.D) {
            this.F0();
        }
        this.A[this.C++] = this.z;
    }
    
    private void h1(final int n) throws IOException {
        final int[] h = super.h;
        final int length = h.length;
        int i = 0;
        int g0 = 0;
    Label_0120:
        while (i < n) {
            while (true) {
                int n2;
                do {
                    final char[] a = this.A;
                    final char c = a[i];
                    if (c < length && h[c] != 0) {
                        final int n3 = i - g0;
                        if (n3 > 0) {
                            this.y.write(a, g0, n3);
                            if (i >= n) {
                                break Label_0120;
                            }
                        }
                        ++i;
                        g0 = this.G0(this.A, i, n, c, h[c]);
                        continue Label_0120;
                    }
                    n2 = i + 1;
                } while ((i = n2) < n);
                i = n2;
                continue;
            }
        }
    }
    
    private void k1(final int n, final int n2) throws IOException, JsonGenerationException {
        final int[] h = super.h;
        final int min = Math.min(h.length, n2 + 1);
        int i = 0;
        int g0 = 0;
        int n3 = 0;
    Label_0131_Outer:
        while (i < n) {
            int n4 = n3;
            int n5 = i;
        Label_0131:
            while (true) {
                int j;
                int n7;
                do {
                    final char[] a = this.A;
                    final char c = a[n5];
                    if (c < min) {
                        final int n6 = h[c];
                        if ((n7 = n6) != 0) {
                            j = n5;
                            n3 = n6;
                            break Label_0131;
                        }
                    }
                    else {
                        n7 = n4;
                        if (c > n2) {
                            final int n8 = -1;
                            j = n5;
                            n3 = n8;
                            break Label_0131;
                        }
                    }
                    j = ++n5;
                    n4 = n7;
                    continue Label_0131_Outer;
                    final int n9 = j - g0;
                    if (n9 > 0) {
                        this.y.write(a, g0, n9);
                        if (j >= n) {
                            break Label_0131_Outer;
                        }
                    }
                    i = j + 1;
                    g0 = this.G0(this.A, i, n, c, n3);
                    continue Label_0131_Outer;
                } while (j < n);
                n3 = n7;
                continue Label_0131;
            }
        }
    }
    
    private void n1(final int n) throws IOException, JsonGenerationException {
        final int[] h = super.h;
        int i;
        if ((i = super.i) < 1) {
            i = 65535;
        }
        final int min = Math.min(h.length, i + '\u0001');
        final CharacterEscapes j = super.j;
        int k = 0;
        int g0 = 0;
        int n2 = 0;
    Label_0177_Outer:
        while (k < n) {
            int n3 = n2;
            int n4 = k;
        Label_0177:
            while (true) {
                int l;
                int n6;
                do {
                    final char c = this.A[n4];
                    if (c < min) {
                        final int n5 = h[c];
                        if ((n6 = n5) != 0) {
                            k = n4;
                            n2 = n5;
                            break Label_0177;
                        }
                    }
                    else {
                        if (c > i) {
                            final int n7 = -1;
                            k = n4;
                            n2 = n7;
                            break Label_0177;
                        }
                        final e escapeSequence = j.getEscapeSequence(c);
                        this.F = escapeSequence;
                        n6 = n3;
                        if (escapeSequence != null) {
                            final int n8 = -2;
                            k = n4;
                            n2 = n8;
                            break Label_0177;
                        }
                    }
                    l = ++n4;
                    n3 = n6;
                    continue Label_0177_Outer;
                    final int n9 = k - g0;
                    if (n9 > 0) {
                        this.y.write(this.A, g0, n9);
                        if (k >= n) {
                            break Label_0177_Outer;
                        }
                    }
                    ++k;
                    g0 = this.G0(this.A, k, n, c, n2);
                    continue Label_0177_Outer;
                } while (l < n);
                n2 = n6;
                k = l;
                continue Label_0177;
            }
        }
    }
    
    private void p1(final String s) throws IOException {
        final int length = s.length();
        final int d = this.D;
        if (length > d) {
            this.R0(s);
            return;
        }
        if (this.C + length > d) {
            this.F0();
        }
        s.getChars(0, length, this.A, this.C);
        if (super.j != null) {
            this.w1(length);
        }
        else {
            final int i = super.i;
            if (i != 0) {
                this.s1(length, i);
            }
            else {
                this.r1(length);
            }
        }
    }
    
    private void r1(int length) throws IOException {
        final int n = this.C + length;
        final int[] h = super.h;
        length = h.length;
    Label_0017:
        while (this.C < n) {
            int c;
            do {
                final char[] a = this.A;
                c = this.C;
                final char c2 = a[c];
                if (c2 < length && h[c2] != 0) {
                    final int b = this.B;
                    final int n2 = c - b;
                    if (n2 > 0) {
                        this.y.write(a, b, n2);
                    }
                    final char c3 = this.A[this.C++];
                    this.J0(c3, h[c3]);
                    continue Label_0017;
                }
            } while ((this.C = c + 1) < n);
            break;
        }
    }
    
    private void s1(int c, final int n) throws IOException, JsonGenerationException {
        final int n2 = this.C + c;
        final int[] h = super.h;
        final int min = Math.min(h.length, n + 1);
    Label_0025:
        while (this.C < n2) {
            do {
                final char[] a = this.A;
                final int c2 = this.C;
                final char c3 = a[c2];
                Label_0077: {
                    if (c3 < min) {
                        c = h[c3];
                        if (c != 0) {
                            break Label_0077;
                        }
                    }
                    else if (c3 > n) {
                        c = -1;
                        break Label_0077;
                    }
                    c = c2 + 1;
                    continue;
                }
                final int b = this.B;
                final int n3 = c2 - b;
                if (n3 > 0) {
                    this.y.write(a, b, n3);
                }
                ++this.C;
                this.J0(c3, c);
                continue Label_0025;
            } while ((this.C = c) < n2);
            break;
        }
    }
    
    private void w1(int c) throws IOException, JsonGenerationException {
        final int n = this.C + c;
        final int[] h = super.h;
        int i;
        c = (i = super.i);
        if (c < 1) {
            i = 65535;
        }
        final int min = Math.min(h.length, i + '\u0001');
        final CharacterEscapes j = super.j;
    Label_0046:
        while (this.C < n) {
            do {
                final char c2 = this.A[this.C];
                Label_0115: {
                    if (c2 < min) {
                        c = h[c2];
                        if (c != 0) {
                            break Label_0115;
                        }
                    }
                    else {
                        if (c2 > i) {
                            c = -1;
                            break Label_0115;
                        }
                        if ((this.F = j.getEscapeSequence(c2)) != null) {
                            c = -2;
                            break Label_0115;
                        }
                    }
                    c = this.C + 1;
                    continue;
                }
                final int c3 = this.C;
                final int b = this.B;
                final int n2 = c3 - b;
                if (n2 > 0) {
                    this.y.write(this.A, b, n2);
                }
                ++this.C;
                this.J0(c2, c);
                continue Label_0046;
            } while ((this.C = c) < n);
            break;
        }
    }
    
    private void y1(final String s) throws IOException {
        final int d = this.D;
        final int c = this.C;
        int n = d - c;
        s.getChars(0, n, this.A, c);
        this.C += n;
        this.F0();
        int c2 = s.length() - n;
        while (true) {
            final int d2 = this.D;
            if (c2 <= d2) {
                break;
            }
            final int n2 = n + d2;
            s.getChars(n, n2, this.A, 0);
            this.B = 0;
            this.C = d2;
            this.F0();
            c2 -= d2;
            n = n2;
        }
        s.getChars(n, n + c2, this.A, 0);
        this.B = 0;
        this.C = c2;
    }
    
    @Override
    public void E(final long n) throws IOException {
        this.L0("write a number");
        if (super.c) {
            this.d1(n);
            return;
        }
        if (this.C + 21 >= this.D) {
            this.F0();
        }
        this.C = com.fasterxml.jackson.core.io.g.r(n, this.A, this.C);
    }
    
    @Override
    public void F(final BigDecimal bigDecimal) throws IOException {
        this.L0("write a number");
        if (bigDecimal == null) {
            this.S0();
        }
        else if (super.c) {
            this.g1(this.e0(bigDecimal));
        }
        else {
            this.V(this.e0(bigDecimal));
        }
    }
    
    protected void F0() throws IOException {
        final int c = this.C;
        final int b = this.B;
        final int n = c - b;
        if (n > 0) {
            this.B = 0;
            this.C = 0;
            this.y.write(this.A, b, n);
        }
    }
    
    protected void K0() {
        final char[] a = this.A;
        if (a != null) {
            this.A = null;
            super.g.m(a);
        }
        final char[] g = this.G;
        if (g != null) {
            this.G = null;
            super.g.n(g);
        }
    }
    
    @Override
    public void L(final BigInteger bigInteger) throws IOException {
        this.L0("write a number");
        if (bigInteger == null) {
            this.S0();
        }
        else if (super.c) {
            this.g1(bigInteger.toString());
        }
        else {
            this.V(bigInteger.toString());
        }
    }
    
    protected final void L0(final String s) throws IOException {
        final int o = super.d.o();
        if (super.a != null) {
            this.r0(s, o);
            return;
        }
        char c;
        if (o != 1) {
            if (o != 2) {
                if (o == 3) {
                    final e p = super.p;
                    if (p != null) {
                        this.V(p.getValue());
                    }
                    return;
                }
                if (o != 5) {
                    return;
                }
                this.m0(s);
                return;
            }
            else {
                c = ':';
            }
        }
        else {
            c = ',';
        }
        if (this.C >= this.D) {
            this.F0();
        }
        this.A[this.C++] = c;
    }
    
    @Override
    public void M(final char c) throws IOException {
        if (this.C >= this.D) {
            this.F0();
        }
        this.A[this.C++] = c;
    }
    
    protected final void N0(final String s, final boolean b) throws IOException {
        if (super.a != null) {
            this.Y0(s, b);
            return;
        }
        if (this.C + 1 >= this.D) {
            this.F0();
        }
        if (b) {
            this.A[this.C++] = ',';
        }
        if (super.w) {
            this.p1(s);
            return;
        }
        this.A[this.C++] = this.z;
        this.p1(s);
        if (this.C >= this.D) {
            this.F0();
        }
        this.A[this.C++] = this.z;
    }
    
    @Override
    public void O(final e e) throws IOException {
        this.V(e.getValue());
    }
    
    @Override
    public void V(final String s) throws IOException {
        final int length = s.length();
        int n;
        if ((n = this.D - this.C) == 0) {
            this.F0();
            n = this.D - this.C;
        }
        if (n >= length) {
            s.getChars(0, length, this.A, this.C);
            this.C += length;
        }
        else {
            this.y1(s);
        }
    }
    
    @Override
    public void W(final char[] array, final int n, final int n2) throws IOException {
        if (n2 < 32) {
            if (n2 > this.D - this.C) {
                this.F0();
            }
            System.arraycopy(array, n, this.A, this.C, n2);
            this.C += n2;
            return;
        }
        this.F0();
        this.y.write(array, n, n2);
    }
    
    protected final void Y0(final String s, final boolean b) throws IOException {
        if (b) {
            super.a.writeObjectEntrySeparator(this);
        }
        else {
            super.a.beforeObjectEntries(this);
        }
        if (super.w) {
            this.p1(s);
        }
        else {
            if (this.C >= this.D) {
                this.F0();
            }
            this.A[this.C++] = this.z;
            this.p1(s);
            if (this.C >= this.D) {
                this.F0();
            }
            this.A[this.C++] = this.z;
        }
    }
    
    @Override
    public void Z() throws IOException {
        this.L0("start an array");
        super.d = super.d.j();
        final d a = super.a;
        if (a != null) {
            a.writeStartArray(this);
        }
        else {
            if (this.C >= this.D) {
                this.F0();
            }
            this.A[this.C++] = '[';
        }
    }
    
    @Override
    public void a0() throws IOException {
        this.L0("start an object");
        super.d = super.d.k();
        final d a = super.a;
        if (a != null) {
            a.writeStartObject(this);
        }
        else {
            if (this.C >= this.D) {
                this.F0();
            }
            this.A[this.C++] = '{';
        }
    }
    
    @Override
    public void c0(final String s) throws IOException {
        this.L0("write a string");
        if (s == null) {
            this.S0();
            return;
        }
        if (this.C >= this.D) {
            this.F0();
        }
        this.A[this.C++] = this.z;
        this.p1(s);
        if (this.C >= this.D) {
            this.F0();
        }
        this.A[this.C++] = this.z;
    }
    
    @Override
    public void close() throws IOException {
        super.close();
        if (this.A != null && this.l0(Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                final b i0 = this.i0();
                if (i0.d()) {
                    this.j();
                }
                else {
                    if (!i0.e()) {
                        break;
                    }
                    this.k();
                }
            }
        }
        this.F0();
        this.B = 0;
        this.C = 0;
        if (this.y != null) {
            if (!super.g.l() && !this.l0(Feature.AUTO_CLOSE_TARGET)) {
                if (this.l0(Feature.FLUSH_PASSED_TO_STREAM)) {
                    this.y.flush();
                }
            }
            else {
                this.y.close();
            }
        }
        this.K0();
    }
    
    @Override
    public void flush() throws IOException {
        this.F0();
        if (this.y != null && this.l0(Feature.FLUSH_PASSED_TO_STREAM)) {
            this.y.flush();
        }
    }
    
    @Override
    public void i(final boolean b) throws IOException {
        this.L0("write a boolean value");
        if (this.C + 5 >= this.D) {
            this.F0();
        }
        int c = this.C;
        final char[] a = this.A;
        if (b) {
            a[c] = 't';
            ++c;
            a[c] = 'r';
            ++c;
            a[c] = 'u';
            ++c;
            a[c] = 'e';
        }
        else {
            a[c] = 'f';
            ++c;
            a[c] = 'a';
            ++c;
            a[c] = 'l';
            ++c;
            a[c] = 's';
            ++c;
            a[c] = 'e';
        }
        this.C = c + 1;
    }
    
    @Override
    public void j() throws IOException {
        if (!super.d.d()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Current context not Array but ");
            sb.append(super.d.g());
            this.a(sb.toString());
        }
        final d a = super.a;
        if (a != null) {
            a.writeEndArray(this, super.d.c());
        }
        else {
            if (this.C >= this.D) {
                this.F0();
            }
            this.A[this.C++] = ']';
        }
        super.d = super.d.i();
    }
    
    @Override
    public void k() throws IOException {
        if (!super.d.e()) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Current context not Object but ");
            sb.append(super.d.g());
            this.a(sb.toString());
        }
        final d a = super.a;
        if (a != null) {
            a.writeEndObject(this, super.d.c());
        }
        else {
            if (this.C >= this.D) {
                this.F0();
            }
            this.A[this.C++] = '}';
        }
        super.d = super.d.i();
    }
    
    @Override
    public void l(final String s) throws IOException {
        final int n = super.d.n(s);
        if (n == 4) {
            this.a("Can not write a field name, expecting a value");
        }
        boolean b = true;
        if (n != 1) {
            b = false;
        }
        this.N0(s, b);
    }
    
    @Override
    public void r() throws IOException {
        this.L0("write a null");
        this.S0();
    }
    
    @Override
    public void s(final double n) throws IOException {
        Label_0049: {
            if (!super.c) {
                if (this.l0(Feature.QUOTE_NON_NUMERIC_NUMBERS)) {
                    if (Double.isNaN(n)) {
                        break Label_0049;
                    }
                    if (Double.isInfinite(n)) {
                        break Label_0049;
                    }
                }
                this.L0("write a number");
                this.V(String.valueOf(n));
                return;
            }
        }
        this.c0(String.valueOf(n));
    }
    
    @Override
    public void t(final float n) throws IOException {
        Label_0049: {
            if (!super.c) {
                if (this.l0(Feature.QUOTE_NON_NUMERIC_NUMBERS)) {
                    if (Float.isNaN(n)) {
                        break Label_0049;
                    }
                    if (Float.isInfinite(n)) {
                        break Label_0049;
                    }
                }
                this.L0("write a number");
                this.V(String.valueOf(n));
                return;
            }
        }
        this.c0(String.valueOf(n));
    }
    
    @Override
    public void u(final int n) throws IOException {
        this.L0("write a number");
        if (super.c) {
            this.a1(n);
            return;
        }
        if (this.C + 11 >= this.D) {
            this.F0();
        }
        this.C = com.fasterxml.jackson.core.io.g.p(n, this.A, this.C);
    }
}
