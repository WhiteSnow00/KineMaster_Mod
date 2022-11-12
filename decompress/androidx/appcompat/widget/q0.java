// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.content.res.Resources$NotFoundException;
import android.graphics.drawable.Drawable;
import android.content.res.Resources;
import android.content.Context;
import java.lang.ref.WeakReference;

class q0 extends i0
{
    private final WeakReference<Context> b;
    
    public q0(final Context context, final Resources resources) {
        super(resources);
        this.b = new WeakReference<Context>(context);
    }
    
    public Drawable getDrawable(final int n) throws Resources$NotFoundException {
        final Drawable a = this.a(n);
        final Context context = this.b.get();
        if (a != null && context != null) {
            h0.g().w(context, n, a);
        }
        return a;
    }
}
