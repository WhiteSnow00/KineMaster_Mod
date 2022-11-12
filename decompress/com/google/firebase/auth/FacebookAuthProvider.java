// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

public class FacebookAuthProvider
{
    private FacebookAuthProvider() {
    }
    
    public static AuthCredential a(final String s) {
        return new FacebookAuthCredential(s);
    }
}
