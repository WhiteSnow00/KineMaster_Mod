// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.logging.Level;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

public abstract class CodedOutputStream extends ByteOutput
{
    private static final Logger c;
    private static final boolean d;
    h a;
    private boolean b;
    
    static {
        c = Logger.getLogger(CodedOutputStream.class.getName());
        d = q0.G();
    }
    
    private CodedOutputStream() {
    }
    
    CodedOutputStream(final CodedOutputStream$a object) {
        this();
    }
    
    public static int A(final int n, final LazyFieldLite lazyFieldLite) {
        return W(1) * 2 + X(2, n) + B(3, lazyFieldLite);
    }
    
    public static int B(final int n, final LazyFieldLite lazyFieldLite) {
        return W(n) + C(lazyFieldLite);
    }
    
    public static int C(final LazyFieldLite lazyFieldLite) {
        return D(lazyFieldLite.b());
    }
    
    static int D(final int n) {
        return Y(n) + n;
    }
    
    public static int E(final int n, final MessageLite messageLite) {
        return W(1) * 2 + X(2, n) + F(3, messageLite);
    }
    
    public static int F(final int n, final MessageLite messageLite) {
        return W(n) + H(messageLite);
    }
    
    static int G(final int n, final MessageLite messageLite, final j0 j0) {
        return W(n) + I(messageLite, j0);
    }
    
    public static int H(final MessageLite messageLite) {
        return D(messageLite.getSerializedSize());
    }
    
    static int I(final MessageLite messageLite, final j0 j0) {
        return D(((AbstractMessageLite)messageLite).f(j0));
    }
    
    static int J(final int n) {
        if (n > 4096) {
            return 4096;
        }
        return n;
    }
    
    public static int K(final int n, final ByteString byteString) {
        return W(1) * 2 + X(2, n) + h(3, byteString);
    }
    
    @Deprecated
    public static int L(final int n) {
        return Y(n);
    }
    
    public static int M(final int n, final int n2) {
        return W(n) + N(n2);
    }
    
    public static int N(final int n) {
        return 4;
    }
    
    public static int O(final int n, final long n2) {
        return W(n) + P(n2);
    }
    
    public static int P(final long n) {
        return 8;
    }
    
    public static int Q(final int n, final int n2) {
        return W(n) + R(n2);
    }
    
    public static int R(final int n) {
        return Y(b0(n));
    }
    
    public static int S(final int n, final long n2) {
        return W(n) + T(n2);
    }
    
    public static int T(final long n) {
        return a0(c0(n));
    }
    
    public static int U(final int n, final String s) {
        return W(n) + V(s);
    }
    
    public static int V(final String s) {
        int n;
        try {
            n = Utf8.j(s);
        }
        catch (final Utf8.UnpairedSurrogateException ex) {
            n = s.getBytes(Internal.a).length;
        }
        return D(n);
    }
    
    public static int W(final int n) {
        return Y(WireFormat.c(n, 0));
    }
    
    public static int X(final int n, final int n2) {
        return W(n) + Y(n2);
    }
    
    public static int Y(final int n) {
        if ((n & 0xFFFFFF80) == 0x0) {
            return 1;
        }
        if ((n & 0xFFFFC000) == 0x0) {
            return 2;
        }
        if ((0xFFE00000 & n) == 0x0) {
            return 3;
        }
        if ((n & 0xF0000000) == 0x0) {
            return 4;
        }
        return 5;
    }
    
    public static int Z(final int n, final long n2) {
        return W(n) + a0(n2);
    }
    
    public static int a0(long n) {
        if ((0xFFFFFFFFFFFFFF80L & n) == 0x0L) {
            return 1;
        }
        if (n < 0L) {
            return 10;
        }
        int n2;
        if ((0xFFFFFFF800000000L & n) != 0x0L) {
            n2 = 6;
            n >>>= 28;
        }
        else {
            n2 = 2;
        }
        int n3 = n2;
        long n4 = n;
        if ((0xFFFFFFFFFFE00000L & n) != 0x0L) {
            n3 = n2 + 2;
            n4 = n >>> 14;
        }
        int n5 = n3;
        if ((n4 & 0xFFFFFFFFFFFFC000L) != 0x0L) {
            n5 = n3 + 1;
        }
        return n5;
    }
    
