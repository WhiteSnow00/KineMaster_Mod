// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.text.InputFilter;
import android.graphics.drawable.Drawable;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.widget.TextView;
import android.widget.CompoundButton;
import android.view.View;
import d.a;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.RadioButton;

public class q extends RadioButton
{
    private final g a;
    private final d b;
    private final v c;
    private j d;
    
    public q(final Context context, final AttributeSet set) {
        this(context, set, d.a.H);
    }
    
    public q(final Context context, final AttributeSet set, final int n) {
        super(o0.b(context), set, n);
        m0.a((View)this, this.getContext());
        (this.a = new g((CompoundButton)this)).e(set, n);
        (this.b = new d((View)this)).e(set, n);
        (this.c = new v((TextView)this)).m(set, n);
        this.getEmojiTextViewHelper().c(set, n);
    }
    
    private j getEmojiTextViewHelper() {
        if (this.d == null) {
            this.d = new j((TextView)this);
        }
        return this.d;
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final d b = this.b;
        if (b != null) {
            b.b();
        }
        final v c = this.c;
        if (c != null) {
            c.b();
        }
    }
    
    public int getCompoundPaddingLeft() {
        final int compoundPaddingLeft = super.getCompoundPaddingLeft();
        final g a = this.a;
        int b = compoundPaddingLeft;
        if (a != null) {
            b = a.b(compoundPaddingLeft);
        }
        return b;
    }
    
    public ColorStateList getSupportBackgroundTintList() {
        final d b = this.b;
        ColorStateList c;
        if (b != null) {
            c = b.c();
        }
        else {
            c = null;
        }
        return c;
    }
    
    public PorterDuff$Mode getSupportBackgroundTintMode() {
        final d b = this.b;
        PorterDuff$Mode d;
        if (b != null) {
            d = b.d();
        }
        else {
            d = null;
        }
        return d;
    }
    
    public ColorStateList getSupportButtonTintList() {
        final g a = this.a;
        ColorStateList c;
        if (a != null) {
            c = a.c();
        }
        else {
            c = null;
        }
        return c;
    }
    
    public PorterDuff$Mode getSupportButtonTintMode() {
        final g a = this.a;
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
        return this.c.j();
    }
    
    public PorterDuff$Mode getSupportCompoundDrawablesTintMode() {
        return this.c.k();
    }
    
    public void setAllCaps(final boolean allCaps) {
        super.setAllCaps(allCaps);
        this.getEmojiTextViewHelper().d(allCaps);
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        super.setBackgroundDrawable(backgroundDrawable);
        final d b = this.b;
        if (b != null) {
            b.f(backgroundDrawable);
        }
    }
    
    public void setBackgroundResource(final int backgroundResource) {
        super.setBackgroundResource(backgroundResource);
        final d b = this.b;
        if (b != null) {
            b.g(backgroundResource);
        }
    }
    
    public void setButtonDrawable(final int n) {
        this.setButtonDrawable(e.a.b(this.getContext(), n));
    }
    
    public void setButtonDrawable(final Drawable buttonDrawable) {
        super.setButtonDrawable(buttonDrawable);
        final g a = this.a;
        if (a != null) {
            a.f();
        }
    }
    
    public void setCompoundDrawables(final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        final v c = this.c;
        if (c != null) {
            c.p();
        }
    }
    
    public void setCompoundDrawablesRelative(final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        final v c = this.c;
        if (c != null) {
            c.p();
        }
    }
    
    public void setEmojiCompatEnabled(final boolean b) {
        this.getEmojiTextViewHelper().e(b);
    }
    
    public void setFilters(final InputFilter[] array) {
        super.setFilters(this.getEmojiTextViewHelper().a(array));
    }
    
    public void setSupportBackgroundTintList(final ColorStateList list) {
        final d b = this.b;
        if (b != null) {
            b.i(list);
        }
    }
    
    public void setSupportBackgroundTintMode(final PorterDuff$Mode porterDuff$Mode) {
        final d b = this.b;
        if (b != null) {
            b.j(porterDuff$Mode);
        }
    }
    
    public void setSupportButtonTintList(final ColorStateList list) {
        final g a = this.a;
        if (a != null) {
            a.g(list);
        }
    }
    
    public void setSupportButtonTintMode(final PorterDuff$Mode porterDuff$Mode) {
        final g a = this.a;
        if (a != null) {
            a.h(porterDuff$Mode);
        }
    }
    
    public void setSupportCompoundDrawablesTintList(final ColorStateList list) {
        this.c.w(list);
        this.c.b();
    }
    
    public void setSupportCompoundDrawablesTintMode(final PorterDuff$Mode porterDuff$Mode) {
        this.c.x(porterDuff$Mode);
        this.c.b();
    }
}
