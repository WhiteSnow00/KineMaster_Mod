// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.common.api.Scope;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
@Class
@Reserved
public class GetServiceRequest extends AbstractSafeParcelable
{
    static final Feature[] A;
    public static final Parcelable$Creator<GetServiceRequest> CREATOR;
    static final Scope[] z;
    @VersionField
    final int a;
    @Field
    final int b;
    @Field
    int c;
    @Field
    String d;
    @Field
    IBinder e;
    @Field
    Scope[] f;
    @Field
    Bundle g;
    @Field
    Account h;
    @Field
    Feature[] i;
    @Field
    Feature[] j;
    @Field
    boolean p;
    @Field
    int w;
    @Field
    boolean x;
    @Field
    private String y;
    
    static {
        CREATOR = (Parcelable$Creator)new zzm();
        z = new Scope[0];
        A = new Feature[0];
    }
    
    @Constructor
    GetServiceRequest(@Param final int a, @Param final int b, @Param final int c, @Param final String d, @Param final IBinder e, @Param final Scope[] array, @Param final Bundle bundle, @Param final Account h, @Param Feature[] a2, @Param final Feature[] array2, @Param final boolean p14, @Param final int w, @Param final boolean x, @Param final String y) {
        Scope[] z = array;
        if (array == null) {
            z = GetServiceRequest.z;
        }
        Bundle g;
        if ((g = bundle) == null) {
            g = new Bundle();
        }
        Feature[] a3;
        if ((a3 = a2) == null) {
            a3 = GetServiceRequest.A;
        }
        if ((a2 = array2) == null) {
            a2 = GetServiceRequest.A;
        }
        this.a = a;
        this.b = b;
        this.c = c;
        if ("com.google.android.gms".equals(d)) {
            this.d = "com.google.android.gms";
        }
        else {
            this.d = d;
        }
        if (a < 2) {
            Account p15;
            if (e != null) {
                p15 = AccountAccessor.p1(IAccountAccessor.Stub.M0(e));
            }
            else {
                p15 = null;
            }
            this.h = p15;
        }
        else {
            this.e = e;
            this.h = h;
        }
        this.f = z;
        this.g = g;
        this.i = a3;
        this.j = a2;
        this.p = p14;
        this.w = w;
        this.x = x;
        this.y = y;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        zzm.a(this, parcel, n);
    }
    
    public final String zza() {
        return this.y;
    }
}
