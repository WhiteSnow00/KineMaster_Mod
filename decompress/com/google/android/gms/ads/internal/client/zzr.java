// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzr implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        zzq[] array = null;
        int e = 0;
        int w;
        int e2 = w = 0;
        int e4;
        int e3 = e4 = w;
        int w3;
        int w2 = w3 = e4;
        int w5;
        int w4 = w5 = w3;
        int w7;
        int w6 = w7 = w5;
        int w9;
        int w8 = w9 = w7;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 16: {
                    w9 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 15: {
                    w8 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 14: {
                    w7 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 13: {
                    w6 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 12: {
                    w5 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 11: {
                    w4 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 10: {
                    w3 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 9: {
                    w2 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 8: {
                    array = SafeParcelReader.s(parcel, c, zzq.CREATOR);
                    continue;
                }
                case 7: {
                    e4 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 6: {
                    e3 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 5: {
                    w = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 4: {
                    e2 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 3: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 2: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zzq(p, e, e2, (boolean)(w != 0), e3, e4, array, (boolean)(w2 != 0), (boolean)(w3 != 0), (boolean)(w4 != 0), (boolean)(w5 != 0), (boolean)(w6 != 0), (boolean)(w7 != 0), (boolean)(w8 != 0), (boolean)(w9 != 0));
    }
    
    public final Object[] newArray(final int n) {
        return new zzq[n];
    }
}
