// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.IBinder;
import android.content.Context;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zzo extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzo> CREATOR;
    @Field
    private final String a;
    @Field
    private final boolean b;
    @Field
    private final boolean c;
    @Field
    private final Context d;
    @Field
    private final boolean e;
    
    static {
        CREATOR = (Parcelable$Creator)new zzp();
    }
    
    @Constructor
    zzo(@Param final String a, @Param final boolean b, @Param final boolean c, @Param final IBinder binder, @Param final boolean e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = ObjectWrapper.p1(IObjectWrapper.Stub.M0(binder));
        this.e = e;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        SafeParcelWriter.g(parcel, 2, this.b);
        SafeParcelWriter.g(parcel, 3, this.c);
        SafeParcelWriter.r(parcel, 4, (IBinder)ObjectWrapper.q1(this.d), false);
        SafeParcelWriter.g(parcel, 5, this.e);
        SafeParcelWriter.b(parcel, a);
    }
}
