// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import android.graphics.PorterDuff$Mode;
import android.graphics.Insets;
import androidx.core.graphics.drawable.a;
import android.os.Build$VERSION;
import android.graphics.drawable.Drawable;
import android.graphics.Rect;

public class a0
{
    private static final int[] a;
    private static final int[] b;
    public static final Rect c;
    
    static {
        a = new int[] { 16842912 };
        b = new int[0];
        c = new Rect();
    }
    
    public static boolean a(final Drawable drawable) {
        return true;
    }
    
    static void b(final Drawable drawable) {
        final String name = drawable.getClass().getName();
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 29 && sdk_INT < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            c(drawable);
        }
    }
    
    private static void c(final Drawable drawable) {
        final int[] state = drawable.getState();
        if (state != null && state.length != 0) {
            drawable.setState(a0.b);
        }
        else {
            drawable.setState(a0.a);
        }
        drawable.setState(state);
    }
    
    public static Rect d(final Drawable drawable) {
        if (Build$VERSION.SDK_INT >= 29) {
            final Insets a = a0.b.a(drawable);
            return new Rect(a.left, a.top, a.right, a.bottom);
        }
        return a0.a.a(androidx.core.graphics.drawable.a.k(drawable));
    }
    
    public static PorterDuff$Mode e(final int n, final PorterDuff$Mode porterDuff$Mode) {
        if (n == 3) {
            return PorterDuff$Mode.SRC_OVER;
        }
        if (n == 5) {
            return PorterDuff$Mode.SRC_IN;
        }
        if (n == 9) {
            return PorterDuff$Mode.SRC_ATOP;
        }
        switch (n) {
            default: {
                return porterDuff$Mode;
            }
            case 16: {
                return PorterDuff$Mode.ADD;
            }
            case 15: {
                return PorterDuff$Mode.SCREEN;
            }
            case 14: {
                return PorterDuff$Mode.MULTIPLY;
            }
        }
    }
    
    static class a
    {
        private static final boolean a;
        private static final Method b;
        private static final Field c;
        private static final Field d;
        private static final Field e;
        private static final Field f;
        
        static {
            Class<?> forName = null;
            Method method;
            Field field = null;
            Field field2 = null;
            Field field3 = null;
            try {
                forName = Class.forName("android.graphics.Insets");
                method = Drawable.class.getMethod("getOpticalInsets", (Class<?>[])new Class[0]);
                try {
                    field = forName.getField("left");
                    try {
                        field2 = forName.getField("top");
                        try {
                            field3 = forName.getField("right");
                            final Class clazz = forName;
                            final String s = "bottom";
                            final Field f2 = clazz.getField(s);
                            final int n2;
                            final int n = n2 = 1;
                        }
                        catch (NoSuchMethodException | ClassNotFoundException | NoSuchFieldException field3) {
                            field3 = null;
                        }
                    }
                    catch (final NoSuchFieldException field3) {}
                    catch (final ClassNotFoundException field3) {}
                    catch (final NoSuchMethodException field3) {}
                }
                catch (final NoSuchFieldException field) {}
                catch (final ClassNotFoundException field) {}
                catch (final NoSuchMethodException field) {}
            }
            catch (NoSuchFieldException method) {
                method = null;
            }
            catch (ClassNotFoundException method) {
                method = null;
            }
            catch (NoSuchMethodException method) {
                method = null;
            }
        Label_0109_Outer:
            while (true) {
                try {
                    final Class clazz = forName;
                    final String s = "bottom";
                    Field f2 = clazz.getField(s);
                    int n2 = 1;
                    while (true) {
                        if (n2 != 0) {
                            b = method;
                            c = field;
                            d = field2;
                            e = field3;
                            f = f2;
                            a = true;
                        }
                        else {
                            b = null;
                            c = null;
                            d = null;
                            e = null;
                            f = null;
                            a = false;
                        }
                        return;
                        n2 = 0;
                        f2 = null;
                        continue Label_0109_Outer;
                    }
                    while (true) {
                        field2 = null;
                        field3 = null;
                        continue Label_0109_Outer;
                        field = null;
                        continue;
                        field = null;
                        continue;
                        field = null;
                        continue;
                    }
                }
                catch (final NoSuchMethodException | ClassNotFoundException | NoSuchFieldException ex) {
                    continue;
                }
                break;
            }
        }
        
        static Rect a(final Drawable drawable) {
            Label_0068: {
                if (Build$VERSION.SDK_INT >= 29 || !a0.a.a) {
                    break Label_0068;
                }
                try {
                    final Object invoke = a0.a.b.invoke(drawable, new Object[0]);
                    if (invoke != null) {
                        return new Rect(a0.a.c.getInt(invoke), a0.a.d.getInt(invoke), a0.a.e.getInt(invoke), a0.a.f.getInt(invoke));
                    }
                    return a0.c;
                }
                catch (final IllegalAccessException | InvocationTargetException ex) {
                    return a0.c;
                }
            }
        }
    }
    
    static class b
    {
        static Insets a(final Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }
}
