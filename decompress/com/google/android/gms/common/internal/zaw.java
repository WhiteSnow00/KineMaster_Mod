// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.IBinder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zaw implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        IBinder d = null;
        ConnectionResult connectionResult = null;
        int e = 0;
        boolean w2;
        boolean w = w2 = false;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        if (v != 4) {
                            if (v != 5) {
                                SafeParcelReader.I(parcel, c);
                            }
                            else {
                                w2 = SafeParcelReader.w(parcel, c);
                            }
                        }
                        else {
                            w = SafeParcelReader.w(parcel, c);
                        }
                    }
                    else {
                        connectionResult = SafeParcelReader.o(parcel, c, ConnectionResult.CREATOR);
                    }
                }
                else {
                    d = SafeParcelReader.D(parcel, c);
                }
            }
            else {
                e = SafeParcelReader.E(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zav(e, d, connectionResult, w, w2);
    }
    
    public final Object[] newArray(final int n) {
        return new zav[n];
    }
}
