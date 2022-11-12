// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation.rtb;

import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.AdSize;
import android.os.Bundle;
import java.util.List;
import android.content.Context;

public class RtbSignalData
{
    private final Context a;
    private final List b;
    private final Bundle c;
    private final AdSize d;
    
    public RtbSignalData(final Context a, final List<MediationConfiguration> b, final Bundle c, final AdSize d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public Context a() {
        return this.a;
    }
}
