// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeEmailInfo;

public final class zzl extends ActionCodeEmailInfo
{
    private final String b;
    
    public zzl(final String s, final String s2) {
        super.a = Preconditions.g(s);
        this.b = Preconditions.g(s2);
    }
}
