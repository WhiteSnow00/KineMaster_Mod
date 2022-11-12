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
public class MethodInvocation extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<MethodInvocation> CREATOR;
    @Field
    private final int a;
    @Field
    private final int b;
    @Field
    private final int c;
    @Field
    private final long d;
    @Field
    private final long e;
    @Field
    private final String f;
    @Field
    private final String g;
    @Field
    private final int h;
    @Field
    private final int i;
    
    static {
        CREATOR = (Parcelable$Creator)new zan();
    }
    
    @Constructor
    public MethodInvocation(@Param final int a, @Param final int b, @Param final int c, @Param final long d, @Param final long e, @Param final String f, @Param final String g, @Param final int h, @Param final int i) {
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
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.s(parcel, 2, this.b);
        SafeParcelWriter.s(parcel, 3, this.c);
        SafeParcelWriter.v(parcel, 4, this.d);
        SafeParcelWriter.v(parcel, 5, this.e);
        SafeParcelWriter.B(parcel, 6, this.f, false);
        SafeParcelWriter.B(parcel, 7, this.g, false);
        SafeParcelWriter.s(parcel, 8, this.h);
        SafeParcelWriter.s(parcel, 9, this.i);
        SafeParcelWriter.b(parcel, a);
    }
}
