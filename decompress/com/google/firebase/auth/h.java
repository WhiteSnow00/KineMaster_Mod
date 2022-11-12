// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.firebase.FirebaseException;
import com.google.android.gms.common.internal.Preconditions;

final class h extends OnVerificationStateChangedCallbacks
{
    final OnVerificationStateChangedCallbacks a;
    final FirebaseAuth b;
    
    h(final FirebaseAuth b, final OnVerificationStateChangedCallbacks a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public final void onCodeAutoRetrievalTimeOut(final String s) {
    }
    
    @Override
    public final void onCodeSent(final String s, final ForceResendingToken forceResendingToken) {
        this.a.onVerificationCompleted(PhoneAuthProvider.a(s, Preconditions.k(FirebaseAuth.V(this.b).b())));
    }
    
    @Override
    public final void onVerificationCompleted(final PhoneAuthCredential phoneAuthCredential) {
        this.a.onVerificationCompleted(phoneAuthCredential);
    }
    
    @Override
    public final void onVerificationFailed(final FirebaseException ex) {
        this.a.onVerificationFailed(ex);
    }
}
