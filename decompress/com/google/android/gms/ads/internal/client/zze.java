// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.IInterface;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.AdError;
import android.os.IBinder;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zze extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zze> CREATOR;
    @Field
    public final int a;
    @Field
    public final String b;
    @Field
    public final String c;
    @Field
    public zze d;
    @Field
    public IBinder e;
    
    static {
        CREATOR = (Parcelable$Creator)new zzf();
    }
    
    @Constructor
    public zze(@Param final int a, @Param final String b, @Param final String c, @Param final zze d, @Param final IBinder e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public final AdError K1() {
        final zze d = this.d;
        AdError adError;
        if (d == null) {
            adError = null;
        }
        else {
            adError = new AdError(d.a, d.b, d.c);
        }
        return new AdError(this.a, this.b, this.c, adError);
    }
    
    public final LoadAdError L1() {
        final zze d = this.d;
        zzdh zzdh = null;
        AdError adError;
        if (d == null) {
            adError = null;
        }
        else {
            adError = new AdError(d.a, d.b, d.c);
        }
        final int a = this.a;
        final String b = this.b;
        final String c = this.c;
        final IBinder e = this.e;
        if (e != null) {
            final IInterface queryLocalInterface = e.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            if (queryLocalInterface instanceof zzdh) {
                zzdh = (zzdh)queryLocalInterface;
            }
            else {
                zzdh = new zzdf(e);
            }
        }
        return new LoadAdError(a, b, c, adError, ResponseInfo.c(zzdh));
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.B(parcel, 3, this.c, false);
        SafeParcelWriter.A(parcel, 4, (Parcelable)this.d, n, false);
        SafeParcelWriter.r(parcel, 5, this.e, false);
        SafeParcelWriter.b(parcel, a);
    }
}
