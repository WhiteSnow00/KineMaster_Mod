// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.Feature;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zzj extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzj> CREATOR;
    @Field
    Bundle a;
    @Field
    Feature[] b;
    @Field
    int c;
    @Field
    ConnectionTelemetryConfiguration d;
    
    static {
        CREATOR = (Parcelable$Creator)new zzk();
    }
    
    public zzj() {
    }
    
    @Constructor
    zzj(@Param final Bundle a, @Param final Feature[] b, @Param final int c, @Param final ConnectionTelemetryConfiguration d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.j(parcel, 1, this.a, false);
        SafeParcelWriter.E(parcel, 2, this.b, n, false);
        SafeParcelWriter.s(parcel, 3, this.c);
        SafeParcelWriter.A(parcel, 4, (Parcelable)this.d, n, false);
        SafeParcelWriter.b(parcel, a);
    }
}
