// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.formats;

import android.os.IBinder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzf implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        IBinder d = null;
        boolean w = false;
        IBinder d2 = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        SafeParcelReader.I(parcel, c);
                    }
                    else {
                        d2 = SafeParcelReader.D(parcel, c);
                    }
                }
                else {
                    d = SafeParcelReader.D(parcel, c);
                }
            }
            else {
                w = SafeParcelReader.w(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new PublisherAdViewOptions(w, d, d2);
    }
    
    public final Object[] newArray(final int n) {
        return new PublisherAdViewOptions[n];
    }
}
