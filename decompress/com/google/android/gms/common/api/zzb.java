// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzb implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        int e = 0;
        int e2 = 0;
        String p = null;
        ConnectionResult connectionResult;
        Object o = connectionResult = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        if (v != 4) {
                            if (v != 1000) {
                                SafeParcelReader.I(parcel, c);
                            }
                            else {
                                e = SafeParcelReader.E(parcel, c);
                            }
                        }
                        else {
                            connectionResult = SafeParcelReader.o(parcel, c, ConnectionResult.CREATOR);
                        }
                    }
                    else {
                        o = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<PendingIntent>)PendingIntent.CREATOR);
                    }
                }
                else {
                    p = SafeParcelReader.p(parcel, c);
                }
            }
            else {
                e2 = SafeParcelReader.E(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new Status(e, e2, p, (PendingIntent)o, connectionResult);
    }
    
    public final Object[] newArray(final int n) {
        return new Status[n];
    }
}
