// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import android.os.IBinder;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.common.zzc;
import android.os.Parcel;
import com.google.android.gms.internal.common.zzb;

public abstract class zzab extends zzb implements IGmsCallbacks
{
    public zzab() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }
    
    protected final boolean zza(int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    return false;
                }
                n = parcel.readInt();
                final IBinder strongBinder = parcel.readStrongBinder();
                final zzj zzj = (zzj)zzc.zza(parcel, (Parcelable$Creator)com.google.android.gms.common.internal.zzj.CREATOR);
                zzc.zzb(parcel);
                this.W0(n, strongBinder, zzj);
            }
            else {
                n = parcel.readInt();
                final Bundle bundle = (Bundle)zzc.zza(parcel, Bundle.CREATOR);
                zzc.zzb(parcel);
                this.a(n, bundle);
            }
        }
        else {
            n = parcel.readInt();
            final IBinder strongBinder2 = parcel.readStrongBinder();
            final Bundle bundle2 = (Bundle)zzc.zza(parcel, Bundle.CREATOR);
            zzc.zzb(parcel);
            this.G(n, strongBinder2, bundle2);
        }
        parcel2.writeNoException();
        return true;
    }
}
