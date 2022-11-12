// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.data;

import android.os.Bundle;
import android.database.CursorWindow;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zaf implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        int e = 0;
        int e2 = 0;
        String[] q = null;
        Bundle f;
        Object o = f = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    if (v != 3) {
                        if (v != 4) {
                            if (v != 1000) {
                                SafeParcelReader.I(parcel, c);
                            }
                            else {
                                e = SafeParcelReader.E(parcel, c);
                            }
                        }
                        else {
                            f = SafeParcelReader.f(parcel, c);
                        }
                    }
                    else {
                        e2 = SafeParcelReader.E(parcel, c);
                    }
                }
                else {
                    o = SafeParcelReader.s(parcel, c, (android.os.Parcelable$Creator<CursorWindow>)CursorWindow.CREATOR);
                }
            }
            else {
                q = SafeParcelReader.q(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        final DataHolder dataHolder = new DataHolder(e, q, (CursorWindow[])o, e2, f);
        dataHolder.P1();
        return dataHolder;
    }
    
    public final Object[] newArray(final int n) {
        return new DataHolder[n];
    }
}
