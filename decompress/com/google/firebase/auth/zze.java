// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth_api.zzag;
import com.google.android.gms.internal.firebase-auth-api.zzxq;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Class
public final class zze extends OAuthCredential
{
    public static final Parcelable$Creator<zze> CREATOR;
    @Field
    private final String a;
    @Field
    private final String b;
    @Field
    private final String c;
    @Field
    private final zzxq d;
    @Field
    private final String e;
    @Field
    private final String f;
    @Field
    private final String g;
    
    static {
        CREATOR = (Parcelable$Creator)new zzf();
    }
    
    @Constructor
    zze(@Param final String s, @Param final String b, @Param final String c, @Param final zzxq d, @Param final String e, @Param final String f, @Param final String g) {
        this.a = zzag.zzc(s);
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public static zze P1(final zzxq zzxq) {
        Preconditions.l(zzxq, "Must specify a non-null webSignInCredential");
        return new zze(null, null, null, zzxq, null, null, null);
    }
    
    public static zze Q1(final String s, final String s2, final String s3, final String s4, final String s5) {
        Preconditions.h(s, "Must specify a non-empty providerId");
        if (TextUtils.isEmpty((CharSequence)s2) && TextUtils.isEmpty((CharSequence)s3)) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        return new zze(s, s2, s3, null, s4, s5, null);
    }
    
    public static zzxq R1(final zze zze, final String s) {
        Preconditions.k(zze);
        final zzxq d = zze.d;
        if (d != null) {
            return d;
        }
        return (zzxq)new com.google.android.gms.internal.firebase_auth_api.zzxq(zze.b, zze.c, zze.a, (String)null, zze.f, (String)null, s, zze.e, zze.g);
    }
    
    @Override
    public final String K1() {
        return this.a;
    }
    
    @Override
    public final AuthCredential L1() {
        return new zze(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
    }
    
    @Override
    public final String M1() {
        return this.c;
    }
    
    @Override
    public final String N1() {
        return this.b;
    }
    
    @Override
    public final String O1() {
        return this.f;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.B(parcel, 3, this.c, false);
        SafeParcelWriter.A(parcel, 4, (Parcelable)this.d, n, false);
        SafeParcelWriter.B(parcel, 5, this.e, false);
        SafeParcelWriter.B(parcel, 6, this.f, false);
        SafeParcelWriter.B(parcel, 7, this.g, false);
        SafeParcelWriter.b(parcel, a);
    }
}
