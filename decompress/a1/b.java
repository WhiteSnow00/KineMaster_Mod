// 
// Decompiled by Procyon v0.6.0
// 

package a1;

import android.content.res.Resources$NotFoundException;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.content.Context;

public class b
{
    public static Interpolator a(final Context context, final int n) throws Resources$NotFoundException {
        return AnimationUtils.loadInterpolator(context, n);
    }
}
