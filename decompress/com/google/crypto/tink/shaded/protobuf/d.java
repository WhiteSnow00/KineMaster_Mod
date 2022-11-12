// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import java.nio.ByteBuffer;

abstract class d implements i0
{
    private d() {
    }
    
    d(final d$a object) {
        this();
    }
    
    public static d P(final ByteBuffer byteBuffer, final boolean b) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer, b);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
    
    private static final class b extends d
    {
        private final boolean a;
        private final byte[] b;
        private int c;
        private final int d;
        private int e;
        private int f;
        private int g;
        
        public b(final ByteBuffer byteBuffer, final boolean a) {
            super(null);
            this.a = a;
            this.b = byteBuffer.array();
            final int n = byteBuffer.arrayOffset() + byteBuffer.position();
            this.c = n;
            this.d = n;
            this.e = byteBuffer.arrayOffset() + byteBuffer.limit();
        }
        
        private boolean Q() {
            return this.c == this.e;
        }
        
        private byte R() throws IOException {
            final int c = this.c;
            if (c != this.e) {
                final byte[] b = this.b;
                this.c = c + 1;
                return b[c];
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        private <T> T S(final j0<T> j0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
            final int g = this.g;
            this.g = WireFormat.c(WireFormat.a(this.f), 4);
            try {
                final T e = j0.e();
                j0.i(e, this, extensionRegistryLite);
                j0.b(e);
                if (this.f == this.g) {
                    return e;
                }
                throw InvalidProtocolBufferException.parseFailure();
            }
            finally {
                this.g = g;
            }
        }
        
        private int T() throws IOException {
            this.d0(4);
            return this.U();
        }
        
        private int U() {
            final int c = this.c;
            final byte[] b = this.b;
            this.c = c + 4;
            return (b[c + 3] & 0xFF) << 24 | ((b[c] & 0xFF) | (b[c + 1] & 0xFF) << 8 | (b[c + 2] & 0xFF) << 16);
        }
        
        private long V() throws IOException {
            this.d0(8);
            return this.W();
        }
        
        private long W() {
            final int c = this.c;
            final byte[] b = this.b;
            this.c = c + 8;
            return ((long)b[c + 7] & 0xFFL) << 56 | (((long)b[c] & 0xFFL) | ((long)b[c + 1] & 0xFFL) << 8 | ((long)b[c + 2] & 0xFFL) << 16 | ((long)b[c + 3] & 0xFFL) << 24 | ((long)b[c + 4] & 0xFFL) << 32 | ((long)b[c + 5] & 0xFFL) << 40 | ((long)b[c + 6] & 0xFFL) << 48);
        }
        
        private <T> T X(final j0<T> j0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
            final int a0 = this.a0();
            this.d0(a0);
            final int e = this.e;
            final int e2 = this.c + a0;
            this.e = e2;
            try {
                final T e3 = j0.e();
                j0.i(e3, this, extensionRegistryLite);
                j0.b(e3);
                if (this.c == e2) {
                    return e3;
                }
                throw InvalidProtocolBufferException.parseFailure();
            }
            finally {
                this.e = e;
            }
        }
        
        private int a0() throws IOException {
            final int c = this.c;
            final int e = this.e;
            if (e == c) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            final byte[] b = this.b;
            final int c2 = c + 1;
            final byte b2 = b[c];
            if (b2 >= 0) {
                this.c = c2;
                return b2;
            }
            if (e - c2 < 9) {
                return (int)this.c0();
            }
            int c3 = c2 + 1;
            final int n = b2 ^ b[c2] << 7;
            int n2;
            if (n < 0) {
                n2 = (n ^ 0xFFFFFF80);
            }
            else {
                final int n3 = c3 + 1;
                final int n4 = n ^ b[c3] << 14;
                if (n4 >= 0) {
                    final int n5 = n4 ^ 0x3F80;
                    c3 = n3;
                    n2 = n5;
                }
                else {
                    c3 = n3 + 1;
                    final int n6 = n4 ^ b[n3] << 21;
                    if (n6 < 0) {
                        n2 = (n6 ^ 0xFFE03F80);
                    }
                    else {
                        final int n7 = c3 + 1;
                        final byte b3 = b[c3];
                        final int n8 = n2 = (n6 ^ b3 << 28 ^ 0xFE03F80);
                        c3 = n7;
                        if (b3 < 0) {
                            final int n9 = n7 + 1;
                            n2 = n8;
                            c3 = n9;
                            if (b[n7] < 0) {
                                final int n10 = n9 + 1;
                                n2 = n8;
                                c3 = n10;
                                if (b[n9] < 0) {
                                    final int n11 = n10 + 1;
                                    n2 = n8;
                                    c3 = n11;
                                    if (b[n10] < 0) {
                                        final int n12 = n11 + 1;
                                        n2 = n8;
                                        c3 = n12;
                                        if (b[n11] < 0) {
                                            c3 = n12 + 1;
                                            if (b[n12] < 0) {
                                                throw InvalidProtocolBufferException.malformedVarint();
                                            }
                                            n2 = n8;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.c = c3;
            return n2;
        }
        
        private long c0() throws IOException {
            long n = 0L;
            for (int i = 0; i < 64; i += 7) {
                final byte r = this.R();
                n |= (long)(r & 0x7F) << i;
                if ((r & 0x80) == 0x0) {
                    return n;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }
        
        private void d0(final int n) throws IOException {
            if (n >= 0 && n <= this.e - this.c) {
                return;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        private void e0(final int n) throws IOException {
            if (this.c == n) {
                return;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        
        private void f0(final int n) throws IOException {
            if (WireFormat.b(this.f) == n) {
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        
        private void g0(final int n) throws IOException {
            this.d0(n);
            this.c += n;
        }
        
        private void h0() throws IOException {
            final int g = this.g;
            this.g = WireFormat.c(WireFormat.a(this.f), 4);
            while (this.z() != Integer.MAX_VALUE && this.C()) {}
            if (this.f == this.g) {
                this.g = g;
                return;
            }
            throw InvalidProtocolBufferException.parseFailure();
        }
        
        private void i0() throws IOException {
            final int e = this.e;
            int c = this.c;
            if (e - c >= 10) {
                final byte[] b = this.b;
                int c2;
                for (int i = 0; i < 10; ++i, c = c2) {
                    c2 = c + 1;
                    if (b[c] >= 0) {
                        this.c = c2;
                        return;
                    }
                }
            }
            this.j0();
        }
        
        private void j0() throws IOException {
            for (int i = 0; i < 10; ++i) {
                if (this.R() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }
        
        private void k0(final int n) throws IOException {
            this.d0(n);
            if ((n & 0x3) == 0x0) {
                return;
            }
            throw InvalidProtocolBufferException.parseFailure();
        }
        
        private void l0(final int n) throws IOException {
            this.d0(n);
            if ((n & 0x7) == 0x0) {
                return;
            }
            throw InvalidProtocolBufferException.parseFailure();
        }
        
        @Override
        public void A(final List<String> list) throws IOException {
            this.Z(list, false);
        }
        
        @Override
        public void B(final List<Float> list) throws IOException {
            if (list instanceof n) {
                final n n = (n)list;
                final int b = WireFormat.b(this.f);
                if (b != 2) {
                    if (b == 5) {
                        int c;
                        do {
                            n.f(this.readFloat());
                            if (this.Q()) {
                                return;
                            }
                            c = this.c;
                        } while (this.a0() == this.f);
                        this.c = c;
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                else {
                    final int a0 = this.a0();
                    this.k0(a0);
                    while (this.c < this.c + a0) {
                        n.f(Float.intBitsToFloat(this.U()));
                    }
                }
            }
            else {
                final int b2 = WireFormat.b(this.f);
                if (b2 != 2) {
                    if (b2 == 5) {
                        int c2;
                        do {
                            list.add(this.readFloat());
                            if (this.Q()) {
                                return;
                            }
                            c2 = this.c;
                        } while (this.a0() == this.f);
                        this.c = c2;
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                else {
                    final int a2 = this.a0();
                    this.k0(a2);
                    while (this.c < this.c + a2) {
                        list.add(Float.intBitsToFloat(this.U()));
                    }
                }
            }
        }
        
        @Override
        public boolean C() throws IOException {
            if (!this.Q()) {
                final int f = this.f;
                if (f != this.g) {
                    final int b = WireFormat.b(f);
                    if (b == 0) {
                        this.i0();
                        return true;
                    }
                    if (b == 1) {
                        this.g0(8);
                        return true;
                    }
                    if (b == 2) {
                        this.g0(this.a0());
                        return true;
                    }
                    if (b == 3) {
                        this.h0();
                        return true;
                    }
                    if (b == 5) {
                        this.g0(4);
                        return true;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
            }
            return false;
        }
        
        @Override
        public int D() throws IOException {
            this.f0(5);
            return this.T();
        }
        
        @Override
        public void E(final List<ByteString> list) throws IOException {
            if (WireFormat.b(this.f) == 2) {
                int c;
                do {
                    list.add(this.n());
                    if (this.Q()) {
                        return;
                    }
                    c = this.c;
                } while (this.a0() == this.f);
                this.c = c;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        
        @Override
        public void F(final List<Double> list) throws IOException {
            if (list instanceof i) {
                final i i = (i)list;
                final int b = WireFormat.b(this.f);
                if (b == 1) {
                    int c;
                    do {
                        i.f(this.readDouble());
                        if (this.Q()) {
                            return;
                        }
                        c = this.c;
                    } while (this.a0() == this.f);
                    this.c = c;
                    return;
                }
                if (b != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                final int a0 = this.a0();
                this.l0(a0);
                while (this.c < this.c + a0) {
                    i.f(Double.longBitsToDouble(this.W()));
                }
            }
            else {
                final int b2 = WireFormat.b(this.f);
                if (b2 == 1) {
                    int c2;
                    do {
                        list.add(this.readDouble());
                        if (this.Q()) {
                            return;
                        }
                        c2 = this.c;
                    } while (this.a0() == this.f);
                    this.c = c2;
                    return;
                }
                if (b2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                final int a2 = this.a0();
                this.l0(a2);
                while (this.c < this.c + a2) {
                    list.add(Double.longBitsToDouble(this.W()));
                }
            }
        }
        
        @Override
        public long G() throws IOException {
            this.f0(0);
            return this.b0();
        }
        
        @Override
        public String H() throws IOException {
            return this.Y(true);
        }
        
        @Override
        public <T> T I(final j0<T> j0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
            this.f0(3);
            return (T)this.S((j0<Object>)j0, extensionRegistryLite);
        }
        
        @Override
        public <T> T J(final Class<T> clazz, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
            this.f0(3);
            return this.S((j0<T>)f0.a().d((Class<T>)clazz), extensionRegistryLite);
        }
        
        @Override
        public <K, V> void K(final Map<K, V> map, final MapEntryLite.a<K, V> a, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
            this.f0(2);
            final int a2 = this.a0();
            this.d0(a2);
            final int e = this.e;
            this.e = this.c + a2;
            try {
                throw null;
            }
            finally {
                this.e = e;
            }
        }
        
        @Override
        public <T> void L(final List<T> list, final j0<T> j0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (WireFormat.b(this.f) == 2) {
                int c;
                do {
                    list.add(this.X(j0, extensionRegistryLite));
                    if (this.Q()) {
                        return;
                    }
                    c = this.c;
                } while (this.a0() == this.f);
                this.c = c;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        
        @Override
        public <T> T M(final j0<T> j0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
            this.f0(2);
            return (T)this.X((j0<Object>)j0, extensionRegistryLite);
        }
        
        @Override
        public <T> T N(final Class<T> clazz, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
            this.f0(2);
            return this.X((j0<T>)f0.a().d((Class<T>)clazz), extensionRegistryLite);
        }
        
        @Override
        public <T> void O(final List<T> list, final j0<T> j0, final ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (WireFormat.b(this.f) == 3) {
                int c;
                do {
                    list.add(this.S(j0, extensionRegistryLite));
                    if (this.Q()) {
                        return;
                    }
                    c = this.c;
                } while (this.a0() == this.f);
                this.c = c;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
        
        public String Y(final boolean b) throws IOException {
            this.f0(2);
            final int a0 = this.a0();
            if (a0 == 0) {
                return "";
            }
            this.d0(a0);
            if (b) {
                final byte[] b2 = this.b;
                final int c = this.c;
                if (!Utf8.t(b2, c, c + a0)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            final String s = new String(this.b, this.c, a0, Internal.a);
            this.c += a0;
            return s;
        }
        
        public void Z(final List<String> list, final boolean b) throws IOException {
            if (WireFormat.b(this.f) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            if (list instanceof LazyStringList && !b) {
                final LazyStringList list2 = (LazyStringList)list;
                int c;
                do {
                    list2.r1(this.n());
                    if (this.Q()) {
                        return;
                    }
                    c = this.c;
                } while (this.a0() == this.f);
                this.c = c;
                return;
            }
            int c2;
            do {
                list.add(this.Y(b));
                if (this.Q()) {
                    return;
                }
                c2 = this.c;
            } while (this.a0() == this.f);
            this.c = c2;
        }
        
        @Override
        public long a() throws IOException {
            this.f0(1);
            return this.V();
        }
        
        @Override
        public void b(final List<Integer> list) throws IOException {
            if (list instanceof p) {
                final p p = (p)list;
                final int b = WireFormat.b(this.f);
                if (b != 2) {
                    if (b == 5) {
                        int c;
                        do {
                            p.N0(this.D());
                            if (this.Q()) {
                                return;
                            }
                            c = this.c;
                        } while (this.a0() == this.f);
                        this.c = c;
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                else {
                    final int a0 = this.a0();
                    this.k0(a0);
                    while (this.c < this.c + a0) {
                        p.N0(this.U());
                    }
                }
            }
            else {
                final int b2 = WireFormat.b(this.f);
                if (b2 != 2) {
                    if (b2 == 5) {
                        int c2;
                        do {
                            list.add(this.D());
                            if (this.Q()) {
                                return;
                            }
                            c2 = this.c;
                        } while (this.a0() == this.f);
                        this.c = c2;
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                else {
                    final int a2 = this.a0();
                    this.k0(a2);
                    while (this.c < this.c + a2) {
                        list.add(this.U());
                    }
                }
            }
        }
        
        public long b0() throws IOException {
            final int c = this.c;
            final int e = this.e;
            if (e == c) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            final byte[] b = this.b;
            final int c2 = c + 1;
            final byte b2 = b[c];
            if (b2 >= 0) {
                this.c = c2;
                return b2;
            }
            if (e - c2 < 9) {
                return this.c0();
            }
            int c3 = c2 + 1;
            final int n = b2 ^ b[c2] << 7;
            long n5 = 0L;
            Label_0345: {
                int n2;
                if (n < 0) {
                    n2 = (n ^ 0xFFFFFF80);
                }
                else {
                    final int n3 = c3 + 1;
                    final int n4 = n ^ b[c3] << 14;
                    if (n4 >= 0) {
                        n5 = (n4 ^ 0x3F80);
                        c3 = n3;
                        break Label_0345;
                    }
                    c3 = n3 + 1;
                    final int n6 = n4 ^ b[n3] << 21;
                    if (n6 >= 0) {
                        final long n7 = n6;
                        final int n8 = c3 + 1;
                        long n9 = n7 ^ (long)b[c3] << 28;
                        long n13 = 0L;
                        Label_0177: {
                            if (n9 < 0L) {
                                final int n10 = n8 + 1;
                                long n11 = n9 ^ (long)b[n8] << 35;
                                long n12;
                                if (n11 < 0L) {
                                    n12 = -34093383808L;
                                    c3 = n10;
                                }
                                else {
                                    c3 = n10 + 1;
                                    n9 = (n11 ^ (long)b[n10] << 42);
                                    if (n9 >= 0L) {
                                        n13 = 4363953127296L;
                                        break Label_0177;
                                    }
                                    final int n14 = c3 + 1;
                                    n11 = (n9 ^ (long)b[c3] << 49);
                                    if (n11 < 0L) {
                                        n12 = -558586000294016L;
                                        c3 = n14;
                                    }
                                    else {
                                        c3 = n14 + 1;
                                        n5 = (n11 ^ (long)b[n14] << 56 ^ 0xFE03F80FE03F80L);
                                        if (n5 >= 0L) {
                                            break Label_0345;
                                        }
                                        final int n15 = c3 + 1;
                                        if (b[c3] >= 0L) {
                                            c3 = n15;
                                            break Label_0345;
                                        }
                                        throw InvalidProtocolBufferException.malformedVarint();
                                    }
                                }
                                n5 = (n11 ^ n12);
                                break Label_0345;
                            }
                            n13 = 266354560L;
                            c3 = n8;
                        }
                        n5 = (n9 ^ n13);
                        break Label_0345;
                    }
                    n2 = (n6 ^ 0xFFE03F80);
                }
                n5 = n2;
            }
            this.c = c3;
            return n5;
        }
        
        @Override
        public void c(final List<Long> list) throws IOException {
            if (list instanceof r) {
                final r r = (r)list;
                final int b = WireFormat.b(this.f);
                if (b == 0) {
                    int c;
                    do {
                        r.g(this.x());
                        if (this.Q()) {
                            return;
                        }
                        c = this.c;
                    } while (this.a0() == this.f);
                    this.c = c;
                    return;
                }
                if (b != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                while (this.c < this.c + this.a0()) {
                    r.g(CodedInputStream.c(this.b0()));
                }
            }
            else {
                final int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    int c2;
                    do {
                        list.add(this.x());
                        if (this.Q()) {
                            return;
                        }
                        c2 = this.c;
                    } while (this.a0() == this.f);
                    this.c = c2;
                    return;
                }
                if (b2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                while (this.c < this.c + this.a0()) {
                    list.add(CodedInputStream.c(this.b0()));
                }
            }
        }
        
        @Override
        public boolean d() throws IOException {
            boolean b = false;
            this.f0(0);
            if (this.a0() != 0) {
                b = true;
            }
            return b;
        }
        
        @Override
        public long e() throws IOException {
            this.f0(1);
            return this.V();
        }
        
        @Override
        public void f(final List<Long> list) throws IOException {
            if (list instanceof r) {
                final r r = (r)list;
                final int b = WireFormat.b(this.f);
                if (b == 0) {
                    int c;
                    do {
                        r.g(this.r());
                        if (this.Q()) {
                            return;
                        }
                        c = this.c;
                    } while (this.a0() == this.f);
                    this.c = c;
                    return;
                }
                if (b != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                final int n = this.c + this.a0();
                while (this.c < n) {
                    r.g(this.b0());
                }
                this.e0(n);
            }
            else {
                final int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    int c2;
                    do {
                        list.add(this.r());
                        if (this.Q()) {
                            return;
                        }
                        c2 = this.c;
                    } while (this.a0() == this.f);
                    this.c = c2;
                    return;
                }
                if (b2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                final int n2 = this.c + this.a0();
                while (this.c < n2) {
                    list.add(this.b0());
                }
                this.e0(n2);
            }
        }
        
        @Override
        public int g() throws IOException {
            this.f0(0);
            return this.a0();
        }
        
        @Override
        public int getTag() {
            return this.f;
        }
        
        @Override
        public void h(final List<Long> list) throws IOException {
            if (list instanceof r) {
                final r r = (r)list;
                final int b = WireFormat.b(this.f);
                if (b == 0) {
                    int c;
                    do {
                        r.g(this.G());
                        if (this.Q()) {
                            return;
                        }
                        c = this.c;
                    } while (this.a0() == this.f);
                    this.c = c;
                    return;
                }
                if (b != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                final int n = this.c + this.a0();
                while (this.c < n) {
                    r.g(this.b0());
                }
                this.e0(n);
            }
            else {
                final int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    int c2;
                    do {
                        list.add(this.G());
                        if (this.Q()) {
                            return;
                        }
                        c2 = this.c;
                    } while (this.a0() == this.f);
                    this.c = c2;
                    return;
                }
                if (b2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                final int n2 = this.c + this.a0();
                while (this.c < n2) {
                    list.add(this.b0());
                }
                this.e0(n2);
            }
        }
        
        @Override
        public void i(final List<Integer> list) throws IOException {
            if (list instanceof p) {
                final p p = (p)list;
                final int b = WireFormat.b(this.f);
                if (b == 0) {
                    int c;
                    do {
                        p.N0(this.j());
                        if (this.Q()) {
                            return;
                        }
                        c = this.c;
                    } while (this.a0() == this.f);
                    this.c = c;
                    return;
                }
                if (b != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                while (this.c < this.c + this.a0()) {
                    p.N0(this.a0());
                }
            }
            else {
                final int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    int c2;
                    do {
                        list.add(this.j());
                        if (this.Q()) {
                            return;
                        }
                        c2 = this.c;
                    } while (this.a0() == this.f);
                    this.c = c2;
                    return;
                }
                if (b2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                while (this.c < this.c + this.a0()) {
                    list.add(this.a0());
                }
            }
        }
        
        @Override
        public int j() throws IOException {
            this.f0(0);
            return this.a0();
        }
        
        @Override
        public int k() throws IOException {
            this.f0(0);
            return CodedInputStream.b(this.a0());
        }
        
        @Override
        public void l(final List<Boolean> list) throws IOException {
            if (list instanceof e) {
                final e e = (e)list;
                final int b = WireFormat.b(this.f);
                if (b == 0) {
                    int c;
                    do {
                        e.g(this.d());
                        if (this.Q()) {
                            return;
                        }
                        c = this.c;
                    } while (this.a0() == this.f);
                    this.c = c;
                    return;
                }
                if (b != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                final int n = this.c + this.a0();
                while (this.c < n) {
                    e.g(this.a0() != 0);
                }
                this.e0(n);
            }
            else {
                final int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    int c2;
                    do {
                        list.add(this.d());
                        if (this.Q()) {
                            return;
                        }
                        c2 = this.c;
                    } while (this.a0() == this.f);
                    this.c = c2;
                    return;
                }
                if (b2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                final int n2 = this.c + this.a0();
                while (this.c < n2) {
                    list.add(this.a0() != 0);
                }
                this.e0(n2);
            }
        }
        
        @Override
        public void m(final List<String> list) throws IOException {
            this.Z(list, true);
        }
        
        @Override
        public ByteString n() throws IOException {
            this.f0(2);
            final int a0 = this.a0();
            if (a0 == 0) {
                return ByteString.EMPTY;
            }
            this.d0(a0);
            ByteString byteString;
            if (this.a) {
                byteString = ByteString.wrap(this.b, this.c, a0);
            }
            else {
                byteString = ByteString.copyFrom(this.b, this.c, a0);
            }
            this.c += a0;
            return byteString;
        }
        
        @Override
        public int o() throws IOException {
            this.f0(0);
            return this.a0();
        }
        
        @Override
        public void p(final List<Long> list) throws IOException {
            if (list instanceof r) {
                final r r = (r)list;
                final int b = WireFormat.b(this.f);
                if (b == 1) {
                    int c;
                    do {
                        r.g(this.a());
                        if (this.Q()) {
                            return;
                        }
                        c = this.c;
                    } while (this.a0() == this.f);
                    this.c = c;
                    return;
                }
                if (b != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                final int a0 = this.a0();
                this.l0(a0);
                while (this.c < this.c + a0) {
                    r.g(this.W());
                }
            }
            else {
                final int b2 = WireFormat.b(this.f);
                if (b2 == 1) {
                    int c2;
                    do {
                        list.add(this.a());
                        if (this.Q()) {
                            return;
                        }
                        c2 = this.c;
                    } while (this.a0() == this.f);
                    this.c = c2;
                    return;
                }
                if (b2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                final int a2 = this.a0();
                this.l0(a2);
                while (this.c < this.c + a2) {
                    list.add(this.W());
                }
            }
        }
        
        @Override
        public void q(final List<Integer> list) throws IOException {
            if (list instanceof p) {
                final p p = (p)list;
                final int b = WireFormat.b(this.f);
                if (b == 0) {
                    int c;
                    do {
                        p.N0(this.k());
                        if (this.Q()) {
                            return;
                        }
                        c = this.c;
                    } while (this.a0() == this.f);
                    this.c = c;
                    return;
                }
                if (b != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                while (this.c < this.c + this.a0()) {
                    p.N0(CodedInputStream.b(this.a0()));
                }
            }
            else {
                final int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    int c2;
                    do {
                        list.add(this.k());
                        if (this.Q()) {
                            return;
                        }
                        c2 = this.c;
                    } while (this.a0() == this.f);
                    this.c = c2;
                    return;
                }
                if (b2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                while (this.c < this.c + this.a0()) {
                    list.add(CodedInputStream.b(this.a0()));
                }
            }
        }
        
        @Override
        public long r() throws IOException {
            this.f0(0);
            return this.b0();
        }
        
        @Override
        public double readDouble() throws IOException {
            this.f0(1);
            return Double.longBitsToDouble(this.V());
        }
        
        @Override
        public float readFloat() throws IOException {
            this.f0(5);
            return Float.intBitsToFloat(this.T());
        }
        
        @Override
        public void s(final List<Integer> list) throws IOException {
            if (list instanceof p) {
                final p p = (p)list;
                final int b = WireFormat.b(this.f);
                if (b == 0) {
                    int c;
                    do {
                        p.N0(this.g());
                        if (this.Q()) {
                            return;
                        }
                        c = this.c;
                    } while (this.a0() == this.f);
                    this.c = c;
                    return;
                }
                if (b != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                while (this.c < this.c + this.a0()) {
                    p.N0(this.a0());
                }
            }
            else {
                final int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    int c2;
                    do {
                        list.add(this.g());
                        if (this.Q()) {
                            return;
                        }
                        c2 = this.c;
                    } while (this.a0() == this.f);
                    this.c = c2;
                    return;
                }
                if (b2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                while (this.c < this.c + this.a0()) {
                    list.add(this.a0());
                }
            }
        }
        
        @Override
        public int t() throws IOException {
            this.f0(5);
            return this.T();
        }
        
        @Override
        public void u(final List<Long> list) throws IOException {
            if (list instanceof r) {
                final r r = (r)list;
                final int b = WireFormat.b(this.f);
                if (b == 1) {
                    int c;
                    do {
                        r.g(this.e());
                        if (this.Q()) {
                            return;
                        }
                        c = this.c;
                    } while (this.a0() == this.f);
                    this.c = c;
                    return;
                }
                if (b != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                final int a0 = this.a0();
                this.l0(a0);
                while (this.c < this.c + a0) {
                    r.g(this.W());
                }
            }
            else {
                final int b2 = WireFormat.b(this.f);
                if (b2 == 1) {
                    int c2;
                    do {
                        list.add(this.e());
                        if (this.Q()) {
                            return;
                        }
                        c2 = this.c;
                    } while (this.a0() == this.f);
                    this.c = c2;
                    return;
                }
                if (b2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                final int a2 = this.a0();
                this.l0(a2);
                while (this.c < this.c + a2) {
                    list.add(this.W());
                }
            }
        }
        
        @Override
        public void v(final List<Integer> list) throws IOException {
            if (list instanceof p) {
                final p p = (p)list;
                final int b = WireFormat.b(this.f);
                if (b == 0) {
                    int c;
                    do {
                        p.N0(this.o());
                        if (this.Q()) {
                            return;
                        }
                        c = this.c;
                    } while (this.a0() == this.f);
                    this.c = c;
                    return;
                }
                if (b != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                final int n = this.c + this.a0();
                while (this.c < n) {
                    p.N0(this.a0());
                }
                this.e0(n);
            }
            else {
                final int b2 = WireFormat.b(this.f);
                if (b2 == 0) {
                    int c2;
                    do {
                        list.add(this.o());
                        if (this.Q()) {
                            return;
                        }
                        c2 = this.c;
                    } while (this.a0() == this.f);
                    this.c = c2;
                    return;
                }
                if (b2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                final int n2 = this.c + this.a0();
                while (this.c < n2) {
                    list.add(this.a0());
                }
                this.e0(n2);
            }
        }
        
        @Override
        public void w(final List<Integer> list) throws IOException {
            if (list instanceof p) {
                final p p = (p)list;
                final int b = WireFormat.b(this.f);
                if (b != 2) {
                    if (b == 5) {
                        int c;
                        do {
                            p.N0(this.t());
                            if (this.Q()) {
                                return;
                            }
                            c = this.c;
                        } while (this.a0() == this.f);
                        this.c = c;
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                else {
                    final int a0 = this.a0();
                    this.k0(a0);
                    while (this.c < this.c + a0) {
                        p.N0(this.U());
                    }
                }
            }
            else {
                final int b2 = WireFormat.b(this.f);
                if (b2 != 2) {
                    if (b2 == 5) {
                        int c2;
                        do {
                            list.add(this.t());
                            if (this.Q()) {
                                return;
                            }
                            c2 = this.c;
                        } while (this.a0() == this.f);
                        this.c = c2;
                        return;
                    }
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                else {
                    final int a2 = this.a0();
                    this.k0(a2);
                    while (this.c < this.c + a2) {
                        list.add(this.U());
                    }
                }
            }
        }
        
        @Override
        public long x() throws IOException {
            this.f0(0);
            return CodedInputStream.c(this.b0());
        }
        
        @Override
        public String y() throws IOException {
            return this.Y(false);
        }
        
        @Override
        public int z() throws IOException {
            if (this.Q()) {
                return Integer.MAX_VALUE;
            }
            final int a0 = this.a0();
            if ((this.f = a0) == this.g) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.a(a0);
        }
    }
}
