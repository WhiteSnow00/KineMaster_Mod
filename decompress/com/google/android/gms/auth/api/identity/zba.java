// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zba implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        boolean w = false;
        int e = 0;
        AbstractSafeParcelable abstractSafeParcelable = null;
        String p;
        Object o = p = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        if (v != 4) {
                            if (v != 5) {
                                SafeParcelReader.I(parcel, c);
                            }
                            else {
                                e = SafeParcelReader.E(parcel, c);
                            }
                        }
                        else {
                            w = SafeParcelReader.w(parcel, c);
                        }
                    }
                    else {
                        p = SafeParcelReader.p(parcel, c);
                    }
                }
                else {
                    o = SafeParcelReader.o(parcel, c, BeginSignInRequest.GoogleIdTokenRequestOptions.CREATOR);
                }
            }
            else {
                abstractSafeParcelable = SafeParcelReader.o(parcel, c, BeginSignInRequest.PasswordRequestOptions.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new BeginSignInRequest((BeginSignInRequest.PasswordRequestOptions)abstractSafeParcelable, (BeginSignInRequest.GoogleIdTokenRequestOptions)o, p, w, e);
    }
    
    public final Object[] newArray(final int n) {
        return new BeginSignInRequest[n];
    }
}
