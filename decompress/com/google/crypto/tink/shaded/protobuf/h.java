// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.util.Map;

final class h implements Writer
{
    private final CodedOutputStream a;
    
    private h(CodedOutputStream a) {
        a = Internal.b(a, "output");
        this.a = a;
        a.a = this;
    }
    
    public static h P(final CodedOutputStream codedOutputStream) {
        final h a = codedOutputStream.a;
        if (a != null) {
            return a;
        }
        return new h(codedOutputStream);
    }
    
    private <K, V> void Q(final int n, final MapEntryLite.a<K, V> a, final Map<K, V> map) throws IOException {
        final int[] a2 = h$a.a;
        throw null;
    }
    
    private void R(final int n, final Object o) throws IOException {
        if (o instanceof String) {
            this.a.P0(n, (String)o);
        }
        else {
            this.a.n0(n, (ByteString)o);
        }
    }
    
    @Override
    public void A(int i, final List<Boolean> list, final boolean b) throws IOException {
        int j = 0;
        final int n = 0;
        if (b) {
            this.a.Q0(i, 2);
            int k = 0;
            i = 0;
            while (k < list.size()) {
                i += CodedOutputStream.f((boolean)list.get(k));
                ++k;
            }
            this.a.S0(i);
            for (i = n; i < list.size(); ++i) {
                this.a.m0((boolean)list.get(i));
            }
        }
        else {
            while (j < list.size()) {
                this.a.l0(i, (boolean)list.get(j));
                ++j;
            }
        }
    }
    
    @Override
    public void B(final int n, final float n2) throws IOException {
        this.a.w0(n, n2);
    }
    
    @Override
    public void C(final int n) throws IOException {
        this.a.Q0(n, 4);
    }
    
    @Override
    public void D(int i, final List<Integer> list, final boolean b) throws IOException {
        int j = 0;
        final int n = 0;
        if (b) {
            this.a.Q0(i, 2);
            int k = 0;
            i = 0;
            while (k < list.size()) {
                i += CodedOutputStream.R((int)list.get(k));
                ++k;
            }
            this.a.S0(i);
            for (i = n; i < list.size(); ++i) {
                this.a.M0((int)list.get(i));
            }
        }
        else {
            while (j < list.size()) {
                this.a.L0(i, (int)list.get(j));
                ++j;
            }
        }
    }
    
    @Override
    public void E(final int n, final int n2) throws IOException {
        this.a.q0(n, n2);
    }
    
    @Override
    public void F(int i, final List<Long> list, final boolean b) throws IOException {
        int j = 0;
        final int n = 0;
        if (b) {
            this.a.Q0(i, 2);
            i = 0;
            int n2 = 0;
            while (i < list.size()) {
                n2 += CodedOutputStream.z(list.get(i));
                ++i;
            }
            this.a.S0(n2);
            for (i = n; i < list.size(); ++i) {
                this.a.D0((long)list.get(i));
            }
        }
        else {
            while (j < list.size()) {
                this.a.C0(i, (long)list.get(j));
                ++j;
            }
        }
    }
    
    @Override
    public void G(int i, final List<Double> list, final boolean b) throws IOException {
        int j = 0;
        final int n = 0;
        if (b) {
            this.a.Q0(i, 2);
            i = 0;
            int n2 = 0;
            while (i < list.size()) {
                n2 += CodedOutputStream.k(list.get(i));
                ++i;
            }
            this.a.S0(n2);
            for (i = n; i < list.size(); ++i) {
                this.a.p0((double)list.get(i));
            }
        }
        else {
            while (j < list.size()) {
                this.a.o0(i, (double)list.get(j));
                ++j;
            }
        }
    }
    
    @Override
    public void H(final int n, final int n2) throws IOException {
        this.a.L0(n, n2);
    }
    
    @Override
    public void I(final int n, final List<ByteString> list) throws IOException {
        for (int i = 0; i < list.size(); ++i) {
            this.a.n0(n, (ByteString)list.get(i));
        }
    }
    
    @Override
    public <K, V> void J(final int n, final MapEntryLite.a<K, V> a, final Map<K, V> map) throws IOException {
        if (this.a.f0()) {
            this.Q(n, (MapEntryLite.a<Object, Object>)a, (Map<Object, Object>)map);
            return;
        }
        for (final Map.Entry<K, V> entry : map.entrySet()) {
            this.a.Q0(n, 2);
            this.a.S0(MapEntryLite.b((MapEntryLite.a<K, V>)a, entry.getKey(), entry.getValue()));
            MapEntryLite.d(this.a, (MapEntryLite.a<K, V>)a, (K)entry.getKey(), entry.getValue());
        }
    }
    
