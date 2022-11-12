// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
@Class
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable
{
    @KeepForSdk
    public static final Parcelable$Creator<ConnectionTelemetryConfiguration> CREATOR;
    @Field
    private final RootTelemetryConfiguration a;
    @Field
    private final boolean b;
    @Field
    private final boolean c;
    @Field
    private final int[] d;
    @Field
    private final int e;
    @Field
    private final int[] f;
    
    static {
        CREATOR = (Parcelable$Creator)new zzl();
    }
    
    @Constructor
    public ConnectionTelemetryConfiguration(@Param final RootTelemetryConfiguration a, @Param final boolean b, @Param final boolean c, @Param final int[] d, @Param final int e, @Param final int[] f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    @KeepForSdk
    public int K1() {
        return this.e;
    }
    
    @KeepForSdk
    public int[] L1() {
        return this.d;
    }
    
    @KeepForSdk
    public int[] M1() {
        return this.f;
    }
    
    @KeepForSdk
    public boolean N1() {
        return this.b;
    }
    
    @KeepForSdk
    public boolean O1() {
        return this.c;
    }
    
    public final RootTelemetryConfiguration P1() {
        return this.a;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.A(parcel, 1, (Parcelable)this.a, n, false);
        SafeParcelWriter.g(parcel, 2, this.N1());
        SafeParcelWriter.g(parcel, 3, this.O1());
        SafeParcelWriter.t(parcel, 4, this.L1(), false);
        SafeParcelWriter.s(parcel, 5, this.K1());
        SafeParcelWriter.t(parcel, 6, this.M1(), false);
        SafeParcelWriter.b(parcel, a);
    }
}
