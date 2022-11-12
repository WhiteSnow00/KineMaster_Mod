// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import java.util.List;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzdg extends zzaqw implements zzdh
{
    public zzdg() {
        super("com.google.android.gms.ads.internal.client.IResponseInfo");
    }
    
    public static zzdh zzb(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
        if (queryLocalInterface instanceof zzdh) {
            return (zzdh)queryLocalInterface;
        }
        return new zzdf(binder);
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n != 5) {
                            return false;
                        }
                        final Bundle zze = this.zze();
                        parcel2.writeNoException();
                        zzaqx.zzf(parcel2, (Parcelable)zze);
                    }
                    else {
                        final zzu zzf = this.zzf();
                        parcel2.writeNoException();
                        zzaqx.zzf(parcel2, (Parcelable)zzf);
                    }
                }
                else {
                    final List zzi = this.zzi();
                    parcel2.writeNoException();
                    parcel2.writeTypedList(zzi);
                }
            }
            else {
                final String zzh = this.zzh();
                parcel2.writeNoException();
                parcel2.writeString(zzh);
            }
        }
        else {
            final String zzg = this.zzg();
            parcel2.writeNoException();
            parcel2.writeString(zzg);
        }
        return true;
    }
}
