// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzfh implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        boolean w = false;
        boolean w2 = false;
        boolean w3 = false;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 2) {
                if (v != 3) {
                    if (v != 4) {
                        SafeParcelReader.I(parcel, c);
                    }
                    else {
                        w3 = SafeParcelReader.w(parcel, c);
                    }
                }
                else {
                    w2 = SafeParcelReader.w(parcel, c);
                }
            }
            else {
                w = SafeParcelReader.w(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zzfg(w, w2, w3);
    }
    
    public final Object[] newArray(final int n) {
        return new zzfg[n];
    }
}
