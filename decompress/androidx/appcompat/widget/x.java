// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.text.InputFilter;
import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.widget.TextView;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.ToggleButton;

public class x extends ToggleButton
{
    private final d a;
    private final v b;
    private j c;
    
    public x(final Context context, final AttributeSet set) {
        this(context, set, 16842827);
    }
    
    public x(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        m0.a((View)this, this.getContext());
        (this.a = new d((View)this)).e(set, n);
        (this.b = new v((TextView)this)).m(set, n);
        this.getEmojiTextViewHelper().c(set, n);
    }
    
    private j getEmojiTextViewHelper() {
        if (this.c == null) {
            this.c = new j((TextView)this);
        }
        return this.c;
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final d a = this.a;
        if (a != null) {
            a.b();
        }
        final v b = this.b;
        if (b != null) {
            b.b();
        }
    }
    
    public ColorStateList getSupportBackgroundTintList() {
        final d a = this.a;
        ColorStateList c;
        if (a != null) {
            c = a.c();
        }
        else {
            c = null;
        }
        return c;
    }
    
    public PorterDuff$Mode getSupportBackgroundTintMode() {
        final d a = this.a;
        PorterDuff$Mode d;
        if (a != null) {
            d = a.d();
        }
        else {
            d = null;
        }
        return d;
    }
    
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.b.j();
    }
    
    public PorterDuff$Mode getSupportCompoundDrawablesTintMode() {
        return this.b.k();
    }
    
    public void setAllCaps(final boolean allCaps) {
        super.setAllCaps(allCaps);
        this.getEmojiTextViewHelper().d(allCaps);
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        super.setBackgroundDrawable(backgroundDrawable);
        final d a = this.a;
        if (a != null) {
            a.f(backgroundDrawable);
        }
    }
    
    public void setBackgroundResource(final int backgroundResource) {
        super.setBackgroundResource(backgroundResource);
        final d a = this.a;
        if (a != null) {
            a.g(backgroundResource);
        }
    }
    
    public void setCompoundDrawables(final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        final v b = this.b;
        if (b != null) {
            b.p();
        }
    }
    
    public void setCompoundDrawablesRelative(final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        final v b = this.b;
        if (b != null) {
            b.p();
        }
    }
    
    public void setEmojiCompatEnabled(final boolean b) {
        this.getEmojiTextViewHelper().e(b);
    }
    
    public void setFilters(final InputFilter[] array) {
        super.setFilters(this.getEmojiTextViewHelper().a(array));
    }
    
    public void setSupportBackgroundTintList(final ColorStateList list) {
        final d a = this.a;
        if (a != null) {
            a.i(list);
        }
    }
    
    public void setSupportBackgroundTintMode(final PorterDuff$Mode porterDuff$Mode) {
        final d a = this.a;
        if (a != null) {
            a.j(porterDuff$Mode);
        }
    }
    
    public void setSupportCompoundDrawablesTintList(final ColorStateList list) {
        this.b.w(list);
        this.b.b();
    }
    
    public void setSupportCompoundDrawablesTintMode(final PorterDuff$Mode porterDuff$Mode) {
        this.b.x(porterDuff$Mode);
        this.b.b();
    }
}
