// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzaa implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        long f = 0L;
        long f2 = 0L;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    SafeParcelReader.I(parcel, c);
                }
                else {
                    f2 = SafeParcelReader.F(parcel, c);
                }
            }
            else {
                f = SafeParcelReader.F(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zzz(f, f2);
    }
    
    public final Object[] newArray(final int n) {
        return new zzz[n];
    }
}
