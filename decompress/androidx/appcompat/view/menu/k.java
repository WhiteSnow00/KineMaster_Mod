// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.widget.PopupWindow$OnDismissListener;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.view.View$MeasureSpec;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.graphics.Rect;
import android.widget.AdapterView$OnItemClickListener;

abstract class k implements p, m, AdapterView$OnItemClickListener
{
    private Rect a;
    
    protected static int p(final ListAdapter listAdapter, final ViewGroup viewGroup, final Context context, final int n) {
        int i = 0;
        final int measureSpec = View$MeasureSpec.makeMeasureSpec(0, 0);
        final int measureSpec2 = View$MeasureSpec.makeMeasureSpec(0, 0);
        final int count = listAdapter.getCount();
        int n2 = 0;
        int n3 = 0;
        final View view = null;
        ViewGroup viewGroup2 = viewGroup;
        View view2 = view;
        while (i < count) {
            final int itemViewType = listAdapter.getItemViewType(i);
            int n4;
            if (itemViewType != (n4 = n3)) {
                view2 = null;
                n4 = itemViewType;
            }
            Object o;
            if ((o = viewGroup2) == null) {
                o = new FrameLayout(context);
            }
            view2 = listAdapter.getView(i, view2, (ViewGroup)o);
            view2.measure(measureSpec, measureSpec2);
            final int measuredWidth = view2.getMeasuredWidth();
            if (measuredWidth >= n) {
                return n;
            }
            int n5;
            if (measuredWidth > (n5 = n2)) {
                n5 = measuredWidth;
            }
            ++i;
            n2 = n5;
            n3 = n4;
            viewGroup2 = (ViewGroup)o;
        }
        return n2;
    }
    
    protected static boolean y(final g g) {
        final int size = g.size();
        final boolean b = false;
        int n = 0;
        boolean b2;
        while (true) {
            b2 = b;
            if (n >= size) {
                break;
            }
            final MenuItem item = g.getItem(n);
            if (item.isVisible() && item.getIcon() != null) {
                b2 = true;
                break;
            }
            ++n;
        }
        return b2;
    }
    
    protected static f z(final ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (f)((HeaderViewListAdapter)listAdapter).getWrappedAdapter();
        }
        return (f)listAdapter;
    }
    
    @Override
    public boolean c(final g g, final i i) {
        return false;
    }
    
    @Override
    public int getId() {
        return 0;
    }
    
    @Override
    public boolean j(final g g, final i i) {
        return false;
    }
    
    @Override
    public void k(final Context context, final g g) {
    }
    
    public abstract void l(final g p0);
    
    protected boolean m() {
        return true;
    }
    
    public Rect n() {
        return this.a;
    }
    
    public void onItemClick(final AdapterView<?> adapterView, final View view, int n, final long n2) {
        final ListAdapter listAdapter = (ListAdapter)adapterView.getAdapter();
        final g a = z(listAdapter).a;
        final MenuItem menuItem = (MenuItem)listAdapter.getItem(n);
        if (this.m()) {
            n = 0;
        }
        else {
            n = 4;
        }
        a.O(menuItem, this, n);
    }
    
    public abstract void q(final View p0);
    
    public void r(final Rect a) {
        this.a = a;
    }
    
    public abstract void s(final boolean p0);
    
    public abstract void t(final int p0);
    
    public abstract void u(final int p0);
    
    public abstract void v(final PopupWindow$OnDismissListener p0);
    
    public abstract void w(final boolean p0);
    
    public abstract void x(final int p0);
}
