// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.EditorInfo;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import androidx.core.widget.n;
import android.view.ActionMode$Callback;
import android.widget.TextView;
import android.view.View;
import d.a;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.CheckedTextView;

public class e extends CheckedTextView
{
    private final f a;
    private final d b;
    private final v c;
    private j d;
    
    public e(final Context context, final AttributeSet set) {
        this(context, set, d.a.s);
    }
    
    public e(final Context context, final AttributeSet set, final int n) {
        super(o0.b(context), set, n);
        m0.a((View)this, this.getContext());
        final v c = new v((TextView)this);
        (this.c = c).m(set, n);
        c.b();
        (this.b = new d((View)this)).e(set, n);
        (this.a = new f(this)).d(set, n);
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
        final v c = this.c;
        if (c != null) {
            c.b();
        }
        final d b = this.b;
        if (b != null) {
            b.b();
        }
        final f a = this.a;
        if (a != null) {
            a.a();
        }
    }
    
    public ActionMode$Callback getCustomSelectionActionModeCallback() {
        return n.s(super.getCustomSelectionActionModeCallback());
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
    
    public ColorStateList getSupportCheckMarkTintList() {
        final f a = this.a;
        ColorStateList b;
        if (a != null) {
            b = a.b();
        }
        else {
            b = null;
        }
        return b;
    }
    
    public PorterDuff$Mode getSupportCheckMarkTintMode() {
        final f a = this.a;
        PorterDuff$Mode c;
        if (a != null) {
            c = a.c();
        }
        else {
            c = null;
        }
        return c;
    }
    
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.c.j();
    }
    
    public PorterDuff$Mode getSupportCompoundDrawablesTintMode() {
        return this.c.k();
    }
    
    public InputConnection onCreateInputConnection(final EditorInfo editorInfo) {
        return k.a(super.onCreateInputConnection(editorInfo), editorInfo, (View)this);
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
    
    public void setCheckMarkDrawable(final int n) {
        this.setCheckMarkDrawable(e.a.b(this.getContext(), n));
    }
    
    public void setCheckMarkDrawable(final Drawable checkMarkDrawable) {
        super.setCheckMarkDrawable(checkMarkDrawable);
        final f a = this.a;
        if (a != null) {
            a.e();
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
    
    public void setCustomSelectionActionModeCallback(final ActionMode$Callback actionMode$Callback) {
        super.setCustomSelectionActionModeCallback(n.t((TextView)this, actionMode$Callback));
    }
    
    public void setEmojiCompatEnabled(final boolean b) {
        this.getEmojiTextViewHelper().e(b);
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
    
    public void setSupportCheckMarkTintList(final ColorStateList list) {
        final f a = this.a;
        if (a != null) {
            a.f(list);
        }
    }
    
    public void setSupportCheckMarkTintMode(final PorterDuff$Mode porterDuff$Mode) {
        final f a = this.a;
        if (a != null) {
            a.g(porterDuff$Mode);
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
    
    public void setTextAppearance(final Context context, final int n) {
        super.setTextAppearance(context, n);
        final v c = this.c;
        if (c != null) {
            c.q(context, n);
        }
    }
}
