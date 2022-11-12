// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.content.Intent;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzb implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        String p = null;
        Object p3;
        Object p2 = p3 = null;
        Object p5;
        String p4 = (String)(p5 = p3);
        Object p7;
        String p6 = (String)(p7 = p5);
        Object d;
        Object o = d = p7;
        boolean w = false;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 11: {
                    w = SafeParcelReader.w(parcel, c);
                    continue;
                }
                case 10: {
                    d = SafeParcelReader.D(parcel, c);
                    continue;
                }
                case 9: {
                    o = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<Intent>)Intent.CREATOR);
                    continue;
                }
                case 8: {
                    p7 = SafeParcelReader.p(parcel, c);
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
                    p3 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 3: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 2: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zzc(p, (String)p2, (String)p3, p4, (String)p5, p6, (String)p7, (Intent)o, (IBinder)d, w);
    }
    
    public final Object[] newArray(final int n) {
        return new zzc[n];
    }
}