    public static int b0(final int n) {
        return n >> 31 ^ n << 1;
    }
    
    static boolean c() {
        return CodedOutputStream.d;
    }
    
    public static long c0(final long n) {
        return n >> 63 ^ n << 1;
    }
    
    public static int e(final int n, final boolean b) {
        return W(n) + f(b);
    }
    
    public static int f(final boolean b) {
        return 1;
    }
    
    public static int g(final byte[] array) {
        return D(array.length);
    }
    
    public static CodedOutputStream g0(final OutputStream outputStream, final int n) {
        return new d(outputStream, n);
    }
    
    public static int h(final int n, final ByteString byteString) {
        return W(n) + i(byteString);
    }
    
    public static CodedOutputStream h0(final byte[] array) {
        return i0(array, 0, array.length);
    }
    
    public static int i(final ByteString byteString) {
        return D(byteString.size());
    }
    
    public static CodedOutputStream i0(final byte[] array, final int n, final int n2) {
        return new c(array, n, n2);
    }
    
    public static int j(final int n, final double n2) {
        return W(n) + k(n2);
    }
    
    public static int k(final double n) {
        return 8;
    }
    
    public static int l(final int n, final int n2) {
        return W(n) + m(n2);
    }
    
    public static int m(final int n) {
        return x(n);
    }
    
    public static int n(final int n, final int n2) {
        return W(n) + o(n2);
    }
    
    public static int o(final int n) {
        return 4;
    }
    
    public static int p(final int n, final long n2) {
        return W(n) + q(n2);
    }
    
    public static int q(final long n) {
        return 8;
    }
    
    public static int r(final int n, final float n2) {
        return W(n) + s(n2);
    }
    
    public static int s(final float n) {
        return 4;
    }
    
    @Deprecated
    static int t(final int n, final MessageLite messageLite, final j0 j0) {
        return W(n) * 2 + v(messageLite, j0);
    }
    
    @Deprecated
    public static int u(final MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }
    
    @Deprecated
    static int v(final MessageLite messageLite, final j0 j0) {
        return ((AbstractMessageLite)messageLite).f(j0);
    }
    
    public static int w(final int n, final int n2) {
        return W(n) + x(n2);
    }
    
    public static int x(final int n) {
        if (n >= 0) {
            return Y(n);
        }
        return 10;
    }
    
    public static int y(final int n, final long n2) {
        return W(n) + z(n2);
    }
    
    public static int z(final long n) {
        return a0(n);
    }
    
    public abstract void A0(final int p0, final int p1) throws IOException;
    
    public abstract void B0(final int p0) throws IOException;
    
    public final void C0(final int n, final long n2) throws IOException {
        this.T0(n, n2);
    }
    
    public final void D0(final long n) throws IOException {
        this.U0(n);
    }
    
    abstract void E0(final int p0, final MessageLite p1, final j0 p2) throws IOException;
    
    public abstract void F0(final int p0, final MessageLite p1) throws IOException;
    
    public abstract void G0(final int p0, final ByteString p1) throws IOException;
    
    public final void H0(final int n, final int n2) throws IOException {
        this.s0(n, n2);
    }
    
    public final void I0(final int n) throws IOException {
        this.t0(n);
    }
    
    public final void J0(final int n, final long n2) throws IOException {
        this.u0(n, n2);
    }
    
    public final void K0(final long n) throws IOException {
        this.v0(n);
    }
    
    public final void L0(final int n, final int n2) throws IOException {
        this.R0(n, b0(n2));
    }
    
    public final void M0(final int n) throws IOException {
        this.S0(b0(n));
    }
    
    public final void N0(final int n, final long n2) throws IOException {
        this.T0(n, c0(n2));
    }
    
    public final void O0(final long n) throws IOException {
        this.U0(c0(n));
    }
    
    public abstract void P0(final int p0, final String p1) throws IOException;
    
    public abstract void Q0(final int p0, final int p1) throws IOException;
    
    public abstract void R0(final int p0, final int p1) throws IOException;
    
