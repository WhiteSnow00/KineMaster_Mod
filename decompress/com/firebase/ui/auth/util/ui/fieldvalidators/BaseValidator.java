// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.ui.fieldvalidators;

import com.google.android.material.textfield.TextInputLayout;

public class BaseValidator
{
    protected String mEmptyMessage;
    protected TextInputLayout mErrorContainer;
    protected String mErrorMessage;
    
    public BaseValidator(final TextInputLayout mErrorContainer) {
        this.mErrorMessage = "";
        this.mErrorContainer = mErrorContainer;
    }
    
    protected boolean isValid(final CharSequence charSequence) {
        return true;
    }
    
    public boolean validate(final CharSequence charSequence) {
        if (this.mEmptyMessage != null && (charSequence == null || charSequence.length() == 0)) {
            this.mErrorContainer.setError((CharSequence)this.mEmptyMessage);
            return false;
        }
        if (this.isValid(charSequence)) {
            this.mErrorContainer.setError((CharSequence)"");
            return true;
        }
        this.mErrorContainer.setError((CharSequence)this.mErrorMessage);
        return false;
    }
}
