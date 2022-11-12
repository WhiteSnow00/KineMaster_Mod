// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.Result;

public class GoogleSignInResult implements Result
{
    private Status a;
    private GoogleSignInAccount b;
    
    public GoogleSignInResult(final GoogleSignInAccount b, final Status a) {
        this.b = b;
        this.a = a;
    }
    
    public GoogleSignInAccount a() {
        return this.b;
    }
    
    @Override
    public Status getStatus() {
        return this.a;
    }
}
