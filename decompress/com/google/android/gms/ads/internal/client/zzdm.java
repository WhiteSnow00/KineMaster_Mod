// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzdm extends zzaqw implements zzdn
{
    public zzdm() {
        super("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n != 5) {
                            return false;
                        }
                        final boolean zzh = zzaqx.zzh(parcel);
                        zzaqx.zzc(parcel);
                        this.c(zzh);
                    }
                    else {
                        this.zze();
                    }
                }
                else {
                    this.zzg();
                }
            }
            else {
                this.zzh();
            }
        }
        else {
            this.zzi();
        }
        parcel2.writeNoException();
        return true;
    }
}
