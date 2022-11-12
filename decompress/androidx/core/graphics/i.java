// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics;

import java.io.File;
import android.content.res.Resources;
import androidx.core.content.res.d;
import android.content.Context;
import java.lang.reflect.GenericDeclaration;
import android.util.Log;
import java.lang.reflect.Array;
import android.graphics.Typeface;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

class i extends m
{
    private static Class<?> b;
    private static Constructor<?> c;
    private static Method d;
    private static Method e;
    private static boolean f = false;
    
    private static boolean f(final Object ex, final String s, final int n, final boolean b) {
        h();
        try {
            return (boolean)i.d.invoke(ex, s, n, b);
        }
        catch (final InvocationTargetException ex) {}
        catch (final IllegalAccessException ex2) {}
        throw new RuntimeException(ex);
    }
    
    private static Typeface g(Object ex) {
        h();
        try {
            final Object instance = Array.newInstance(i.b, 1);
            Array.set(instance, 0, ex);
            ex = (InvocationTargetException)i.e.invoke(null, instance);
            return (Typeface)ex;
        }
        catch (final InvocationTargetException ex) {}
        catch (final IllegalAccessException ex2) {}
        throw new RuntimeException(ex);
    }
    
    private static void h() {
        if (i.f) {
            return;
        }
        i.f = true;
        Constructor<?> c = null;
        GenericDeclaration forName = null;
        Method method = null;
        Method method2 = null;
        Label_0111: {
            try {
                forName = Class.forName("android.graphics.FontFamily");
                final Constructor constructor = ((Class)forName).getConstructor((Class[])new Class[0]);
                method = ((Class)forName).getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>)forName, 1).getClass());
                c = constructor;
                break Label_0111;
            }
            catch (final NoSuchMethodException method) {}
            catch (final ClassNotFoundException ex) {}
            Log.e("TypefaceCompatApi21Impl", ((NoSuchMethodException)method).getClass().getName(), (Throwable)method);
            method2 = null;
            forName = (method = null);
        }
        i.c = c;
        i.b = (Class<?>)forName;
        i.d = method;
        i.e = method2;
    }
    
    private static Object i() {
        h();
        Object instance = null;
        try {
            instance = i.c.newInstance(new Object[0]);
            return instance;
        }
        catch (final InvocationTargetException instance) {}
        catch (final InstantiationException instance) {}
        catch (final IllegalAccessException ex) {}
        throw new RuntimeException((Throwable)instance);
    }
    
    @Override
    public Typeface a(final Context context, d.c d, final Resources resources, int i) {
        final Object j = i();
        final d.d[] a = d.a();
        final int length = a.length;
        i = 0;
        while (i < length) {
            final d.d d2 = a[i];
            d = (d.c)n.d(context);
            if (d == null) {
                return null;
            }
            try {
                if (!n.b((File)d, resources, d2.b())) {
                    return null;
                }
                if (!f(j, ((File)d).getPath(), d2.e(), d2.f())) {
                    return null;
                }
                ((File)d).delete();
                ++i;
                continue;
            }
            catch (final RuntimeException ex) {
                return null;
            }
            finally {
                ((File)d).delete();
            }
            break;
        }
        return g(j);
    }
}
