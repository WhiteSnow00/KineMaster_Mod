// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zbc implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        int e = 0;
        int w = 0;
        int w3;
        int w2 = w3 = w;
        String[] q = null;
        CredentialPickerConfig credentialPickerConfig2;
        CredentialPickerConfig credentialPickerConfig = credentialPickerConfig2 = null;
        Object p2;
        Object p = p2 = credentialPickerConfig2;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1000) {
                switch (v) {
                    default: {
                        SafeParcelReader.I(parcel, c);
                        continue;
                    }
                    case 8: {
                        w3 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
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
                        w2 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                        continue;
                    }
                    case 4: {
                        credentialPickerConfig2 = SafeParcelReader.o(parcel, c, CredentialPickerConfig.CREATOR);
                        continue;
                    }
                    case 3: {
                        credentialPickerConfig = SafeParcelReader.o(parcel, c, CredentialPickerConfig.CREATOR);
                        continue;
                    }
                    case 2: {
                        q = SafeParcelReader.q(parcel, c);
                        continue;
                    }
                    case 1: {
                        w = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                        continue;
                    }
                }
            }
            else {
                e = SafeParcelReader.E(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new CredentialRequest(e, (boolean)(w != 0), q, credentialPickerConfig, credentialPickerConfig2, (boolean)(w2 != 0), (String)p, (String)p2, (boolean)(w3 != 0));
    }
    
    public final Object[] newArray(final int n) {
        return new CredentialRequest[n];
    }
}