    @Override
    public void K(final int n, final Object o, final j0 j0) throws IOException {
        this.a.y0(n, (MessageLite)o, j0);
    }
    
    @Override
    public void L(final int n, final List<?> list, final j0 j0) throws IOException {
        for (int i = 0; i < list.size(); ++i) {
            this.N(n, list.get(i), j0);
        }
    }
    
    @Override
    public void M(final int n, final ByteString byteString) throws IOException {
        this.a.n0(n, byteString);
    }
    
    @Override
    public void N(final int n, final Object o, final j0 j0) throws IOException {
        this.a.E0(n, (MessageLite)o, j0);
    }
    
    @Override
    public void O(final int n, final List<?> list, final j0 j0) throws IOException {
        for (int i = 0; i < list.size(); ++i) {
            this.K(n, list.get(i), j0);
        }
    }
    
    @Override
    public void a(int i, final List<Float> list, final boolean b) throws IOException {
        int j = 0;
        final int n = 0;
        if (b) {
            this.a.Q0(i, 2);
            int k = 0;
            i = 0;
            while (k < list.size()) {
                i += CodedOutputStream.s((float)list.get(k));
                ++k;
            }
            this.a.S0(i);
            for (i = n; i < list.size(); ++i) {
                this.a.x0((float)list.get(i));
            }
        }
        else {
            while (j < list.size()) {
                this.a.w0(i, (float)list.get(j));
                ++j;
            }
        }
    }
    
    @Override
    public final void b(final int n, final Object o) throws IOException {
        if (o instanceof ByteString) {
            this.a.G0(n, (ByteString)o);
        }
        else {
            this.a.F0(n, (MessageLite)o);
        }
    }
    
    @Override
    public void c(final int n, final int n2) throws IOException {
        this.a.s0(n, n2);
    }
    
    @Override
    public void d(final int n, final List<String> list) throws IOException {
        final boolean b = list instanceof LazyStringList;
        int i = 0;
        final int n2 = 0;
        if (b) {
            final LazyStringList list2 = (LazyStringList)list;
            for (int j = n2; j < list.size(); ++j) {
                this.R(n, list2.u(j));
            }
        }
        else {
            while (i < list.size()) {
                this.a.P0(n, list.get(i));
                ++i;
            }
        }
    }
    
    @Override
    public void e(final int n, final String s) throws IOException {
        this.a.P0(n, s);
    }
    
    @Override
    public void f(final int n, final long n2) throws IOException {
        this.a.T0(n, n2);
    }
    
    @Override
    public void g(int i, final List<Integer> list, final boolean b) throws IOException {
        int j = 0;
        final int n = 0;
        if (b) {
            this.a.Q0(i, 2);
            i = 0;
            int n2 = 0;
            while (i < list.size()) {
                n2 += CodedOutputStream.x(list.get(i));
                ++i;
            }
            this.a.S0(n2);
            for (i = n; i < list.size(); ++i) {
                this.a.B0((int)list.get(i));
            }
        }
        else {
            while (j < list.size()) {
                this.a.A0(i, (int)list.get(j));
                ++j;
            }
        }
    }
    
    @Override
    public void h(final int n, final int n2) throws IOException {
        this.a.A0(n, n2);
    }
    
    @Override
    public void i(final int n, final long n2) throws IOException {
        this.a.J0(n, n2);
    }
    
    @Override
    public void j(int i, final List<Integer> list, final boolean b) throws IOException {
        int j = 0;
        final int n = 0;
        if (b) {
            this.a.Q0(i, 2);
            int k = 0;
            i = 0;
            while (k < list.size()) {
                i += CodedOutputStream.o((int)list.get(k));
                ++k;
            }
            this.a.S0(i);
            for (i = n; i < list.size(); ++i) {
                this.a.t0((int)list.get(i));
            }
        }
        else {
            while (j < list.size()) {
                this.a.s0(i, (int)list.get(j));
                ++j;
            }
        }
    }
    
    @Override
    public void k(int i, final List<Integer> list, final boolean b) throws IOException {
        int j = 0;
        final int n = 0;
        if (b) {
            this.a.Q0(i, 2);
            i = 0;
            int n2 = 0;
            while (i < list.size()) {
                n2 += CodedOutputStream.Y(list.get(i));
                ++i;
            }
            this.a.S0(n2);
            for (i = n; i < list.size(); ++i) {
                this.a.S0((int)list.get(i));
            }
        }
        else {
            while (j < list.size()) {
                this.a.R0(i, (int)list.get(j));
                ++j;
            }
        }
    }
    
