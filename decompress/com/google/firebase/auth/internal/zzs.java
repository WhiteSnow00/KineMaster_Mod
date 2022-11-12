// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import com.google.firebase.auth.zze;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzs implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        zzx zzx = null;
        zzp zzp = null;
        zze zze = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        SafeParcelReader.I(parcel, c);
                    }
                    else {
                        zze = SafeParcelReader.o(parcel, c, com.google.firebase.auth.zze.CREATOR);
                    }
                }
                else {
                    zzp = SafeParcelReader.o(parcel, c, com.google.firebase.auth.internal.zzp.CREATOR);
                }
            }
            else {
                zzx = SafeParcelReader.o(parcel, c, com.google.firebase.auth.internal.zzx.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zzr(zzx, zzp, zze);
    }
    
    public final Object[] newArray(final int n) {
        return new zzr[n];
    }
}
