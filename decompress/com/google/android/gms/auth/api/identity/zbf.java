// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zbf implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        boolean w = false;
        int e = 0;
        String p = null;
        String p2 = null;
        String p4;
        String p3 = p4 = p2;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 6: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 5: {
                    w = SafeParcelReader.w(parcel, c);
                    continue;
                }
                case 4: {
                    p4 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 3: {
                    p3 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 2: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 1: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new GetSignInIntentRequest(p, p2, p3, p4, w, e);
    }
    
    public final Object[] newArray(final int n) {
        return new GetSignInIntentRequest[n];
    }
}
