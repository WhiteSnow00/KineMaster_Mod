// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import android.os.IBinder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzt implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        boolean w = false;
        String p = null;
        IBinder d = null;
        boolean w2 = false;
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
                            w2 = SafeParcelReader.w(parcel, c);
                        }
                    }
                    else {
                        w = SafeParcelReader.w(parcel, c);
                    }
                }
                else {
                    d = SafeParcelReader.D(parcel, c);
                }
            }
            else {
                p = SafeParcelReader.p(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zzs(p, d, w, w2);
    }
    
    public final Object[] newArray(final int n) {
        return new zzs[n];
    }
}
