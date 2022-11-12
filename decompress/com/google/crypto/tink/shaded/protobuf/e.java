// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class e extends a<Boolean> implements BooleanList, RandomAccess, e0
{
    private static final e d;
    private boolean[] b;
    private int c;
    
    static {
        (d = new e(new boolean[0], 0)).i();
    }
    
    e() {
        this(new boolean[10], 0);
    }
    
    private e(final boolean[] b, final int c) {
        this.b = b;
        this.c = c;
    }
    
    private void f(final int n, final boolean b) {
        this.a();
        if (n >= 0) {
            final int c = this.c;
            if (n <= c) {
                final boolean[] b2 = this.b;
                if (c < b2.length) {
                    System.arraycopy(b2, n, b2, n + 1, c - n);
                }
                else {
                    final boolean[] b3 = new boolean[c * 3 / 2 + 1];
                    System.arraycopy(b2, 0, b3, 0, n);
                    System.arraycopy(this.b, n, b3, n + 1, this.c - n);
                    this.b = b3;
                }
                this.b[n] = b;
                ++this.c;
                ++super.modCount;
                return;
            }
        }
        throw new IndexOutOfBoundsException(this.o(n));
    }
    
    private void k(final int n) {
        if (n >= 0 && n < this.c) {
            return;
        }
        throw new IndexOutOfBoundsException(this.o(n));
    }
    
    private String o(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Index:");
        sb.append(n);
        sb.append(", Size:");
        sb.append(this.c);
        return sb.toString();
    }
    
    @Override
    public /* bridge */ void add(final int n, final Object o) {
        this.b(n, (Boolean)o);
    }
    
    @Override
    public /* bridge */ boolean add(final Object o) {
        return this.e((Boolean)o);
    }
    
    @Override
    public boolean addAll(final Collection<? extends Boolean> collection) {
        this.a();
        Internal.a(collection);
        if (!(collection instanceof e)) {
            return super.addAll(collection);
        }
        final e e = (e)collection;
        final int c = e.c;
        if (c == 0) {
            return false;
        }
        final int c2 = this.c;
        if (Integer.MAX_VALUE - c2 >= c) {
            final int c3 = c2 + c;
            final boolean[] b = this.b;
            if (c3 > b.length) {
                this.b = Arrays.copyOf(b, c3);
            }
            System.arraycopy(e.b, 0, this.b, this.c, e.c);
            this.c = c3;
            ++super.modCount;
            return true;
        }
        throw new OutOfMemoryError();
    }
    
    public void b(final int n, final Boolean b) {
        this.f(n, b);
    }
    
    @Override
    public /* bridge */ ProtobufList d(final int n) {
        return this.p(n);
    }
    
    public boolean e(final Boolean b) {
        this.g(b);
        return true;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof e)) {
            return super.equals(o);
        }
        final e e = (e)o;
        if (this.c != e.c) {
            return false;
        }
        final boolean[] b = e.b;
        for (int i = 0; i < this.c; ++i) {
            if (this.b[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    
    public void g(final boolean b) {
        this.a();
        final int c = this.c;
        final boolean[] b2 = this.b;
        if (c == b2.length) {
            final boolean[] b3 = new boolean[c * 3 / 2 + 1];
            System.arraycopy(b2, 0, b3, 0, c);
            this.b = b3;
        }
        this.b[this.c++] = b;
    }
    
    @Override
    public /* bridge */ Object get(final int n) {
        return this.m(n);
    }
    
    @Override
    public int hashCode() {
        int n = 1;
        for (int i = 0; i < this.c; ++i) {
            n = n * 31 + Internal.c(this.b[i]);
        }
        return n;
    }
    
    public Boolean m(final int n) {
        return this.n(n);
    }
    
    public boolean n(final int n) {
        this.k(n);
        return this.b[n];
    }
    
    public BooleanList p(final int n) {
        if (n >= this.c) {
            return new e(Arrays.copyOf(this.b, n), this.c);
        }
        throw new IllegalArgumentException();
    }
    
    public Boolean q(final int n) {
        this.a();
        this.k(n);
        final boolean[] b = this.b;
        final boolean b2 = b[n];
        final int c = this.c;
        if (n < c - 1) {
            System.arraycopy(b, n + 1, b, n, c - n - 1);
        }
        --this.c;
        ++super.modCount;
        return b2;
    }
    
    @Override
    public /* bridge */ Object remove(final int n) {
        return this.q(n);
    }
    
    @Override
    public boolean remove(final Object o) {
        this.a();
        for (int i = 0; i < this.c; ++i) {
            if (o.equals(this.b[i])) {
                final boolean[] b = this.b;
                System.arraycopy(b, i + 1, b, i, this.c - i - 1);
                --this.c;
                ++super.modCount;
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected void removeRange(final int n, final int n2) {
        this.a();
        if (n2 >= n) {
            final boolean[] b = this.b;
            System.arraycopy(b, n2, b, n, this.c - n2);
            this.c -= n2 - n;
            ++super.modCount;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }
    
    public Boolean s(final int n, final Boolean b) {
        return this.t(n, b);
    }
    
    @Override
    public /* bridge */ Object set(final int n, final Object o) {
        return this.s(n, (Boolean)o);
    }
    
    @Override
    public int size() {
        return this.c;
    }
    
    public boolean t(final int n, final boolean b) {
        this.a();
        this.k(n);
        final boolean[] b2 = this.b;
        final boolean b3 = b2[n];
        b2[n] = b;
        return b3;
    }
}
