// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzds implements Runnable
{
    public final zzdu a;
    public final IObjectWrapper b;
    
    public zzds(final zzdu a, final IObjectWrapper b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        this.a.o(this.b);
    }
}
