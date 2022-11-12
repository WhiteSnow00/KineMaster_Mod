// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import java.util.List;
import com.google.firebase.auth.SignInMethodQueryResult;

public final class zzaj implements SignInMethodQueryResult
{
    private final List a;
    
    public zzaj(final List a) {
        this.a = a;
    }
    
    @Override
    public final List<String> a() {
        return this.a;
    }
}
