// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

abstract class o0<T, B>
{
    abstract void a(final B p0, final int p1, final int p2);
    
    abstract void b(final B p0, final int p1, final long p2);
    
    abstract void c(final B p0, final int p1, final T p2);
    
    abstract void d(final B p0, final int p1, final ByteString p2);
    
    abstract void e(final B p0, final int p1, final long p2);
    
    abstract B f(final Object p0);
    
    abstract T g(final Object p0);
    
    abstract int h(final T p0);
    
    abstract int i(final T p0);
    
    abstract void j(final Object p0);
    
    abstract T k(final T p0, final T p1);
    
    final void l(final B b, final i0 i0) throws IOException {
        while (i0.z() != Integer.MAX_VALUE && this.m(b, i0)) {}
    }
    
    final boolean m(final B b, final i0 i0) throws IOException {
        final int tag = i0.getTag();
        final int a = WireFormat.a(tag);
        final int b2 = WireFormat.b(tag);
        if (b2 == 0) {
            this.e(b, a, i0.G());
            return true;
        }
        if (b2 == 1) {
            this.b(b, a, i0.a());
            return true;
        }
        if (b2 == 2) {
            this.d(b, a, i0.n());
            return true;
        }
        if (b2 != 3) {
            if (b2 == 4) {
                return false;
            }
            if (b2 == 5) {
                this.a(b, a, i0.t());
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        else {
            final B n = this.n();
            final int c = WireFormat.c(a, 4);
            this.l(n, i0);
            if (c == i0.getTag()) {
                this.c(b, a, this.r(n));
                return true;
            }
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }
    
    abstract B n();
    
    abstract void o(final Object p0, final B p1);
    
    abstract void p(final Object p0, final T p1);
    
    abstract boolean q(final i0 p0);
    
    abstract T r(final B p0);
    
    abstract void s(final T p0, final Writer p1) throws IOException;
    
    abstract void t(final T p0, final Writer p1) throws IOException;
}
