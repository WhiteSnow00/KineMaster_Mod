// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzcx extends zzaqw implements zzcy
{
    public zzcx() {
        super("com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n == 1) {
            final zze zze = (zze)zzaqx.zza(parcel, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzaqx.zzc(parcel);
            this.y(zze);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
