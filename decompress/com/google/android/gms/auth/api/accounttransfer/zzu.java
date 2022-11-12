// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.accounttransfer;

import java.util.Set;
import java.util.HashSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzu implements Parcelable$Creator<zzt>
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        final HashSet set = new HashSet();
        int e = 0;
        zzv zzv = null;
        String p = null;
        String p3;
        String p2 = p3 = p;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        if (v != 4) {
                            if (v != 5) {
                                SafeParcelReader.I(parcel, c);
                            }
                            else {
                                p3 = SafeParcelReader.p(parcel, c);
                                set.add(5);
                            }
                        }
                        else {
                            p2 = SafeParcelReader.p(parcel, c);
                            set.add(4);
                        }
                    }
                    else {
                        p = SafeParcelReader.p(parcel, c);
                        set.add(3);
                    }
                }
                else {
                    zzv = SafeParcelReader.o(parcel, c, com.google.android.gms.auth.api.accounttransfer.zzv.CREATOR);
                    set.add(2);
                }
            }
            else {
                e = SafeParcelReader.E(parcel, c);
                set.add(1);
            }
        }
        if (parcel.dataPosition() == j) {
            return new zzt(set, e, zzv, p, p2, p3);
        }
        final StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(j);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }
    
    public final /* bridge */ Object[] newArray(final int n) {
        return new zzt[n];
    }
}
