// 
// Decompiled by Procyon v0.6.0
// 

package androidx.preference;

import androidx.core.view.b0;
import android.widget.TextView;
import android.view.View;
import android.util.SparseArray;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.RecyclerView;

public class l extends c0
{
    private final Drawable a;
    private ColorStateList b;
    private final SparseArray<View> c;
    private boolean d;
    private boolean e;
    
    l(final View view) {
        super(view);
        final SparseArray c = new SparseArray(4);
        this.c = (SparseArray<View>)c;
        final TextView textView = (TextView)view.findViewById(16908310);
        c.put(16908310, (Object)textView);
        c.put(16908304, (Object)view.findViewById(16908304));
        c.put(16908294, (Object)view.findViewById(16908294));
        final int a = androidx.preference.o.a;
        c.put(a, (Object)view.findViewById(a));
        c.put(16908350, (Object)view.findViewById(16908350));
        this.a = view.getBackground();
        if (textView != null) {
            this.b = textView.getTextColors();
        }
    }
    
    public View a(final int n) {
        final View view = (View)this.c.get(n);
        if (view != null) {
            return view;
        }
        final View viewById = super.itemView.findViewById(n);
        if (viewById != null) {
            this.c.put(n, (Object)viewById);
        }
        return viewById;
    }
    
    public boolean b() {
        return this.d;
    }
    
    public boolean c() {
        return this.e;
    }
    
    void d() {
        final Drawable background = super.itemView.getBackground();
        final Drawable a = this.a;
        if (background != a) {
            androidx.core.view.b0.t0(super.itemView, a);
        }
        final TextView textView = (TextView)this.a(16908310);
        if (textView != null && this.b != null && !textView.getTextColors().equals(this.b)) {
            textView.setTextColor(this.b);
        }
    }
    
    public void e(final boolean d) {
        this.d = d;
    }
    
    public void f(final boolean e) {
        this.e = e;
    }
}
