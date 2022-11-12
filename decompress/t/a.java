// 
// Decompiled by Procyon v0.6.0
// 

package t;

import java.lang.reflect.Method;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;

public class a
{
    private static int a(int n) {
        n = (n & ~(n >> 31)) - 255;
        return (n & n >> 31) + 255;
    }
    
    public static void b(final ConstraintAttribute constraintAttribute, final View view, final float[] array) {
        final Class<? extends View> class1 = view.getClass();
        final StringBuilder sb = new StringBuilder();
        sb.append("set");
        sb.append(constraintAttribute.c());
        final String string = sb.toString();
        try {
            final int n = a$a.a[constraintAttribute.d().ordinal()];
            boolean b = true;
            switch (n) {
                case 7: {
                    class1.getMethod(string, Float.TYPE).invoke(view, array[0]);
                    break;
                }
                case 6: {
                    final Method method = class1.getMethod(string, Boolean.TYPE);
                    if (array[0] <= 0.5f) {
                        b = false;
                    }
                    method.invoke(view, b);
                    break;
                }
                case 5: {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("unable to interpolate strings ");
                    sb2.append(constraintAttribute.c());
                    throw new RuntimeException(sb2.toString());
                }
                case 4: {
                    class1.getMethod(string, Integer.TYPE).invoke(view, a((int)((float)Math.pow(array[0], 0.45454545454545453) * 255.0f)) << 16 | a((int)(array[3] * 255.0f)) << 24 | a((int)((float)Math.pow(array[1], 0.45454545454545453) * 255.0f)) << 8 | a((int)((float)Math.pow(array[2], 0.45454545454545453) * 255.0f)));
                    break;
                }
                case 3: {
                    final Method method2 = class1.getMethod(string, Drawable.class);
                    final int a = a((int)((float)Math.pow(array[0], 0.45454545454545453) * 255.0f));
                    final int a2 = a((int)((float)Math.pow(array[1], 0.45454545454545453) * 255.0f));
                    final int a3 = a((int)((float)Math.pow(array[2], 0.45454545454545453) * 255.0f));
                    final int a4 = a((int)(array[3] * 255.0f));
                    final ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(a << 16 | a4 << 24 | a2 << 8 | a3);
                    method2.invoke(view, colorDrawable);
                    break;
                }
                case 2: {
                    class1.getMethod(string, Float.TYPE).invoke(view, array[0]);
                    break;
                }
                case 1: {
                    class1.getMethod(string, Integer.TYPE).invoke(view, (int)array[0]);
                    break;
                }
            }
        }
        catch (final InvocationTargetException ex) {
            ex.printStackTrace();
        }
        catch (final IllegalAccessException ex2) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("cannot access method ");
            sb3.append(string);
            sb3.append(" on View \"");
            sb3.append(androidx.constraintlayout.motion.widget.a.c(view));
            sb3.append("\"");
            Log.e("CustomSupport", sb3.toString());
            ex2.printStackTrace();
        }
        catch (final NoSuchMethodException ex3) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append("no method ");
            sb4.append(string);
            sb4.append(" on View \"");
            sb4.append(androidx.constraintlayout.motion.widget.a.c(view));
            sb4.append("\"");
            Log.e("CustomSupport", sb4.toString());
            ex3.printStackTrace();
        }
    }
}
