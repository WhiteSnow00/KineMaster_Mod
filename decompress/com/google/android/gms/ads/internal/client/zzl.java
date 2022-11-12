// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.ads.zzcfj;
import java.util.ArrayList;
import android.location.Location;
import android.os.Bundle;
import java.util.List;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class zzl extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzl> CREATOR;
    @Field
    public final String A;
    @Field
    public final String B;
    @Deprecated
    @Field
    public final boolean C;
    @Field
    public final zzc D;
    @Field
    public final int E;
    @Field
    public final String F;
    @Field
    public final List G;
    @Field
    public final int H;
    @Field
    public final String I;
    @Field
    public final int a;
    @Deprecated
    @Field
    public final long b;
    @Field
    public final Bundle c;
    @Deprecated
    @Field
    public final int d;
    @Field
    public final List e;
    @Field
    public final boolean f;
    @Field
    public final int g;
    @Field
    public final boolean h;
    @Field
    public final String i;
    @Field
    public final zzfc j;
    @Field
    public final Location p;
    @Field
    public final String w;
    @Field
    public final Bundle x;
    @Field
    public final Bundle y;
    @Field
    public final List z;
    
    static {
        CREATOR = (Parcelable$Creator)new zzn();
    }
    
    @Constructor
    public zzl(@Param final int a, @Param final long b, @Param Bundle bundle, @Param final int d, @Param final List e, @Param final boolean f, @Param final int g, @Param final boolean h, @Param final String i, @Param final zzfc j, @Param final Location p24, @Param final String w, @Param final Bundle bundle2, @Param final Bundle y, @Param final List z, @Param final String a2, @Param final String b2, @Param final boolean c, @Param final zzc d2, @Param final int e2, @Param final String f2, @Param List g2, @Param final int h2, @Param final String k) {
        this.a = a;
        this.b = b;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.c = bundle;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.p = p24;
        this.w = w;
        if (bundle2 == null) {
            bundle = new Bundle();
        }
        else {
            bundle = bundle2;
        }
        this.x = bundle;
        this.y = y;
        this.z = z;
        this.A = a2;
        this.B = b2;
        this.C = c;
        this.D = d2;
        this.E = e2;
        this.F = f2;
        if (g2 == null) {
            g2 = new ArrayList();
        }
        this.G = g2;
        this.H = h2;
        this.I = k;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (!(o instanceof zzl)) {
            return false;
        }
        final zzl zzl = (zzl)o;
        return this.a == zzl.a && this.b == zzl.b && zzcfj.zza(this.c, zzl.c) && this.d == zzl.d && Objects.b(this.e, zzl.e) && this.f == zzl.f && this.g == zzl.g && this.h == zzl.h && Objects.b(this.i, zzl.i) && Objects.b(this.j, zzl.j) && Objects.b(this.p, zzl.p) && Objects.b(this.w, zzl.w) && zzcfj.zza(this.x, zzl.x) && zzcfj.zza(this.y, zzl.y) && Objects.b(this.z, zzl.z) && Objects.b(this.A, zzl.A) && Objects.b(this.B, zzl.B) && this.C == zzl.C && this.E == zzl.E && Objects.b(this.F, zzl.F) && Objects.b(this.G, zzl.G) && this.H == zzl.H && Objects.b(this.I, zzl.I);
    }
    
    @Override
    public final int hashCode() {
        return Objects.c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.p, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.E, this.F, this.G, this.H, this.I);
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.v(parcel, 2, this.b);
        SafeParcelWriter.j(parcel, 3, this.c, false);
        SafeParcelWriter.s(parcel, 4, this.d);
        SafeParcelWriter.D(parcel, 5, this.e, false);
        SafeParcelWriter.g(parcel, 6, this.f);
        SafeParcelWriter.s(parcel, 7, this.g);
        SafeParcelWriter.g(parcel, 8, this.h);
        SafeParcelWriter.B(parcel, 9, this.i, false);
        SafeParcelWriter.A(parcel, 10, (Parcelable)this.j, n, false);
        SafeParcelWriter.A(parcel, 11, (Parcelable)this.p, n, false);
        SafeParcelWriter.B(parcel, 12, this.w, false);
        SafeParcelWriter.j(parcel, 13, this.x, false);
        SafeParcelWriter.j(parcel, 14, this.y, false);
        SafeParcelWriter.D(parcel, 15, this.z, false);
        SafeParcelWriter.B(parcel, 16, this.A, false);
        SafeParcelWriter.B(parcel, 17, this.B, false);
        SafeParcelWriter.g(parcel, 18, this.C);
        SafeParcelWriter.A(parcel, 19, (Parcelable)this.D, n, false);
        SafeParcelWriter.s(parcel, 20, this.E);
        SafeParcelWriter.B(parcel, 21, this.F, false);
        SafeParcelWriter.D(parcel, 22, this.G, false);
        SafeParcelWriter.s(parcel, 23, this.H);
        SafeParcelWriter.B(parcel, 24, this.I, false);
        SafeParcelWriter.b(parcel, a);
    }
}
