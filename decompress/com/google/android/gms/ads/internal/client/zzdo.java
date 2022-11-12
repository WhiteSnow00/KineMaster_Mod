// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
@Reserved
public final class zzdo extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzdo> CREATOR;
    @Field
    public final int a;
    
    static {
        CREATOR = (Parcelable$Creator)new zzdp();
    }
    
    @Constructor
    public zzdo(@Param final int a) {
        this.a = a;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 2, this.a);
        SafeParcelWriter.b(parcel, a);
    }
}
