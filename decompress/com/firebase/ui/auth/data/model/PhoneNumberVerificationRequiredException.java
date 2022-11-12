// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.model;

import com.firebase.ui.auth.FirebaseUiException;

public class PhoneNumberVerificationRequiredException extends FirebaseUiException
{
    private final String mPhoneNumber;
    
    public PhoneNumberVerificationRequiredException(final String mPhoneNumber) {
        super(4, "Phone number requires verification.");
        this.mPhoneNumber = mPhoneNumber;
    }
    
    public String getPhoneNumber() {
        return this.mPhoneNumber;
    }
}
