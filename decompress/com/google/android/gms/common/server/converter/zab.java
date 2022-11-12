// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.server.converter;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zab implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        int e = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    SafeParcelReader.I(parcel, c);
                }
                else {
                    stringToIntConverter = SafeParcelReader.o(parcel, c, StringToIntConverter.CREATOR);
                }
            }
            else {
                e = SafeParcelReader.E(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new zaa(e, stringToIntConverter);
    }
    
    public final Object[] newArray(final int n) {
        return new zaa[n];
    }
}
