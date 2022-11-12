// 
// Decompiled by Procyon v0.6.0
// 

package androidx.browser.browseractions;

import android.view.View$MeasureSpec;
import l.a;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.LinearLayout;

@Deprecated
public class BrowserActionsFallbackMenuView extends LinearLayout
{
    private final int a;
    private final int b;
    
    public BrowserActionsFallbackMenuView(final Context context, final AttributeSet set) {
        super(context, set);
        this.a = this.getResources().getDimensionPixelOffset(l.a.b);
        this.b = this.getResources().getDimensionPixelOffset(l.a.a);
    }
    
    protected void onMeasure(final int n, final int n2) {
        super.onMeasure(View$MeasureSpec.makeMeasureSpec(Math.min(this.getResources().getDisplayMetrics().widthPixels - this.a * 2, this.b), 1073741824), n2);
    }
}
