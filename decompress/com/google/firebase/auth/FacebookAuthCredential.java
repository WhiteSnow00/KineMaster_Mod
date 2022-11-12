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
public class FacebookAuthCredential extends AuthCredential
{
    public static final Parcelable$Creator<FacebookAuthCredential> CREATOR;
    @Field
    private final String a;
    
    static {
        CREATOR = (Parcelable$Creator)new zzh();
    }
    
    @Constructor
    FacebookAuthCredential(@Param final String s) {
        this.a = Preconditions.g(s);
    }
    
    public static zzxq M1(final FacebookAuthCredential facebookAuthCredential, final String s) {
        Preconditions.k(facebookAuthCredential);
        return (zzxq)new com.google.android.gms.internal.firebase_auth_api.zzxq((String)null, facebookAuthCredential.a, facebookAuthCredential.K1(), (String)null, (String)null, (String)null, s, (String)null, (String)null);
    }
    
    @Override
    public String K1() {
        return "facebook.com";
    }
    
    @Override
    public final AuthCredential L1() {
        return new FacebookAuthCredential(this.a);
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.a, false);
        SafeParcelWriter.b(parcel, a);
    }
}
