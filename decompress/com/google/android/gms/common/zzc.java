// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzc implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        int e = 0;
        long f = -1L;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        SafeParcelReader.I(parcel, c);
                    }
                    else {
                        f = SafeParcelReader.F(parcel, c);
                    }
                }
                else {
                    e = SafeParcelReader.E(parcel, c);
                }
            }
            else {
                p = SafeParcelReader.p(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new Feature(p, e, f);
    }
    
    public final Object[] newArray(final int n) {
        return new Feature[n];
    }
}
