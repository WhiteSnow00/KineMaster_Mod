// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.accounttransfer;

import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzs implements Parcelable$Creator<zzr>
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        List<String> r = null;
        List<String> r3;
        List<String> r2 = r3 = null;
        List<String> r5;
        List<String> r4 = r5 = r3;
        int e = 0;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 6: {
                    r5 = SafeParcelReader.r(parcel, c);
                    continue;
                }
                case 5: {
                    r4 = SafeParcelReader.r(parcel, c);
                    continue;
                }
                case 4: {
                    r3 = SafeParcelReader.r(parcel, c);
                    continue;
                }
                case 3: {
                    r2 = SafeParcelReader.r(parcel, c);
                    continue;
                }
                case 2: {
                    r = SafeParcelReader.r(parcel, c);
                    continue;
                }
                case 1: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zzr(e, r, r2, r3, r4, r5);
    }
    
    public final /* bridge */ Object[] newArray(final int n) {
        return new zzr[n];
    }
}
