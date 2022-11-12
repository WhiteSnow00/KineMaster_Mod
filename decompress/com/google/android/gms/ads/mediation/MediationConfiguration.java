// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;

public class MediationConfiguration
{
    private final AdFormat a;
    private final Bundle b;
    
    public MediationConfiguration(final AdFormat a, final Bundle b) {
        this.a = a;
        this.b = b;
    }
    
    public Bundle a() {
        return this.b;
    }
}
