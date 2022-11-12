// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Map;
import java.util.List;
import java.io.IOException;

final class g implements i0
{
    private final CodedInputStream a;
    private int b;
    private int c;
    private int d;
    
    private g(CodedInputStream a) {
        this.d = 0;
        a = Internal.b(a, "input");
        this.a = a;
        a.d = this;
    }
    
    public static g P(final CodedInputStream codedInputStream) {
        final g d = codedInputStream.d;
        if (d != null) {
            return d;
        }
        return new g(codedInputStream);
    }
    
    private <T> T Q(final j0<T> j0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        final int c = this.c;
        this.c = WireFormat.c(WireFormat.a(this.b), 4);
        try {
            final T e = j0.e();
            j0.i(e, this, extensionRegistryLite);
            j0.b(e);
            if (this.b == this.c) {
                return e;
            }
            throw InvalidProtocolBufferException.parseFailure();
        }
        finally {
            this.c = c;
        }
    }
    
    private <T> T R(final j0<T> j0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        final int d = this.a.D();
        final CodedInputStream a = this.a;
        if (a.a < a.b) {
            final int m = a.m(d);
            final T e = j0.e();
            final CodedInputStream a2 = this.a;
            ++a2.a;
            j0.i(e, this, extensionRegistryLite);
            j0.b(e);
            this.a.a(0);
            final CodedInputStream a3 = this.a;
            --a3.a;
            a3.l(m);
            return e;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }
    
    private void T(final int n) throws IOException {
        if (this.a.d() == n) {
            return;
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }
    
    private void U(final int n) throws IOException {
        if (WireFormat.b(this.b) == n) {
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }
    
    private void V(final int n) throws IOException {
        if ((n & 0x3) == 0x0) {
            return;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }
    
    private void W(final int n) throws IOException {
        if ((n & 0x7) == 0x0) {
            return;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }
    
    @Override
    public void A(final List<String> list) throws IOException {
        this.S(list, false);
    }
    
    @Override
    public void B(final List<Float> list) throws IOException {
        if (list instanceof n) {
            final n n = (n)list;
            final int b = WireFormat.b(this.b);
            if (b != 2) {
                if (b == 5) {
                    int i;
                    do {
                        n.f(this.a.t());
                        if (this.a.e()) {
                            return;
                        }
                        i = this.a.C();
                    } while (i == this.b);
                    this.d = i;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            else {
                final int d = this.a.D();
                this.V(d);
                do {
                    n.f(this.a.t());
                } while (this.a.d() < this.a.d() + d);
            }
        }
        else {
            final int b2 = WireFormat.b(this.b);
            if (b2 != 2) {
                if (b2 == 5) {
                    int j;
                    do {
                        list.add(this.a.t());
                        if (this.a.e()) {
                            return;
                        }
                        j = this.a.C();
                    } while (j == this.b);
                    this.d = j;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            else {
                final int d2 = this.a.D();
                this.V(d2);
                do {
                    list.add(this.a.t());
                } while (this.a.d() < this.a.d() + d2);
            }
        }
    }
    
    @Override
    public boolean C() throws IOException {
        if (!this.a.e()) {
            final int b = this.b;
            if (b != this.c) {
                return this.a.F(b);
            }
        }
        return false;
    }
    
    @Override
    public int D() throws IOException {
        this.U(5);
        return this.a.w();
    }
    
    @Override
    public void E(final List<ByteString> list) throws IOException {
        if (WireFormat.b(this.b) == 2) {
            int i;
            do {
                list.add(this.n());
                if (this.a.e()) {
                    return;
                }
                i = this.a.C();
            } while (i == this.b);
            this.d = i;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }
    
    @Override
    public void F(final List<Double> list) throws IOException {
        if (list instanceof i) {
            final i i = (i)list;
            final int b = WireFormat.b(this.b);
            if (b == 1) {
                int j;
                do {
                    i.f(this.a.p());
                    if (this.a.e()) {
                        return;
                    }
                    j = this.a.C();
                } while (j == this.b);
                this.d = j;
                return;
            }
            if (b != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int d = this.a.D();
            this.W(d);
            do {
                i.f(this.a.p());
            } while (this.a.d() < this.a.d() + d);
        }
        else {
            final int b2 = WireFormat.b(this.b);
            if (b2 == 1) {
                int k;
                do {
                    list.add(this.a.p());
                    if (this.a.e()) {
                        return;
                    }
                    k = this.a.C();
                } while (k == this.b);
                this.d = k;
                return;
            }
            if (b2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int d2 = this.a.D();
            this.W(d2);
            do {
                list.add(this.a.p());
            } while (this.a.d() < this.a.d() + d2);
        }
    }
    
    @Override
    public long G() throws IOException {
        this.U(0);
        return this.a.v();
    }
    
    @Override
    public String H() throws IOException {
        this.U(2);
        return this.a.B();
    }
    
    @Override
    public <T> T I(final j0<T> j0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        this.U(3);
        return (T)this.Q((j0<Object>)j0, extensionRegistryLite);
    }
    
    @Override
    public <T> T J(final Class<T> clazz, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        this.U(3);
        return this.Q((j0<T>)f0.a().d((Class<T>)clazz), extensionRegistryLite);
    }
    
    @Override
    public <K, V> void K(final Map<K, V> map, final MapEntryLite.a<K, V> a, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        this.U(2);
        this.a.m(this.a.D());
        throw null;
    }
    
    @Override
    public <T> void L(final List<T> list, final j0<T> j0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        if (WireFormat.b(this.b) == 2) {
            int i;
            do {
                list.add(this.R(j0, extensionRegistryLite));
                if (!this.a.e()) {
                    if (this.d == 0) {
                        i = this.a.C();
                        continue;
                    }
                }
                return;
            } while (i == this.b);
            this.d = i;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }
    
    @Override
    public <T> T M(final j0<T> j0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        this.U(2);
        return (T)this.R((j0<Object>)j0, extensionRegistryLite);
    }
    
    @Override
    public <T> T N(final Class<T> clazz, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        this.U(2);
        return this.R((j0<T>)f0.a().d((Class<T>)clazz), extensionRegistryLite);
    }
    
    @Override
    public <T> void O(final List<T> list, final j0<T> j0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
        if (WireFormat.b(this.b) == 3) {
            int i;
            do {
                list.add(this.Q(j0, extensionRegistryLite));
                if (!this.a.e()) {
                    if (this.d == 0) {
                        i = this.a.C();
                        continue;
                    }
                }
                return;
            } while (i == this.b);
            this.d = i;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }
    
    public void S(final List<String> list, final boolean b) throws IOException {
        if (WireFormat.b(this.b) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        if (list instanceof LazyStringList && !b) {
            final LazyStringList list2 = (LazyStringList)list;
            int i;
            do {
                list2.r1(this.n());
                if (this.a.e()) {
                    return;
                }
                i = this.a.C();
            } while (i == this.b);
            this.d = i;
            return;
        }
        int j;
        do {
            String s;
            if (b) {
                s = this.H();
            }
            else {
                s = this.y();
            }
            list.add(s);
            if (this.a.e()) {
                return;
            }
            j = this.a.C();
        } while (j == this.b);
        this.d = j;
    }
    
    @Override
    public long a() throws IOException {
        this.U(1);
        return this.a.s();
    }
    
    @Override
    public void b(final List<Integer> list) throws IOException {
        if (list instanceof p) {
            final p p = (p)list;
            final int b = WireFormat.b(this.b);
            if (b != 2) {
                if (b == 5) {
                    int i;
                    do {
                        p.N0(this.a.w());
                        if (this.a.e()) {
                            return;
                        }
                        i = this.a.C();
                    } while (i == this.b);
                    this.d = i;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            else {
                final int d = this.a.D();
                this.V(d);
                do {
                    p.N0(this.a.w());
                } while (this.a.d() < this.a.d() + d);
            }
        }
        else {
            final int b2 = WireFormat.b(this.b);
            if (b2 != 2) {
                if (b2 == 5) {
                    int j;
                    do {
                        list.add(this.a.w());
                        if (this.a.e()) {
                            return;
                        }
                        j = this.a.C();
                    } while (j == this.b);
                    this.d = j;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            else {
                final int d2 = this.a.D();
                this.V(d2);
                do {
                    list.add(this.a.w());
                } while (this.a.d() < this.a.d() + d2);
            }
        }
    }
    
    @Override
    public void c(final List<Long> list) throws IOException {
        if (list instanceof r) {
            final r r = (r)list;
            final int b = WireFormat.b(this.b);
            if (b == 0) {
                int i;
                do {
                    r.g(this.a.z());
                    if (this.a.e()) {
                        return;
                    }
                    i = this.a.C();
                } while (i == this.b);
                this.d = i;
                return;
            }
            if (b != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n = this.a.d() + this.a.D();
            do {
                r.g(this.a.z());
            } while (this.a.d() < n);
            this.T(n);
        }
        else {
            final int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                int j;
                do {
                    list.add(this.a.z());
                    if (this.a.e()) {
                        return;
                    }
                    j = this.a.C();
                } while (j == this.b);
                this.d = j;
                return;
            }
            if (b2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n2 = this.a.d() + this.a.D();
            do {
                list.add(this.a.z());
            } while (this.a.d() < n2);
            this.T(n2);
        }
    }
    
    @Override
    public boolean d() throws IOException {
        this.U(0);
        return this.a.n();
    }
    
    @Override
    public long e() throws IOException {
        this.U(1);
        return this.a.x();
    }
    
    @Override
    public void f(final List<Long> list) throws IOException {
        if (list instanceof r) {
            final r r = (r)list;
            final int b = WireFormat.b(this.b);
            if (b == 0) {
                int i;
                do {
                    r.g(this.a.E());
                    if (this.a.e()) {
                        return;
                    }
                    i = this.a.C();
                } while (i == this.b);
                this.d = i;
                return;
            }
            if (b != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n = this.a.d() + this.a.D();
            do {
                r.g(this.a.E());
            } while (this.a.d() < n);
            this.T(n);
        }
        else {
            final int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                int j;
                do {
                    list.add(this.a.E());
                    if (this.a.e()) {
                        return;
                    }
                    j = this.a.C();
                } while (j == this.b);
                this.d = j;
                return;
            }
            if (b2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n2 = this.a.d() + this.a.D();
            do {
                list.add(this.a.E());
            } while (this.a.d() < n2);
            this.T(n2);
        }
    }
    
    @Override
    public int g() throws IOException {
        this.U(0);
        return this.a.D();
    }
    
    @Override
    public int getTag() {
        return this.b;
    }
    
    @Override
    public void h(final List<Long> list) throws IOException {
        if (list instanceof r) {
            final r r = (r)list;
            final int b = WireFormat.b(this.b);
            if (b == 0) {
                int i;
                do {
                    r.g(this.a.v());
                    if (this.a.e()) {
                        return;
                    }
                    i = this.a.C();
                } while (i == this.b);
                this.d = i;
                return;
            }
            if (b != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n = this.a.d() + this.a.D();
            do {
                r.g(this.a.v());
            } while (this.a.d() < n);
            this.T(n);
        }
        else {
            final int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                int j;
                do {
                    list.add(this.a.v());
                    if (this.a.e()) {
                        return;
                    }
                    j = this.a.C();
                } while (j == this.b);
                this.d = j;
                return;
            }
            if (b2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n2 = this.a.d() + this.a.D();
            do {
                list.add(this.a.v());
            } while (this.a.d() < n2);
            this.T(n2);
        }
    }
    
    @Override
    public void i(final List<Integer> list) throws IOException {
        if (list instanceof p) {
            final p p = (p)list;
            final int b = WireFormat.b(this.b);
            if (b == 0) {
                int i;
                do {
                    p.N0(this.a.q());
                    if (this.a.e()) {
                        return;
                    }
                    i = this.a.C();
                } while (i == this.b);
                this.d = i;
                return;
            }
            if (b != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n = this.a.d() + this.a.D();
            do {
                p.N0(this.a.q());
            } while (this.a.d() < n);
            this.T(n);
        }
        else {
            final int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                int j;
                do {
                    list.add(this.a.q());
                    if (this.a.e()) {
                        return;
                    }
                    j = this.a.C();
                } while (j == this.b);
                this.d = j;
                return;
            }
            if (b2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n2 = this.a.d() + this.a.D();
            do {
                list.add(this.a.q());
            } while (this.a.d() < n2);
            this.T(n2);
        }
    }
    
    @Override
    public int j() throws IOException {
        this.U(0);
        return this.a.q();
    }
    
    @Override
    public int k() throws IOException {
        this.U(0);
        return this.a.y();
    }
    
    @Override
    public void l(final List<Boolean> list) throws IOException {
        if (list instanceof e) {
            final e e = (e)list;
            final int b = WireFormat.b(this.b);
            if (b == 0) {
                int i;
                do {
                    e.g(this.a.n());
                    if (this.a.e()) {
                        return;
                    }
                    i = this.a.C();
                } while (i == this.b);
                this.d = i;
                return;
            }
            if (b != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n = this.a.d() + this.a.D();
            do {
                e.g(this.a.n());
            } while (this.a.d() < n);
            this.T(n);
        }
        else {
            final int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                int j;
                do {
                    list.add(this.a.n());
                    if (this.a.e()) {
                        return;
                    }
                    j = this.a.C();
                } while (j == this.b);
                this.d = j;
                return;
            }
            if (b2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n2 = this.a.d() + this.a.D();
            do {
                list.add(this.a.n());
            } while (this.a.d() < n2);
            this.T(n2);
        }
    }
    
    @Override
    public void m(final List<String> list) throws IOException {
        this.S(list, true);
    }
    
    @Override
    public ByteString n() throws IOException {
        this.U(2);
        return this.a.o();
    }
    
    @Override
    public int o() throws IOException {
        this.U(0);
        return this.a.u();
    }
    
    @Override
    public void p(final List<Long> list) throws IOException {
        if (list instanceof r) {
            final r r = (r)list;
            final int b = WireFormat.b(this.b);
            if (b == 1) {
                int i;
                do {
                    r.g(this.a.s());
                    if (this.a.e()) {
                        return;
                    }
                    i = this.a.C();
                } while (i == this.b);
                this.d = i;
                return;
            }
            if (b != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int d = this.a.D();
            this.W(d);
            do {
                r.g(this.a.s());
            } while (this.a.d() < this.a.d() + d);
        }
        else {
            final int b2 = WireFormat.b(this.b);
            if (b2 == 1) {
                int j;
                do {
                    list.add(this.a.s());
                    if (this.a.e()) {
                        return;
                    }
                    j = this.a.C();
                } while (j == this.b);
                this.d = j;
                return;
            }
            if (b2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int d2 = this.a.D();
            this.W(d2);
            do {
                list.add(this.a.s());
            } while (this.a.d() < this.a.d() + d2);
        }
    }
    
    @Override
    public void q(final List<Integer> list) throws IOException {
        if (list instanceof p) {
            final p p = (p)list;
            final int b = WireFormat.b(this.b);
            if (b == 0) {
                int i;
                do {
                    p.N0(this.a.y());
                    if (this.a.e()) {
                        return;
                    }
                    i = this.a.C();
                } while (i == this.b);
                this.d = i;
                return;
            }
            if (b != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n = this.a.d() + this.a.D();
            do {
                p.N0(this.a.y());
            } while (this.a.d() < n);
            this.T(n);
        }
        else {
            final int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                int j;
                do {
                    list.add(this.a.y());
                    if (this.a.e()) {
                        return;
                    }
                    j = this.a.C();
                } while (j == this.b);
                this.d = j;
                return;
            }
            if (b2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n2 = this.a.d() + this.a.D();
            do {
                list.add(this.a.y());
            } while (this.a.d() < n2);
            this.T(n2);
        }
    }
    
    @Override
    public long r() throws IOException {
        this.U(0);
        return this.a.E();
    }
    
    @Override
    public double readDouble() throws IOException {
        this.U(1);
        return this.a.p();
    }
    
    @Override
    public float readFloat() throws IOException {
        this.U(5);
        return this.a.t();
    }
    
    @Override
    public void s(final List<Integer> list) throws IOException {
        if (list instanceof p) {
            final p p = (p)list;
            final int b = WireFormat.b(this.b);
            if (b == 0) {
                int i;
                do {
                    p.N0(this.a.D());
                    if (this.a.e()) {
                        return;
                    }
                    i = this.a.C();
                } while (i == this.b);
                this.d = i;
                return;
            }
            if (b != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n = this.a.d() + this.a.D();
            do {
                p.N0(this.a.D());
            } while (this.a.d() < n);
            this.T(n);
        }
        else {
            final int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                int j;
                do {
                    list.add(this.a.D());
                    if (this.a.e()) {
                        return;
                    }
                    j = this.a.C();
                } while (j == this.b);
                this.d = j;
                return;
            }
            if (b2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n2 = this.a.d() + this.a.D();
            do {
                list.add(this.a.D());
            } while (this.a.d() < n2);
            this.T(n2);
        }
    }
    
    @Override
    public int t() throws IOException {
        this.U(5);
        return this.a.r();
    }
    
    @Override
    public void u(final List<Long> list) throws IOException {
        if (list instanceof r) {
            final r r = (r)list;
            final int b = WireFormat.b(this.b);
            if (b == 1) {
                int i;
                do {
                    r.g(this.a.x());
                    if (this.a.e()) {
                        return;
                    }
                    i = this.a.C();
                } while (i == this.b);
                this.d = i;
                return;
            }
            if (b != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int d = this.a.D();
            this.W(d);
            do {
                r.g(this.a.x());
            } while (this.a.d() < this.a.d() + d);
        }
        else {
            final int b2 = WireFormat.b(this.b);
            if (b2 == 1) {
                int j;
                do {
                    list.add(this.a.x());
                    if (this.a.e()) {
                        return;
                    }
                    j = this.a.C();
                } while (j == this.b);
                this.d = j;
                return;
            }
            if (b2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int d2 = this.a.D();
            this.W(d2);
            do {
                list.add(this.a.x());
            } while (this.a.d() < this.a.d() + d2);
        }
    }
    
    @Override
    public void v(final List<Integer> list) throws IOException {
        if (list instanceof p) {
            final p p = (p)list;
            final int b = WireFormat.b(this.b);
            if (b == 0) {
                int i;
                do {
                    p.N0(this.a.u());
                    if (this.a.e()) {
                        return;
                    }
                    i = this.a.C();
                } while (i == this.b);
                this.d = i;
                return;
            }
            if (b != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n = this.a.d() + this.a.D();
            do {
                p.N0(this.a.u());
            } while (this.a.d() < n);
            this.T(n);
        }
        else {
            final int b2 = WireFormat.b(this.b);
            if (b2 == 0) {
                int j;
                do {
                    list.add(this.a.u());
                    if (this.a.e()) {
                        return;
                    }
                    j = this.a.C();
                } while (j == this.b);
                this.d = j;
                return;
            }
            if (b2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            final int n2 = this.a.d() + this.a.D();
            do {
                list.add(this.a.u());
            } while (this.a.d() < n2);
            this.T(n2);
        }
    }
    
    @Override
    public void w(final List<Integer> list) throws IOException {
        if (list instanceof p) {
            final p p = (p)list;
            final int b = WireFormat.b(this.b);
            if (b != 2) {
                if (b == 5) {
                    int i;
                    do {
                        p.N0(this.a.r());
                        if (this.a.e()) {
                            return;
                        }
                        i = this.a.C();
                    } while (i == this.b);
                    this.d = i;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            else {
                final int d = this.a.D();
                this.V(d);
                do {
                    p.N0(this.a.r());
                } while (this.a.d() < this.a.d() + d);
            }
        }
        else {
            final int b2 = WireFormat.b(this.b);
            if (b2 != 2) {
                if (b2 == 5) {
                    int j;
                    do {
                        list.add(this.a.r());
                        if (this.a.e()) {
                            return;
                        }
                        j = this.a.C();
                    } while (j == this.b);
                    this.d = j;
                    return;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
            else {
                final int d2 = this.a.D();
                this.V(d2);
                do {
                    list.add(this.a.r());
                } while (this.a.d() < this.a.d() + d2);
            }
        }
    }
    
    @Override
    public long x() throws IOException {
        this.U(0);
        return this.a.z();
    }
    
    @Override
    public String y() throws IOException {
        this.U(2);
        return this.a.A();
    }
    
    @Override
    public int z() throws IOException {
        final int d = this.d;
        if (d != 0) {
            this.b = d;
            this.d = 0;
        }
        else {
            this.b = this.a.C();
        }
        final int b = this.b;
        if (b != 0 && b != this.c) {
            return WireFormat.a(b);
        }
        return Integer.MAX_VALUE;
    }
}
