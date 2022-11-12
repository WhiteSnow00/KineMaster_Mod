// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzbh extends zzaqw implements zzbi
{
    public zzbh() {
        super("com.google.android.gms.ads.internal.client.IAdLoadCallback");
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            final zze zze = (zze)zzaqx.zza(parcel, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzaqx.zzc(parcel);
            this.zzb(zze);
        }
        else {
            this.zzc();
        }
        parcel2.writeNoException();
        return true;
    }
}
