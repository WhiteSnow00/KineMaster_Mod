// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.EditorInfo;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.text.method.KeyListener;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import d.a;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.MultiAutoCompleteTextView;

public class n extends MultiAutoCompleteTextView
{
    private static final int[] d;
    private final d a;
    private final v b;
    private final i c;
    
    static {
        d = new int[] { 16843126 };
    }
    
    public n(final Context context, final AttributeSet set) {
        this(context, set, d.a.p);
    }
    
    public n(final Context context, final AttributeSet set, final int n) {
        super(o0.b(context), set, n);
        m0.a((View)this, this.getContext());
        final r0 v = r0.v(this.getContext(), set, n.d, n, 0);
        if (v.s(0)) {
            this.setDropDownBackgroundDrawable(v.g(0));
        }
        v.w();
        (this.a = new d((View)this)).e(set, n);
        final v b = new v((TextView)this);
        (this.b = b).m(set, n);
        b.b();
        final i c = new i((EditText)this);
        (this.c = c).d(set, n);
        this.a(c);
    }
    
    void a(final i i) {
        final KeyListener keyListener = this.getKeyListener();
        if (i.b(keyListener)) {
            final boolean focusable = super.isFocusable();
            final boolean clickable = super.isClickable();
            final boolean longClickable = super.isLongClickable();
            final int inputType = super.getInputType();
            final KeyListener a = i.a(keyListener);
            if (a == keyListener) {
                return;
            }
            super.setKeyListener(a);
            super.setRawInputType(inputType);
            super.setFocusable(focusable);
            super.setClickable(clickable);
            super.setLongClickable(longClickable);
        }
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
    
    public InputConnection onCreateInputConnection(final EditorInfo editorInfo) {
        return this.c.e(k.a(super.onCreateInputConnection(editorInfo), editorInfo, (View)this), editorInfo);
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
    
    public void setDropDownBackgroundResource(final int n) {
        this.setDropDownBackgroundDrawable(e.a.b(this.getContext(), n));
    }
    
    public void setEmojiCompatEnabled(final boolean b) {
        this.c.f(b);
    }
    
    public void setKeyListener(final KeyListener keyListener) {
        super.setKeyListener(this.c.a(keyListener));
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
    
    public void setTextAppearance(final Context context, final int n) {
        super.setTextAppearance(context, n);
        final v b = this.b;
        if (b != null) {
            b.q(context, n);
        }
    }
}
