// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Objects;
import java.util.Iterator;
import java.util.Arrays;
import java.lang.reflect.Field;
import java.util.Map;
import java.io.IOException;
import java.util.List;
import sun.misc.Unsafe;

final class z<T> implements j0<T>
{
    private static final int[] r;
    private static final Unsafe s;
    private final int[] a;
    private final Object[] b;
    private final int c;
    private final int d;
    private final MessageLite e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final int[] j;
    private final int k;
    private final int l;
    private final b0 m;
    private final q n;
    private final o0<?, ?> o;
    private final k<?> p;
    private final t q;
    
    static {
        r = new int[0];
        s = q0.F();
    }
    
    private z(final int[] a, final Object[] b, final int c, final int d, final MessageLite e, final boolean h, final boolean i, final int[] j, final int k, final int l, final b0 m, final q n, final o0<?, ?> o, final k<?> p15, final t q) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.g = (e instanceof GeneratedMessageLite);
        this.h = h;
        this.f = (p15 != null && p15.e(e));
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
        this.o = o;
        this.p = p15;
        this.e = e;
        this.q = q;
    }
    
    private static boolean A(final int n) {
        return (n & 0x20000000) != 0x0;
    }
    
    private boolean B(final T t, int n) {
        final boolean h = this.h;
        final boolean b = false;
        final boolean b2 = false;
        final boolean b3 = false;
        final boolean b4 = false;
        final boolean b5 = false;
        final boolean b6 = false;
        final boolean b7 = false;
        final boolean b8 = false;
        final boolean b9 = false;
        final boolean b10 = false;
        final boolean b11 = false;
        final boolean b12 = false;
        final boolean b13 = false;
        final boolean b14 = false;
        final boolean b15 = false;
        boolean b16 = false;
        if (!h) {
            n = this.h0(n);
            boolean b17 = b15;
            if ((q0.A(t, n & 0xFFFFF) & 1 << (n >>> 20)) != 0x0) {
                b17 = true;
            }
            return b17;
        }
        n = this.r0(n);
        final long u = U(n);
        switch (q0(n)) {
            default: {
                throw new IllegalArgumentException();
            }
            case 17: {
                if (q0.E(t, u) != null) {
                    b16 = true;
                }
                return b16;
            }
            case 16: {
                boolean b18 = b;
                if (q0.C(t, u) != 0L) {
                    b18 = true;
                }
                return b18;
            }
            case 15: {
                boolean b19 = b2;
                if (q0.A(t, u) != 0) {
                    b19 = true;
                }
                return b19;
            }
            case 14: {
                boolean b20 = b3;
                if (q0.C(t, u) != 0L) {
                    b20 = true;
                }
                return b20;
            }
            case 13: {
                boolean b21 = b4;
                if (q0.A(t, u) != 0) {
                    b21 = true;
                }
                return b21;
            }
            case 12: {
                boolean b22 = b5;
                if (q0.A(t, u) != 0) {
                    b22 = true;
                }
                return b22;
            }
            case 11: {
                boolean b23 = b6;
                if (q0.A(t, u) != 0) {
                    b23 = true;
                }
                return b23;
            }
            case 10: {
                return ByteString.EMPTY.equals(q0.E(t, u)) ^ true;
            }
            case 9: {
                boolean b24 = b7;
                if (q0.E(t, u) != null) {
                    b24 = true;
                }
                return b24;
            }
            case 8: {
                final Object e = q0.E(t, u);
                if (e instanceof String) {
                    return ((String)e).isEmpty() ^ true;
                }
                if (e instanceof ByteString) {
                    return ByteString.EMPTY.equals(e) ^ true;
                }
                throw new IllegalArgumentException();
            }
            case 7: {
                return q0.r(t, u);
            }
            case 6: {
                boolean b25 = b8;
                if (q0.A(t, u) != 0) {
                    b25 = true;
                }
                return b25;
            }
            case 5: {
                boolean b26 = b9;
                if (q0.C(t, u) != 0L) {
                    b26 = true;
                }
                return b26;
            }
            case 4: {
                boolean b27 = b10;
                if (q0.A(t, u) != 0) {
                    b27 = true;
                }
                return b27;
            }
            case 3: {
                boolean b28 = b11;
                if (q0.C(t, u) != 0L) {
                    b28 = true;
                }
                return b28;
            }
            case 2: {
                boolean b29 = b12;
                if (q0.C(t, u) != 0L) {
                    b29 = true;
                }
                return b29;
            }
            case 1: {
                boolean b30 = b13;
                if (q0.z(t, u) != 0.0f) {
                    b30 = true;
                }
                return b30;
            }
            case 0: {
                boolean b31 = b14;
                if (q0.y(t, u) != 0.0) {
                    b31 = true;
                }
                return b31;
            }
        }
    }
    
    private boolean C(final T t, final int n, final int n2, final int n3) {
        if (this.h) {
            return this.B(t, n);
        }
        return (n2 & n3) != 0x0;
    }
    
    private static boolean D(final Object o, final int n, final j0 j0) {
        return j0.c(q0.E(o, U(n)));
    }
    
    private <N> boolean E(final Object o, int i, final int n) {
        final List list = (List)q0.E(o, U(i));
        if (list.isEmpty()) {
            return true;
        }
        final j0 u = this.u(n);
        for (i = 0; i < list.size(); ++i) {
            if (!u.c(list.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    private boolean F(final T t, final int n, final int n2) {
        if (this.q.e(q0.E(t, U(n))).isEmpty()) {
            return true;
        }
        this.q.b(this.t(n2));
        throw null;
    }
    
    private boolean G(final T t, final T t2, final int n) {
        final long n2 = this.h0(n) & 0xFFFFF;
        return q0.A(t, n2) == q0.A(t2, n2);
    }
    
    private boolean H(final T t, final int n, final int n2) {
        return q0.A(t, this.h0(n2) & 0xFFFFF) == n;
    }
    
    private static boolean I(final int n) {
        return (n & 0x10000000) != 0x0;
    }
    
    private static List<?> J(final Object o, final long n) {
        return (List)q0.E(o, n);
    }
    
    private static <T> long K(final T t, final long n) {
        return q0.C(t, n);
    }
    
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void L(final o0<UT, UB> o0, final k<ET> k, final T t, final i0 i0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        InvalidProtocolBufferException.InvalidWireTypeException ex = null;
        FieldSet set = null;
        while (true) {
            Object p5 = ex;
            try {
                final int z = i0.z();
                p5 = ex;
                final int f0 = this.f0(z);
                if (f0 < 0) {
                    if (z == Integer.MAX_VALUE) {
                        return;
                    }
                    p5 = ex;
                    Object b;
                    if (!this.f) {
                        b = null;
                    }
                    else {
                        p5 = ex;
                        b = k.b(extensionRegistryLite, this.e, z);
                    }
                    if (b == null) {
                        p5 = ex;
                        if (o0.q(i0)) {
                            p5 = ex;
                            if (i0.C()) {
                                continue;
                            }
                        }
                        else {
                            Object f2;
                            if ((f2 = ex) == null) {
                                p5 = ex;
                                f2 = o0.f(t);
                            }
                            p5 = f2;
                            if (o0.m((InvalidProtocolBufferException.InvalidWireTypeException)f2, i0)) {
                                ex = (InvalidProtocolBufferException.InvalidWireTypeException)f2;
                                continue;
                            }
                        }
                        return;
                    }
                    FieldSet d;
                    if ((d = set) == null) {
                        p5 = ex;
                        d = k.d(t);
                    }
                    p5 = ex;
                    ex = k.g(i0, b, extensionRegistryLite, d, ex, o0);
                    set = d;
                }
                else {
                    p5 = ex;
                    final int r0 = this.r0(f0);
                    InvalidProtocolBufferException.InvalidWireTypeException ex2 = ex;
                    p5 = ex;
                    try {
                        switch (q0(r0)) {
                            default: {
                                InvalidProtocolBufferException.InvalidWireTypeException n = ex;
                                if (ex == null) {
                                    ex2 = ex;
                                    p5 = ex;
                                    n = o0.n();
                                }
                                ex2 = n;
                                p5 = n;
                                final boolean m = o0.m(n, i0);
                                ex = n;
                                if (!m) {
                                    return;
                                }
                                continue;
                            }
                            case 68: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.I((j0<Object>)this.u(f0), extensionRegistryLite));
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 67: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.x());
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 66: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.k());
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 65: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.e());
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 64: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.D());
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 63: {
                                ex2 = ex;
                                p5 = ex;
                                final int j = i0.j();
                                ex2 = ex;
                                p5 = ex;
                                final Internal.EnumVerifier s = this.s(f0);
                                if (s != null) {
                                    ex2 = ex;
                                    p5 = ex;
                                    if (!s.a(j)) {
                                        ex2 = ex;
                                        p5 = ex;
                                        ex = l0.L(z, j, ex, (o0<UT, InvalidProtocolBufferException.InvalidWireTypeException>)o0);
                                        continue;
                                    }
                                }
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), j);
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 62: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.g());
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 61: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.n());
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 60: {
                                ex2 = ex;
                                p5 = ex;
                                if (this.H(t, z, f0)) {
                                    ex2 = ex;
                                    p5 = ex;
                                    final Object h = Internal.h(q0.E(t, U(r0)), i0.M((j0<Object>)this.u(f0), extensionRegistryLite));
                                    ex2 = ex;
                                    p5 = ex;
                                    q0.T(t, U(r0), h);
                                }
                                else {
                                    ex2 = ex;
                                    p5 = ex;
                                    q0.T(t, U(r0), i0.M((j0<Object>)this.u(f0), extensionRegistryLite));
                                    ex2 = ex;
                                    p5 = ex;
                                    this.n0(t, f0);
                                }
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 59: {
                                ex2 = ex;
                                p5 = ex;
                                this.k0(t, r0, i0);
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 58: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.d());
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 57: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.t());
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 56: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.a());
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 55: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.o());
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 54: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.r());
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 53: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.G());
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 52: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.readFloat());
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 51: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.readDouble());
                                ex2 = ex;
                                p5 = ex;
                                this.o0(t, z, f0);
                                continue;
                            }
                            case 50: {
                                ex2 = ex;
                                p5 = ex;
                                this.M(t, f0, this.t(f0), extensionRegistryLite, i0);
                                continue;
                            }
                            case 49: {
                                ex2 = ex;
                                p5 = ex;
                                this.i0(t, U(r0), i0, (j0<Object>)this.u(f0), extensionRegistryLite);
                                continue;
                            }
                            case 48: {
                                ex2 = ex;
                                p5 = ex;
                                i0.c((List<Long>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 47: {
                                ex2 = ex;
                                p5 = ex;
                                i0.q((List<Integer>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 46: {
                                ex2 = ex;
                                p5 = ex;
                                i0.u((List<Long>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 45: {
                                ex2 = ex;
                                p5 = ex;
                                i0.b((List<Integer>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 44: {
                                ex2 = ex;
                                p5 = ex;
                                final List<Object> e = this.n.e(t, U(r0));
                                ex2 = ex;
                                p5 = ex;
                                i0.i((List<Integer>)e);
                                ex2 = ex;
                                p5 = ex;
                                ex = l0.A(z, (List<Integer>)e, this.s(f0), ex, (o0<Object, InvalidProtocolBufferException.InvalidWireTypeException>)o0);
                                continue;
                            }
                            case 43: {
                                ex2 = ex;
                                p5 = ex;
                                i0.s((List<Integer>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 42: {
                                ex2 = ex;
                                p5 = ex;
                                i0.l((List<Boolean>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 41: {
                                ex2 = ex;
                                p5 = ex;
                                i0.w((List<Integer>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 40: {
                                ex2 = ex;
                                p5 = ex;
                                i0.p((List<Long>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 39: {
                                ex2 = ex;
                                p5 = ex;
                                i0.v((List<Integer>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 38: {
                                ex2 = ex;
                                p5 = ex;
                                i0.f((List<Long>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 37: {
                                ex2 = ex;
                                p5 = ex;
                                i0.h((List<Long>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 36: {
                                ex2 = ex;
                                p5 = ex;
                                i0.B((List<Float>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 35: {
                                ex2 = ex;
                                p5 = ex;
                                i0.F((List<Double>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 34: {
                                ex2 = ex;
                                p5 = ex;
                                i0.c((List<Long>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 33: {
                                ex2 = ex;
                                p5 = ex;
                                i0.q((List<Integer>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 32: {
                                ex2 = ex;
                                p5 = ex;
                                i0.u((List<Long>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 31: {
                                ex2 = ex;
                                p5 = ex;
                                i0.b((List<Integer>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 30: {
                                ex2 = ex;
                                p5 = ex;
                                final List<Object> e2 = this.n.e(t, U(r0));
                                ex2 = ex;
                                p5 = ex;
                                i0.i((List<Integer>)e2);
                                ex2 = ex;
                                p5 = ex;
                                ex = l0.A(z, (List<Integer>)e2, this.s(f0), ex, (o0<Object, InvalidProtocolBufferException.InvalidWireTypeException>)o0);
                                continue;
                            }
                            case 29: {
                                ex2 = ex;
                                p5 = ex;
                                i0.s((List<Integer>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 28: {
                                ex2 = ex;
                                p5 = ex;
                                i0.E((List<ByteString>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 27: {
                                ex2 = ex;
                                p5 = ex;
                                this.j0(t, r0, i0, (j0<Object>)this.u(f0), extensionRegistryLite);
                                continue;
                            }
                            case 26: {
                                ex2 = ex;
                                p5 = ex;
                                this.l0(t, r0, i0);
                                continue;
                            }
                            case 25: {
                                ex2 = ex;
                                p5 = ex;
                                i0.l((List<Boolean>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 24: {
                                ex2 = ex;
                                p5 = ex;
                                i0.w((List<Integer>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 23: {
                                ex2 = ex;
                                p5 = ex;
                                i0.p((List<Long>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 22: {
                                ex2 = ex;
                                p5 = ex;
                                i0.v((List<Integer>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 21: {
                                ex2 = ex;
                                p5 = ex;
                                i0.f((List<Long>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 20: {
                                ex2 = ex;
                                p5 = ex;
                                i0.h((List<Long>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 19: {
                                ex2 = ex;
                                p5 = ex;
                                i0.B((List<Float>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 18: {
                                ex2 = ex;
                                p5 = ex;
                                i0.F((List<Double>)this.n.e(t, U(r0)));
                                continue;
                            }
                            case 17: {
                                ex2 = ex;
                                p5 = ex;
                                if (this.B(t, f0)) {
                                    ex2 = ex;
                                    p5 = ex;
                                    final Object h2 = Internal.h(q0.E(t, U(r0)), i0.I((j0<Object>)this.u(f0), extensionRegistryLite));
                                    ex2 = ex;
                                    p5 = ex;
                                    q0.T(t, U(r0), h2);
                                    continue;
                                }
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.I((j0<Object>)this.u(f0), extensionRegistryLite));
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 16: {
                                ex2 = ex;
                                p5 = ex;
                                q0.S(t, U(r0), i0.x());
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 15: {
                                ex2 = ex;
                                p5 = ex;
                                q0.R(t, U(r0), i0.k());
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 14: {
                                ex2 = ex;
                                p5 = ex;
                                q0.S(t, U(r0), i0.e());
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 13: {
                                ex2 = ex;
                                p5 = ex;
                                q0.R(t, U(r0), i0.D());
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 12: {
                                ex2 = ex;
                                p5 = ex;
                                final int l = i0.j();
                                ex2 = ex;
                                p5 = ex;
                                final Internal.EnumVerifier s2 = this.s(f0);
                                if (s2 != null) {
                                    ex2 = ex;
                                    p5 = ex;
                                    if (!s2.a(l)) {
                                        ex2 = ex;
                                        p5 = ex;
                                        ex = l0.L(z, l, ex, (o0<Object, InvalidProtocolBufferException.InvalidWireTypeException>)o0);
                                        continue;
                                    }
                                }
                                ex2 = ex;
                                p5 = ex;
                                q0.R(t, U(r0), l);
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 11: {
                                ex2 = ex;
                                p5 = ex;
                                q0.R(t, U(r0), i0.g());
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 10: {
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.n());
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 9: {
                                ex2 = ex;
                                p5 = ex;
                                if (this.B(t, f0)) {
                                    ex2 = ex;
                                    p5 = ex;
                                    final Object h3 = Internal.h(q0.E(t, U(r0)), i0.M((j0<Object>)this.u(f0), extensionRegistryLite));
                                    ex2 = ex;
                                    p5 = ex;
                                    q0.T(t, U(r0), h3);
                                    continue;
                                }
                                ex2 = ex;
                                p5 = ex;
                                q0.T(t, U(r0), i0.M((j0<Object>)this.u(f0), extensionRegistryLite));
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 8: {
                                ex2 = ex;
                                p5 = ex;
                                this.k0(t, r0, i0);
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 7: {
                                ex2 = ex;
                                p5 = ex;
                                q0.J(t, U(r0), i0.d());
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 6: {
                                ex2 = ex;
                                p5 = ex;
                                q0.R(t, U(r0), i0.t());
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 5: {
                                ex2 = ex;
                                p5 = ex;
                                q0.S(t, U(r0), i0.a());
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 4: {
                                ex2 = ex;
                                p5 = ex;
                                q0.R(t, U(r0), i0.o());
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 3: {
                                ex2 = ex;
                                p5 = ex;
                                q0.S(t, U(r0), i0.r());
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 2: {
                                ex2 = ex;
                                p5 = ex;
                                q0.S(t, U(r0), i0.G());
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 1: {
                                ex2 = ex;
                                p5 = ex;
                                q0.Q(t, U(r0), i0.readFloat());
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                            case 0: {
                                ex2 = ex;
                                p5 = ex;
                                q0.P(t, U(r0), i0.readDouble());
                                ex2 = ex;
                                p5 = ex;
                                this.n0(t, f0);
                                continue;
                            }
                        }
                    }
                    catch (final InvalidProtocolBufferException.InvalidWireTypeException ex) {
                        p5 = ex2;
                        if (o0.q(i0)) {
                            p5 = ex2;
                            final boolean c = i0.C();
                            ex = ex2;
                            if (!c) {
                                return;
                            }
                            continue;
                        }
                        else {
                            InvalidProtocolBufferException.InvalidWireTypeException f3;
                            if ((f3 = ex2) == null) {
                                p5 = ex2;
                                f3 = o0.f(t);
                            }
                            p5 = f3;
                            final boolean m2 = o0.m(f3, i0);
                            ex = f3;
                            if (!m2) {
                                return;
                            }
                            continue;
                        }
                    }
                }
            }
            finally {
                for (int k2 = this.k; k2 < this.l; ++k2) {
                    p5 = this.p(t, this.j[k2], (InvalidProtocolBufferException.InvalidWireTypeException)p5, (o0<UT, InvalidProtocolBufferException.InvalidWireTypeException>)o0);
                }
                if (p5 != null) {
                    o0.o((Object)t, (InvalidProtocolBufferException.InvalidWireTypeException)p5);
                }
            }
        }
    }
    
    private final <K, V> void M(final Object o, final int n, final Object o2, final ExtensionRegistryLite extensionRegistryLite, final i0 i0) throws IOException {
        final long u = U(this.r0(n));
        final Object e = q0.E(o, u);
        Object o3;
        if (e == null) {
            o3 = this.q.d(o2);
            q0.T(o, u, o3);
        }
        else {
            o3 = e;
            if (this.q.h(e)) {
                o3 = this.q.d(o2);
                this.q.a(o3, e);
                q0.T(o, u, o3);
            }
        }
        final Map<?, ?> c = this.q.c(o3);
        this.q.b(o2);
        i0.K(c, null, extensionRegistryLite);
    }
    
    private void N(final T t, final T t2, final int n) {
        final long u = U(this.r0(n));
        if (!this.B(t2, n)) {
            return;
        }
        final Object e = q0.E(t, u);
        final Object e2 = q0.E(t2, u);
        if (e != null && e2 != null) {
            q0.T(t, u, Internal.h(e, e2));
            this.n0(t, n);
        }
        else if (e2 != null) {
            q0.T(t, u, e2);
            this.n0(t, n);
        }
    }
    
    private void O(final T t, final T t2, final int n) {
        final int r0 = this.r0(n);
        final int t3 = this.T(n);
        final long u = U(r0);
        if (!this.H(t2, t3, n)) {
            return;
        }
        final Object e = q0.E(t, u);
        final Object e2 = q0.E(t2, u);
        if (e != null && e2 != null) {
            q0.T(t, u, Internal.h(e, e2));
            this.o0(t, t3, n);
        }
        else if (e2 != null) {
            q0.T(t, u, e2);
            this.o0(t, t3, n);
        }
    }
    
    private void P(final T t, final T t2, final int n) {
        final int r0 = this.r0(n);
        final long u = U(r0);
        final int t3 = this.T(n);
        switch (q0(r0)) {
            case 68: {
                this.O(t, t2, n);
                break;
            }
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67: {
                if (this.H(t2, t3, n)) {
                    q0.T(t, u, q0.E(t2, u));
                    this.o0(t, t3, n);
                    break;
                }
                break;
            }
            case 60: {
                this.O(t, t2, n);
                break;
            }
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59: {
                if (this.H(t2, t3, n)) {
                    q0.T(t, u, q0.E(t2, u));
                    this.o0(t, t3, n);
                    break;
                }
                break;
            }
            case 50: {
                l0.F(this.q, t, t2, u);
                break;
            }
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49: {
                this.n.d(t, t2, u);
                break;
            }
            case 17: {
                this.N(t, t2, n);
                break;
            }
            case 16: {
                if (this.B(t2, n)) {
                    q0.S(t, u, q0.C(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
            case 15: {
                if (this.B(t2, n)) {
                    q0.R(t, u, q0.A(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
            case 14: {
                if (this.B(t2, n)) {
                    q0.S(t, u, q0.C(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
            case 13: {
                if (this.B(t2, n)) {
                    q0.R(t, u, q0.A(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
            case 12: {
                if (this.B(t2, n)) {
                    q0.R(t, u, q0.A(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
            case 11: {
                if (this.B(t2, n)) {
                    q0.R(t, u, q0.A(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
            case 10: {
                if (this.B(t2, n)) {
                    q0.T(t, u, q0.E(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
            case 9: {
                this.N(t, t2, n);
                break;
            }
            case 8: {
                if (this.B(t2, n)) {
                    q0.T(t, u, q0.E(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
            case 7: {
                if (this.B(t2, n)) {
                    q0.J(t, u, q0.r(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
            case 6: {
                if (this.B(t2, n)) {
                    q0.R(t, u, q0.A(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
            case 5: {
                if (this.B(t2, n)) {
                    q0.S(t, u, q0.C(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
            case 4: {
                if (this.B(t2, n)) {
                    q0.R(t, u, q0.A(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
            case 3: {
                if (this.B(t2, n)) {
                    q0.S(t, u, q0.C(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
            case 2: {
                if (this.B(t2, n)) {
                    q0.S(t, u, q0.C(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
            case 1: {
                if (this.B(t2, n)) {
                    q0.Q(t, u, q0.z(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
            case 0: {
                if (this.B(t2, n)) {
                    q0.P(t, u, q0.y(t2, u));
                    this.n0(t, n);
                    break;
                }
                break;
            }
        }
    }
    
    static <T> z<T> Q(final Class<T> clazz, final w w, final b0 b0, final q q, final o0<?, ?> o0, final k<?> k, final t t) {
        if (w instanceof h0) {
            return S((h0)w, b0, q, o0, k, t);
        }
        return R((StructuralMessageInfo)w, b0, q, o0, k, t);
    }
    
    static <T> z<T> R(final StructuralMessageInfo structuralMessageInfo, final b0 b0, final q q, final o0<?, ?> o0, final k<?> k, final t t) {
        final boolean b2 = structuralMessageInfo.c() == ProtoSyntax.PROTO3;
        final FieldInfo[] e = structuralMessageInfo.e();
        if (e.length != 0) {
            final FieldInfo fieldInfo = e[0];
            throw null;
        }
        final int length = e.length;
        final int[] array = new int[length * 3];
        final Object[] array2 = new Object[length * 2];
        if (e.length > 0) {
            final FieldInfo fieldInfo2 = e[0];
            throw null;
        }
        int[] array3;
        if ((array3 = structuralMessageInfo.d()) == null) {
            array3 = z.r;
        }
        if (e.length <= 0) {
            final int[] r = z.r;
            final int[] r2 = z.r;
            final int[] array4 = new int[array3.length + r.length + r2.length];
            System.arraycopy(array3, 0, array4, 0, array3.length);
            System.arraycopy(r, 0, array4, array3.length, r.length);
            System.arraycopy(r2, 0, array4, array3.length + r.length, r2.length);
            return new z<T>(array, array2, 0, 0, structuralMessageInfo.b(), b2, true, array4, array3.length, array3.length + r.length, b0, q, o0, k, t);
        }
        final FieldInfo fieldInfo3 = e[0];
        throw null;
    }
    
    static <T> z<T> S(final h0 h0, final b0 b0, final q q, final o0<?, ?> o0, final k<?> k, final t t) {
        final ProtoSyntax c = h0.c();
        final ProtoSyntax proto3 = ProtoSyntax.PROTO3;
        int n = 0;
        final boolean b2 = c == proto3;
        final String e = h0.e();
        final int length = e.length();
        int char1 = e.charAt(0);
        int n6;
        if (char1 >= 55296) {
            int n2 = char1 & 0x1FFF;
            int n3 = 1;
            int n4 = 13;
            int n5;
            char char2;
            while (true) {
                n5 = n3 + 1;
                char2 = e.charAt(n3);
                if (char2 < '\ud800') {
                    break;
                }
                n2 |= (char2 & '\u1fff') << n4;
                n4 += 13;
                n3 = n5;
            }
            char1 = (n2 | char2 << n4);
            n6 = n5;
        }
        else {
            n6 = 1;
        }
        final int n7 = n6 + 1;
        final char char3 = e.charAt(n6);
        int i = n7;
        int n8 = char3;
        if (char3 >= '\ud800') {
            int n9 = char3 & '\u1fff';
            int n10 = 13;
            int n11 = n7;
            int n12;
            char char4;
            while (true) {
                n12 = n11 + 1;
                char4 = e.charAt(n11);
                if (char4 < '\ud800') {
                    break;
                }
                n9 |= (char4 & '\u1fff') << n10;
                n10 += 13;
                n11 = n12;
            }
            n8 = (n9 | char4 << n10);
            i = n12;
        }
        int[] r;
        int n13;
        int n14;
        int n16;
        int n18;
        int n17;
        int n19;
        if (n8 == 0) {
            r = z.r;
            n13 = 0;
            n14 = 0;
            final int n15 = n16 = n14;
            n17 = (n18 = n16);
            n19 = n15;
        }
        else {
            final int n20 = i + 1;
            int char5;
            final char c2 = (char)(char5 = e.charAt(i));
            int n21 = n20;
            if (c2 >= '\ud800') {
                final int n22 = c2 & '\u1fff';
                int n23 = 13;
                int n24 = n20;
                int n25 = n22;
                int n26;
                char char6;
                while (true) {
                    n26 = n24 + 1;
                    char6 = e.charAt(n24);
                    if (char6 < '\ud800') {
                        break;
                    }
                    n25 |= (char6 & '\u1fff') << n23;
                    n23 += 13;
                    n24 = n26;
                }
                final int n27 = n25 | char6 << n23;
                n21 = n26;
                char5 = n27;
            }
            final int n28 = n21 + 1;
            int char7;
            final char c3 = (char)(char7 = e.charAt(n21));
            int n29 = n28;
            if (c3 >= '\ud800') {
                int n30 = c3 & '\u1fff';
                int n31 = 13;
                int n32 = n28;
                int n33;
                char char8;
                while (true) {
                    n33 = n32 + 1;
                    char8 = e.charAt(n32);
                    if (char8 < '\ud800') {
                        break;
                    }
                    n30 |= (char8 & '\u1fff') << n31;
                    n31 += 13;
                    n32 = n33;
                }
                char7 = (n30 | char8 << n31);
                n29 = n33;
            }
            final int n34 = n29 + 1;
            int char9;
            final char c4 = (char)(char9 = e.charAt(n29));
            int n35 = n34;
            if (c4 >= '\ud800') {
                final int n36 = c4 & '\u1fff';
                int n37 = 13;
                int n38 = n34;
                int n39 = n36;
                int n40;
                char char10;
                while (true) {
                    n40 = n38 + 1;
                    char10 = e.charAt(n38);
                    if (char10 < '\ud800') {
                        break;
                    }
                    n39 |= (char10 & '\u1fff') << n37;
                    n37 += 13;
                    n38 = n40;
                }
                final int n41 = n39 | char10 << n37;
                n35 = n40;
                char9 = n41;
            }
            final int n42 = n35 + 1;
            int char11;
            final char c5 = (char)(char11 = e.charAt(n35));
            int n43 = n42;
            if (c5 >= '\ud800') {
                final int n44 = c5 & '\u1fff';
                int n45 = 13;
                int n46 = n42;
                int n47 = n44;
                int n48;
                char char12;
                while (true) {
                    n48 = n46 + 1;
                    char12 = e.charAt(n46);
                    if (char12 < '\ud800') {
                        break;
                    }
                    n47 |= (char12 & '\u1fff') << n45;
                    n45 += 13;
                    n46 = n48;
                }
                final int n49 = n47 | char12 << n45;
                n43 = n48;
                char11 = n49;
            }
            final int n50 = n43 + 1;
            int char13;
            final char c6 = (char)(char13 = e.charAt(n43));
            int n51 = n50;
            if (c6 >= '\ud800') {
                final int n52 = c6 & '\u1fff';
                int n53 = 13;
                int n54 = n50;
                int n55 = n52;
                int n56;
                char char14;
                while (true) {
                    n56 = n54 + 1;
                    char14 = e.charAt(n54);
                    if (char14 < '\ud800') {
                        break;
                    }
                    n55 |= (char14 & '\u1fff') << n53;
                    n53 += 13;
                    n54 = n56;
                }
                final int n57 = n55 | char14 << n53;
                n51 = n56;
                char13 = n57;
            }
            final int n58 = n51 + 1;
            int char15;
            final char c7 = (char)(char15 = e.charAt(n51));
            int n59 = n58;
            if (c7 >= '\ud800') {
                final int n60 = c7 & '\u1fff';
                int n61 = 13;
                int n62 = n58;
                int n63 = n60;
                int n64;
                char char16;
                while (true) {
                    n64 = n62 + 1;
                    char16 = e.charAt(n62);
                    if (char16 < '\ud800') {
                        break;
                    }
                    n63 |= (char16 & '\u1fff') << n61;
                    n61 += 13;
                    n62 = n64;
                }
                final int n65 = n63 | char16 << n61;
                n59 = n64;
                char15 = n65;
            }
            final int n66 = n59 + 1;
            int char17;
            final char c8 = (char)(char17 = e.charAt(n59));
            int n67 = n66;
            if (c8 >= '\ud800') {
                int n68 = c8 & '\u1fff';
                int n69 = 13;
                int n70 = n66;
                int n71;
                char char18;
                while (true) {
                    n71 = n70 + 1;
                    char18 = e.charAt(n70);
                    if (char18 < '\ud800') {
                        break;
                    }
                    n68 |= (char18 & '\u1fff') << n69;
                    n69 += 13;
                    n70 = n71;
                }
                char17 = (n68 | char18 << n69);
                n67 = n71;
            }
            final int n72 = n67 + 1;
            int char19;
            final char c9 = (char)(char19 = e.charAt(n67));
            int n73 = n72;
            if (c9 >= '\ud800') {
                final int n74 = c9 & '\u1fff';
                int n75 = n72;
                int n76 = 13;
                int n77 = n74;
                int n78;
                char char20;
                while (true) {
                    n78 = n75 + 1;
                    char20 = e.charAt(n75);
                    if (char20 < '\ud800') {
                        break;
                    }
                    n77 |= (char20 & '\u1fff') << n76;
                    n76 += 13;
                    n75 = n78;
                }
                final int n79 = n77 | char20 << n76;
                n73 = n78;
                char19 = n79;
            }
            r = new int[char19 + char15 + char17];
            final int n80 = char5 * 2 + char7;
            final int n81 = n73;
            n = char9;
            final int n82 = char15;
            n17 = char19;
            n16 = n80;
            n19 = char13;
            n14 = char11;
            n13 = n82;
            n18 = char5;
            i = n81;
        }
        final Unsafe s = z.s;
        final Object[] d = h0.d();
        final Class<? extends MessageLite> class1 = h0.b().getClass();
        final int[] array = new int[n19 * 3];
        final Object[] array2 = new Object[n19 * 2];
        final int n83 = n17 + n13;
        int n84 = n17;
        int n85 = n83;
        int n86 = 0;
        int n87 = 0;
        final int n88 = n14;
        final int n89 = char1;
        while (i < length) {
            final int n90 = i + 1;
            int char21 = e.charAt(i);
            int n95;
            int n96;
            if (char21 >= 55296) {
                int n91 = char21 & 0x1FFF;
                int n92 = n90;
                int n93 = 13;
                int n94;
                char char22;
                while (true) {
                    n94 = n92 + 1;
                    char22 = e.charAt(n92);
                    n95 = n17;
                    if (char22 < '\ud800') {
                        break;
                    }
                    n91 |= (char22 & '\u1fff') << n93;
                    n93 += 13;
                    n17 = n95;
                    n92 = n94;
                }
                char21 = (n91 | char22 << n93);
                n96 = n94;
            }
            else {
                n95 = n17;
                n96 = n90;
            }
            final int n97 = n96 + 1;
            int char23 = e.charAt(n96);
            int n102;
            if (char23 >= 55296) {
                int n98 = char23 & 0x1FFF;
                int n99 = 13;
                int n100 = n97;
                int n101;
                char char24;
                while (true) {
                    n101 = n100 + 1;
                    char24 = e.charAt(n100);
                    if (char24 < '\ud800') {
                        break;
                    }
                    n98 |= (char24 & '\u1fff') << n99;
                    n99 += 13;
                    n100 = n101;
                }
                char23 = (n98 | char24 << n99);
                n102 = n101;
            }
            else {
                n102 = n97;
            }
            final int n103 = char23 & 0xFF;
            int n104 = n86;
            if ((char23 & 0x400) != 0x0) {
                r[n86] = n87;
                n104 = n86 + 1;
            }
            int n106;
            int n115;
            int n116;
            int n117;
            if (n103 >= 51) {
                int n105 = n102 + 1;
                final char char25 = e.charAt(n102);
                n106 = n105;
                int n107;
                if ((n107 = char25) >= 55296) {
                    int n108 = char25 & '\u1fff';
                    int n109 = 13;
                    char char26;
                    while (true) {
                        n106 = n105 + 1;
                        char26 = e.charAt(n105);
                        if (char26 < '\ud800') {
                            break;
                        }
                        n108 |= (char26 & '\u1fff') << n109;
                        n109 += 13;
                        n105 = n106;
                    }
                    n107 = (n108 | char26 << n109);
                }
                final int n110 = n103 - 51;
                int n111;
                if (n110 != 9 && n110 != 17) {
                    n111 = n16;
                    if (n110 == 12) {
                        n111 = n16;
                        if ((n89 & 0x1) == 0x1) {
                            final int n112 = n87 / 3;
                            n111 = n16 + 1;
                            array2[n112 * 2 + 1] = d[n16];
                        }
                    }
                }
                else {
                    final int n113 = n87 / 3;
                    n111 = n16 + 1;
                    array2[n113 * 2 + 1] = d[n16];
                }
                int n114 = n107 * 2;
                final Object o2 = d[n114];
                Field m0;
                if (o2 instanceof Field) {
                    m0 = (Field)o2;
                }
                else {
                    m0 = m0(class1, (String)o2);
                    d[n114] = m0;
                }
                n115 = (int)s.objectFieldOffset(m0);
                ++n114;
                final Object o3 = d[n114];
                Field m2;
                if (o3 instanceof Field) {
                    m2 = (Field)o3;
                }
                else {
                    m2 = m0(class1, (String)o3);
                    d[n114] = m2;
                }
                n116 = (int)s.objectFieldOffset(m2);
                n117 = 0;
                n16 = n111;
            }
            else {
                final int n118 = n16 + 1;
                final Field m3 = m0(class1, (String)d[n16]);
                int n119 = 0;
                Label_2219: {
                    int n120 = 0;
                    Label_2215: {
                        if (n103 != 9 && n103 != 17) {
                            if (n103 != 27 && n103 != 49) {
                                if (n103 != 12 && n103 != 30 && n103 != 44) {
                                    if (n103 != 50) {
                                        n119 = n118;
                                        n120 = n84;
                                        break Label_2215;
                                    }
                                    final int n121 = n84 + 1;
                                    r[n84] = n87;
                                    final int n122 = n87 / 3 * 2;
                                    final int n123 = n118 + 1;
                                    array2[n122] = d[n118];
                                    if ((char23 & 0x800) != 0x0) {
                                        final int n124 = n123 + 1;
                                        array2[n122 + 1] = d[n123];
                                        n120 = n121;
                                        n119 = n124;
                                        break Label_2215;
                                    }
                                    n120 = n121;
                                    n119 = n123;
                                    break Label_2215;
                                }
                                else {
                                    n119 = n118;
                                    n120 = n84;
                                    if ((n89 & 0x1) != 0x1) {
                                        break Label_2215;
                                    }
                                    final int n125 = n87 / 3;
                                    n119 = n118 + 1;
                                    array2[n125 * 2 + 1] = d[n118];
                                }
                            }
                            else {
                                final int n126 = n87 / 3;
                                n119 = n118 + 1;
                                array2[n126 * 2 + 1] = d[n118];
                            }
                            break Label_2219;
                        }
                        array2[n87 / 3 * 2 + 1] = m3.getType();
                        n120 = n84;
                        n119 = n118;
                    }
                    n84 = n120;
                }
                final int n127 = (int)s.objectFieldOffset(m3);
                int n129;
                int n136;
                int n137;
                if ((n89 & 0x1) == 0x1 && n103 <= 17) {
                    final int n128 = n102 + 1;
                    final char char27 = e.charAt(n102);
                    n129 = n128;
                    int n130;
                    if ((n130 = char27) >= 55296) {
                        int n131 = char27 & '\u1fff';
                        int n132 = 13;
                        int n133 = n128;
                        int n134;
                        char char28;
                        while (true) {
                            n134 = n133 + 1;
                            char28 = e.charAt(n133);
                            if (char28 < '\ud800') {
                                break;
                            }
                            n131 |= (char28 & '\u1fff') << n132;
                            n132 += 13;
                            n133 = n134;
                        }
                        n130 = (n131 | char28 << n132);
                        n129 = n134;
                    }
                    final int n135 = n18 * 2 + n130 / 32;
                    final Object o4 = d[n135];
                    Field m4;
                    if (o4 instanceof Field) {
                        m4 = (Field)o4;
                    }
                    else {
                        m4 = m0(class1, (String)o4);
                        d[n135] = m4;
                    }
                    n136 = (int)s.objectFieldOffset(m4);
                    n137 = n130 % 32;
                }
                else {
                    n129 = n102;
                    n136 = 0;
                    n137 = 0;
                }
                final int n138 = n103;
                int n139 = n85;
                if (n138 >= 18) {
                    n139 = n85;
                    if (n138 <= 49) {
                        r[n85] = n127;
                        n139 = n85 + 1;
                    }
                }
                n85 = n139;
                n117 = n137;
                n16 = n119;
                n106 = n129;
                n115 = n127;
                n116 = n136;
            }
            final int n140 = n103;
            final int n141 = n87 + 1;
            array[n87] = char21;
            n87 = n141 + 1;
            int n142;
            if ((char23 & 0x200) != 0x0) {
                n142 = 536870912;
            }
            else {
                n142 = 0;
            }
            int n143;
            if ((char23 & 0x100) != 0x0) {
                n143 = 268435456;
            }
            else {
                n143 = 0;
            }
            array[n141] = (n142 | n143 | n140 << 20 | n115);
            array[n87] = (n117 << 20 | n116);
            final int n144 = n95;
            ++n87;
            i = n106;
            n86 = n104;
            n17 = n144;
        }
        return new z<T>(array, array2, n, n88, h0.b(), b2, false, r, n17, n83, b0, q, o0, k, t);
    }
    
    private int T(final int n) {
        return this.a[n];
    }
    
    private static long U(final int n) {
        return n & 0xFFFFF;
    }
    
    private static <T> boolean V(final T t, final long n) {
        return (boolean)q0.E(t, n);
    }
    
    private static <T> double W(final T t, final long n) {
        return (double)q0.E(t, n);
    }
    
    private static <T> float X(final T t, final long n) {
        return (float)q0.E(t, n);
    }
    
    private static <T> int Y(final T t, final long n) {
        return (int)q0.E(t, n);
    }
    
    private static <T> long Z(final T t, final long n) {
        return (long)q0.E(t, n);
    }
    
    private <K, V> int a0(final T t, final byte[] array, final int n, final int n2, final int n3, final long n4, final c.b b) throws IOException {
        final Unsafe s = z.s;
        final Object t2 = this.t(n3);
        Object o2;
        final Object o = o2 = s.getObject(t, n4);
        if (this.q.h(o)) {
            o2 = this.q.d(t2);
            this.q.a(o2, o);
            s.putObject(t, n4, o2);
        }
        this.q.b(t2);
        return this.m(array, n, n2, null, this.q.c(o2), b);
    }
    
    private int b0(final T t, final byte[] array, int n, int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final long n8, final int n9, final c.b b) throws IOException {
        final Unsafe s = z.s;
        final long n10 = this.a[n9 + 2] & 0xFFFFF;
        switch (n7) {
            case 68: {
                if (n5 == 3) {
                    n = com.google.crypto.tink.shaded.protobuf.c.n(this.u(n9), array, n, n2, (n3 & 0xFFFFFFF8) | 0x4, b);
                    Object object;
                    if (s.getInt(t, n10) == n4) {
                        object = s.getObject(t, n8);
                    }
                    else {
                        object = null;
                    }
                    if (object == null) {
                        s.putObject(t, n8, b.c);
                    }
                    else {
                        s.putObject(t, n8, Internal.h(object, b.c));
                    }
                    s.putInt(t, n10, n4);
                    break;
                }
                break;
            }
            case 67: {
                if (n5 == 0) {
                    n = com.google.crypto.tink.shaded.protobuf.c.L(array, n, b);
                    s.putObject(t, n8, CodedInputStream.c(b.b));
                    s.putInt(t, n10, n4);
                    break;
                }
                break;
            }
            case 66: {
                if (n5 == 0) {
                    n = com.google.crypto.tink.shaded.protobuf.c.I(array, n, b);
                    s.putObject(t, n8, CodedInputStream.b(b.a));
                    s.putInt(t, n10, n4);
                    break;
                }
                break;
            }
            case 63: {
                if (n5 == 0) {
                    n = com.google.crypto.tink.shaded.protobuf.c.I(array, n, b);
                    n2 = b.a;
                    final Internal.EnumVerifier s2 = this.s(n9);
                    if (s2 != null && !s2.a(n2)) {
                        v(t).n(n3, (long)n2);
                    }
                    else {
                        s.putObject(t, n8, n2);
                        s.putInt(t, n10, n4);
                    }
                    break;
                }
                break;
            }
            case 61: {
                if (n5 == 2) {
                    n = com.google.crypto.tink.shaded.protobuf.c.b(array, n, b);
                    s.putObject(t, n8, b.c);
                    s.putInt(t, n10, n4);
                    break;
                }
                break;
            }
            case 60: {
                if (n5 == 2) {
                    n = com.google.crypto.tink.shaded.protobuf.c.p(this.u(n9), array, n, n2, b);
                    Object object2;
                    if (s.getInt(t, n10) == n4) {
                        object2 = s.getObject(t, n8);
                    }
                    else {
                        object2 = null;
                    }
                    if (object2 == null) {
                        s.putObject(t, n8, b.c);
                    }
                    else {
                        s.putObject(t, n8, Internal.h(object2, b.c));
                    }
                    s.putInt(t, n10, n4);
                    break;
                }
                break;
            }
            case 59: {
                if (n5 == 2) {
                    n = com.google.crypto.tink.shaded.protobuf.c.I(array, n, b);
                    n2 = b.a;
                    if (n2 == 0) {
                        s.putObject(t, n8, "");
                    }
                    else {
                        if ((n6 & 0x20000000) != 0x0 && !Utf8.t(array, n, n + n2)) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        s.putObject(t, n8, new String(array, n, n2, Internal.a));
                        n += n2;
                    }
                    s.putInt(t, n10, n4);
                    break;
                }
                break;
            }
            case 58: {
                if (n5 == 0) {
                    n = com.google.crypto.tink.shaded.protobuf.c.L(array, n, b);
                    s.putObject(t, n8, b.b != 0L);
                    s.putInt(t, n10, n4);
                    break;
                }
                break;
            }
            case 57:
            case 64: {
                if (n5 == 5) {
                    s.putObject(t, n8, com.google.crypto.tink.shaded.protobuf.c.h(array, n));
                    n += 4;
                    s.putInt(t, n10, n4);
                    break;
                }
                break;
            }
            case 56:
            case 65: {
                if (n5 == 1) {
                    s.putObject(t, n8, com.google.crypto.tink.shaded.protobuf.c.j(array, n));
                    n += 8;
                    s.putInt(t, n10, n4);
                    break;
                }
                break;
            }
            case 55:
            case 62: {
                if (n5 == 0) {
                    n = com.google.crypto.tink.shaded.protobuf.c.I(array, n, b);
                    s.putObject(t, n8, b.a);
                    s.putInt(t, n10, n4);
                    break;
                }
                break;
            }
            case 53:
            case 54: {
                if (n5 == 0) {
                    n = com.google.crypto.tink.shaded.protobuf.c.L(array, n, b);
                    s.putObject(t, n8, b.b);
                    s.putInt(t, n10, n4);
                    break;
                }
                break;
            }
            case 52: {
                if (n5 == 5) {
                    s.putObject(t, n8, com.google.crypto.tink.shaded.protobuf.c.l(array, n));
                    n += 4;
                    s.putInt(t, n10, n4);
                    break;
                }
                break;
            }
            case 51: {
                if (n5 == 1) {
                    s.putObject(t, n8, com.google.crypto.tink.shaded.protobuf.c.d(array, n));
                    n += 8;
                    s.putInt(t, n10, n4);
                    break;
                }
                break;
            }
        }
        return n;
    }
    
    private int d0(final T t, final byte[] array, int n, final int n2, final c.b b) throws IOException {
        final Unsafe s = z.s;
        int n3 = -1;
        int i = n;
        n = -1;
        int n4 = 0;
        while (i < n2) {
            final int n5 = i + 1;
            int a = array[i];
            if (a < 0) {
                i = com.google.crypto.tink.shaded.protobuf.c.H(a, array, n5, b);
                a = b.a;
            }
            else {
                i = n5;
            }
            final int n6 = a >>> 3;
            final int n7 = a & 0x7;
            if (n6 > n) {
                n = this.g0(n6, n4 / 3);
            }
            else {
                n = this.f0(n6);
            }
            int n8 = 0;
            int n12 = 0;
            Label_1056: {
                int n10 = 0;
                Label_1032: {
                    if (n == n3) {
                        n = i;
                        n8 = n3;
                        final int n9 = 0;
                        n10 = n;
                        n = n9;
                    }
                    else {
                        final int n11 = this.a[n + 1];
                        final int q0 = q0(n11);
                        final long u = U(n11);
                        Label_0847: {
                            Label_0714: {
                                if (q0 <= 17) {
                                    boolean b2 = true;
                                    Label_0726: {
                                        Label_0711: {
                                            Label_0708: {
                                                switch (q0) {
                                                    default: {
                                                        break Label_0847;
                                                    }
                                                    case 16: {
                                                        if (n7 == 0) {
                                                            i = com.google.crypto.tink.shaded.protobuf.c.L(array, i, b);
                                                            s.putLong(t, u, CodedInputStream.c(b.b));
                                                            break;
                                                        }
                                                        break Label_0847;
                                                    }
                                                    case 15: {
                                                        if (n7 == 0) {
                                                            i = com.google.crypto.tink.shaded.protobuf.c.I(array, i, b);
                                                            s.putInt(t, u, CodedInputStream.b(b.a));
                                                            break;
                                                        }
                                                        break Label_0726;
                                                    }
                                                    case 12: {
                                                        if (n7 == 0) {
                                                            i = com.google.crypto.tink.shaded.protobuf.c.I(array, i, b);
                                                            s.putInt(t, u, b.a);
                                                            break;
                                                        }
                                                        break Label_0726;
                                                    }
                                                    case 10: {
                                                        if (n7 == 2) {
                                                            i = com.google.crypto.tink.shaded.protobuf.c.b(array, i, b);
                                                            s.putObject(t, u, b.c);
                                                            break;
                                                        }
                                                        break Label_0847;
                                                    }
                                                    case 9: {
                                                        if (n7 != 2) {
                                                            break Label_0847;
                                                        }
                                                        i = com.google.crypto.tink.shaded.protobuf.c.p(this.u(n), array, i, n2, b);
                                                        final Object object = s.getObject(t, u);
                                                        if (object == null) {
                                                            s.putObject(t, u, b.c);
                                                            break;
                                                        }
                                                        s.putObject(t, u, Internal.h(object, b.c));
                                                        break;
                                                    }
                                                    case 8: {
                                                        if (n7 == 2) {
                                                            if ((0x20000000 & n11) == 0x0) {
                                                                i = com.google.crypto.tink.shaded.protobuf.c.C(array, i, b);
                                                            }
                                                            else {
                                                                i = com.google.crypto.tink.shaded.protobuf.c.F(array, i, b);
                                                            }
                                                            s.putObject(t, u, b.c);
                                                            break;
                                                        }
                                                        break Label_0847;
                                                    }
                                                    case 7: {
                                                        if (n7 == 0) {
                                                            i = com.google.crypto.tink.shaded.protobuf.c.L(array, i, b);
                                                            if (b.b == 0L) {
                                                                b2 = false;
                                                            }
                                                            com.google.crypto.tink.shaded.protobuf.q0.J(t, u, b2);
                                                            break;
                                                        }
                                                        break Label_0847;
                                                    }
                                                    case 6:
                                                    case 13: {
                                                        if (n7 == 5) {
                                                            s.putInt(t, u, com.google.crypto.tink.shaded.protobuf.c.h(array, i));
                                                            i += 4;
                                                            break;
                                                        }
                                                        break Label_0847;
                                                    }
                                                    case 5:
                                                    case 14: {
                                                        if (n7 == 1) {
                                                            s.putLong(t, u, com.google.crypto.tink.shaded.protobuf.c.j(array, i));
                                                            break Label_0708;
                                                        }
                                                        break Label_0847;
                                                    }
                                                    case 4:
                                                    case 11: {
                                                        if (n7 == 0) {
                                                            i = com.google.crypto.tink.shaded.protobuf.c.I(array, i, b);
                                                            s.putInt(t, u, b.a);
                                                            break;
                                                        }
                                                        break Label_0726;
                                                    }
                                                    case 2:
                                                    case 3: {
                                                        if (n7 == 0) {
                                                            i = com.google.crypto.tink.shaded.protobuf.c.L(array, i, b);
                                                            s.putLong(t, u, b.b);
                                                            break;
                                                        }
                                                        break Label_0726;
                                                    }
                                                    case 1: {
                                                        if (n7 == 5) {
                                                            com.google.crypto.tink.shaded.protobuf.q0.Q(t, u, com.google.crypto.tink.shaded.protobuf.c.l(array, i));
                                                            i += 4;
                                                            break;
                                                        }
                                                        break Label_0726;
                                                    }
                                                    case 0: {
                                                        if (n7 == 1) {
                                                            com.google.crypto.tink.shaded.protobuf.q0.P(t, u, com.google.crypto.tink.shaded.protobuf.c.d(array, i));
                                                            break Label_0708;
                                                        }
                                                        break Label_0726;
                                                    }
                                                }
                                                break Label_0711;
                                            }
                                            i += 8;
                                        }
                                        break Label_0714;
                                    }
                                    break Label_0847;
                                }
                                if (q0 != 27) {
                                    n12 = n;
                                    Label_1019: {
                                        if (q0 <= 49) {
                                            final int e0 = this.e0(t, array, i, n2, a, n6, n7, n12, n11, q0, u, b);
                                            if ((n = e0) == i) {
                                                break Label_1019;
                                            }
                                            n = e0;
                                        }
                                        else if (q0 == 50) {
                                            if (n7 != 2) {
                                                break Label_0847;
                                            }
                                            final int a2 = this.a0(t, array, i, n2, n12, u, b);
                                            if ((n = a2) == i) {
                                                break Label_1019;
                                            }
                                            n = a2;
                                        }
                                        else {
                                            final int b3 = this.b0(t, array, i, n2, a, n6, n7, n11, q0, u, n12, b);
                                            if ((n = b3) == i) {
                                                break Label_1019;
                                            }
                                            n = b3;
                                        }
                                        n8 = -1;
                                        break Label_1056;
                                    }
                                    n8 = -1;
                                    final int n13 = n;
                                    n = n12;
                                    n10 = n13;
                                    break Label_1032;
                                }
                                if (n7 != 2) {
                                    break Label_0847;
                                }
                                Object d;
                                final Object o = d = s.getObject(t, u);
                                if (!((Internal.ProtobufList)o).r()) {
                                    final int size = ((List)o).size();
                                    int n14;
                                    if (size == 0) {
                                        n14 = 10;
                                    }
                                    else {
                                        n14 = size * 2;
                                    }
                                    d = ((Internal.ProtobufList)o).d(n14);
                                    s.putObject(t, u, d);
                                }
                                i = com.google.crypto.tink.shaded.protobuf.c.q(this.u(n), a, array, i, n2, (Internal.ProtobufList<?>)d, b);
                            }
                            n4 = n;
                            n = n6;
                            n3 = -1;
                            continue;
                        }
                        final int n15 = -1;
                        n10 = i;
                        n8 = n15;
                    }
                }
                final int g = com.google.crypto.tink.shaded.protobuf.c.G(a, array, n10, n2, v(t), b);
                n12 = n;
                n = g;
            }
            final int n16 = n6;
            final int n17 = n8;
            i = n;
            n = n16;
            n4 = n12;
            n3 = n17;
        }
        if (i == n2) {
            return i;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }
    
    private int e0(final T t, final byte[] array, int n, final int n2, final int n3, final int n4, final int n5, final int n6, final long n7, final int n8, final long n9, final c.b b) throws IOException {
        final Unsafe s = z.s;
        Object d;
        final Object o = d = s.getObject(t, n9);
        if (!((Internal.ProtobufList)o).r()) {
            final int size = ((List)o).size();
            int n10;
            if (size == 0) {
                n10 = 10;
            }
            else {
                n10 = size * 2;
            }
            d = ((Internal.ProtobufList)o).d(n10);
            s.putObject(t, n9, d);
        }
        switch (n8) {
            case 49: {
                if (n5 == 3) {
                    n = com.google.crypto.tink.shaded.protobuf.c.o(this.u(n6), n3, array, n, n2, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                break;
            }
            case 34:
            case 48: {
                if (n5 == 2) {
                    n = com.google.crypto.tink.shaded.protobuf.c.x(array, n, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                if (n5 == 0) {
                    n = com.google.crypto.tink.shaded.protobuf.c.B(n3, array, n, n2, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                break;
            }
            case 33:
            case 47: {
                if (n5 == 2) {
                    n = com.google.crypto.tink.shaded.protobuf.c.w(array, n, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                if (n5 == 0) {
                    n = com.google.crypto.tink.shaded.protobuf.c.A(n3, array, n, n2, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                break;
            }
            case 30:
            case 44: {
                if (n5 == 2) {
                    n = com.google.crypto.tink.shaded.protobuf.c.y(array, n, (Internal.ProtobufList<?>)d, b);
                }
                else {
                    if (n5 != 0) {
                        break;
                    }
                    n = com.google.crypto.tink.shaded.protobuf.c.J(n3, array, n, n2, (Internal.ProtobufList<?>)d, b);
                }
                final GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite)t;
                UnknownFieldSetLite unknownFields;
                if ((unknownFields = generatedMessageLite.unknownFields) == UnknownFieldSetLite.e()) {
                    unknownFields = null;
                }
                final UnknownFieldSetLite unknownFields2 = l0.A(n4, (List<Integer>)d, this.s(n6), unknownFields, this.o);
                if (unknownFields2 != null) {
                    generatedMessageLite.unknownFields = unknownFields2;
                }
                break;
            }
            case 28: {
                if (n5 == 2) {
                    n = com.google.crypto.tink.shaded.protobuf.c.c(n3, array, n, n2, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                break;
            }
            case 27: {
                if (n5 == 2) {
                    n = com.google.crypto.tink.shaded.protobuf.c.q(this.u(n6), n3, array, n, n2, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                break;
            }
            case 26: {
                if (n5 != 2) {
                    break;
                }
                if ((n7 & 0x20000000L) == 0x0L) {
                    n = com.google.crypto.tink.shaded.protobuf.c.D(n3, array, n, n2, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                n = com.google.crypto.tink.shaded.protobuf.c.E(n3, array, n, n2, (Internal.ProtobufList<?>)d, b);
                break;
            }
            case 25:
            case 42: {
                if (n5 == 2) {
                    n = com.google.crypto.tink.shaded.protobuf.c.r(array, n, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                if (n5 == 0) {
                    n = com.google.crypto.tink.shaded.protobuf.c.a(n3, array, n, n2, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                break;
            }
            case 24:
            case 31:
            case 41:
            case 45: {
                if (n5 == 2) {
                    n = com.google.crypto.tink.shaded.protobuf.c.t(array, n, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                if (n5 == 5) {
                    n = com.google.crypto.tink.shaded.protobuf.c.i(n3, array, n, n2, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                break;
            }
            case 23:
            case 32:
            case 40:
            case 46: {
                if (n5 == 2) {
                    n = com.google.crypto.tink.shaded.protobuf.c.u(array, n, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                if (n5 == 1) {
                    n = com.google.crypto.tink.shaded.protobuf.c.k(n3, array, n, n2, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                break;
            }
            case 22:
            case 29:
            case 39:
            case 43: {
                if (n5 == 2) {
                    n = com.google.crypto.tink.shaded.protobuf.c.y(array, n, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                if (n5 == 0) {
                    n = com.google.crypto.tink.shaded.protobuf.c.J(n3, array, n, n2, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                break;
            }
            case 20:
            case 21:
            case 37:
            case 38: {
                if (n5 == 2) {
                    n = com.google.crypto.tink.shaded.protobuf.c.z(array, n, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                if (n5 == 0) {
                    n = com.google.crypto.tink.shaded.protobuf.c.M(n3, array, n, n2, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                break;
            }
            case 19:
            case 36: {
                if (n5 == 2) {
                    n = com.google.crypto.tink.shaded.protobuf.c.v(array, n, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                if (n5 == 5) {
                    n = com.google.crypto.tink.shaded.protobuf.c.m(n3, array, n, n2, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                break;
            }
            case 18:
            case 35: {
                if (n5 == 2) {
                    n = com.google.crypto.tink.shaded.protobuf.c.s(array, n, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                if (n5 == 1) {
                    n = com.google.crypto.tink.shaded.protobuf.c.e(n3, array, n, n2, (Internal.ProtobufList<?>)d, b);
                    break;
                }
                break;
            }
        }
        return n;
    }
    
    private int f0(final int n) {
        if (n >= this.c && n <= this.d) {
            return this.p0(n, 0);
        }
        return -1;
    }
    
    private int g0(final int n, final int n2) {
        if (n >= this.c && n <= this.d) {
            return this.p0(n, n2);
        }
        return -1;
    }
    
    private int h0(final int n) {
        return this.a[n + 2];
    }
    
    private <E> void i0(final Object o, final long n, final i0 i0, final j0<E> j0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        i0.O(this.n.e(o, n), j0, extensionRegistryLite);
    }
    
    private <E> void j0(final Object o, final int n, final i0 i0, final j0<E> j0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        i0.L(this.n.e(o, U(n)), j0, extensionRegistryLite);
    }
    
    private boolean k(final T t, final T t2, final int n) {
        return this.B(t, n) == this.B(t2, n);
    }
    
    private void k0(final Object o, final int n, final i0 i0) throws IOException {
        if (A(n)) {
            q0.T(o, U(n), i0.H());
        }
        else if (this.g) {
            q0.T(o, U(n), i0.y());
        }
        else {
            q0.T(o, U(n), i0.n());
        }
    }
    
    private static <T> boolean l(final T t, final long n) {
        return q0.r(t, n);
    }
    
    private void l0(final Object o, final int n, final i0 i0) throws IOException {
        if (A(n)) {
            i0.m(this.n.e(o, U(n)));
        }
        else {
            i0.A(this.n.e(o, U(n)));
        }
    }
    
    private <K, V> int m(final byte[] array, int i, final int n, final MapEntryLite.a<K, V> a, final Map<K, V> map, final c.b b) throws IOException {
        i = com.google.crypto.tink.shaded.protobuf.c.I(array, i, b);
        final int a2 = b.a;
        if (a2 >= 0 && a2 <= n - i) {
            throw null;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    private static Field m0(final Class<?> clazz, final String s) {
        try {
            return clazz.getDeclaredField(s);
        }
        catch (final NoSuchFieldException ex) {
            final Field[] declaredFields = clazz.getDeclaredFields();
            for (final Field field : declaredFields) {
                if (s.equals(field.getName())) {
                    return field;
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Field ");
            sb.append(s);
            sb.append(" for ");
            sb.append(clazz.getName());
            sb.append(" not found. Known fields are ");
            sb.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sb.toString());
        }
    }
    
    private static <T> double n(final T t, final long n) {
        return q0.y(t, n);
    }
    
    private void n0(final T t, int h0) {
        if (this.h) {
            return;
        }
        h0 = this.h0(h0);
        final long n = h0 & 0xFFFFF;
        q0.R(t, n, q0.A(t, n) | 1 << (h0 >>> 20));
    }
    
    private boolean o(final T t, final T t2, final int n) {
        final int r0 = this.r0(n);
        final long u = U(r0);
        final int q0 = q0(r0);
        final boolean b = false;
        final boolean b2 = false;
        final boolean b3 = false;
        final boolean b4 = false;
        final boolean b5 = false;
        final boolean b6 = false;
        final boolean b7 = false;
        final boolean b8 = false;
        final boolean b9 = false;
        final boolean b10 = false;
        final boolean b11 = false;
        final boolean b12 = false;
        final boolean b13 = false;
        final boolean b14 = false;
        final boolean b15 = false;
        final boolean b16 = false;
        final boolean b17 = false;
        final boolean b18 = false;
        final boolean b19 = false;
        switch (q0) {
            default: {
                return true;
            }
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68: {
                boolean b20 = b19;
                if (this.G(t, t2, n)) {
                    b20 = b19;
                    if (l0.K(com.google.crypto.tink.shaded.protobuf.q0.E(t, u), com.google.crypto.tink.shaded.protobuf.q0.E(t2, u))) {
                        b20 = true;
                    }
                }
                return b20;
            }
            case 50: {
                return l0.K(com.google.crypto.tink.shaded.protobuf.q0.E(t, u), com.google.crypto.tink.shaded.protobuf.q0.E(t2, u));
            }
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49: {
                return l0.K(com.google.crypto.tink.shaded.protobuf.q0.E(t, u), com.google.crypto.tink.shaded.protobuf.q0.E(t2, u));
            }
            case 17: {
                boolean b21 = b;
                if (this.k(t, t2, n)) {
                    b21 = b;
                    if (l0.K(com.google.crypto.tink.shaded.protobuf.q0.E(t, u), com.google.crypto.tink.shaded.protobuf.q0.E(t2, u))) {
                        b21 = true;
                    }
                }
                return b21;
            }
            case 16: {
                boolean b22 = b2;
                if (this.k(t, t2, n)) {
                    b22 = b2;
                    if (com.google.crypto.tink.shaded.protobuf.q0.C(t, u) == com.google.crypto.tink.shaded.protobuf.q0.C(t2, u)) {
                        b22 = true;
                    }
                }
                return b22;
            }
            case 15: {
                boolean b23 = b3;
                if (this.k(t, t2, n)) {
                    b23 = b3;
                    if (com.google.crypto.tink.shaded.protobuf.q0.A(t, u) == com.google.crypto.tink.shaded.protobuf.q0.A(t2, u)) {
                        b23 = true;
                    }
                }
                return b23;
            }
            case 14: {
                boolean b24 = b4;
                if (this.k(t, t2, n)) {
                    b24 = b4;
                    if (com.google.crypto.tink.shaded.protobuf.q0.C(t, u) == com.google.crypto.tink.shaded.protobuf.q0.C(t2, u)) {
                        b24 = true;
                    }
                }
                return b24;
            }
            case 13: {
                boolean b25 = b5;
                if (this.k(t, t2, n)) {
                    b25 = b5;
                    if (com.google.crypto.tink.shaded.protobuf.q0.A(t, u) == com.google.crypto.tink.shaded.protobuf.q0.A(t2, u)) {
                        b25 = true;
                    }
                }
                return b25;
            }
            case 12: {
                boolean b26 = b6;
                if (this.k(t, t2, n)) {
                    b26 = b6;
                    if (com.google.crypto.tink.shaded.protobuf.q0.A(t, u) == com.google.crypto.tink.shaded.protobuf.q0.A(t2, u)) {
                        b26 = true;
                    }
                }
                return b26;
            }
            case 11: {
                boolean b27 = b7;
                if (this.k(t, t2, n)) {
                    b27 = b7;
                    if (com.google.crypto.tink.shaded.protobuf.q0.A(t, u) == com.google.crypto.tink.shaded.protobuf.q0.A(t2, u)) {
                        b27 = true;
                    }
                }
                return b27;
            }
            case 10: {
                boolean b28 = b8;
                if (this.k(t, t2, n)) {
                    b28 = b8;
                    if (l0.K(com.google.crypto.tink.shaded.protobuf.q0.E(t, u), com.google.crypto.tink.shaded.protobuf.q0.E(t2, u))) {
                        b28 = true;
                    }
                }
                return b28;
            }
            case 9: {
                boolean b29 = b9;
                if (this.k(t, t2, n)) {
                    b29 = b9;
                    if (l0.K(com.google.crypto.tink.shaded.protobuf.q0.E(t, u), com.google.crypto.tink.shaded.protobuf.q0.E(t2, u))) {
                        b29 = true;
                    }
                }
                return b29;
            }
            case 8: {
                boolean b30 = b10;
                if (this.k(t, t2, n)) {
                    b30 = b10;
                    if (l0.K(com.google.crypto.tink.shaded.protobuf.q0.E(t, u), com.google.crypto.tink.shaded.protobuf.q0.E(t2, u))) {
                        b30 = true;
                    }
                }
                return b30;
            }
            case 7: {
                boolean b31 = b11;
                if (this.k(t, t2, n)) {
                    b31 = b11;
                    if (com.google.crypto.tink.shaded.protobuf.q0.r(t, u) == com.google.crypto.tink.shaded.protobuf.q0.r(t2, u)) {
                        b31 = true;
                    }
                }
                return b31;
            }
            case 6: {
                boolean b32 = b12;
                if (this.k(t, t2, n)) {
                    b32 = b12;
                    if (com.google.crypto.tink.shaded.protobuf.q0.A(t, u) == com.google.crypto.tink.shaded.protobuf.q0.A(t2, u)) {
                        b32 = true;
                    }
                }
                return b32;
            }
            case 5: {
                boolean b33 = b13;
                if (this.k(t, t2, n)) {
                    b33 = b13;
                    if (com.google.crypto.tink.shaded.protobuf.q0.C(t, u) == com.google.crypto.tink.shaded.protobuf.q0.C(t2, u)) {
                        b33 = true;
                    }
                }
                return b33;
            }
            case 4: {
                boolean b34 = b14;
                if (this.k(t, t2, n)) {
                    b34 = b14;
                    if (com.google.crypto.tink.shaded.protobuf.q0.A(t, u) == com.google.crypto.tink.shaded.protobuf.q0.A(t2, u)) {
                        b34 = true;
                    }
                }
                return b34;
            }
            case 3: {
                boolean b35 = b15;
                if (this.k(t, t2, n)) {
                    b35 = b15;
                    if (com.google.crypto.tink.shaded.protobuf.q0.C(t, u) == com.google.crypto.tink.shaded.protobuf.q0.C(t2, u)) {
                        b35 = true;
                    }
                }
                return b35;
            }
            case 2: {
                boolean b36 = b16;
                if (this.k(t, t2, n)) {
                    b36 = b16;
                    if (com.google.crypto.tink.shaded.protobuf.q0.C(t, u) == com.google.crypto.tink.shaded.protobuf.q0.C(t2, u)) {
                        b36 = true;
                    }
                }
                return b36;
            }
            case 1: {
                boolean b37 = b17;
                if (this.k(t, t2, n)) {
                    b37 = b17;
                    if (Float.floatToIntBits(com.google.crypto.tink.shaded.protobuf.q0.z(t, u)) == Float.floatToIntBits(com.google.crypto.tink.shaded.protobuf.q0.z(t2, u))) {
                        b37 = true;
                    }
                }
                return b37;
            }
            case 0: {
                boolean b38 = b18;
                if (this.k(t, t2, n)) {
                    b38 = b18;
                    if (Double.doubleToLongBits(com.google.crypto.tink.shaded.protobuf.q0.y(t, u)) == Double.doubleToLongBits(com.google.crypto.tink.shaded.protobuf.q0.y(t2, u))) {
                        b38 = true;
                    }
                }
                return b38;
            }
        }
    }
    
    private void o0(final T t, final int n, final int n2) {
        q0.R(t, this.h0(n2) & 0xFFFFF, n);
    }
    
    private final <UT, UB> UB p(final Object o, final int n, final UB ub, final o0<UT, UB> o2) {
        final int t = this.T(n);
        final Object e = q0.E(o, U(this.r0(n)));
        if (e == null) {
            return ub;
        }
        final Internal.EnumVerifier s = this.s(n);
        if (s == null) {
            return ub;
        }
        return this.q(n, t, this.q.c(e), s, ub, o2);
    }
    
    private int p0(final int n, int i) {
        int n2 = this.a.length / 3 - 1;
        while (i <= n2) {
            final int n3 = n2 + i >>> 1;
            final int n4 = n3 * 3;
            final int t = this.T(n4);
            if (n == t) {
                return n4;
            }
            if (n < t) {
                n2 = n3 - 1;
            }
            else {
                i = n3 + 1;
            }
        }
        return -1;
    }
    
    private final <K, V, UT, UB> UB q(final int n, final int n2, final Map<K, V> map, final Internal.EnumVerifier enumVerifier, UB ub, final o0<UT, UB> o0) {
        this.q.b(this.t(n));
        final Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<K, Integer> entry = (Map.Entry<K, Integer>)iterator.next();
            if (!enumVerifier.a(entry.getValue())) {
                UB n3;
                if ((n3 = ub) == null) {
                    n3 = o0.n();
                }
                final ByteString.f codedBuilder = ByteString.newCodedBuilder(MapEntryLite.b(null, entry.getKey(), entry.getValue()));
                final CodedOutputStream b = codedBuilder.b();
                try {
                    MapEntryLite.d(b, null, entry.getKey(), entry.getValue());
                    o0.d(n3, n2, codedBuilder.a());
                    iterator.remove();
                    ub = n3;
                    continue;
                }
                catch (final IOException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            }
        }
        return ub;
    }
    
    private static int q0(final int n) {
        return (n & 0xFF00000) >>> 20;
    }
    
    private static <T> float r(final T t, final long n) {
        return q0.z(t, n);
    }
    
    private int r0(final int n) {
        return this.a[n + 1];
    }
    
    private Internal.EnumVerifier s(final int n) {
        return (Internal.EnumVerifier)this.b[n / 3 * 2 + 1];
    }
    
    private void s0(final T t, final Writer writer) throws IOException {
        Iterator r = null;
        Map.Entry entry = null;
        Label_0053: {
            if (this.f) {
                final FieldSet<?> c = this.p.c(t);
                if (!c.m()) {
                    r = c.r();
                    entry = (Map.Entry)r.next();
                    break Label_0053;
                }
            }
            r = null;
            entry = null;
        }
        int n = -1;
        final int length = this.a.length;
        final Unsafe s = z.s;
        int i = 0;
        int int1 = 0;
        while (i < length) {
            final int r2 = this.r0(i);
            final int t2 = this.T(i);
            final int q0 = q0(r2);
            int n5;
            if (!this.h && q0 <= 17) {
                final int n2 = this.a[i + 2];
                final int n3 = n2 & 0xFFFFF;
                int n4;
                if (n3 != (n4 = n)) {
                    int1 = s.getInt(t, (long)n3);
                    n4 = n3;
                }
                n5 = 1 << (n2 >>> 20);
                n = n4;
            }
            else {
                n5 = 0;
            }
            while (entry != null && this.p.a(entry) <= t2) {
                this.p.j(writer, entry);
                if (r.hasNext()) {
                    entry = (Map.Entry)r.next();
                }
                else {
                    entry = null;
                }
            }
            final long u = U(r2);
            switch (q0) {
                case 68: {
                    if (this.H(t, t2, i)) {
                        writer.K(t2, s.getObject(t, u), this.u(i));
                        break;
                    }
                    break;
                }
                case 67: {
                    if (this.H(t, t2, i)) {
                        writer.m(t2, Z(t, u));
                        break;
                    }
                    break;
                }
                case 66: {
                    if (this.H(t, t2, i)) {
                        writer.H(t2, Y(t, u));
                        break;
                    }
                    break;
                }
                case 65: {
                    if (this.H(t, t2, i)) {
                        writer.i(t2, Z(t, u));
                        break;
                    }
                    break;
                }
                case 64: {
                    if (this.H(t, t2, i)) {
                        writer.w(t2, Y(t, u));
                        break;
                    }
                    break;
                }
                case 63: {
                    if (this.H(t, t2, i)) {
                        writer.E(t2, Y(t, u));
                        break;
                    }
                    break;
                }
                case 62: {
                    if (this.H(t, t2, i)) {
                        writer.o(t2, Y(t, u));
                        break;
                    }
                    break;
                }
                case 61: {
                    if (this.H(t, t2, i)) {
                        writer.M(t2, (ByteString)s.getObject(t, u));
                        break;
                    }
                    break;
                }
                case 60: {
                    if (this.H(t, t2, i)) {
                        writer.N(t2, s.getObject(t, u), this.u(i));
                        break;
                    }
                    break;
                }
                case 59: {
                    if (this.H(t, t2, i)) {
                        this.w0(t2, s.getObject(t, u), writer);
                        break;
                    }
                    break;
                }
                case 58: {
                    if (this.H(t, t2, i)) {
                        writer.v(t2, V(t, u));
                        break;
                    }
                    break;
                }
                case 57: {
                    if (this.H(t, t2, i)) {
                        writer.c(t2, Y(t, u));
                        break;
                    }
                    break;
                }
                case 56: {
                    if (this.H(t, t2, i)) {
                        writer.s(t2, Z(t, u));
                        break;
                    }
                    break;
                }
                case 55: {
                    if (this.H(t, t2, i)) {
                        writer.h(t2, Y(t, u));
                        break;
                    }
                    break;
                }
                case 54: {
                    if (this.H(t, t2, i)) {
                        writer.f(t2, Z(t, u));
                        break;
                    }
                    break;
                }
                case 53: {
                    if (this.H(t, t2, i)) {
                        writer.u(t2, Z(t, u));
                        break;
                    }
                    break;
                }
                case 52: {
                    if (this.H(t, t2, i)) {
                        writer.B(t2, X(t, u));
                        break;
                    }
                    break;
                }
                case 51: {
                    if (this.H(t, t2, i)) {
                        writer.p(t2, W(t, u));
                        break;
                    }
                    break;
                }
                case 50: {
                    this.v0(writer, t2, s.getObject(t, u), i);
                    break;
                }
                case 49: {
                    l0.U(this.T(i), (List<?>)s.getObject(t, u), writer, this.u(i));
                    break;
                }
                case 48: {
                    l0.b0(this.T(i), (List<Long>)s.getObject(t, u), writer, true);
                    break;
                }
                case 47: {
                    l0.a0(this.T(i), (List<Integer>)s.getObject(t, u), writer, true);
                    break;
                }
                case 46: {
                    l0.Z(this.T(i), (List<Long>)s.getObject(t, u), writer, true);
                    break;
                }
                case 45: {
                    l0.Y(this.T(i), (List<Integer>)s.getObject(t, u), writer, true);
                    break;
                }
                case 44: {
                    l0.Q(this.T(i), (List<Integer>)s.getObject(t, u), writer, true);
                    break;
                }
                case 43: {
                    l0.d0(this.T(i), (List<Integer>)s.getObject(t, u), writer, true);
                    break;
                }
                case 42: {
                    l0.N(this.T(i), (List<Boolean>)s.getObject(t, u), writer, true);
                    break;
                }
                case 41: {
                    l0.R(this.T(i), (List<Integer>)s.getObject(t, u), writer, true);
                    break;
                }
                case 40: {
                    l0.S(this.T(i), (List<Long>)s.getObject(t, u), writer, true);
                    break;
                }
                case 39: {
                    l0.V(this.T(i), (List<Integer>)s.getObject(t, u), writer, true);
                    break;
                }
                case 38: {
                    l0.e0(this.T(i), (List<Long>)s.getObject(t, u), writer, true);
                    break;
                }
                case 37: {
                    l0.W(this.T(i), (List<Long>)s.getObject(t, u), writer, true);
                    break;
                }
                case 36: {
                    l0.T(this.T(i), (List<Float>)s.getObject(t, u), writer, true);
                    break;
                }
                case 35: {
                    l0.P(this.T(i), (List<Double>)s.getObject(t, u), writer, true);
                    break;
                }
                case 34: {
                    l0.b0(this.T(i), (List<Long>)s.getObject(t, u), writer, false);
                    break;
                }
                case 33: {
                    l0.a0(this.T(i), (List<Integer>)s.getObject(t, u), writer, false);
                    break;
                }
                case 32: {
                    l0.Z(this.T(i), (List<Long>)s.getObject(t, u), writer, false);
                    break;
                }
                case 31: {
                    l0.Y(this.T(i), (List<Integer>)s.getObject(t, u), writer, false);
                    break;
                }
                case 30: {
                    l0.Q(this.T(i), (List<Integer>)s.getObject(t, u), writer, false);
                    break;
                }
                case 29: {
                    l0.d0(this.T(i), (List<Integer>)s.getObject(t, u), writer, false);
                    break;
                }
                case 28: {
                    l0.O(this.T(i), (List<ByteString>)s.getObject(t, u), writer);
                    break;
                }
                case 27: {
                    l0.X(this.T(i), (List<?>)s.getObject(t, u), writer, this.u(i));
                    break;
                }
                case 26: {
                    l0.c0(this.T(i), (List<String>)s.getObject(t, u), writer);
                    break;
                }
                case 25: {
                    l0.N(this.T(i), (List<Boolean>)s.getObject(t, u), writer, false);
                    break;
                }
                case 24: {
                    l0.R(this.T(i), (List<Integer>)s.getObject(t, u), writer, false);
                    break;
                }
                case 23: {
                    l0.S(this.T(i), (List<Long>)s.getObject(t, u), writer, false);
                    break;
                }
                case 22: {
                    l0.V(this.T(i), (List<Integer>)s.getObject(t, u), writer, false);
                    break;
                }
                case 21: {
                    l0.e0(this.T(i), (List<Long>)s.getObject(t, u), writer, false);
                    break;
                }
                case 20: {
                    l0.W(this.T(i), (List<Long>)s.getObject(t, u), writer, false);
                    break;
                }
                case 19: {
                    l0.T(this.T(i), (List<Float>)s.getObject(t, u), writer, false);
                    break;
                }
                case 18: {
                    l0.P(this.T(i), (List<Double>)s.getObject(t, u), writer, false);
                    break;
                }
                case 17: {
                    if ((n5 & int1) != 0x0) {
                        writer.K(t2, s.getObject(t, u), this.u(i));
                        break;
                    }
                    break;
                }
                case 16: {
                    if ((n5 & int1) != 0x0) {
                        writer.m(t2, s.getLong(t, u));
                        break;
                    }
                    break;
                }
                case 15: {
                    if ((n5 & int1) != 0x0) {
                        writer.H(t2, s.getInt(t, u));
                        break;
                    }
                    break;
                }
                case 14: {
                    if ((n5 & int1) != 0x0) {
                        writer.i(t2, s.getLong(t, u));
                        break;
                    }
                    break;
                }
                case 13: {
                    if ((n5 & int1) != 0x0) {
                        writer.w(t2, s.getInt(t, u));
                        break;
                    }
                    break;
                }
                case 12: {
                    if ((n5 & int1) != 0x0) {
                        writer.E(t2, s.getInt(t, u));
                        break;
                    }
                    break;
                }
                case 11: {
                    if ((n5 & int1) != 0x0) {
                        writer.o(t2, s.getInt(t, u));
                        break;
                    }
                    break;
                }
                case 10: {
                    if ((n5 & int1) != 0x0) {
                        writer.M(t2, (ByteString)s.getObject(t, u));
                        break;
                    }
                    break;
                }
                case 9: {
                    if ((n5 & int1) != 0x0) {
                        writer.N(t2, s.getObject(t, u), this.u(i));
                        break;
                    }
                    break;
                }
                case 8: {
                    if ((n5 & int1) != 0x0) {
                        this.w0(t2, s.getObject(t, u), writer);
                        break;
                    }
                    break;
                }
                case 7: {
                    if ((n5 & int1) != 0x0) {
                        writer.v(t2, l(t, u));
                        break;
                    }
                    break;
                }
                case 6: {
                    if ((n5 & int1) != 0x0) {
                        writer.c(t2, s.getInt(t, u));
                        break;
                    }
                    break;
                }
                case 5: {
                    if ((n5 & int1) != 0x0) {
                        writer.s(t2, s.getLong(t, u));
                        break;
                    }
                    break;
                }
                case 4: {
                    if ((n5 & int1) != 0x0) {
                        writer.h(t2, s.getInt(t, u));
                        break;
                    }
                    break;
                }
                case 3: {
                    if ((n5 & int1) != 0x0) {
                        writer.f(t2, s.getLong(t, u));
                        break;
                    }
                    break;
                }
                case 2: {
                    if ((n5 & int1) != 0x0) {
                        writer.u(t2, s.getLong(t, u));
                        break;
                    }
                    break;
                }
                case 1: {
                    if ((n5 & int1) != 0x0) {
                        writer.B(t2, r(t, u));
                        break;
                    }
                    break;
                }
                case 0: {
                    if ((n5 & int1) != 0x0) {
                        writer.p(t2, n(t, u));
                        break;
                    }
                    break;
                }
            }
            i += 3;
        }
        while (entry != null) {
            this.p.j(writer, entry);
            if (r.hasNext()) {
                entry = (Map.Entry)r.next();
            }
            else {
                entry = null;
            }
        }
        this.x0(this.o, t, writer);
    }
    
    private Object t(final int n) {
        return this.b[n / 3 * 2];
    }
    
    private void t0(final T t, final Writer writer) throws IOException {
        Iterator r = null;
        Map.Entry entry = null;
        Label_0053: {
            if (this.f) {
                final FieldSet<?> c = this.p.c(t);
                if (!c.m()) {
                    r = c.r();
                    entry = (Map.Entry)r.next();
                    break Label_0053;
                }
            }
            r = null;
            entry = null;
        }
        final int length = this.a.length;
        int n = 0;
        Map.Entry entry2;
        while (true) {
            entry2 = entry;
            if (n >= length) {
                break;
            }
            final int r2 = this.r0(n);
            final int t2 = this.T(n);
            while (entry != null && this.p.a(entry) <= t2) {
                this.p.j(writer, entry);
                if (r.hasNext()) {
                    entry = (Map.Entry)r.next();
                }
                else {
                    entry = null;
                }
            }
            switch (q0(r2)) {
                case 68: {
                    if (this.H(t, t2, n)) {
                        writer.K(t2, q0.E(t, U(r2)), this.u(n));
                        break;
                    }
                    break;
                }
                case 67: {
                    if (this.H(t, t2, n)) {
                        writer.m(t2, Z(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 66: {
                    if (this.H(t, t2, n)) {
                        writer.H(t2, Y(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 65: {
                    if (this.H(t, t2, n)) {
                        writer.i(t2, Z(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 64: {
                    if (this.H(t, t2, n)) {
                        writer.w(t2, Y(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 63: {
                    if (this.H(t, t2, n)) {
                        writer.E(t2, Y(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 62: {
                    if (this.H(t, t2, n)) {
                        writer.o(t2, Y(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 61: {
                    if (this.H(t, t2, n)) {
                        writer.M(t2, (ByteString)q0.E(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 60: {
                    if (this.H(t, t2, n)) {
                        writer.N(t2, q0.E(t, U(r2)), this.u(n));
                        break;
                    }
                    break;
                }
                case 59: {
                    if (this.H(t, t2, n)) {
                        this.w0(t2, q0.E(t, U(r2)), writer);
                        break;
                    }
                    break;
                }
                case 58: {
                    if (this.H(t, t2, n)) {
                        writer.v(t2, V(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 57: {
                    if (this.H(t, t2, n)) {
                        writer.c(t2, Y(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 56: {
                    if (this.H(t, t2, n)) {
                        writer.s(t2, Z(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 55: {
                    if (this.H(t, t2, n)) {
                        writer.h(t2, Y(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 54: {
                    if (this.H(t, t2, n)) {
                        writer.f(t2, Z(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 53: {
                    if (this.H(t, t2, n)) {
                        writer.u(t2, Z(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 52: {
                    if (this.H(t, t2, n)) {
                        writer.B(t2, X(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 51: {
                    if (this.H(t, t2, n)) {
                        writer.p(t2, W(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 50: {
                    this.v0(writer, t2, q0.E(t, U(r2)), n);
                    break;
                }
                case 49: {
                    l0.U(this.T(n), (List<?>)q0.E(t, U(r2)), writer, this.u(n));
                    break;
                }
                case 48: {
                    l0.b0(this.T(n), (List<Long>)q0.E(t, U(r2)), writer, true);
                    break;
                }
                case 47: {
                    l0.a0(this.T(n), (List<Integer>)q0.E(t, U(r2)), writer, true);
                    break;
                }
                case 46: {
                    l0.Z(this.T(n), (List<Long>)q0.E(t, U(r2)), writer, true);
                    break;
                }
                case 45: {
                    l0.Y(this.T(n), (List<Integer>)q0.E(t, U(r2)), writer, true);
                    break;
                }
                case 44: {
                    l0.Q(this.T(n), (List<Integer>)q0.E(t, U(r2)), writer, true);
                    break;
                }
                case 43: {
                    l0.d0(this.T(n), (List<Integer>)q0.E(t, U(r2)), writer, true);
                    break;
                }
                case 42: {
                    l0.N(this.T(n), (List<Boolean>)q0.E(t, U(r2)), writer, true);
                    break;
                }
                case 41: {
                    l0.R(this.T(n), (List<Integer>)q0.E(t, U(r2)), writer, true);
                    break;
                }
                case 40: {
                    l0.S(this.T(n), (List<Long>)q0.E(t, U(r2)), writer, true);
                    break;
                }
                case 39: {
                    l0.V(this.T(n), (List<Integer>)q0.E(t, U(r2)), writer, true);
                    break;
                }
                case 38: {
                    l0.e0(this.T(n), (List<Long>)q0.E(t, U(r2)), writer, true);
                    break;
                }
                case 37: {
                    l0.W(this.T(n), (List<Long>)q0.E(t, U(r2)), writer, true);
                    break;
                }
                case 36: {
                    l0.T(this.T(n), (List<Float>)q0.E(t, U(r2)), writer, true);
                    break;
                }
                case 35: {
                    l0.P(this.T(n), (List<Double>)q0.E(t, U(r2)), writer, true);
                    break;
                }
                case 34: {
                    l0.b0(this.T(n), (List<Long>)q0.E(t, U(r2)), writer, false);
                    break;
                }
                case 33: {
                    l0.a0(this.T(n), (List<Integer>)q0.E(t, U(r2)), writer, false);
                    break;
                }
                case 32: {
                    l0.Z(this.T(n), (List<Long>)q0.E(t, U(r2)), writer, false);
                    break;
                }
                case 31: {
                    l0.Y(this.T(n), (List<Integer>)q0.E(t, U(r2)), writer, false);
                    break;
                }
                case 30: {
                    l0.Q(this.T(n), (List<Integer>)q0.E(t, U(r2)), writer, false);
                    break;
                }
                case 29: {
                    l0.d0(this.T(n), (List<Integer>)q0.E(t, U(r2)), writer, false);
                    break;
                }
                case 28: {
                    l0.O(this.T(n), (List<ByteString>)q0.E(t, U(r2)), writer);
                    break;
                }
                case 27: {
                    l0.X(this.T(n), (List<?>)q0.E(t, U(r2)), writer, this.u(n));
                    break;
                }
                case 26: {
                    l0.c0(this.T(n), (List<String>)q0.E(t, U(r2)), writer);
                    break;
                }
                case 25: {
                    l0.N(this.T(n), (List<Boolean>)q0.E(t, U(r2)), writer, false);
                    break;
                }
                case 24: {
                    l0.R(this.T(n), (List<Integer>)q0.E(t, U(r2)), writer, false);
                    break;
                }
                case 23: {
                    l0.S(this.T(n), (List<Long>)q0.E(t, U(r2)), writer, false);
                    break;
                }
                case 22: {
                    l0.V(this.T(n), (List<Integer>)q0.E(t, U(r2)), writer, false);
                    break;
                }
                case 21: {
                    l0.e0(this.T(n), (List<Long>)q0.E(t, U(r2)), writer, false);
                    break;
                }
                case 20: {
                    l0.W(this.T(n), (List<Long>)q0.E(t, U(r2)), writer, false);
                    break;
                }
                case 19: {
                    l0.T(this.T(n), (List<Float>)q0.E(t, U(r2)), writer, false);
                    break;
                }
                case 18: {
                    l0.P(this.T(n), (List<Double>)q0.E(t, U(r2)), writer, false);
                    break;
                }
                case 17: {
                    if (this.B(t, n)) {
                        writer.K(t2, q0.E(t, U(r2)), this.u(n));
                        break;
                    }
                    break;
                }
                case 16: {
                    if (this.B(t, n)) {
                        writer.m(t2, K(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 15: {
                    if (this.B(t, n)) {
                        writer.H(t2, z(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 14: {
                    if (this.B(t, n)) {
                        writer.i(t2, K(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 13: {
                    if (this.B(t, n)) {
                        writer.w(t2, z(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 12: {
                    if (this.B(t, n)) {
                        writer.E(t2, z(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 11: {
                    if (this.B(t, n)) {
                        writer.o(t2, z(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 10: {
                    if (this.B(t, n)) {
                        writer.M(t2, (ByteString)q0.E(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 9: {
                    if (this.B(t, n)) {
                        writer.N(t2, q0.E(t, U(r2)), this.u(n));
                        break;
                    }
                    break;
                }
                case 8: {
                    if (this.B(t, n)) {
                        this.w0(t2, q0.E(t, U(r2)), writer);
                        break;
                    }
                    break;
                }
                case 7: {
                    if (this.B(t, n)) {
                        writer.v(t2, l(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 6: {
                    if (this.B(t, n)) {
                        writer.c(t2, z(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 5: {
                    if (this.B(t, n)) {
                        writer.s(t2, K(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 4: {
                    if (this.B(t, n)) {
                        writer.h(t2, z(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 3: {
                    if (this.B(t, n)) {
                        writer.f(t2, K(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 2: {
                    if (this.B(t, n)) {
                        writer.u(t2, K(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 1: {
                    if (this.B(t, n)) {
                        writer.B(t2, r(t, U(r2)));
                        break;
                    }
                    break;
                }
                case 0: {
                    if (this.B(t, n)) {
                        writer.p(t2, n(t, U(r2)));
                        break;
                    }
                    break;
                }
            }
            n += 3;
        }
        while (entry2 != null) {
            this.p.j(writer, entry2);
            if (r.hasNext()) {
                entry2 = (Map.Entry)r.next();
            }
            else {
                entry2 = null;
            }
        }
        this.x0(this.o, t, writer);
    }
    
    private j0 u(int n) {
        n = n / 3 * 2;
        final j0 j0 = (j0)this.b[n];
        if (j0 != null) {
            return j0;
        }
        return (j0)(this.b[n] = f0.a().d((Class<Object>)this.b[n + 1]));
    }
    
    private void u0(final T t, final Writer writer) throws IOException {
        this.x0(this.o, t, writer);
        Iterator g = null;
        Map.Entry entry = null;
        Label_0063: {
            if (this.f) {
                final FieldSet<?> c = this.p.c(t);
                if (!c.m()) {
                    g = c.g();
                    entry = (Map.Entry)g.next();
                    break Label_0063;
                }
            }
            g = null;
            entry = null;
        }
        int n = this.a.length - 3;
        Map.Entry entry2 = entry;
        Map.Entry entry3;
        while (true) {
            entry3 = entry2;
            if (n < 0) {
                break;
            }
            final int r0 = this.r0(n);
            final int t2 = this.T(n);
            while (entry2 != null && this.p.a(entry2) > t2) {
                this.p.j(writer, entry2);
                if (g.hasNext()) {
                    entry2 = (Map.Entry)g.next();
                }
                else {
                    entry2 = null;
                }
            }
            switch (q0(r0)) {
                case 68: {
                    if (this.H(t, t2, n)) {
                        writer.K(t2, q0.E(t, U(r0)), this.u(n));
                        break;
                    }
                    break;
                }
                case 67: {
                    if (this.H(t, t2, n)) {
                        writer.m(t2, Z(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 66: {
                    if (this.H(t, t2, n)) {
                        writer.H(t2, Y(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 65: {
                    if (this.H(t, t2, n)) {
                        writer.i(t2, Z(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 64: {
                    if (this.H(t, t2, n)) {
                        writer.w(t2, Y(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 63: {
                    if (this.H(t, t2, n)) {
                        writer.E(t2, Y(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 62: {
                    if (this.H(t, t2, n)) {
                        writer.o(t2, Y(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 61: {
                    if (this.H(t, t2, n)) {
                        writer.M(t2, (ByteString)q0.E(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 60: {
                    if (this.H(t, t2, n)) {
                        writer.N(t2, q0.E(t, U(r0)), this.u(n));
                        break;
                    }
                    break;
                }
                case 59: {
                    if (this.H(t, t2, n)) {
                        this.w0(t2, q0.E(t, U(r0)), writer);
                        break;
                    }
                    break;
                }
                case 58: {
                    if (this.H(t, t2, n)) {
                        writer.v(t2, V(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 57: {
                    if (this.H(t, t2, n)) {
                        writer.c(t2, Y(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 56: {
                    if (this.H(t, t2, n)) {
                        writer.s(t2, Z(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 55: {
                    if (this.H(t, t2, n)) {
                        writer.h(t2, Y(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 54: {
                    if (this.H(t, t2, n)) {
                        writer.f(t2, Z(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 53: {
                    if (this.H(t, t2, n)) {
                        writer.u(t2, Z(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 52: {
                    if (this.H(t, t2, n)) {
                        writer.B(t2, X(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 51: {
                    if (this.H(t, t2, n)) {
                        writer.p(t2, W(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 50: {
                    this.v0(writer, t2, q0.E(t, U(r0)), n);
                    break;
                }
                case 49: {
                    l0.U(this.T(n), (List<?>)q0.E(t, U(r0)), writer, this.u(n));
                    break;
                }
                case 48: {
                    l0.b0(this.T(n), (List<Long>)q0.E(t, U(r0)), writer, true);
                    break;
                }
                case 47: {
                    l0.a0(this.T(n), (List<Integer>)q0.E(t, U(r0)), writer, true);
                    break;
                }
                case 46: {
                    l0.Z(this.T(n), (List<Long>)q0.E(t, U(r0)), writer, true);
                    break;
                }
                case 45: {
                    l0.Y(this.T(n), (List<Integer>)q0.E(t, U(r0)), writer, true);
                    break;
                }
                case 44: {
                    l0.Q(this.T(n), (List<Integer>)q0.E(t, U(r0)), writer, true);
                    break;
                }
                case 43: {
                    l0.d0(this.T(n), (List<Integer>)q0.E(t, U(r0)), writer, true);
                    break;
                }
                case 42: {
                    l0.N(this.T(n), (List<Boolean>)q0.E(t, U(r0)), writer, true);
                    break;
                }
                case 41: {
                    l0.R(this.T(n), (List<Integer>)q0.E(t, U(r0)), writer, true);
                    break;
                }
                case 40: {
                    l0.S(this.T(n), (List<Long>)q0.E(t, U(r0)), writer, true);
                    break;
                }
                case 39: {
                    l0.V(this.T(n), (List<Integer>)q0.E(t, U(r0)), writer, true);
                    break;
                }
                case 38: {
                    l0.e0(this.T(n), (List<Long>)q0.E(t, U(r0)), writer, true);
                    break;
                }
                case 37: {
                    l0.W(this.T(n), (List<Long>)q0.E(t, U(r0)), writer, true);
                    break;
                }
                case 36: {
                    l0.T(this.T(n), (List<Float>)q0.E(t, U(r0)), writer, true);
                    break;
                }
                case 35: {
                    l0.P(this.T(n), (List<Double>)q0.E(t, U(r0)), writer, true);
                    break;
                }
                case 34: {
                    l0.b0(this.T(n), (List<Long>)q0.E(t, U(r0)), writer, false);
                    break;
                }
                case 33: {
                    l0.a0(this.T(n), (List<Integer>)q0.E(t, U(r0)), writer, false);
                    break;
                }
                case 32: {
                    l0.Z(this.T(n), (List<Long>)q0.E(t, U(r0)), writer, false);
                    break;
                }
                case 31: {
                    l0.Y(this.T(n), (List<Integer>)q0.E(t, U(r0)), writer, false);
                    break;
                }
                case 30: {
                    l0.Q(this.T(n), (List<Integer>)q0.E(t, U(r0)), writer, false);
                    break;
                }
                case 29: {
                    l0.d0(this.T(n), (List<Integer>)q0.E(t, U(r0)), writer, false);
                    break;
                }
                case 28: {
                    l0.O(this.T(n), (List<ByteString>)q0.E(t, U(r0)), writer);
                    break;
                }
                case 27: {
                    l0.X(this.T(n), (List<?>)q0.E(t, U(r0)), writer, this.u(n));
                    break;
                }
                case 26: {
                    l0.c0(this.T(n), (List<String>)q0.E(t, U(r0)), writer);
                    break;
                }
                case 25: {
                    l0.N(this.T(n), (List<Boolean>)q0.E(t, U(r0)), writer, false);
                    break;
                }
                case 24: {
                    l0.R(this.T(n), (List<Integer>)q0.E(t, U(r0)), writer, false);
                    break;
                }
                case 23: {
                    l0.S(this.T(n), (List<Long>)q0.E(t, U(r0)), writer, false);
                    break;
                }
                case 22: {
                    l0.V(this.T(n), (List<Integer>)q0.E(t, U(r0)), writer, false);
                    break;
                }
                case 21: {
                    l0.e0(this.T(n), (List<Long>)q0.E(t, U(r0)), writer, false);
                    break;
                }
                case 20: {
                    l0.W(this.T(n), (List<Long>)q0.E(t, U(r0)), writer, false);
                    break;
                }
                case 19: {
                    l0.T(this.T(n), (List<Float>)q0.E(t, U(r0)), writer, false);
                    break;
                }
                case 18: {
                    l0.P(this.T(n), (List<Double>)q0.E(t, U(r0)), writer, false);
                    break;
                }
                case 17: {
                    if (this.B(t, n)) {
                        writer.K(t2, q0.E(t, U(r0)), this.u(n));
                        break;
                    }
                    break;
                }
                case 16: {
                    if (this.B(t, n)) {
                        writer.m(t2, K(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 15: {
                    if (this.B(t, n)) {
                        writer.H(t2, z(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 14: {
                    if (this.B(t, n)) {
                        writer.i(t2, K(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 13: {
                    if (this.B(t, n)) {
                        writer.w(t2, z(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 12: {
                    if (this.B(t, n)) {
                        writer.E(t2, z(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 11: {
                    if (this.B(t, n)) {
                        writer.o(t2, z(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 10: {
                    if (this.B(t, n)) {
                        writer.M(t2, (ByteString)q0.E(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 9: {
                    if (this.B(t, n)) {
                        writer.N(t2, q0.E(t, U(r0)), this.u(n));
                        break;
                    }
                    break;
                }
                case 8: {
                    if (this.B(t, n)) {
                        this.w0(t2, q0.E(t, U(r0)), writer);
                        break;
                    }
                    break;
                }
                case 7: {
                    if (this.B(t, n)) {
                        writer.v(t2, l(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 6: {
                    if (this.B(t, n)) {
                        writer.c(t2, z(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 5: {
                    if (this.B(t, n)) {
                        writer.s(t2, K(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 4: {
                    if (this.B(t, n)) {
                        writer.h(t2, z(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 3: {
                    if (this.B(t, n)) {
                        writer.f(t2, K(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 2: {
                    if (this.B(t, n)) {
                        writer.u(t2, K(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 1: {
                    if (this.B(t, n)) {
                        writer.B(t2, r(t, U(r0)));
                        break;
                    }
                    break;
                }
                case 0: {
                    if (this.B(t, n)) {
                        writer.p(t2, n(t, U(r0)));
                        break;
                    }
                    break;
                }
            }
            n -= 3;
        }
        while (entry3 != null) {
            this.p.j(writer, entry3);
            if (g.hasNext()) {
                entry3 = (Map.Entry)g.next();
            }
            else {
                entry3 = null;
            }
        }
    }
    
    static UnknownFieldSetLite v(final Object o) {
        final GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite)o;
        UnknownFieldSetLite unknownFields;
        if ((unknownFields = generatedMessageLite.unknownFields) == UnknownFieldSetLite.e()) {
            unknownFields = UnknownFieldSetLite.l();
            generatedMessageLite.unknownFields = unknownFields;
        }
        return unknownFields;
    }
    
    private <K, V> void v0(final Writer writer, final int n, final Object o, final int n2) throws IOException {
        if (o != null) {
            this.q.b(this.t(n2));
            writer.J(n, null, this.q.e(o));
        }
    }
    
    private int w(final T t) {
        final Unsafe s = z.s;
        int n = -1;
        int i = 0;
        int n2 = 0;
        int int1 = 0;
        while (i < this.a.length) {
            final int r0 = this.r0(i);
            final int t2 = this.T(i);
            final int q0 = q0(r0);
            int n3;
            int n5;
            int n6;
            int n7;
            if (q0 <= 17) {
                n3 = this.a[i + 2];
                final int n4 = 0xFFFFF & n3;
                if (n4 != (n5 = n)) {
                    int1 = s.getInt(t, (long)n4);
                    n5 = n4;
                }
                n6 = 1 << (n3 >>> 20);
                n7 = int1;
            }
            else {
                if (this.i && q0 >= FieldType.DOUBLE_LIST_PACKED.id() && q0 <= FieldType.SINT64_LIST_PACKED.id()) {
                    n3 = (this.a[i + 2] & 0xFFFFF);
                }
                else {
                    n3 = 0;
                }
                n6 = 0;
                n7 = int1;
                n5 = n;
            }
            final long u = U(r0);
            int n16 = 0;
            Label_2818: {
                int n15 = 0;
            Label_2813:
                while (true) {
                    int n10 = 0;
                    Label_2441: {
                        int n9 = 0;
                        Label_2299: {
                            int n14 = 0;
                            Label_2273: {
                                int n11 = 0;
                                int n12 = 0;
                                int w2 = 0;
                                switch (q0) {
                                    default: {
                                        final int n8 = n2;
                                        break Label_2304;
                                    }
                                    case 68: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n9 = CodedOutputStream.t(t2, (MessageLite)s.getObject(t, u), this.u(i));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 67: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n9 = CodedOutputStream.S(t2, Z(t, u));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 66: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n9 = CodedOutputStream.Q(t2, Y(t, u));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 65: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n9 = CodedOutputStream.O(t2, 0L);
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 64: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n10 = CodedOutputStream.M(t2, 0);
                                            break Label_2441;
                                        }
                                        break Label_2304;
                                    }
                                    case 63: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n9 = CodedOutputStream.l(t2, Y(t, u));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 62: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n9 = CodedOutputStream.X(t2, Y(t, u));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 61: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n9 = CodedOutputStream.h(t2, (ByteString)s.getObject(t, u));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 60: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n9 = l0.o(t2, s.getObject(t, u), this.u(i));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 59: {
                                        final int n8 = n2;
                                        if (!this.H(t, t2, i)) {
                                            break Label_2304;
                                        }
                                        final Object object = s.getObject(t, u);
                                        if (object instanceof ByteString) {
                                            n9 = CodedOutputStream.h(t2, (ByteString)object);
                                            break Label_2299;
                                        }
                                        n9 = CodedOutputStream.U(t2, (String)object);
                                        break Label_2299;
                                    }
                                    case 58: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n9 = CodedOutputStream.e(t2, true);
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 57: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n10 = CodedOutputStream.n(t2, 0);
                                            break Label_2441;
                                        }
                                        break Label_2304;
                                    }
                                    case 56: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n9 = CodedOutputStream.p(t2, 0L);
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 55: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n9 = CodedOutputStream.w(t2, Y(t, u));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 54: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n9 = CodedOutputStream.Z(t2, Z(t, u));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 53: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n9 = CodedOutputStream.y(t2, Z(t, u));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 52: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n9 = CodedOutputStream.r(t2, 0.0f);
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 51: {
                                        final int n8 = n2;
                                        if (this.H(t, t2, i)) {
                                            n9 = CodedOutputStream.j(t2, 0.0);
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 50: {
                                        n9 = this.q.g(t2, s.getObject(t, u), this.t(i));
                                        break Label_2299;
                                    }
                                    case 49: {
                                        n9 = l0.j(t2, (List<MessageLite>)s.getObject(t, u), this.u(i));
                                        break Label_2299;
                                    }
                                    case 48: {
                                        final int t3 = l0.t((List<Long>)s.getObject(t, u));
                                        final int n8 = n2;
                                        if (t3 > 0) {
                                            if (this.i) {
                                                s.putInt(t, (long)n3, t3);
                                            }
                                            final int w = CodedOutputStream.W(t2);
                                            n11 = CodedOutputStream.Y(t3);
                                            n12 = t3;
                                            w2 = w;
                                            break;
                                        }
                                        break Label_2304;
                                    }
                                    case 47: {
                                        final int r2 = l0.r((List<Integer>)s.getObject(t, u));
                                        final int n8 = n2;
                                        if (r2 > 0) {
                                            if (this.i) {
                                                s.putInt(t, (long)n3, r2);
                                            }
                                            final int w3 = CodedOutputStream.W(t2);
                                            n11 = CodedOutputStream.Y(r2);
                                            n12 = r2;
                                            w2 = w3;
                                            break;
                                        }
                                        break Label_2304;
                                    }
                                    case 46: {
                                        final int j = l0.i((List<?>)s.getObject(t, u));
                                        final int n8 = n2;
                                        if (j > 0) {
                                            if (this.i) {
                                                s.putInt(t, (long)n3, j);
                                            }
                                            final int w4 = CodedOutputStream.W(t2);
                                            n11 = CodedOutputStream.Y(j);
                                            n12 = j;
                                            w2 = w4;
                                            break;
                                        }
                                        break Label_2304;
                                    }
                                    case 45: {
                                        final int g = l0.g((List<?>)s.getObject(t, u));
                                        final int n8 = n2;
                                        if (g > 0) {
                                            if (this.i) {
                                                s.putInt(t, (long)n3, g);
                                            }
                                            final int w5 = CodedOutputStream.W(t2);
                                            n11 = CodedOutputStream.Y(g);
                                            n12 = g;
                                            w2 = w5;
                                            break;
                                        }
                                        break Label_2304;
                                    }
                                    case 44: {
                                        final int e = l0.e((List<Integer>)s.getObject(t, u));
                                        final int n8 = n2;
                                        if (e > 0) {
                                            if (this.i) {
                                                s.putInt(t, (long)n3, e);
                                            }
                                            final int w6 = CodedOutputStream.W(t2);
                                            n11 = CodedOutputStream.Y(e);
                                            n12 = e;
                                            w2 = w6;
                                            break;
                                        }
                                        break Label_2304;
                                    }
                                    case 43: {
                                        final int w7 = l0.w((List<Integer>)s.getObject(t, u));
                                        final int n8 = n2;
                                        if (w7 > 0) {
                                            if (this.i) {
                                                s.putInt(t, (long)n3, w7);
                                            }
                                            final int w8 = CodedOutputStream.W(t2);
                                            n11 = CodedOutputStream.Y(w7);
                                            n12 = w7;
                                            w2 = w8;
                                            break;
                                        }
                                        break Label_2304;
                                    }
                                    case 42: {
                                        final int b = l0.b((List<?>)s.getObject(t, u));
                                        final int n8 = n2;
                                        if (b > 0) {
                                            if (this.i) {
                                                s.putInt(t, (long)n3, b);
                                            }
                                            final int w9 = CodedOutputStream.W(t2);
                                            n11 = CodedOutputStream.Y(b);
                                            n12 = b;
                                            w2 = w9;
                                            break;
                                        }
                                        break Label_2304;
                                    }
                                    case 41: {
                                        final int g2 = l0.g((List<?>)s.getObject(t, u));
                                        final int n8 = n2;
                                        if (g2 > 0) {
                                            if (this.i) {
                                                s.putInt(t, (long)n3, g2);
                                            }
                                            final int w10 = CodedOutputStream.W(t2);
                                            n11 = CodedOutputStream.Y(g2);
                                            n12 = g2;
                                            w2 = w10;
                                            break;
                                        }
                                        break Label_2304;
                                    }
                                    case 40: {
                                        final int k = l0.i((List<?>)s.getObject(t, u));
                                        final int n8 = n2;
                                        if (k > 0) {
                                            if (this.i) {
                                                s.putInt(t, (long)n3, k);
                                            }
                                            final int w11 = CodedOutputStream.W(t2);
                                            n11 = CodedOutputStream.Y(k);
                                            n12 = k;
                                            w2 = w11;
                                            break;
                                        }
                                        break Label_2304;
                                    }
                                    case 39: {
                                        final int l = l0.l((List<Integer>)s.getObject(t, u));
                                        final int n8 = n2;
                                        if (l > 0) {
                                            if (this.i) {
                                                s.putInt(t, (long)n3, l);
                                            }
                                            final int w12 = CodedOutputStream.W(t2);
                                            n11 = CodedOutputStream.Y(l);
                                            n12 = l;
                                            w2 = w12;
                                            break;
                                        }
                                        break Label_2304;
                                    }
                                    case 38: {
                                        final int y = l0.y((List<Long>)s.getObject(t, u));
                                        final int n8 = n2;
                                        if (y > 0) {
                                            if (this.i) {
                                                s.putInt(t, (long)n3, y);
                                            }
                                            final int w13 = CodedOutputStream.W(t2);
                                            n11 = CodedOutputStream.Y(y);
                                            n12 = y;
                                            w2 = w13;
                                            break;
                                        }
                                        break Label_2304;
                                    }
                                    case 37: {
                                        final int n13 = l0.n((List<Long>)s.getObject(t, u));
                                        final int n8 = n2;
                                        if (n13 > 0) {
                                            if (this.i) {
                                                s.putInt(t, (long)n3, n13);
                                            }
                                            final int w14 = CodedOutputStream.W(t2);
                                            n11 = CodedOutputStream.Y(n13);
                                            n12 = n13;
                                            w2 = w14;
                                            break;
                                        }
                                        break Label_2304;
                                    }
                                    case 36: {
                                        final int g3 = l0.g((List<?>)s.getObject(t, u));
                                        final int n8 = n2;
                                        if (g3 > 0) {
                                            if (this.i) {
                                                s.putInt(t, (long)n3, g3);
                                            }
                                            final int w15 = CodedOutputStream.W(t2);
                                            n11 = CodedOutputStream.Y(g3);
                                            n12 = g3;
                                            w2 = w15;
                                            break;
                                        }
                                        break Label_2304;
                                    }
                                    case 35: {
                                        final int m = l0.i((List<?>)s.getObject(t, u));
                                        final int n8 = n2;
                                        if (m > 0) {
                                            if (this.i) {
                                                s.putInt(t, (long)n3, m);
                                            }
                                            w2 = CodedOutputStream.W(t2);
                                            n11 = CodedOutputStream.Y(m);
                                            n12 = m;
                                            break;
                                        }
                                        break Label_2304;
                                    }
                                    case 34: {
                                        n14 = l0.s(t2, (List<Long>)s.getObject(t, u), false);
                                        break Label_2273;
                                    }
                                    case 33: {
                                        n14 = l0.q(t2, (List<Integer>)s.getObject(t, u), false);
                                        break Label_2273;
                                    }
                                    case 32: {
                                        n14 = l0.h(t2, (List<?>)s.getObject(t, u), false);
                                        break Label_2273;
                                    }
                                    case 31: {
                                        n14 = l0.f(t2, (List<?>)s.getObject(t, u), false);
                                        break Label_2273;
                                    }
                                    case 30: {
                                        n14 = l0.d(t2, (List<Integer>)s.getObject(t, u), false);
                                        break Label_2273;
                                    }
                                    case 29: {
                                        n9 = l0.v(t2, (List<Integer>)s.getObject(t, u), false);
                                        break Label_2299;
                                    }
                                    case 28: {
                                        n9 = l0.c(t2, (List<ByteString>)s.getObject(t, u));
                                        break Label_2299;
                                    }
                                    case 27: {
                                        n9 = l0.p(t2, (List<?>)s.getObject(t, u), this.u(i));
                                        break Label_2299;
                                    }
                                    case 26: {
                                        n9 = l0.u(t2, (List<?>)s.getObject(t, u));
                                        break Label_2299;
                                    }
                                    case 25: {
                                        n14 = l0.a(t2, (List<?>)s.getObject(t, u), false);
                                        break Label_2273;
                                    }
                                    case 24: {
                                        n14 = l0.f(t2, (List<?>)s.getObject(t, u), false);
                                        break Label_2273;
                                    }
                                    case 23: {
                                        n14 = l0.h(t2, (List<?>)s.getObject(t, u), false);
                                        break Label_2273;
                                    }
                                    case 22: {
                                        n14 = l0.k(t2, (List<Integer>)s.getObject(t, u), false);
                                        break Label_2273;
                                    }
                                    case 21: {
                                        n14 = l0.x(t2, (List<Long>)s.getObject(t, u), false);
                                        break Label_2273;
                                    }
                                    case 20: {
                                        n14 = l0.m(t2, (List<Long>)s.getObject(t, u), false);
                                        break Label_2273;
                                    }
                                    case 19: {
                                        n14 = l0.f(t2, (List<?>)s.getObject(t, u), false);
                                        break Label_2273;
                                    }
                                    case 18: {
                                        n9 = l0.h(t2, (List<?>)s.getObject(t, u), false);
                                        break Label_2299;
                                    }
                                    case 17: {
                                        final int n8 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n9 = CodedOutputStream.t(t2, (MessageLite)s.getObject(t, u), this.u(i));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 16: {
                                        final int n8 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n9 = CodedOutputStream.S(t2, s.getLong(t, u));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 15: {
                                        final int n8 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n9 = CodedOutputStream.Q(t2, s.getInt(t, u));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 14: {
                                        final int n8 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n9 = CodedOutputStream.O(t2, 0L);
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 13: {
                                        final int n8 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n10 = CodedOutputStream.M(t2, 0);
                                            break Label_2441;
                                        }
                                        break Label_2304;
                                    }
                                    case 12: {
                                        final int n8 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n9 = CodedOutputStream.l(t2, s.getInt(t, u));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 11: {
                                        final int n8 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n9 = CodedOutputStream.X(t2, s.getInt(t, u));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 10: {
                                        final int n8 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n9 = CodedOutputStream.h(t2, (ByteString)s.getObject(t, u));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 9: {
                                        final int n8 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n9 = l0.o(t2, s.getObject(t, u), this.u(i));
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 8: {
                                        final int n8 = n2;
                                        if ((n7 & n6) == 0x0) {
                                            break Label_2304;
                                        }
                                        final Object object2 = s.getObject(t, u);
                                        if (object2 instanceof ByteString) {
                                            n9 = CodedOutputStream.h(t2, (ByteString)object2);
                                            break Label_2299;
                                        }
                                        n9 = CodedOutputStream.U(t2, (String)object2);
                                        break Label_2299;
                                    }
                                    case 7: {
                                        final int n8 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n9 = CodedOutputStream.e(t2, true);
                                            break Label_2299;
                                        }
                                        break Label_2304;
                                    }
                                    case 6: {
                                        final int n8 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n15 = CodedOutputStream.n(t2, 0);
                                            break Label_2813;
                                        }
                                        break Label_2304;
                                    }
                                    case 5: {
                                        n16 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n15 = CodedOutputStream.p(t2, 0L);
                                            break Label_2813;
                                        }
                                        break Label_2818;
                                    }
                                    case 4: {
                                        n16 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n15 = CodedOutputStream.w(t2, s.getInt(t, u));
                                            break Label_2813;
                                        }
                                        break Label_2818;
                                    }
                                    case 3: {
                                        n16 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n15 = CodedOutputStream.Z(t2, s.getLong(t, u));
                                            break Label_2813;
                                        }
                                        break Label_2818;
                                    }
                                    case 2: {
                                        n16 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n15 = CodedOutputStream.y(t2, s.getLong(t, u));
                                            break Label_2813;
                                        }
                                        break Label_2818;
                                    }
                                    case 1: {
                                        n16 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n15 = CodedOutputStream.r(t2, 0.0f);
                                            break Label_2813;
                                        }
                                        break Label_2818;
                                    }
                                    case 0: {
                                        n16 = n2;
                                        if ((n7 & n6) != 0x0) {
                                            n15 = CodedOutputStream.j(t2, 0.0);
                                            break Label_2813;
                                        }
                                        break Label_2818;
                                    }
                                }
                                n10 = w2 + n11 + n12;
                                break Label_2441;
                            }
                            n16 = n2 + n14;
                            break Label_2818;
                        }
                        final int n8 = n2 + n9;
                        n16 = n8;
                        break Label_2818;
                    }
                    final int n8 = n2 + n10;
                    continue;
                }
                n16 = n2 + n15;
            }
            i += 3;
            n = n5;
            n2 = n16;
            int1 = n7;
        }
        int n17 = n2 + this.y(this.o, t);
        if (this.f) {
            n17 += this.p.c(t).l();
        }
        return n17;
    }
    
    private void w0(final int n, final Object o, final Writer writer) throws IOException {
        if (o instanceof String) {
            writer.e(n, (String)o);
        }
        else {
            writer.M(n, (ByteString)o);
        }
    }
    
    private int x(final T t) {
        final Unsafe s = z.s;
        int i = 0;
        int n = 0;
        while (i < this.a.length) {
            final int r0 = this.r0(i);
            final int q0 = q0(r0);
            final int t2 = this.T(i);
            final long u = U(r0);
            int n2;
            if (q0 >= FieldType.DOUBLE_LIST_PACKED.id() && q0 <= FieldType.SINT64_LIST_PACKED.id()) {
                n2 = (this.a[i + 2] & 0xFFFFF);
            }
            else {
                n2 = 0;
            }
            int n3 = 0;
            Label_2677: {
                int n4 = 0;
                Label_2153: {
                    int n5 = 0;
                    int n6 = 0;
                    int y2 = 0;
                    switch (q0) {
                        default: {
                            n3 = n;
                            break Label_2677;
                        }
                        case 68: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.t(t2, (MessageLite)com.google.crypto.tink.shaded.protobuf.q0.E(t, u), this.u(i));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 67: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.S(t2, Z(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 66: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.Q(t2, Y(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 65: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.O(t2, 0L);
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 64: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.M(t2, 0);
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 63: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.l(t2, Y(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 62: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.X(t2, Y(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 61: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.h(t2, (ByteString)com.google.crypto.tink.shaded.protobuf.q0.E(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 60: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = l0.o(t2, com.google.crypto.tink.shaded.protobuf.q0.E(t, u), this.u(i));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 59: {
                            n3 = n;
                            if (!this.H(t, t2, i)) {
                                break Label_2677;
                            }
                            final Object e = com.google.crypto.tink.shaded.protobuf.q0.E(t, u);
                            if (e instanceof ByteString) {
                                n4 = CodedOutputStream.h(t2, (ByteString)e);
                                break Label_2153;
                            }
                            n4 = CodedOutputStream.U(t2, (String)e);
                            break Label_2153;
                        }
                        case 58: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.e(t2, true);
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 57: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.n(t2, 0);
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 56: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.p(t2, 0L);
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 55: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.w(t2, Y(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 54: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.Z(t2, Z(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 53: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.y(t2, Z(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 52: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.r(t2, 0.0f);
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 51: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = CodedOutputStream.j(t2, 0.0);
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 50: {
                            n4 = this.q.g(t2, com.google.crypto.tink.shaded.protobuf.q0.E(t, u), this.t(i));
                            break Label_2153;
                        }
                        case 49: {
                            n4 = l0.j(t2, (List<MessageLite>)J(t, u), this.u(i));
                            break Label_2153;
                        }
                        case 48: {
                            final int t3 = l0.t((List<Long>)s.getObject(t, u));
                            n3 = n;
                            if (t3 > 0) {
                                if (this.i) {
                                    s.putInt(t, (long)n2, t3);
                                }
                                n5 = CodedOutputStream.W(t2);
                                final int y = CodedOutputStream.Y(t3);
                                n6 = t3;
                                y2 = y;
                                break;
                            }
                            break Label_2677;
                        }
                        case 47: {
                            final int r2 = l0.r((List<Integer>)s.getObject(t, u));
                            n3 = n;
                            if (r2 > 0) {
                                if (this.i) {
                                    s.putInt(t, (long)n2, r2);
                                }
                                n5 = CodedOutputStream.W(t2);
                                final int y3 = CodedOutputStream.Y(r2);
                                n6 = r2;
                                y2 = y3;
                                break;
                            }
                            break Label_2677;
                        }
                        case 46: {
                            final int j = l0.i((List<?>)s.getObject(t, u));
                            n3 = n;
                            if (j > 0) {
                                if (this.i) {
                                    s.putInt(t, (long)n2, j);
                                }
                                n5 = CodedOutputStream.W(t2);
                                final int y4 = CodedOutputStream.Y(j);
                                n6 = j;
                                y2 = y4;
                                break;
                            }
                            break Label_2677;
                        }
                        case 45: {
                            final int g = l0.g((List<?>)s.getObject(t, u));
                            n3 = n;
                            if (g > 0) {
                                if (this.i) {
                                    s.putInt(t, (long)n2, g);
                                }
                                n5 = CodedOutputStream.W(t2);
                                final int y5 = CodedOutputStream.Y(g);
                                n6 = g;
                                y2 = y5;
                                break;
                            }
                            break Label_2677;
                        }
                        case 44: {
                            final int e2 = l0.e((List<Integer>)s.getObject(t, u));
                            n3 = n;
                            if (e2 > 0) {
                                if (this.i) {
                                    s.putInt(t, (long)n2, e2);
                                }
                                n5 = CodedOutputStream.W(t2);
                                final int y6 = CodedOutputStream.Y(e2);
                                n6 = e2;
                                y2 = y6;
                                break;
                            }
                            break Label_2677;
                        }
                        case 43: {
                            final int w = l0.w((List<Integer>)s.getObject(t, u));
                            n3 = n;
                            if (w > 0) {
                                if (this.i) {
                                    s.putInt(t, (long)n2, w);
                                }
                                n5 = CodedOutputStream.W(t2);
                                final int y7 = CodedOutputStream.Y(w);
                                n6 = w;
                                y2 = y7;
                                break;
                            }
                            break Label_2677;
                        }
                        case 42: {
                            final int b = l0.b((List<?>)s.getObject(t, u));
                            n3 = n;
                            if (b > 0) {
                                if (this.i) {
                                    s.putInt(t, (long)n2, b);
                                }
                                n5 = CodedOutputStream.W(t2);
                                final int y8 = CodedOutputStream.Y(b);
                                n6 = b;
                                y2 = y8;
                                break;
                            }
                            break Label_2677;
                        }
                        case 41: {
                            final int g2 = l0.g((List<?>)s.getObject(t, u));
                            n3 = n;
                            if (g2 > 0) {
                                if (this.i) {
                                    s.putInt(t, (long)n2, g2);
                                }
                                n5 = CodedOutputStream.W(t2);
                                final int y9 = CodedOutputStream.Y(g2);
                                n6 = g2;
                                y2 = y9;
                                break;
                            }
                            break Label_2677;
                        }
                        case 40: {
                            final int k = l0.i((List<?>)s.getObject(t, u));
                            n3 = n;
                            if (k > 0) {
                                if (this.i) {
                                    s.putInt(t, (long)n2, k);
                                }
                                n5 = CodedOutputStream.W(t2);
                                final int y10 = CodedOutputStream.Y(k);
                                n6 = k;
                                y2 = y10;
                                break;
                            }
                            break Label_2677;
                        }
                        case 39: {
                            final int l = l0.l((List<Integer>)s.getObject(t, u));
                            n3 = n;
                            if (l > 0) {
                                if (this.i) {
                                    s.putInt(t, (long)n2, l);
                                }
                                n5 = CodedOutputStream.W(t2);
                                final int y11 = CodedOutputStream.Y(l);
                                n6 = l;
                                y2 = y11;
                                break;
                            }
                            break Label_2677;
                        }
                        case 38: {
                            final int y12 = l0.y((List<Long>)s.getObject(t, u));
                            n3 = n;
                            if (y12 > 0) {
                                if (this.i) {
                                    s.putInt(t, (long)n2, y12);
                                }
                                n5 = CodedOutputStream.W(t2);
                                final int y13 = CodedOutputStream.Y(y12);
                                n6 = y12;
                                y2 = y13;
                                break;
                            }
                            break Label_2677;
                        }
                        case 37: {
                            final int n7 = l0.n((List<Long>)s.getObject(t, u));
                            n3 = n;
                            if (n7 > 0) {
                                if (this.i) {
                                    s.putInt(t, (long)n2, n7);
                                }
                                n5 = CodedOutputStream.W(t2);
                                final int y14 = CodedOutputStream.Y(n7);
                                n6 = n7;
                                y2 = y14;
                                break;
                            }
                            break Label_2677;
                        }
                        case 36: {
                            final int g3 = l0.g((List<?>)s.getObject(t, u));
                            n3 = n;
                            if (g3 > 0) {
                                if (this.i) {
                                    s.putInt(t, (long)n2, g3);
                                }
                                n5 = CodedOutputStream.W(t2);
                                final int y15 = CodedOutputStream.Y(g3);
                                n6 = g3;
                                y2 = y15;
                                break;
                            }
                            break Label_2677;
                        }
                        case 35: {
                            final int m = l0.i((List<?>)s.getObject(t, u));
                            n3 = n;
                            if (m > 0) {
                                if (this.i) {
                                    s.putInt(t, (long)n2, m);
                                }
                                n5 = CodedOutputStream.W(t2);
                                y2 = CodedOutputStream.Y(m);
                                n6 = m;
                                break;
                            }
                            break Label_2677;
                        }
                        case 34: {
                            n4 = l0.s(t2, (List<Long>)J(t, u), false);
                            break Label_2153;
                        }
                        case 33: {
                            n4 = l0.q(t2, (List<Integer>)J(t, u), false);
                            break Label_2153;
                        }
                        case 32: {
                            n4 = l0.h(t2, J(t, u), false);
                            break Label_2153;
                        }
                        case 31: {
                            n4 = l0.f(t2, J(t, u), false);
                            break Label_2153;
                        }
                        case 30: {
                            n4 = l0.d(t2, (List<Integer>)J(t, u), false);
                            break Label_2153;
                        }
                        case 29: {
                            n4 = l0.v(t2, (List<Integer>)J(t, u), false);
                            break Label_2153;
                        }
                        case 28: {
                            n4 = l0.c(t2, (List<ByteString>)J(t, u));
                            break Label_2153;
                        }
                        case 27: {
                            n4 = l0.p(t2, J(t, u), this.u(i));
                            break Label_2153;
                        }
                        case 26: {
                            n4 = l0.u(t2, J(t, u));
                            break Label_2153;
                        }
                        case 25: {
                            n4 = l0.a(t2, J(t, u), false);
                            break Label_2153;
                        }
                        case 24: {
                            n4 = l0.f(t2, J(t, u), false);
                            break Label_2153;
                        }
                        case 23: {
                            n4 = l0.h(t2, J(t, u), false);
                            break Label_2153;
                        }
                        case 22: {
                            n4 = l0.k(t2, (List<Integer>)J(t, u), false);
                            break Label_2153;
                        }
                        case 21: {
                            n4 = l0.x(t2, (List<Long>)J(t, u), false);
                            break Label_2153;
                        }
                        case 20: {
                            n4 = l0.m(t2, (List<Long>)J(t, u), false);
                            break Label_2153;
                        }
                        case 19: {
                            n4 = l0.f(t2, J(t, u), false);
                            break Label_2153;
                        }
                        case 18: {
                            n4 = l0.h(t2, J(t, u), false);
                            break Label_2153;
                        }
                        case 17: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.t(t2, (MessageLite)com.google.crypto.tink.shaded.protobuf.q0.E(t, u), this.u(i));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 16: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.S(t2, com.google.crypto.tink.shaded.protobuf.q0.C(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 15: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.Q(t2, com.google.crypto.tink.shaded.protobuf.q0.A(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 14: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.O(t2, 0L);
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 13: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.M(t2, 0);
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 12: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.l(t2, com.google.crypto.tink.shaded.protobuf.q0.A(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 11: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.X(t2, com.google.crypto.tink.shaded.protobuf.q0.A(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 10: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.h(t2, (ByteString)com.google.crypto.tink.shaded.protobuf.q0.E(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 9: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = l0.o(t2, com.google.crypto.tink.shaded.protobuf.q0.E(t, u), this.u(i));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 8: {
                            n3 = n;
                            if (!this.B(t, i)) {
                                break Label_2677;
                            }
                            final Object e3 = com.google.crypto.tink.shaded.protobuf.q0.E(t, u);
                            if (e3 instanceof ByteString) {
                                n4 = CodedOutputStream.h(t2, (ByteString)e3);
                                break Label_2153;
                            }
                            n4 = CodedOutputStream.U(t2, (String)e3);
                            break Label_2153;
                        }
                        case 7: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.e(t2, true);
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 6: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.n(t2, 0);
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 5: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.p(t2, 0L);
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 4: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.w(t2, com.google.crypto.tink.shaded.protobuf.q0.A(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 3: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.Z(t2, com.google.crypto.tink.shaded.protobuf.q0.C(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 2: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.y(t2, com.google.crypto.tink.shaded.protobuf.q0.C(t, u));
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 1: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.r(t2, 0.0f);
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                        case 0: {
                            n3 = n;
                            if (this.B(t, i)) {
                                n4 = CodedOutputStream.j(t2, 0.0);
                                break Label_2153;
                            }
                            break Label_2677;
                        }
                    }
                    n4 = n5 + y2 + n6;
                }
                n3 = n + n4;
            }
            i += 3;
            n = n3;
        }
        return n + this.y(this.o, t);
    }
    
    private <UT, UB> void x0(final o0<UT, UB> o0, final T t, final Writer writer) throws IOException {
        o0.t(o0.g(t), writer);
    }
    
    private <UT, UB> int y(final o0<UT, UB> o0, final T t) {
        return o0.h(o0.g(t));
    }
    
    private static <T> int z(final T t, final long n) {
        return q0.A(t, n);
    }
    
    @Override
    public void a(final T t, final T t2) {
        Objects.requireNonNull(t2);
        for (int i = 0; i < this.a.length; i += 3) {
            this.P(t, t2, i);
        }
        l0.G(this.o, t, t2);
        if (this.f) {
            l0.E(this.p, t, t2);
        }
    }
    
    @Override
    public void b(final T t) {
        int k = this.k;
        int l;
        while (true) {
            l = this.l;
            if (k >= l) {
                break;
            }
            final long u = U(this.r0(this.j[k]));
            final Object e = q0.E(t, u);
            if (e != null) {
                q0.T(t, u, this.q.f(e));
            }
            ++k;
        }
        for (int length = this.j.length, i = l; i < length; ++i) {
            this.n.c(t, this.j[i]);
        }
        this.o.j(t);
        if (this.f) {
            this.p.f(t);
        }
    }
    
    @Override
    public final boolean c(final T t) {
        int n = -1;
        int i = 0;
        int int1 = 0;
        while (i < this.k) {
            final int n2 = this.j[i];
            final int t2 = this.T(n2);
            final int r0 = this.r0(n2);
            int n6;
            int n7;
            if (!this.h) {
                final int n3 = this.a[n2 + 2];
                final int n4 = 0xFFFFF & n3;
                final int n5 = 1 << (n3 >>> 20);
                n6 = n;
                n7 = n5;
                if (n4 != n) {
                    int1 = z.s.getInt(t, (long)n4);
                    n6 = n4;
                    n7 = n5;
                }
            }
            else {
                n7 = 0;
                n6 = n;
            }
            if (I(r0) && !this.C(t, n2, int1, n7)) {
                return false;
            }
            final int q0 = q0(r0);
            Label_0278: {
                if (q0 != 9 && q0 != 17) {
                    if (q0 != 27) {
                        if (q0 != 60 && q0 != 68) {
                            if (q0 != 49) {
                                if (q0 != 50) {
                                    break Label_0278;
                                }
                                if (!this.F(t, r0, n2)) {
                                    return false;
                                }
                                break Label_0278;
                            }
                        }
                        else {
                            if (this.H(t, t2, n2) && !D(t, r0, this.u(n2))) {
                                return false;
                            }
                            break Label_0278;
                        }
                    }
                    if (!this.E(t, r0, n2)) {
                        return false;
                    }
                }
                else if (this.C(t, n2, int1, n7) && !D(t, r0, this.u(n2))) {
                    return false;
                }
            }
            ++i;
            n = n6;
        }
        return !this.f || this.p.c(t).o();
    }
    
    int c0(final T t, final byte[] array, int i, final int n, int n2, final c.b b) throws IOException {
        int n3 = n2;
        final Unsafe s = z.s;
        int n4 = 0;
        int n6;
        int n5 = n6 = 0;
        int n7 = -1;
        int n8 = -1;
        while (true) {
        Label_1349_Outer:
            while (i < n) {
                int h = i + 1;
                i = array[i];
                if (i < 0) {
                    h = com.google.crypto.tink.shaded.protobuf.c.H(i, array, h, b);
                    i = b.a;
                }
                final int n9 = i >>> 3;
                final int n10 = i & 0x7;
                int n11;
                if (n9 > n7) {
                    n11 = this.g0(n9, n4 / 3);
                }
                else {
                    n11 = this.f0(n9);
                }
                while (true) {
                    int n13 = 0;
                    int n14 = 0;
                    int n15 = 0;
                    int n16 = 0;
                    Label_1503: {
                        if (n11 == -1) {
                            final int n12 = n6;
                            n13 = n8;
                            n14 = n3;
                            n15 = 0;
                            n16 = n12;
                            break Label_1503;
                        }
                        final int n17 = this.a[n11 + 1];
                        final int q0 = q0(n17);
                        final long u = U(n17);
                        int q2 = 0;
                        Label_1234: {
                            if (q0 <= 17) {
                                final int n18 = this.a[n11 + 2];
                                final int n19 = 1 << (n18 >>> 20);
                                final int n20 = n18 & 0xFFFFF;
                                int n21;
                                if (n20 != n8) {
                                    if (n8 != -1) {
                                        s.putInt(t, (long)n8, n6);
                                    }
                                    final int int1 = s.getInt(t, (long)n20);
                                    n8 = n20;
                                    n21 = int1;
                                }
                                else {
                                    n21 = n6;
                                }
                                Label_1084: {
                                    int n22 = 0;
                                    Label_1062: {
                                        Label_1055: {
                                            Label_1048: {
                                                int n26 = 0;
                                                Label_0970: {
                                                    int n23 = 0;
                                                    Label_0940: {
                                                        int n24 = 0;
                                                        Label_0822: {
                                                            switch (q0) {
                                                                case 17: {
                                                                    if (n10 == 3) {
                                                                        n22 = com.google.crypto.tink.shaded.protobuf.c.n(this.u(n11), array, h, n, n9 << 3 | 0x4, b);
                                                                        if ((n21 & n19) == 0x0) {
                                                                            s.putObject(t, u, b.c);
                                                                        }
                                                                        else {
                                                                            s.putObject(t, u, Internal.h(s.getObject(t, u), b.c));
                                                                        }
                                                                        n21 |= n19;
                                                                        break Label_1062;
                                                                    }
                                                                    break;
                                                                }
                                                                case 16: {
                                                                    if (n10 == 0) {
                                                                        n23 = com.google.crypto.tink.shaded.protobuf.c.L(array, h, b);
                                                                        s.putLong(t, u, CodedInputStream.c(b.b));
                                                                        break Label_0940;
                                                                    }
                                                                    break;
                                                                }
                                                                case 15: {
                                                                    if (n10 == 0) {
                                                                        n22 = com.google.crypto.tink.shaded.protobuf.c.I(array, h, b);
                                                                        s.putInt(t, u, CodedInputStream.b(b.a));
                                                                        break Label_1055;
                                                                    }
                                                                    break;
                                                                }
                                                                case 12: {
                                                                    if (n10 != 0) {
                                                                        break;
                                                                    }
                                                                    n22 = com.google.crypto.tink.shaded.protobuf.c.I(array, h, b);
                                                                    final int a = b.a;
                                                                    final Internal.EnumVerifier s2 = this.s(n11);
                                                                    if (s2 != null && !s2.a(a)) {
                                                                        v(t).n(i, (long)a);
                                                                        break Label_1062;
                                                                    }
                                                                    s.putInt(t, u, a);
                                                                    break Label_1055;
                                                                }
                                                                case 10: {
                                                                    if (n10 == 2) {
                                                                        n22 = com.google.crypto.tink.shaded.protobuf.c.b(array, h, b);
                                                                        s.putObject(t, u, b.c);
                                                                        break Label_1055;
                                                                    }
                                                                    break;
                                                                }
                                                                case 9: {
                                                                    if (n10 != 2) {
                                                                        break;
                                                                    }
                                                                    n24 = com.google.crypto.tink.shaded.protobuf.c.p(this.u(n11), array, h, n, b);
                                                                    if ((n21 & n19) == 0x0) {
                                                                        s.putObject(t, u, b.c);
                                                                        break Label_0822;
                                                                    }
                                                                    s.putObject(t, u, Internal.h(s.getObject(t, u), b.c));
                                                                    break Label_0822;
                                                                }
                                                                case 8: {
                                                                    if (n10 == 2) {
                                                                        if ((n17 & 0x20000000) == 0x0) {
                                                                            n24 = com.google.crypto.tink.shaded.protobuf.c.C(array, h, b);
                                                                        }
                                                                        else {
                                                                            n24 = com.google.crypto.tink.shaded.protobuf.c.F(array, h, b);
                                                                        }
                                                                        s.putObject(t, u, b.c);
                                                                        break Label_0822;
                                                                    }
                                                                    break;
                                                                }
                                                                case 7: {
                                                                    if (n10 == 0) {
                                                                        n24 = com.google.crypto.tink.shaded.protobuf.c.L(array, h, b);
                                                                        com.google.crypto.tink.shaded.protobuf.q0.J(t, u, b.b != 0L);
                                                                        break Label_0822;
                                                                    }
                                                                    break;
                                                                }
                                                                case 6:
                                                                case 13: {
                                                                    if (n10 == 5) {
                                                                        s.putInt(t, u, com.google.crypto.tink.shaded.protobuf.c.h(array, h));
                                                                        n24 = h + 4;
                                                                        break Label_0822;
                                                                    }
                                                                    break;
                                                                }
                                                                case 5:
                                                                case 14: {
                                                                    if (n10 == 1) {
                                                                        s.putLong(t, u, com.google.crypto.tink.shaded.protobuf.c.j(array, h));
                                                                        break Label_1048;
                                                                    }
                                                                    break;
                                                                }
                                                                case 4:
                                                                case 11: {
                                                                    if (n10 == 0) {
                                                                        n22 = com.google.crypto.tink.shaded.protobuf.c.I(array, h, b);
                                                                        s.putInt(t, u, b.a);
                                                                        break Label_1055;
                                                                    }
                                                                    break;
                                                                }
                                                                case 2:
                                                                case 3: {
                                                                    if (n10 == 0) {
                                                                        n23 = com.google.crypto.tink.shaded.protobuf.c.L(array, h, b);
                                                                        s.putLong(t, u, b.b);
                                                                        break Label_0940;
                                                                    }
                                                                    break;
                                                                }
                                                                case 1: {
                                                                    if (n10 == 5) {
                                                                        com.google.crypto.tink.shaded.protobuf.q0.Q(t, u, com.google.crypto.tink.shaded.protobuf.c.l(array, h));
                                                                        n22 = h + 4;
                                                                        break Label_1055;
                                                                    }
                                                                    break;
                                                                }
                                                                case 0: {
                                                                    if (n10 == 1) {
                                                                        com.google.crypto.tink.shaded.protobuf.q0.P(t, u, com.google.crypto.tink.shaded.protobuf.c.d(array, h));
                                                                        break Label_1048;
                                                                    }
                                                                    break;
                                                                }
                                                            }
                                                            break Label_1084;
                                                        }
                                                        final int n25 = n21 | n19;
                                                        n26 = n24;
                                                        n6 = n25;
                                                        break Label_0970;
                                                        break Label_1084;
                                                    }
                                                    final int n27 = n21 | n19;
                                                    n26 = n23;
                                                    n6 = n27;
                                                }
                                                final int n28 = i;
                                                n7 = n9;
                                                final int n29 = n2;
                                                i = n26;
                                                n4 = n11;
                                                n5 = n28;
                                                n3 = n29;
                                                continue Label_1349_Outer;
                                            }
                                            n22 = h + 8;
                                        }
                                        n21 |= n19;
                                    }
                                    q2 = n22;
                                    n6 = n21;
                                    break Label_1234;
                                }
                                final int n30 = n2;
                                final int n31 = n21;
                                n15 = n11;
                                n14 = n30;
                                n13 = n8;
                                n16 = n31;
                                break Label_1503;
                            }
                            Label_1413: {
                                if (q0 != 27) {
                                    n15 = n11;
                                    final int n32 = n6;
                                    int n33 = 0;
                                    Label_1484: {
                                        int n34;
                                        if (q0 <= 49) {
                                            final int e0 = this.e0(t, array, h, n, i, n9, n10, n15, n17, q0, u, b);
                                            if ((n33 = e0) == h) {
                                                break Label_1484;
                                            }
                                            n34 = e0;
                                        }
                                        else if (q0 == 50) {
                                            if (n10 != 2) {
                                                break Label_1413;
                                            }
                                            final int a2 = this.a0(t, array, h, n, n15, u, b);
                                            if ((n33 = a2) == h) {
                                                break Label_1484;
                                            }
                                            n34 = a2;
                                        }
                                        else {
                                            final int b2 = this.b0(t, array, h, n, i, n9, n10, n17, q0, u, n15, b);
                                            if ((n33 = b2) == h) {
                                                break Label_1484;
                                            }
                                            n34 = b2;
                                        }
                                        final int n35 = n2;
                                        n4 = n15;
                                        n3 = n35;
                                        n6 = n32;
                                        final int n36 = i;
                                        i = n34;
                                        break Label_1349;
                                    }
                                    n13 = n8;
                                    h = n33;
                                    n14 = n2;
                                    n16 = n32;
                                    break Label_1503;
                                }
                                if (n10 == 2) {
                                    Object d;
                                    final Object o = d = s.getObject(t, u);
                                    if (!((Internal.ProtobufList)o).r()) {
                                        final int size = ((List)o).size();
                                        int n37;
                                        if (size == 0) {
                                            n37 = 10;
                                        }
                                        else {
                                            n37 = size * 2;
                                        }
                                        d = ((Internal.ProtobufList)o).d(n37);
                                        s.putObject(t, u, d);
                                    }
                                    q2 = com.google.crypto.tink.shaded.protobuf.c.q(this.u(n11), i, array, h, n, (Internal.ProtobufList<?>)d, b);
                                    break Label_1234;
                                }
                            }
                            final int n38 = n6;
                            n15 = n11;
                            n13 = n8;
                            n14 = n2;
                            n16 = n38;
                            break Label_1503;
                        }
                        final int n39 = i;
                        n3 = n2;
                        i = n;
                        i = q2;
                        n7 = n9;
                        n4 = n11;
                        n5 = n39;
                        continue Label_1349_Outer;
                        n7 = n9;
                        int n36 = 0;
                        n5 = n36;
                        continue Label_1349_Outer;
                    }
                    final int n40 = i;
                    if (n40 == n14 && n14 != 0) {
                        i = h;
                        n2 = n40;
                        final int n41 = n13;
                        n6 = n16;
                        n8 = n41;
                        final int n42 = n14;
                        if (n8 != -1) {
                            s.putInt(t, (long)n8, n6);
                        }
                        Object o2 = null;
                        for (int j = this.k; j < this.l; ++j) {
                            o2 = this.p(t, this.j[j], o2, this.o);
                        }
                        if (o2 != null) {
                            this.o.o(t, o2);
                        }
                        if (n42 == 0) {
                            if (i != n) {
                                throw InvalidProtocolBufferException.parseFailure();
                            }
                        }
                        else if (i > n || n2 != n42) {
                            throw InvalidProtocolBufferException.parseFailure();
                        }
                        return i;
                    }
                    if (this.f && b.d != ExtensionRegistryLite.b()) {
                        i = com.google.crypto.tink.shaded.protobuf.c.g(n40, array, h, n, t, this.e, (o0<UnknownFieldSetLite, UnknownFieldSetLite>)this.o, b);
                    }
                    else {
                        i = com.google.crypto.tink.shaded.protobuf.c.G(n40, array, h, n, v(t), b);
                    }
                    final int n36 = n40;
                    final int n43 = n13;
                    n6 = n16;
                    n4 = n15;
                    n8 = n43;
                    n3 = n14;
                    continue;
                }
            }
            final int n42 = n3;
            n2 = n5;
            continue;
        }
    }
    
    @Override
    public int d(final T t) {
        int n;
        if (this.h) {
            n = this.x(t);
        }
        else {
            n = this.w(t);
        }
        return n;
    }
    
    @Override
    public T e() {
        return (T)this.m.a(this.e);
    }
    
    @Override
    public int f(final T t) {
        final int length = this.a.length;
        int i = 0;
        int n = 0;
        while (i < length) {
            final int r0 = this.r0(i);
            final int t2 = this.T(i);
            final long u = U(r0);
            final int q0 = q0(r0);
            int n2 = 37;
            int n3 = 0;
            Label_1281: {
                int n4 = 0;
                int n5 = 0;
                Label_1277: {
                    switch (q0) {
                        default: {
                            n3 = n;
                            break Label_1281;
                        }
                        case 68: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                final Object e = com.google.crypto.tink.shaded.protobuf.q0.E(t, u);
                                n4 = n * 53;
                                n5 = e.hashCode();
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 67: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = Internal.f(Z(t, u));
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 66: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = Y(t, u);
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 65: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = Internal.f(Z(t, u));
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 64: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = Y(t, u);
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 63: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = Y(t, u);
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 62: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = Y(t, u);
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 61: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = com.google.crypto.tink.shaded.protobuf.q0.E(t, u).hashCode();
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 60: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                final Object e2 = com.google.crypto.tink.shaded.protobuf.q0.E(t, u);
                                n4 = n * 53;
                                n5 = e2.hashCode();
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 59: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = ((String)com.google.crypto.tink.shaded.protobuf.q0.E(t, u)).hashCode();
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 58: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = Internal.c(V(t, u));
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 57: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = Y(t, u);
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 56: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = Internal.f(Z(t, u));
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 55: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = Y(t, u);
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 54: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = Internal.f(Z(t, u));
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 53: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = Internal.f(Z(t, u));
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 52: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = Float.floatToIntBits(X(t, u));
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 51: {
                            n3 = n;
                            if (this.H(t, t2, i)) {
                                n4 = n * 53;
                                n5 = Internal.f(Double.doubleToLongBits(W(t, u)));
                                break Label_1277;
                            }
                            break Label_1281;
                        }
                        case 50: {
                            n4 = n * 53;
                            n5 = com.google.crypto.tink.shaded.protobuf.q0.E(t, u).hashCode();
                            break Label_1277;
                        }
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49: {
                            n4 = n * 53;
                            n5 = com.google.crypto.tink.shaded.protobuf.q0.E(t, u).hashCode();
                            break Label_1277;
                        }
                        case 17: {
                            final Object e3 = com.google.crypto.tink.shaded.protobuf.q0.E(t, u);
                            if (e3 != null) {
                                n2 = e3.hashCode();
                                break;
                            }
                            break;
                        }
                        case 16: {
                            n4 = n * 53;
                            n5 = Internal.f(com.google.crypto.tink.shaded.protobuf.q0.C(t, u));
                            break Label_1277;
                        }
                        case 15: {
                            n4 = n * 53;
                            n5 = com.google.crypto.tink.shaded.protobuf.q0.A(t, u);
                            break Label_1277;
                        }
                        case 14: {
                            n4 = n * 53;
                            n5 = Internal.f(com.google.crypto.tink.shaded.protobuf.q0.C(t, u));
                            break Label_1277;
                        }
                        case 13: {
                            n4 = n * 53;
                            n5 = com.google.crypto.tink.shaded.protobuf.q0.A(t, u);
                            break Label_1277;
                        }
                        case 12: {
                            n4 = n * 53;
                            n5 = com.google.crypto.tink.shaded.protobuf.q0.A(t, u);
                            break Label_1277;
                        }
                        case 11: {
                            n4 = n * 53;
                            n5 = com.google.crypto.tink.shaded.protobuf.q0.A(t, u);
                            break Label_1277;
                        }
                        case 10: {
                            n4 = n * 53;
                            n5 = com.google.crypto.tink.shaded.protobuf.q0.E(t, u).hashCode();
                            break Label_1277;
                        }
                        case 9: {
                            final Object e4 = com.google.crypto.tink.shaded.protobuf.q0.E(t, u);
                            if (e4 != null) {
                                n2 = e4.hashCode();
                                break;
                            }
                            break;
                        }
                        case 8: {
                            n4 = n * 53;
                            n5 = ((String)com.google.crypto.tink.shaded.protobuf.q0.E(t, u)).hashCode();
                            break Label_1277;
                        }
                        case 7: {
                            n4 = n * 53;
                            n5 = Internal.c(com.google.crypto.tink.shaded.protobuf.q0.r(t, u));
                            break Label_1277;
                        }
                        case 6: {
                            n4 = n * 53;
                            n5 = com.google.crypto.tink.shaded.protobuf.q0.A(t, u);
                            break Label_1277;
                        }
                        case 5: {
                            n4 = n * 53;
                            n5 = Internal.f(com.google.crypto.tink.shaded.protobuf.q0.C(t, u));
                            break Label_1277;
                        }
                        case 4: {
                            n4 = n * 53;
                            n5 = com.google.crypto.tink.shaded.protobuf.q0.A(t, u);
                            break Label_1277;
                        }
                        case 3: {
                            n4 = n * 53;
                            n5 = Internal.f(com.google.crypto.tink.shaded.protobuf.q0.C(t, u));
                            break Label_1277;
                        }
                        case 2: {
                            n4 = n * 53;
                            n5 = Internal.f(com.google.crypto.tink.shaded.protobuf.q0.C(t, u));
                            break Label_1277;
                        }
                        case 1: {
                            n4 = n * 53;
                            n5 = Float.floatToIntBits(com.google.crypto.tink.shaded.protobuf.q0.z(t, u));
                            break Label_1277;
                        }
                        case 0: {
                            n4 = n * 53;
                            n5 = Internal.f(Double.doubleToLongBits(com.google.crypto.tink.shaded.protobuf.q0.y(t, u)));
                            break Label_1277;
                        }
                    }
                    n3 = n * 53 + n2;
                    break Label_1281;
                }
                n3 = n4 + n5;
            }
            i += 3;
            n = n3;
        }
        int n6 = n * 53 + this.o.g(t).hashCode();
        if (this.f) {
            n6 = n6 * 53 + this.p.c(t).hashCode();
        }
        return n6;
    }
    
    @Override
    public boolean g(final T t, final T t2) {
        for (int length = this.a.length, i = 0; i < length; i += 3) {
            if (!this.o(t, t2, i)) {
                return false;
            }
        }
        return this.o.g(t).equals(this.o.g(t2)) && (!this.f || this.p.c(t).equals(this.p.c(t2)));
    }
    
    @Override
    public void h(final T t, final byte[] array, final int n, final int n2, final c.b b) throws IOException {
        if (this.h) {
            this.d0(t, array, n, n2, b);
        }
        else {
            this.c0(t, array, n, n2, 0, b);
        }
    }
    
    @Override
    public void i(final T t, final i0 i0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        Objects.requireNonNull(extensionRegistryLite);
        this.L(this.o, this.p, t, i0, extensionRegistryLite);
    }
    
    @Override
    public void j(final T t, final Writer writer) throws IOException {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            this.u0(t, writer);
        }
        else if (this.h) {
            this.t0(t, writer);
        }
        else {
            this.s0(t, writer);
        }
    }
}
