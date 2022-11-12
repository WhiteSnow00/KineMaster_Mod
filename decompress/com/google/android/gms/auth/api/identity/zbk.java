// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zbk implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        SignInPassword signInPassword = null;
        int e = 0;
        String p = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        SafeParcelReader.I(parcel, c);
                    }
                    else {
                        e = SafeParcelReader.E(parcel, c);
                    }
                }
                else {
                    p = SafeParcelReader.p(parcel, c);
                }
            }
            else {
                signInPassword = SafeParcelReader.o(parcel, c, SignInPassword.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new SavePasswordRequest(signInPassword, p, e);
    }
    
    public final Object[] newArray(final int n) {
        return new SavePasswordRequest[n];
    }
}
