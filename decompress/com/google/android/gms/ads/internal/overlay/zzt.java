// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.ads.internal.util.zze;
import android.os.Bundle;
import android.app.Activity;

public final class zzt extends zzl
{
    public zzt(final Activity activity) {
        super(activity);
    }
    
    @Override
    public final void zzk(final Bundle bundle) {
        zze.a("AdOverlayParcel is null or does not contain valid overlay type.");
        super.E = 4;
        super.a.finish();
    }
}
