// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall;

import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zae implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        Long g = null;
        Long g2 = null;
        int e = 0;
        int e3;
        int e2 = e3 = 0;
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
                                e3 = SafeParcelReader.E(parcel, c);
                            }
                        }
                        else {
                            g2 = SafeParcelReader.G(parcel, c);
                        }
                    }
                    else {
                        g = SafeParcelReader.G(parcel, c);
                    }
                }
                else {
                    e2 = SafeParcelReader.E(parcel, c);
                }
            }
            else {
                e = SafeParcelReader.E(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new ModuleInstallStatusUpdate(e, e2, g, g2, e3);
    }
    
    public final Object[] newArray(final int n) {
        return new ModuleInstallStatusUpdate[n];
    }
}
