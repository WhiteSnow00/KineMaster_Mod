// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

class j
{
    static void a(final List<Component<?>> list) {
        final Set<b> c = c(list);
        final Set<b> b = b(c);
        int n = 0;
        while (!b.isEmpty()) {
            final b b2 = b.iterator().next();
            b.remove(b2);
            final int n2 = n + 1;
            final Iterator<b> iterator = b2.d().iterator();
            while (true) {
                n = n2;
                if (!iterator.hasNext()) {
                    break;
                }
                final b b3 = iterator.next();
                b3.g(b2);
                if (!b3.f()) {
                    continue;
                }
                b.add(b3);
            }
        }
        if (n == list.size()) {
            return;
        }
        final ArrayList list2 = new ArrayList();
        for (final b b4 : c) {
            if (!b4.f() && !b4.e()) {
                list2.add(b4.c());
            }
        }
        throw new DependencyCycleException(list2);
    }
    
    private static Set<b> b(final Set<b> set) {
        final HashSet set2 = new HashSet();
        for (final b b : set) {
            if (b.f()) {
                set2.add(b);
            }
        }
        return set2;
    }
    
    private static Set<b> c(final List<Component<?>> list) {
        final HashMap hashMap = new HashMap(list.size());
        for (final Component component : list) {
            final b b = new b(component);
            for (final Class clazz : component.g()) {
                final c c = new c(clazz, component.m() ^ true, null);
                if (!hashMap.containsKey(c)) {
                    hashMap.put(c, new HashSet());
                }
                final Set set = (Set)hashMap.get(c);
                if (!set.isEmpty() && !j.c.a(c)) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", clazz));
                }
                set.add(b);
            }
        }
        final Iterator iterator3 = hashMap.values().iterator();
        while (iterator3.hasNext()) {
            for (final b b2 : (Set)iterator3.next()) {
                for (final Dependency dependency : b2.c().e()) {
                    if (!dependency.e()) {
                        continue;
                    }
                    final Set set2 = (Set)hashMap.get(new c(dependency.c(), dependency.g(), null));
                    if (set2 == null) {
                        continue;
                    }
                    for (final b b3 : set2) {
                        b2.a(b3);
                        b3.b(b2);
                    }
                }
            }
        }
        final HashSet set3 = new HashSet();
        final Iterator iterator7 = hashMap.values().iterator();
        while (iterator7.hasNext()) {
            set3.addAll((Collection)iterator7.next());
        }
        return set3;
    }
    
    private static class b
    {
        private final Component<?> a;
        private final Set<b> b;
        private final Set<b> c;
        
        b(final Component<?> a) {
            this.b = new HashSet<b>();
            this.c = new HashSet<b>();
            this.a = a;
        }
        
        void a(final b b) {
            this.b.add(b);
        }
        
        void b(final b b) {
            this.c.add(b);
        }
        
        Component<?> c() {
            return this.a;
        }
        
        Set<b> d() {
            return this.b;
        }
        
        boolean e() {
            return this.b.isEmpty();
        }
        
        boolean f() {
            return this.c.isEmpty();
        }
        
        void g(final b b) {
            this.c.remove(b);
        }
    }
    
    private static class c
    {
        private final Class<?> a;
        private final boolean b;
        
        private c(final Class<?> a, final boolean b) {
            this.a = a;
            this.b = b;
        }
        
        c(final Class clazz, final boolean b, final j$a object) {
            this(clazz, b);
        }
        
        static boolean a(final c c) {
            return c.b;
        }
        
        @Override
        public boolean equals(final Object o) {
            final boolean b = o instanceof c;
            boolean b3;
            final boolean b2 = b3 = false;
            if (b) {
                final c c = (c)o;
                b3 = b2;
                if (c.a.equals(this.a)) {
                    b3 = b2;
                    if (c.b == this.b) {
                        b3 = true;
                    }
                }
            }
            return b3;
        }
        
        @Override
        public int hashCode() {
            return (this.a.hashCode() ^ 0xF4243) * 1000003 ^ Boolean.valueOf(this.b).hashCode();
        }
    }
}
