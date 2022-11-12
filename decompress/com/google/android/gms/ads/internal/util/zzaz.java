// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.internal.ads.zzfpg;
import com.google.android.gms.internal.ads.zzfcx;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zzaz extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzaz> CREATOR;
    @Field
    public final String a;
    @Field
    public final int b;
    
    static {
        CREATOR = (Parcelable$Creator)new zzba();
    }
    
    @Constructor
    zzaz(@Param final String s, @Param final int b) {
        String a = s;
        if (s == null) {
            a = "";
        }
        this.a = a;
        this.b = b;
    }
    
    public static zzaz K1(final Throwable t) {
        final zze zza = zzfcx.zza(t);
        String s;
        if (zzfpg.zzd(t.getMessage())) {
            s = zza.b;
        }
        else {
            s = t.getMessage();
        }
        return new zzaz(s, zza.a);
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        SafeParcelWriter.s(parcel, 2, this.b);
        SafeParcelWriter.b(parcel, a);
    }
}
