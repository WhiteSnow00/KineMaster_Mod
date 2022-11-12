// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.util.AttributeSet;
import android.content.Context;
import android.widget.LinearLayout;

public class ActivityChooserView$InnerLayout extends LinearLayout
{
    private static final int[] a;
    
    static {
        a = new int[] { 16842964 };
    }
    
    public ActivityChooserView$InnerLayout(final Context context, final AttributeSet set) {
        super(context, set);
        final r0 u = r0.u(context, set, ActivityChooserView$InnerLayout.a);
        this.setBackgroundDrawable(u.g(0));
        u.w();
    }
}
