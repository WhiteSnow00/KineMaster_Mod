// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.ActionCodeMultiFactorInfo;

public final class zzn extends ActionCodeMultiFactorInfo
{
    private final MultiFactorInfo b;
    
    public zzn(final String s, final MultiFactorInfo multiFactorInfo) {
        super.a = Preconditions.g(s);
        this.b = Preconditions.k(multiFactorInfo);
    }
}
