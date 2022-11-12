// 
// Decompiled by Procyon v0.6.0
// 

package androidx.appcompat.widget;

import androidx.core.graphics.h;
import android.graphics.Typeface;
import android.text.InputFilter;
import e.a;
import android.graphics.drawable.Drawable;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.EditorInfo;
import android.os.Build$VERSION;
import android.view.textclassifier.TextClassifier;
import android.graphics.PorterDuff$Mode;
import android.content.res.ColorStateList;
import android.view.ActionMode$Callback;
import java.util.concurrent.ExecutionException;
import androidx.core.widget.n;
import android.view.View;
import android.util.AttributeSet;
import android.content.Context;
import java.util.concurrent.Future;
import androidx.core.widget.b;
import android.widget.TextView;

public class AppCompatTextView extends TextView implements b
{
    private final d a;
    private final v b;
    private final u c;
    private j d;
    private boolean e;
    private Future<androidx.core.text.b> f;
    
    public AppCompatTextView(final Context context) {
        this(context, null);
    }
    
    public AppCompatTextView(final Context context, final AttributeSet set) {
        this(context, set, 16842884);
    }
    
    public AppCompatTextView(final Context context, final AttributeSet set, final int n) {
        super(o0.b(context), set, n);
        this.e = false;
        m0.a((View)this, this.getContext());
        (this.a = new d((View)this)).e(set, n);
        final v b = new v(this);
        (this.b = b).m(set, n);
        b.b();
        this.c = new u(this);
        this.getEmojiTextViewHelper().c(set, n);
    }
    
    private void d() {
        final Future<androidx.core.text.b> f = this.f;
        if (f == null) {
            return;
        }
        try {
            this.f = null;
            n.p(this, f.get());
        }
        catch (final InterruptedException | ExecutionException ex) {}
    }
    
    private j getEmojiTextViewHelper() {
        if (this.d == null) {
            this.d = new j(this);
        }
        return this.d;
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
    
    public int getAutoSizeMaxTextSize() {
        if (androidx.core.widget.b.k) {
            return super.getAutoSizeMaxTextSize();
        }
        final v b = this.b;
        if (b != null) {
            return b.e();
        }
        return -1;
    }
    
    public int getAutoSizeMinTextSize() {
        if (androidx.core.widget.b.k) {
            return super.getAutoSizeMinTextSize();
        }
        final v b = this.b;
        if (b != null) {
            return b.f();
        }
        return -1;
    }
    
    public int getAutoSizeStepGranularity() {
        if (androidx.core.widget.b.k) {
            return super.getAutoSizeStepGranularity();
        }
        final v b = this.b;
        if (b != null) {
            return b.g();
        }
        return -1;
    }
    
    public int[] getAutoSizeTextAvailableSizes() {
        if (androidx.core.widget.b.k) {
            return super.getAutoSizeTextAvailableSizes();
        }
        final v b = this.b;
        if (b != null) {
            return b.h();
        }
        return new int[0];
    }
    
    public int getAutoSizeTextType() {
        final boolean k = androidx.core.widget.b.k;
        int n = 0;
        if (k) {
            if (super.getAutoSizeTextType() == 1) {
                n = 1;
            }
            return n;
        }
        final v b = this.b;
        if (b != null) {
            return b.i();
        }
        return 0;
    }
    
    public ActionMode$Callback getCustomSelectionActionModeCallback() {
        return n.s(super.getCustomSelectionActionModeCallback());
    }
    
    public int getFirstBaselineToTopHeight() {
        return n.b(this);
    }
    
    public int getLastBaselineToBottomHeight() {
        return n.c(this);
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
    
    public CharSequence getText() {
        this.d();
        return super.getText();
    }
    
    public TextClassifier getTextClassifier() {
        if (Build$VERSION.SDK_INT < 28) {
            final u c = this.c;
            if (c != null) {
                return c.a();
            }
        }
        return super.getTextClassifier();
    }
    
    public androidx.core.text.b.a getTextMetricsParamsCompat() {
        return n.g(this);
    }
    
    public InputConnection onCreateInputConnection(final EditorInfo editorInfo) {
        final InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.b.r(this, onCreateInputConnection, editorInfo);
        return androidx.appcompat.widget.k.a(onCreateInputConnection, editorInfo, (View)this);
    }
    
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        super.onLayout(b, n, n2, n3, n4);
        final v b2 = this.b;
        if (b2 != null) {
            b2.o(b, n, n2, n3, n4);
        }
    }
    
    protected void onMeasure(final int n, final int n2) {
        this.d();
        super.onMeasure(n, n2);
    }
    
    protected void onTextChanged(final CharSequence charSequence, final int n, final int n2, final int n3) {
        super.onTextChanged(charSequence, n, n2, n3);
        final v b = this.b;
        if (b != null && !androidx.core.widget.b.k && b.l()) {
            this.b.c();
        }
    }
    
    public void setAllCaps(final boolean allCaps) {
        super.setAllCaps(allCaps);
        this.getEmojiTextViewHelper().d(allCaps);
    }
    
    public void setAutoSizeTextTypeUniformWithConfiguration(final int n, final int n2, final int n3, final int n4) throws IllegalArgumentException {
        if (androidx.core.widget.b.k) {
            super.setAutoSizeTextTypeUniformWithConfiguration(n, n2, n3, n4);
        }
        else {
            final v b = this.b;
            if (b != null) {
                b.t(n, n2, n3, n4);
            }
        }
    }
    
    public void setAutoSizeTextTypeUniformWithPresetSizes(final int[] array, final int n) throws IllegalArgumentException {
        if (androidx.core.widget.b.k) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(array, n);
        }
        else {
            final v b = this.b;
            if (b != null) {
                b.u(array, n);
            }
        }
    }
    
