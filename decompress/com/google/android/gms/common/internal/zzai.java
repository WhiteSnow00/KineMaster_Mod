// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzai implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        int e = 0;
        int w2;
        int w = w2 = 0;
        int e3;
        int e2 = e3 = w2;
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
                                e3 = SafeParcelReader.E(parcel, c);
                            }
                        }
                        else {
                            e2 = SafeParcelReader.E(parcel, c);
                        }
                    }
                    else {
                        w2 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    }
                }
                else {
                    w = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                }
            }
            else {
                e = SafeParcelReader.E(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new RootTelemetryConfiguration(e, (boolean)(w != 0), (boolean)(w2 != 0), e2, e3);
    }
    
    public final Object[] newArray(final int n) {
        return new RootTelemetryConfiguration[n];
    }
}
