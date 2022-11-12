// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Collections;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends a<String> implements LazyStringList, RandomAccess
{
    private static final LazyStringArrayList c;
    public static final LazyStringList d;
    private final List<Object> b;
    
    static {
        final LazyStringArrayList list = new LazyStringArrayList();
        (c = list).i();
        d = list;
    }
    
    public LazyStringArrayList() {
        this(10);
    }
    
    public LazyStringArrayList(final int n) {
        this(new ArrayList<Object>(n));
    }
    
    private LazyStringArrayList(final ArrayList<Object> b) {
        this.b = b;
    }
    
    private static String e(final Object o) {
        if (o instanceof String) {
            return (String)o;
        }
        if (o instanceof ByteString) {
            return ((ByteString)o).toStringUtf8();
        }
        return Internal.j((byte[])o);
    }
    
    @Override
    public /* bridge */ void add(final int n, final Object o) {
        this.b(n, (String)o);
    }
    
    @Override
    public /* bridge */ boolean add(final Object o) {
        return super.add((String)o);
    }
    
    @Override
    public boolean addAll(final int n, final Collection<? extends String> collection) {
        this.a();
        List<?> c = (List<?>)collection;
        if (collection instanceof LazyStringList) {
            c = ((LazyStringList)collection).c();
        }
        final boolean addAll = this.b.addAll(n, c);
        ++super.modCount;
        return addAll;
    }
    
    @Override
    public boolean addAll(final Collection<? extends String> collection) {
        return this.addAll(this.size(), collection);
    }
    
    public void b(final int n, final String s) {
        this.a();
        this.b.add(n, s);
        ++super.modCount;
    }
    
    @Override
    public List<?> c() {
        return Collections.unmodifiableList((List<?>)this.b);
    }
    
    @Override
    public void clear() {
        this.a();
        this.b.clear();
        ++super.modCount;
    }
    
    @Override
    public /* bridge */ ProtobufList d(final int n) {
        return this.g(n);
    }
    
    @Override
    public /* bridge */ boolean equals(final Object o) {
        return super.equals(o);
    }
    
    public String f(final int n) {
        final byte[] value = this.b.get(n);
        if (value instanceof String) {
            return (String)(Object)value;
        }
        if (value instanceof ByteString) {
            final ByteString byteString = (Object)value;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.b.set(n, stringUtf8);
            }
            return stringUtf8;
        }
        final byte[] array = value;
        final String j = Internal.j(array);
        if (Internal.g(array)) {
            this.b.set(n, j);
        }
        return j;
    }
    
    public LazyStringArrayList g(final int n) {
        if (n >= this.size()) {
            final ArrayList list = new ArrayList(n);
            list.addAll(this.b);
            return new LazyStringArrayList(list);
        }
        throw new IllegalArgumentException();
    }
    
    @Override
    public /* bridge */ Object get(final int n) {
        return this.f(n);
    }
    
    @Override
    public LazyStringList h() {
        if (this.r()) {
            return new UnmodifiableLazyStringList(this);
        }
        return this;
    }
    
    @Override
    public /* bridge */ int hashCode() {
        return super.hashCode();
    }
    
    public String k(final int n) {
        this.a();
        final Object remove = this.b.remove(n);
        ++super.modCount;
        return e(remove);
    }
    
    public String m(final int n, final String s) {
        this.a();
        return e(this.b.set(n, s));
    }
    
    @Override
    public /* bridge */ boolean r() {
        return super.r();
    }
    
    @Override
    public void r1(final ByteString byteString) {
        this.a();
        this.b.add(byteString);
        ++super.modCount;
    }
    
    @Override
    public /* bridge */ Object remove(final int n) {
        return this.k(n);
    }
    
    @Override
    public /* bridge */ boolean remove(final Object o) {
        return super.remove(o);
    }
    
    @Override
    public /* bridge */ boolean removeAll(final Collection collection) {
        return super.removeAll(collection);
    }
    
    @Override
    public /* bridge */ boolean retainAll(final Collection collection) {
        return super.retainAll(collection);
    }
    
    @Override
    public /* bridge */ Object set(final int n, final Object o) {
        return this.m(n, (String)o);
    }
    
    @Override
    public int size() {
        return this.b.size();
    }
    
    @Override
    public Object u(final int n) {
        return this.b.get(n);
    }
}
