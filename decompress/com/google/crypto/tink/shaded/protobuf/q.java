// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class q
{
    private static final q a;
    private static final q b;
    
    static {
        a = new b(null);
        b = new c(null);
    }
    
    private q() {
    }
    
    q(final q$a object) {
        this();
    }
    
    static q a() {
        return q.a;
    }
    
    static q b() {
        return q.b;
    }
    
    abstract void c(final Object p0, final long p1);
    
    abstract <L> void d(final Object p0, final Object p1, final long p2);
    
    abstract <L> List<L> e(final Object p0, final long p1);
    
    private static final class b extends q
    {
        private static final Class<?> c;
        
        static {
            c = Collections.unmodifiableList(Collections.emptyList()).getClass();
        }
        
        private b() {
            super(null);
        }
        
        b(final q$a object) {
            this();
        }
        
        static <E> List<E> f(final Object o, final long n) {
            return (List)q0.E(o, n);
        }
        
        private static <L> List<L> g(final Object o, final long n, final int n2) {
            final List<Object> f = f(o, n);
            Object o2;
            if (f.isEmpty()) {
                if (f instanceof LazyStringList) {
                    o2 = new LazyStringArrayList(n2);
                }
                else if (f instanceof e0 && f instanceof Internal.ProtobufList) {
                    o2 = ((Internal.ProtobufList)f).d(n2);
                }
                else {
                    o2 = new ArrayList<L>(n2);
                }
                q0.T(o, n, o2);
            }
            else {
                ArrayList list2;
                if (b.c.isAssignableFrom(((Internal.ProtobufList)f).getClass())) {
                    final ArrayList list = new ArrayList(f.size() + n2);
                    list.addAll((Collection)f);
                    q0.T(o, n, list);
                    list2 = list;
                }
                else if (f instanceof UnmodifiableLazyStringList) {
                    final LazyStringArrayList list3 = new LazyStringArrayList(f.size() + n2);
                    list3.addAll((Collection<? extends String>)f);
                    q0.T(o, n, list3);
                    list2 = (ArrayList)list3;
                }
                else {
                    o2 = f;
                    if (!(f instanceof e0)) {
                        return (List<L>)o2;
                    }
                    o2 = f;
                    if (!(f instanceof Internal.ProtobufList)) {
                        return (List<L>)o2;
                    }
                    final Internal.ProtobufList list4 = (Internal.ProtobufList)f;
                    o2 = f;
                    if (!list4.r()) {
                        o2 = list4.d(f.size() + n2);
                        q0.T(o, n, o2);
                        return (List<L>)o2;
                    }
                    return (List<L>)o2;
                }
                o2 = list2;
            }
            return (List<L>)o2;
        }
        
        @Override
        void c(final Object o, final long n) {
            final List list = (List)q0.E(o, n);
            Object o2;
            if (list instanceof LazyStringList) {
                o2 = ((LazyStringList)list).h();
            }
            else {
                if (b.c.isAssignableFrom(((Internal.ProtobufList)list).getClass())) {
                    return;
                }
                if (list instanceof e0 && list instanceof Internal.ProtobufList) {
                    final Internal.ProtobufList list2 = (Internal.ProtobufList)list;
                    if (list2.r()) {
                        list2.i();
                    }
                    return;
                }
                o2 = Collections.unmodifiableList((List<?>)list);
            }
            q0.T(o, n, o2);
        }
        
        @Override
         <E> void d(final Object o, final Object o2, final long n) {
            List<Object> f = f(o2, n);
            final List<Object> g = g(o, n, f.size());
            final int size = g.size();
            final int size2 = f.size();
            if (size > 0 && size2 > 0) {
                g.addAll(f);
            }
            if (size > 0) {
                f = g;
            }
            q0.T(o, n, f);
        }
        
        @Override
         <L> List<L> e(final Object o, final long n) {
            return g(o, n, 10);
        }
    }
    
    private static final class c extends q
    {
        private c() {
            super(null);
        }
        
        c(final q$a object) {
            this();
        }
        
        static <E> Internal.ProtobufList<E> f(final Object o, final long n) {
            return (Internal.ProtobufList)q0.E(o, n);
        }
        
        @Override
        void c(final Object o, final long n) {
            f(o, n).i();
        }
        
        @Override
         <E> void d(final Object o, final Object o2, final long n) {
            final Internal.ProtobufList<Object> f = f(o, n);
            final Internal.ProtobufList<Object> f2 = f(o2, n);
            final int size = f.size();
            final int size2 = f2.size();
            Internal.ProtobufList<Object> d = f;
            if (size > 0) {
                d = f;
                if (size2 > 0) {
                    d = f;
                    if (!f.r()) {
                        d = f.d(size2 + size);
                    }
                    d.addAll(f2);
                }
            }
            Internal.ProtobufList list = f2;
            if (size > 0) {
                list = (Internal.ProtobufList)d;
            }
            q0.T(o, n, list);
        }
        
        @Override
         <L> List<L> e(final Object o, final long n) {
            Internal.ProtobufList<Object> list2;
            final Internal.ProtobufList<Object> list = list2 = f(o, n);
            if (!list.r()) {
                final int size = list.size();
                int n2;
                if (size == 0) {
                    n2 = 10;
                }
                else {
                    n2 = size * 2;
                }
                list2 = list.d(n2);
                q0.T(o, n, list2);
            }
            return (List<L>)list2;
        }
    }
}
