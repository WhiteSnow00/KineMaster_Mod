// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zbe implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        CredentialPickerConfig credentialPickerConfig = null;
        Object q = null;
        Object p2;
        Object p = p2 = q;
        int e = 0;
        int w = 0;
        int w3;
        int w2 = w3 = w;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1000) {
                switch (v) {
                    default: {
                        SafeParcelReader.I(parcel, c);
                        continue;
                    }
                    case 7: {
                        p2 = SafeParcelReader.p(parcel, c);
                        continue;
                    }
                    case 6: {
                        p = SafeParcelReader.p(parcel, c);
                        continue;
                    }
                    case 5: {
                        w3 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                        continue;
                    }
                    case 4: {
                        q = SafeParcelReader.q(parcel, c);
                        continue;
                    }
                    case 3: {
                        w2 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                        continue;
                    }
                    case 2: {
                        w = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                        continue;
                    }
                    case 1: {
                        credentialPickerConfig = SafeParcelReader.o(parcel, c, CredentialPickerConfig.CREATOR);
                        continue;
                    }
                }
            }
            else {
                e = SafeParcelReader.E(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new HintRequest(e, credentialPickerConfig, (boolean)(w != 0), (boolean)(w2 != 0), (String[])q, (boolean)(w3 != 0), (String)p, (String)p2);
    }
    
    public final Object[] newArray(final int n) {
        return new HintRequest[n];
    }
}
