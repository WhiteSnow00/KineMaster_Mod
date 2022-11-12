// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.widget.CompoundButton;
import android.view.ViewGroup$LayoutParams;
import d.f;
import androidx.core.view.b0;
import android.widget.LinearLayout$LayoutParams;
import android.graphics.Rect;
import android.view.ViewGroup;
import d.g;
import android.view.View;
import android.content.res.TypedArray;
import android.content.res.Resources$Theme;
import androidx.appcompat.widget.r0;
import d.j;
import d.a;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.widget.AbsListView$SelectionBoundsAdjuster;
import android.widget.LinearLayout;

public class ListMenuItemView extends LinearLayout implements a, AbsListView$SelectionBoundsAdjuster
{
    private LayoutInflater A;
    private boolean B;
    private i a;
    private ImageView b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private LinearLayout i;
    private Drawable j;
    private int p;
    private Context w;
    private boolean x;
    private Drawable y;
    private boolean z;
    
    public ListMenuItemView(final Context context, final AttributeSet set) {
        this(context, set, d.a.E);
    }
    
    public ListMenuItemView(final Context w, final AttributeSet set, int b) {
        super(w, set);
        final r0 v = r0.v(this.getContext(), set, d.j.T1, b, 0);
        this.j = v.g(d.j.V1);
        this.p = v.n(d.j.U1, -1);
        this.x = v.a(d.j.W1, false);
        this.w = w;
        this.y = v.g(d.j.X1);
        final Resources$Theme theme = w.getTheme();
        b = d.a.B;
        final TypedArray obtainStyledAttributes = theme.obtainStyledAttributes((AttributeSet)null, new int[] { 16843049 }, b, 0);
        this.z = obtainStyledAttributes.hasValue(0);
        v.w();
        obtainStyledAttributes.recycle();
    }
    
    private void a(final View view) {
        this.b(view, -1);
    }
    
    private void b(final View view, final int n) {
        final LinearLayout i = this.i;
        if (i != null) {
            i.addView(view, n);
        }
        else {
            this.addView(view, n);
        }
    }
    
    private void d() {
        this.a((View)(this.e = (CheckBox)this.getInflater().inflate(d.g.h, (ViewGroup)this, false)));
    }
    
    private void f() {
        this.b((View)(this.b = (ImageView)this.getInflater().inflate(d.g.i, (ViewGroup)this, false)), 0);
    }
    
    private void g() {
        this.a((View)(this.c = (RadioButton)this.getInflater().inflate(d.g.k, (ViewGroup)this, false)));
    }
    
    private LayoutInflater getInflater() {
        if (this.A == null) {
            this.A = LayoutInflater.from(this.getContext());
        }
        return this.A;
    }
    
    private void setSubMenuArrowVisible(final boolean b) {
        final ImageView g = this.g;
        if (g != null) {
            int visibility;
            if (b) {
                visibility = 0;
            }
            else {
                visibility = 8;
            }
            g.setVisibility(visibility);
        }
    }
    
