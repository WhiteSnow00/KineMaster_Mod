// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.server;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
@Class
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable
{
    @KeepForSdk
    public static final Parcelable$Creator<FavaDiagnosticsEntity> CREATOR;
    @VersionField
    final int a;
    @Field
    public final String b;
    @Field
    public final int c;
    
    static {
        CREATOR = (Parcelable$Creator)new zaa();
    }
    
    @Constructor
    public FavaDiagnosticsEntity(@Param final int a, @Param final String b, @Param final int c) {
        this.a = a;
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
