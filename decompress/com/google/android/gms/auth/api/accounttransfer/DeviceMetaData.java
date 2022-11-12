// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class DeviceMetaData extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<DeviceMetaData> CREATOR;
    @VersionField
    final int a;
    @Field
    private boolean b;
    @Field
    private long c;
    @Field
    private final boolean d;
    
    static {
        CREATOR = (Parcelable$Creator)new zzx();
    }
    
    @Constructor
    DeviceMetaData(@Param final int a, @Param final boolean b, @Param final long c, @Param final boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public long K1() {
        return this.c;
    }
    
    public boolean L1() {
        return this.d;
    }
    
    public boolean M1() {
        return this.b;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.g(parcel, 2, this.M1());
        SafeParcelWriter.v(parcel, 3, this.K1());
        SafeParcelWriter.g(parcel, 4, this.L1());
        SafeParcelWriter.b(parcel, a);
    }
}
