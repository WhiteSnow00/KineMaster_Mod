// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.ListIterator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.AbstractList;

public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess
{
    private final LazyStringList a;
    
    public UnmodifiableLazyStringList(final LazyStringList a) {
        this.a = a;
    }
    
    static LazyStringList a(final UnmodifiableLazyStringList list) {
        return list.a;
    }
    
    public String b(final int n) {
        return this.a.get(n);
    }
    
    @Override
    public List<?> c() {
        return this.a.c();
    }
    
    @Override
    public /* bridge */ Object get(final int n) {
        return this.b(n);
    }
    
    @Override
    public LazyStringList h() {
        return this;
    }
    
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>(this) {
            Iterator<String> a = UnmodifiableLazyStringList.a(b).iterator();
            final UnmodifiableLazyStringList b;
            
            public String b() {
                return this.a.next();
            }
            
            @Override
            public boolean hasNext() {
                return this.a.hasNext();
            }
            
            @Override
            public /* bridge */ Object next() {
                return this.b();
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    
    @Override
    public ListIterator<String> listIterator(final int n) {
        return new ListIterator<String>(this, n) {
            ListIterator<String> a = UnmodifiableLazyStringList.a(c).listIterator(b);
            final int b;
            final UnmodifiableLazyStringList c;
            
            @Override
            public /* bridge */ void add(final Object o) {
                this.b((String)o);
            }
            
            public void b(final String s) {
                throw new UnsupportedOperationException();
            }
            
            public String c() {
                return this.a.next();
            }
            
            public String d() {
                return this.a.previous();
            }
            
            public void e(final String s) {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public boolean hasNext() {
                return this.a.hasNext();
            }
            
            @Override
            public boolean hasPrevious() {
                return this.a.hasPrevious();
            }
            
            @Override
            public /* bridge */ Object next() {
                return this.c();
            }
            
            @Override
            public int nextIndex() {
                return this.a.nextIndex();
            }
            
            @Override
            public /* bridge */ Object previous() {
                return this.d();
            }
            
            @Override
            public int previousIndex() {
                return this.a.previousIndex();
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
            @Override
            public /* bridge */ void set(final Object o) {
                this.e((String)o);
            }
        };
    }
    
    @Override
    public void r1(final ByteString byteString) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int size() {
        return this.a.size();
    }
    
    @Override
    public Object u(final int n) {
        return this.a.u(n);
    }
}
