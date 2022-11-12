// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.accounttransfer;

import java.util.Set;
import android.app.PendingIntent;
import java.util.HashSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzw implements Parcelable$Creator<zzv>
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        final HashSet set = new HashSet();
        int e = 0;
        String p = null;
        Object g = null;
        Object o2;
        Object o = o2 = g;
        int e2 = 0;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 6: {
                    o2 = SafeParcelReader.o(parcel, c, DeviceMetaData.CREATOR);
                    set.add(6);
                    continue;
                }
                case 5: {
                    o = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<PendingIntent>)PendingIntent.CREATOR);
                    set.add(5);
                    continue;
                }
                case 4: {
                    g = SafeParcelReader.g(parcel, c);
                    set.add(4);
                    continue;
                }
                case 3: {
                    e = SafeParcelReader.E(parcel, c);
                    set.add(3);
                    continue;
                }
                case 2: {
                    p = SafeParcelReader.p(parcel, c);
                    set.add(2);
                    continue;
                }
                case 1: {
                    e2 = SafeParcelReader.E(parcel, c);
                    set.add(1);
                    continue;
                }
            }
        }
        if (parcel.dataPosition() == j) {
            return new zzv(set, e2, p, e, (byte[])g, (PendingIntent)o, (DeviceMetaData)o2);
        }
        final StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(j);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }
    
    public final /* bridge */ Object[] newArray(final int n) {
        return new zzv[n];
    }
}
