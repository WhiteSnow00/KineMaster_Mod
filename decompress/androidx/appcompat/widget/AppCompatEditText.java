// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import y.c;
import androidx.core.view.b0;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.EditorInfo;
import android.text.method.KeyListener;
import android.view.textclassifier.TextClassifier;
import android.os.Build$VERSION;
import android.text.Editable;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import androidx.core.widget.n;
import android.view.ActionMode$Callback;
import android.widget.TextView;
import android.view.View;
import d.a;
import android.util.AttributeSet;
import android.content.Context;
import androidx.core.widget.o;
import androidx.core.view.x;
import android.widget.EditText;

public class AppCompatEditText extends EditText implements x
{
    private final i mAppCompatEmojiEditTextHelper;
    private final d mBackgroundTintHelper;
    private final o mDefaultOnReceiveContentListener;
    private final u mTextClassifierHelper;
    private final v mTextHelper;
    
    public AppCompatEditText(final Context context) {
        this(context, null);
    }
    
    public AppCompatEditText(final Context context, final AttributeSet set) {
        this(context, set, a.C);
    }
    
    public AppCompatEditText(final Context context, final AttributeSet set, final int n) {
        super(o0.b(context), set, n);
        m0.a((View)this, this.getContext());
        (this.mBackgroundTintHelper = new d((View)this)).e(set, n);
        final v mTextHelper = new v((TextView)this);
        (this.mTextHelper = mTextHelper).m(set, n);
        mTextHelper.b();
        this.mTextClassifierHelper = new u((TextView)this);
        this.mDefaultOnReceiveContentListener = new o();
        final i mAppCompatEmojiEditTextHelper = new i(this);
        (this.mAppCompatEmojiEditTextHelper = mAppCompatEmojiEditTextHelper).d(set, n);
        this.initEmojiKeyListener(mAppCompatEmojiEditTextHelper);
    }
    
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final d mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.b();
        }
        final v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            mTextHelper.b();
        }
    }
    
    public ActionMode$Callback getCustomSelectionActionModeCallback() {
        return n.s(super.getCustomSelectionActionModeCallback());
    }
    
    public ColorStateList getSupportBackgroundTintList() {
        final d mBackgroundTintHelper = this.mBackgroundTintHelper;
        ColorStateList c;
        if (mBackgroundTintHelper != null) {
            c = mBackgroundTintHelper.c();
        }
        else {
            c = null;
        }
        return c;
    }
    
    public PorterDuff$Mode getSupportBackgroundTintMode() {
        final d mBackgroundTintHelper = this.mBackgroundTintHelper;
        PorterDuff$Mode d;
        if (mBackgroundTintHelper != null) {
            d = mBackgroundTintHelper.d();
        }
        else {
            d = null;
        }
        return d;
    }
    
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j();
    }
    
    public PorterDuff$Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k();
    }
    
    public Editable getText() {
        if (Build$VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }
    
    public /* bridge */ CharSequence getText() {
        return (CharSequence)this.getText();
    }
    
    public TextClassifier getTextClassifier() {
        if (Build$VERSION.SDK_INT < 28) {
            final u mTextClassifierHelper = this.mTextClassifierHelper;
            if (mTextClassifierHelper != null) {
                return mTextClassifierHelper.a();
            }
        }
        return super.getTextClassifier();
    }
    
    void initEmojiKeyListener(final i i) {
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
    
    public boolean isEmojiCompatEnabled() {
        return this.mAppCompatEmojiEditTextHelper.c();
    }
    
    public InputConnection onCreateInputConnection(final EditorInfo editorInfo) {
        final InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.r((TextView)this, onCreateInputConnection, editorInfo);
        InputConnection inputConnection2;
        final InputConnection inputConnection = inputConnection2 = k.a(onCreateInputConnection, editorInfo, (View)this);
        if (inputConnection != null) {
            inputConnection2 = inputConnection;
            if (Build$VERSION.SDK_INT <= 30) {
                final String[] e = b0.E((View)this);
                inputConnection2 = inputConnection;
                if (e != null) {
                    y.a.c(editorInfo, e);
                    inputConnection2 = c.c((View)this, inputConnection, editorInfo);
                }
            }
        }
        return this.mAppCompatEmojiEditTextHelper.e(inputConnection2, editorInfo);
    }
    
    public boolean onDragEvent(final DragEvent dragEvent) {
        return s.a((View)this, dragEvent) || super.onDragEvent(dragEvent);
    }
    
    public androidx.core.view.c onReceiveContent(final androidx.core.view.c c) {
        return this.mDefaultOnReceiveContentListener.a((View)this, c);
    }
    
    public boolean onTextContextMenuItem(final int n) {
        return s.b((TextView)this, n) || super.onTextContextMenuItem(n);
    }
    
    public void setBackgroundDrawable(final Drawable backgroundDrawable) {
        super.setBackgroundDrawable(backgroundDrawable);
        final d mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.f(backgroundDrawable);
        }
    }
    
    public void setBackgroundResource(final int backgroundResource) {
        super.setBackgroundResource(backgroundResource);
        final d mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.g(backgroundResource);
        }
    }
    
    public void setCompoundDrawables(final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        final v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            mTextHelper.p();
        }
    }
    
    public void setCompoundDrawablesRelative(final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        final v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            mTextHelper.p();
        }
    }
    
    public void setCustomSelectionActionModeCallback(final ActionMode$Callback actionMode$Callback) {
        super.setCustomSelectionActionModeCallback(n.t((TextView)this, actionMode$Callback));
    }
    
    public void setEmojiCompatEnabled(final boolean b) {
        this.mAppCompatEmojiEditTextHelper.f(b);
    }
    
    public void setKeyListener(final KeyListener keyListener) {
        super.setKeyListener(this.mAppCompatEmojiEditTextHelper.a(keyListener));
    }
    
    public void setSupportBackgroundTintList(final ColorStateList list) {
        final d mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.i(list);
        }
    }
    
    public void setSupportBackgroundTintMode(final PorterDuff$Mode porterDuff$Mode) {
        final d mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.j(porterDuff$Mode);
        }
    }
    
    public void setSupportCompoundDrawablesTintList(final ColorStateList list) {
        this.mTextHelper.w(list);
        this.mTextHelper.b();
    }
    
    public void setSupportCompoundDrawablesTintMode(final PorterDuff$Mode porterDuff$Mode) {
        this.mTextHelper.x(porterDuff$Mode);
        this.mTextHelper.b();
    }
    
    public void setTextAppearance(final Context context, final int n) {
        super.setTextAppearance(context, n);
        final v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            mTextHelper.q(context, n);
        }
    }
    
    public void setTextClassifier(final TextClassifier textClassifier) {
        if (Build$VERSION.SDK_INT < 28) {
            final u mTextClassifierHelper = this.mTextClassifierHelper;
            if (mTextClassifierHelper != null) {
                mTextClassifierHelper.b(textClassifier);
                return;
            }
        }
        super.setTextClassifier(textClassifier);
    }
}
