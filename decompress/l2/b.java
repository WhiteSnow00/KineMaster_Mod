// 
// Decompiled by Procyon v0.6.0
// 

package l2;

import androidx.appcompat.view.d;
import androidx.core.content.res.f;
import android.content.res.Resources$NotFoundException;
import androidx.core.content.a;
import android.graphics.drawable.Drawable;
import android.content.res.Resources$Theme;
import android.content.Context;

public final class b
{
    private static volatile boolean a = true;
    
    public static Drawable a(final Context context, final int n, final Resources$Theme resources$Theme) {
        return c(context, context, n, resources$Theme);
    }
    
    public static Drawable b(final Context context, final Context context2, final int n) {
        return c(context, context2, n, null);
    }
    
    private static Drawable c(final Context context, final Context context2, final int n, final Resources$Theme resources$Theme) {
        try {
            if (b.a) {
                return e(context2, n, resources$Theme);
            }
            goto Label_0045;
        }
        catch (final IllegalStateException ex) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return androidx.core.content.a.getDrawable(context2, n);
            }
            throw ex;
        }
        catch (final NoClassDefFoundError noClassDefFoundError) {
            b.a = false;
        }
        catch (final Resources$NotFoundException ex2) {
            goto Label_0045;
        }
    }
    
    private static Drawable d(final Context context, final int n, final Resources$Theme resources$Theme) {
        return f.f(context.getResources(), n, resources$Theme);
    }
    
    private static Drawable e(final Context context, final int n, final Resources$Theme resources$Theme) {
        Object o = context;
        if (resources$Theme != null) {
            o = new d(context, resources$Theme);
        }
        return e.a.b((Context)o, n);
    }
}
