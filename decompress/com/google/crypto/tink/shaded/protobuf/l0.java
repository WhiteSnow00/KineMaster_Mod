// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.List;

final class l0
{
    private static final Class<?> a;
    private static final o0<?, ?> b;
    private static final o0<?, ?> c;
    private static final o0<?, ?> d;
    
    static {
        a = B();
        b = C(false);
        c = C(true);
        d = new p0();
    }
    
    static <UT, UB> UB A(final int n, final List<Integer> list, final Internal.EnumVerifier enumVerifier, UB ub, final o0<UT, UB> o0) {
        if (enumVerifier == null) {
            return ub;
        }
        UB ub2;
        if (list instanceof RandomAccess) {
            final int size = list.size();
            int i = 0;
            int n2 = 0;
            while (i < size) {
                final int intValue = list.get(i);
                if (enumVerifier.a(intValue)) {
                    if (i != n2) {
                        list.set(n2, intValue);
                    }
                    ++n2;
                }
                else {
                    ub = L(n, intValue, ub, o0);
                }
                ++i;
            }
            ub2 = ub;
            if (n2 != size) {
                list.subList(n2, size).clear();
                ub2 = ub;
            }
        }
        else {
            final Iterator iterator = list.iterator();
            while (true) {
                ub2 = ub;
                if (!iterator.hasNext()) {
                    break;
                }
                final int intValue2 = (int)iterator.next();
                if (enumVerifier.a(intValue2)) {
                    continue;
                }
                ub = L(n, intValue2, ub, o0);
                iterator.remove();
            }
        }
        return ub2;
    }
    
