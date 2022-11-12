// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.RandomAccess;
import java.util.List;
import java.util.Collection;
import java.util.AbstractList;

abstract class a<E> extends AbstractList<E> implements ProtobufList<E>
{
    private boolean a;
    
    a() {
        this.a = true;
    }
    
    protected void a() {
        if (this.a) {
            return;
        }
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void add(final int n, final E e) {
        this.a();
        super.add(n, e);
    }
    
    @Override
    public boolean add(final E e) {
        this.a();
        return super.add(e);
    }
    
    @Override
    public boolean addAll(final int n, final Collection<? extends E> collection) {
        this.a();
        return super.addAll(n, collection);
    }
    
    @Override
    public boolean addAll(final Collection<? extends E> collection) {
        this.a();
        return super.addAll(collection);
    }
    
    @Override
    public void clear() {
        this.a();
        super.clear();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof List)) {
            return false;
        }
        if (!(o instanceof RandomAccess)) {
            return super.equals(o);
        }
        final List list = (List)o;
        final int size = this.size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; ++i) {
            if (!this.get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final int size = this.size();
        int n = 1;
        for (int i = 0; i < size; ++i) {
            n = n * 31 + this.get(i).hashCode();
        }
        return n;
    }
    
    @Override
    public final void i() {
        this.a = false;
    }
    
    @Override
    public boolean r() {
        return this.a;
    }
    
    @Override
    public E remove(final int n) {
        this.a();
        return super.remove(n);
    }
    
    @Override
    public boolean remove(final Object o) {
        this.a();
        return super.remove(o);
    }
    
    @Override
    public boolean removeAll(final Collection<?> collection) {
        this.a();
        return super.removeAll(collection);
    }
    
    @Override
    public boolean retainAll(final Collection<?> collection) {
        this.a();
        return super.retainAll(collection);
    }
    
    @Override
    public E set(final int n, final E e) {
        this.a();
        return super.set(n, e);
    }
}
