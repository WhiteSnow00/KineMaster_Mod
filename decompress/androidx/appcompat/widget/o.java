// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.view.View;
import androidx.core.widget.m;
import d.j;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.PopupWindow;

class o extends PopupWindow
{
    private static final boolean b;
    private boolean a;
    
    static {
        b = false;
    }
    
    public o(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.a(context, set, n, n2);
    }
    
    private void a(final Context context, final AttributeSet set, int a2, final int n) {
        final r0 v = r0.v(context, set, j.Y1, a2, n);
        a2 = j.a2;
        if (v.s(a2)) {
            this.b(v.a(a2, false));
        }
        this.setBackgroundDrawable(v.g(j.Z1));
        v.w();
    }
    
    private void b(final boolean a) {
        if (o.b) {
            this.a = a;
        }
        else {
            m.a(this, a);
        }
    }
    
    public void showAsDropDown(final View view, final int n, final int n2) {
        int n3 = n2;
        if (o.b) {
            n3 = n2;
            if (this.a) {
                n3 = n2 - view.getHeight();
            }
        }
        super.showAsDropDown(view, n, n3);
    }
    
    public void showAsDropDown(final View view, final int n, final int n2, final int n3) {
        int n4 = n2;
        if (o.b) {
            n4 = n2;
            if (this.a) {
                n4 = n2 - view.getHeight();
            }
        }
        super.showAsDropDown(view, n, n4, n3);
    }
    
    public void update(final View view, final int n, final int n2, final int n3, final int n4) {
        int n5 = n2;
        if (o.b) {
            n5 = n2;
            if (this.a) {
                n5 = n2 - view.getHeight();
            }
        }
        super.update(view, n, n5, n3, n4);
    }
}
