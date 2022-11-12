// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
@Reserved
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable
{
    public static final Parcelable$Creator<SignInAccount> CREATOR;
    @Deprecated
    @Field
    String a;
    @Field
    private GoogleSignInAccount b;
    @Deprecated
    @Field
    String c;
    
    static {
        CREATOR = (Parcelable$Creator)new zbc();
    }
    
    @Constructor
    SignInAccount(@Param final String s, @Param final GoogleSignInAccount b, @Param final String s2) {
        this.b = b;
        this.a = Preconditions.h(s, "8.3 and 8.4 SDKs require non-null email");
        this.c = Preconditions.h(s2, "8.3 and 8.4 SDKs require non-null userId");
    }
    
    public final GoogleSignInAccount K1() {
        return this.b;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 4, this.a, false);
        SafeParcelWriter.A(parcel, 7, (Parcelable)this.b, n, false);
        SafeParcelWriter.B(parcel, 8, this.c, false);
        SafeParcelWriter.b(parcel, a);
    }
}
