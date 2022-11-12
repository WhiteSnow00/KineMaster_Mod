// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import com.google.android.gms.internal.ads.zzcfo;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzn implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        boolean w = false;
        int e2;
        int e = e2 = 0;
        zzc zzc = null;
        Object d = null;
        Object d3;
        IBinder d2 = (IBinder)(d3 = d);
        Object p;
        IBinder d4 = (IBinder)(p = d3);
        Object d5;
        String p2 = (String)(d5 = p);
        Object o;
        Object p3 = o = d5;
        Object o2;
        Object p4 = o2 = o;
        Object p5;
        Object d6 = p5 = o2;
        Object d8;
        Object d7 = d8 = p5;
        Object d10;
        IBinder d9 = (IBinder)(d10 = d8);
        Object p7;
        Object p6 = p7 = d10;
        Object d12;
        Object d11 = d12 = p7;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 27: {
                    d12 = SafeParcelReader.D(parcel, c);
                    continue;
                }
                case 26: {
                    d11 = SafeParcelReader.D(parcel, c);
                    continue;
                }
                case 25: {
                    p7 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 24: {
                    p6 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 23: {
                    d10 = SafeParcelReader.D(parcel, c);
                    continue;
                }
                case 22: {
                    d9 = SafeParcelReader.D(parcel, c);
                    continue;
                }
                case 21: {
                    d8 = SafeParcelReader.D(parcel, c);
                    continue;
                }
                case 20: {
                    d7 = SafeParcelReader.D(parcel, c);
                    continue;
                }
                case 19: {
                    p5 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 18: {
                    d6 = SafeParcelReader.D(parcel, c);
                    continue;
                }
                case 17: {
                    o2 = SafeParcelReader.o(parcel, c, zzj.CREATOR);
                    continue;
                }
                case 16: {
                    p4 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 14: {
                    o = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<zzcfo>)zzcfo.CREATOR);
                    continue;
                }
                case 13: {
                    p3 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 12: {
                    e2 = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 11: {
                    e = SafeParcelReader.E(parcel, c);
                    continue;
                }
                case 10: {
                    d5 = SafeParcelReader.D(parcel, c);
                    continue;
                }
                case 9: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 8: {
                    w = SafeParcelReader.w(parcel, c);
                    continue;
                }
                case 7: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 6: {
                    d4 = SafeParcelReader.D(parcel, c);
                    continue;
                }
                case 5: {
                    d3 = SafeParcelReader.D(parcel, c);
                    continue;
                }
                case 4: {
                    d2 = SafeParcelReader.D(parcel, c);
                    continue;
                }
                case 3: {
                    d = SafeParcelReader.D(parcel, c);
                    continue;
                }
                case 2: {
                    zzc = SafeParcelReader.o(parcel, c, com.google.android.gms.ads.internal.overlay.zzc.CREATOR);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new AdOverlayInfoParcel(zzc, (IBinder)d, d2, (IBinder)d3, d4, (String)p, w, p2, (IBinder)d5, e, e2, (String)p3, (zzcfo)o, (String)p4, (zzj)o2, (IBinder)d6, (String)p5, (IBinder)d7, (IBinder)d8, d9, (IBinder)d10, (String)p6, (String)p7, (IBinder)d11, (IBinder)d12);
    }
    
    public final Object[] newArray(final int n) {
        return new AdOverlayInfoParcel[n];
    }
}
