// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.widget;

import android.view.View;
import android.widget.ListView;

public class k extends a
{
    private final ListView D;
    
    public k(final ListView d) {
        super((View)d);
        this.D = d;
    }
    
    @Override
    public boolean a(final int n) {
        return false;
    }
    
    @Override
    public boolean b(final int n) {
        final ListView d = this.D;
        final int count = d.getCount();
        if (count == 0) {
            return false;
        }
        final int childCount = d.getChildCount();
        final int firstVisiblePosition = d.getFirstVisiblePosition();
        if (n > 0) {
            if (firstVisiblePosition + childCount >= count && d.getChildAt(childCount - 1).getBottom() <= d.getHeight()) {
                return false;
            }
        }
        else {
            if (n >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && d.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void j(final int n, final int n2) {
        l.b(this.D, n2);
    }
}
