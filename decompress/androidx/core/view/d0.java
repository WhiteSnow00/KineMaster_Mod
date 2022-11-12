// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.content.res.Resources;
import android.os.Build$VERSION;
import android.content.Context;
import android.view.ViewConfiguration;

public final class d0
{
    public static float a(final ViewConfiguration viewConfiguration, final Context context) {
        return a.a(viewConfiguration);
    }
    
    public static float b(final ViewConfiguration viewConfiguration, final Context context) {
        return a.b(viewConfiguration);
    }
    
    public static boolean c(final ViewConfiguration viewConfiguration, final Context context) {
        if (Build$VERSION.SDK_INT >= 28) {
            return b.b(viewConfiguration);
        }
        final Resources resources = context.getResources();
        final int identifier = resources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
        return identifier != 0 && resources.getBoolean(identifier);
    }
    
    static class a
    {
        static float a(final ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }
        
        static float b(final ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }
    
    static class b
    {
        static int a(final ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }
        
        static boolean b(final ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }
}
