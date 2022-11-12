// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth;

import java.io.Serializable;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzm implements Parcelable$Creator<TokenData>
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        int e = 0;
        boolean w2;
        boolean w = w2 = false;
        String p = null;
        Serializable g = null;
        Serializable p2;
        Serializable r = p2 = g;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 7: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 6: {
                    r = SafeParcelReader.r(parcel, c);
                    continue;
                }
                case 5: {
                    w2 = SafeParcelReader.w(parcel, c);
                    continue;
                }
                case 4: {
                    w = SafeParcelReader.w(parcel, c);
                    continue;
                }
                case 3: {
                    g = SafeParcelReader.G(parcel, c);
                    continue;
                }
                case 2: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 1: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new TokenData(e, p, (Long)g, w, w2, (List<String>)r, (String)p2);
    }
    
    public final /* bridge */ Object[] newArray(final int n) {
        return new TokenData[n];
    }
}
