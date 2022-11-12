// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<GoogleSignInOptionsExtensionParcelable> CREATOR;
    @VersionField
    final int a;
    @Field
    private int b;
    @Field
    private Bundle c;
    
    static {
        CREATOR = (Parcelable$Creator)new zaa();
    }
    
    @Constructor
    GoogleSignInOptionsExtensionParcelable(@Param final int a, @Param final int b, @Param final Bundle c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @KeepForSdk
    public int K1() {
        return this.b;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 1, this.a);
        SafeParcelWriter.s(parcel, 2, this.K1());
        SafeParcelWriter.j(parcel, 3, this.c, false);
        SafeParcelWriter.b(parcel, a);
    }
}
