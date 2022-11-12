// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import android.location.Location;
import android.os.Bundle;
import android.content.Context;
import com.google.android.gms.ads.AdSize;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class MediationBannerAdConfiguration extends MediationAdConfiguration
{
    private final AdSize k;
    
    public MediationBannerAdConfiguration(final Context context, final String s, final Bundle bundle, final Bundle bundle2, final boolean b, final Location location, final int n, final int n2, final String s2, final AdSize k, final String s3) {
        super(context, s, bundle, bundle2, b, location, n, n2, s2, s3);
        this.k = k;
    }
    
    public AdSize f() {
        return this.k;
    }
}
