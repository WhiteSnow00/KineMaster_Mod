// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.ads.appopen.AppOpenAd;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
@Reserved
public final class zzw extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzw> CREATOR;
    @AppOpenAd.AppOpenAdOrientation
    @Field
    public final int a;
    
    static {
        CREATOR = (Parcelable$Creator)new zzx();
    }
    
    @Constructor
    public zzw(@AppOpenAd.AppOpenAdOrientation @Param final int a) {
        this.a = a;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 2, this.a);
        SafeParcelWriter.b(parcel, a);
    }
}
