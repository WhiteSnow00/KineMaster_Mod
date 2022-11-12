// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzbk extends zzaqw implements zzbl
{
    public zzbk() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }
    
    protected final boolean zzbI(int int1, final Parcel parcel, final Parcel parcel2, final int n) throws RemoteException {
        if (int1 != 1) {
            if (int1 != 2) {
                if (int1 != 3) {
                    if (int1 != 4) {
                        if (int1 != 5) {
                            return false;
                        }
                        final zzl zzl = (zzl)zzaqx.zza(parcel, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zzl.CREATOR);
                        int1 = parcel.readInt();
                        zzaqx.zzc(parcel);
                        this.zzh(zzl, int1);
                        parcel2.writeNoException();
                    }
                    else {
                        final String zzf = this.zzf();
                        parcel2.writeNoException();
                        parcel2.writeString(zzf);
                    }
                }
                else {
                    final boolean zzi = this.zzi();
                    parcel2.writeNoException();
                    zzaqx.zzd(parcel2, zzi);
                }
            }
            else {
                final String zze = this.zze();
                parcel2.writeNoException();
                parcel2.writeString(zze);
            }
        }
        else {
            final zzl zzl2 = (zzl)zzaqx.zza(parcel, (Parcelable$Creator)zzl.CREATOR);
            zzaqx.zzc(parcel);
            this.zzg(zzl2);
            parcel2.writeNoException();
        }
        return true;
    }
}
