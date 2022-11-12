// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class ModuleAvailabilityResponse extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<ModuleAvailabilityResponse> CREATOR;
    @Field
    private final boolean a;
    @Field
    private final int b;
    
    static {
        CREATOR = (Parcelable$Creator)new zaa();
    }
    
    @KeepForSdk
    @Constructor
    public ModuleAvailabilityResponse(@Param final boolean a, @Param final int b) {
        this.a = a;
        this.b = b;
    }
    
    public boolean K1() {
        return this.a;
    }
    
    @AvailabilityStatus
    public int L1() {
        return this.b;
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, this.K1());
        SafeParcelWriter.s(parcel, 2, this.L1());
        SafeParcelWriter.b(parcel, a);
    }
    
    @Retention(RetentionPolicy.CLASS)
    public @interface AvailabilityStatus {
    }
}
