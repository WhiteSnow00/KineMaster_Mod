// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.internal.LifecycleFragment;
import android.content.Intent;

final class b extends zag
{
    final Intent a;
    final LifecycleFragment b;
    
    b(final Intent a, final LifecycleFragment b, final int n) {
        this.a = a;
        this.b = b;
    }
    
    public final void a() {
        final Intent a = this.a;
        if (a != null) {
            this.b.startActivityForResult(a, 2);
        }
    }
}
