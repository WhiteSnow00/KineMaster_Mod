// 
// Decompiled by Procyon v0.6.0
// 

package z2;

import com.fasterxml.jackson.core.b;
import com.fasterxml.jackson.core.d;
import java.math.BigInteger;
import java.math.BigDecimal;
import com.fasterxml.jackson.core.io.g;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.JsonGenerationException;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.a;
import java.io.OutputStream;

public class i extends c
{
    private static final byte[] H;
    private static final byte[] I;
    private static final byte[] J;
    private static final byte[] K;
    protected byte[] A;
    protected int B;
    protected final int C;
    protected final int D;
    protected char[] E;
    protected final int F;
    protected boolean G;
    protected final OutputStream y;
    protected byte z;
    
    static {
        H = com.fasterxml.jackson.core.io.a.c();
        I = new byte[] { 110, 117, 108, 108 };
        J = new byte[] { 116, 114, 117, 101 };
        K = new byte[] { 102, 97, 108, 115, 101 };
    }
    
    public i(final com.fasterxml.jackson.core.io.c c, int length, final com.fasterxml.jackson.core.c c2, final OutputStream y) {
        super(c, length, c2);
        this.z = 34;
        this.y = y;
        this.G = true;
        final byte[] h = c.h();
        this.A = h;
        length = h.length;
        this.C = length;
        this.D = length >> 3;
        final char[] d = c.d();
        this.E = d;
        this.F = d.length;
        if (this.l0(Feature.ESCAPE_NON_ASCII)) {
            this.y0(127);
        }
    }
    
    private final void A1(final String s, int b, final int n) throws IOException {
        if (this.B + (n - b) * 6 > this.C) {
            this.C0();
        }
        final int b2 = this.B;
        final byte[] a = this.A;
        final int[] h = super.h;
        int i = b;
        b = b2;
        while (i < n) {
            final int n2 = i + 1;
            final char char1 = s.charAt(i);
            if (char1 <= '\u007f') {
                if (h[char1] == 0) {
                    a[b] = (byte)char1;
                    i = n2;
                    ++b;
                    continue;
                }
                final int n3 = h[char1];
                if (n3 > 0) {
                    final int n4 = b + 1;
                    a[b] = 92;
                    b = n4 + 1;
                    a[n4] = (byte)n3;
                }
                else {
                    b = this.d1(char1, b);
                }
            }
            else if (char1 <= '\u07ff') {
                final int n5 = b + 1;
                a[b] = (byte)(char1 >> 6 | 0xC0);
                b = n5 + 1;
                a[n5] = (byte)((char1 & '?') | 0x80);
            }
            else {
                b = this.G0(char1, b);
            }
            i = n2;
        }
        this.B = b;
    }
    
    private final void B1(final char[] array, int b, final int n) throws IOException {
        if (this.B + (n - b) * 6 > this.C) {
            this.C0();
        }
        final int b2 = this.B;
        final byte[] a = this.A;
        final int[] h = super.h;
        int i = b;
        b = b2;
        while (i < n) {
            final int n2 = i + 1;
            final char c = array[i];
            if (c <= '\u007f') {
                if (h[c] == 0) {
                    a[b] = (byte)c;
                    i = n2;
                    ++b;
                    continue;
                }
                final int n3 = h[c];
                if (n3 > 0) {
                    final int n4 = b + 1;
                    a[b] = 92;
                    b = n4 + 1;
                    a[n4] = (byte)n3;
                }
                else {
                    b = this.d1(c, b);
                }
            }
            else if (c <= '\u07ff') {
                final int n5 = b + 1;
                a[b] = (byte)(c >> 6 | 0xC0);
                b = n5 + 1;
                a[n5] = (byte)((c & '?') | 0x80);
            }
            else {
                b = this.G0(c, b);
            }
            i = n2;
        }
        this.B = b;
    }
    
