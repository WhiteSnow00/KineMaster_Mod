// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zzei extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzei> CREATOR;
    @Field
    private final int a;
    @Field
    private final int b;
    @Field
    private final String c;
    
    static {
        CREATOR = (Parcelable$Creator)new zzej();
    }
    
    public zzei() {
        this(221310600, 221310000, "21.0.0");
    }
    
    @Constructor
    public zzei(@Param final int a, @Param final int b, @Param final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public final int K1() {
        return this.b;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.s(parcel, 2, this.b);
        SafeParcelWriter.B(parcel, 3, this.c, false);
        SafeParcelWriter.b(parcel, a);
    }
}
