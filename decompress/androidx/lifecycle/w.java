// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;

public class w
{
    private static Map<Class<?>, Integer> a;
    private static Map<Class<?>, List<Constructor<? extends j>>> b;
    
    static {
        w.a = new HashMap<Class<?>, Integer>();
        w.b = new HashMap<Class<?>, List<Constructor<? extends j>>>();
    }
    
    private static j a(final Constructor<? extends j> constructor, final Object o) {
        try {
            return (j)constructor.newInstance(o);
        }
        catch (final InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
        catch (final InstantiationException ex2) {
            throw new RuntimeException(ex2);
        }
        catch (final IllegalAccessException ex3) {
            throw new RuntimeException(ex3);
        }
    }
    
    private static Constructor<? extends j> b(final Class<?> clazz) {
        try {
            final Package package1 = clazz.getPackage();
            String s = clazz.getCanonicalName();
            String name;
            if (package1 != null) {
                name = package1.getName();
            }
            else {
                name = "";
            }
            if (!name.isEmpty()) {
                s = s.substring(name.length() + 1);
            }
            final String c = c(s);
            String string;
            if (name.isEmpty()) {
                string = c;
            }
            else {
                final StringBuilder sb = new StringBuilder();
                sb.append(name);
                sb.append(".");
                sb.append(c);
                string = sb.toString();
            }
            final Constructor<?> declaredConstructor = Class.forName(string).getDeclaredConstructor(clazz);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return (Constructor<? extends j>)declaredConstructor;
        }
        catch (final NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }
        catch (final ClassNotFoundException ex2) {
            return null;
        }
    }
    
    public static String c(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s.replace(".", "_"));
        sb.append("_LifecycleAdapter");
        return sb.toString();
    }
    
    private static int d(final Class<?> clazz) {
        final Integer n = w.a.get(clazz);
        if (n != null) {
            return n;
        }
        final int g = g(clazz);
        w.a.put(clazz, g);
        return g;
    }
    
    private static boolean e(final Class<?> clazz) {
        return clazz != null && q.class.isAssignableFrom(clazz);
    }
    
    static o f(final Object o) {
        final boolean b = o instanceof o;
        final boolean b2 = o instanceof i;
        if (b && b2) {
            return new FullLifecycleObserverAdapter((i)o, (o)o);
        }
        if (b2) {
            return new FullLifecycleObserverAdapter((i)o, null);
        }
        if (b) {
            return (o)o;
        }
        final Class<?> class1 = o.getClass();
        if (d(class1) != 2) {
            return new ReflectiveGenericLifecycleObserver(o);
        }
        final List list = w.b.get(class1);
        final int size = list.size();
        int i = 0;
        if (size == 1) {
            return new SingleGeneratedAdapterObserver(a((Constructor<? extends j>)list.get(0), o));
        }
        final j[] array = new j[list.size()];
        while (i < list.size()) {
            array[i] = a((Constructor<? extends j>)list.get(i), o);
            ++i;
        }
        return new CompositeGeneratedAdaptersObserver(array);
    }
    
    private static int g(final Class<?> clazz) {
        if (clazz.getCanonicalName() == null) {
            return 1;
        }
        final Constructor<? extends j> b = b(clazz);
        if (b != null) {
            w.b.put(clazz, Collections.singletonList(b));
            return 2;
        }
        if (c.c.d(clazz)) {
            return 1;
        }
        final Class superclass = clazz.getSuperclass();
        List<Constructor<? extends j>> list = null;
        if (e(superclass)) {
            if (d(superclass) == 1) {
                return 1;
            }
            list = new ArrayList<Constructor<? extends j>>(w.b.get(superclass));
        }
        for (final Class clazz2 : clazz.getInterfaces()) {
            if (e(clazz2)) {
                if (d(clazz2) == 1) {
                    return 1;
                }
                List<Constructor<? extends j>> list2;
                if ((list2 = list) == null) {
                    list2 = new ArrayList<Constructor<? extends j>>();
                }
                list2.addAll(w.b.get(clazz2));
                list = list2;
            }
        }
        if (list != null) {
            w.b.put(clazz, list);
            return 2;
        }
        return 1;
    }
}
