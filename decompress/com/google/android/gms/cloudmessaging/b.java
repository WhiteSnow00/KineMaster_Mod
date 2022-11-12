// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.os.Parcel;
import android.os.Parcelable$Creator;

final class b implements Parcelable$Creator<zzd>
{
    public final /* bridge */ Object createFromParcel(final Parcel parcel) {
        return new zzd(parcel.readStrongBinder());
    }
    
    public final /* bridge */ Object[] newArray(final int n) {
        return new zzd[n];
    }
}
