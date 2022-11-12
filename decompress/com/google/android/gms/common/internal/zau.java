// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.accounts.Account;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zau implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        Account account = null;
        int e = 0;
        int e2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        if (v != 4) {
                            SafeParcelReader.I(parcel, c);
                        }
                        else {
                            googleSignInAccount = SafeParcelReader.o(parcel, c, GoogleSignInAccount.CREATOR);
                        }
                    }
                    else {
                        e2 = SafeParcelReader.E(parcel, c);
                    }
                }
                else {
                    account = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<Account>)Account.CREATOR);
                }
            }
            else {
                e = SafeParcelReader.E(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zat(e, account, e2, googleSignInAccount);
    }
    
    public final Object[] newArray(final int n) {
        return new zat[n];
    }
}
