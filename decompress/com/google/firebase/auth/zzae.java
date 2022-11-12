// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzae implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        boolean w = false;
        boolean w2 = false;
        String p = null;
        String p3;
        String p2 = p3 = null;
        String p5;
        String p4 = p5 = p3;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 7: {
                    p5 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 6: {
                    p4 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 5: {
                    w2 = SafeParcelReader.w(parcel, c);
                    continue;
                }
                case 4: {
                    p3 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 3: {
                    w = SafeParcelReader.w(parcel, c);
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
        return new PhoneAuthCredential(p, p2, w, p3, w2, p4, p5);
    }
    
    public final Object[] newArray(final int n) {
        return new PhoneAuthCredential[n];
    }
}
