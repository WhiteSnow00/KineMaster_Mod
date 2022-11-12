// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.graphics.drawable;

import android.graphics.Outline;
import android.view.Gravity;
import android.graphics.Rect;
import android.graphics.Bitmap;
import android.content.res.Resources;

class c extends d
{
    protected c(final Resources resources, final Bitmap bitmap) {
        super(resources, bitmap);
    }
    
    @Override
    void c(final int n, final int n2, final int n3, final Rect rect, final Rect rect2) {
        Gravity.apply(n, n2, n3, rect, rect2, 0);
    }
    
    public void getOutline(final Outline outline) {
        this.h();
        outline.setRoundRect(super.h, this.b());
    }
}
