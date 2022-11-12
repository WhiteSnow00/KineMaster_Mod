// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Array;
import android.graphics.Typeface;

public class k extends j
{
    @Override
    protected Typeface g(Object ex) {
        try {
            final Object instance = Array.newInstance(super.g, 1);
            Array.set(instance, 0, ex);
            ex = (InvocationTargetException)super.m.invoke(null, instance, "sans-serif", -1, -1);
            return (Typeface)ex;
        }
        catch (final InvocationTargetException ex) {}
        catch (final IllegalAccessException ex2) {}
        throw new RuntimeException(ex);
    }
    
    @Override
    protected Method r(final Class<?> clazz) throws NoSuchMethodException {
        final Class<?> class1 = Array.newInstance(clazz, 1).getClass();
        final Class<Integer> type = Integer.TYPE;
        final Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", class1, String.class, type, type);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
