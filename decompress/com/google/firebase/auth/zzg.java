// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzg implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        String p2 = null;
        String p4;
        String p3 = p4 = p2;
        boolean w = false;
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
                                w = SafeParcelReader.w(parcel, c);
                            }
                        }
                        else {
                            p4 = SafeParcelReader.p(parcel, c);
                        }
                    }
                    else {
                        p3 = SafeParcelReader.p(parcel, c);
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
        return new EmailAuthCredential(p, p2, p3, p4, w);
    }
    
    public final Object[] newArray(final int n) {
        return new EmailAuthCredential[n];
    }
}
