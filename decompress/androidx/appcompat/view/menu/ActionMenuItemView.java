// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.view.menu;

import android.view.MotionEvent;
import android.os.Parcelable;
import android.view.View$MeasureSpec;
import android.widget.Button;
import android.view.View;
import androidx.appcompat.widget.u0;
import android.text.TextUtils;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.content.res.Resources;
import d.j;
import android.util.AttributeSet;
import android.content.Context;
import androidx.appcompat.widget.d0;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionMenuView;
import android.view.View$OnClickListener;
import androidx.appcompat.widget.AppCompatTextView;

public class ActionMenuItemView extends AppCompatTextView implements n.a, View$OnClickListener, ActionMenuView.a
{
    private int A;
    private int B;
    i g;
    private CharSequence h;
    private Drawable i;
    g.b j;
    private d0 p;
    b w;
    private boolean x;
    private boolean y;
    private int z;
    
    public ActionMenuItemView(final Context context, final AttributeSet set) {
        this(context, set, 0);
    }
    
    public ActionMenuItemView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        final Resources resources = context.getResources();
        this.x = this.g();
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, d.j.v, n, 0);
        this.z = obtainStyledAttributes.getDimensionPixelSize(d.j.w, 0);
        obtainStyledAttributes.recycle();
        this.B = (int)(resources.getDisplayMetrics().density * 32.0f + 0.5f);
        this.setOnClickListener((View$OnClickListener)this);
        this.A = -1;
        this.setSaveEnabled(false);
    }
    
    private boolean g() {
        final Configuration configuration = this.getContext().getResources().getConfiguration();
        final int screenWidthDp = configuration.screenWidthDp;
        final int screenHeightDp = configuration.screenHeightDp;
        return screenWidthDp >= 480 || (screenWidthDp >= 640 && screenHeightDp >= 480) || configuration.orientation == 2;
    }
    
    private void h() {
        final boolean empty = TextUtils.isEmpty(this.h);
        boolean b2;
        final boolean b = b2 = true;
        Label_0052: {
            if (this.i != null) {
                if (this.g.B()) {
                    b2 = b;
                    if (this.x) {
                        break Label_0052;
                    }
                    if (this.y) {
                        b2 = b;
                        break Label_0052;
                    }
                }
                b2 = false;
            }
        }
        final boolean b3 = (empty ^ true) & b2;
        final CharSequence charSequence = null;
        CharSequence h;
        if (b3) {
            h = this.h;
        }
        else {
            h = null;
        }
        this.setText(h);
        final CharSequence contentDescription = this.g.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            CharSequence title;
            if (b3) {
                title = null;
            }
            else {
                title = this.g.getTitle();
            }
            this.setContentDescription(title);
        }
        else {
            this.setContentDescription(contentDescription);
        }
        final CharSequence tooltipText = this.g.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            CharSequence title2;
            if (b3) {
                title2 = charSequence;
            }
            else {
                title2 = this.g.getTitle();
            }
            u0.a((View)this, title2);
        }
        else {
            u0.a((View)this, tooltipText);
        }
    }
    
    public boolean a() {
        return this.f();
    }
    
    public boolean b() {
        return this.f() && this.g.getIcon() == null;
    }
    
    @Override
    public void c(final i g, int visibility) {
        this.g = g;
        this.setIcon(g.getIcon());
        this.setTitle(g.i(this));
        this.setId(g.getItemId());
        if (g.isVisible()) {
            visibility = 0;
        }
        else {
            visibility = 8;
        }
        this.setVisibility(visibility);
        this.setEnabled(g.isEnabled());
        if (g.hasSubMenu() && this.p == null) {
            this.p = new a();
        }
    }
    
    @Override
    public boolean e() {
        return true;
    }
    
    public boolean f() {
        return TextUtils.isEmpty(this.getText()) ^ true;
    }
    
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }
    
    @Override
    public i getItemData() {
        return this.g;
    }
    
    public void onClick(final View view) {
        final g.b j = this.j;
        if (j != null) {
            j.d(this.g);
        }
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.x = this.g();
        this.h();
    }
    
    @Override
    protected void onMeasure(int n, final int n2) {
        final boolean f = this.f();
        if (f) {
            final int a = this.A;
            if (a >= 0) {
                super.setPadding(a, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
            }
        }
        super.onMeasure(n, n2);
        final int mode = View$MeasureSpec.getMode(n);
        n = View$MeasureSpec.getSize(n);
        final int measuredWidth = this.getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            n = Math.min(n, this.z);
        }
        else {
            n = this.z;
        }
        if (mode != 1073741824 && this.z > 0 && measuredWidth < n) {
            super.onMeasure(View$MeasureSpec.makeMeasureSpec(n, 1073741824), n2);
        }
        if (!f && this.i != null) {
            super.setPadding((this.getMeasuredWidth() - this.i.getBounds().width()) / 2, this.getPaddingTop(), this.getPaddingRight(), this.getPaddingBottom());
        }
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable)null);
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.g.hasSubMenu()) {
            final d0 p = this.p;
            if (p != null && p.onTouch((View)this, motionEvent)) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
    
    public void setCheckable(final boolean b) {
    }
    
    public void setChecked(final boolean b) {
    }
    
    public void setExpandedFormat(final boolean y) {
        if (this.y != y) {
            this.y = y;
            final i g = this.g;
            if (g != null) {
                g.c();
            }
        }
    }
    
    public void setIcon(final Drawable i) {
        this.i = i;
        if (i != null) {
            final int intrinsicWidth = i.getIntrinsicWidth();
            final int intrinsicHeight = i.getIntrinsicHeight();
            int b = this.B;
            int n = intrinsicWidth;
            int n2 = intrinsicHeight;
            if (intrinsicWidth > b) {
                n2 = (int)(intrinsicHeight * (b / (float)intrinsicWidth));
                n = b;
            }
            if (n2 > b) {
                n *= (int)(b / (float)n2);
            }
            else {
                b = n2;
            }
            i.setBounds(0, 0, n, b);
        }
        this.setCompoundDrawables(i, null, null, null);
        this.h();
    }
    
    public void setItemInvoker(final g.b j) {
        this.j = j;
    }
    
    public void setPadding(final int a, final int n, final int n2, final int n3) {
        super.setPadding(this.A = a, n, n2, n3);
    }
    
    public void setPopupCallback(final b w) {
        this.w = w;
    }
    
    public void setTitle(final CharSequence h) {
        this.h = h;
        this.h();
    }
    
    private class a extends d0
    {
        final ActionMenuItemView j;
        
        public a(final ActionMenuItemView j) {
            super((View)(this.j = j));
        }
        
        @Override
        public p b() {
            final ActionMenuItemView.b w = this.j.w;
            if (w != null) {
                return w.a();
            }
            return null;
        }
        
        @Override
        protected boolean c() {
            final ActionMenuItemView j = this.j;
            final g.b i = j.j;
            boolean b2;
            final boolean b = b2 = false;
            if (i != null) {
                b2 = b;
                if (i.d(j.g)) {
                    final p b3 = this.b();
                    b2 = b;
                    if (b3 != null) {
                        b2 = b;
                        if (b3.a()) {
                            b2 = true;
                        }
                    }
                }
            }
            return b2;
        }
    }
    
    public abstract static class b
    {
        public abstract p a();
    }
}
