// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.server.response;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zaq implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        Parcel m = null;
        int e = 0;
        zan zan = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        SafeParcelReader.I(parcel, c);
                    }
                    else {
                        zan = SafeParcelReader.o(parcel, c, com.google.android.gms.common.server.response.zan.CREATOR);
                    }
                }
                else {
                    m = SafeParcelReader.m(parcel, c);
                }
            }
            else {
                e = SafeParcelReader.E(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new SafeParcelResponse(e, m, zan);
    }
    
    public final Object[] newArray(final int n) {
        return new SafeParcelResponse[n];
    }
}
