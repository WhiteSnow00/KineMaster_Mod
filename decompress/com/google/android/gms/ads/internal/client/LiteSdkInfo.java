// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbtw;
import com.google.android.gms.internal.ads.zzbtz;
import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class LiteSdkInfo extends zzci
{
    public LiteSdkInfo(final Context context) {
    }
    
    public zzbtz getAdapterCreator() {
        return (zzbtz)new zzbtw();
    }
    
    public zzei getLiteSdkVersion() {
        return new zzei(221310600, 221310000, "21.0.0");
    }
}
