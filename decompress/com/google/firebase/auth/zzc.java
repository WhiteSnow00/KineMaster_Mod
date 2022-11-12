// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzc implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        boolean w = false;
        int e;
        int w2 = e = 0;
        String p = null;
        String p3;
        String p2 = p3 = null;
        String p5;
        String p4 = p5 = p3;
        String p7;
        String p6 = p7 = p5;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 10: {
                    p7 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 9: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 8: {
                    p6 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 7: {
                    w2 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 6: {
                    p5 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 5: {
                    w = SafeParcelReader.w(parcel, c);
                    continue;
                }
                case 4: {
                    p4 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 3: {
                    p3 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 2: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 1: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new ActionCodeSettings(p, p2, p3, p4, w, p5, (boolean)(w2 != 0), p6, e, p7);
    }
    
    public final Object[] newArray(final int n) {
        return new ActionCodeSettings[n];
    }
}
