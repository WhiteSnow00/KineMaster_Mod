// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.internal.firebase-auth-api.zzxq;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Class
public class TwitterAuthCredential extends AuthCredential
{
    public static final Parcelable$Creator<TwitterAuthCredential> CREATOR;
    @Field
    private String a;
    @Field
    private String b;
    
    static {
        CREATOR = (Parcelable$Creator)new zzai();
    }
    
    @Constructor
    TwitterAuthCredential(@Param final String s, @Param final String s2) {
        this.a = Preconditions.g(s);
        this.b = Preconditions.g(s2);
    }
    
    public static zzxq M1(final TwitterAuthCredential twitterAuthCredential, final String s) {
        Preconditions.k(twitterAuthCredential);
        return (zzxq)new com.google.android.gms.internal.firebase_auth_api.zzxq((String)null, twitterAuthCredential.a, twitterAuthCredential.K1(), (String)null, twitterAuthCredential.b, (String)null, s, (String)null, (String)null);
    }
    
    @Override
    public String K1() {
        return "twitter.com";
    }
    
    @Override
    public final AuthCredential L1() {
        return new TwitterAuthCredential(this.a, this.b);
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        SafeParcelWriter.B(parcel, 2, this.b, false);
        SafeParcelWriter.b(parcel, a);
    }
}
