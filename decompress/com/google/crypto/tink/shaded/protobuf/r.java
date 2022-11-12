// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class r extends a<Long> implements LongList, RandomAccess, e0
{
    private static final r d;
    private long[] b;
    private int c;
    
    static {
        (d = new r(new long[0], 0)).i();
    }
    
    r() {
        this(new long[10], 0);
    }
    
    private r(final long[] b, final int c) {
        this.b = b;
        this.c = c;
    }
    
    private void f(final int n, final long n2) {
        this.a();
        if (n >= 0) {
            final int c = this.c;
            if (n <= c) {
                final long[] b = this.b;
                if (c < b.length) {
                    System.arraycopy(b, n, b, n + 1, c - n);
                }
                else {
                    final long[] b2 = new long[c * 3 / 2 + 1];
                    System.arraycopy(b, 0, b2, 0, n);
                    System.arraycopy(this.b, n, b2, n + 1, this.c - n);
                    this.b = b2;
                }
                this.b[n] = n2;
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
        this.b(n, (Long)o);
    }
    
    @Override
    public /* bridge */ boolean add(final Object o) {
        return this.e((Long)o);
    }
    
    @Override
    public boolean addAll(final Collection<? extends Long> collection) {
        this.a();
        Internal.a(collection);
        if (!(collection instanceof r)) {
            return super.addAll(collection);
        }
        final r r = (r)collection;
        final int c = r.c;
        if (c == 0) {
            return false;
        }
        final int c2 = this.c;
        if (Integer.MAX_VALUE - c2 >= c) {
            final int c3 = c2 + c;
            final long[] b = this.b;
            if (c3 > b.length) {
                this.b = Arrays.copyOf(b, c3);
            }
            System.arraycopy(r.b, 0, this.b, this.c, r.c);
            this.c = c3;
            ++super.modCount;
            return true;
        }
        throw new OutOfMemoryError();
    }
    
    public void b(final int n, final Long n2) {
        this.f(n, n2);
    }
    
    @Override
    public /* bridge */ ProtobufList d(final int n) {
        return this.p(n);
    }
    
    public boolean e(final Long n) {
        this.g(n);
        return true;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof r)) {
            return super.equals(o);
        }
        final r r = (r)o;
        if (this.c != r.c) {
            return false;
        }
        final long[] b = r.b;
        for (int i = 0; i < this.c; ++i) {
            if (this.b[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    
    public void g(final long n) {
        this.a();
        final int c = this.c;
        final long[] b = this.b;
        if (c == b.length) {
            final long[] b2 = new long[c * 3 / 2 + 1];
            System.arraycopy(b, 0, b2, 0, c);
            this.b = b2;
        }
        this.b[this.c++] = n;
    }
    
    @Override
    public /* bridge */ Object get(final int n) {
        return this.m(n);
    }
    
    @Override
    public int hashCode() {
        int n = 1;
        for (int i = 0; i < this.c; ++i) {
            n = n * 31 + Internal.f(this.b[i]);
        }
        return n;
    }
    
    public Long m(final int n) {
        return this.n(n);
    }
    
    public long n(final int n) {
        this.k(n);
        return this.b[n];
    }
    
    public LongList p(final int n) {
        if (n >= this.c) {
            return new r(Arrays.copyOf(this.b, n), this.c);
        }
        throw new IllegalArgumentException();
    }
    
    public Long q(final int n) {
        this.a();
        this.k(n);
        final long[] b = this.b;
        final long n2 = b[n];
        final int c = this.c;
        if (n < c - 1) {
            System.arraycopy(b, n + 1, b, n, c - n - 1);
        }
        --this.c;
        ++super.modCount;
        return n2;
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
                final long[] b = this.b;
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
            final long[] b = this.b;
            System.arraycopy(b, n2, b, n, this.c - n2);
            this.c -= n2 - n;
            ++super.modCount;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }
    
    public Long s(final int n, final Long n2) {
        return this.t(n, n2);
    }
    
    @Override
    public /* bridge */ Object set(final int n, final Object o) {
        return this.s(n, (Long)o);
    }
    
    @Override
    public int size() {
        return this.c;
    }
    
    public long t(final int n, final long n2) {
        this.a();
        this.k(n);
        final long[] b = this.b;
        final long n3 = b[n];
        b[n] = n2;
        return n3;
    }
}
