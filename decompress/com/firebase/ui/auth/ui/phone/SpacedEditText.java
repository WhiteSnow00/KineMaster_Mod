// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.phone;

import android.widget.TextView$BufferType;
import android.content.res.TypedArray;
import com.firebase.ui.auth.R;
import android.text.Editable;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.content.Context;
import android.text.SpannableStringBuilder;
import com.google.android.material.textfield.TextInputEditText;

public final class SpacedEditText extends TextInputEditText
{
    private SpannableStringBuilder mOriginalText;
    private float mProportion;
    
    public SpacedEditText(final Context context) {
        super(context);
        this.mOriginalText = new SpannableStringBuilder((CharSequence)"");
    }
    
    public SpacedEditText(final Context context, final AttributeSet set) {
        super(context, set);
        this.mOriginalText = new SpannableStringBuilder((CharSequence)"");
        this.initAttrs(context, set);
    }
    
    private SpannableStringBuilder getSpacedOutString(final CharSequence charSequence) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        final int length = charSequence.length();
        int n = -1;
        int n2 = 0;
        int n3;
        while (true) {
            n3 = length - 1;
            if (n2 >= n3) {
                break;
            }
            spannableStringBuilder.append(charSequence.charAt(n2));
            spannableStringBuilder.append((CharSequence)" ");
            n += 2;
            spannableStringBuilder.setSpan((Object)new ScaleXSpan(this.mProportion), n, n + 1, 33);
            ++n2;
        }
        if (length != 0) {
            spannableStringBuilder.append(charSequence.charAt(n3));
        }
        return spannableStringBuilder;
    }
    
    public Editable getUnspacedText() {
        return (Editable)this.mOriginalText;
    }
    
    void initAttrs(final Context context, final AttributeSet set) {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, R.styleable.SpacedEditText);
        this.mProportion = obtainStyledAttributes.getFloat(R.styleable.SpacedEditText_spacingProportion, 1.0f);
        obtainStyledAttributes.recycle();
    }
    
    public void setSelection(final int n) {
        final int min = Math.min(Math.max(n * 2 - 1, 0), this.mOriginalText.length() * 2 - 1);
        try {
            super.setSelection(min);
        }
        catch (final IndexOutOfBoundsException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append(ex.getMessage());
            sb.append(", requestedIndex=");
            sb.append(n);
            sb.append(", newIndex= ");
            sb.append(min);
            sb.append(", originalText=");
            sb.append(this.mOriginalText);
            throw new IndexOutOfBoundsException(sb.toString());
        }
    }
    
    public void setText(final CharSequence charSequence, final TextView$BufferType textView$BufferType) {
        this.mOriginalText = new SpannableStringBuilder(charSequence);
        super.setText((CharSequence)this.getSpacedOutString(charSequence), TextView$BufferType.SPANNABLE);
    }
}