    private static Class<?> B() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3");
        }
        finally {
            return null;
        }
    }
    
    private static o0<?, ?> C(final boolean b) {
        try {
            final Class<?> d = D();
            if (d == null) {}
            return (o0)d.getConstructor(Boolean.TYPE).newInstance(b);
        }
        finally {
            return null;
        }
    }
    
    private static Class<?> D() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema");
        }
        finally {
            return null;
        }
    }
    
    static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void E(final k<FT> k, final T t, final T t2) {
        final FieldSet<FT> c = k.c(t2);
        if (!c.m()) {
            k.d(t).t(c);
        }
    }
    
    static <T> void F(final t t, final T t2, final T t3, final long n) {
        q0.T(t2, n, t.a(q0.E(t2, n), q0.E(t3, n)));
    }
    
    static <T, UT, UB> void G(final o0<UT, UB> o0, final T t, final T t2) {
        o0.p(t, o0.k(o0.g(t), o0.g(t2)));
    }
    
    public static o0<?, ?> H() {
        return l0.b;
    }
    
    public static o0<?, ?> I() {
        return l0.c;
    }
    
    public static void J(final Class<?> clazz) {
        if (!GeneratedMessageLite.class.isAssignableFrom(clazz)) {
            final Class<?> a = l0.a;
            if (a != null) {
                if (!a.isAssignableFrom(clazz)) {
                    throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
                }
            }
        }
    }
    
    static boolean K(final Object o, final Object o2) {
        return o == o2 || (o != null && o.equals(o2));
    }
    
    static <UT, UB> UB L(final int n, final int n2, final UB ub, final o0<UT, UB> o0) {
        UB n3 = ub;
        if (ub == null) {
            n3 = o0.n();
        }
        o0.e(n3, n, n2);
        return n3;
    }
    
    public static o0<?, ?> M() {
        return l0.d;
    }
    
    public static void N(final int n, final List<Boolean> list, final Writer writer, final boolean b) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.A(n, list, b);
        }
    }
    
    public static void O(final int n, final List<ByteString> list, final Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.I(n, list);
        }
    }
    
    public static void P(final int n, final List<Double> list, final Writer writer, final boolean b) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.G(n, list, b);
        }
    }
    
    public static void Q(final int n, final List<Integer> list, final Writer writer, final boolean b) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.n(n, list, b);
        }
    }
    
    public static void R(final int n, final List<Integer> list, final Writer writer, final boolean b) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.j(n, list, b);
        }
    }
    
    public static void S(final int n, final List<Long> list, final Writer writer, final boolean b) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.y(n, list, b);
        }
    }
    
    public static void T(final int n, final List<Float> list, final Writer writer, final boolean b) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.a(n, list, b);
        }
    }
    
    public static void U(final int n, final List<?> list, final Writer writer, final j0 j0) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.O(n, list, j0);
        }
    }
    
    public static void V(final int n, final List<Integer> list, final Writer writer, final boolean b) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.g(n, list, b);
        }
    }
    
    public static void W(final int n, final List<Long> list, final Writer writer, final boolean b) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.F(n, list, b);
        }
    }
    
    public static void X(final int n, final List<?> list, final Writer writer, final j0 j0) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.L(n, list, j0);
        }
    }
    
    public static void Y(final int n, final List<Integer> list, final Writer writer, final boolean b) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.z(n, list, b);
        }
    }
    
    public static void Z(final int n, final List<Long> list, final Writer writer, final boolean b) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.q(n, list, b);
        }
    }
    
    static int a(final int n, final List<?> list, final boolean b) {
        final int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (b) {
            return CodedOutputStream.W(n) + CodedOutputStream.D(size);
        }
        return size * CodedOutputStream.e(n, true);
    }
    
    public static void a0(final int n, final List<Integer> list, final Writer writer, final boolean b) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.D(n, list, b);
        }
    }
    
    static int b(final List<?> list) {
        return list.size();
    }
    
    public static void b0(final int n, final List<Long> list, final Writer writer, final boolean b) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.l(n, list, b);
        }
    }
    
    static int c(int i, final List<ByteString> list) {
        final int size = list.size();
        final int n = 0;
        if (size == 0) {
            return 0;
        }
        final int n2 = size * CodedOutputStream.W(i);
        i = n;
        int n3 = n2;
        while (i < list.size()) {
            n3 += CodedOutputStream.i(list.get(i));
            ++i;
        }
        return n3;
    }
    
    public static void c0(final int n, final List<String> list, final Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.d(n, list);
        }
    }
    
    static int d(final int n, final List<Integer> list, final boolean b) {
        final int size = list.size();
        if (size == 0) {
            return 0;
        }
        final int e = e(list);
        if (b) {
            return CodedOutputStream.W(n) + CodedOutputStream.D(e);
        }
        return e + size * CodedOutputStream.W(n);
    }
    
    public static void d0(final int n, final List<Integer> list, final Writer writer, final boolean b) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.k(n, list, b);
        }
    }
    
    static int e(final List<Integer> list) {
        final int size = list.size();
        int n = 0;
        final int n2 = 0;
        if (size == 0) {
            return 0;
        }
        int n5;
        if (list instanceof p) {
            final p p = (p)list;
            int n3 = 0;
            int n4 = n2;
            while (true) {
                n5 = n3;
                if (n4 >= size) {
                    break;
                }
                n3 += CodedOutputStream.m(p.getInt(n4));
                ++n4;
            }
        }
        else {
            int n6 = 0;
            while (true) {
                n5 = n6;
                if (n >= size) {
                    break;
                }
                n6 += CodedOutputStream.m(list.get(n));
                ++n;
            }
        }
        return n5;
    }
    
    public static void e0(final int n, final List<Long> list, final Writer writer, final boolean b) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.r(n, list, b);
        }
    }
    
    static int f(final int n, final List<?> list, final boolean b) {
        final int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (b) {
            return CodedOutputStream.W(n) + CodedOutputStream.D(size * 4);
        }
        return size * CodedOutputStream.n(n, 0);
    }
    
    static int g(final List<?> list) {
        return list.size() * 4;
    }
    
    static int h(final int n, final List<?> list, final boolean b) {
        final int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (b) {
            return CodedOutputStream.W(n) + CodedOutputStream.D(size * 8);
        }
        return size * CodedOutputStream.p(n, 0L);
    }
    
    static int i(final List<?> list) {
        return list.size() * 8;
    }
    
    static int j(final int n, final List<MessageLite> list, final j0 j0) {
        final int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        int n2 = 0;
        while (i < size) {
            n2 += CodedOutputStream.t(n, list.get(i), j0);
            ++i;
        }
        return n2;
    }
    
    static int k(final int n, final List<Integer> list, final boolean b) {
        final int size = list.size();
        if (size == 0) {
            return 0;
        }
        final int l = l(list);
        if (b) {
            return CodedOutputStream.W(n) + CodedOutputStream.D(l);
        }
        return l + size * CodedOutputStream.W(n);
    }
    
    static int l(final List<Integer> list) {
        final int size = list.size();
        final int n = 0;
        int n2 = 0;
        if (size == 0) {
            return 0;
        }
        int n4;
        if (list instanceof p) {
            final p p = (p)list;
            int n3 = 0;
            while (true) {
                n4 = n3;
                if (n2 >= size) {
                    break;
                }
                n3 += CodedOutputStream.x(p.getInt(n2));
                ++n2;
            }
        }
        else {
            int n5 = 0;
            int n6 = n;
            while (true) {
                n4 = n5;
                if (n6 >= size) {
                    break;
                }
                n5 += CodedOutputStream.x(list.get(n6));
                ++n6;
            }
        }
        return n4;
    }
    
    static int m(final int n, final List<Long> list, final boolean b) {
        if (list.size() == 0) {
            return 0;
        }
        final int n2 = n(list);
        if (b) {
            return CodedOutputStream.W(n) + CodedOutputStream.D(n2);
        }
        return n2 + list.size() * CodedOutputStream.W(n);
    }
    
    static int n(final List<Long> list) {
        final int size = list.size();
        int n = 0;
        final int n2 = 0;
        if (size == 0) {
            return 0;
        }
        int n5;
        if (list instanceof r) {
            final r r = (r)list;
            int n3 = 0;
            int n4 = n2;
            while (true) {
                n5 = n3;
                if (n4 >= size) {
                    break;
                }
                n3 += CodedOutputStream.z(r.n(n4));
                ++n4;
            }
        }
        else {
            int n6 = 0;
            while (true) {
                n5 = n6;
                if (n >= size) {
                    break;
                }
                n6 += CodedOutputStream.z(list.get(n));
                ++n;
            }
        }
        return n5;
    }
    
    static int o(final int n, final Object o, final j0 j0) {
        if (o instanceof LazyFieldLite) {
            return CodedOutputStream.B(n, (LazyFieldLite)o);
        }
        return CodedOutputStream.G(n, (MessageLite)o, j0);
    }
    
    static int p(int i, final List<?> list, final j0 j0) {
        final int size = list.size();
        final int n = 0;
        if (size == 0) {
            return 0;
        }
        int n2 = CodedOutputStream.W(i) * size;
        LazyFieldLite value;
        int n3;
        for (i = n; i < size; ++i) {
            value = list.get(i);
            if (value instanceof LazyFieldLite) {
                n3 = CodedOutputStream.C(value);
            }
            else {
                n3 = CodedOutputStream.I((MessageLite)value, j0);
            }
            n2 += n3;
        }
        return n2;
    }
    
    static int q(final int n, final List<Integer> list, final boolean b) {
        final int size = list.size();
        if (size == 0) {
            return 0;
        }
        final int r = r(list);
        if (b) {
            return CodedOutputStream.W(n) + CodedOutputStream.D(r);
        }
        return r + size * CodedOutputStream.W(n);
    }
    
    static int r(final List<Integer> list) {
        final int size = list.size();
        int n = 0;
        final int n2 = 0;
        if (size == 0) {
            return 0;
        }
        int n5;
        if (list instanceof p) {
            final p p = (p)list;
            int n3 = 0;
            int n4 = n2;
            while (true) {
                n5 = n3;
                if (n4 >= size) {
                    break;
                }
                n3 += CodedOutputStream.R(p.getInt(n4));
                ++n4;
            }
        }
        else {
            int n6 = 0;
            while (true) {
                n5 = n6;
                if (n >= size) {
                    break;
                }
                n6 += CodedOutputStream.R(list.get(n));
                ++n;
            }
        }
        return n5;
    }
    
    static int s(final int n, final List<Long> list, final boolean b) {
        final int size = list.size();
        if (size == 0) {
            return 0;
        }
        final int t = t(list);
        if (b) {
            return CodedOutputStream.W(n) + CodedOutputStream.D(t);
        }
        return t + size * CodedOutputStream.W(n);
    }
    
    static int t(final List<Long> list) {
        final int size = list.size();
        int n = 0;
        final int n2 = 0;
        if (size == 0) {
            return 0;
        }
        int n5;
        if (list instanceof r) {
            final r r = (r)list;
            int n3 = 0;
            int n4 = n2;
            while (true) {
                n5 = n3;
                if (n4 >= size) {
                    break;
                }
                n3 += CodedOutputStream.T(r.n(n4));
                ++n4;
            }
        }
        else {
            int n6 = 0;
            while (true) {
                n5 = n6;
                if (n >= size) {
                    break;
                }
                n6 += CodedOutputStream.T(list.get(n));
                ++n;
            }
        }
        return n5;
    }
    
    static int u(int n, final List<?> list) {
        final int size = list.size();
        int n2 = 0;
        final int n3 = 0;
        if (size == 0) {
            return 0;
        }
        final int n4 = n = CodedOutputStream.W(n) * size;
        int n6;
        if (list instanceof LazyStringList) {
            final LazyStringList list2 = (LazyStringList)list;
            n = n4;
            int n5 = n3;
            while (true) {
                n6 = n;
                if (n5 >= size) {
                    break;
                }
                final Object u = list2.u(n5);
                int n7;
                if (u instanceof ByteString) {
                    n7 = CodedOutputStream.i((ByteString)u);
                }
                else {
                    n7 = CodedOutputStream.V((String)u);
                }
                n += n7;
                ++n5;
            }
        }
        else {
            while (true) {
                n6 = n;
                if (n2 >= size) {
                    break;
                }
                final ByteString value = list.get(n2);
                int n8;
                if (value instanceof ByteString) {
                    n8 = CodedOutputStream.i(value);
                }
                else {
                    n8 = CodedOutputStream.V((String)value);
                }
                n += n8;
                ++n2;
            }
        }
        return n6;
    }
    
    static int v(final int n, final List<Integer> list, final boolean b) {
        final int size = list.size();
        if (size == 0) {
            return 0;
        }
        final int w = w(list);
        if (b) {
            return CodedOutputStream.W(n) + CodedOutputStream.D(w);
        }
        return w + size * CodedOutputStream.W(n);
    }
    
    static int w(final List<Integer> list) {
        final int size = list.size();
        int n = 0;
        final int n2 = 0;
        if (size == 0) {
            return 0;
        }
        int n5;
        if (list instanceof p) {
            final p p = (p)list;
            int n3 = 0;
            int n4 = n2;
            while (true) {
                n5 = n3;
                if (n4 >= size) {
                    break;
                }
                n3 += CodedOutputStream.Y(p.getInt(n4));
                ++n4;
            }
        }
        else {
            int n6 = 0;
            while (true) {
                n5 = n6;
                if (n >= size) {
                    break;
                }
                n6 += CodedOutputStream.Y(list.get(n));
                ++n;
            }
        }
        return n5;
    }
    
    static int x(final int n, final List<Long> list, final boolean b) {
        final int size = list.size();
        if (size == 0) {
            return 0;
        }
        final int y = y(list);
        if (b) {
            return CodedOutputStream.W(n) + CodedOutputStream.D(y);
        }
        return y + size * CodedOutputStream.W(n);
    }
    
    static int y(final List<Long> list) {
        final int size = list.size();
        int n = 0;
        final int n2 = 0;
        if (size == 0) {
            return 0;
        }
        int n5;
        if (list instanceof r) {
            final r r = (r)list;
            int n3 = 0;
            int n4 = n2;
            while (true) {
                n5 = n3;
                if (n4 >= size) {
                    break;
                }
                n3 += CodedOutputStream.a0(r.n(n4));
                ++n4;
            }
        }
        else {
            int n6 = 0;
            while (true) {
                n5 = n6;
                if (n >= size) {
                    break;
                }
                n6 += CodedOutputStream.a0(list.get(n));
                ++n;
            }
        }
        return n5;
    }
    
    static <UT, UB> UB z(final int n, final List<Integer> list, final Internal.EnumLiteMap<?> enumLiteMap, UB ub, final o0<UT, UB> o0) {
        if (enumLiteMap == null) {
            return ub;
        }
        UB ub2;
        if (list instanceof RandomAccess) {
            final int size = list.size();
            int i = 0;
            int n2 = 0;
            while (i < size) {
                final int intValue = list.get(i);
                if (enumLiteMap.a(intValue) != null) {
                    if (i != n2) {
                        list.set(n2, intValue);
                    }
                    ++n2;
                }
                else {
                    ub = L(n, intValue, ub, o0);
                }
                ++i;
            }
            ub2 = ub;
            if (n2 != size) {
                list.subList(n2, size).clear();
                ub2 = ub;
            }
        }
        else {
            final Iterator iterator = list.iterator();
            while (true) {
                ub2 = ub;
                if (!iterator.hasNext()) {
                    break;
                }
                final int intValue2 = (int)iterator.next();
                if (enumLiteMap.a(intValue2) != null) {
                    continue;
                }
                ub = L(n, intValue2, ub, o0);
                iterator.remove();
            }
        }
        return ub2;
    }
}
