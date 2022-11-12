// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.ui.fieldvalidators;

import android.widget.LinearLayout;
import android.content.res.Resources;
import com.firebase.ui.auth.R;
import com.google.android.material.textfield.TextInputLayout;

public class PasswordFieldValidator extends BaseValidator
{
    private int mMinLength;
    
    public PasswordFieldValidator(final TextInputLayout textInputLayout, int fui_error_weak_password) {
        super(textInputLayout);
        this.mMinLength = fui_error_weak_password;
        final Resources resources = ((LinearLayout)super.mErrorContainer).getResources();
        fui_error_weak_password = R.plurals.fui_error_weak_password;
        final int mMinLength = this.mMinLength;
        super.mErrorMessage = resources.getQuantityString(fui_error_weak_password, mMinLength, new Object[] { mMinLength });
    }
    
    @Override
    protected boolean isValid(final CharSequence charSequence) {
        return charSequence.length() >= this.mMinLength;
    }
}
