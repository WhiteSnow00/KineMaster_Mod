// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.proxy;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Bundle;
import android.app.PendingIntent;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdkWithMembers
@ShowFirstParty
@Class
public class ProxyResponse extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<ProxyResponse> CREATOR;
    @Field
    public final int a;
    @Field
    public final PendingIntent b;
    @Field
    public final int c;
    @Field
    public final byte[] d;
    @VersionField
    final int e;
    @Field
    final Bundle f;
    
    static {
        CREATOR = (Parcelable$Creator)new zzb();
    }
    
    @Constructor
    ProxyResponse(@Param final int e, @Param final int a, @Param final PendingIntent b, @Param final int c, @Param final Bundle f, @Param final byte[] d) {
        this.e = e;
        this.a = a;
        this.c = c;
        this.f = f;
        this.d = d;
        this.b = b;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.A(parcel, 2, (Parcelable)this.b, n, false);
        SafeParcelWriter.s(parcel, 3, this.c);
        SafeParcelWriter.j(parcel, 4, this.f, false);
        SafeParcelWriter.k(parcel, 5, this.d, false);
        SafeParcelWriter.s(parcel, 1000, this.e);
        SafeParcelWriter.b(parcel, a);
    }
}
