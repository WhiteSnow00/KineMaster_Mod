// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.mediation;

import java.util.Map;
import com.google.android.gms.ads.formats.NativeAdOptions;

@Deprecated
public interface NativeMediationAdRequest extends MediationAdRequest
{
    @Deprecated
    NativeAdOptions getNativeAdOptions();
    
    com.google.android.gms.ads.nativead.NativeAdOptions getNativeAdRequestOptions();
    
    boolean isUnifiedNativeAdRequested();
    
    Map zza();
    
    boolean zzb();
}
