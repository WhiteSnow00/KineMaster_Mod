// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import java.util.List;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzah implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        String p2 = null;
        List<PhoneMultiFactorInfo> t = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        SafeParcelReader.I(parcel, c);
                    }
                    else {
                        t = SafeParcelReader.t(parcel, c, PhoneMultiFactorInfo.CREATOR);
                    }
                }
                else {
                    p2 = SafeParcelReader.p(parcel, c);
                }
            }
            else {
                p = SafeParcelReader.p(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zzag(p, p2, t);
    }
    
    public final Object[] newArray(final int n) {
        return new zzag[n];
    }
}
