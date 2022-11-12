// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Map;
import java.io.IOException;
import java.util.List;

interface Writer
{
    void A(final int p0, final List<Boolean> p1, final boolean p2) throws IOException;
    
    void B(final int p0, final float p1) throws IOException;
    
    @Deprecated
    void C(final int p0) throws IOException;
    
    void D(final int p0, final List<Integer> p1, final boolean p2) throws IOException;
    
    void E(final int p0, final int p1) throws IOException;
    
    void F(final int p0, final List<Long> p1, final boolean p2) throws IOException;
    
    void G(final int p0, final List<Double> p1, final boolean p2) throws IOException;
    
    void H(final int p0, final int p1) throws IOException;
    
    void I(final int p0, final List<ByteString> p1) throws IOException;
    
     <K, V> void J(final int p0, final MapEntryLite.a<K, V> p1, final Map<K, V> p2) throws IOException;
    
    @Deprecated
    void K(final int p0, final Object p1, final j0 p2) throws IOException;
    
    void L(final int p0, final List<?> p1, final j0 p2) throws IOException;
    
    void M(final int p0, final ByteString p1) throws IOException;
    
    void N(final int p0, final Object p1, final j0 p2) throws IOException;
    
    @Deprecated
    void O(final int p0, final List<?> p1, final j0 p2) throws IOException;
    
    void a(final int p0, final List<Float> p1, final boolean p2) throws IOException;
    
    void b(final int p0, final Object p1) throws IOException;
    
    void c(final int p0, final int p1) throws IOException;
    
    void d(final int p0, final List<String> p1) throws IOException;
    
    void e(final int p0, final String p1) throws IOException;
    
    void f(final int p0, final long p1) throws IOException;
    
    void g(final int p0, final List<Integer> p1, final boolean p2) throws IOException;
    
    void h(final int p0, final int p1) throws IOException;
    
    void i(final int p0, final long p1) throws IOException;
    
    void j(final int p0, final List<Integer> p1, final boolean p2) throws IOException;
    
    void k(final int p0, final List<Integer> p1, final boolean p2) throws IOException;
    
    void l(final int p0, final List<Long> p1, final boolean p2) throws IOException;
    
    void m(final int p0, final long p1) throws IOException;
    
    void n(final int p0, final List<Integer> p1, final boolean p2) throws IOException;
    
    void o(final int p0, final int p1) throws IOException;
    
    void p(final int p0, final double p1) throws IOException;
    
    void q(final int p0, final List<Long> p1, final boolean p2) throws IOException;
    
    void r(final int p0, final List<Long> p1, final boolean p2) throws IOException;
    
    void s(final int p0, final long p1) throws IOException;
    
    FieldOrder t();
    
    void u(final int p0, final long p1) throws IOException;
    
    void v(final int p0, final boolean p1) throws IOException;
    
    void w(final int p0, final int p1) throws IOException;
    
    @Deprecated
    void x(final int p0) throws IOException;
    
    void y(final int p0, final List<Long> p1, final boolean p2) throws IOException;
    
    void z(final int p0, final List<Integer> p1, final boolean p2) throws IOException;
    
    public enum FieldOrder
    {
        private static final FieldOrder[] $VALUES;
        
        ASCENDING, 
        DESCENDING;
    }
}
