// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.server.converter;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zac extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zac> CREATOR;
    @VersionField
    final int a;
    @Field
    final String b;
    @Field
    final int c;
    
    static {
        CREATOR = (Parcelable$Creator)new zae();
    }
    
    @Constructor
    zac(@Param final int a, @Param final String b, @Param final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    zac(final String b, final int c) {
        this.a = 1;
        this.b = b;
        this.c = c;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.s(parcel, 3, this.c);
        SafeParcelWriter.b(parcel, a);
    }
}
