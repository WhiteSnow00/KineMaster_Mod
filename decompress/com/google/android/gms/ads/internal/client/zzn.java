// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import java.io.Serializable;
import android.os.Bundle;
import java.util.List;
import android.location.Location;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzn implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        int e = 0;
        int e2 = 0;
        int e3;
        int w = e3 = e2;
        int w3;
        int w2 = w3 = e3;
        int e5;
        int e4 = e5 = w3;
        Bundle f = null;
        Object p;
        Object r = p = null;
        Object o2;
        Object o = o2 = p;
        Object f2;
        Object p2 = f2 = o2;
        Object r2;
        Bundle f3 = (Bundle)(r2 = f2);
        Object p4;
        Object p3 = p4 = r2;
        Object p5;
        Object o3 = p5 = p4;
        Object p6;
        Serializable r3 = (Serializable)(p6 = p5);
        long f4 = 0L;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 24: {
                    p6 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 23: {
                    e5 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 22: {
                    r3 = SafeParcelReader.r(parcel, c);
                    continue;
                }
                case 21: {
                    p5 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 20: {
                    e4 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 19: {
                    o3 = SafeParcelReader.o(parcel, c, zzc.CREATOR);
                    continue;
                }
                case 18: {
                    w3 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 17: {
                    p4 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 16: {
                    p3 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 15: {
                    r2 = SafeParcelReader.r(parcel, c);
                    continue;
                }
                case 14: {
                    f3 = SafeParcelReader.f(parcel, c);
                    continue;
                }
                case 13: {
                    f2 = SafeParcelReader.f(parcel, c);
                    continue;
                }
                case 12: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 11: {
                    o2 = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<Location>)Location.CREATOR);
                    continue;
                }
                case 10: {
                    o = SafeParcelReader.o(parcel, c, zzfc.CREATOR);
                    continue;
                }
                case 9: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 8: {
                    w2 = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 7: {
                    e3 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 6: {
                    w = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 5: {
                    r = SafeParcelReader.r(parcel, c);
                    continue;
                }
                case 4: {
                    e2 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 3: {
                    f = SafeParcelReader.f(parcel, c);
                    continue;
                }
                case 2: {
                    f4 = SafeParcelReader.F(parcel, c);
                    continue;
                }
                case 1: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zzl(e, f4, f, e2, (List)r, (boolean)(w != 0), e3, (boolean)(w2 != 0), (String)p, (zzfc)o, (Location)o2, (String)p2, (Bundle)f2, f3, (List)r2, (String)p3, (String)p4, (boolean)(w3 != 0), (zzc)o3, e4, (String)p5, (List)r3, e5, (String)p6);
    }
    
    public final Object[] newArray(final int n) {
        return new zzl[n];
    }
}