    private final void C1(final String s, int b, final int n) throws IOException {
        if (this.B + (n - b) * 6 > this.C) {
            this.C0();
        }
        final int b2 = this.B;
        final byte[] a = this.A;
        final int[] h = super.h;
        final int i = super.i;
        int j = b;
        b = b2;
        while (j < n) {
            final int n2 = j + 1;
            final char char1 = s.charAt(j);
            if (char1 <= '\u007f') {
                if (h[char1] == 0) {
                    a[b] = (byte)char1;
                    j = n2;
                    ++b;
                    continue;
                }
                final int n3 = h[char1];
                if (n3 > 0) {
                    final int n4 = b + 1;
                    a[b] = 92;
                    b = n4 + 1;
                    a[n4] = (byte)n3;
                }
                else {
                    b = this.d1(char1, b);
                }
            }
            else if (char1 > i) {
                b = this.d1(char1, b);
            }
            else if (char1 <= '\u07ff') {
                final int n5 = b + 1;
                a[b] = (byte)(char1 >> 6 | 0xC0);
                b = n5 + 1;
                a[n5] = (byte)((char1 & '?') | 0x80);
            }
            else {
                b = this.G0(char1, b);
            }
            j = n2;
        }
        this.B = b;
    }
    
    private final void E1(final char[] array, int b, final int n) throws IOException {
        if (this.B + (n - b) * 6 > this.C) {
            this.C0();
        }
        final int b2 = this.B;
        final byte[] a = this.A;
        final int[] h = super.h;
        final int i = super.i;
        int j = b;
        b = b2;
        while (j < n) {
            final int n2 = j + 1;
            final char c = array[j];
            if (c <= '\u007f') {
                if (h[c] == 0) {
                    a[b] = (byte)c;
                    j = n2;
                    ++b;
                    continue;
                }
                final int n3 = h[c];
                if (n3 > 0) {
                    final int n4 = b + 1;
                    a[b] = 92;
                    b = n4 + 1;
                    a[n4] = (byte)n3;
                }
                else {
                    b = this.d1(c, b);
                }
            }
            else if (c > i) {
                b = this.d1(c, b);
            }
            else if (c <= '\u07ff') {
                final int n5 = b + 1;
                a[b] = (byte)(c >> 6 | 0xC0);
                b = n5 + 1;
                a[n5] = (byte)((c & '?') | 0x80);
            }
            else {
                b = this.G0(c, b);
            }
            j = n2;
        }
        this.B = b;
    }
    
    private final int F0(final byte[] array, int b, final int n, final byte[] array2, final int n2) throws IOException, JsonGenerationException {
        final int length = array2.length;
        int n3 = b;
        if (b + length > n) {
            this.B = b;
            this.C0();
            b = this.B;
            if (length > array.length) {
                this.y.write(array2, 0, length);
                return b;
            }
            System.arraycopy(array2, 0, array, b, length);
            n3 = b + length;
        }
        if (n2 * 6 + n3 > n) {
            this.C0();
            return this.B;
        }
        return n3;
    }
    
    private final void F1(final String s, int n, int n2) throws IOException {
        int min;
        do {
            min = Math.min(this.D, n2);
            if (this.B + min > this.C) {
                this.C0();
            }
            this.w1(s, n, min);
            n += min;
        } while ((n2 -= min) > 0);
    }
    
    private final int G0(int n, int n2) throws IOException {
        final byte[] a = this.A;
        if (n >= 55296 && n <= 57343) {
            final int n3 = n2 + 1;
            a[n2] = 92;
            final int n4 = n3 + 1;
            a[n3] = 117;
            n2 = n4 + 1;
            final byte[] h = i.H;
            a[n4] = h[n >> 12 & 0xF];
            final int n5 = n2 + 1;
            a[n2] = h[n >> 8 & 0xF];
            final int n6 = n5 + 1;
            a[n5] = h[n >> 4 & 0xF];
            n2 = n6 + 1;
            a[n6] = h[n & 0xF];
            n = n2;
        }
        else {
            final int n7 = n2 + 1;
            a[n2] = (byte)(n >> 12 | 0xE0);
            n2 = n7 + 1;
            a[n7] = (byte)((n >> 6 & 0x3F) | 0x80);
            a[n2] = (byte)((n & 0x3F) | 0x80);
            n = n2 + 1;
        }
        return n;
    }
    
