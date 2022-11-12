// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase-auth-api.zzxq;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Class
public class GoogleAuthCredential extends AuthCredential
{
    public static final Parcelable$Creator<GoogleAuthCredential> CREATOR;
    @Field
    private final String a;
    @Field
    private final String b;
    
    static {
        CREATOR = (Parcelable$Creator)new zzaa();
    }
    
    @Constructor
    GoogleAuthCredential(@Param final String a, @Param final String b) {
        if (a == null && b == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        if (a != null && a.length() == 0) {
            throw new IllegalArgumentException("idToken cannot be empty");
        }
        if (b != null && b.length() == 0) {
            throw new IllegalArgumentException("accessToken cannot be empty");
        }
        this.a = a;
        this.b = b;
    }
    
    public static zzxq M1(final GoogleAuthCredential googleAuthCredential, final String s) {
        Preconditions.k(googleAuthCredential);
        return (zzxq)new com.google.android.gms.internal.firebase_auth_api.zzxq(googleAuthCredential.a, googleAuthCredential.b, googleAuthCredential.K1(), (String)null, (String)null, (String)null, s, (String)null, (String)null);
    }
    
    @Override
    public String K1() {
        return "google.com";
    }
    
    @Override
    public final AuthCredential L1() {
        return new GoogleAuthCredential(this.a, this.b);
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.b(parcel, a);
    }
}
