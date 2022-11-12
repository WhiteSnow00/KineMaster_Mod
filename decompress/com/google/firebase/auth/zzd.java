// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzd implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            SafeParcelReader.v(c);
            SafeParcelReader.I(parcel, c);
        }
        SafeParcelReader.u(parcel, j);
        return new PhoneAuthProvider.ForceResendingToken();
    }
    
    public final Object[] newArray(final int n) {
        return new PhoneAuthProvider.ForceResendingToken[n];
    }
}
