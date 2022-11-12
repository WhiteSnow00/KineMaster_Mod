// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.model;

import android.text.TextUtils;

public final class PhoneNumber
{
    private static final PhoneNumber EMPTY_PHONE_NUMBER;
    private final String mCountryCode;
    private final String mCountryIso;
    private final String mPhoneNumber;
    
    static {
        EMPTY_PHONE_NUMBER = new PhoneNumber("", "", "");
    }
    
    public PhoneNumber(final String mPhoneNumber, final String mCountryIso, final String mCountryCode) {
        this.mPhoneNumber = mPhoneNumber;
        this.mCountryIso = mCountryIso;
        this.mCountryCode = mCountryCode;
    }
    
    public static PhoneNumber emptyPhone() {
        return PhoneNumber.EMPTY_PHONE_NUMBER;
    }
    
    public static boolean isCountryValid(final PhoneNumber phoneNumber) {
        return phoneNumber != null && !PhoneNumber.EMPTY_PHONE_NUMBER.equals(phoneNumber) && !TextUtils.isEmpty((CharSequence)phoneNumber.getCountryCode()) && !TextUtils.isEmpty((CharSequence)phoneNumber.getCountryIso());
    }
    
    public static boolean isValid(final PhoneNumber phoneNumber) {
        return phoneNumber != null && !PhoneNumber.EMPTY_PHONE_NUMBER.equals(phoneNumber) && !TextUtils.isEmpty((CharSequence)phoneNumber.getPhoneNumber()) && !TextUtils.isEmpty((CharSequence)phoneNumber.getCountryCode()) && !TextUtils.isEmpty((CharSequence)phoneNumber.getCountryIso());
    }
    
    public String getCountryCode() {
        return this.mCountryCode;
    }
    
    public String getCountryIso() {
        return this.mCountryIso;
    }
    
    public String getPhoneNumber() {
        return this.mPhoneNumber;
    }
}
