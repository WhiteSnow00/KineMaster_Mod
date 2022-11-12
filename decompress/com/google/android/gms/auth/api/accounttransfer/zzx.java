// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzx implements Parcelable$Creator<DeviceMetaData>
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        int e = 0;
        boolean w2;
        boolean w = w2 = false;
        long f = 0L;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        if (v != 4) {
                            SafeParcelReader.I(parcel, c);
                        }
                        else {
                            w2 = SafeParcelReader.w(parcel, c);
                        }
                    }
                    else {
                        f = SafeParcelReader.F(parcel, c);
                    }
                }
                else {
                    w = SafeParcelReader.w(parcel, c);
                }
            }
            else {
                e = SafeParcelReader.E(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new DeviceMetaData(e, w, f, w2);
    }
    
    public final /* bridge */ Object[] newArray(final int n) {
        return new DeviceMetaData[n];
    }
}
