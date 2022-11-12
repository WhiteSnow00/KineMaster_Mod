// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.ConnectionResult;

final class n0
{
    private final int a;
    private final ConnectionResult b;
    
    n0(final ConnectionResult b, final int a) {
        Preconditions.k(b);
        this.b = b;
        this.a = a;
    }
    
    final int a() {
        return this.a;
    }
    
    final ConnectionResult b() {
        return this.b;
    }
}
