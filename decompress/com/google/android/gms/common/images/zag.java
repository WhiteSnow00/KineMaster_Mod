// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.images;

import android.graphics.drawable.BitmapDrawable;
import com.google.android.gms.common.internal.Asserts;
import android.graphics.Bitmap;
import com.google.android.gms.internal.base.zam;
import android.content.Context;
import android.graphics.drawable.Drawable;

public abstract class zag
{
    protected int a;
    
    protected abstract void a(final Drawable p0, final boolean p1, final boolean p2, final boolean p3);
    
    final void b(final Context context, final zam zam, final boolean b) {
        final int a = this.a;
        Drawable drawable;
        if (a != 0) {
            drawable = context.getResources().getDrawable(a);
        }
        else {
            drawable = null;
        }
        this.a(drawable, b, false, false);
    }
    
    final void c(final Context context, final Bitmap bitmap, final boolean b) {
        Asserts.c(bitmap);
        this.a((Drawable)new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
