// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth;

import java.util.List;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zzc implements Parcelable$Creator<AccountChangeEventsResponse>
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        int e = 0;
        List<AccountChangeEvent> t = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            final int v = SafeParcelReader.v(c);
            if (v != 1) {
                if (v != 2) {
                    SafeParcelReader.I(parcel, c);
                }
                else {
                    t = SafeParcelReader.t(parcel, c, AccountChangeEvent.CREATOR);
                }
            }
            else {
                e = SafeParcelReader.E(parcel, c);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new AccountChangeEventsResponse(e, t);
    }
    
    public final /* bridge */ Object[] newArray(final int n) {
        return new AccountChangeEventsResponse[n];
    }
}
