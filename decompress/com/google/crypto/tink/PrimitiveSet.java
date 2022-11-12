// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink;

import com.google.crypto.tink.subtle.Hex;
import java.util.Arrays;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public final class PrimitiveSet<P>
{
    private final ConcurrentMap<b, List<Entry<P>>> a;
    private Entry<P> b;
    private final Class<P> c;
    
    private PrimitiveSet(final Class<P> c) {
        this.a = new ConcurrentHashMap<b, List<Entry<P>>>();
        this.c = c;
    }
    
    public static <P> PrimitiveSet<P> f(final Class<P> clazz) {
        return new PrimitiveSet<P>(clazz);
    }
    
    public Entry<P> a(final P p2, final Keyset.Key key) throws GeneralSecurityException {
        if (key.R() == KeyStatusType.ENABLED) {
            final Entry entry = new Entry((P)p2, CryptoFormat.a(key), key.R(), key.Q(), key.P());
            final ArrayList list = new ArrayList();
            list.add(entry);
            final b b = new b(entry.a(), null);
            final List<Entry<P>> list2 = this.a.put(b, Collections.unmodifiableList((List<? extends Entry<P>>)list));
            if (list2 != null) {
                final ArrayList list3 = new ArrayList();
                list3.addAll(list2);
                list3.add(entry);
                this.a.put(b, (List<Entry<P>>)Collections.unmodifiableList((List<?>)list3));
            }
            return entry;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }
    
    public Entry<P> b() {
        return this.b;
    }
    
    public List<Entry<P>> c(final byte[] array) {
        List<Object> emptyList = this.a.get(new b(array, null));
        if (emptyList == null) {
            emptyList = Collections.emptyList();
        }
        return (List<Entry<P>>)emptyList;
    }
    
    public Class<P> d() {
        return this.c;
    }
    
    public List<Entry<P>> e() {
        return this.c(CryptoFormat.a);
    }
    
    public void g(final Entry<P> b) {
        if (b == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        }
        if (b.e() != KeyStatusType.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
        if (!this.c(b.a()).isEmpty()) {
            this.b = b;
            return;
        }
        throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
    }
    
    public static final class Entry<P>
    {
        private final P a;
        private final byte[] b;
        private final KeyStatusType c;
        private final OutputPrefixType d;
        private final int e;
        
        Entry(final P a, final byte[] array, final KeyStatusType c, final OutputPrefixType d, final int e) {
            this.a = a;
            this.b = Arrays.copyOf(array, array.length);
            this.c = c;
            this.d = d;
            this.e = e;
        }
        
        public final byte[] a() {
            final byte[] b = this.b;
            if (b == null) {
                return null;
            }
            return Arrays.copyOf(b, b.length);
        }
        
        public int b() {
            return this.e;
        }
        
        public OutputPrefixType c() {
            return this.d;
        }
        
        public P d() {
            return this.a;
        }
        
        public KeyStatusType e() {
            return this.c;
        }
    }
    
    private static class b implements Comparable<b>
    {
        private final byte[] a;
        
        private b(final byte[] array) {
            this.a = Arrays.copyOf(array, array.length);
        }
        
        b(final byte[] array, final PrimitiveSet$a object) {
            this(array);
        }
        
        public int a(final b b) {
            final byte[] a = this.a;
            final int length = a.length;
            final byte[] a2 = b.a;
            int length2;
            int length3;
            if (length != a2.length) {
                length2 = a.length;
                length3 = a2.length;
            }
            else {
                int n = 0;
                while (true) {
                    final byte[] a3 = this.a;
                    if (n >= a3.length) {
                        return 0;
                    }
                    final byte b2 = a3[n];
                    final byte[] a4 = b.a;
                    if (b2 != a4[n]) {
                        length2 = a3[n];
                        length3 = a4[n];
                        break;
                    }
                    ++n;
                }
            }
            return length2 - length3;
        }
        
        @Override
        public /* bridge */ int compareTo(final Object o) {
            return this.a((b)o);
        }
        
        @Override
        public boolean equals(final Object o) {
            return o instanceof b && Arrays.equals(this.a, ((b)o).a);
        }
        
        @Override
        public int hashCode() {
            return Arrays.hashCode(this.a);
        }
        
        @Override
        public String toString() {
            return Hex.b(this.a);
        }
    }
}