    public abstract void S0(final int p0) throws IOException;
    
    public abstract void T0(final int p0, final long p1) throws IOException;
    
    public abstract void U0(final long p0) throws IOException;
    
    @Override
    public abstract void b(final byte[] p0, final int p1, final int p2) throws IOException;
    
    public final void d() {
        if (this.j0() == 0) {
            return;
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }
    
    public abstract void d0() throws IOException;
    
    final void e0(final String s, final Utf8.UnpairedSurrogateException ex) throws IOException {
        CodedOutputStream.c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", ex);
        final byte[] bytes = s.getBytes(Internal.a);
        try {
            this.S0(bytes.length);
            this.b(bytes, 0, bytes.length);
        }
        catch (final OutOfSpaceException ex2) {
            throw ex2;
        }
        catch (final IndexOutOfBoundsException ex3) {
            throw new OutOfSpaceException(ex3);
        }
    }
    
    boolean f0() {
        return this.b;
    }
    
    public abstract int j0();
    
    public abstract void k0(final byte p0) throws IOException;
    
    public abstract void l0(final int p0, final boolean p1) throws IOException;
    
    public final void m0(final boolean b) throws IOException {
        this.k0((byte)(b ? 1 : 0));
    }
    
    public abstract void n0(final int p0, final ByteString p1) throws IOException;
    
    public final void o0(final int n, final double n2) throws IOException {
        this.u0(n, Double.doubleToRawLongBits(n2));
    }
    
    public final void p0(final double n) throws IOException {
        this.v0(Double.doubleToRawLongBits(n));
    }
    
    public final void q0(final int n, final int n2) throws IOException {
        this.A0(n, n2);
    }
    
    public final void r0(final int n) throws IOException {
        this.B0(n);
    }
    
    public abstract void s0(final int p0, final int p1) throws IOException;
    
    public abstract void t0(final int p0) throws IOException;
    
    public abstract void u0(final int p0, final long p1) throws IOException;
    
    public abstract void v0(final long p0) throws IOException;
    
    public final void w0(final int n, final float n2) throws IOException {
        this.s0(n, Float.floatToRawIntBits(n2));
    }
    
    public final void x0(final float n) throws IOException {
        this.t0(Float.floatToRawIntBits(n));
    }
    
    @Deprecated
    final void y0(final int n, final MessageLite messageLite, final j0 j0) throws IOException {
        this.Q0(n, 3);
        this.z0(messageLite, j0);
        this.Q0(n, 4);
    }
    
    @Deprecated
    final void z0(final MessageLite messageLite, final j0 j0) throws IOException {
        j0.j(messageLite, this.a);
    }
    
    public static class OutOfSpaceException extends IOException
    {
        private static final long serialVersionUID = -6947486886997889499L;
        
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
        
        OutOfSpaceException(final String s) {
            final StringBuilder sb = new StringBuilder();
            sb.append("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            sb.append(s);
            super(sb.toString());
        }
        
        OutOfSpaceException(final String s, final Throwable t) {
            final StringBuilder sb = new StringBuilder();
            sb.append("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            sb.append(s);
            super(sb.toString(), t);
        }
        
        OutOfSpaceException(final Throwable t) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", t);
        }
    }
    
    private abstract static class b extends CodedOutputStream
    {
        final byte[] e;
        final int f;
        int g;
        int h;
        
        b(final int n) {
            super(null);
            if (n >= 0) {
                final byte[] e = new byte[Math.max(n, 20)];
                this.e = e;
                this.f = e.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        
        final void V0(final byte b) {
            this.e[this.g++] = b;
            ++this.h;
        }
        
        final void W0(final int n) {
            final byte[] e = this.e;
            final int g = this.g;
            final int g2 = g + 1;
            this.g = g2;
            e[g] = (byte)(n & 0xFF);
            final int g3 = g2 + 1;
            this.g = g3;
            e[g2] = (byte)(n >> 8 & 0xFF);
            final int g4 = g3 + 1;
            this.g = g4;
            e[g3] = (byte)(n >> 16 & 0xFF);
            this.g = g4 + 1;
            e[g4] = (byte)(n >> 24 & 0xFF);
            this.h += 4;
        }
        
        final void X0(final long n) {
            final byte[] e = this.e;
            final int g = this.g;
            final int g2 = g + 1;
            this.g = g2;
            e[g] = (byte)(n & 0xFFL);
            final int g3 = g2 + 1;
            this.g = g3;
            e[g2] = (byte)(n >> 8 & 0xFFL);
            final int g4 = g3 + 1;
            this.g = g4;
            e[g3] = (byte)(n >> 16 & 0xFFL);
            final int g5 = g4 + 1;
            this.g = g5;
            e[g4] = (byte)(0xFFL & n >> 24);
            final int g6 = g5 + 1;
            this.g = g6;
            e[g5] = (byte)((int)(n >> 32) & 0xFF);
            final int g7 = g6 + 1;
            this.g = g7;
            e[g6] = (byte)((int)(n >> 40) & 0xFF);
            final int g8 = g7 + 1;
            this.g = g8;
            e[g7] = (byte)((int)(n >> 48) & 0xFF);
            this.g = g8 + 1;
            e[g8] = (byte)((int)(n >> 56) & 0xFF);
            this.h += 8;
        }
        
        final void Y0(final int n) {
            if (n >= 0) {
                this.a1(n);
            }
            else {
                this.b1(n);
            }
        }
        
        final void Z0(final int n, final int n2) {
            this.a1(WireFormat.c(n, n2));
        }
        
        final void a1(int n) {
            int n2 = n;
            if (CodedOutputStream.c()) {
                final long n3 = this.g;
                while ((n & 0xFFFFFF80) != 0x0) {
                    q0.M(this.e, this.g++, (byte)((n & 0x7F) | 0x80));
                    n >>>= 7;
                }
                q0.M(this.e, this.g++, (byte)n);
                n = (int)(this.g - n3);
                this.h += n;
                return;
            }
            while ((n2 & 0xFFFFFF80) != 0x0) {
                final byte[] e = this.e;
                n = this.g++;
                e[n] = (byte)((n2 & 0x7F) | 0x80);
                ++this.h;
                n2 >>>= 7;
            }
            final byte[] e2 = this.e;
            n = this.g++;
            e2[n] = (byte)n2;
            ++this.h;
        }
        
        final void b1(long n) {
            long n2 = n;
            if (CodedOutputStream.c()) {
                final long n3 = this.g;
                while ((n & 0xFFFFFFFFFFFFFF80L) != 0x0L) {
                    q0.M(this.e, this.g++, (byte)(((int)n & 0x7F) | 0x80));
                    n >>>= 7;
                }
                q0.M(this.e, this.g++, (byte)n);
                this.h += (int)(this.g - n3);
                return;
            }
            while ((n2 & 0xFFFFFFFFFFFFFF80L) != 0x0L) {
                this.e[this.g++] = (byte)(((int)n2 & 0x7F) | 0x80);
                ++this.h;
                n2 >>>= 7;
            }
            this.e[this.g++] = (byte)n2;
            ++this.h;
        }
        
        @Override
        public final int j0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }
    
    private static class c extends CodedOutputStream
    {
        private final byte[] e;
        private final int f;
        private final int g;
        private int h;
        
        c(final byte[] e, final int n, final int n2) {
            super(null);
            Objects.requireNonNull(e, "buffer");
            final int length = e.length;
            final int g = n + n2;
            if ((n | n2 | length - g) >= 0) {
                this.e = e;
                this.f = n;
                this.h = n;
                this.g = g;
                return;
            }
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", e.length, n, n2));
        }
        
        @Override
        public final void A0(final int n, final int n2) throws IOException {
            this.Q0(n, 0);
            this.B0(n2);
        }
        
        @Override
        public final void B0(final int n) throws IOException {
            if (n >= 0) {
                this.S0(n);
            }
            else {
                this.U0(n);
            }
        }
        
        @Override
        final void E0(final int n, final MessageLite messageLite, final j0 j0) throws IOException {
            this.Q0(n, 2);
            this.S0(((AbstractMessageLite)messageLite).f(j0));
            j0.j(messageLite, super.a);
        }
        
        @Override
        public final void F0(final int n, final MessageLite messageLite) throws IOException {
            this.Q0(1, 3);
            this.R0(2, n);
            this.Y0(3, messageLite);
            this.Q0(1, 4);
        }
        
        @Override
        public final void G0(final int n, final ByteString byteString) throws IOException {
            this.Q0(1, 3);
            this.R0(2, n);
            this.n0(3, byteString);
            this.Q0(1, 4);
        }
        
        @Override
        public final void P0(final int n, final String s) throws IOException {
            this.Q0(n, 2);
            this.a1(s);
        }
        
        @Override
        public final void Q0(final int n, final int n2) throws IOException {
            this.S0(WireFormat.c(n, n2));
        }
        
        @Override
        public final void R0(final int n, final int n2) throws IOException {
            this.Q0(n, 0);
            this.S0(n2);
        }
        
        @Override
        public final void S0(int n) throws IOException {
            int n2 = n;
            if (CodedOutputStream.c()) {
                n2 = n;
                if (!com.google.crypto.tink.shaded.protobuf.b.c()) {
                    n2 = n;
                    if (this.j0() >= 5) {
                        if ((n & 0xFFFFFF80) == 0x0) {
                            q0.M(this.e, this.h++, (byte)n);
                            return;
                        }
                        q0.M(this.e, this.h++, (byte)(n | 0x80));
                        n >>>= 7;
                        if ((n & 0xFFFFFF80) == 0x0) {
                            q0.M(this.e, this.h++, (byte)n);
                            return;
                        }
                        q0.M(this.e, this.h++, (byte)(n | 0x80));
                        n >>>= 7;
                        if ((n & 0xFFFFFF80) == 0x0) {
                            q0.M(this.e, this.h++, (byte)n);
                            return;
                        }
                        q0.M(this.e, this.h++, (byte)(n | 0x80));
                        n >>>= 7;
                        if ((n & 0xFFFFFF80) == 0x0) {
                            q0.M(this.e, this.h++, (byte)n);
                            return;
                        }
                        q0.M(this.e, this.h++, (byte)(n | 0x80));
                        q0.M(this.e, this.h++, (byte)(n >>> 7));
                        return;
                    }
                }
            }
            while (true) {
                Label_0348: {
                    if ((n2 & 0xFFFFFF80) != 0x0) {
                        break Label_0348;
                    }
                    try {
                        final byte[] e = this.e;
                        n = this.h++;
                        e[n] = (byte)n2;
                        return;
                        final byte[] e2 = this.e;
                        n = this.h++;
                        e2[n] = (byte)((n2 & 0x7F) | 0x80);
                        n2 >>>= 7;
                    }
                    catch (final IndexOutOfBoundsException ex) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", this.h, this.g, 1), ex);
                    }
                }
            }
        }
        
        @Override
        public final void T0(final int n, final long n2) throws IOException {
            this.Q0(n, 0);
            this.U0(n2);
        }
        
        @Override
        public final void U0(long n) throws IOException {
            long n2 = n;
            if (CodedOutputStream.c()) {
                n2 = n;
                if (this.j0() >= 10) {
                    while ((n & 0xFFFFFFFFFFFFFF80L) != 0x0L) {
                        q0.M(this.e, this.h++, (byte)(((int)n & 0x7F) | 0x80));
                        n >>>= 7;
                    }
                    q0.M(this.e, this.h++, (byte)n);
                    return;
                }
            }
            while (true) {
                Label_0141: {
                    if ((n2 & 0xFFFFFFFFFFFFFF80L) != 0x0L) {
                        break Label_0141;
                    }
                    try {
                        this.e[this.h++] = (byte)n2;
                        return;
                        this.e[this.h++] = (byte)(((int)n2 & 0x7F) | 0x80);
                        n2 >>>= 7;
                    }
                    catch (final IndexOutOfBoundsException ex) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", this.h, this.g, 1), ex);
                    }
                }
            }
        }
        
        public final void V0(final ByteBuffer byteBuffer) throws IOException {
            final int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.e, this.h, remaining);
                this.h += remaining;
            }
            catch (final IndexOutOfBoundsException ex) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", this.h, this.g, remaining), ex);
            }
        }
        
