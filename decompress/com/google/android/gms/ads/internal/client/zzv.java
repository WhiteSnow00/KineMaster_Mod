// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzv implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        Object f;
        Object o = f = null;
        Object p3;
        Object p2 = p3 = f;
        Object p5;
        String p4 = (String)(p5 = p3);
        long f2 = 0L;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 8: {
                    p5 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 7: {
                    p4 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 6: {
                    p3 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 5: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 4: {
                    f = SafeParcelReader.f(parcel, c);
                    continue;
                }
                case 3: {
                    o = SafeParcelReader.o(parcel, c, zze.CREATOR);
                    continue;
                }
                case 2: {
                    f2 = SafeParcelReader.F(parcel, c);
                    continue;
                }
                case 1: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zzu(p, f2, (zze)o, (Bundle)f, (String)p2, (String)p3, p4, (String)p5);
    }
    
    public final Object[] newArray(final int n) {
        return new zzu[n];
    }
}
