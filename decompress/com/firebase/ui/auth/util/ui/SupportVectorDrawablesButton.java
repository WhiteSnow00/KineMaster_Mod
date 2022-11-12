// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.ui;

import android.content.res.TypedArray;
import android.widget.TextView;
import androidx.core.widget.n;
import com.firebase.ui.auth.R;
import android.util.AttributeSet;
import android.content.Context;
import androidx.appcompat.widget.AppCompatButton;

public class SupportVectorDrawablesButton extends AppCompatButton
{
    public SupportVectorDrawablesButton(final Context context) {
        super(context);
    }
    
    public SupportVectorDrawablesButton(final Context context, final AttributeSet set) {
        super(context, set);
        this.initSupportVectorDrawablesAttrs(set);
    }
    
    public SupportVectorDrawablesButton(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.initSupportVectorDrawablesAttrs(set);
    }
    
    private void initSupportVectorDrawablesAttrs(final AttributeSet set) {
        if (set == null) {
            return;
        }
        final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes(set, R.styleable.SupportVectorDrawablesButton);
        n.l((TextView)this, obtainStyledAttributes.getDrawable(R.styleable.SupportVectorDrawablesButton_drawableStartCompat), obtainStyledAttributes.getDrawable(R.styleable.SupportVectorDrawablesButton_drawableTopCompat), obtainStyledAttributes.getDrawable(R.styleable.SupportVectorDrawablesButton_drawableEndCompat), obtainStyledAttributes.getDrawable(R.styleable.SupportVectorDrawablesButton_drawableBottomCompat));
        obtainStyledAttributes.recycle();
    }
}
