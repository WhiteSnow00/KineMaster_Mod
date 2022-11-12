// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class SignInPassword extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<SignInPassword> CREATOR;
    @Field
    private final String a;
    @Field
    private final String b;
    
    static {
        CREATOR = (Parcelable$Creator)new zbo();
    }
    
    @Constructor
    public SignInPassword(@Param final String s, @Param final String s2) {
        this.a = Preconditions.h(Preconditions.l(s, "Account identifier cannot be null").trim(), "Account identifier cannot be empty");
        this.b = Preconditions.g(s2);
    }
    
    public String K1() {
        return this.a;
    }
    
    public String L1() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof SignInPassword)) {
            return false;
        }
        final SignInPassword signInPassword = (SignInPassword)o;
        return Objects.b(this.a, signInPassword.a) && Objects.b(this.b, signInPassword.b);
    }
    
    @Override
    public int hashCode() {
        return Objects.c(this.a, this.b);
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.K1(), false);
        SafeParcelWriter.B(parcel, 2, this.L1(), false);
        SafeParcelWriter.b(parcel, a);
    }
}
