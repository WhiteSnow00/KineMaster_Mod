// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.parser.moshi;

import qc.a0;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import qc.f;
import qc.h;
import okio.ByteString;

final class b extends JsonReader
{
    private static final ByteString A;
    private static final ByteString B;
    private static final ByteString C;
    private static final ByteString y;
    private static final ByteString z;
    private final h h;
    private final f i;
    private int j;
    private long p;
    private int w;
    private String x;
    
    static {
        y = ByteString.encodeUtf8("'\\");
        z = ByteString.encodeUtf8("\"\\");
        A = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
        B = ByteString.encodeUtf8("\n\r");
        C = ByteString.encodeUtf8("*/");
    }
    
    b(final h h) {
        this.j = 0;
        Objects.requireNonNull(h, "source == null");
        this.h = h;
        this.i = h.y();
        this.E(6);
    }
    
    private void B0() throws IOException {
        long n = this.h.P(b.A);
        final f i = this.i;
        if (n == -1L) {
            n = i.i0();
        }
        i.f(n);
    }
    
    private void W() throws IOException {
        if (super.e) {
            return;
        }
        throw this.V("Use JsonReader.setLenient(true) to accept malformed JSON");
    }
    
    private int Z() throws IOException {
        final int[] b = super.b;
        final int a = super.a;
        final int n = b[a - 1];
        if (n == 1) {
            b[a - 1] = 2;
        }
        else if (n == 2) {
            final int e0 = this.e0(true);
            this.i.readByte();
            if (e0 != 44) {
                if (e0 != 59) {
                    if (e0 == 93) {
                        return this.j = 4;
                    }
                    throw this.V("Unterminated array");
                }
                else {
                    this.W();
                }
            }
        }
        else if (n != 3 && n != 5) {
            if (n == 4) {
                b[a - 1] = 5;
                final int e2 = this.e0(true);
                this.i.readByte();
                if (e2 != 58) {
                    if (e2 != 61) {
                        throw this.V("Expected ':'");
                    }
                    this.W();
                    if (this.h.request(1L) && this.i.l(0L) == 62) {
                        this.i.readByte();
                    }
                }
            }
            else if (n == 6) {
                b[a - 1] = 7;
            }
            else if (n == 7) {
                if (this.e0(false) == -1) {
                    return this.j = 18;
                }
                this.W();
            }
            else if (n == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        else {
            b[a - 1] = 4;
            if (n == 5) {
                final int e3 = this.e0(true);
                this.i.readByte();
                if (e3 != 44) {
                    if (e3 != 59) {
                        if (e3 == 125) {
                            return this.j = 2;
                        }
                        throw this.V("Unterminated object");
                    }
                    else {
                        this.W();
                    }
                }
            }
            final int e4 = this.e0(true);
            if (e4 == 34) {
                this.i.readByte();
                return this.j = 13;
            }
            if (e4 == 39) {
                this.i.readByte();
                this.W();
                return this.j = 12;
            }
            if (e4 != 125) {
                this.W();
                if (this.c0((char)e4)) {
                    return this.j = 14;
                }
                throw this.V("Expected name");
            }
            else {
                if (n != 5) {
                    this.i.readByte();
                    return this.j = 2;
                }
                throw this.V("Expected name");
            }
        }
        final int e5 = this.e0(true);
        if (e5 == 34) {
            this.i.readByte();
            return this.j = 9;
        }
        if (e5 == 39) {
            this.W();
            this.i.readByte();
            return this.j = 8;
        }
        if (e5 != 44 && e5 != 59) {
            if (e5 == 91) {
                this.i.readByte();
                return this.j = 3;
            }
            if (e5 != 93) {
                if (e5 == 123) {
                    this.i.readByte();
                    return this.j = 1;
                }
                final int i0 = this.i0();
                if (i0 != 0) {
                    return i0;
                }
                final int l0 = this.l0();
                if (l0 != 0) {
                    return l0;
                }
                if (this.c0(this.i.l(0L))) {
                    this.W();
                    return this.j = 10;
                }
                throw this.V("Expected value");
            }
            else if (n == 1) {
                this.i.readByte();
                return this.j = 4;
            }
        }
        if (n != 1 && n != 2) {
            throw this.V("Unexpected value");
        }
        this.W();
        return this.j = 7;
    }
    
    private int a0(final String s, final a a) {
        for (int length = a.a.length, i = 0; i < length; ++i) {
            if (s.equals(a.a[i])) {
                this.j = 0;
                super.c[super.a - 1] = s;
                return i;
            }
        }
        return -1;
    }
    
    private boolean c0(final int n) throws IOException {
        if (n != 9 && n != 10 && n != 12 && n != 13 && n != 32) {
            if (n != 35) {
                if (n == 44) {
                    return false;
                }
                if (n != 47 && n != 61) {
                    if (n == 123 || n == 125 || n == 58) {
                        return false;
                    }
                    if (n != 59) {
                        switch (n) {
                            default: {
                                return true;
                            }
                            case 92: {
                                break;
                            }
                            case 91:
                            case 93: {
                                return false;
                            }
                        }
                    }
                }
            }
            this.W();
        }
        return false;
    }
    
    private int e0(final boolean b) throws IOException {
        while (true) {
            int n = 0;
            while (true) {
                final h h = this.h;
                final int n2 = n + 1;
                if (h.request((long)n2)) {
                    final byte l = this.i.l((long)n);
                    if (l != 10 && l != 32 && l != 13 && l != 9) {
                        this.i.f((long)(n2 - 1));
                        if (l == 47) {
                            if (!this.h.request(2L)) {
                                return l;
                            }
                            this.W();
                            final byte i = this.i.l(1L);
                            if (i != 42) {
                                if (i != 47) {
                                    return l;
                                }
                                this.i.readByte();
                                this.i.readByte();
                                this.y0();
                                break;
                            }
                            else {
                                this.i.readByte();
                                this.i.readByte();
                                if (this.t0()) {
                                    break;
                                }
                                throw this.V("Unterminated comment");
                            }
                        }
                        else {
                            if (l == 35) {
                                this.W();
                                this.y0();
                                break;
                            }
                            return l;
                        }
                    }
                    else {
                        n = n2;
                    }
                }
                else {
                    if (!b) {
                        return -1;
                    }
                    throw new EOFException("End of input");
                }
            }
        }
    }
    
    private String f0(final ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            final long p = this.h.P(byteString);
            if (p == -1L) {
                throw this.V("Unterminated string");
            }
            if (this.i.l(p) == 92) {
                StringBuilder sb2;
                if ((sb2 = sb) == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.i.c0(p));
                this.i.readByte();
                sb2.append(this.m0());
                sb = sb2;
            }
            else {
                if (sb == null) {
                    final String c0 = this.i.c0(p);
                    this.i.readByte();
                    return c0;
                }
                sb.append(this.i.c0(p));
                this.i.readByte();
                return sb.toString();
            }
        }
    }
    
    private String g0() throws IOException {
        final long p = this.h.P(b.A);
        String s;
        if (p != -1L) {
            s = this.i.c0(p);
        }
        else {
            s = this.i.a0();
        }
        return s;
    }
    
    private int i0() throws IOException {
        final byte l = this.i.l(0L);
        int j;
        String s;
        String s2;
        if (l != 116 && l != 84) {
            if (l != 102 && l != 70) {
                if (l != 110 && l != 78) {
                    return 0;
                }
                j = 7;
                s = "null";
                s2 = "NULL";
            }
            else {
                j = 6;
                s = "false";
                s2 = "FALSE";
            }
        }
        else {
            j = 5;
            s = "true";
            s2 = "TRUE";
        }
        final int length = s.length();
        int n;
        for (int i = 1; i < length; i = n) {
            final h h = this.h;
            n = i + 1;
            if (!h.request((long)n)) {
                return 0;
            }
            final byte k = this.i.l((long)i);
            if (k != s.charAt(i) && k != s2.charAt(i)) {
                return 0;
            }
        }
        if (this.h.request((long)(length + 1)) && this.c0(this.i.l((long)length))) {
            return 0;
        }
        this.i.f((long)length);
        return this.j = j;
    }
    
    private int l0() throws IOException {
        int n = 0;
        long p = 0L;
        int n2 = 1;
        int w = 0;
        int n4;
        int n3 = n4 = 0;
        while (true) {
            final h h = this.h;
            final int n5 = w + 1;
            if (!h.request((long)n5)) {
                break;
            }
            final byte l = this.i.l((long)w);
            Label_0460: {
                if (l != 43) {
                    if (l != 69 && l != 101) {
                        if (l != 45) {
                            if (l != 46) {
                                if (l >= 48 && l <= 57) {
                                    long n6 = 0L;
                                    int n8 = 0;
                                    int n9 = 0;
                                    Label_0248: {
                                        if (n3 != 1 && n3 != 0) {
                                            if (n3 == 2) {
                                                if (p == 0L) {
                                                    return n;
                                                }
                                                n6 = 10L * p - (l - 48);
                                                final long n7 = lcmp(p, -922337203685477580L);
                                                n8 = (n2 & ((n7 > 0 || (n7 == 0 && n6 < p)) ? 1 : 0));
                                                n9 = n3;
                                            }
                                            else {
                                                if (n3 == 3) {
                                                    n = 0;
                                                    n3 = 4;
                                                    break Label_0460;
                                                }
                                                if (n3 != 5) {
                                                    n9 = n3;
                                                    n8 = n2;
                                                    n6 = p;
                                                    if (n3 != 6) {
                                                        break Label_0248;
                                                    }
                                                }
                                                n = 0;
                                                n3 = 7;
                                                break Label_0460;
                                            }
                                        }
                                        else {
                                            n6 = -(l - 48);
                                            n9 = 2;
                                            n8 = n2;
                                        }
                                    }
                                    n = 0;
                                    n3 = n9;
                                    n2 = n8;
                                    p = n6;
                                }
                                else {
                                    if (!this.c0(l)) {
                                        break;
                                    }
                                    return 0;
                                }
                            }
                            else {
                                final int n10 = 3;
                                if (n3 != 2) {
                                    return n;
                                }
                                n3 = n10;
                            }
                        }
                        else {
                            final int n11 = 6;
                            if (n3 == 0) {
                                n3 = 1;
                                n4 = 1;
                            }
                            else {
                                if (n3 != 5) {
                                    return n;
                                }
                                n3 = n11;
                            }
                        }
                    }
                    else {
                        if (n3 != 2 && n3 != 4) {
                            return n;
                        }
                        n3 = 5;
                    }
                }
                else {
                    final int n12 = 6;
                    if (n3 != 5) {
                        return n;
                    }
                    n3 = n12;
                }
            }
            w = n5;
        }
        if (n3 == 2 && n2 != 0 && (p != Long.MIN_VALUE || n4 != 0) && (p != 0L || n4 == 0)) {
            if (n4 == 0) {
                p = -p;
            }
            this.p = p;
            this.i.f((long)w);
            return this.j = 16;
        }
        if (n3 != 2 && n3 != 4 && n3 != 7) {
            return 0;
        }
        this.w = w;
        return this.j = 17;
    }
    
    private char m0() throws IOException {
        if (!this.h.request(1L)) {
            throw this.V("Unterminated escape sequence");
        }
        final byte byte1 = this.i.readByte();
        if (byte1 == 10 || byte1 == 34 || byte1 == 39 || byte1 == 47 || byte1 == 92) {
            return (char)byte1;
        }
        if (byte1 == 98) {
            return '\b';
        }
        if (byte1 == 102) {
            return '\f';
        }
        if (byte1 == 110) {
            return '\n';
        }
        if (byte1 == 114) {
            return '\r';
        }
        if (byte1 == 116) {
            return '\t';
        }
        if (byte1 != 117) {
            if (super.e) {
                return (char)byte1;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid escape sequence: \\");
            sb.append((char)byte1);
            throw this.V(sb.toString());
        }
        else {
            if (this.h.request(4L)) {
                int i = 0;
                char c = '\0';
                while (i < 4) {
                    int l = this.i.l((long)i);
                    final char c2 = (char)(c << 4);
                    if (l >= '0' && l <= '9') {
                        l -= 48;
                    }
                    else {
                        if (l >= 'a' && l <= 'f') {
                            l -= 97;
                        }
                        else {
                            if (l < 'A' || l > 'F') {
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append("\\u");
                                sb2.append(this.i.c0(4L));
                                throw this.V(sb2.toString());
                            }
                            l -= 65;
                        }
                        l += '\n';
                    }
                    c = (char)(c2 + l);
                    ++i;
                }
                this.i.f(4L);
                return c;
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Unterminated escape sequence at path ");
            sb3.append(this.getPath());
            throw new EOFException(sb3.toString());
        }
    }
    
    private void r0(final ByteString byteString) throws IOException {
        while (true) {
            final long p = this.h.P(byteString);
            if (p == -1L) {
                throw this.V("Unterminated string");
            }
            if (this.i.l(p) != 92) {
                this.i.f(p + 1L);
                return;
            }
            this.i.f(p + 1L);
            this.m0();
        }
    }
    
    private boolean t0() throws IOException {
        final h h = this.h;
        final ByteString c = b.C;
        final long i = h.I(c);
        final boolean b = i != -1L;
        final f j = this.i;
        long i2;
        if (b) {
            i2 = i + c.size();
        }
        else {
            i2 = j.i0();
        }
        j.f(i2);
        return b;
    }
    
    private void y0() throws IOException {
        final long p = this.h.P(b.B);
        final f i = this.i;
        long i2;
        if (p != -1L) {
            i2 = p + 1L;
        }
        else {
            i2 = i.i0();
        }
        i.f(i2);
    }
    
    @Override
    public int F(final a a) throws IOException {
        int n;
        if ((n = this.j) == 0) {
            n = this.Z();
        }
        if (n < 12 || n > 15) {
            return -1;
        }
        if (n == 15) {
            return this.a0(this.x, a);
        }
        final int e1 = this.h.e1(a.b);
        if (e1 != -1) {
            this.j = 0;
            super.c[super.a - 1] = a.a[e1];
            return e1;
        }
        final String s = super.c[super.a - 1];
        final String r = this.r();
        final int a2 = this.a0(r, a);
        if (a2 == -1) {
            this.j = 15;
            this.x = r;
            super.c[super.a - 1] = s;
        }
        return a2;
    }
    
    @Override
    public void L() throws IOException {
        if (!super.f) {
            int n;
            if ((n = this.j) == 0) {
                n = this.Z();
            }
            if (n == 14) {
                this.B0();
            }
            else if (n == 13) {
                this.r0(b.z);
            }
            else if (n == 12) {
                this.r0(b.y);
            }
            else if (n != 15) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Expected a name but was ");
                sb.append(this.u());
                sb.append(" at path ");
                sb.append(this.getPath());
                throw new JsonDataException(sb.toString());
            }
            this.j = 0;
            super.c[super.a - 1] = "null";
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot skip unexpected ");
        sb2.append(this.u());
        sb2.append(" at ");
        sb2.append(this.getPath());
        throw new JsonDataException(sb2.toString());
    }
    
    @Override
    public void M() throws IOException {
        if (!super.f) {
            int n = 0;
            int i = 0;
            do {
                int n2;
                if ((n2 = this.j) == 0) {
                    n2 = this.Z();
                }
                Label_0396: {
                    if (n2 == 3) {
                        this.E(1);
                    }
                    else if (n2 == 1) {
                        this.E(3);
                    }
                    else if (n2 == 4) {
                        i = n - 1;
                        if (i >= 0) {
                            --super.a;
                            break Label_0396;
                        }
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Expected a value but was ");
                        sb.append(this.u());
                        sb.append(" at path ");
                        sb.append(this.getPath());
                        throw new JsonDataException(sb.toString());
                    }
                    else if (n2 == 2) {
                        i = n - 1;
                        if (i >= 0) {
                            --super.a;
                            break Label_0396;
                        }
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Expected a value but was ");
                        sb2.append(this.u());
                        sb2.append(" at path ");
                        sb2.append(this.getPath());
                        throw new JsonDataException(sb2.toString());
                    }
                    else {
                        if (n2 == 14 || n2 == 10) {
                            this.B0();
                            i = n;
                            break Label_0396;
                        }
                        if (n2 == 9 || n2 == 13) {
                            this.r0(b.z);
                            i = n;
                            break Label_0396;
                        }
                        if (n2 == 8 || n2 == 12) {
                            this.r0(b.y);
                            i = n;
                            break Label_0396;
                        }
                        if (n2 == 17) {
                            this.i.f((long)this.w);
                            i = n;
                            break Label_0396;
                        }
                        if (n2 != 18) {
                            i = n;
                            break Label_0396;
                        }
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("Expected a value but was ");
                        sb3.append(this.u());
                        sb3.append(" at path ");
                        sb3.append(this.getPath());
                        throw new JsonDataException(sb3.toString());
                    }
                    i = n + 1;
                }
                this.j = 0;
                n = i;
            } while (i != 0);
            final int[] d = super.d;
            final int a = super.a;
            final int n3 = a - 1;
            ++d[n3];
            super.c[a - 1] = "null";
            return;
        }
        final StringBuilder sb4 = new StringBuilder();
        sb4.append("Cannot skip unexpected ");
        sb4.append(this.u());
        sb4.append(" at ");
        sb4.append(this.getPath());
        throw new JsonDataException(sb4.toString());
    }
    
    @Override
    public void c() throws IOException {
        int n;
        if ((n = this.j) == 0) {
            n = this.Z();
        }
        if (n == 3) {
            this.E(1);
            super.d[super.a - 1] = 0;
            this.j = 0;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected BEGIN_ARRAY but was ");
        sb.append(this.u());
        sb.append(" at path ");
        sb.append(this.getPath());
        throw new JsonDataException(sb.toString());
    }
    
    @Override
    public void close() throws IOException {
        this.j = 0;
        super.b[0] = 8;
        super.a = 1;
        this.i.c();
        ((a0)this.h).close();
    }
    
    @Override
    public void d() throws IOException {
        int n;
        if ((n = this.j) == 0) {
            n = this.Z();
        }
        if (n == 1) {
            this.E(3);
            this.j = 0;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected BEGIN_OBJECT but was ");
        sb.append(this.u());
        sb.append(" at path ");
        sb.append(this.getPath());
        throw new JsonDataException(sb.toString());
    }
    
    @Override
    public void e() throws IOException {
        int n;
        if ((n = this.j) == 0) {
            n = this.Z();
        }
        if (n == 4) {
            int a = super.a - 1;
            super.a = a;
            final int[] d = super.d;
            --a;
            ++d[a];
            this.j = 0;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected END_ARRAY but was ");
        sb.append(this.u());
        sb.append(" at path ");
        sb.append(this.getPath());
        throw new JsonDataException(sb.toString());
    }
    
    @Override
    public void h() throws IOException {
        int n;
        if ((n = this.j) == 0) {
            n = this.Z();
        }
        if (n == 2) {
            int a = super.a - 1;
            super.a = a;
            super.c[a] = null;
            final int[] d = super.d;
            --a;
            ++d[a];
            this.j = 0;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected END_OBJECT but was ");
        sb.append(this.u());
        sb.append(" at path ");
        sb.append(this.getPath());
        throw new JsonDataException(sb.toString());
    }
    
    @Override
    public boolean i() throws IOException {
        int n;
        if ((n = this.j) == 0) {
            n = this.Z();
        }
        return n != 2 && n != 4 && n != 18;
    }
    
    @Override
    public boolean j() throws IOException {
        int n;
        if ((n = this.j) == 0) {
            n = this.Z();
        }
        if (n == 5) {
            this.j = 0;
            final int[] d = super.d;
            final int n2 = super.a - 1;
            ++d[n2];
            return true;
        }
        if (n == 6) {
            this.j = 0;
            final int[] d2 = super.d;
            final int n3 = super.a - 1;
            ++d2[n3];
            return false;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected a boolean but was ");
        sb.append(this.u());
        sb.append(" at path ");
        sb.append(this.getPath());
        throw new JsonDataException(sb.toString());
    }
    
    @Override
    public double k() throws IOException {
        int n;
        if ((n = this.j) == 0) {
            n = this.Z();
        }
        if (n == 16) {
            this.j = 0;
            final int[] d = super.d;
            final int n2 = super.a - 1;
            ++d[n2];
            return (double)this.p;
        }
        Label_0339: {
            if (n == 17) {
                this.x = this.i.c0((long)this.w);
            }
            else if (n == 9) {
                this.x = this.f0(b.z);
            }
            else if (n == 8) {
                this.x = this.f0(b.y);
            }
            else if (n == 10) {
                this.x = this.g0();
            }
            else if (n != 11) {
                break Label_0339;
            }
            this.j = 11;
            try {
                final double double1 = Double.parseDouble(this.x);
                if (!super.e && (Double.isNaN(double1) || Double.isInfinite(double1))) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("JSON forbids NaN and infinities: ");
                    sb.append(double1);
                    sb.append(" at path ");
                    sb.append(this.getPath());
                    throw new JsonEncodingException(sb.toString());
                }
                this.x = null;
                this.j = 0;
                final int[] d2 = super.d;
                final int n3 = super.a - 1;
                ++d2[n3];
                return double1;
            }
            catch (final NumberFormatException ex) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Expected a double but was ");
                sb2.append(this.x);
                sb2.append(" at path ");
                sb2.append(this.getPath());
                throw new JsonDataException(sb2.toString());
            }
        }
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("Expected a double but was ");
        sb3.append(this.u());
        sb3.append(" at path ");
        sb3.append(this.getPath());
        throw new JsonDataException(sb3.toString());
    }
    
    @Override
    public int l() throws IOException {
        int n;
        if ((n = this.j) == 0) {
            n = this.Z();
        }
        if (n == 16) {
            final long p = this.p;
            final int n2 = (int)p;
            if (p == n2) {
                this.j = 0;
                final int[] d = super.d;
                final int n3 = super.a - 1;
                ++d[n3];
                return n2;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Expected an int but was ");
            sb.append(this.p);
            sb.append(" at path ");
            sb.append(this.getPath());
            throw new JsonDataException(sb.toString());
        }
        else {
            while (true) {
                if (n == 17) {
                    this.x = this.i.c0((long)this.w);
                    break Label_0316;
                }
                String x;
                if (n != 9 && n != 8) {
                    if (n == 11) {
                        break Label_0316;
                    }
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Expected an int but was ");
                    sb2.append(this.u());
                    sb2.append(" at path ");
                    sb2.append(this.getPath());
                    throw new JsonDataException(sb2.toString());
                }
                else if (n == 9) {
                    x = this.f0(b.z);
                }
                else {
                    x = this.f0(b.y);
                }
                this.x = x;
                try {
                    final int int1 = Integer.parseInt(x);
                    this.j = 0;
                    final int[] d2 = super.d;
                    final int n4 = super.a - 1;
                    ++d2[n4];
                    return int1;
                    this.j = 11;
                    try {
                        final double double1 = Double.parseDouble(this.x);
                        final int n5 = (int)double1;
                        if (n5 == double1) {
                            this.x = null;
                            this.j = 0;
                            final int[] d3 = super.d;
                            final int n6 = super.a - 1;
                            ++d3[n6];
                            return n5;
                        }
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("Expected an int but was ");
                        sb3.append(this.x);
                        sb3.append(" at path ");
                        sb3.append(this.getPath());
                        throw new JsonDataException(sb3.toString());
                    }
                    catch (final NumberFormatException ex) {
                        final StringBuilder sb4 = new StringBuilder();
                        sb4.append("Expected an int but was ");
                        sb4.append(this.x);
                        sb4.append(" at path ");
                        sb4.append(this.getPath());
                        throw new JsonDataException(sb4.toString());
                    }
                }
                catch (final NumberFormatException ex2) {
                    continue;
                }
                break;
            }
        }
    }
    
    @Override
    public String r() throws IOException {
        int n;
        if ((n = this.j) == 0) {
            n = this.Z();
        }
        String s;
        if (n == 14) {
            s = this.g0();
        }
        else if (n == 13) {
            s = this.f0(b.z);
        }
        else if (n == 12) {
            s = this.f0(b.y);
        }
        else {
            if (n != 15) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Expected a name but was ");
                sb.append(this.u());
                sb.append(" at path ");
                sb.append(this.getPath());
                throw new JsonDataException(sb.toString());
            }
            s = this.x;
        }
        this.j = 0;
        return super.c[super.a - 1] = s;
    }
    
    @Override
    public String s() throws IOException {
        int n;
        if ((n = this.j) == 0) {
            n = this.Z();
        }
        String s;
        if (n == 10) {
            s = this.g0();
        }
        else if (n == 9) {
            s = this.f0(b.z);
        }
        else if (n == 8) {
            s = this.f0(b.y);
        }
        else if (n == 11) {
            s = this.x;
            this.x = null;
        }
        else if (n == 16) {
            s = Long.toString(this.p);
        }
        else {
            if (n != 17) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Expected a string but was ");
                sb.append(this.u());
                sb.append(" at path ");
                sb.append(this.getPath());
                throw new JsonDataException(sb.toString());
            }
            s = this.i.c0((long)this.w);
        }
        this.j = 0;
        final int[] d = super.d;
        final int n2 = super.a - 1;
        ++d[n2];
        return s;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("JsonReader(");
        sb.append(this.h);
        sb.append(")");
        return sb.toString();
    }
    
    @Override
    public Token u() throws IOException {
        int n;
        if ((n = this.j) == 0) {
            n = this.Z();
        }
        switch (n) {
            default: {
                throw new AssertionError();
            }
            case 18: {
                return Token.END_DOCUMENT;
            }
            case 16:
            case 17: {
                return Token.NUMBER;
            }
            case 12:
            case 13:
            case 14:
            case 15: {
                return Token.NAME;
            }
            case 8:
            case 9:
            case 10:
            case 11: {
                return Token.STRING;
            }
            case 7: {
                return Token.NULL;
            }
            case 5:
            case 6: {
                return Token.BOOLEAN;
            }
            case 4: {
                return Token.END_ARRAY;
            }
            case 3: {
                return Token.BEGIN_ARRAY;
            }
            case 2: {
                return Token.END_OBJECT;
            }
            case 1: {
                return Token.BEGIN_OBJECT;
            }
        }
    }
}
