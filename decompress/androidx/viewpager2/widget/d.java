// 
// Decompiled by Procyon v0.6.0
// 

package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import java.util.Locale;
import androidx.recyclerview.widget.LinearLayoutManager;

final class d extends i
{
    private final LinearLayoutManager a;
    private k b;
    
    d(final LinearLayoutManager a) {
        this.a = a;
    }
    
    k a() {
        return this.b;
    }
    
    void b(final k b) {
        this.b = b;
    }
    
    @Override
    public void onPageScrollStateChanged(final int n) {
    }
    
    @Override
    public void onPageScrolled(final int n, float n2, int i) {
        if (this.b == null) {
            return;
        }
        final float n3 = -n2;
        View child;
        for (i = 0; i < ((RecyclerView.o)this.a).getChildCount(); ++i) {
            child = ((RecyclerView.o)this.a).getChildAt(i);
            if (child == null) {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", i, ((RecyclerView.o)this.a).getChildCount()));
            }
            n2 = (float)(((RecyclerView.o)this.a).getPosition(child) - n);
            this.b.a(child, n2 + n3);
        }
    }
    
    @Override
    public void onPageSelected(final int n) {
    }
}
