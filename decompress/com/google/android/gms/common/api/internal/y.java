// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

final class y implements Runnable
{
    final z a;
    
    y(final z a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        final zabq a = this.a.a;
        zabq.r(a).disconnect(zabq.r(a).getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
