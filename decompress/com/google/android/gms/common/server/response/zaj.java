// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zaj implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        zaa zaa;
        Object p2 = zaa = null;
        int e = 0;
        int e2 = 0;
        int e3;
        int w = e3 = e2;
        int e4;
        int w2 = e4 = e3;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 9: {
                    zaa = SafeParcelReader.o(parcel, c, com.google.android.gms.common.server.converter.zaa.CREATOR);
                    continue;
                }
                case 8: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 7: {
                    e4 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 6: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 5: {
                    w2 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 4: {
                    e3 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 3: {
                    w = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 2: {
                    e2 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 1: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new FastJsonResponse.Field(e, e2, (boolean)(w != 0), e3, (boolean)(w2 != 0), p, e4, (String)p2, zaa);
    }
    
    public final Object[] newArray(final int n) {
        return new FastJsonResponse.Field[n];
    }
}
