// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzk implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        Bundle f = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int e = 0;
        Feature[] array = null;
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
                            connectionTelemetryConfiguration = SafeParcelReader.o(parcel, c, ConnectionTelemetryConfiguration.CREATOR);
                        }
                    }
                    else {
                        e = SafeParcelReader.E(parcel, c);
                    }
                }
                else {
                    array = SafeParcelReader.s(parcel, c, Feature.CREATOR);
                }
            }
            else {
                f = SafeParcelReader.f(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zzj(f, array, e, connectionTelemetryConfiguration);
    }
    
    public final Object[] newArray(final int n) {
        return new zzj[n];
    }
}
