// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class p extends a<Integer> implements IntList, RandomAccess, e0
{
    private static final p d;
    private int[] b;
    private int c;
    
    static {
        (d = new p(new int[0], 0)).i();
    }
    
    p() {
        this(new int[10], 0);
    }
    
    private p(final int[] b, final int c) {
        this.b = b;
        this.c = c;
    }
    
    private void f(final int n, final int n2) {
        this.a();
        if (n >= 0) {
            final int c = this.c;
            if (n <= c) {
                final int[] b = this.b;
                if (c < b.length) {
                    System.arraycopy(b, n, b, n + 1, c - n);
                }
                else {
                    final int[] b2 = new int[c * 3 / 2 + 1];
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
        throw new IndexOutOfBoundsException(this.m(n));
    }
    
    private void g(final int n) {
        if (n >= 0 && n < this.c) {
            return;
        }
        throw new IndexOutOfBoundsException(this.m(n));
    }
    
    private String m(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Index:");
        sb.append(n);
        sb.append(", Size:");
        sb.append(this.c);
        return sb.toString();
    }
    
    public void N0(final int n) {
        this.a();
        final int c = this.c;
        final int[] b = this.b;
        if (c == b.length) {
            final int[] b2 = new int[c * 3 / 2 + 1];
            System.arraycopy(b, 0, b2, 0, c);
            this.b = b2;
        }
        this.b[this.c++] = n;
    }
    
    @Override
    public /* bridge */ void add(final int n, final Object o) {
        this.b(n, (Integer)o);
    }
    
    @Override
    public /* bridge */ boolean add(final Object o) {
        return this.e((Integer)o);
    }
    
    @Override
    public boolean addAll(final Collection<? extends Integer> collection) {
        this.a();
        Internal.a(collection);
        if (!(collection instanceof p)) {
            return super.addAll(collection);
        }
        final p p = (p)collection;
        final int c = p.c;
        if (c == 0) {
            return false;
        }
        final int c2 = this.c;
        if (Integer.MAX_VALUE - c2 >= c) {
            final int c3 = c2 + c;
            final int[] b = this.b;
            if (c3 > b.length) {
                this.b = Arrays.copyOf(b, c3);
            }
            System.arraycopy(p.b, 0, this.b, this.c, p.c);
            this.c = c3;
            ++super.modCount;
            return true;
        }
        throw new OutOfMemoryError();
    }
    
    public void b(final int n, final Integer n2) {
        this.f(n, n2);
    }
    
    @Override
    public /* bridge */ ProtobufList d(final int n) {
        return this.n(n);
    }
    
    public boolean e(final Integer n) {
        this.N0(n);
        return true;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof p)) {
            return super.equals(o);
        }
        final p p = (p)o;
        if (this.c != p.c) {
            return false;
        }
        final int[] b = p.b;
        for (int i = 0; i < this.c; ++i) {
            if (this.b[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public /* bridge */ Object get(final int n) {
        return this.k(n);
    }
    
    public int getInt(final int n) {
        this.g(n);
        return this.b[n];
    }
    
    @Override
    public int hashCode() {
        int n = 1;
        for (int i = 0; i < this.c; ++i) {
            n = n * 31 + this.b[i];
        }
        return n;
    }
    
    public Integer k(final int n) {
        return this.getInt(n);
    }
    
    public IntList n(final int n) {
        if (n >= this.c) {
            return new p(Arrays.copyOf(this.b, n), this.c);
        }
        throw new IllegalArgumentException();
    }
    
    public Integer o(final int n) {
        this.a();
        this.g(n);
        final int[] b = this.b;
        final int n2 = b[n];
        final int c = this.c;
        if (n < c - 1) {
            System.arraycopy(b, n + 1, b, n, c - n - 1);
        }
        --this.c;
        ++super.modCount;
        return n2;
    }
    
    public Integer p(final int n, final Integer n2) {
        return this.q(n, n2);
    }
    
    public int q(final int n, final int n2) {
        this.a();
        this.g(n);
        final int[] b = this.b;
        final int n3 = b[n];
        b[n] = n2;
        return n3;
    }
    
    @Override
    public /* bridge */ Object remove(final int n) {
        return this.o(n);
    }
    
    @Override
    public boolean remove(final Object o) {
        this.a();
        for (int i = 0; i < this.c; ++i) {
            if (o.equals(this.b[i])) {
                final int[] b = this.b;
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
            final int[] b = this.b;
            System.arraycopy(b, n2, b, n, this.c - n2);
            this.c -= n2 - n;
            ++super.modCount;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }
    
    @Override
    public /* bridge */ Object set(final int n, final Object o) {
        return this.p(n, (Integer)o);
    }
    
    @Override
    public int size() {
        return this.c;
    }
}
