// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import javax.annotation.concurrent.GuardedBy;
import com.google.android.gms.common.ConnectionResult;

final class i extends t
{
    final ConnectionResult b;
    final k c;
    
    i(final k c, final zabf zabf, final ConnectionResult b) {
        this.c = c;
        this.b = b;
        super(zabf);
    }
    
    @GuardedBy
    public final void a() {
        zaaw.C(this.c.c, this.b);
    }
}
