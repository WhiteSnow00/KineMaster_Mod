// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public final class zza implements Parcelable$Creator<CloudMessage>
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        final int j = SafeParcelReader.J(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < j) {
            final int c = SafeParcelReader.C(parcel);
            if (SafeParcelReader.v(c) != 1) {
                SafeParcelReader.I(parcel, c);
            }
            else {
                intent = SafeParcelReader.o(parcel, c, (android.os.Parcelable$Creator<Intent>)Intent.CREATOR);
            }
        }
        SafeParcelReader.u(parcel, j);
        return new CloudMessage(intent);
    }
    
    public final /* bridge */ Object[] newArray(final int n) {
        return new CloudMessage[n];
    }
}
