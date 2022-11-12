// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzl implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        boolean w = false;
        int e;
        int w2 = e = 0;
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] k;
        int[] i = k = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 6: {
                    k = SafeParcelReader.j(parcel, c);
                    continue;
                }
                case 5: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 4: {
                    i = SafeParcelReader.j(parcel, c);
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
                case 1: {
                    rootTelemetryConfiguration = SafeParcelReader.o(parcel, c, RootTelemetryConfiguration.CREATOR);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, w, (boolean)(w2 != 0), i, e, k);
    }
    
    public final Object[] newArray(final int n) {
        return new ConnectionTelemetryConfiguration[n];
    }
}
