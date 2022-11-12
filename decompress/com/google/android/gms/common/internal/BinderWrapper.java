// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.IBinder;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.os.Parcelable;

@KeepForSdk
@KeepName
public final class BinderWrapper implements Parcelable
{
    public static final Parcelable$Creator<BinderWrapper> CREATOR;
    private IBinder a;
    
    static {
        CREATOR = (Parcelable$Creator)new l();
    }
    
    BinderWrapper(final Parcel parcel, final zzi zzi) {
        this.a = parcel.readStrongBinder();
    }
    
    public final int describeContents() {
        return 0;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeStrongBinder(this.a);
    }
}
