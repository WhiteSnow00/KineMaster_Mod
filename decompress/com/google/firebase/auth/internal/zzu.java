// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzu implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        String p3;
        String p2 = p3 = null;
        String p5;
        String p4 = p5 = p3;
        String p7;
        String p6 = p7 = p5;
        boolean w = false;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 8: {
                    p7 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 7: {
                    w = SafeParcelReader.w(parcel, c);
                    continue;
                }
                case 6: {
                    p6 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 5: {
                    p3 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 4: {
                    p4 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 3: {
                    p5 = SafeParcelReader.p(parcel, c);
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
        return new zzt(p, p2, p3, p4, p5, p6, w, p7);
    }
    
    public final Object[] newArray(final int n) {
        return new zzt[n];
    }
}