    private final int J0(final int n, final char[] array, final int n2, int b) throws IOException {
        if (n >= 55296 && n <= 57343) {
            if (n2 >= b || array == null) {
                this.a(String.format("Split surrogate on writeRaw() input (last character): first character 0x%4x", n));
            }
            this.K0(n, array[n2]);
            return n2 + 1;
        }
        final byte[] a = this.A;
        final int b2 = this.B;
        b = b2 + 1;
        this.B = b;
        a[b2] = (byte)(n >> 12 | 0xE0);
        final int b3 = b + 1;
        this.B = b3;
        a[b] = (byte)((n >> 6 & 0x3F) | 0x80);
        this.B = b3 + 1;
        a[b3] = (byte)((n & 0x3F) | 0x80);
        return n2;
    }
    
    private final void K1(final String s, final boolean b) throws IOException {
        if (b) {
            if (this.B >= this.C) {
                this.C0();
            }
            this.A[this.B++] = this.z;
        }
        int i = s.length();
        int n = 0;
        while (i > 0) {
            final int min = Math.min(this.D, i);
            if (this.B + min > this.C) {
                this.C0();
            }
            this.w1(s, n, min);
            n += min;
            i -= min;
        }
        if (b) {
            if (this.B >= this.C) {
                this.C0();
            }
            this.A[this.B++] = this.z;
        }
    }
    
    private final void L1(final char[] array, int n, int n2) throws IOException {
        int min;
        do {
            min = Math.min(this.D, n2);
            if (this.B + min > this.C) {
                this.C0();
            }
            this.y1(array, n, min);
            n += min;
        } while ((n2 -= min) > 0);
    }
    
    private final void R0(final byte[] array) throws IOException {
        final int length = array.length;
        if (this.B + length > this.C) {
            this.C0();
            if (length > 512) {
                this.y.write(array, 0, length);
                return;
            }
        }
        System.arraycopy(array, 0, this.A, this.B, length);
        this.B += length;
    }
    
    private final int S0(final byte[] array, final int n, final e e, final int n2) throws IOException, JsonGenerationException {
        final byte[] unquotedUTF8 = e.asUnquotedUTF8();
        final int length = unquotedUTF8.length;
        if (length > 6) {
            return this.F0(array, n, this.C, unquotedUTF8, n2);
        }
        System.arraycopy(unquotedUTF8, 0, array, n, length);
        return n + length;
    }
    
