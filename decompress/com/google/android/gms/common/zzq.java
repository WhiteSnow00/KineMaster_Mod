// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import javax.annotation.Nullable;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zzq extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzq> CREATOR;
    @Field
    private final boolean a;
    @Nullable
    @Field
    private final String b;
    @Field
    private final int c;
    @Field
    private final int d;
    
    static {
        CREATOR = (Parcelable$Creator)new zzr();
    }
    
    @Constructor
    zzq(@Param final boolean a, @Param final String b, @Param final int n, @Param final int n2) {
        this.a = a;
        this.b = b;
        this.c = o.a(n) - 1;
        this.d = com.google.android.gms.common.c.a(n2) - 1;
    }
    
    public final boolean K1() {
        return this.a;
    }
    
    public final int L1() {
        return com.google.android.gms.common.c.a(this.d);
    }
    
    public final int M1() {
        return o.a(this.c);
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, this.a);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.s(parcel, 3, this.c);
        SafeParcelWriter.s(parcel, 4, this.d);
        SafeParcelWriter.b(parcel, a);
    }
    
    @Nullable
    public final String zza() {
        return this.b;
    }
}
