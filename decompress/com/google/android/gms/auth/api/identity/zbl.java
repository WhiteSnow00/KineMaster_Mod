// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zbl implements Parcelable$Creator
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            if (SafeParcelReader.v(c) != 1) {
                SafeParcelReader.I(parcel, c);
            }
            else {
                pendingIntent = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<PendingIntent>)PendingIntent.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new SavePasswordResult(pendingIntent);
    }
    
    public final Object[] newArray(final int n) {
        return new SavePasswordResult[n];
    }
}
