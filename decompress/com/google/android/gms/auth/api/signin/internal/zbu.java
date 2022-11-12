// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zbu implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 2) {
                if (v != 5) {
                    SafeParcelReader.I(parcel, c);
                }
                else {
                    googleSignInOptions = SafeParcelReader.o(parcel, c, GoogleSignInOptions.CREATOR);
                }
            }
            else {
                p = SafeParcelReader.p(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new SignInConfiguration(p, googleSignInOptions);
    }
    
    public final Object[] newArray(final int n) {
        return new SignInConfiguration[n];
    }
}
