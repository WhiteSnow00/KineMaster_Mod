// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.overlay;

import android.os.IInterface;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.IBinder;
import com.google.android.gms.dynamic.ObjectWrapper;
import android.content.Intent;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
@Reserved
public final class zzc extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzc> CREATOR;
    @Field
    public final String a;
    @Field
    public final String b;
    @Field
    public final String c;
    @Field
    public final String d;
    @Field
    public final String e;
    @Field
    public final String f;
    @Field
    public final String g;
    @Field
    public final Intent h;
    @Field
    public final zzu i;
    @Field
    public final boolean j;
    
    static {
        CREATOR = (Parcelable$Creator)new zzb();
    }
    
    public zzc(final Intent intent, final zzu zzu) {
        this(null, null, null, null, null, null, null, intent, ((IInterface)ObjectWrapper.q1(zzu)).asBinder(), false);
    }
    
    @Constructor
    public zzc(@Param final String a, @Param final String b, @Param final String c, @Param final String d, @Param final String e, @Param final String f, @Param final String g, @Param final Intent h, @Param final IBinder binder, @Param final boolean j) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = ObjectWrapper.p1(IObjectWrapper.Stub.M0(binder));
        this.j = j;
    }
    
    public zzc(final String s, final String s2, final String s3, final String s4, final String s5, final String s6, final String s7, final zzu zzu) {
        this(s, s2, s3, s4, s5, s6, s7, null, ((IInterface)ObjectWrapper.q1(zzu)).asBinder(), false);
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 2, this.a, false);
        SafeParcelWriter.B(parcel, 3, this.b, false);
        SafeParcelWriter.B(parcel, 4, this.c, false);
        SafeParcelWriter.B(parcel, 5, this.d, false);
        SafeParcelWriter.B(parcel, 6, this.e, false);
        SafeParcelWriter.B(parcel, 7, this.f, false);
        SafeParcelWriter.B(parcel, 8, this.g, false);
        SafeParcelWriter.A(parcel, 9, (Parcelable)this.h, n, false);
        SafeParcelWriter.r(parcel, 10, ((IInterface)ObjectWrapper.q1(this.i)).asBinder(), false);
        SafeParcelWriter.g(parcel, 11, this.j);
        SafeParcelWriter.b(parcel, a);
    }
}
