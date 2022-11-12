// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.ui.fieldvalidators;

import android.widget.LinearLayout;
import com.firebase.ui.auth.R;
import com.google.android.material.textfield.TextInputLayout;

public class RequiredFieldValidator extends BaseValidator
{
    public RequiredFieldValidator(final TextInputLayout textInputLayout) {
        super(textInputLayout);
        super.mErrorMessage = ((LinearLayout)super.mErrorContainer).getResources().getString(R.string.fui_required_field);
    }
    
    public RequiredFieldValidator(final TextInputLayout textInputLayout, final String mErrorMessage) {
        super(textInputLayout);
        super.mErrorMessage = mErrorMessage;
    }
    
    @Override
    protected boolean isValid(final CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0;
    }
}
