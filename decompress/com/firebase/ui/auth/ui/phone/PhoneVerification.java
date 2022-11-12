// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.ui.phone;

import com.google.firebase.auth.PhoneAuthCredential;

public final class PhoneVerification
{
    private final PhoneAuthCredential mCredential;
    private final boolean mIsAutoVerified;
    private final String mNumber;
    
    public PhoneVerification(final String mNumber, final PhoneAuthCredential mCredential, final boolean mIsAutoVerified) {
        this.mNumber = mNumber;
        this.mCredential = mCredential;
        this.mIsAutoVerified = mIsAutoVerified;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && PhoneVerification.class == o.getClass()) {
            final PhoneVerification phoneVerification = (PhoneVerification)o;
            if (this.mIsAutoVerified != phoneVerification.mIsAutoVerified || !this.mNumber.equals(phoneVerification.mNumber) || !this.mCredential.equals(phoneVerification.mCredential)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    public PhoneAuthCredential getCredential() {
        return this.mCredential;
    }
    
    public String getNumber() {
        return this.mNumber;
    }
    
    @Override
    public int hashCode() {
        return (this.mNumber.hashCode() * 31 + this.mCredential.hashCode()) * 31 + (this.mIsAutoVerified ? 1 : 0);
    }
    
    public boolean isAutoVerified() {
        return this.mIsAutoVerified;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("PhoneVerification{mNumber='");
        sb.append(this.mNumber);
        sb.append('\'');
        sb.append(", mCredential=");
        sb.append(this.mCredential);
        sb.append(", mIsAutoVerified=");
        sb.append(this.mIsAutoVerified);
        sb.append('}');
        return sb.toString();
    }
}
