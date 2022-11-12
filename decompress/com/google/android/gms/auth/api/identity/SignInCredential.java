// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import android.net.Uri;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public final class SignInCredential extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<SignInCredential> CREATOR;
    @Field
    private final String a;
    @Field
    private final String b;
    @Field
    private final String c;
    @Field
    private final String d;
    @Field
    private final Uri e;
    @Field
    private final String f;
    @Field
    private final String g;
    @Field
    private final String h;
    
    static {
        CREATOR = (Parcelable$Creator)new zbm();
    }
    
    @Constructor
    public SignInCredential(@Param final String s, @Param final String b, @Param final String c, @Param final String d, @Param final Uri e, @Param final String f, @Param final String g, @Param final String h) {
        this.a = Preconditions.g(s);
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    public String K1() {
        return this.b;
    }
    
    public String L1() {
        return this.d;
    }
    
    public String M1() {
        return this.c;
    }
    
    public String N1() {
        return this.g;
    }
    
    public String O1() {
        return this.a;
    }
    
    public String P1() {
        return this.f;
    }
    
    public Uri Q1() {
        return this.e;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof SignInCredential)) {
            return false;
        }
        final SignInCredential signInCredential = (SignInCredential)o;
        return Objects.b(this.a, signInCredential.a) && Objects.b(this.b, signInCredential.b) && Objects.b(this.c, signInCredential.c) && Objects.b(this.d, signInCredential.d) && Objects.b(this.e, signInCredential.e) && Objects.b(this.f, signInCredential.f) && Objects.b(this.g, signInCredential.g) && Objects.b(this.h, signInCredential.h);
    }
    
    @Override
    public int hashCode() {
        return Objects.c(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 1, this.O1(), false);
        SafeParcelWriter.B(parcel, 2, this.K1(), false);
        SafeParcelWriter.B(parcel, 3, this.M1(), false);
        SafeParcelWriter.B(parcel, 4, this.L1(), false);
        SafeParcelWriter.A(parcel, 5, (Parcelable)this.Q1(), n, false);
        SafeParcelWriter.B(parcel, 6, this.P1(), false);
        SafeParcelWriter.B(parcel, 7, this.N1(), false);
        SafeParcelWriter.B(parcel, 8, this.h, false);
        SafeParcelWriter.b(parcel, a);
    }
}
