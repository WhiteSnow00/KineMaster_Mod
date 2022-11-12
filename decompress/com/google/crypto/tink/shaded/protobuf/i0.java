// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Map;
import java.io.IOException;
import java.util.List;

interface i0
{
    void A(final List<String> p0) throws IOException;
    
    void B(final List<Float> p0) throws IOException;
    
    boolean C() throws IOException;
    
    int D() throws IOException;
    
    void E(final List<ByteString> p0) throws IOException;
    
    void F(final List<Double> p0) throws IOException;
    
    long G() throws IOException;
    
    String H() throws IOException;
    
    @Deprecated
     <T> T I(final j0<T> p0, final ExtensionRegistryLite p1) throws IOException;
    
    @Deprecated
     <T> T J(final Class<T> p0, final ExtensionRegistryLite p1) throws IOException;
    
     <K, V> void K(final Map<K, V> p0, final MapEntryLite.a<K, V> p1, final ExtensionRegistryLite p2) throws IOException;
    
     <T> void L(final List<T> p0, final j0<T> p1, final ExtensionRegistryLite p2) throws IOException;
    
     <T> T M(final j0<T> p0, final ExtensionRegistryLite p1) throws IOException;
    
     <T> T N(final Class<T> p0, final ExtensionRegistryLite p1) throws IOException;
    
    @Deprecated
     <T> void O(final List<T> p0, final j0<T> p1, final ExtensionRegistryLite p2) throws IOException;
    
    long a() throws IOException;
    
    void b(final List<Integer> p0) throws IOException;
    
    void c(final List<Long> p0) throws IOException;
    
    boolean d() throws IOException;
    
    long e() throws IOException;
    
    void f(final List<Long> p0) throws IOException;
    
    int g() throws IOException;
    
    int getTag();
    
    void h(final List<Long> p0) throws IOException;
    
    void i(final List<Integer> p0) throws IOException;
    
    int j() throws IOException;
    
    int k() throws IOException;
    
    void l(final List<Boolean> p0) throws IOException;
    
    void m(final List<String> p0) throws IOException;
    
    ByteString n() throws IOException;
    
    int o() throws IOException;
    
    void p(final List<Long> p0) throws IOException;
    
    void q(final List<Integer> p0) throws IOException;
    
    long r() throws IOException;
    
    double readDouble() throws IOException;
    
    float readFloat() throws IOException;
    
    void s(final List<Integer> p0) throws IOException;
    
    int t() throws IOException;
    
    void u(final List<Long> p0) throws IOException;
    
    void v(final List<Integer> p0) throws IOException;
    
    void w(final List<Integer> p0) throws IOException;
    
    long x() throws IOException;
    
    String y() throws IOException;
    
    int z() throws IOException;
}
