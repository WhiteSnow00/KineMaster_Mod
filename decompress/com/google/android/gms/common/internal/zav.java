// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import android.os.IBinder;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zav extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zav> CREATOR;
    @VersionField
    final int a;
    @Field
    final IBinder b;
    @Field
    private final ConnectionResult c;
    @Field
    private final boolean d;
    @Field
    private final boolean e;
    
    static {
        CREATOR = (Parcelable$Creator)new zaw();
    }
    
    @Constructor
    zav(@Param final int a, @Param final IBinder b, @Param final ConnectionResult c, @Param final boolean d, @Param final boolean e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public final ConnectionResult K1() {
        return this.c;
    }
    
    public final IAccountAccessor L1() {
        final IBinder b = this.b;
        if (b == null) {
            return null;
        }
        return IAccountAccessor.Stub.M0(b);
    }
    
    public final boolean M1() {
        return this.d;
    }
    
    public final boolean N1() {
        return this.e;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof zav)) {
            return false;
        }
        final zav zav = (zav)o;
        return this.c.equals(zav.c) && Objects.b(this.L1(), zav.L1());
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.r(parcel, 2, this.b, false);
        SafeParcelWriter.A(parcel, 3, (Parcelable)this.c, n, false);
        SafeParcelWriter.g(parcel, 4, this.d);
        SafeParcelWriter.g(parcel, 5, this.e);
        SafeParcelWriter.b(parcel, a);
    }
}
