// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.ads.RequestConfiguration;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zzfa extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzfa> CREATOR;
    @Field
    public final int a;
    @Field
    public final int b;
    
    static {
        CREATOR = (Parcelable$Creator)new zzfb();
    }
    
    @Constructor
    public zzfa(@Param final int a, @Param final int b) {
        this.a = a;
        this.b = b;
    }
    
    public zzfa(final RequestConfiguration requestConfiguration) {
        this.a = requestConfiguration.b();
        this.b = requestConfiguration.c();
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.s(parcel, 2, this.b);
        SafeParcelWriter.b(parcel, a);
    }
}
