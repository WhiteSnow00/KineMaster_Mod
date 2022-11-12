// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.appset;

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
    private final String a;
    @Field
    private final int b;
    
    static {
        CREATOR = (Parcelable$Creator)new zzd();
    }
    
    @Constructor
    public zzc(@Param final String a, @Param final int b) {
        this.a = a;
        this.b = b;
    }
    
    public final int K1() {
        return this.b;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        SafeParcelWriter.s(parcel, 2, this.b);
        SafeParcelWriter.b(parcel, a);
    }
    
    public final String zzb() {
        return this.a;
    }
}
