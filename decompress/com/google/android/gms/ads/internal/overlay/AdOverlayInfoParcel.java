// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.overlay;

import android.os.IInterface;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.os.Bundle;
import android.content.Intent;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.internal.ads.zzcfo;
import com.google.android.gms.internal.ads.zzbnn;
import com.google.android.gms.internal.ads.zzcli;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.internal.ads.zzdjf;
import com.google.android.gms.internal.ads.zzdcf;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.internal.ads.zzfgo;
import com.google.android.gms.internal.ads.zzdwg;
import com.google.android.gms.internal.ads.zzeen;
import com.google.android.gms.internal.ads.zzbnl;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
@Reserved
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable
{
    public static final Parcelable$Creator<AdOverlayInfoParcel> CREATOR;
    @Field
    public final zzbnl A;
    @Field
    public final String B;
    @Field
    public final zzeen C;
    @Field
    public final zzdwg D;
    @Field
    public final zzfgo E;
    @Field
    public final zzbr F;
    @Field
    public final String G;
    @Field
    public final String H;
    @Field
    public final zzdcf I;
    @Field
    public final zzdjf J;
    @Field
    public final zzc a;
    @Field
    public final zza b;
    @Field
    public final zzo c;
    @Field
    public final zzcli d;
    @Field
    public final zzbnn e;
    @Field
    public final String f;
    @Field
    public final boolean g;
    @Field
    public final String h;
    @Field
    public final zzw i;
    @Field
    public final int j;
    @Field
    public final int p;
    @Field
    public final String w;
    @Field
    public final zzcfo x;
    @Field
    public final String y;
    @Field
    public final zzj z;
    
    static {
        CREATOR = (Parcelable$Creator)new zzn();
    }
    
    public AdOverlayInfoParcel(final zza zza, final zzo c, final zzw zzw, final zzcli d, final int j, final zzcfo x, final String y, final zzj z, final String f, final String h, final String h2, final zzdcf i) {
        this.a = null;
        this.b = null;
        this.c = c;
        this.d = d;
        this.A = null;
        this.e = null;
        this.g = false;
        if (zzay.c().zzb(zzbhy.zzaC)) {
            this.f = null;
            this.h = null;
        }
        else {
            this.f = f;
            this.h = h;
        }
        this.i = null;
        this.j = j;
        this.p = 1;
        this.w = null;
        this.x = x;
        this.y = y;
        this.z = z;
        this.B = null;
        this.G = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.H = h2;
        this.I = i;
        this.J = null;
    }
    
    public AdOverlayInfoParcel(final zza b, final zzo c, final zzw i, final zzcli d, final boolean g, final int j, final zzcfo x, final zzdjf k) {
        this.a = null;
        this.b = b;
        this.c = c;
        this.d = d;
        this.A = null;
        this.e = null;
        this.f = null;
        this.g = g;
        this.h = null;
        this.i = i;
        this.j = j;
        this.p = 2;
        this.w = null;
        this.x = x;
        this.y = null;
        this.z = null;
        this.B = null;
        this.G = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.H = null;
        this.I = null;
        this.J = k;
    }
    
    public AdOverlayInfoParcel(final zza b, final zzo c, final zzbnl a, final zzbnn e, final zzw i, final zzcli d, final boolean g, final int j, final String w, final zzcfo x, final zzdjf k) {
        this.a = null;
        this.b = b;
        this.c = c;
        this.d = d;
        this.A = a;
        this.e = e;
        this.f = null;
        this.g = g;
        this.h = null;
        this.i = i;
        this.j = j;
        this.p = 3;
        this.w = w;
        this.x = x;
        this.y = null;
        this.z = null;
        this.B = null;
        this.G = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.H = null;
        this.I = null;
        this.J = k;
    }
    
    public AdOverlayInfoParcel(final zza b, final zzo c, final zzbnl a, final zzbnn e, final zzw i, final zzcli d, final boolean g, final int j, final String h, final String f, final zzcfo x, final zzdjf k) {
        this.a = null;
        this.b = b;
        this.c = c;
        this.d = d;
        this.A = a;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.p = 3;
        this.w = null;
        this.x = x;
        this.y = null;
        this.z = null;
        this.B = null;
        this.G = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.H = null;
        this.I = null;
        this.J = k;
    }
    
    @Constructor
    AdOverlayInfoParcel(@Param final zzc a, @Param final IBinder binder, @Param final IBinder binder2, @Param final IBinder binder3, @Param final IBinder binder4, @Param final String f, @Param final boolean g, @Param final String h, @Param final IBinder binder5, @Param final int j, @Param final int p25, @Param final String w, @Param final zzcfo x, @Param final String y, @Param final zzj z, @Param final IBinder binder6, @Param final String b, @Param final IBinder binder7, @Param final IBinder binder8, @Param final IBinder binder9, @Param final IBinder binder10, @Param final String g2, @Param final String h2, @Param final IBinder binder11, @Param final IBinder binder12) {
        this.a = a;
        this.b = ObjectWrapper.p1(IObjectWrapper.Stub.M0(binder));
        this.c = ObjectWrapper.p1(IObjectWrapper.Stub.M0(binder2));
        this.d = ObjectWrapper.p1(IObjectWrapper.Stub.M0(binder3));
        this.A = ObjectWrapper.p1(IObjectWrapper.Stub.M0(binder6));
        this.e = ObjectWrapper.p1(IObjectWrapper.Stub.M0(binder4));
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = ObjectWrapper.p1(IObjectWrapper.Stub.M0(binder5));
        this.j = j;
        this.p = p25;
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
        this.B = b;
        this.G = g2;
        this.C = ObjectWrapper.p1(IObjectWrapper.Stub.M0(binder7));
        this.D = ObjectWrapper.p1(IObjectWrapper.Stub.M0(binder8));
        this.E = ObjectWrapper.p1(IObjectWrapper.Stub.M0(binder9));
        this.F = ObjectWrapper.p1(IObjectWrapper.Stub.M0(binder10));
        this.H = h2;
        this.I = ObjectWrapper.p1(IObjectWrapper.Stub.M0(binder11));
        this.J = ObjectWrapper.p1(IObjectWrapper.Stub.M0(binder12));
    }
    
    public AdOverlayInfoParcel(final zzc a, final zza b, final zzo c, final zzw i, final zzcfo x, final zzcli d, final zzdjf j) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.A = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = null;
        this.i = i;
        this.j = -1;
        this.p = 4;
        this.w = null;
        this.x = x;
        this.y = null;
        this.z = null;
        this.B = null;
        this.G = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.H = null;
        this.I = null;
        this.J = j;
    }
    
    public AdOverlayInfoParcel(final zzo c, final zzcli d, final int n, final zzcfo x) {
        this.c = c;
        this.d = d;
        this.j = 1;
        this.x = x;
        this.a = null;
        this.b = null;
        this.A = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = null;
        this.i = null;
        this.p = 1;
        this.w = null;
        this.y = null;
        this.z = null;
        this.B = null;
        this.G = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.H = null;
        this.I = null;
        this.J = null;
    }
    
    public AdOverlayInfoParcel(final zzcli d, final zzcfo x, final zzbr f, final zzeen c, final zzdwg d2, final zzfgo e, final String b, final String g, final int n) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = d;
        this.A = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = 14;
        this.p = 5;
        this.w = null;
        this.x = x;
        this.y = null;
        this.z = null;
        this.B = b;
        this.G = g;
        this.C = c;
        this.D = d2;
        this.E = e;
        this.F = f;
        this.H = null;
        this.I = null;
        this.J = null;
    }
    
    public static AdOverlayInfoParcel K1(final Intent intent) {
        try {
            final Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel)bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.A(parcel, 2, (Parcelable)this.a, n, false);
        SafeParcelWriter.r(parcel, 3, ((IInterface)ObjectWrapper.q1(this.b)).asBinder(), false);
        SafeParcelWriter.r(parcel, 4, ((IInterface)ObjectWrapper.q1(this.c)).asBinder(), false);
        SafeParcelWriter.r(parcel, 5, ((IInterface)ObjectWrapper.q1(this.d)).asBinder(), false);
        SafeParcelWriter.r(parcel, 6, ((IInterface)ObjectWrapper.q1(this.e)).asBinder(), false);
        SafeParcelWriter.B(parcel, 7, this.f, false);
        SafeParcelWriter.g(parcel, 8, this.g);
        SafeParcelWriter.B(parcel, 9, this.h, false);
        SafeParcelWriter.r(parcel, 10, ((IInterface)ObjectWrapper.q1(this.i)).asBinder(), false);
        SafeParcelWriter.s(parcel, 11, this.j);
        SafeParcelWriter.s(parcel, 12, this.p);
        SafeParcelWriter.B(parcel, 13, this.w, false);
        SafeParcelWriter.A(parcel, 14, (Parcelable)this.x, n, false);
        SafeParcelWriter.B(parcel, 16, this.y, false);
        SafeParcelWriter.A(parcel, 17, (Parcelable)this.z, n, false);
        SafeParcelWriter.r(parcel, 18, ((IInterface)ObjectWrapper.q1(this.A)).asBinder(), false);
        SafeParcelWriter.B(parcel, 19, this.B, false);
        SafeParcelWriter.r(parcel, 20, ((IInterface)ObjectWrapper.q1(this.C)).asBinder(), false);
        SafeParcelWriter.r(parcel, 21, ((IInterface)ObjectWrapper.q1(this.D)).asBinder(), false);
        SafeParcelWriter.r(parcel, 22, ((IInterface)ObjectWrapper.q1(this.E)).asBinder(), false);
        SafeParcelWriter.r(parcel, 23, ((IInterface)ObjectWrapper.q1(this.F)).asBinder(), false);
        SafeParcelWriter.B(parcel, 24, this.G, false);
        SafeParcelWriter.B(parcel, 25, this.H, false);
        SafeParcelWriter.r(parcel, 26, ((IInterface)ObjectWrapper.q1(this.I)).asBinder(), false);
        SafeParcelWriter.r(parcel, 27, ((IInterface)ObjectWrapper.q1(this.J)).asBinder(), false);
        SafeParcelWriter.b(parcel, a);
    }
}
