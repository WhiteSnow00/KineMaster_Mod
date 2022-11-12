// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.firebase.FirebaseException;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.Preconditions;

public class PhoneAuthProvider
{
    public static PhoneAuthCredential a(final String s, final String s2) {
        return PhoneAuthCredential.O1(s, s2);
    }
    
    public static void b(final PhoneAuthOptions phoneAuthOptions) {
        Preconditions.k(phoneAuthOptions);
        phoneAuthOptions.c().H(phoneAuthOptions);
    }
    
    @Class
    public static class ForceResendingToken extends AbstractSafeParcelable
    {
        public static final Parcelable$Creator<ForceResendingToken> CREATOR;
        
        static {
            CREATOR = (Parcelable$Creator)new zzd();
        }
        
        @Constructor
        ForceResendingToken() {
        }
        
        public static ForceResendingToken K1() {
            return new ForceResendingToken();
        }
        
        public final void writeToParcel(final Parcel parcel, final int n) {
            SafeParcelWriter.b(parcel, SafeParcelWriter.a(parcel));
        }
    }
    
    public abstract static class OnVerificationStateChangedCallbacks
    {
        private static final Logger zza;
        
        static {
            zza = new Logger("PhoneAuthProvider", new String[0]);
        }
        
        public void onCodeAutoRetrievalTimeOut(final String s) {
            OnVerificationStateChangedCallbacks.zza.e("Sms auto retrieval timed-out.", new Object[0]);
        }
        
        public void onCodeSent(final String s, final ForceResendingToken forceResendingToken) {
        }
        
        public abstract void onVerificationCompleted(final PhoneAuthCredential p0);
        
        public abstract void onVerificationFailed(final FirebaseException p0);
    }
}
