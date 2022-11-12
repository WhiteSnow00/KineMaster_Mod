// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
@Class
public class RootTelemetryConfiguration extends AbstractSafeParcelable
{
    @KeepForSdk
    public static final Parcelable$Creator<RootTelemetryConfiguration> CREATOR;
    @Field
    private final int a;
    @Field
    private final boolean b;
    @Field
    private final boolean c;
    @Field
    private final int d;
    @Field
    private final int e;
    
    static {
        CREATOR = (Parcelable$Creator)new zzai();
    }
    
    @Constructor
    public RootTelemetryConfiguration(@Param final int a, @Param final boolean b, @Param final boolean c, @Param final int d, @Param final int e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    @KeepForSdk
    public int K1() {
        return this.d;
    }
    
    @KeepForSdk
    public int L1() {
        return this.e;
    }
    
    @KeepForSdk
    public boolean M1() {
        return this.b;
    }
    
    @KeepForSdk
    public boolean N1() {
        return this.c;
    }
    
    @KeepForSdk
    public int O1() {
        return this.a;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.O1());
        SafeParcelWriter.g(parcel, 2, this.M1());
        SafeParcelWriter.g(parcel, 3, this.N1());
        SafeParcelWriter.s(parcel, 4, this.K1());
        SafeParcelWriter.s(parcel, 5, this.L1());
        SafeParcelWriter.b(parcel, a);
    }
}
