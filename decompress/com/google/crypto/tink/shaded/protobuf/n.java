// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class n extends a<Float> implements FloatList, RandomAccess, e0
{
    private static final n d;
    private float[] b;
    private int c;
    
    static {
        (d = new n(new float[0], 0)).i();
    }
    
    n() {
        this(new float[10], 0);
    }
    
    private n(final float[] b, final int c) {
        this.b = b;
        this.c = c;
    }
    
    private void g(final int n, final float n2) {
        this.a();
        if (n >= 0) {
            final int c = this.c;
            if (n <= c) {
                final float[] b = this.b;
                if (c < b.length) {
                    System.arraycopy(b, n, b, n + 1, c - n);
                }
                else {
                    final float[] b2 = new float[c * 3 / 2 + 1];
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
        this.b(n, (Float)o);
    }
    
    @Override
    public /* bridge */ boolean add(final Object o) {
        return this.e((Float)o);
    }
    
    @Override
    public boolean addAll(final Collection<? extends Float> collection) {
        this.a();
        Internal.a(collection);
        if (!(collection instanceof n)) {
            return super.addAll(collection);
        }
        final n n = (n)collection;
        final int c = n.c;
        if (c == 0) {
            return false;
        }
        final int c2 = this.c;
        if (Integer.MAX_VALUE - c2 >= c) {
            final int c3 = c2 + c;
            final float[] b = this.b;
            if (c3 > b.length) {
                this.b = Arrays.copyOf(b, c3);
            }
            System.arraycopy(n.b, 0, this.b, this.c, n.c);
            this.c = c3;
            ++super.modCount;
            return true;
        }
        throw new OutOfMemoryError();
    }
    
    public void b(final int n, final Float n2) {
        this.g(n, n2);
    }
    
    @Override
    public /* bridge */ ProtobufList d(final int n) {
        return this.p(n);
    }
    
    public boolean e(final Float n) {
        this.f(n);
        return true;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof n)) {
            return super.equals(o);
        }
        final n n = (n)o;
        if (this.c != n.c) {
            return false;
        }
        final float[] b = n.b;
        for (int i = 0; i < this.c; ++i) {
            if (Float.floatToIntBits(this.b[i]) != Float.floatToIntBits(b[i])) {
                return false;
            }
        }
        return true;
    }
    
    public void f(final float n) {
        this.a();
        final int c = this.c;
        final float[] b = this.b;
        if (c == b.length) {
            final float[] b2 = new float[c * 3 / 2 + 1];
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
            n = n * 31 + Float.floatToIntBits(this.b[i]);
        }
        return n;
    }
    
    public Float m(final int n) {
        return this.n(n);
    }
    
    public float n(final int n) {
        this.k(n);
        return this.b[n];
    }
    
    public FloatList p(final int n) {
        if (n >= this.c) {
            return new n(Arrays.copyOf(this.b, n), this.c);
        }
        throw new IllegalArgumentException();
    }
    
    public Float q(final int n) {
        this.a();
        this.k(n);
        final float[] b = this.b;
        final float n2 = b[n];
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
                final float[] b = this.b;
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
            final float[] b = this.b;
            System.arraycopy(b, n2, b, n, this.c - n2);
            this.c -= n2 - n;
            ++super.modCount;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }
    
    public Float s(final int n, final Float n2) {
        return this.t(n, n2);
    }
    
    @Override
    public /* bridge */ Object set(final int n, final Object o) {
        return this.s(n, (Float)o);
    }
    
    @Override
    public int size() {
        return this.c;
    }
    
    public float t(final int n, final float n2) {
        this.a();
        this.k(n);
        final float[] b = this.b;
        final float n3 = b[n];
        b[n] = n2;
        return n3;
    }
}
