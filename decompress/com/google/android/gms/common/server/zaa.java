// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.server;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zaa implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        int e = 0;
        String p = null;
        int e2 = 0;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        SafeParcelReader.I(parcel, c);
                    }
                    else {
                        e2 = SafeParcelReader.E(parcel, c);
                    }
                }
                else {
                    p = SafeParcelReader.p(parcel, c);
                }
            }
            else {
                e = SafeParcelReader.E(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new FavaDiagnosticsEntity(e, p, e2);
    }
    
    public final Object[] newArray(final int n) {
        return new FavaDiagnosticsEntity[n];
    }
}
