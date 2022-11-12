// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.CommonStatusCodes;

public final class GoogleSignInStatusCodes extends CommonStatusCodes
{
    private GoogleSignInStatusCodes() {
    }
    
    public static String a(final int n) {
        switch (n) {
            default: {
                return CommonStatusCodes.a(n);
            }
            case 12502: {
                return "Sign-in in progress";
            }
            case 12501: {
                return "Sign in action cancelled";
            }
            case 12500: {
                return "A non-recoverable sign in failure occurred";
            }
        }
    }
}
