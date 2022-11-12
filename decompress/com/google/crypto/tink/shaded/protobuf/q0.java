// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.security.AccessController;
import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import java.nio.ByteOrder;
import sun.misc.Unsafe;
import java.util.logging.Logger;

final class q0
{
    private static final Logger a;
    private static final Unsafe b;
    private static final Class<?> c;
    private static final boolean d;
    private static final boolean e;
    private static final e f;
    private static final boolean g;
    private static final boolean h;
    static final long i;
    private static final long j;
    private static final long k;
    private static final long l;
    private static final long m;
    private static final long n;
    private static final long o;
    private static final long p;
    private static final long q;
    private static final long r;
    private static final long s;
    private static final long t;
    private static final long u;
    private static final long v;
    private static final int w;
    static final boolean x;
    
    static {
        a = Logger.getLogger(q0.class.getName());
        b = F();
        c = com.google.crypto.tink.shaded.protobuf.b.b();
        d = o(Long.TYPE);
        e = o(Integer.TYPE);
        f = D();
        g = V();
        h = U();
        final long n2 = i = k(byte[].class);
        j = k(boolean[].class);
        k = l(boolean[].class);
        l = k(int[].class);
        m = l(int[].class);
        n = k(long[].class);
        o = l(long[].class);
        p = k(float[].class);
        q = l(float[].class);
        r = k(double[].class);
        s = l(double[].class);
        t = k(Object[].class);
        u = l(Object[].class);
        v = q(m());
        w = (int)(0x7L & n2);
        x = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);
    }
    
    private q0() {
    }
    
    static int A(final Object o, final long n) {
        return q0.f.i(o, n);
    }
    
    static long B(final long n) {
        return q0.f.j(n);
    }
    
    static long C(final Object o, final long n) {
        return q0.f.k(o, n);
    }
    
    private static e D() {
        final Unsafe b = q0.b;
        Object o = null;
        if (b == null) {
            return null;
        }
        if (!com.google.crypto.tink.shaded.protobuf.b.c()) {
            return (e)new d(b);
        }
        if (q0.d) {
            return (e)new c(b);
        }
        if (q0.e) {
            o = new b(b);
        }
        return (e)o;
    }
    
    static Object E(final Object o, final long n) {
        return q0.f.l(o, n);
    }
    
    static Unsafe F() {
        Unsafe unsafe2;
        try {
            final Unsafe unsafe = AccessController.doPrivileged((PrivilegedExceptionAction<Unsafe>)new PrivilegedExceptionAction<Unsafe>() {
                public Unsafe a() throws Exception {
                    for (final Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        final Object value = field.get(null);
                        if (Unsafe.class.isInstance(value)) {
                            return Unsafe.class.cast(value);
                        }
                    }
                    return null;
                }
                
                @Override
                public /* bridge */ Object run() throws Exception {
                    return this.a();
                }
            });
        }
        finally {
            unsafe2 = null;
        }
        return unsafe2;
    }
    
    static boolean G() {
        return q0.h;
    }
    
    static boolean H() {
        return q0.g;
    }
    
    static long I(final Field field) {
        return q0.f.m(field);
    }
    
    static void J(final Object o, final long n, final boolean b) {
        q0.f.n(o, n, b);
    }
    
    private static void K(final Object o, final long n, final boolean b) {
        N(o, n, (byte)(b ? 1 : 0));
    }
    
    private static void L(final Object o, final long n, final boolean b) {
        O(o, n, (byte)(b ? 1 : 0));
    }
    
    static void M(final byte[] array, final long n, final byte b) {
        q0.f.o(array, q0.i + n, b);
    }
    
    private static void N(final Object o, final long n, final byte b) {
        final long n2 = 0xFFFFFFFFFFFFFFFCL & n;
        final int a = A(o, n2);
        final int n3 = (~(int)n & 0x3) << 3;
        R(o, n2, (0xFF & b) << n3 | (a & ~(255 << n3)));
    }
    
    private static void O(final Object o, final long n, final byte b) {
        final long n2 = 0xFFFFFFFFFFFFFFFCL & n;
        final int a = A(o, n2);
        final int n3 = ((int)n & 0x3) << 3;
        R(o, n2, (0xFF & b) << n3 | (a & ~(255 << n3)));
    }
    
    static void P(final Object o, final long n, final double n2) {
        q0.f.p(o, n, n2);
    }
    
    static void Q(final Object o, final long n, final float n2) {
        q0.f.q(o, n, n2);
    }
    
    static void R(final Object o, final long n, final int n2) {
        q0.f.r(o, n, n2);
    }
    
    static void S(final Object o, final long n, final long n2) {
        q0.f.s(o, n, n2);
    }
    
    static void T(final Object o, final long n, final Object o2) {
        q0.f.t(o, n, o2);
    }
    
    private static boolean U() {
        final Unsafe b = q0.b;
        if (b == null) {
            return false;
        }
        try {
            final Class<? extends Unsafe> class1 = b.getClass();
            class1.getMethod("objectFieldOffset", Field.class);
            class1.getMethod("arrayBaseOffset", Class.class);
            class1.getMethod("arrayIndexScale", Class.class);
            final Class<Long> type = Long.TYPE;
            class1.getMethod("getInt", Object.class, type);
            class1.getMethod("putInt", Object.class, type, Integer.TYPE);
            class1.getMethod("getLong", Object.class, type);
            class1.getMethod("putLong", Object.class, type, type);
            class1.getMethod("getObject", Object.class, type);
            class1.getMethod("putObject", Object.class, type, Object.class);
            if (com.google.crypto.tink.shaded.protobuf.b.c()) {
                return true;
            }
            class1.getMethod("getByte", Object.class, type);
            class1.getMethod("putByte", Object.class, type, Byte.TYPE);
            class1.getMethod("getBoolean", Object.class, type);
            class1.getMethod("putBoolean", Object.class, type, Boolean.TYPE);
            class1.getMethod("getFloat", Object.class, type);
            class1.getMethod("putFloat", Object.class, type, Float.TYPE);
            class1.getMethod("getDouble", Object.class, type);
            class1.getMethod("putDouble", Object.class, type, Double.TYPE);
            return true;
        }
        finally {
            final Logger a = q0.a;
            final Level warning = Level.WARNING;
            final StringBuilder sb = new StringBuilder();
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            final Throwable t;
            sb.append(t);
            a.log(warning, sb.toString());
            return false;
        }
    }
    
    private static boolean V() {
        final Unsafe b = q0.b;
        if (b == null) {
            return false;
        }
        try {
            final Class<? extends Unsafe> class1 = b.getClass();
            class1.getMethod("objectFieldOffset", Field.class);
            final Class<Long> type = Long.TYPE;
            class1.getMethod("getLong", Object.class, type);
            if (m() == null) {
                return false;
            }
            if (com.google.crypto.tink.shaded.protobuf.b.c()) {
                return true;
            }
            class1.getMethod("getByte", type);
            class1.getMethod("putByte", type, Byte.TYPE);
            class1.getMethod("getInt", type);
            class1.getMethod("putInt", type, Integer.TYPE);
            class1.getMethod("getLong", type);
            class1.getMethod("putLong", type, type);
            class1.getMethod("copyMemory", type, type, type);
            class1.getMethod("copyMemory", Object.class, type, Object.class, type, type);
            return true;
        }
        finally {
            final Logger a = q0.a;
            final Level warning = Level.WARNING;
            final StringBuilder sb = new StringBuilder();
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            final Throwable t;
            sb.append(t);
            a.log(warning, sb.toString());
            return false;
        }
    }
    
    static byte a(final Object o, final long n) {
        return w(o, n);
    }
    
    static byte b(final Object o, final long n) {
        return x(o, n);
    }
    
    static void c(final Object o, final long n, final byte b) {
        N(o, n, b);
    }
    
    static void d(final Object o, final long n, final byte b) {
        O(o, n, b);
    }
    
    static boolean e(final Object o, final long n) {
        return s(o, n);
    }
    
    static boolean f(final Object o, final long n) {
        return t(o, n);
    }
    
    static void g(final Object o, final long n, final boolean b) {
        K(o, n, b);
    }
    
    static void h(final Object o, final long n, final boolean b) {
        L(o, n, b);
    }
    
    static long i(final ByteBuffer byteBuffer) {
        return q0.f.k(byteBuffer, q0.v);
    }
    
    static <T> T j(final Class<T> clazz) {
        try {
            return (T)q0.b.allocateInstance(clazz);
        }
        catch (final InstantiationException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    private static int k(final Class<?> clazz) {
        int a;
        if (q0.h) {
            a = q0.f.a(clazz);
        }
        else {
            a = -1;
        }
        return a;
    }
    
    private static int l(final Class<?> clazz) {
        int b;
        if (q0.h) {
            b = q0.f.b(clazz);
        }
        else {
            b = -1;
        }
        return b;
    }
    
    private static Field m() {
        if (com.google.crypto.tink.shaded.protobuf.b.c()) {
            final Field p = p(Buffer.class, "effectiveDirectAddress");
            if (p != null) {
                return p;
            }
        }
        Field p2 = p(Buffer.class, "address");
        if (p2 == null || p2.getType() != Long.TYPE) {
            p2 = null;
        }
        return p2;
    }
    
    static void n(final long n, final byte[] array, final long n2, final long n3) {
        q0.f.c(n, array, n2, n3);
    }
    
    private static boolean o(final Class<?> clazz) {
        if (!com.google.crypto.tink.shaded.protobuf.b.c()) {
            return false;
        }
        try {
            final Class<?> c = q0.c;
            final Class<Boolean> type = Boolean.TYPE;
            c.getMethod("peekLong", clazz, type);
            c.getMethod("pokeLong", clazz, Long.TYPE, type);
            final Class<Integer> type2 = Integer.TYPE;
            c.getMethod("pokeInt", clazz, type2, type);
            c.getMethod("peekInt", clazz, type);
            c.getMethod("pokeByte", clazz, Byte.TYPE);
            c.getMethod("peekByte", clazz);
            c.getMethod("pokeByteArray", clazz, byte[].class, type2, type2);
            c.getMethod("peekByteArray", clazz, byte[].class, type2, type2);
            return true;
        }
        finally {
            return false;
        }
    }
    
    private static Field p(final Class<?> clazz, final String s) {
        Field field;
        try {
            clazz.getDeclaredField(s);
        }
        finally {
            field = null;
        }
        return field;
    }
    
    private static long q(final Field field) {
        if (field != null) {
            final e f = q0.f;
            if (f != null) {
                return f.m(field);
            }
        }
        return -1L;
    }
    
    static boolean r(final Object o, final long n) {
        return q0.f.d(o, n);
    }
    
    private static boolean s(final Object o, final long n) {
        return w(o, n) != 0;
    }
    
    private static boolean t(final Object o, final long n) {
        return x(o, n) != 0;
    }
    
    static byte u(final long n) {
        return q0.f.e(n);
    }
    
    static byte v(final byte[] array, final long n) {
        return q0.f.f(array, q0.i + n);
    }
    
    private static byte w(final Object o, final long n) {
        return (byte)(A(o, 0xFFFFFFFFFFFFFFFCL & n) >>> (int)((~n & 0x3L) << 3) & 0xFF);
    }
    
    private static byte x(final Object o, final long n) {
        return (byte)(A(o, 0xFFFFFFFFFFFFFFFCL & n) >>> (int)((n & 0x3L) << 3) & 0xFF);
    }
    
    static double y(final Object o, final long n) {
        return q0.f.g(o, n);
    }
    
    static float z(final Object o, final long n) {
        return q0.f.h(o, n);
    }
    
    private static final class b extends e
    {
        b(final Unsafe unsafe) {
            super(unsafe);
        }
        
        @Override
        public void c(final long n, final byte[] array, final long n2, final long n3) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean d(final Object o, final long n) {
            if (q0.x) {
                return q0.e(o, n);
            }
            return q0.f(o, n);
        }
        
        @Override
        public byte e(final long n) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public byte f(final Object o, final long n) {
            if (q0.x) {
                return q0.a(o, n);
            }
            return q0.b(o, n);
        }
        
        @Override
        public double g(final Object o, final long n) {
            return Double.longBitsToDouble(((e)this).k(o, n));
        }
        
        @Override
        public float h(final Object o, final long n) {
            return Float.intBitsToFloat(((e)this).i(o, n));
        }
        
        @Override
        public long j(final long n) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void n(final Object o, final long n, final boolean b) {
            if (q0.x) {
                q0.g(o, n, b);
            }
            else {
                q0.h(o, n, b);
            }
        }
        
        @Override
        public void o(final Object o, final long n, final byte b) {
            if (q0.x) {
                q0.c(o, n, b);
            }
            else {
                q0.d(o, n, b);
            }
        }
        
        @Override
        public void p(final Object o, final long n, final double n2) {
            ((e)this).s(o, n, Double.doubleToLongBits(n2));
        }
        
        @Override
        public void q(final Object o, final long n, final float n2) {
            ((e)this).r(o, n, Float.floatToIntBits(n2));
        }
    }
    
    private static final class c extends e
    {
        c(final Unsafe unsafe) {
            super(unsafe);
        }
        
        @Override
        public void c(final long n, final byte[] array, final long n2, final long n3) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean d(final Object o, final long n) {
            if (q0.x) {
                return q0.e(o, n);
            }
            return q0.f(o, n);
        }
        
        @Override
        public byte e(final long n) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public byte f(final Object o, final long n) {
            if (q0.x) {
                return q0.a(o, n);
            }
            return q0.b(o, n);
        }
        
        @Override
        public double g(final Object o, final long n) {
            return Double.longBitsToDouble(((e)this).k(o, n));
        }
        
        @Override
        public float h(final Object o, final long n) {
            return Float.intBitsToFloat(((e)this).i(o, n));
        }
        
        @Override
        public long j(final long n) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void n(final Object o, final long n, final boolean b) {
            if (q0.x) {
                q0.g(o, n, b);
            }
            else {
                q0.h(o, n, b);
            }
        }
        
        @Override
        public void o(final Object o, final long n, final byte b) {
            if (q0.x) {
                q0.c(o, n, b);
            }
            else {
                q0.d(o, n, b);
            }
        }
        
        @Override
        public void p(final Object o, final long n, final double n2) {
            ((e)this).s(o, n, Double.doubleToLongBits(n2));
        }
        
        @Override
        public void q(final Object o, final long n, final float n2) {
            ((e)this).r(o, n, Float.floatToIntBits(n2));
        }
    }
    
    private static final class d extends e
    {
        d(final Unsafe unsafe) {
            super(unsafe);
        }
        
        @Override
        public void c(final long n, final byte[] array, final long n2, final long n3) {
            super.a.copyMemory(null, n, array, q0.i + n2, n3);
        }
        
        @Override
        public boolean d(final Object o, final long n) {
            return super.a.getBoolean(o, n);
        }
        
        @Override
        public byte e(final long n) {
            return super.a.getByte(n);
        }
        
        @Override
        public byte f(final Object o, final long n) {
            return super.a.getByte(o, n);
        }
        
        @Override
        public double g(final Object o, final long n) {
            return super.a.getDouble(o, n);
        }
        
        @Override
        public float h(final Object o, final long n) {
            return super.a.getFloat(o, n);
        }
        
        @Override
        public long j(final long n) {
            return super.a.getLong(n);
        }
        
        @Override
        public void n(final Object o, final long n, final boolean b) {
            super.a.putBoolean(o, n, b);
        }
        
        @Override
        public void o(final Object o, final long n, final byte b) {
            super.a.putByte(o, n, b);
        }
        
        @Override
        public void p(final Object o, final long n, final double n2) {
            super.a.putDouble(o, n, n2);
        }
        
        @Override
        public void q(final Object o, final long n, final float n2) {
            super.a.putFloat(o, n, n2);
        }
    }
    
    private abstract static class e
    {
        Unsafe a;
        
        e(final Unsafe a) {
            this.a = a;
        }
        
        public final int a(final Class<?> clazz) {
            return this.a.arrayBaseOffset(clazz);
        }
        
        public final int b(final Class<?> clazz) {
            return this.a.arrayIndexScale(clazz);
        }
        
        public abstract void c(final long p0, final byte[] p1, final long p2, final long p3);
        
        public abstract boolean d(final Object p0, final long p1);
        
        public abstract byte e(final long p0);
        
        public abstract byte f(final Object p0, final long p1);
        
        public abstract double g(final Object p0, final long p1);
        
        public abstract float h(final Object p0, final long p1);
        
        public final int i(final Object o, final long n) {
            return this.a.getInt(o, n);
        }
        
        public abstract long j(final long p0);
        
        public final long k(final Object o, final long n) {
            return this.a.getLong(o, n);
        }
        
        public final Object l(final Object o, final long n) {
            return this.a.getObject(o, n);
        }
        
        public final long m(final Field field) {
            return this.a.objectFieldOffset(field);
        }
        
        public abstract void n(final Object p0, final long p1, final boolean p2);
        
        public abstract void o(final Object p0, final long p1, final byte p2);
        
        public abstract void p(final Object p0, final long p1, final double p2);
        
        public abstract void q(final Object p0, final long p1, final float p2);
        
        public final void r(final Object o, final long n, final int n2) {
            this.a.putInt(o, n, n2);
        }
        
        public final void s(final Object o, final long n, final long n2) {
            this.a.putLong(o, n, n2);
        }
        
        public final void t(final Object o, final long n, final Object o2) {
            this.a.putObject(o, n, o2);
        }
    }
}
