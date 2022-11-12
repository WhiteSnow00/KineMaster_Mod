// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.graphics.Rect;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.FrameLayout;

public class FitWindowsFrameLayout extends FrameLayout
{
    private c0 a;
    
    public FitWindowsFrameLayout(final Context context, final AttributeSet set) {
        super(context, set);
    }
    
    protected boolean fitSystemWindows(final Rect rect) {
        final c0 a = this.a;
        if (a != null) {
            a.a(rect);
        }
        return super.fitSystemWindows(rect);
    }
    
    public void setOnFitSystemWindowsListener(final c0 a) {
        this.a = a;
    }
}
