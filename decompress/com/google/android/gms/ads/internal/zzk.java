// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzk implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        boolean w = false;
        int w3;
        int w2 = w3 = 0;
        int w4;
        int e = w4 = w3;
        int w6;
        int w5 = w6 = w4;
        String p = null;
        float a = 0.0f;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 10: {
                    w6 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 9: {
                    w5 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 8: {
                    w4 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 7: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 6: {
                    a = SafeParcelReader.A(parcel, c);
                    continue;
                }
                case 5: {
                    w3 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 4: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 3: {
                    w2 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 2: {
                    w = SafeParcelReader.w(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zzj(w, (boolean)(w2 != 0), p, (boolean)(w3 != 0), a, e, (boolean)(w4 != 0), (boolean)(w5 != 0), (boolean)(w6 != 0));
    }
    
    public final Object[] newArray(final int n) {
        return new zzj[n];
    }
}
