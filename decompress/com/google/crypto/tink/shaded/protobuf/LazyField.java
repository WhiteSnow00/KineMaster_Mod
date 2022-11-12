// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;
import java.util.Map;

public class LazyField extends LazyFieldLite
{
    private final MessageLite f;
    
    @Override
    public boolean equals(final Object o) {
        return this.f().equals(o);
    }
    
    public MessageLite f() {
        return this.c(this.f);
    }
    
    @Override
    public int hashCode() {
        return this.f().hashCode();
    }
    
    @Override
    public String toString() {
        return this.f().toString();
    }
    
    static class b<K> implements Entry<K, Object>
    {
        private Entry<K, LazyField> a;
        
        private b(final Entry<K, LazyField> a) {
            this.a = a;
        }
        
        b(final Entry entry, final LazyField$a object) {
            this(entry);
        }
        
        public LazyField a() {
            return this.a.getValue();
        }
        
        @Override
        public K getKey() {
            return this.a.getKey();
        }
        
        @Override
        public Object getValue() {
            final LazyField lazyField = this.a.getValue();
            if (lazyField == null) {
                return null;
            }
            return lazyField.f();
        }
        
        @Override
        public Object setValue(final Object o) {
            if (o instanceof MessageLite) {
                return this.a.getValue().d((MessageLite)o);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }
    
    static class c<K> implements Iterator<Map.Entry<K, Object>>
    {
        private Iterator<Map.Entry<K, Object>> a;
        
        public c(final Iterator<Map.Entry<K, Object>> a) {
            this.a = a;
        }
        
        public Map.Entry<K, Object> b() {
            final Map.Entry entry = this.a.next();
            if (entry.getValue() instanceof LazyField) {
                return new b<K>(entry, null);
            }
            return entry;
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
            this.a.remove();
        }
    }
}
