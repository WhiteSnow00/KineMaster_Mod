// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzbe extends zzaqw implements zzbf
{
    public zzbe() {
        super("com.google.android.gms.ads.internal.client.IAdListener");
    }
    
    protected final boolean zzbI(int int1, final Parcel parcel, final Parcel parcel2, final int n) throws RemoteException {
        while (true) {
            switch (int1) {
                default: {
                    return false;
                }
                case 3: {
                    parcel2.writeNoException();
                    return true;
                }
                case 8: {
                    final zze zze = (zze)zzaqx.zza(parcel, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zze.CREATOR);
                    zzaqx.zzc(parcel);
                    this.zzf(zze);
                    continue;
                }
                case 7: {
                    this.zzg();
                    continue;
                }
                case 6: {
                    this.zzc();
                    continue;
                }
                case 5: {
                    this.zzj();
                    continue;
                }
                case 4: {
                    this.zzi();
                    continue;
                }
                case 2: {
                    int1 = parcel.readInt();
                    zzaqx.zzc(parcel);
                    this.zze(int1);
                    continue;
                }
                case 1: {
                    this.zzd();
                    continue;
                }
            }
            break;
        }
    }
}
