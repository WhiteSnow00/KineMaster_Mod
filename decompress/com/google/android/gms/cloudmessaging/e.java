// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

final class e extends f<Void>
{
    e(final int n, final int n2, final Bundle bundle) {
        super(n, 2, bundle);
    }
    
    @Override
    final void a(final Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            this.d(null);
            return;
        }
        this.c(new zzq(4, "Invalid response to one way request", null));
    }
    
    @Override
    final boolean b() {
        return true;
    }
}
