// 
// Decompiled by Procyon v0.6.0
// 

package androidx.viewpager2.adapter;

import androidx.core.view.b0;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;

public final class a extends c0
{
    private a(final FrameLayout frameLayout) {
        super((View)frameLayout);
    }
    
    static a a(final ViewGroup viewGroup) {
        final FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup$LayoutParams(-1, -1));
        frameLayout.setId(androidx.core.view.b0.k());
        frameLayout.setSaveEnabled(false);
        return new a(frameLayout);
    }
    
    FrameLayout b() {
        return (FrameLayout)super.itemView;
    }
}
