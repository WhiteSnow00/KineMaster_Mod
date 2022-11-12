// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.AbstractMap;
import java.util.AbstractList;
import java.util.RandomAccess;
import java.util.List;
import java.util.Objects;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class Internal
{
    static final Charset a;
    static final Charset b;
    public static final byte[] c;
    public static final ByteBuffer d;
    public static final CodedInputStream e;
    
    static {
        a = Charset.forName("UTF-8");
        b = Charset.forName("ISO-8859-1");
        final byte[] array = c = new byte[0];
        d = ByteBuffer.wrap(array);
        e = CodedInputStream.i(array);
    }
    
    private Internal() {
    }
    
    static <T> T a(final T t) {
        Objects.requireNonNull(t);
        return t;
    }
    
    static <T> T b(final T t, final String s) {
        Objects.requireNonNull(t, s);
        return t;
    }
    
    public static int c(final boolean b) {
        int n;
        if (b) {
            n = 1231;
        }
        else {
            n = 1237;
        }
        return n;
    }
    
    public static int d(final byte[] array) {
        return e(array, 0, array.length);
    }
    
    static int e(final byte[] array, int i, int n) {
        n = (i = i(n, array, i, n));
        if (n == 0) {
            i = 1;
        }
        return i;
    }
    
    public static int f(final long n) {
        return (int)(n ^ n >>> 32);
    }
    
    public static boolean g(final byte[] array) {
        return Utf8.s(array);
    }
    
    static Object h(final Object o, final Object o2) {
        return ((MessageLite)o).toBuilder().g1((MessageLite)o2).k();
    }
    
    static int i(int n, final byte[] array, final int n2, final int n3) {
        for (int i = n2; i < n2 + n3; ++i) {
            n = n * 31 + array[i];
        }
        return n;
    }
    
    public static String j(final byte[] array) {
        return new String(array, Internal.a);
    }
    
    public interface BooleanList extends ProtobufList<Boolean>
    {
    }
    
    public interface ProtobufList<E> extends List<E>, RandomAccess
    {
        ProtobufList<E> d(final int p0);
        
        void i();
        
        boolean r();
    }
    
    public interface DoubleList extends ProtobufList<Double>
    {
    }
    
    public interface EnumLite
    {
        int getNumber();
    }
    
    public interface EnumLiteMap<T extends EnumLite>
    {
        T a(final int p0);
    }
    
    public interface EnumVerifier
    {
        boolean a(final int p0);
    }
    
    public interface FloatList extends ProtobufList<Float>
    {
    }
    
    public interface IntList extends ProtobufList<Integer>
    {
    }
    
    public static class ListAdapter<F, T> extends AbstractList<T>
    {
        private final List<F> a;
        private final Converter<F, T> b;
        
        @Override
        public T get(final int n) {
            return this.b.a(this.a.get(n));
        }
        
        @Override
        public int size() {
            return this.a.size();
        }
        
        public interface Converter<F, T>
        {
            T a(final F p0);
        }
    }
    
    public interface LongList extends ProtobufList<Long>
    {
    }
    
    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V>
    {
        private final Map<K, RealValue> a;
        private final Converter<RealValue, V> b;
        
        static Converter a(final MapAdapter mapAdapter) {
            return mapAdapter.b;
        }
        
        @Override
        public Set<Entry<K, V>> entrySet() {
            return new c(this.a.entrySet());
        }
        
        @Override
        public V get(Object value) {
            value = this.a.get(value);
            if (value == null) {
                return null;
            }
            return this.b.a((RealValue)value);
        }
        
        @Override
        public V put(final K k, final V v) {
            final RealValue put = this.a.put(k, this.b.b(v));
            if (put == null) {
                return null;
            }
            return this.b.a(put);
        }
        
        public interface Converter<A, B>
        {
            B a(final A p0);
            
            A b(final B p0);
        }
        
        private class a implements Entry<K, V>
        {
            private final Entry<K, RealValue> a;
            final MapAdapter b;
            
            public a(final MapAdapter b, final Entry<K, RealValue> a) {
                this.b = b;
                this.a = a;
            }
            
            @Override
            public boolean equals(final Object o) {
                boolean b = true;
                if (o == this) {
                    return true;
                }
                if (!(o instanceof Entry)) {
                    return false;
                }
                if (!this.getKey().equals(((Entry)o).getKey()) || !this.getValue().equals(this.getValue())) {
                    b = false;
                }
                return b;
            }
            
            @Override
            public K getKey() {
                return this.a.getKey();
            }
            
            @Override
            public V getValue() {
                return MapAdapter.a(this.b).a(this.a.getValue());
            }
            
            @Override
            public int hashCode() {
                return this.a.hashCode();
            }
            
            @Override
            public V setValue(final V v) {
                final RealValue setValue = this.a.setValue(MapAdapter.a(this.b).b(v));
                if (setValue == null) {
                    return null;
                }
                return (V)MapAdapter.a(this.b).a(setValue);
            }
        }
        
        private class b implements Iterator<Entry<K, V>>
        {
            private final Iterator<Entry<K, RealValue>> a;
            final MapAdapter b;
            
            public b(final MapAdapter b, final Iterator<Entry<K, RealValue>> a) {
                this.b = b;
                this.a = a;
            }
            
            public Entry<K, V> b() {
                return new a(this.a.next());
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
        
        private class c extends AbstractSet<Entry<K, V>>
        {
            private final Set<Entry<K, RealValue>> a;
            final MapAdapter b;
            
            public c(final MapAdapter b, final Set<Entry<K, RealValue>> a) {
                this.b = b;
                this.a = a;
            }
            
            @Override
            public Iterator<Entry<K, V>> iterator() {
                return new b(this.a.iterator());
            }
            
            @Override
            public int size() {
                return this.a.size();
            }
        }
    }
}
