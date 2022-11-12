// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;

final class l implements Parcelable$Creator
{
    public final Object createFromParcel(final Parcel parcel) {
        return new BinderWrapper(parcel, null);
    }
    
    public final Object[] newArray(final int n) {
        return new BinderWrapper[n];
    }
}
