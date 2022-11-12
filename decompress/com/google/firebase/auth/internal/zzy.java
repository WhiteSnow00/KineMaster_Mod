// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.auth.internal;

import java.io.Serializable;
import java.util.List;
import com.google.android.gms.internal.firebase_auth_api.zzwq;
import com.google.firebase.auth.zze;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzy implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        Object o = null;
        Object p;
        Object o2 = p = null;
        Object t;
        String p2 = (String)(t = p);
        Object p3;
        List<String> r = (List<String>)(p3 = t);
        Object o3;
        Serializable x = (Serializable)(o3 = p3);
        Object o5;
        Object o4 = o5 = o3;
        boolean w = false;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            switch (SafeParcelReader.v(c)) {
                default: {
                    SafeParcelReader.I(parcel, c);
                    continue;
                }
                case 12: {
                    o5 = SafeParcelReader.o(parcel, c, zzbb.CREATOR);
                    continue;
                }
                case 11: {
                    o4 = SafeParcelReader.o(parcel, c, zze.CREATOR);
                    continue;
                }
                case 10: {
                    w = SafeParcelReader.w(parcel, c);
                    continue;
                }
                case 9: {
                    o3 = SafeParcelReader.o(parcel, c, zzz.CREATOR);
                    continue;
                }
                case 8: {
                    x = SafeParcelReader.x(parcel, c);
                    continue;
                }
                case 7: {
                    p3 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 6: {
                    r = SafeParcelReader.r(parcel, c);
                    continue;
                }
                case 5: {
                    t = SafeParcelReader.t(parcel, c, zzt.CREATOR);
                    continue;
                }
                case 4: {
                    p2 = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 3: {
                    p = SafeParcelReader.p(parcel, c);
                    continue;
                }
                case 2: {
                    o2 = SafeParcelReader.o(parcel, c, zzt.CREATOR);
                    continue;
                }
                case 1: {
                    o = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<zzwq>)zzwq.CREATOR);
                    continue;
                }
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zzx((com.google.android.gms.internal.firebase-auth-api.zzwq)o, (zzt)o2, (String)p, p2, (List)t, r, (String)p3, (Boolean)x, (zzz)o3, w, (zze)o4, (zzbb)o5);
    }
    
    public final Object[] newArray(final int n) {
        return new zzx[n];
    }
}
