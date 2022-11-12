// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.stats;

import java.io.Serializable;
import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zza implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        long f = 0L;
        long f3;
        long f2 = f3 = 0L;
        int e = 0;
        int e3;
        int e2 = e3 = 0;
        int w;
        int e4 = w = e3;
        String p = null;
        Serializable r = null;
        Serializable p3;
        String p2 = (String)(p3 = r);
        String p5;
        String p4 = p5 = (String)p3;
        float a = 0.0f;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 18: {
                    w = (SafeParcelReader.w(parcel, c) ? 1 : 0);
                    continue;
                }
                case 17: {
                    p5 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 16: {
                    f3 = SafeParcelReader.F(parcel, c);
                    continue;
                }
                case 15: {
                    a = SafeParcelReader.A(parcel, c);
                    continue;
                }
                case 14: {
                    e4 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 13: {
                    p4 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 12: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 11: {
                    e2 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 10: {
                    p3 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 8: {
                    f2 = SafeParcelReader.F(parcel, c);
                    continue;
                }
                case 6: {
                    r = SafeParcelReader.r(parcel, c);
                    continue;
                }
                case 5: {
                    e3 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 4: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 2: {
                    f = SafeParcelReader.F(parcel, c);
                    continue;
                }
                case 1: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new WakeLockEvent(e, f, e2, p, e3, (List)r, p2, f2, e4, (String)p3, p4, a, f3, p5, (boolean)(w != 0));
    }
    
    public final Object[] newArray(final int n) {
        return new WakeLockEvent[n];
    }
}
