// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.server.response;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@ShowFirstParty
@Class
public final class zam extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zam> CREATOR;
    @VersionField
    final int a;
    @Field
    final String b;
    @Field
    final FastJsonResponse.Field c;
    
    static {
        CREATOR = (Parcelable$Creator)new zak();
    }
    
    @Constructor
    zam(@Param final int a, @Param final String b, @Param final FastJsonResponse.Field c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    zam(final String b, final FastJsonResponse.Field c) {
        this.a = 1;
        this.b = b;
        this.c = c;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.A(parcel, 3, (Parcelable)this.c, n, false);
        SafeParcelWriter.b(parcel, a);
    }
}
