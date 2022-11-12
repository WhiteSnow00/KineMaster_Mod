// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util.ui.fieldvalidators;

import com.google.android.material.textfield.TextInputLayout;

public class NoOpValidator extends BaseValidator
{
    public NoOpValidator(final TextInputLayout textInputLayout) {
        super(textInputLayout);
    }
    
    @Override
    protected boolean isValid(final CharSequence charSequence) {
        return true;
    }
}
