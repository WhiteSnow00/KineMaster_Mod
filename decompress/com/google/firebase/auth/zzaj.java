// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzaj implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        boolean w = false;
        String p = null;
        String p2 = null;
        boolean w2 = false;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
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
                    p2 = SafeParcelReader.p(parcel, c);
                }
            }
            else {
                p = SafeParcelReader.p(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new UserProfileChangeRequest(p, p2, w, w2);
    }
    
    public final Object[] newArray(final int n) {
        return new UserProfileChangeRequest[n];
    }
}
