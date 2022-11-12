// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.server.response;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zak implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        int e = 0;
        FastJsonResponse.Field field = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        SafeParcelReader.I(parcel, c);
                    }
                    else {
                        field = (FastJsonResponse.Field)SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<FastJsonResponse.Field>)FastJsonResponse.Field.CREATOR);
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
        return new zam(e, p, field);
    }
    
    public final Object[] newArray(final int n) {
        return new zam[n];
    }
}
