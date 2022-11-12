// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zbh implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        boolean w = false;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            if (SafeParcelReader.v(c) != 1) {
                SafeParcelReader.I(parcel, c);
            }
            else {
                w = SafeParcelReader.w(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new BeginSignInRequest.PasswordRequestOptions(w);
    }
    
    public final Object[] newArray(final int n) {
        return new BeginSignInRequest.PasswordRequestOptions[n];
    }
}
