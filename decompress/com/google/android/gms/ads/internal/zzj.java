// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
@Reserved
public final class zzj extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzj> CREATOR;
    @Field
    public final boolean a;
    @Field
    public final boolean b;
    @Field
    public final String c;
    @Field
    public final boolean d;
    @Field
    public final float e;
    @Field
    public final int f;
    @Field
    public final boolean g;
    @Field
    public final boolean h;
    @Field
    public final boolean i;
    
    static {
        CREATOR = (Parcelable$Creator)new zzk();
    }
    
    @Constructor
    zzj(@Param final boolean a, @Param final boolean b, @Param final String c, @Param final boolean d, @Param final float e, @Param final int f, @Param final boolean g, @Param final boolean h, @Param final boolean i) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    public zzj(final boolean b, final boolean b2, final boolean b3, final float n, final int n2, final boolean b4, final boolean b5, final boolean b6) {
        this(b, b2, null, b3, n, -1, b4, b5, b6);
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 2, this.a);
        SafeParcelWriter.g(parcel, 3, this.b);
        SafeParcelWriter.B(parcel, 4, this.c, false);
        SafeParcelWriter.g(parcel, 5, this.d);
        SafeParcelWriter.o(parcel, 6, this.e);
        SafeParcelWriter.s(parcel, 7, this.f);
        SafeParcelWriter.g(parcel, 8, this.g);
        SafeParcelWriter.g(parcel, 9, this.h);
        SafeParcelWriter.g(parcel, 10, this.i);
        SafeParcelWriter.b(parcel, a);
    }
}