    private final void Y0(final String s, int b, final int n) throws IOException {
        if (this.B + (n - b) * 6 > this.C) {
            this.C0();
        }
        final int b2 = this.B;
        final byte[] a = this.A;
        final int[] h = super.h;
        int i;
        if ((i = super.i) <= 0) {
            i = 65535;
        }
        final CharacterEscapes j = super.j;
        int k = b;
        b = b2;
        while (k < n) {
            final int n2 = k + 1;
            final char char1 = s.charAt(k);
            if (char1 <= '\u007f') {
                if (h[char1] == 0) {
                    a[b] = (byte)char1;
                    k = n2;
                    ++b;
                    continue;
                }
                final int n3 = h[char1];
                if (n3 > 0) {
                    final int n4 = b + 1;
                    a[b] = 92;
                    b = n4 + 1;
                    a[n4] = (byte)n3;
                }
                else if (n3 == -2) {
                    final e escapeSequence = j.getEscapeSequence(char1);
                    if (escapeSequence == null) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Invalid custom escape definitions; custom escape not found for character code 0x");
                        sb.append(Integer.toHexString(char1));
                        sb.append(", although was supposed to have one");
                        this.a(sb.toString());
                    }
                    b = this.S0(a, b, escapeSequence, n - n2);
                }
                else {
                    b = this.d1(char1, b);
                }
            }
            else if (char1 > i) {
                b = this.d1(char1, b);
            }
            else {
                final e escapeSequence2 = j.getEscapeSequence(char1);
                if (escapeSequence2 != null) {
                    b = this.S0(a, b, escapeSequence2, n - n2);
                }
                else if (char1 <= '\u07ff') {
                    final int n5 = b + 1;
                    a[b] = (byte)(char1 >> 6 | 0xC0);
                    b = n5 + 1;
                    a[n5] = (byte)((char1 & '?') | 0x80);
                }
                else {
                    b = this.G0(char1, b);
                }
            }
            k = n2;
        }
        this.B = b;
    }
    
    private final void a1(final char[] array, int b, final int n) throws IOException {
        if (this.B + (n - b) * 6 > this.C) {
            this.C0();
        }
        final int b2 = this.B;
        final byte[] a = this.A;
        final int[] h = super.h;
        int i;
        if ((i = super.i) <= 0) {
            i = 65535;
        }
        final CharacterEscapes j = super.j;
        int k = b;
        b = b2;
        while (k < n) {
            final int n2 = k + 1;
            final char c = array[k];
            if (c <= '\u007f') {
                if (h[c] == 0) {
                    a[b] = (byte)c;
                    k = n2;
                    ++b;
                    continue;
                }
                final int n3 = h[c];
                if (n3 > 0) {
                    final int n4 = b + 1;
                    a[b] = 92;
                    b = n4 + 1;
                    a[n4] = (byte)n3;
                }
                else if (n3 == -2) {
                    final e escapeSequence = j.getEscapeSequence(c);
                    if (escapeSequence == null) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Invalid custom escape definitions; custom escape not found for character code 0x");
                        sb.append(Integer.toHexString(c));
                        sb.append(", although was supposed to have one");
                        this.a(sb.toString());
                    }
                    b = this.S0(a, b, escapeSequence, n - n2);
                }
                else {
                    b = this.d1(c, b);
                }
            }
            else if (c > i) {
                b = this.d1(c, b);
            }
            else {
                final e escapeSequence2 = j.getEscapeSequence(c);
                if (escapeSequence2 != null) {
                    b = this.S0(a, b, escapeSequence2, n - n2);
                }
                else if (c <= '\u07ff') {
                    final int n5 = b + 1;
                    a[b] = (byte)(c >> 6 | 0xC0);
                    b = n5 + 1;
                    a[n5] = (byte)((c & '?') | 0x80);
                }
                else {
                    b = this.G0(c, b);
                }
            }
            k = n2;
        }
        this.B = b;
    }
    
    private int d1(int n, int n2) throws IOException {
        final byte[] a = this.A;
        final int n3 = n2 + 1;
        a[n2] = 92;
        n2 = n3 + 1;
        a[n3] = 117;
        if (n > 255) {
            final int n4 = 0xFF & n >> 8;
            final int n5 = n2 + 1;
            final byte[] h = i.H;
            a[n2] = h[n4 >> 4];
            n2 = n5 + 1;
            a[n5] = h[n4 & 0xF];
            n &= 0xFF;
        }
        else {
            final int n6 = n2 + 1;
            a[n2] = 48;
            n2 = n6 + 1;
            a[n6] = 48;
        }
        final int n7 = n2 + 1;
        final byte[] h2 = i.H;
        a[n2] = h2[n >> 4];
        a[n7] = h2[n & 0xF];
        return n7 + 1;
    }
    
    private final void g1() throws IOException {
        if (this.B + 4 >= this.C) {
            this.C0();
        }
        System.arraycopy(i.I, 0, this.A, this.B, 4);
        this.B += 4;
    }
    
    private final void k1(int o) throws IOException {
        if (this.B + 13 >= this.C) {
            this.C0();
        }
        final byte[] a = this.A;
        final int b = this.B;
        final int b2 = b + 1;
        this.B = b2;
        a[b] = this.z;
        o = com.fasterxml.jackson.core.io.g.o(o, a, b2);
        final byte[] a2 = this.A;
        this.B = o + 1;
        a2[o] = this.z;
    }
    
    private final void n1(final long n) throws IOException {
        if (this.B + 23 >= this.C) {
            this.C0();
        }
        final byte[] a = this.A;
        final int b = this.B;
        final int b2 = b + 1;
        this.B = b2;
        a[b] = this.z;
        final int q = com.fasterxml.jackson.core.io.g.q(n, a, b2);
        final byte[] a2 = this.A;
        this.B = q + 1;
        a2[q] = this.z;
    }
    
    private final void p1(final String s) throws IOException {
        if (this.B >= this.C) {
            this.C0();
        }
        this.A[this.B++] = this.z;
        this.V(s);
        if (this.B >= this.C) {
            this.C0();
        }
        this.A[this.B++] = this.z;
    }
    
    private void r1(final char[] array, int i, final int n) throws IOException {
    Label_0000:
        while (i < n) {
            do {
                final char c = array[i];
                if (c > '\u007f') {
                    final int n2 = i + 1;
                    final char c2 = array[i];
                    if (c2 < '\u0800') {
                        final byte[] a = this.A;
                        i = this.B;
                        final int b = i + 1;
                        this.B = b;
                        a[i] = (byte)(c2 >> 6 | 0xC0);
                        this.B = b + 1;
                        a[b] = (byte)((c2 & '?') | 0x80);
                        i = n2;
                        continue Label_0000;
                    }
                    i = this.J0(c2, array, n2, n);
                    continue Label_0000;
                }
                else {
                    this.A[this.B++] = (byte)c;
                }
            } while (++i < n);
            break;
        }
    }
    
    private final void s1(final char[] array, int i, int n) throws IOException {
        final int c = this.C;
        final byte[] a = this.A;
        final int n2 = n + i;
    Label_0017:
        while (i < n2) {
            do {
                n = array[i];
                if (n >= 128) {
                    if (this.B + 3 >= this.C) {
                        this.C0();
                    }
                    n = i + 1;
                    final char c2 = array[i];
                    if (c2 < '\u0800') {
                        i = this.B;
                        final int b = i + 1;
                        this.B = b;
                        a[i] = (byte)(c2 >> 6 | 0xC0);
                        this.B = b + 1;
                        a[b] = (byte)((c2 & '?') | 0x80);
                        i = n;
                        continue Label_0017;
                    }
                    i = this.J0(c2, array, n, n2);
                    continue Label_0017;
                }
                else {
                    if (this.B >= c) {
                        this.C0();
                    }
                    a[this.B++] = (byte)n;
                    n = i + 1;
                }
            } while ((i = n) < n2);
            break;
        }
    }
    
    private final void w1(final String s, int b, int i) throws IOException {
        final int n = i + b;
        final int b2 = this.B;
        final byte[] a = this.A;
        final int[] h = super.h;
        char char1;
        for (i = b, b = b2; i < n; ++i, ++b) {
            char1 = s.charAt(i);
            if (char1 > '\u007f') {
                break;
            }
            if (h[char1] != 0) {
                break;
            }
            a[b] = (byte)char1;
        }
        this.B = b;
        if (i < n) {
            if (super.j != null) {
                this.Y0(s, i, n);
            }
            else if (super.i == 0) {
                this.A1(s, i, n);
            }
            else {
                this.C1(s, i, n);
            }
        }
    }
    
    private final void y1(final char[] array, int i, int b) throws IOException {
        final int n = b + i;
        b = this.B;
        final byte[] a = this.A;
        final int[] h = super.h;
        while (i < n) {
            final char c = array[i];
            if (c > '\u007f') {
                break;
            }
            if (h[c] != 0) {
                break;
            }
            a[b] = (byte)c;
            ++i;
            ++b;
        }
        this.B = b;
        if (i < n) {
            if (super.j != null) {
                this.a1(array, i, n);
            }
            else if (super.i == 0) {
                this.B1(array, i, n);
            }
            else {
                this.E1(array, i, n);
            }
        }
    }
    
    protected final void C0() throws IOException {
        final int b = this.B;
        if (b > 0) {
            this.B = 0;
            this.y.write(this.A, 0, b);
        }
    }
    
    @Override
    public void E(final long n) throws IOException {
        this.N0("write a number");
        if (super.c) {
            this.n1(n);
            return;
        }
        if (this.B + 21 >= this.C) {
            this.C0();
        }
        this.B = com.fasterxml.jackson.core.io.g.q(n, this.A, this.B);
    }
    
    @Override
    public void F(final BigDecimal bigDecimal) throws IOException {
        this.N0("write a number");
        if (bigDecimal == null) {
            this.g1();
        }
        else if (super.c) {
            this.p1(this.e0(bigDecimal));
        }
        else {
            this.V(this.e0(bigDecimal));
        }
    }
    
    protected final void K0(int g0, int n) throws IOException {
        g0 = this.g0(g0, n);
        if (this.B + 4 > this.C) {
            this.C0();
        }
        final byte[] a = this.A;
        final int b = this.B;
        n = b + 1;
        this.B = n;
        a[b] = (byte)(g0 >> 18 | 0xF0);
        final int b2 = n + 1;
        this.B = b2;
        a[n] = (byte)((g0 >> 12 & 0x3F) | 0x80);
        n = b2 + 1;
        this.B = n;
        a[b2] = (byte)((g0 >> 6 & 0x3F) | 0x80);
        this.B = n + 1;
        a[n] = (byte)((g0 & 0x3F) | 0x80);
    }
    
    @Override
    public void L(final BigInteger bigInteger) throws IOException {
        this.N0("write a number");
        if (bigInteger == null) {
            this.g1();
        }
        else if (super.c) {
            this.p1(bigInteger.toString());
        }
        else {
            this.V(bigInteger.toString());
        }
    }
    
    protected void L0() {
        final byte[] a = this.A;
        if (a != null && this.G) {
            this.A = null;
            super.g.q(a);
        }
        final char[] e = this.E;
        if (e != null) {
            this.E = null;
            super.g.m(e);
        }
    }
    
    @Override
    public void M(final char c) throws IOException {
        if (this.B + 3 >= this.C) {
            this.C0();
        }
        final byte[] a = this.A;
        if (c <= '\u007f') {
            a[this.B++] = (byte)c;
        }
        else if (c < '\u0800') {
            final int b = this.B;
            final int b2 = b + 1;
            this.B = b2;
            a[b] = (byte)(c >> 6 | 0xC0);
            this.B = b2 + 1;
            a[b2] = (byte)((c & '?') | 0x80);
        }
        else {
            this.J0(c, null, 0, 0);
        }
    }
    
    public void M1(final String s, int n, int i) throws IOException {
        final char[] e = this.E;
        final int length = e.length;
        if (i <= length) {
            s.getChars(n, n + i, e, 0);
            this.W(e, 0, i);
            return;
        }
        final int c = this.C;
        final int min = Math.min(length, (c >> 2) + (c >> 4));
        while (i > 0) {
            final int min2 = Math.min(min, i);
            s.getChars(n, n + min2, e, 0);
            if (this.B + min * 3 > this.C) {
                this.C0();
            }
            int n2;
            if ((n2 = min2) > 1) {
                final char c2 = e[min2 - 1];
                n2 = min2;
                if (c2 >= '\ud800') {
                    n2 = min2;
                    if (c2 <= '\udbff') {
                        n2 = min2 - 1;
                    }
                }
            }
            this.r1(e, 0, n2);
            n += n2;
            i -= n2;
        }
    }
    
    protected final void N0(final String s) throws IOException {
        final int o = super.d.o();
        if (super.a != null) {
            this.r0(s, o);
            return;
        }
        byte b;
        if (o != 1) {
            if (o != 2) {
                if (o == 3) {
                    final e p = super.p;
                    if (p != null) {
                        final byte[] unquotedUTF8 = p.asUnquotedUTF8();
                        if (unquotedUTF8.length > 0) {
                            this.R0(unquotedUTF8);
                        }
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
                b = 58;
            }
        }
        else {
            b = 44;
        }
        if (this.B >= this.C) {
            this.C0();
        }
        this.A[this.B++] = b;
    }
    
    @Override
    public void O(final e e) throws IOException {
        final byte[] unquotedUTF8 = e.asUnquotedUTF8();
        if (unquotedUTF8.length > 0) {
            this.R0(unquotedUTF8);
        }
    }
    
    @Override
    public void V(final String s) throws IOException {
        final int length = s.length();
        final char[] e = this.E;
        if (length <= e.length) {
            s.getChars(0, length, e, 0);
            this.W(e, 0, length);
        }
        else {
            this.M1(s, 0, length);
        }
    }
    
    @Override
    public final void W(final char[] array, int i, int n) throws IOException {
        final int n2 = n + n + n;
        final int b = this.B;
        final int c = this.C;
        if (b + n2 > c) {
            if (c < n2) {
                this.s1(array, i, n);
                return;
            }
            this.C0();
        }
        final int n3 = n + i;
    Label_0053:
        while (i < n3) {
            do {
                n = array[i];
                if (n > 127) {
                    n = i + 1;
                    final char c2 = array[i];
                    if (c2 < '\u0800') {
                        final byte[] a = this.A;
                        final int b2 = this.B;
                        i = b2 + 1;
                        this.B = i;
                        a[b2] = (byte)(c2 >> 6 | 0xC0);
                        this.B = i + 1;
                        a[i] = (byte)((c2 & '?') | 0x80);
                        i = n;
                        continue Label_0053;
                    }
                    i = this.J0(c2, array, n, n3);
                    continue Label_0053;
                }
                else {
                    this.A[this.B++] = (byte)n;
                    n = i + 1;
                }
            } while ((i = n) < n3);
            break;
        }
    }
    
    @Override
    public final void Z() throws IOException {
        this.N0("start an array");
        super.d = super.d.j();
        final d a = super.a;
        if (a != null) {
            a.writeStartArray(this);
        }
        else {
            if (this.B >= this.C) {
                this.C0();
            }
            this.A[this.B++] = 91;
        }
    }
    
    @Override
    public final void a0() throws IOException {
        this.N0("start an object");
        super.d = super.d.k();
        final d a = super.a;
        if (a != null) {
            a.writeStartObject(this);
        }
        else {
            if (this.B >= this.C) {
                this.C0();
            }
            this.A[this.B++] = 123;
        }
    }
    
    @Override
    public void c0(final String s) throws IOException {
        this.N0("write a string");
        if (s == null) {
            this.g1();
            return;
        }
        final int length = s.length();
        if (length > this.D) {
            this.K1(s, true);
            return;
        }
        if (this.B + length >= this.C) {
            this.C0();
        }
        this.A[this.B++] = this.z;
        this.w1(s, 0, length);
        if (this.B >= this.C) {
            this.C0();
        }
        this.A[this.B++] = this.z;
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
        this.C0();
        this.B = 0;
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
        this.L0();
    }
    
    @Override
    public void flush() throws IOException {
        this.C0();
        if (this.y != null && this.l0(Feature.FLUSH_PASSED_TO_STREAM)) {
            this.y.flush();
        }
    }
    
    protected final void h1(final String s) throws IOException {
        final int n = super.d.n(s);
        if (n == 4) {
            this.a("Can not write a field name, expecting a value");
        }
        if (n == 1) {
            super.a.writeObjectEntrySeparator(this);
        }
        else {
            super.a.beforeObjectEntries(this);
        }
        if (super.w) {
            this.K1(s, false);
            return;
        }
        final int length = s.length();
        if (length > this.F) {
            this.K1(s, true);
            return;
        }
        if (this.B >= this.C) {
            this.C0();
        }
        this.A[this.B++] = this.z;
        s.getChars(0, length, this.E, 0);
        if (length <= this.D) {
            if (this.B + length > this.C) {
                this.C0();
            }
            this.y1(this.E, 0, length);
        }
        else {
            this.L1(this.E, 0, length);
        }
        if (this.B >= this.C) {
            this.C0();
        }
        this.A[this.B++] = this.z;
    }
    
    @Override
    public void i(final boolean b) throws IOException {
        this.N0("write a boolean value");
        if (this.B + 5 >= this.C) {
            this.C0();
        }
        byte[] array;
        if (b) {
            array = i.J;
        }
        else {
            array = i.K;
        }
        final int length = array.length;
        System.arraycopy(array, 0, this.A, this.B, length);
        this.B += length;
    }
    
    @Override
    public final void j() throws IOException {
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
            if (this.B >= this.C) {
                this.C0();
            }
            this.A[this.B++] = 93;
        }
        super.d = super.d.i();
    }
    
    @Override
    public final void k() throws IOException {
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
            if (this.B >= this.C) {
                this.C0();
            }
            this.A[this.B++] = 125;
        }
        super.d = super.d.i();
    }
    
    @Override
    public void l(final String s) throws IOException {
        if (super.a != null) {
            this.h1(s);
            return;
        }
        final int n = super.d.n(s);
        if (n == 4) {
            this.a("Can not write a field name, expecting a value");
        }
        if (n == 1) {
            if (this.B >= this.C) {
                this.C0();
            }
            this.A[this.B++] = 44;
        }
        if (super.w) {
            this.K1(s, false);
            return;
        }
        final int length = s.length();
        if (length > this.F) {
            this.K1(s, true);
            return;
        }
        if (this.B >= this.C) {
            this.C0();
        }
        final byte[] a = this.A;
        final int b = this.B;
        final int b2 = b + 1;
        this.B = b2;
        a[b] = this.z;
        if (length <= this.D) {
            if (b2 + length > this.C) {
                this.C0();
            }
            this.w1(s, 0, length);
        }
        else {
            this.F1(s, 0, length);
        }
        if (this.B >= this.C) {
            this.C0();
        }
        this.A[this.B++] = this.z;
    }
    
    @Override
    public void r() throws IOException {
        this.N0("write a null");
        this.g1();
    }
    
    @Override
    public void s(final double n) throws IOException {
        if (!super.c && ((!Double.isNaN(n) && !Double.isInfinite(n)) || !Feature.QUOTE_NON_NUMERIC_NUMBERS.enabledIn(super.b))) {
            this.N0("write a number");
            this.V(String.valueOf(n));
            return;
        }
        this.c0(String.valueOf(n));
    }
    
    @Override
    public void t(final float n) throws IOException {
        if (!super.c && ((!Float.isNaN(n) && !Float.isInfinite(n)) || !Feature.QUOTE_NON_NUMERIC_NUMBERS.enabledIn(super.b))) {
            this.N0("write a number");
            this.V(String.valueOf(n));
            return;
        }
        this.c0(String.valueOf(n));
    }
    
    @Override
    public void u(final int n) throws IOException {
        this.N0("write a number");
        if (this.B + 11 >= this.C) {
            this.C0();
        }
        if (super.c) {
            this.k1(n);
            return;
        }
        this.B = com.fasterxml.jackson.core.io.g.o(n, this.A, this.B);
    }
}
