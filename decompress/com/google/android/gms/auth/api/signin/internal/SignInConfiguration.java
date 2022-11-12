// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
@Reserved
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable
{
    public static final Parcelable$Creator<SignInConfiguration> CREATOR;
    @Field
    private final String a;
    @Field
    private GoogleSignInOptions b;
    
    static {
        CREATOR = (Parcelable$Creator)new zbu();
    }
    
    @Constructor
    public SignInConfiguration(@Param final String s, @Param final GoogleSignInOptions b) {
        this.a = Preconditions.g(s);
        this.b = b;
    }
    
    public final GoogleSignInOptions K1() {
        return this.b;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (!(o instanceof SignInConfiguration)) {
            return false;
        }
        final SignInConfiguration signInConfiguration = (SignInConfiguration)o;
        if (this.a.equals(signInConfiguration.a)) {
            final GoogleSignInOptions b = this.b;
            final GoogleSignInOptions b2 = signInConfiguration.b;
            if (b == null) {
                if (b2 != null) {
                    return false;
                }
            }
            else if (!b.equals(b2)) {
                return false;
            }
            return true;
        }
        return false;
    }
    
    @Override
    public final int hashCode() {
        return new HashAccumulator().a(this.a).a(this.b).b();
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 2, this.a, false);
        SafeParcelWriter.A(parcel, 5, (Parcelable)this.b, n, false);
        SafeParcelWriter.b(parcel, a);
    }
}
