// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

final class g0<E> extends a<E> implements RandomAccess
{
    private static final g0<Object> d;
    private E[] b;
    private int c;
    
    static {
        (d = new g0<Object>(new Object[0], 0)).i();
    }
    
    private g0(final E[] b, final int c) {
        this.b = b;
        this.c = c;
    }
    
    private static <E> E[] b(final int n) {
        return (E[])new Object[n];
    }
    
    public static <E> g0<E> e() {
        return (g0<E>)g0.d;
    }
    
    private void f(final int n) {
        if (n >= 0 && n < this.c) {
            return;
        }
        throw new IndexOutOfBoundsException(this.g(n));
    }
    
    private String g(final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Index:");
        sb.append(n);
        sb.append(", Size:");
        sb.append(this.c);
        return sb.toString();
    }
    
    @Override
    public void add(final int n, final E e) {
        this.a();
        if (n >= 0) {
            final int c = this.c;
            if (n <= c) {
                final E[] b = this.b;
                if (c < b.length) {
                    System.arraycopy(b, n, b, n + 1, c - n);
                }
                else {
                    final Object[] b2 = b(c * 3 / 2 + 1);
                    System.arraycopy(this.b, 0, b2, 0, n);
                    System.arraycopy(this.b, n, b2, n + 1, this.c - n);
                    this.b = (E[])b2;
                }
                this.b[n] = e;
                ++this.c;
                ++super.modCount;
                return;
            }
        }
        throw new IndexOutOfBoundsException(this.g(n));
    }
    
    @Override
    public boolean add(final E e) {
        this.a();
        final int c = this.c;
        final E[] b = this.b;
        if (c == b.length) {
            this.b = Arrays.copyOf(b, c * 3 / 2 + 1);
        }
        this.b[this.c++] = e;
        ++super.modCount;
        return true;
    }
    
    @Override
    public /* bridge */ ProtobufList d(final int n) {
        return this.k(n);
    }
    
    @Override
    public E get(final int n) {
        this.f(n);
        return this.b[n];
    }
    
    public g0<E> k(final int n) {
        if (n >= this.c) {
            return new g0<E>(Arrays.copyOf(this.b, n), this.c);
        }
        throw new IllegalArgumentException();
    }
    
    @Override
    public E remove(final int n) {
        this.a();
        this.f(n);
        final E[] b = this.b;
        final E e = b[n];
        final int c = this.c;
        if (n < c - 1) {
            System.arraycopy(b, n + 1, b, n, c - n - 1);
        }
        --this.c;
        ++super.modCount;
        return e;
    }
    
    @Override
    public E set(final int n, final E e) {
        this.a();
        this.f(n);
        final E[] b = this.b;
        final E e2 = b[n];
        b[n] = e;
        ++super.modCount;
        return e2;
    }
    
    @Override
    public int size() {
        return this.c;
    }
}
