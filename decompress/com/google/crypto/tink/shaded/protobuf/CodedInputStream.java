// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.io.InputStream;

public abstract class CodedInputStream
{
    int a;
    int b;
    int c;
    g d;
    private boolean e;
    
    private CodedInputStream() {
        this.b = 100;
        this.c = Integer.MAX_VALUE;
        this.e = false;
    }
    
    CodedInputStream(final CodedInputStream$a object) {
        this();
    }
    
    public static int b(final int n) {
        return -(n & 0x1) ^ n >>> 1;
    }
    
    public static long c(final long n) {
        return -(n & 0x1L) ^ n >>> 1;
    }
    
    public static CodedInputStream f(final InputStream inputStream) {
        return g(inputStream, 4096);
    }
    
    public static CodedInputStream g(final InputStream inputStream, final int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("bufferSize must be > 0");
        }
        if (inputStream == null) {
            return i(Internal.c);
        }
        return new c(inputStream, n, null);
    }
    
    static CodedInputStream h(final ByteBuffer byteBuffer, final boolean b) {
        if (byteBuffer.hasArray()) {
            return k(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), b);
        }
        if (byteBuffer.isDirect() && d.H()) {
            return new d(byteBuffer, b, null);
        }
        final int remaining = byteBuffer.remaining();
        final byte[] array = new byte[remaining];
        byteBuffer.duplicate().get(array);
        return k(array, 0, remaining, true);
    }
    
    public static CodedInputStream i(final byte[] array) {
        return j(array, 0, array.length);
    }
    
    public static CodedInputStream j(final byte[] array, final int n, final int n2) {
        return k(array, n, n2, false);
    }
    
    static CodedInputStream k(final byte[] array, final int n, final int n2, final boolean b) {
        final b b2 = new b(array, n, n2, b, null);
        try {
            b2.m(n2);
            return b2;
        }
        catch (final InvalidProtocolBufferException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
    
    public abstract String A() throws IOException;
    
    public abstract String B() throws IOException;
    
    public abstract int C() throws IOException;
    
    public abstract int D() throws IOException;
    
    public abstract long E() throws IOException;
    
    public abstract boolean F(final int p0) throws IOException;
    
    public abstract void a(final int p0) throws InvalidProtocolBufferException;
    
    public abstract int d();
    
    public abstract boolean e() throws IOException;
    
    public abstract void l(final int p0);
    
    public abstract int m(final int p0) throws InvalidProtocolBufferException;
    
    public abstract boolean n() throws IOException;
    
    public abstract ByteString o() throws IOException;
    
    public abstract double p() throws IOException;
    
    public abstract int q() throws IOException;
    
    public abstract int r() throws IOException;
    
    public abstract long s() throws IOException;
    
    public abstract float t() throws IOException;
    
    public abstract int u() throws IOException;
    
    public abstract long v() throws IOException;
    
    public abstract int w() throws IOException;
    
    public abstract long x() throws IOException;
    
    public abstract int y() throws IOException;
    
    public abstract long z() throws IOException;
    
    private static final class b extends CodedInputStream
    {
        private final byte[] f;
        private final boolean g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private boolean m;
        private int n;
        
        private b(final byte[] f, final int n, final int n2, final boolean g) {
            super(null);
            this.n = Integer.MAX_VALUE;
            this.f = f;
            this.h = n2 + n;
            this.j = n;
            this.k = n;
            this.g = g;
        }
        
        b(final byte[] array, final int n, final int n2, final boolean b, final CodedInputStream$a object) {
            this(array, n, n2, b);
        }
        
        private void N() {
            final int h = this.h + this.i;
            this.h = h;
            final int n = h - this.k;
            final int n2 = this.n;
            if (n > n2) {
                final int i = n - n2;
                this.i = i;
                this.h = h - i;
            }
            else {
                this.i = 0;
            }
        }
        
        private void Q() throws IOException {
            if (this.h - this.j >= 10) {
                this.R();
            }
            else {
                this.S();
            }
        }
        
        private void R() throws IOException {
            for (int i = 0; i < 10; ++i) {
                if (this.f[this.j++] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }
        
        private void S() throws IOException {
            for (int i = 0; i < 10; ++i) {
                if (this.G() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }
        
        @Override
        public String A() throws IOException {
            final int k = this.K();
            if (k > 0) {
                final int h = this.h;
                final int j = this.j;
                if (k <= h - j) {
                    final String s = new String(this.f, j, k, Internal.a);
                    this.j += k;
                    return s;
                }
            }
            if (k == 0) {
                return "";
            }
            if (k < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        @Override
        public String B() throws IOException {
            final int k = this.K();
            if (k > 0) {
                final int h = this.h;
                final int j = this.j;
                if (k <= h - j) {
                    final String h2 = Utf8.h(this.f, j, k);
                    this.j += k;
                    return h2;
                }
            }
            if (k == 0) {
                return "";
            }
            if (k <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        @Override
        public int C() throws IOException {
            if (this.e()) {
                return this.l = 0;
            }
            final int k = this.K();
            this.l = k;
            if (WireFormat.a(k) != 0) {
                return this.l;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }
        
        @Override
        public int D() throws IOException {
            return this.K();
        }
        
        @Override
        public long E() throws IOException {
            return this.L();
        }
        
        @Override
        public boolean F(final int n) throws IOException {
            final int b = WireFormat.b(n);
            if (b == 0) {
                this.Q();
                return true;
            }
            if (b == 1) {
                this.P(8);
                return true;
            }
            if (b == 2) {
                this.P(this.K());
                return true;
            }
            if (b == 3) {
                this.O();
                this.a(WireFormat.c(WireFormat.a(n), 4));
                return true;
            }
            if (b == 4) {
                return false;
            }
            if (b == 5) {
                this.P(4);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        
        public byte G() throws IOException {
            final int j = this.j;
            if (j != this.h) {
                final byte[] f = this.f;
                this.j = j + 1;
                return f[j];
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        public byte[] H(int j) throws IOException {
            if (j > 0) {
                final int h = this.h;
                final int i = this.j;
                if (j <= h - i) {
                    j += i;
                    this.j = j;
                    return Arrays.copyOfRange(this.f, i, j);
                }
            }
            if (j > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (j == 0) {
                return Internal.c;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        
        public int I() throws IOException {
            final int j = this.j;
            if (this.h - j >= 4) {
                final byte[] f = this.f;
                this.j = j + 4;
                return (f[j + 3] & 0xFF) << 24 | ((f[j] & 0xFF) | (f[j + 1] & 0xFF) << 8 | (f[j + 2] & 0xFF) << 16);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        public long J() throws IOException {
            final int j = this.j;
            if (this.h - j >= 8) {
                final byte[] f = this.f;
                this.j = j + 8;
                return ((long)f[j + 7] & 0xFFL) << 56 | (((long)f[j] & 0xFFL) | ((long)f[j + 1] & 0xFFL) << 8 | ((long)f[j + 2] & 0xFFL) << 16 | ((long)f[j + 3] & 0xFFL) << 24 | ((long)f[j + 4] & 0xFFL) << 32 | ((long)f[j + 5] & 0xFFL) << 40 | ((long)f[j + 6] & 0xFFL) << 48);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        public int K() throws IOException {
            final int j = this.j;
            final int h = this.h;
            if (h != j) {
                final byte[] f = this.f;
                final int i = j + 1;
                final byte b = f[j];
                if (b >= 0) {
                    this.j = i;
                    return b;
                }
                if (h - i >= 9) {
                    int k = i + 1;
                    final int n = b ^ f[i] << 7;
                    int n2;
                    if (n < 0) {
                        n2 = (n ^ 0xFFFFFF80);
                    }
                    else {
                        final int n3 = k + 1;
                        final int n4 = n ^ f[k] << 14;
                        if (n4 >= 0) {
                            final int n5 = n4 ^ 0x3F80;
                            k = n3;
                            n2 = n5;
                        }
                        else {
                            k = n3 + 1;
                            final int n6 = n4 ^ f[n3] << 21;
                            if (n6 < 0) {
                                n2 = (n6 ^ 0xFFE03F80);
                            }
                            else {
                                final int n7 = k + 1;
                                final byte b2 = f[k];
                                final int n8 = n2 = (n6 ^ b2 << 28 ^ 0xFE03F80);
                                k = n7;
                                if (b2 < 0) {
                                    final int n9 = n7 + 1;
                                    n2 = n8;
                                    k = n9;
                                    if (f[n7] < 0) {
                                        final int n10 = n9 + 1;
                                        n2 = n8;
                                        k = n10;
                                        if (f[n9] < 0) {
                                            final int n11 = n10 + 1;
                                            n2 = n8;
                                            k = n11;
                                            if (f[n10] < 0) {
                                                final int n12 = n11 + 1;
                                                n2 = n8;
                                                k = n12;
                                                if (f[n11] < 0) {
                                                    k = n12 + 1;
                                                    n2 = n8;
                                                    if (f[n12] < 0) {
                                                        return (int)this.M();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.j = k;
                    return n2;
                }
            }
            return (int)this.M();
        }
        
        public long L() throws IOException {
            final int j = this.j;
            final int h = this.h;
            if (h != j) {
                final byte[] f = this.f;
                final int i = j + 1;
                final byte b = f[j];
                if (b >= 0) {
                    this.j = i;
                    return b;
                }
                if (h - i >= 9) {
                    int k = i + 1;
                    final int n = b ^ f[i] << 7;
                    long n5 = 0L;
                    Label_0344: {
                        int n2;
                        if (n < 0) {
                            n2 = (n ^ 0xFFFFFF80);
                        }
                        else {
                            final int n3 = k + 1;
                            final int n4 = n ^ f[k] << 14;
                            if (n4 >= 0) {
                                n5 = (n4 ^ 0x3F80);
                                k = n3;
                                break Label_0344;
                            }
                            k = n3 + 1;
                            final int n6 = n4 ^ f[n3] << 21;
                            if (n6 >= 0) {
                                final long n7 = n6;
                                final int n8 = k + 1;
                                long n9 = n7 ^ (long)f[k] << 28;
                                long n13 = 0L;
                                Label_0178: {
                                    if (n9 < 0L) {
                                        final int n10 = n8 + 1;
                                        long n11 = n9 ^ (long)f[n8] << 35;
                                        long n12;
                                        if (n11 < 0L) {
                                            n12 = -34093383808L;
                                            k = n10;
                                        }
                                        else {
                                            k = n10 + 1;
                                            n9 = (n11 ^ (long)f[n10] << 42);
                                            if (n9 >= 0L) {
                                                n13 = 4363953127296L;
                                                break Label_0178;
                                            }
                                            final int n14 = k + 1;
                                            n11 = (n9 ^ (long)f[k] << 49);
                                            if (n11 < 0L) {
                                                n12 = -558586000294016L;
                                                k = n14;
                                            }
                                            else {
                                                final int n15 = n14 + 1;
                                                n5 = (n11 ^ (long)f[n14] << 56 ^ 0xFE03F80FE03F80L);
                                                if (n5 >= 0L) {
                                                    k = n15;
                                                    break Label_0344;
                                                }
                                                k = n15 + 1;
                                                if (f[n15] < 0L) {
                                                    return this.M();
                                                }
                                                break Label_0344;
                                            }
                                        }
                                        n5 = (n11 ^ n12);
                                        break Label_0344;
                                    }
                                    n13 = 266354560L;
                                    k = n8;
                                }
                                n5 = (n9 ^ n13);
                                break Label_0344;
                            }
                            n2 = (n6 ^ 0xFFE03F80);
                        }
                        n5 = n2;
                    }
                    this.j = k;
                    return n5;
                }
            }
            return this.M();
        }
        
        long M() throws IOException {
            long n = 0L;
            for (int i = 0; i < 64; i += 7) {
                final byte g = this.G();
                n |= (long)(g & 0x7F) << i;
                if ((g & 0x80) == 0x0) {
                    return n;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }
        
        public void O() throws IOException {
            int c;
            do {
                c = this.C();
            } while (c != 0 && this.F(c));
        }
        
        public void P(final int n) throws IOException {
            if (n >= 0) {
                final int h = this.h;
                final int j = this.j;
                if (n <= h - j) {
                    this.j = j + n;
                    return;
                }
            }
            if (n < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        @Override
        public void a(final int n) throws InvalidProtocolBufferException {
            if (this.l == n) {
                return;
            }
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        
        @Override
        public int d() {
            return this.j - this.k;
        }
        
        @Override
        public boolean e() throws IOException {
            return this.j == this.h;
        }
        
        @Override
        public void l(final int n) {
            this.n = n;
            this.N();
        }
        
        @Override
        public int m(int n) throws InvalidProtocolBufferException {
            if (n < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            n += this.d();
            final int n2 = this.n;
            if (n <= n2) {
                this.n = n;
                this.N();
                return n2;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        @Override
        public boolean n() throws IOException {
            return this.L() != 0L;
        }
        
        @Override
        public ByteString o() throws IOException {
            final int k = this.K();
            if (k > 0) {
                final int h = this.h;
                final int j = this.j;
                if (k <= h - j) {
                    ByteString byteString;
                    if (this.g && this.m) {
                        byteString = ByteString.wrap(this.f, j, k);
                    }
                    else {
                        byteString = ByteString.copyFrom(this.f, j, k);
                    }
                    this.j += k;
                    return byteString;
                }
            }
            if (k == 0) {
                return ByteString.EMPTY;
            }
            return ByteString.wrap(this.H(k));
        }
        
        @Override
        public double p() throws IOException {
            return Double.longBitsToDouble(this.J());
        }
        
        @Override
        public int q() throws IOException {
            return this.K();
        }
        
        @Override
        public int r() throws IOException {
            return this.I();
        }
        
        @Override
        public long s() throws IOException {
            return this.J();
        }
        
        @Override
        public float t() throws IOException {
            return Float.intBitsToFloat(this.I());
        }
        
        @Override
        public int u() throws IOException {
            return this.K();
        }
        
        @Override
        public long v() throws IOException {
            return this.L();
        }
        
        @Override
        public int w() throws IOException {
            return this.I();
        }
        
        @Override
        public long x() throws IOException {
            return this.J();
        }
        
        @Override
        public int y() throws IOException {
            return CodedInputStream.b(this.K());
        }
        
        @Override
        public long z() throws IOException {
            return CodedInputStream.c(this.L());
        }
    }
    
    private static final class c extends CodedInputStream
    {
        private final InputStream f;
        private final byte[] g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private a n;
        
        private c(final InputStream f, final int n) {
            super(null);
            this.m = Integer.MAX_VALUE;
            this.n = null;
            Internal.b(f, "input");
            this.f = f;
            this.g = new byte[n];
            this.h = 0;
            this.j = 0;
            this.l = 0;
        }
        
        c(final InputStream inputStream, final int n, final CodedInputStream$a object) {
            this(inputStream, n);
        }
        
        private ByteString G(int n) throws IOException {
            final byte[] j = this.J(n);
            if (j != null) {
                return ByteString.copyFrom(j);
            }
            final int i = this.j;
            final int h = this.h;
            final int n2 = h - i;
            this.l += h;
            this.j = 0;
            this.h = 0;
            final List<byte[]> k = this.K(n - n2);
            final byte[] array = new byte[n];
            System.arraycopy(this.g, i, array, 0, n2);
            final Iterator<byte[]> iterator = k.iterator();
            n = n2;
            while (iterator.hasNext()) {
                final byte[] array2 = iterator.next();
                System.arraycopy(array2, 0, array, n, array2.length);
                n += array2.length;
            }
            return ByteString.wrap(array);
        }
        
        private byte[] I(int n, final boolean b) throws IOException {
            final byte[] j = this.J(n);
            if (j != null) {
                byte[] array = j;
                if (b) {
                    array = j.clone();
                }
                return array;
            }
            final int i = this.j;
            final int h = this.h;
            final int n2 = h - i;
            this.l += h;
            this.j = 0;
            this.h = 0;
            final List<byte[]> k = this.K(n - n2);
            final byte[] array2 = new byte[n];
            System.arraycopy(this.g, i, array2, 0, n2);
            final Iterator<byte[]> iterator = k.iterator();
            n = n2;
            while (iterator.hasNext()) {
                final byte[] array3 = iterator.next();
                System.arraycopy(array3, 0, array2, n, array3.length);
                n += array3.length;
            }
            return array2;
        }
        
        private byte[] J(final int n) throws IOException {
            if (n == 0) {
                return Internal.c;
            }
            if (n < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            final int l = this.l;
            final int j = this.j;
            final int n2 = l + j + n;
            if (n2 - super.c > 0) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            final int m = this.m;
            if (n2 > m) {
                this.T(m - l - j);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i = this.h - j;
            final int n3 = n - i;
            if (n3 >= 4096 && n3 > this.f.available()) {
                return null;
            }
            final byte[] array = new byte[n];
            System.arraycopy(this.g, this.j, array, 0, i);
            this.l += this.h;
            this.j = 0;
            this.h = 0;
            while (i < n) {
                final int read = this.f.read(array, i, n - i);
                if (read == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.l += read;
                i += read;
            }
            return array;
        }
        
        private List<byte[]> K(int i) throws IOException {
            final ArrayList list = new ArrayList();
            while (i > 0) {
                final int min = Math.min(i, 4096);
                final byte[] array = new byte[min];
                int read;
                for (int j = 0; j < min; j += read) {
                    read = this.f.read(array, j, min - j);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.l += read;
                }
                i -= min;
                list.add(array);
            }
            return list;
        }
        
        private void Q() {
            final int h = this.h + this.i;
            this.h = h;
            final int n = this.l + h;
            final int m = this.m;
            if (n > m) {
                final int i = n - m;
                this.i = i;
                this.h = h - i;
            }
            else {
                this.i = 0;
            }
        }
        
        private void R(final int n) throws IOException {
            if (this.Y(n)) {
                return;
            }
            if (n > super.c - this.l - this.j) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        private void U(final int n) throws IOException {
            if (n < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            final int l = this.l;
            final int j = this.j;
            final int m = this.m;
            if (l + j + n <= m) {
                final a n2 = this.n;
                int i = 0;
                if (n2 == null) {
                    this.l = l + j;
                    final int h = this.h;
                    this.h = 0;
                    this.j = 0;
                    i = h - j;
                    while (i < n) {
                        try {
                            final InputStream f = this.f;
                            final long n3 = n - i;
                            final long skip = f.skip(n3);
                            final long n4 = lcmp(skip, 0L);
                            if (n4 < 0 || skip > n3) {
                                final StringBuilder sb = new StringBuilder();
                                sb.append(this.f.getClass());
                                sb.append("#skip returned invalid result: ");
                                sb.append(skip);
                                sb.append("\nThe InputStream implementation is buggy.");
                                throw new IllegalStateException(sb.toString());
                            }
                            if (n4 != 0) {
                                i += (int)skip;
                                continue;
                            }
                        }
                        finally {
                            this.l += i;
                            this.Q();
                        }
                        break;
                    }
                    this.l += i;
                    this.Q();
                }
                if (i < n) {
                    final int h2 = this.h;
                    int n5 = h2 - this.j;
                    this.j = h2;
                    this.R(1);
                    int k;
                    while (true) {
                        k = n - n5;
                        final int h3 = this.h;
                        if (k <= h3) {
                            break;
                        }
                        n5 += h3;
                        this.j = h3;
                        this.R(1);
                    }
                    this.j = k;
                }
                return;
            }
            this.T(m - l - j);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        private void V() throws IOException {
            if (this.h - this.j >= 10) {
                this.W();
            }
            else {
                this.X();
            }
        }
        
        private void W() throws IOException {
            for (int i = 0; i < 10; ++i) {
                if (this.g[this.j++] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }
        
        private void X() throws IOException {
            for (int i = 0; i < 10; ++i) {
                if (this.H() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }
        
        private boolean Y(final int n) throws IOException {
            final int j = this.j;
            if (j + n <= this.h) {
                final StringBuilder sb = new StringBuilder();
                sb.append("refillBuffer() called when ");
                sb.append(n);
                sb.append(" bytes were already available in buffer");
                throw new IllegalStateException(sb.toString());
            }
            final int c = super.c;
            final int l = this.l;
            if (n > c - l - j) {
                return false;
            }
            if (l + j + n > this.m) {
                return false;
            }
            final a n2 = this.n;
            if (n2 != null) {
                n2.a();
            }
            final int i = this.j;
            if (i > 0) {
                final int h = this.h;
                if (h > i) {
                    final byte[] g = this.g;
                    System.arraycopy(g, i, g, 0, h - i);
                }
                this.l += i;
                this.h -= i;
                this.j = 0;
            }
            final InputStream f = this.f;
            final byte[] g2 = this.g;
            final int h2 = this.h;
            final int read = f.read(g2, h2, Math.min(g2.length - h2, super.c - this.l - h2));
            if (read == 0 || read < -1 || read > this.g.length) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f.getClass());
                sb2.append("#read(byte[]) returned invalid result: ");
                sb2.append(read);
                sb2.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb2.toString());
            }
            if (read > 0) {
                this.h += read;
                this.Q();
                return this.h >= n || this.Y(n);
            }
            return false;
        }
        
        @Override
        public String A() throws IOException {
            final int n = this.N();
            if (n > 0) {
                final int h = this.h;
                final int j = this.j;
                if (n <= h - j) {
                    final String s = new String(this.g, j, n, Internal.a);
                    this.j += n;
                    return s;
                }
            }
            if (n == 0) {
                return "";
            }
            if (n <= this.h) {
                this.R(n);
                final String s2 = new String(this.g, this.j, n, Internal.a);
                this.j += n;
                return s2;
            }
            return new String(this.I(n, false), Internal.a);
        }
        
        @Override
        public String B() throws IOException {
            final int n = this.N();
            int j = this.j;
            final int h = this.h;
            byte[] array;
            if (n <= h - j && n > 0) {
                array = this.g;
                this.j = j + n;
            }
            else {
                if (n == 0) {
                    return "";
                }
                if (n <= h) {
                    this.R(n);
                    array = this.g;
                    this.j = n + 0;
                }
                else {
                    array = this.I(n, false);
                }
                j = 0;
            }
            return Utf8.h(array, j, n);
        }
        
        @Override
        public int C() throws IOException {
            if (this.e()) {
                return this.k = 0;
            }
            final int n = this.N();
            this.k = n;
            if (WireFormat.a(n) != 0) {
                return this.k;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }
        
        @Override
        public int D() throws IOException {
            return this.N();
        }
        
        @Override
        public long E() throws IOException {
            return this.O();
        }
        
        @Override
        public boolean F(final int n) throws IOException {
            final int b = WireFormat.b(n);
            if (b == 0) {
                this.V();
                return true;
            }
            if (b == 1) {
                this.T(8);
                return true;
            }
            if (b == 2) {
                this.T(this.N());
                return true;
            }
            if (b == 3) {
                this.S();
                this.a(WireFormat.c(WireFormat.a(n), 4));
                return true;
            }
            if (b == 4) {
                return false;
            }
            if (b == 5) {
                this.T(4);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        
        public byte H() throws IOException {
            if (this.j == this.h) {
                this.R(1);
            }
            return this.g[this.j++];
        }
        
        public int L() throws IOException {
            int n;
            if (this.h - (n = this.j) < 4) {
                this.R(4);
                n = this.j;
            }
            final byte[] g = this.g;
            this.j = n + 4;
            return (g[n + 3] & 0xFF) << 24 | ((g[n] & 0xFF) | (g[n + 1] & 0xFF) << 8 | (g[n + 2] & 0xFF) << 16);
        }
        
        public long M() throws IOException {
            int n;
            if (this.h - (n = this.j) < 8) {
                this.R(8);
                n = this.j;
            }
            final byte[] g = this.g;
            this.j = n + 8;
            return ((long)g[n + 7] & 0xFFL) << 56 | (((long)g[n] & 0xFFL) | ((long)g[n + 1] & 0xFFL) << 8 | ((long)g[n + 2] & 0xFFL) << 16 | ((long)g[n + 3] & 0xFFL) << 24 | ((long)g[n + 4] & 0xFFL) << 32 | ((long)g[n + 5] & 0xFFL) << 40 | ((long)g[n + 6] & 0xFFL) << 48);
        }
        
        public int N() throws IOException {
            final int j = this.j;
            final int h = this.h;
            if (h != j) {
                final byte[] g = this.g;
                final int i = j + 1;
                final byte b = g[j];
                if (b >= 0) {
                    this.j = i;
                    return b;
                }
                if (h - i >= 9) {
                    int k = i + 1;
                    final int n = b ^ g[i] << 7;
                    int n2;
                    if (n < 0) {
                        n2 = (n ^ 0xFFFFFF80);
                    }
                    else {
                        final int n3 = k + 1;
                        final int n4 = n ^ g[k] << 14;
                        if (n4 >= 0) {
                            final int n5 = n4 ^ 0x3F80;
                            k = n3;
                            n2 = n5;
                        }
                        else {
                            k = n3 + 1;
                            final int n6 = n4 ^ g[n3] << 21;
                            if (n6 < 0) {
                                n2 = (n6 ^ 0xFFE03F80);
                            }
                            else {
                                final int n7 = k + 1;
                                final byte b2 = g[k];
                                final int n8 = n2 = (n6 ^ b2 << 28 ^ 0xFE03F80);
                                k = n7;
                                if (b2 < 0) {
                                    final int n9 = n7 + 1;
                                    n2 = n8;
                                    k = n9;
                                    if (g[n7] < 0) {
                                        final int n10 = n9 + 1;
                                        n2 = n8;
                                        k = n10;
                                        if (g[n9] < 0) {
                                            final int n11 = n10 + 1;
                                            n2 = n8;
                                            k = n11;
                                            if (g[n10] < 0) {
                                                final int n12 = n11 + 1;
                                                n2 = n8;
                                                k = n12;
                                                if (g[n11] < 0) {
                                                    k = n12 + 1;
                                                    n2 = n8;
                                                    if (g[n12] < 0) {
                                                        return (int)this.P();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.j = k;
                    return n2;
                }
            }
            return (int)this.P();
        }
        
        public long O() throws IOException {
            final int j = this.j;
            final int h = this.h;
            if (h != j) {
                final byte[] g = this.g;
                final int i = j + 1;
                final byte b = g[j];
                if (b >= 0) {
                    this.j = i;
                    return b;
                }
                if (h - i >= 9) {
                    int k = i + 1;
                    final int n = b ^ g[i] << 7;
                    long n5 = 0L;
                    Label_0345: {
                        int n2;
                        if (n < 0) {
                            n2 = (n ^ 0xFFFFFF80);
                        }
                        else {
                            final int n3 = k + 1;
                            final int n4 = n ^ g[k] << 14;
                            if (n4 >= 0) {
                                n5 = (n4 ^ 0x3F80);
                                k = n3;
                                break Label_0345;
                            }
                            k = n3 + 1;
                            final int n6 = n4 ^ g[n3] << 21;
                            if (n6 >= 0) {
                                final long n7 = n6;
                                final int n8 = k + 1;
                                long n9 = n7 ^ (long)g[k] << 28;
                                long n13 = 0L;
                                Label_0179: {
                                    if (n9 < 0L) {
                                        final int n10 = n8 + 1;
                                        long n11 = n9 ^ (long)g[n8] << 35;
                                        long n12;
                                        if (n11 < 0L) {
                                            n12 = -34093383808L;
                                            k = n10;
                                        }
                                        else {
                                            k = n10 + 1;
                                            n9 = (n11 ^ (long)g[n10] << 42);
                                            if (n9 >= 0L) {
                                                n13 = 4363953127296L;
                                                break Label_0179;
                                            }
                                            final int n14 = k + 1;
                                            n11 = (n9 ^ (long)g[k] << 49);
                                            if (n11 < 0L) {
                                                n12 = -558586000294016L;
                                                k = n14;
                                            }
                                            else {
                                                final int n15 = n14 + 1;
                                                n5 = (n11 ^ (long)g[n14] << 56 ^ 0xFE03F80FE03F80L);
                                                if (n5 >= 0L) {
                                                    k = n15;
                                                    break Label_0345;
                                                }
                                                k = n15 + 1;
                                                if (g[n15] < 0L) {
                                                    return this.P();
                                                }
                                                break Label_0345;
                                            }
                                        }
                                        n5 = (n11 ^ n12);
                                        break Label_0345;
                                    }
                                    n13 = 266354560L;
                                    k = n8;
                                }
                                n5 = (n9 ^ n13);
                                break Label_0345;
                            }
                            n2 = (n6 ^ 0xFFE03F80);
                        }
                        n5 = n2;
                    }
                    this.j = k;
                    return n5;
                }
            }
            return this.P();
        }
        
        long P() throws IOException {
            long n = 0L;
            for (int i = 0; i < 64; i += 7) {
                final byte h = this.H();
                n |= (long)(h & 0x7F) << i;
                if ((h & 0x80) == 0x0) {
                    return n;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }
        
        public void S() throws IOException {
            int c;
            do {
                c = this.C();
            } while (c != 0 && this.F(c));
        }
        
        public void T(final int n) throws IOException {
            final int h = this.h;
            final int j = this.j;
            if (n <= h - j && n >= 0) {
                this.j = j + n;
            }
            else {
                this.U(n);
            }
        }
        
        @Override
        public void a(final int n) throws InvalidProtocolBufferException {
            if (this.k == n) {
                return;
            }
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        
        @Override
        public int d() {
            return this.l + this.j;
        }
        
        @Override
        public boolean e() throws IOException {
            final int j = this.j;
            final int h = this.h;
            boolean b = true;
            if (j != h || this.Y(1)) {
                b = false;
            }
            return b;
        }
        
        @Override
        public void l(final int m) {
            this.m = m;
            this.Q();
        }
        
        @Override
        public int m(int m) throws InvalidProtocolBufferException {
            if (m < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            m += this.l + this.j;
            final int i = this.m;
            if (m <= i) {
                this.m = m;
                this.Q();
                return i;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        @Override
        public boolean n() throws IOException {
            return this.O() != 0L;
        }
        
        @Override
        public ByteString o() throws IOException {
            final int n = this.N();
            final int h = this.h;
            final int j = this.j;
            if (n <= h - j && n > 0) {
                final ByteString copy = ByteString.copyFrom(this.g, j, n);
                this.j += n;
                return copy;
            }
            if (n == 0) {
                return ByteString.EMPTY;
            }
            return this.G(n);
        }
        
        @Override
        public double p() throws IOException {
            return Double.longBitsToDouble(this.M());
        }
        
        @Override
        public int q() throws IOException {
            return this.N();
        }
        
        @Override
        public int r() throws IOException {
            return this.L();
        }
        
        @Override
        public long s() throws IOException {
            return this.M();
        }
        
        @Override
        public float t() throws IOException {
            return Float.intBitsToFloat(this.L());
        }
        
        @Override
        public int u() throws IOException {
            return this.N();
        }
        
        @Override
        public long v() throws IOException {
            return this.O();
        }
        
        @Override
        public int w() throws IOException {
            return this.L();
        }
        
        @Override
        public long x() throws IOException {
            return this.M();
        }
        
        @Override
        public int y() throws IOException {
            return CodedInputStream.b(this.N());
        }
        
        @Override
        public long z() throws IOException {
            return CodedInputStream.c(this.O());
        }
        
        private interface a
        {
            void a();
        }
    }
    
    private static final class d extends CodedInputStream
    {
        private final ByteBuffer f;
        private final boolean g;
        private final long h;
        private long i;
        private long j;
        private long k;
        private int l;
        private int m;
        private boolean n;
        private int o;
        
        private d(final ByteBuffer f, final boolean g) {
            super(null);
            this.o = Integer.MAX_VALUE;
            this.f = f;
            final long i = q0.i(f);
            this.h = i;
            this.i = f.limit() + i;
            final long n = i + f.position();
            this.j = n;
            this.k = n;
            this.g = g;
        }
        
        d(final ByteBuffer byteBuffer, final boolean b, final CodedInputStream$a object) {
            this(byteBuffer, b);
        }
        
        private int G(final long n) {
            return (int)(n - this.h);
        }
        
        static boolean H() {
            return q0.H();
        }
        
        private void O() {
            final long i = this.i + this.l;
            this.i = i;
            final int n = (int)(i - this.k);
            final int o = this.o;
            if (n > o) {
                final int l = n - o;
                this.l = l;
                this.i = i - l;
            }
            else {
                this.l = 0;
            }
        }
        
        private int P() {
            return (int)(this.i - this.j);
        }
        
        private void S() throws IOException {
            if (this.P() >= 10) {
                this.T();
            }
            else {
                this.U();
            }
        }
        
        private void T() throws IOException {
            for (int i = 0; i < 10; ++i) {
                final long j = this.j;
                this.j = 1L + j;
                if (q0.u(j) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }
        
        private void U() throws IOException {
            for (int i = 0; i < 10; ++i) {
                if (this.I() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }
        
        private ByteBuffer V(final long n, final long n2) throws IOException {
            final int position = this.f.position();
            final int limit = this.f.limit();
            try {
                try {
                    this.f.position(this.G(n));
                    this.f.limit(this.G(n2));
                    final ByteBuffer slice = this.f.slice();
                    this.f.position(position);
                    this.f.limit(limit);
                    return slice;
                }
                finally {}
            }
            catch (final IllegalArgumentException ex) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f.position(position);
            this.f.limit(limit);
        }
        
        @Override
        public String A() throws IOException {
            final int l = this.L();
            if (l > 0 && l <= this.P()) {
                final byte[] array = new byte[l];
                final long j = this.j;
                final long n = l;
                q0.n(j, array, 0L, n);
                final String s = new String(array, Internal.a);
                this.j += n;
                return s;
            }
            if (l == 0) {
                return "";
            }
            if (l < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        @Override
        public String B() throws IOException {
            final int l = this.L();
            if (l > 0 && l <= this.P()) {
                final String g = Utf8.g(this.f, this.G(this.j), l);
                this.j += l;
                return g;
            }
            if (l == 0) {
                return "";
            }
            if (l <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        @Override
        public int C() throws IOException {
            if (this.e()) {
                return this.m = 0;
            }
            final int l = this.L();
            this.m = l;
            if (WireFormat.a(l) != 0) {
                return this.m;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }
        
        @Override
        public int D() throws IOException {
            return this.L();
        }
        
        @Override
        public long E() throws IOException {
            return this.M();
        }
        
        @Override
        public boolean F(final int n) throws IOException {
            final int b = WireFormat.b(n);
            if (b == 0) {
                this.S();
                return true;
            }
            if (b == 1) {
                this.R(8);
                return true;
            }
            if (b == 2) {
                this.R(this.L());
                return true;
            }
            if (b == 3) {
                this.Q();
                this.a(WireFormat.c(WireFormat.a(n), 4));
                return true;
            }
            if (b == 4) {
                return false;
            }
            if (b == 5) {
                this.R(4);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        
        public byte I() throws IOException {
            final long j = this.j;
            if (j != this.i) {
                this.j = 1L + j;
                return q0.u(j);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        public int J() throws IOException {
            final long j = this.j;
            if (this.i - j >= 4L) {
                this.j = 4L + j;
                return (q0.u(j + 3L) & 0xFF) << 24 | ((q0.u(j) & 0xFF) | (q0.u(1L + j) & 0xFF) << 8 | (q0.u(2L + j) & 0xFF) << 16);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        public long K() throws IOException {
            final long j = this.j;
            if (this.i - j >= 8L) {
                this.j = 8L + j;
                return ((long)q0.u(j + 7L) & 0xFFL) << 56 | (((long)q0.u(j) & 0xFFL) | ((long)q0.u(1L + j) & 0xFFL) << 8 | ((long)q0.u(2L + j) & 0xFFL) << 16 | ((long)q0.u(3L + j) & 0xFFL) << 24 | ((long)q0.u(4L + j) & 0xFFL) << 32 | ((long)q0.u(5L + j) & 0xFFL) << 40 | ((long)q0.u(6L + j) & 0xFFL) << 48);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        public int L() throws IOException {
            final long j = this.j;
            if (this.i != j) {
                final long i = j + 1L;
                final byte u = q0.u(j);
                if (u >= 0) {
                    this.j = i;
                    return u;
                }
                if (this.i - i >= 9L) {
                    long k = i + 1L;
                    final int n = u ^ q0.u(i) << 7;
                    int n2;
                    if (n < 0) {
                        n2 = (n ^ 0xFFFFFF80);
                    }
                    else {
                        final long n3 = k + 1L;
                        final int n4 = n ^ q0.u(k) << 14;
                        if (n4 >= 0) {
                            n2 = (n4 ^ 0x3F80);
                            k = n3;
                        }
                        else {
                            k = n3 + 1L;
                            final int n5 = n4 ^ q0.u(n3) << 21;
                            if (n5 < 0) {
                                n2 = (n5 ^ 0xFFE03F80);
                            }
                            else {
                                final long n6 = k + 1L;
                                final byte u2 = q0.u(k);
                                final int n7 = n2 = (n5 ^ u2 << 28 ^ 0xFE03F80);
                                k = n6;
                                if (u2 < 0) {
                                    final long n8 = n6 + 1L;
                                    n2 = n7;
                                    k = n8;
                                    if (q0.u(n6) < 0) {
                                        final long n9 = n8 + 1L;
                                        n2 = n7;
                                        k = n9;
                                        if (q0.u(n8) < 0) {
                                            final long n10 = n9 + 1L;
                                            n2 = n7;
                                            k = n10;
                                            if (q0.u(n9) < 0) {
                                                final long n11 = n10 + 1L;
                                                n2 = n7;
                                                k = n11;
                                                if (q0.u(n10) < 0) {
                                                    k = n11 + 1L;
                                                    n2 = n7;
                                                    if (q0.u(n11) < 0) {
                                                        return (int)this.N();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.j = k;
                    return n2;
                }
            }
            return (int)this.N();
        }
        
        public long M() throws IOException {
            final long j = this.j;
            if (this.i != j) {
                final long i = j + 1L;
                final byte u = q0.u(j);
                if (u >= 0) {
                    this.j = i;
                    return u;
                }
                if (this.i - i >= 9L) {
                    final long n = i + 1L;
                    final int n2 = u ^ q0.u(i) << 7;
                    long k = 0L;
                    long n4 = 0L;
                    Label_0370: {
                        int n7 = 0;
                        Label_0085: {
                            if (n2 >= 0) {
                                k = n + 1L;
                                final int n3 = n2 ^ q0.u(n) << 14;
                                Label_0117: {
                                    if (n3 >= 0) {
                                        n4 = (n3 ^ 0x3F80);
                                    }
                                    else {
                                        final long n5 = k + 1L;
                                        final int n6 = n3 ^ q0.u(k) << 21;
                                        if (n6 < 0) {
                                            n7 = (n6 ^ 0xFFE03F80);
                                            k = n5;
                                            break Label_0085;
                                        }
                                        final long n8 = n6;
                                        k = n5 + 1L;
                                        long n9 = n8 ^ (long)q0.u(n5) << 28;
                                        long n14 = 0L;
                                        Label_0184: {
                                            if (n9 < 0L) {
                                                long n10 = k + 1L;
                                                final long n11 = n9 ^ (long)q0.u(k) << 35;
                                                long n12;
                                                long n13;
                                                if (n11 < 0L) {
                                                    n12 = -34093383808L;
                                                    n13 = n11;
                                                }
                                                else {
                                                    k = n10 + 1L;
                                                    n9 = (n11 ^ (long)q0.u(n10) << 42);
                                                    if (n9 >= 0L) {
                                                        n14 = 4363953127296L;
                                                        break Label_0184;
                                                    }
                                                    n10 = k + 1L;
                                                    n13 = (n9 ^ (long)q0.u(k) << 49);
                                                    if (n13 < 0L) {
                                                        n12 = -558586000294016L;
                                                    }
                                                    else {
                                                        final long n15 = n10 + 1L;
                                                        final long n16 = n4 = (n13 ^ (long)q0.u(n10) << 56 ^ 0xFE03F80FE03F80L);
                                                        k = n15;
                                                        if (n16 >= 0L) {
                                                            break Label_0117;
                                                        }
                                                        if (q0.u(n15) < 0L) {
                                                            return this.N();
                                                        }
                                                        k = 1L + n15;
                                                        n4 = n16;
                                                        break Label_0370;
                                                    }
                                                }
                                                final long n17 = n13 ^ n12;
                                                k = n10;
                                                n4 = n17;
                                                break Label_0370;
                                            }
                                            n14 = 266354560L;
                                        }
                                        n4 = (n9 ^ n14);
                                    }
                                }
                                break Label_0370;
                            }
                            n7 = (n2 ^ 0xFFFFFF80);
                            k = n;
                        }
                        n4 = n7;
                    }
                    this.j = k;
                    return n4;
                }
            }
            return this.N();
        }
        
        long N() throws IOException {
            long n = 0L;
            for (int i = 0; i < 64; i += 7) {
                final byte j = this.I();
                n |= (long)(j & 0x7F) << i;
                if ((j & 0x80) == 0x0) {
                    return n;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }
        
        public void Q() throws IOException {
            int c;
            do {
                c = this.C();
            } while (c != 0 && this.F(c));
        }
        
        public void R(final int n) throws IOException {
            if (n >= 0 && n <= this.P()) {
                this.j += n;
                return;
            }
            if (n < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        @Override
        public void a(final int n) throws InvalidProtocolBufferException {
            if (this.m == n) {
                return;
            }
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        
        @Override
        public int d() {
            return (int)(this.j - this.k);
        }
        
        @Override
        public boolean e() throws IOException {
            return this.j == this.i;
        }
        
        @Override
        public void l(final int o) {
            this.o = o;
            this.O();
        }
        
        @Override
        public int m(int o) throws InvalidProtocolBufferException {
            if (o < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            final int o2 = o + this.d();
            o = this.o;
            if (o2 <= o) {
                this.o = o2;
                this.O();
                return o;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        @Override
        public boolean n() throws IOException {
            return this.M() != 0L;
        }
        
        @Override
        public ByteString o() throws IOException {
            final int l = this.L();
            if (l > 0 && l <= this.P()) {
                if (this.g && this.n) {
                    final long j = this.j;
                    final long n = l;
                    final ByteBuffer v = this.V(j, j + n);
                    this.j += n;
                    return ByteString.wrap(v);
                }
                final byte[] array = new byte[l];
                final long i = this.j;
                final long n2 = l;
                q0.n(i, array, 0L, n2);
                this.j += n2;
                return ByteString.wrap(array);
            }
            else {
                if (l == 0) {
                    return ByteString.EMPTY;
                }
                if (l < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
        
        @Override
        public double p() throws IOException {
            return Double.longBitsToDouble(this.K());
        }
        
        @Override
        public int q() throws IOException {
            return this.L();
        }
        
        @Override
        public int r() throws IOException {
            return this.J();
        }
        
        @Override
        public long s() throws IOException {
            return this.K();
        }
        
        @Override
        public float t() throws IOException {
            return Float.intBitsToFloat(this.J());
        }
        
        @Override
        public int u() throws IOException {
            return this.L();
        }
        
        @Override
        public long v() throws IOException {
            return this.M();
        }
        
        @Override
        public int w() throws IOException {
            return this.J();
        }
        
        @Override
        public long x() throws IOException {
            return this.K();
        }
        
        @Override
        public int y() throws IOException {
            return CodedInputStream.b(this.L());
        }
        
        @Override
        public long z() throws IOException {
            return CodedInputStream.c(this.M());
        }
    }
}
