// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.accounttransfer;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzo implements Parcelable$Creator<zzn>
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        final HashSet set = new HashSet();
        int e = 0;
        ArrayList<zzt> t = null;
        zzr zzr = null;
        int e2 = 0;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        if (v != 4) {
                            SafeParcelReader.I(parcel, c);
                        }
                        else {
                            zzr = SafeParcelReader.o(parcel, c, com.google.android.gms.auth.api.accounttransfer.zzr.CREATOR);
                            set.add(4);
                        }
                    }
                    else {
                        e2 = SafeParcelReader.E(parcel, c);
                        set.add(3);
                    }
                }
                else {
                    t = SafeParcelReader.t(parcel, c, zzt.CREATOR);
                    set.add(2);
                }
            }
            else {
                e = SafeParcelReader.E(parcel, c);
                set.add(1);
            }
        }
        if (parcel.dataPosition() == j) {
            return new zzn(set, e, t, e2, zzr);
        }
        final StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(j);
        throw new SafeParcelReader.ParseException(sb.toString(), parcel);
    }
    
    public final /* bridge */ Object[] newArray(final int n) {
        return new zzn[n];
    }
}
