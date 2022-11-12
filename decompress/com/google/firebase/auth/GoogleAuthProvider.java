// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

public class GoogleAuthProvider
{
    private GoogleAuthProvider() {
    }
    
    public static AuthCredential a(final String s, final String s2) {
        return new GoogleAuthCredential(s, s2);
    }
}
