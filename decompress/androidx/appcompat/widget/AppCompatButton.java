// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import android.text.InputFilter;
import android.graphics.drawable.Drawable;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityEvent;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import androidx.core.widget.n;
import android.view.ActionMode$Callback;
import android.widget.TextView;
import android.view.View;
import d.a;
import android.util.AttributeSet;
import android.content.Context;
import androidx.core.widget.b;
import android.widget.Button;

public class AppCompatButton extends Button implements b
{
    private j mAppCompatEmojiTextHelper;
    private final d mBackgroundTintHelper;
    private final v mTextHelper;
    
    public AppCompatButton(final Context context) {
        this(context, null);
    }
    
    public AppCompatButton(final Context context, final AttributeSet set) {
        this(context, set, a.q);
    }
    
    public AppCompatButton(final Context context, final AttributeSet set, final int n) {
        super(o0.b(context), set, n);
        m0.a((View)this, this.getContext());
        (this.mBackgroundTintHelper = new d((View)this)).e(set, n);
        final v mTextHelper = new v((TextView)this);
        (this.mTextHelper = mTextHelper).m(set, n);
        mTextHelper.b();
        this.getEmojiTextViewHelper().c(set, n);
    }
    
    private j getEmojiTextViewHelper() {
        if (this.mAppCompatEmojiTextHelper == null) {
            this.mAppCompatEmojiTextHelper = new j((TextView)this);
        }
        return this.mAppCompatEmojiTextHelper;
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
    
    public int getAutoSizeMaxTextSize() {
        if (b.k) {
            return super.getAutoSizeMaxTextSize();
        }
        final v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            return mTextHelper.e();
        }
        return -1;
    }
    
    public int getAutoSizeMinTextSize() {
        if (b.k) {
            return super.getAutoSizeMinTextSize();
        }
        final v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            return mTextHelper.f();
        }
        return -1;
    }
    
    public int getAutoSizeStepGranularity() {
        if (b.k) {
            return super.getAutoSizeStepGranularity();
        }
        final v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            return mTextHelper.g();
        }
        return -1;
    }
    
    public int[] getAutoSizeTextAvailableSizes() {
        if (b.k) {
            return super.getAutoSizeTextAvailableSizes();
        }
        final v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            return mTextHelper.h();
        }
        return new int[0];
    }
    
    public int getAutoSizeTextType() {
        final boolean k = b.k;
        int n = 0;
        if (k) {
            if (super.getAutoSizeTextType() == 1) {
                n = 1;
            }
            return n;
        }
        final v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            return mTextHelper.i();
        }
        return 0;
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
    
    public boolean isEmojiCompatEnabled() {
        return this.getEmojiTextViewHelper().b();
    }
    
    public void onInitializeAccessibilityEvent(final AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)Button.class.getName());
    }
    
    public void onInitializeAccessibilityNodeInfo(final AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)Button.class.getName());
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        final v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            mTextHelper.o(b, n, n2, n3, n4);
        }
    }
    
    protected void onTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
        super.onTextChanged(charSequence, n, n2, n3);
        final v mTextHelper = this.mTextHelper;
        if (mTextHelper != null && !b.k && mTextHelper.l()) {
            this.mTextHelper.c();
        }
    }
    
    public void setAllCaps(final boolean allCaps) {
        super.setAllCaps(allCaps);
        this.getEmojiTextViewHelper().d(allCaps);
    }
    
    public void setAutoSizeTextTypeUniformWithConfiguration(final int n, final int n2, final int n3, final int n4) throws IllegalArgumentException {
        if (b.k) {
            super.setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
        }
        else {
            final v mTextHelper = this.mTextHelper;
            if (mTextHelper != null) {
                mTextHelper.t(n, n2, n3, n4);
            }
        }
    }
    
    public void setAutoSizeTextTypeUniformWithPresetSizes(final int[] array, final int n) throws IllegalArgumentException {
        if (b.k) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(array, n);
        }
        else {
            final v mTextHelper = this.mTextHelper;
            if (mTextHelper != null) {
                mTextHelper.u(array, n);
            }
        }
    }
    
    public void setAutoSizeTextTypeWithDefaults(final int autoSizeTextTypeWithDefaults) {
        if (b.k) {
            super.setAutoSizeTextTypeWithDefaults(autoSizeTextTypeWithDefaults);
        }
        else {
            final v mTextHelper = this.mTextHelper;
            if (mTextHelper != null) {
                mTextHelper.v(autoSizeTextTypeWithDefaults);
            }
        }
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
    
    public void setCustomSelectionActionModeCallback(final ActionMode$Callback actionMode$Callback) {
        super.setCustomSelectionActionModeCallback(n.t((TextView)this, actionMode$Callback));
    }
    
    public void setEmojiCompatEnabled(final boolean b) {
        this.getEmojiTextViewHelper().e(b);
    }
    
    public void setFilters(final InputFilter[] array) {
        super.setFilters(this.getEmojiTextViewHelper().a(array));
    }
    
    public void setSupportAllCaps(final boolean b) {
        final v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            mTextHelper.s(b);
        }
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
    
    public void setTextSize(final int n, final float n2) {
        if (b.k) {
            super.setTextSize(n, n2);
        }
        else {
            final v mTextHelper = this.mTextHelper;
            if (mTextHelper != null) {
                mTextHelper.A(n, n2);
            }
        }
    }
}
