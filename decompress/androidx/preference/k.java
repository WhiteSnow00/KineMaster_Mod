// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import android.os.Bundle;
import androidx.core.view.accessibility.d;
import android.view.View;
import androidx.core.view.a;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.u;

@Deprecated
public class k extends u
{
    final RecyclerView c;
    final androidx.core.view.a d;
    final androidx.core.view.a e;
    
    public k(final RecyclerView c) {
        super(c);
        this.d = super.a();
        this.e = new androidx.core.view.a() {
            final k a;
            
            @Override
            public void onInitializeAccessibilityNodeInfo(final View view, final d d) {
                this.a.d.onInitializeAccessibilityNodeInfo(view, d);
                final int childAdapterPosition = this.a.c.getChildAdapterPosition(view);
                final RecyclerView.Adapter adapter = this.a.c.getAdapter();
                if (!(adapter instanceof h)) {
                    return;
                }
                final Preference o = ((h)adapter).o(childAdapterPosition);
                if (o == null) {
                    return;
                }
                o.f0(d);
            }
            
            @Override
            public boolean performAccessibilityAction(final View view, final int n, final Bundle bundle) {
                return this.a.d.performAccessibilityAction(view, n, bundle);
            }
        };
        this.c = c;
    }
    
    @Override
    public androidx.core.view.a a() {
        return this.e;
    }
}
