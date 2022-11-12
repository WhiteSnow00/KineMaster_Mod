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
public final class zzc extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzc> CREATOR;
    @Field
    public final String a;
    @Field
    public final String b;
    
    static {
        CREATOR = (Parcelable$Creator)new zzd();
    }
    
    @Constructor
    public zzc(@Param final String a, @Param final String b) {
        this.a = a;
        this.b = b;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.b(parcel, a);
    }
}
