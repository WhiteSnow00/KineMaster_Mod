// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import java.util.List;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zac implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        List<Feature> t = null;
        String p = null;
        boolean w = false;
        String p2 = null;
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
                            p = SafeParcelReader.p(parcel, c);
                        }
                    }
                    else {
                        p2 = SafeParcelReader.p(parcel, c);
                    }
                }
                else {
                    w = SafeParcelReader.w(parcel, c);
                }
            }
            else {
                t = SafeParcelReader.t(parcel, c, Feature.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new ApiFeatureRequest(t, w, p2, p);
    }
    
    public final Object[] newArray(final int n) {
        return new ApiFeatureRequest[n];
    }
}
