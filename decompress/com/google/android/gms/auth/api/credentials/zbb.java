// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zbb implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        int e = 0;
        int w2;
        int w = w2 = 0;
        int e2;
        int w3 = e2 = w2;
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
                            e2 = SafeParcelReader.E(parcel, c);
                        }
                    }
                    else {
                        w3 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
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
        SafeParcelReader.u(parcel, j);
        return new CredentialPickerConfig(e, (boolean)(w != 0), (boolean)(w2 != 0), (boolean)(w3 != 0), e2);
    }
    
    public final Object[] newArray(final int n) {
        return new CredentialPickerConfig[n];
    }
}
