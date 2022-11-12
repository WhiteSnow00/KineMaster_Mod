// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Deprecated
final class c
{
    static c c;
    private final Map<Class<?>, a> a;
    private final Map<Class<?>, Boolean> b;
    
    static {
        androidx.lifecycle.c.c = new c();
    }
    
    c() {
        this.a = new HashMap<Class<?>, a>();
        this.b = new HashMap<Class<?>, Boolean>();
    }
    
    private a a(final Class<?> clazz, Method[] b) {
        final Class superclass = clazz.getSuperclass();
        final HashMap hashMap = new HashMap();
        if (superclass != null) {
            final a c = this.c(superclass);
            if (c != null) {
                hashMap.putAll(c.b);
            }
        }
        final Class[] interfaces = clazz.getInterfaces();
        for (int length = interfaces.length, i = 0; i < length; ++i) {
            for (final Map.Entry entry : this.c(interfaces[i]).b.entrySet()) {
                this.e(hashMap, (b)entry.getKey(), (Lifecycle.Event)entry.getValue(), clazz);
            }
        }
        if (b == null) {
            b = this.b(clazz);
        }
        final int length2 = b.length;
        int j = 0;
        boolean b2 = false;
        while (j < length2) {
            final Method method = b[j];
            final b0 b3 = method.getAnnotation(b0.class);
            if (b3 != null) {
                final Class<?>[] parameterTypes = method.getParameterTypes();
                int n;
                if (parameterTypes.length > 0) {
                    if (!parameterTypes[0].isAssignableFrom(r.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    n = 1;
                }
                else {
                    n = 0;
                }
                final Lifecycle.Event value = b3.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    n = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                this.e(hashMap, new b(n, method), value, clazz);
                b2 = true;
            }
            ++j;
        }
        final a a = new a(hashMap);
        this.a.put(clazz, a);
        this.b.put(clazz, b2);
        return a;
    }
    
    private Method[] b(final Class<?> clazz) {
        try {
            return clazz.getDeclaredMethods();
        }
        catch (final NoClassDefFoundError noClassDefFoundError) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", noClassDefFoundError);
        }
    }
    
    private void e(final Map<b, Lifecycle.Event> map, final b b, final Lifecycle.Event event, final Class<?> clazz) {
        final Lifecycle.Event event2 = map.get(b);
        if (event2 != null && event != event2) {
            final Method b2 = b.b;
            final StringBuilder sb = new StringBuilder();
            sb.append("Method ");
            sb.append(b2.getName());
            sb.append(" in ");
            sb.append(clazz.getName());
            sb.append(" already declared with different @OnLifecycleEvent value: previous value ");
            sb.append(event2);
            sb.append(", new value ");
            sb.append(event);
            throw new IllegalArgumentException(sb.toString());
        }
        if (event2 == null) {
            map.put(b, event);
        }
    }
    
    a c(final Class<?> clazz) {
        final a a = this.a.get(clazz);
        if (a != null) {
            return a;
        }
        return this.a(clazz, null);
    }
    
    boolean d(final Class<?> clazz) {
        final Boolean b = this.b.get(clazz);
        if (b != null) {
            return b;
        }
        final Method[] b2 = this.b(clazz);
        for (int length = b2.length, i = 0; i < length; ++i) {
            if (b2[i].getAnnotation(b0.class) != null) {
                this.a(clazz, b2);
                return true;
            }
        }
        this.b.put(clazz, Boolean.FALSE);
        return false;
    }
    
    @Deprecated
    static class a
    {
        final Map<Lifecycle.Event, List<b>> a;
        final Map<b, Lifecycle.Event> b;
        
        a(final Map<b, Lifecycle.Event> b) {
            this.b = b;
            this.a = new HashMap<Lifecycle.Event, List<b>>();
            for (final Map.Entry<K, Lifecycle.Event> entry : b.entrySet()) {
                final Lifecycle.Event event = entry.getValue();
                List list;
                if ((list = this.a.get(event)) == null) {
                    list = new ArrayList();
                    this.a.put(event, list);
                }
                list.add(entry.getKey());
            }
        }
        
        private static void b(final List<b> list, final r r, final Lifecycle.Event event, final Object o) {
            if (list != null) {
                for (int i = list.size() - 1; i >= 0; --i) {
                    ((b)list.get(i)).a(r, event, o);
                }
            }
        }
        
        void a(final r r, final Lifecycle.Event event, final Object o) {
            b(this.a.get(event), r, event, o);
            b(this.a.get(Lifecycle.Event.ON_ANY), r, event, o);
        }
    }
    
    @Deprecated
    static final class b
    {
        final int a;
        final Method b;
        
        b(final int a, final Method b) {
            this.a = a;
            (this.b = b).setAccessible(true);
        }
        
        void a(final r r, final Lifecycle.Event event, final Object o) {
            try {
                final int a = this.a;
                if (a != 0) {
                    if (a != 1) {
                        if (a == 2) {
                            this.b.invoke(o, r, event);
                        }
                    }
                    else {
                        this.b.invoke(o, r);
                    }
                }
                else {
                    this.b.invoke(o, new Object[0]);
                }
            }
            catch (final IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
            catch (final InvocationTargetException ex2) {
                throw new RuntimeException("Failed to call observer method", ex2.getCause());
            }
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (this == o) {
                return true;
            }
            if (!(o instanceof b)) {
                return false;
            }
            final b b2 = (b)o;
            if (this.a != b2.a || !this.b.getName().equals(b2.b.getName())) {
                b = false;
            }
            return b;
        }
        
        @Override
        public int hashCode() {
            return this.a * 31 + this.b.getName().hashCode();
        }
    }
}
