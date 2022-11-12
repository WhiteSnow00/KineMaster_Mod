// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;

public class EmailAuthProvider
{
    private EmailAuthProvider() {
    }
    
    public static AuthCredential a(final String s, final String s2) {
        Preconditions.g(s);
        Preconditions.g(s2);
        return new EmailAuthCredential(s, s2, null, null, false);
    }
    
    public static AuthCredential b(final String s, final String s2) {
        if (EmailAuthCredential.O1(s2)) {
            return new EmailAuthCredential(s, null, s2, null, false);
        }
        throw new IllegalArgumentException("Given link is not a valid email link. Please use FirebaseAuth#isSignInWithEmailLink(String) to determine this before calling this function");
    }
}
