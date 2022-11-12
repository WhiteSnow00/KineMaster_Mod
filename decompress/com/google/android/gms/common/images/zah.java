// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zah implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        int e = 0;
        int e2 = 0;
        Uri uri = null;
        int e3 = 0;
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
                            e2 = SafeParcelReader.E(parcel, c);
                        }
                    }
                    else {
                        e3 = SafeParcelReader.E(parcel, c);
                    }
                }
                else {
                    uri = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<Uri>)Uri.CREATOR);
                }
            }
            else {
                e = SafeParcelReader.E(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new WebImage(e, uri, e3, e2);
    }
    
    public final Object[] newArray(final int n) {
        return new WebImage[n];
    }
}
