// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zzu extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzu> CREATOR;
    @Field
    public final String a;
    @Field
    public long b;
    @Field
    public zze c;
    @Field
    public final Bundle d;
    @Field
    public final String e;
    @Field
    public final String f;
    @Field
    public final String g;
    @Field
    public final String h;
    
    static {
        CREATOR = (Parcelable$Creator)new zzv();
    }
    
    @Constructor
    public zzu(@Param final String a, @Param final long b, @Param final zze c, @Param final Bundle d, @Param final String e, @Param final String f, @Param final String g, @Param final String h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        SafeParcelWriter.v(parcel, 2, this.b);
        SafeParcelWriter.A(parcel, 3, (Parcelable)this.c, n, false);
        SafeParcelWriter.j(parcel, 4, this.d, false);
        SafeParcelWriter.B(parcel, 5, this.e, false);
        SafeParcelWriter.B(parcel, 6, this.f, false);
        SafeParcelWriter.B(parcel, 7, this.g, false);
        SafeParcelWriter.B(parcel, 8, this.h, false);
        SafeParcelWriter.b(parcel, a);
    }
}
