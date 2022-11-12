// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.view.View;
import android.widget.AdapterView;
import android.view.MenuItem;
import androidx.appcompat.widget.r0;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements b, n, AdapterView$OnItemClickListener
{
    private static final int[] c;
    private g a;
    private int b;
    
    static {
        c = new int[] { 16842964, 16843049 };
    }
    
    public ExpandedMenuView(final Context context, final AttributeSet set) {
        this(context, set, 16842868);
    }
    
    public ExpandedMenuView(final Context context, final AttributeSet set, final int n) {
        super(context, set);
        this.setOnItemClickListener((AdapterView$OnItemClickListener)this);
        final r0 v = r0.v(context, set, ExpandedMenuView.c, n, 0);
        if (v.s(0)) {
            this.setBackgroundDrawable(v.g(0));
        }
        if (v.s(1)) {
            this.setDivider(v.g(1));
        }
        v.w();
    }
    
    public void a(final g a) {
        this.a = a;
    }
    
    public boolean d(final i i) {
        return this.a.N((MenuItem)i, 0);
    }
    
    public int getWindowAnimations() {
        return this.b;
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.setChildrenDrawingCacheEnabled(false);
    }
    
    public void onItemClick(final AdapterView adapterView, final View view, final int n, final long n2) {
        this.d((i)this.getAdapter().getItem(n));
    }
}
