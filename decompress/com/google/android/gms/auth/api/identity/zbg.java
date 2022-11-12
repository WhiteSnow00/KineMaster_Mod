// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zbg implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        boolean w = false;
        boolean w3;
        boolean w2 = w3 = false;
        String p = null;
        Object p2 = null;
        Object r;
        String p3 = (String)(r = p2);
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 7: {
                    w3 = SafeParcelReader.w(parcel, c);
                    continue;
                }
                case 6: {
                    r = SafeParcelReader.r(parcel, c);
                    continue;
                }
                case 5: {
                    p3 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 4: {
                    w2 = SafeParcelReader.w(parcel, c);
                    continue;
                }
                case 3: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 2: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 1: {
                    w = SafeParcelReader.w(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new BeginSignInRequest.GoogleIdTokenRequestOptions(w, p, (String)p2, w2, p3, (List)r, w3);
    }
    
    public final Object[] newArray(final int n) {
        return new BeginSignInRequest.GoogleIdTokenRequestOptions[n];
    }
}
