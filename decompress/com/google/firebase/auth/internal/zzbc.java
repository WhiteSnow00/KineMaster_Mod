// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import java.util.List;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzbc implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        List<PhoneMultiFactorInfo> t = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            if (SafeParcelReader.v(c) != 1) {
                SafeParcelReader.I(parcel, c);
            }
            else {
                t = SafeParcelReader.t(parcel, c, PhoneMultiFactorInfo.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zzbb(t);
    }
    
    public final Object[] newArray(final int n) {
        return new zzbb[n];
    }
}
