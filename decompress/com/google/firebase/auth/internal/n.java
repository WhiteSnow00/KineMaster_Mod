// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

final class n implements BackgroundStateChangeListener
{
    final zzbi a;
    
    n(final zzbi a) {
        this.a = a;
    }
    
    @Override
    public final void a(final boolean b) {
        if (b) {
            zzbi.b(this.a, true);
            this.a.c();
            return;
        }
        zzbi.b(this.a, false);
        if (zzbi.f(this.a)) {
            zzbi.a(this.a).c();
        }
    }
}
