// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zza implements Parcelable$Creator<AccountChangeEvent>
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        String p2 = null;
        int e = 0;
        int e3;
        int e2 = e3 = 0;
        long f = 0L;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 6: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 5: {
                    e3 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 4: {
                    e2 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 3: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 2: {
                    f = SafeParcelReader.F(parcel, c);
                    continue;
                }
                case 1: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new AccountChangeEvent(e, f, p, e2, e3, p2);
    }
    
    public final /* bridge */ Object[] newArray(final int n) {
        return new AccountChangeEvent[n];
    }
}
