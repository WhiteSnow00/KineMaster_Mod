// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;
import java.util.Arrays;

public final class UnknownFieldSetLite
{
    private static final UnknownFieldSetLite f;
    private int a;
    private int[] b;
    private Object[] c;
    private int d;
    private boolean e;
    
    static {
        f = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    }
    
    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }
    
    private UnknownFieldSetLite(final int a, final int[] b, final Object[] c, final boolean e) {
        this.d = -1;
        this.a = a;
        this.b = b;
        this.c = c;
        this.e = e;
    }
    
    private void b() {
        final int a = this.a;
        final int[] b = this.b;
        if (a == b.length) {
            int n;
            if (a < 4) {
                n = 8;
            }
            else {
                n = a >> 1;
            }
            final int n2 = a + n;
            this.b = Arrays.copyOf(b, n2);
            this.c = Arrays.copyOf(this.c, n2);
        }
    }
    
    private static boolean c(final int[] array, final int[] array2, final int n) {
        for (int i = 0; i < n; ++i) {
            if (array[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
    
    private static boolean d(final Object[] array, final Object[] array2, final int n) {
        for (int i = 0; i < n; ++i) {
            if (!array[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }
    
    public static UnknownFieldSetLite e() {
        return UnknownFieldSetLite.f;
    }
    
    private static int h(final int[] array, final int n) {
        int n2 = 17;
        for (int i = 0; i < n; ++i) {
            n2 = n2 * 31 + array[i];
        }
        return n2;
    }
    
    private static int i(final Object[] array, final int n) {
        int n2 = 17;
        for (int i = 0; i < n; ++i) {
            n2 = n2 * 31 + array[i].hashCode();
        }
        return n2;
    }
    
    static UnknownFieldSetLite k(final UnknownFieldSetLite unknownFieldSetLite, final UnknownFieldSetLite unknownFieldSetLite2) {
        final int n = unknownFieldSetLite.a + unknownFieldSetLite2.a;
        final int[] copy = Arrays.copyOf(unknownFieldSetLite.b, n);
        System.arraycopy(unknownFieldSetLite2.b, 0, copy, unknownFieldSetLite.a, unknownFieldSetLite2.a);
        final Object[] copy2 = Arrays.copyOf(unknownFieldSetLite.c, n);
        System.arraycopy(unknownFieldSetLite2.c, 0, copy2, unknownFieldSetLite.a, unknownFieldSetLite2.a);
        return new UnknownFieldSetLite(n, copy, copy2, true);
    }
    
    static UnknownFieldSetLite l() {
        return new UnknownFieldSetLite();
    }
    
    private static void p(int b, final Object o, final Writer writer) throws IOException {
        final int a = WireFormat.a(b);
        b = WireFormat.b(b);
        if (b != 0) {
            if (b != 1) {
                if (b != 2) {
                    if (b != 3) {
                        if (b != 5) {
                            throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
                        }
                        writer.c(a, (int)o);
                    }
                    else if (writer.t() == Writer.FieldOrder.ASCENDING) {
                        writer.x(a);
                        ((UnknownFieldSetLite)o).q(writer);
                        writer.C(a);
                    }
                    else {
                        writer.C(a);
                        ((UnknownFieldSetLite)o).q(writer);
                        writer.x(a);
                    }
                }
                else {
                    writer.M(a, (ByteString)o);
                }
            }
            else {
                writer.s(a, (long)o);
            }
        }
        else {
            writer.u(a, (long)o);
        }
    }
    
    void a() {
        if (this.e) {
            return;
        }
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof UnknownFieldSetLite)) {
            return false;
        }
        final UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite)o;
        final int a = this.a;
        return a == unknownFieldSetLite.a && c(this.b, unknownFieldSetLite.b, a) && d(this.c, unknownFieldSetLite.c, this.a);
    }
    
    public int f() {
        final int d = this.d;
        if (d != -1) {
            return d;
        }
        int i = 0;
        int d2 = 0;
        while (i < this.a) {
            final int n = this.b[i];
            final int a = WireFormat.a(n);
            final int b = WireFormat.b(n);
            int n2;
            if (b != 0) {
                if (b != 1) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 5) {
                                throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
                            }
                            n2 = CodedOutputStream.n(a, (int)this.c[i]);
                        }
                        else {
                            n2 = CodedOutputStream.W(a) * 2 + ((UnknownFieldSetLite)this.c[i]).f();
                        }
                    }
                    else {
                        n2 = CodedOutputStream.h(a, (ByteString)this.c[i]);
                    }
                }
                else {
                    n2 = CodedOutputStream.p(a, (long)this.c[i]);
                }
            }
            else {
                n2 = CodedOutputStream.Z(a, (long)this.c[i]);
            }
            d2 += n2;
            ++i;
        }
        return this.d = d2;
    }
    
    public int g() {
        final int d = this.d;
        if (d != -1) {
            return d;
        }
        int i = 0;
        int d2 = 0;
        while (i < this.a) {
            d2 += CodedOutputStream.K(WireFormat.a(this.b[i]), (ByteString)this.c[i]);
            ++i;
        }
        return this.d = d2;
    }
    
    @Override
    public int hashCode() {
        final int a = this.a;
        return ((527 + a) * 31 + h(this.b, a)) * 31 + i(this.c, this.a);
    }
    
    public void j() {
        this.e = false;
    }
    
    final void m(final StringBuilder sb, final int n) {
        for (int i = 0; i < this.a; ++i) {
            y.c(sb, n, String.valueOf(WireFormat.a(this.b[i])), this.c[i]);
        }
    }
    
    void n(final int n, final Object o) {
        this.a();
        this.b();
        final int[] b = this.b;
        final int a = this.a;
        b[a] = n;
        this.c[a] = o;
        this.a = a + 1;
    }
    
    void o(final Writer writer) throws IOException {
        if (writer.t() == Writer.FieldOrder.DESCENDING) {
            for (int i = this.a - 1; i >= 0; --i) {
                writer.b(WireFormat.a(this.b[i]), this.c[i]);
            }
        }
        else {
            for (int j = 0; j < this.a; ++j) {
                writer.b(WireFormat.a(this.b[j]), this.c[j]);
            }
        }
    }
    
    public void q(final Writer writer) throws IOException {
        if (this.a == 0) {
            return;
        }
        if (writer.t() == Writer.FieldOrder.ASCENDING) {
            for (int i = 0; i < this.a; ++i) {
                p(this.b[i], this.c[i], writer);
            }
        }
        else {
            for (int j = this.a - 1; j >= 0; --j) {
                p(this.b[j], this.c[j], writer);
            }
        }
    }
}
