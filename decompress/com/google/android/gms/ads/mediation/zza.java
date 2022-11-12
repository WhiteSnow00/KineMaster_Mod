// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import android.os.Bundle;

public final class zza
{
    private int a;
    
    public final Bundle a() {
        final Bundle bundle = new Bundle();
        bundle.putInt("capabilities", this.a);
        return bundle;
    }
    
    public final zza b(final int n) {
        this.a = 1;
        return this;
    }
}
