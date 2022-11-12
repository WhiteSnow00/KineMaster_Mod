// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

final class g extends f<Bundle>
{
    g(final int n, final int n2, final Bundle bundle) {
        super(n, 1, bundle);
    }
    
    @Override
    final void a(Bundle bundle) {
        if ((bundle = bundle.getBundle("data")) == null) {
            bundle = Bundle.EMPTY;
        }
        this.d(bundle);
    }
    
    @Override
    final boolean b() {
        return false;
    }
}
