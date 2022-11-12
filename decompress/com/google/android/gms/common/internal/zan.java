// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zan implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        String p2 = null;
        long f = 0L;
        long f2 = 0L;
        int e = 0;
        int e2 = 0;
        int e4;
        int e3 = e4 = e2;
        int e5 = -1;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 9: {
                    e5 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 8: {
                    e4 = SafeParcelReader.E(parcel, c);
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
                    f2 = SafeParcelReader.F(parcel, c);
                    continue;
                }
                case 4: {
                    f = SafeParcelReader.F(parcel, c);
                    continue;
                }
                case 3: {
                    e3 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 2: {
                    e2 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 1: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new MethodInvocation(e, e2, e3, f, f2, p, p2, e4, e5);
    }
    
    public final Object[] newArray(final int n) {
        return new MethodInvocation[n];
    }
}