    public void setAutoSizeTextTypeWithDefaults(final int autoSizeTextTypeWithDefaults) {
        if (androidx.core.widget.b.k) {
            super.setAutoSizeTextTypeWithDefaults(autoSizeTextTypeWithDefaults);
        }
        else {
            final v b = this.b;
            if (b != null) {
                b.v(autoSizeTextTypeWithDefaults);
            }
        }
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
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(final int n, final int n2, final int n3, final int n4) {
        final Context context = this.getContext();
        Drawable b = null;
        Drawable b2;
        if (n != 0) {
            b2 = e.a.b(context, n);
        }
        else {
            b2 = null;
        }
        Drawable b3;
        if (n2 != 0) {
            b3 = e.a.b(context, n2);
        }
        else {
            b3 = null;
        }
        Drawable b4;
        if (n3 != 0) {
            b4 = e.a.b(context, n3);
        }
        else {
            b4 = null;
        }
        if (n4 != 0) {
            b = e.a.b(context, n4);
        }
        this.setCompoundDrawablesRelativeWithIntrinsicBounds(b2, b3, b4, b);
        final v b5 = this.b;
        if (b5 != null) {
            b5.p();
        }
    }
    
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        final v b = this.b;
        if (b != null) {
            b.p();
        }
    }
    
    public void setCompoundDrawablesWithIntrinsicBounds(final int n, final int n2, final int n3, final int n4) {
        final Context context = this.getContext();
        Drawable b = null;
        Drawable b2;
        if (n != 0) {
            b2 = e.a.b(context, n);
        }
        else {
            b2 = null;
        }
        Drawable b3;
        if (n2 != 0) {
            b3 = e.a.b(context, n2);
        }
        else {
            b3 = null;
        }
        Drawable b4;
        if (n3 != 0) {
            b4 = e.a.b(context, n3);
        }
        else {
            b4 = null;
        }
        if (n4 != 0) {
            b = e.a.b(context, n4);
        }
        this.setCompoundDrawablesWithIntrinsicBounds(b2, b3, b4, b);
        final v b5 = this.b;
        if (b5 != null) {
            b5.p();
        }
    }
    
    public void setCompoundDrawablesWithIntrinsicBounds(final Drawable drawable, final Drawable drawable2, final Drawable drawable3, final Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        final v b = this.b;
        if (b != null) {
            b.p();
        }
    }
    
    public void setCustomSelectionActionModeCallback(final ActionMode$Callback actionMode$Callback) {
        super.setCustomSelectionActionModeCallback(n.t(this, actionMode$Callback));
    }
    
    public void setEmojiCompatEnabled(final boolean b) {
        this.getEmojiTextViewHelper().e(b);
    }
    
    public void setFilters(final InputFilter[] array) {
        super.setFilters(this.getEmojiTextViewHelper().a(array));
    }
    
    public void setFirstBaselineToTopHeight(final int firstBaselineToTopHeight) {
        if (Build$VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(firstBaselineToTopHeight);
        }
        else {
            n.m(this, firstBaselineToTopHeight);
        }
    }
    
    public void setLastBaselineToBottomHeight(final int lastBaselineToBottomHeight) {
        if (Build$VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(lastBaselineToBottomHeight);
        }
        else {
            n.n(this, lastBaselineToBottomHeight);
        }
    }
    
    public void setLineHeight(final int n) {
        n.o(this, n);
    }
    
    public void setPrecomputedText(final androidx.core.text.b b) {
        n.p(this, b);
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
    
    public void setTextClassifier(final TextClassifier textClassifier) {
        if (Build$VERSION.SDK_INT < 28) {
            final u c = this.c;
            if (c != null) {
                c.b(textClassifier);
                return;
            }
        }
        super.setTextClassifier(textClassifier);
    }
    
    public void setTextFuture(final Future<androidx.core.text.b> f) {
        this.f = f;
        if (f != null) {
            this.requestLayout();
        }
    }
    
    public void setTextMetricsParamsCompat(final androidx.core.text.b.a a) {
        n.r(this, a);
    }
    
    public void setTextSize(final int n, final float n2) {
        if (androidx.core.widget.b.k) {
            super.setTextSize(n, n2);
        }
        else {
            final v b = this.b;
            if (b != null) {
                b.A(n, n2);
            }
        }
    }
    
    public void setTypeface(Typeface typeface, final int n) {
        if (this.e) {
            return;
        }
        Typeface a;
        final Typeface typeface2 = a = null;
        if (typeface != null) {
            a = typeface2;
            if (n > 0) {
                a = h.a(this.getContext(), typeface, n);
            }
        }
        this.e = true;
        if (a != null) {
            typeface = a;
        }
        try {
            super.setTypeface(typeface, n);
        }
        finally {
            this.e = false;
        }
    }
}