    @Override
    public void l(int i, final List<Long> list, final boolean b) throws IOException {
        int j = 0;
        final int n = 0;
        if (b) {
            this.a.Q0(i, 2);
            int k = 0;
            i = 0;
            while (k < list.size()) {
                i += CodedOutputStream.T((long)list.get(k));
                ++k;
            }
            this.a.S0(i);
            for (i = n; i < list.size(); ++i) {
                this.a.O0((long)list.get(i));
            }
        }
        else {
            while (j < list.size()) {
                this.a.N0(i, (long)list.get(j));
                ++j;
            }
        }
    }
    
    @Override
    public void m(final int n, final long n2) throws IOException {
        this.a.N0(n, n2);
    }
    
    @Override
    public void n(int i, final List<Integer> list, final boolean b) throws IOException {
        int j = 0;
        final int n = 0;
        if (b) {
            this.a.Q0(i, 2);
            i = 0;
            int n2 = 0;
            while (i < list.size()) {
                n2 += CodedOutputStream.m(list.get(i));
                ++i;
            }
            this.a.S0(n2);
            for (i = n; i < list.size(); ++i) {
                this.a.r0((int)list.get(i));
            }
        }
        else {
            while (j < list.size()) {
                this.a.q0(i, (int)list.get(j));
                ++j;
            }
        }
    }
    
    @Override
    public void o(final int n, final int n2) throws IOException {
        this.a.R0(n, n2);
    }
    
    @Override
    public void p(final int n, final double n2) throws IOException {
        this.a.o0(n, n2);
    }
    
    @Override
    public void q(int i, final List<Long> list, final boolean b) throws IOException {
        int j = 0;
        final int n = 0;
        if (b) {
            this.a.Q0(i, 2);
            i = 0;
            int n2 = 0;
            while (i < list.size()) {
                n2 += CodedOutputStream.P(list.get(i));
                ++i;
            }
            this.a.S0(n2);
            for (i = n; i < list.size(); ++i) {
                this.a.K0((long)list.get(i));
            }
        }
        else {
            while (j < list.size()) {
                this.a.J0(i, (long)list.get(j));
                ++j;
            }
        }
    }
    
    @Override
    public void r(int i, final List<Long> list, final boolean b) throws IOException {
        int j = 0;
        final int n = 0;
        if (b) {
            this.a.Q0(i, 2);
            i = 0;
            int n2 = 0;
            while (i < list.size()) {
                n2 += CodedOutputStream.a0(list.get(i));
                ++i;
            }
            this.a.S0(n2);
            for (i = n; i < list.size(); ++i) {
                this.a.U0((long)list.get(i));
            }
        }
        else {
            while (j < list.size()) {
                this.a.T0(i, (long)list.get(j));
                ++j;
            }
        }
    }
    
    @Override
    public void s(final int n, final long n2) throws IOException {
        this.a.u0(n, n2);
    }
    
    @Override
    public FieldOrder t() {
        return FieldOrder.ASCENDING;
    }
    
    @Override
    public void u(final int n, final long n2) throws IOException {
        this.a.C0(n, n2);
    }
    
    @Override
    public void v(final int n, final boolean b) throws IOException {
        this.a.l0(n, b);
    }
    
    @Override
    public void w(final int n, final int n2) throws IOException {
        this.a.H0(n, n2);
    }
    
    @Override
    public void x(final int n) throws IOException {
        this.a.Q0(n, 3);
    }
    
    @Override
    public void y(int i, final List<Long> list, final boolean b) throws IOException {
        int j = 0;
        final int n = 0;
        if (b) {
            this.a.Q0(i, 2);
            int k = 0;
            i = 0;
            while (k < list.size()) {
                i += CodedOutputStream.q((long)list.get(k));
                ++k;
            }
            this.a.S0(i);
            for (i = n; i < list.size(); ++i) {
                this.a.v0((long)list.get(i));
            }
        }
        else {
            while (j < list.size()) {
                this.a.u0(i, (long)list.get(j));
                ++j;
            }
        }
    }
    
    @Override
    public void z(int i, final List<Integer> list, final boolean b) throws IOException {
        int j = 0;
        final int n = 0;
        if (b) {
            this.a.Q0(i, 2);
            i = 0;
            int n2 = 0;
            while (i < list.size()) {
                n2 += CodedOutputStream.N(list.get(i));
                ++i;
            }
            this.a.S0(n2);
            for (i = n; i < list.size(); ++i) {
                this.a.I0((int)list.get(i));
            }
        }
        else {
            while (j < list.size()) {
                this.a.H0(i, (int)list.get(j));
                ++j;
            }
        }
    }
}
