// 
// Decompiled by Procyon v0.6.0
// 

package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import kotlin.collections.h;
import java.lang.reflect.Constructor;
import kotlin.collections.o;
import android.app.Application;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\u001aK\u0010\t\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001a6\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0010\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000bH\u0000\"\u001e\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u001e\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000f¨\u0006\u0013" }, d2 = { "Landroidx/lifecycle/l0;", "T", "Ljava/lang/Class;", "modelClass", "Ljava/lang/reflect/Constructor;", "constructor", "", "", "params", "d", "(Ljava/lang/Class;Ljava/lang/reflect/Constructor;[Ljava/lang/Object;)Landroidx/lifecycle/l0;", "", "signature", "c", "a", "Ljava/util/List;", "ANDROID_VIEWMODEL_SIGNATURE", "b", "VIEWMODEL_SIGNATURE", "lifecycle-viewmodel-savedstate_release" }, k = 2, mv = { 1, 6, 0 })
public final class j0
{
    private static final List<Class<?>> a;
    private static final List<Class<?>> b;
    
    static {
        a = o.m((Object[])new Class[] { Application.class, g0.class });
        b = o.e((Object)g0.class);
    }
    
    public static final List a() {
        return j0.a;
    }
    
    public static final List b() {
        return j0.b;
    }
    
    public static final <T> Constructor<T> c(final Class<T> clazz, final List<? extends Class<?>> list) {
        kotlin.jvm.internal.o.g((Object)clazz, "modelClass");
        kotlin.jvm.internal.o.g((Object)list, "signature");
        final Constructor[] constructors = clazz.getConstructors();
        kotlin.jvm.internal.o.f((Object)constructors, "modelClass.constructors");
        for (final Constructor constructor : constructors) {
            final Class[] parameterTypes = constructor.getParameterTypes();
            kotlin.jvm.internal.o.f((Object)parameterTypes, "constructor.parameterTypes");
            final List c0 = h.c0((Object[])parameterTypes);
            if (kotlin.jvm.internal.o.b((Object)list, (Object)c0)) {
                return constructor;
            }
            if (list.size() == c0.size() && c0.containsAll(list)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Class ");
                sb.append(clazz.getSimpleName());
                sb.append(" must have parameters in the proper order: ");
                sb.append(list);
                throw new UnsupportedOperationException(sb.toString());
            }
        }
        return null;
    }
    
    public static final <T extends l0> T d(final Class<T> clazz, final Constructor<T> constructor, final Object... array) {
        kotlin.jvm.internal.o.g((Object)clazz, "modelClass");
        kotlin.jvm.internal.o.g((Object)constructor, "constructor");
        kotlin.jvm.internal.o.g((Object)array, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(array, array.length));
        }
        catch (final InvocationTargetException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("An exception happened in constructor of ");
            sb.append(clazz);
            throw new RuntimeException(sb.toString(), ex.getCause());
        }
        catch (final InstantiationException ex2) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("A ");
            sb2.append(clazz);
            sb2.append(" cannot be instantiated.");
            throw new RuntimeException(sb2.toString(), ex2);
        }
        catch (final IllegalAccessException ex3) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to access ");
            sb3.append(clazz);
            throw new RuntimeException(sb3.toString(), ex3);
        }
    }
}
