// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

final class v implements BackgroundStateChangeListener
{
    final GoogleApiManager a;
    
    v(final GoogleApiManager a) {
        this.a = a;
    }
    
    @Override
    public final void a(final boolean b) {
        final GoogleApiManager a = this.a;
        GoogleApiManager.s(a).sendMessage(GoogleApiManager.s(a).obtainMessage(1, (Object)b));
    }
}
