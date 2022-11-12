// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zbc implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = "";
        GoogleSignInAccount googleSignInAccount = null;
        String p2 = "";
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 4) {
                if (v != 7) {
                    if (v != 8) {
                        SafeParcelReader.I(parcel, c);
                    }
                    else {
                        p2 = SafeParcelReader.p(parcel, c);
                    }
                }
                else {
                    googleSignInAccount = SafeParcelReader.o(parcel, c, GoogleSignInAccount.CREATOR);
                }
            }
            else {
                p = SafeParcelReader.p(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new SignInAccount(p, googleSignInAccount, p2);
    }
    
    public final Object[] newArray(final int n) {
        return new SignInAccount[n];
    }
}