        public final void W0(final byte[] array, final int n, final int n2) throws IOException {
            try {
                System.arraycopy(array, n, this.e, this.h, n2);
                this.h += n2;
            }
            catch (final IndexOutOfBoundsException ex) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", this.h, this.g, n2), ex);
            }
        }
        
        public final void X0(final ByteString byteString) throws IOException {
            this.S0(byteString.size());
            byteString.writeTo(this);
        }
        
        public final void Y0(final int n, final MessageLite messageLite) throws IOException {
            this.Q0(n, 2);
            this.Z0(messageLite);
        }
        
        public final void Z0(final MessageLite messageLite) throws IOException {
            this.S0(messageLite.getSerializedSize());
            messageLite.e(this);
        }
        
        @Override
        public final void a(final ByteBuffer byteBuffer) throws IOException {
            this.V0(byteBuffer);
        }
        
        public final void a1(final String s) throws IOException {
            final int h = this.h;
            try {
                final int y = CodedOutputStream.Y(s.length() * 3);
                final int y2 = CodedOutputStream.Y(s.length());
                if (y2 == y) {
                    final int h2 = h + y2;
                    this.h = h2;
                    final int i = Utf8.i(s, this.e, h2, this.j0());
                    this.S0(i - (this.h = h) - y2);
                    this.h = i;
                }
                else {
                    this.S0(Utf8.j(s));
                    this.h = Utf8.i(s, this.e, this.h, this.j0());
                }
            }
            catch (final IndexOutOfBoundsException ex) {
                throw new OutOfSpaceException(ex);
            }
            catch (final Utf8.UnpairedSurrogateException ex2) {
                this.h = h;
                this.e0(s, ex2);
            }
        }
        
        @Override
        public final void b(final byte[] array, final int n, final int n2) throws IOException {
            this.W0(array, n, n2);
        }
        
        @Override
        public void d0() {
        }
        
        @Override
        public final int j0() {
            return this.g - this.h;
        }
        
        @Override
        public final void k0(final byte b) throws IOException {
            try {
                this.e[this.h++] = b;
            }
            catch (final IndexOutOfBoundsException ex) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", this.h, this.g, 1), ex);
            }
        }
        
        @Override
        public final void l0(final int n, final boolean b) throws IOException {
            this.Q0(n, 0);
            this.k0((byte)(b ? 1 : 0));
        }
        
        @Override
        public final void n0(final int n, final ByteString byteString) throws IOException {
            this.Q0(n, 2);
            this.X0(byteString);
        }
        
        @Override
        public final void s0(final int n, final int n2) throws IOException {
            this.Q0(n, 5);
            this.t0(n2);
        }
        
        @Override
        public final void t0(final int n) throws IOException {
            try {
                final byte[] e = this.e;
                final int h = this.h;
                final int h2 = h + 1;
                this.h = h2;
                e[h] = (byte)(n & 0xFF);
                final int h3 = h2 + 1;
                this.h = h3;
                e[h2] = (byte)(n >> 8 & 0xFF);
                final int h4 = h3 + 1;
                this.h = h4;
                e[h3] = (byte)(n >> 16 & 0xFF);
                this.h = h4 + 1;
                e[h4] = (byte)(n >> 24 & 0xFF);
            }
            catch (final IndexOutOfBoundsException ex) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", this.h, this.g, 1), ex);
            }
        }
        
        @Override
        public final void u0(final int n, final long n2) throws IOException {
            this.Q0(n, 1);
            this.v0(n2);
        }
        
        @Override
        public final void v0(final long n) throws IOException {
            try {
                final byte[] e = this.e;
                final int h = this.h;
                final int h2 = h + 1;
                this.h = h2;
                e[h] = (byte)((int)n & 0xFF);
                final int h3 = h2 + 1;
                this.h = h3;
                e[h2] = (byte)((int)(n >> 8) & 0xFF);
                final int h4 = h3 + 1;
                this.h = h4;
                e[h3] = (byte)((int)(n >> 16) & 0xFF);
                final int h5 = h4 + 1;
                this.h = h5;
                e[h4] = (byte)((int)(n >> 24) & 0xFF);
                final int h6 = h5 + 1;
                this.h = h6;
                e[h5] = (byte)((int)(n >> 32) & 0xFF);
                final int h7 = h6 + 1;
                this.h = h7;
                e[h6] = (byte)((int)(n >> 40) & 0xFF);
                final int h8 = h7 + 1;
                this.h = h8;
                e[h7] = (byte)((int)(n >> 48) & 0xFF);
                this.h = h8 + 1;
                e[h8] = (byte)((int)(n >> 56) & 0xFF);
            }
            catch (final IndexOutOfBoundsException ex) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", this.h, this.g, 1), ex);
            }
        }
    }
    
    private static final class d extends b
    {
        private final OutputStream i;
        
        d(final OutputStream i, final int n) {
            super(n);
            Objects.requireNonNull(i, "out");
            this.i = i;
        }
        
        private void c1() throws IOException {
            this.i.write(super.e, 0, super.g);
            super.g = 0;
        }
        
        private void d1(final int n) throws IOException {
            if (super.f - super.g < n) {
                this.c1();
            }
        }
        
        @Override
        public void A0(final int n, final int n2) throws IOException {
            this.d1(20);
            ((b)this).Z0(n, 0);
            ((b)this).Y0(n2);
        }
        
        @Override
        public void B0(final int n) throws IOException {
            if (n >= 0) {
                this.S0(n);
            }
            else {
                this.U0(n);
            }
        }
        
        @Override
        void E0(final int n, final MessageLite messageLite, final j0 j0) throws IOException {
            this.Q0(n, 2);
            this.j1(messageLite, j0);
        }
        
        @Override
        public void F0(final int n, final MessageLite messageLite) throws IOException {
            this.Q0(1, 3);
            this.R0(2, n);
            this.h1(3, messageLite);
            this.Q0(1, 4);
        }
        
        @Override
        public void G0(final int n, final ByteString byteString) throws IOException {
            this.Q0(1, 3);
            this.R0(2, n);
            this.n0(3, byteString);
            this.Q0(1, 4);
        }
        
        @Override
        public void P0(final int n, final String s) throws IOException {
            this.Q0(n, 2);
            this.k1(s);
        }
        
        @Override
        public void Q0(final int n, final int n2) throws IOException {
            this.S0(WireFormat.c(n, n2));
        }
        
        @Override
        public void R0(final int n, final int n2) throws IOException {
            this.d1(20);
            ((b)this).Z0(n, 0);
            ((b)this).a1(n2);
        }
        
        @Override
        public void S0(final int n) throws IOException {
            this.d1(5);
            ((b)this).a1(n);
        }
        
        @Override
        public void T0(final int n, final long n2) throws IOException {
            this.d1(20);
            ((b)this).Z0(n, 0);
            ((b)this).b1(n2);
        }
        
        @Override
        public void U0(final long n) throws IOException {
            this.d1(10);
            ((b)this).b1(n);
        }
        
        @Override
        public void a(final ByteBuffer byteBuffer) throws IOException {
            this.e1(byteBuffer);
        }
        
        @Override
        public void b(final byte[] array, final int n, final int n2) throws IOException {
            this.f1(array, n, n2);
        }
        
        @Override
        public void d0() throws IOException {
            if (super.g > 0) {
                this.c1();
            }
        }
        
        public void e1(final ByteBuffer byteBuffer) throws IOException {
            final int remaining = byteBuffer.remaining();
            final int f = super.f;
            final int g = super.g;
            if (f - g >= remaining) {
                byteBuffer.get(super.e, g, remaining);
                super.g += remaining;
                super.h += remaining;
            }
            else {
                final int n = f - g;
                byteBuffer.get(super.e, g, n);
                int g2 = remaining - n;
                super.g = super.f;
                super.h += n;
                this.c1();
                while (true) {
                    final int f2 = super.f;
                    if (g2 <= f2) {
                        break;
                    }
                    byteBuffer.get(super.e, 0, f2);
                    this.i.write(super.e, 0, super.f);
                    final int f3 = super.f;
                    g2 -= f3;
                    super.h += f3;
                }
                byteBuffer.get(super.e, 0, g2);
                super.g = g2;
                super.h += g2;
            }
        }
        
        public void f1(final byte[] array, int n, int g) throws IOException {
            final int f = super.f;
            final int g2 = super.g;
            if (f - g2 >= g) {
                System.arraycopy(array, n, super.e, g2, g);
                super.g += g;
                super.h += g;
            }
            else {
                final int n2 = f - g2;
                System.arraycopy(array, n, super.e, g2, n2);
                n += n2;
                g -= n2;
                super.g = super.f;
                super.h += n2;
                this.c1();
                if (g <= super.f) {
                    System.arraycopy(array, n, super.e, 0, g);
                    super.g = g;
                }
                else {
                    this.i.write(array, n, g);
                }
                super.h += g;
            }
        }
        
        public void g1(final ByteString byteString) throws IOException {
            this.S0(byteString.size());
            byteString.writeTo(this);
        }
        
        public void h1(final int n, final MessageLite messageLite) throws IOException {
            this.Q0(n, 2);
            this.i1(messageLite);
        }
        
        public void i1(final MessageLite messageLite) throws IOException {
            this.S0(messageLite.getSerializedSize());
            messageLite.e(this);
        }
        
        void j1(final MessageLite messageLite, final j0 j0) throws IOException {
            this.S0(((AbstractMessageLite)messageLite).f(j0));
            j0.j(messageLite, super.a);
        }
        
        @Override
        public void k0(final byte b) throws IOException {
            if (super.g == super.f) {
                this.c1();
            }
            ((b)this).V0(b);
        }
        
        public void k1(final String s) throws IOException {
            try {
                final int n = s.length() * 3;
                final int y = CodedOutputStream.Y(n);
                final int n2 = y + n;
                final int f = super.f;
                if (n2 > f) {
                    final byte[] array = new byte[n];
                    final int i = Utf8.i(s, array, 0, n);
                    this.S0(i);
                    this.b(array, 0, i);
                    return;
                }
                if (n2 > f - super.g) {
                    this.c1();
                }
                final int y2 = CodedOutputStream.Y(s.length());
                final int g = super.g;
                Label_0150: {
                    if (y2 != y) {
                        break Label_0150;
                    }
                    final int g2 = g + y2;
                    try {
                        super.g = g2;
                        final int j = Utf8.i(s, super.e, g2, super.f - g2);
                        super.g = g;
                        int k = j - g - y2;
                        ((b)this).a1(k);
                        super.g = j;
                        super.h += k;
                        return;
                        k = Utf8.j(s);
                        ((b)this).a1(k);
                        super.g = Utf8.i(s, super.e, super.g, k);
                    }
                    catch (final ArrayIndexOutOfBoundsException ex) {
                        throw new OutOfSpaceException(ex);
                    }
                    catch (final Utf8.UnpairedSurrogateException ex2) {
                        try {
                            super.h -= super.g - g;
                            super.g = g;
                            throw ex2;
                        }
                        catch (final Utf8.UnpairedSurrogateException ex3) {
                            this.e0(s, ex3);
                        }
                    }
                }
            }
            catch (final Utf8.UnpairedSurrogateException ex4) {}
        }
        
        @Override
        public void l0(final int n, final boolean b) throws IOException {
            this.d1(11);
            ((b)this).Z0(n, 0);
            ((b)this).V0((byte)(b ? 1 : 0));
        }
        
        @Override
        public void n0(final int n, final ByteString byteString) throws IOException {
            this.Q0(n, 2);
            this.g1(byteString);
        }
        
        @Override
        public void s0(final int n, final int n2) throws IOException {
            this.d1(14);
            ((b)this).Z0(n, 5);
            ((b)this).W0(n2);
        }
        
        @Override
        public void t0(final int n) throws IOException {
            this.d1(4);
            ((b)this).W0(n);
        }
        
        @Override
        public void u0(final int n, final long n2) throws IOException {
            this.d1(18);
            ((b)this).Z0(n, 1);
            ((b)this).X0(n2);
        }
        
        @Override
        public void v0(final long n) throws IOException {
            this.d1(8);
            ((b)this).X0(n);
        }
    }
}
