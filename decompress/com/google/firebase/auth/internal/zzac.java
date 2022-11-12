// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.firebase.auth.MultiFactorInfo;
import java.util.List;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.MultiFactor;

public final class zzac extends MultiFactor
{
    private final zzx a;
    
    public zzac(final zzx a) {
        Preconditions.k(a);
        this.a = a;
    }
    
    @Override
    public final List<MultiFactorInfo> a() {
        return this.a.i2();
    }
}
