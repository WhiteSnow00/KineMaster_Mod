// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import java.util.List;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.zze;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzaf implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        List<PhoneMultiFactorInfo> t = null;
        Object p;
        Object o = p = null;
        Object o3;
        Object o2 = o3 = p;
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
                                o3 = SafeParcelReader.o(parcel, c, zzx.CREATOR);
                            }
                        }
                        else {
                            o2 = SafeParcelReader.o(parcel, c, zze.CREATOR);
                        }
                    }
                    else {
                        p = SafeParcelReader.p(parcel, c);
                    }
                }
                else {
                    o = SafeParcelReader.o(parcel, c, zzag.CREATOR);
                }
            }
            else {
                t = SafeParcelReader.t(parcel, c, PhoneMultiFactorInfo.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zzae(t, (zzag)o, (String)p, (zze)o2, (zzx)o3);
    }
    
    public final Object[] newArray(final int n) {
        return new zzae[n];
    }
}
