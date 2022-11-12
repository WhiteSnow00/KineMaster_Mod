// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.ui.fieldvalidators;

import android.widget.LinearLayout;
import android.util.Patterns;
import com.firebase.ui.auth.R;
import com.google.android.material.textfield.TextInputLayout;

public class EmailFieldValidator extends BaseValidator
{
    public EmailFieldValidator(final TextInputLayout textInputLayout) {
        super(textInputLayout);
        super.mErrorMessage = ((LinearLayout)super.mErrorContainer).getResources().getString(R.string.fui_invalid_email_address);
        super.mEmptyMessage = ((LinearLayout)super.mErrorContainer).getResources().getString(R.string.fui_missing_email_address);
    }
    
    @Override
    protected boolean isValid(final CharSequence charSequence) {
        return Patterns.EMAIL_ADDRESS.matcher(charSequence).matches();
    }
}
