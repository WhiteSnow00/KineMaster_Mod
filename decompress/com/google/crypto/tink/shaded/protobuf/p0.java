// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

class p0 extends o0<UnknownFieldSetLite, UnknownFieldSetLite>
{
    UnknownFieldSetLite A(final Object o) {
        return ((GeneratedMessageLite)o).unknownFields;
    }
    
    int B(final UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.f();
    }
    
    int C(final UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.g();
    }
    
    UnknownFieldSetLite D(UnknownFieldSetLite k, final UnknownFieldSetLite unknownFieldSetLite) {
        if (!unknownFieldSetLite.equals(UnknownFieldSetLite.e())) {
            k = UnknownFieldSetLite.k(k, unknownFieldSetLite);
        }
        return k;
    }
    
    UnknownFieldSetLite E() {
        return UnknownFieldSetLite.l();
    }
    
    void F(final Object o, final UnknownFieldSetLite unknownFieldSetLite) {
        this.G(o, unknownFieldSetLite);
    }
    
    void G(final Object o, final UnknownFieldSetLite unknownFields) {
        ((GeneratedMessageLite)o).unknownFields = unknownFields;
    }
    
    UnknownFieldSetLite H(final UnknownFieldSetLite unknownFieldSetLite) {
        unknownFieldSetLite.j();
        return unknownFieldSetLite;
    }
    
    void I(final UnknownFieldSetLite unknownFieldSetLite, final Writer writer) throws IOException {
        unknownFieldSetLite.o(writer);
    }
    
    void J(final UnknownFieldSetLite unknownFieldSetLite, final Writer writer) throws IOException {
        unknownFieldSetLite.q(writer);
    }
    
    @Override
    /* bridge */ void a(final Object o, final int n, final int n2) {
        this.u((UnknownFieldSetLite)o, n, n2);
    }
    
    @Override
    /* bridge */ void b(final Object o, final int n, final long n2) {
        this.v((UnknownFieldSetLite)o, n, n2);
    }
    
    @Override
    /* bridge */ void c(final Object o, final int n, final Object o2) {
        this.w((UnknownFieldSetLite)o, n, (UnknownFieldSetLite)o2);
    }
    
    @Override
    /* bridge */ void d(final Object o, final int n, final ByteString byteString) {
        this.x((UnknownFieldSetLite)o, n, byteString);
    }
    
    @Override
    /* bridge */ void e(final Object o, final int n, final long n2) {
        this.y((UnknownFieldSetLite)o, n, n2);
    }
    
    @Override
    /* bridge */ Object f(final Object o) {
        return this.z(o);
    }
    
    @Override
    /* bridge */ Object g(final Object o) {
        return this.A(o);
    }
    
    @Override
    /* bridge */ int h(final Object o) {
        return this.B((UnknownFieldSetLite)o);
    }
    
    @Override
    /* bridge */ int i(final Object o) {
        return this.C((UnknownFieldSetLite)o);
    }
    
    @Override
    void j(final Object o) {
        this.A(o).j();
    }
    
    @Override
    /* bridge */ Object k(final Object o, final Object o2) {
        return this.D((UnknownFieldSetLite)o, (UnknownFieldSetLite)o2);
    }
    
    @Override
    /* bridge */ Object n() {
        return this.E();
    }
    
    @Override
    /* bridge */ void o(final Object o, final Object o2) {
        this.F(o, (UnknownFieldSetLite)o2);
    }
    
    @Override
    /* bridge */ void p(final Object o, final Object o2) {
        this.G(o, (UnknownFieldSetLite)o2);
    }
    
    @Override
    boolean q(final i0 i0) {
        return false;
    }
    
    @Override
    /* bridge */ Object r(final Object o) {
        return this.H((UnknownFieldSetLite)o);
    }
    
    @Override
    /* bridge */ void s(final Object o, final Writer writer) throws IOException {
        this.I((UnknownFieldSetLite)o, writer);
    }
    
    @Override
    /* bridge */ void t(final Object o, final Writer writer) throws IOException {
        this.J((UnknownFieldSetLite)o, writer);
    }
    
    void u(final UnknownFieldSetLite unknownFieldSetLite, final int n, final int n2) {
        unknownFieldSetLite.n(WireFormat.c(n, 5), n2);
    }
    
    void v(final UnknownFieldSetLite unknownFieldSetLite, final int n, final long n2) {
        unknownFieldSetLite.n(WireFormat.c(n, 1), n2);
    }
    
    void w(final UnknownFieldSetLite unknownFieldSetLite, final int n, final UnknownFieldSetLite unknownFieldSetLite2) {
        unknownFieldSetLite.n(WireFormat.c(n, 3), unknownFieldSetLite2);
    }
    
    void x(final UnknownFieldSetLite unknownFieldSetLite, final int n, final ByteString byteString) {
        unknownFieldSetLite.n(WireFormat.c(n, 2), byteString);
    }
    
    void y(final UnknownFieldSetLite unknownFieldSetLite, final int n, final long n2) {
        unknownFieldSetLite.n(WireFormat.c(n, 0), n2);
    }
    
    UnknownFieldSetLite z(final Object o) {
        UnknownFieldSetLite unknownFieldSetLite;
        if ((unknownFieldSetLite = this.A(o)) == UnknownFieldSetLite.e()) {
            unknownFieldSetLite = UnknownFieldSetLite.l();
            this.G(o, unknownFieldSetLite);
        }
        return unknownFieldSetLite;
    }
}
