// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzcf extends zzaqw implements zzcg
{
    public zzcf() {
        super("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n != 5) {
                            return false;
                        }
                        this.zzb();
                    }
                    else {
                        this.zze();
                    }
                }
                else {
                    this.zzc();
                }
            }
            else {
                this.zzf();
            }
        }
        else {
            final zze zze = (zze)zzaqx.zza(parcel, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzaqx.zzc(parcel);
            this.zzd(zze);
        }
        parcel2.writeNoException();
        return true;
    }
}
