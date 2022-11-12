// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.content.Context;
import android.view.PointerIcon;

public final class z
{
    private final PointerIcon a;
    
    private z(final PointerIcon a) {
        this.a = a;
    }
    
    public static z b(final Context context, final int n) {
        return new z(a.b(context, n));
    }
    
    public Object a() {
        return this.a;
    }
    
    static class a
    {
        static PointerIcon a(final Bitmap bitmap, final float n, final float n2) {
            return PointerIcon.create(bitmap, n, n2);
        }
        
        static PointerIcon b(final Context context, final int n) {
            return PointerIcon.getSystemIcon(context, n);
        }
        
        static PointerIcon c(final Resources resources, final int n) {
            return PointerIcon.load(resources, n);
        }
    }
}
