// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth;

import com.google.android.gms.internal.firebase_auth_api.zzxq;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzf implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        String p3;
        String p2 = p3 = null;
        String p4;
        Object o = p4 = p3;
        String p6;
        String p5 = p6 = p4;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 7: {
                    p6 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 6: {
                    p5 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 5: {
                    p4 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 4: {
                    o = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<zzxq>)zzxq.CREATOR);
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
        return new zze(p, p2, p3, (com.google.android.gms.internal.firebase-auth-api.zzxq)o, p4, p5, p6);
    }
    
    public final Object[] newArray(final int n) {
        return new zze[n];
    }
}