    public void adjustListItemSelectionBounds(final Rect rect) {
        final ImageView h = this.h;
        if (h != null && h.getVisibility() == 0) {
            final LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams)this.h.getLayoutParams();
            rect.top += this.h.getHeight() + linearLayout$LayoutParams.topMargin + linearLayout$LayoutParams.bottomMargin;
        }
    }
    
    public void c(final i a, int visibility) {
        this.a = a;
        if (a.isVisible()) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        this.setVisibility(visibility);
        this.setTitle(a.i(this));
        this.setCheckable(a.isCheckable());
        this.h(a.A(), a.g());
        this.setIcon(a.getIcon());
        this.setEnabled(a.isEnabled());
        this.setSubMenuArrowVisible(a.hasSubMenu());
        this.setContentDescription(a.getContentDescription());
    }
    
    public boolean e() {
        return false;
    }
    
    public i getItemData() {
        return this.a;
    }
    
    public void h(final boolean b, final char c) {
        int visibility;
        if (b && this.a.A()) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        if (visibility == 0) {
            this.f.setText((CharSequence)this.a.h());
        }
        if (this.f.getVisibility() != visibility) {
            this.f.setVisibility(visibility);
        }
    }
    
    protected void onFinishInflate() {
        super.onFinishInflate();
        b0.t0((View)this, this.j);
        final TextView d = (TextView)this.findViewById(d.f.L);
        this.d = d;
        final int p = this.p;
        if (p != -1) {
            d.setTextAppearance(this.w, p);
        }
        this.f = (TextView)this.findViewById(d.f.E);
        final ImageView g = (ImageView)this.findViewById(d.f.H);
        if ((this.g = g) != null) {
            g.setImageDrawable(this.y);
        }
        this.h = (ImageView)this.findViewById(d.f.r);
        this.i = (LinearLayout)this.findViewById(d.f.l);
    }
    
    protected void onMeasure(final int n, final int n2) {
        if (this.b != null && this.x) {
            final ViewGroup$LayoutParams layoutParams = this.getLayoutParams();
            final LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams)this.b.getLayoutParams();
            final int height = layoutParams.height;
            if (height > 0 && linearLayout$LayoutParams.width <= 0) {
                linearLayout$LayoutParams.width = height;
            }
        }
        super.onMeasure(n, n2);
    }
    
    public void setCheckable(final boolean b) {
        if (!b && this.c == null && this.e == null) {
            return;
        }
        Object o;
        Object o2;
        if (this.a.m()) {
            if (this.c == null) {
                this.g();
            }
            o = this.c;
            o2 = this.e;
        }
        else {
            if (this.e == null) {
                this.d();
            }
            o = this.e;
            o2 = this.c;
        }
        if (b) {
            ((CompoundButton)o).setChecked(this.a.isChecked());
            if (((CompoundButton)o).getVisibility() != 0) {
                ((CompoundButton)o).setVisibility(0);
            }
            if (o2 != null && ((CompoundButton)o2).getVisibility() != 8) {
                ((CompoundButton)o2).setVisibility(8);
            }
        }
        else {
            final CheckBox e = this.e;
            if (e != null) {
                e.setVisibility(8);
            }
            final RadioButton c = this.c;
            if (c != null) {
                c.setVisibility(8);
            }
        }
    }
    
    public void setChecked(final boolean checked) {
        Object o;
        if (this.a.m()) {
            if (this.c == null) {
                this.g();
            }
            o = this.c;
        }
        else {
            if (this.e == null) {
                this.d();
            }
            o = this.e;
        }
        ((CompoundButton)o).setChecked(checked);
    }
    
    public void setForceShowIcon(final boolean b) {
        this.B = b;
        this.x = b;
    }
    
    public void setGroupDividerEnabled(final boolean b) {
        final ImageView h = this.h;
        if (h != null) {
            int visibility;
            if (!this.z && b) {
                visibility = 0;
            }
            else {
                visibility = 8;
            }
            h.setVisibility(visibility);
        }
    }
    
    public void setIcon(Drawable imageDrawable) {
        final boolean b = this.a.z() || this.B;
        if (!b && !this.x) {
            return;
        }
        final ImageView b2 = this.b;
        if (b2 == null && imageDrawable == null && !this.x) {
            return;
        }
        if (b2 == null) {
            this.f();
        }
        if (imageDrawable == null && !this.x) {
            this.b.setVisibility(8);
        }
        else {
            final ImageView b3 = this.b;
            if (!b) {
                imageDrawable = null;
            }
            b3.setImageDrawable(imageDrawable);
            if (this.b.getVisibility() != 0) {
                this.b.setVisibility(0);
            }
        }
    }
    
    public void setTitle(final CharSequence text) {
        if (text != null) {
            this.d.setText(text);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        }
        else if (this.d.getVisibility() != 8) {
            this.d.setVisibility(8);
        }
    }
}
