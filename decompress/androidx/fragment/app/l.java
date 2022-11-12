// 
// Decompiled by Procyon v0.6.0
// 

package androidx.fragment.app;

import androidx.collection.g;

public class l
{
    private static final g<ClassLoader, g<String, Class<?>>> a;
    
    static {
        a = new g<ClassLoader, g<String, Class<?>>>();
    }
    
    static boolean b(final ClassLoader classLoader, final String s) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, s));
        }
        catch (final ClassNotFoundException ex) {
            return false;
        }
    }
    
    private static Class<?> c(final ClassLoader classLoader, final String s) throws ClassNotFoundException {
        final g<ClassLoader, g<String, Class<?>>> a = l.a;
        g g;
        if ((g = a.get(classLoader)) == null) {
            g = new g();
            a.put(classLoader, g);
        }
        Class<?> forName;
        if ((forName = (Class)g.get(s)) == null) {
            forName = Class.forName(s, false, classLoader);
            g.put(s, forName);
        }
        return forName;
    }
    
    public static Class<? extends Fragment> d(final ClassLoader classLoader, final String s) {
        try {
            return (Class<? extends Fragment>)c(classLoader, s);
        }
        catch (final ClassCastException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unable to instantiate fragment ");
            sb.append(s);
            sb.append(": make sure class is a valid subclass of Fragment");
            throw new Fragment.InstantiationException(sb.toString(), ex);
        }
        catch (final ClassNotFoundException ex2) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to instantiate fragment ");
            sb2.append(s);
            sb2.append(": make sure class name exists");
            throw new Fragment.InstantiationException(sb2.toString(), ex2);
        }
    }
    
    public Fragment a(final ClassLoader classLoader, final String s) {
        throw null;
    }
}
