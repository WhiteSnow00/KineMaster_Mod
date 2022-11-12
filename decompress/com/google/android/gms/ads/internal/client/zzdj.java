// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzdj extends zzaqw implements zzdk
{
    public zzdj() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }
    
    public static zzdk zzb(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        if (queryLocalInterface instanceof zzdk) {
            return (zzdk)queryLocalInterface;
        }
        return new zzdi(binder);
    }
    
    protected final boolean zzbI(int zzh, final Parcel parcel, final Parcel parcel2, final int n) throws RemoteException {
        switch (zzh) {
            default: {
                return false;
            }
            case 13: {
                this.zzn();
                parcel2.writeNoException();
                break;
            }
            case 12: {
                final boolean zzo = this.zzo();
                parcel2.writeNoException();
                zzaqx.zzd(parcel2, zzo);
                break;
            }
            case 11: {
                final zzdn zzi = this.zzi();
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)zzi);
                break;
            }
            case 10: {
                final boolean zzp = this.zzp();
                parcel2.writeNoException();
                zzaqx.zzd(parcel2, zzp);
                break;
            }
            case 9: {
                final float zze = this.zze();
                parcel2.writeNoException();
                parcel2.writeFloat(zze);
                break;
            }
            case 8: {
                final IBinder strongBinder = parcel.readStrongBinder();
                zzdn zzdn;
                if (strongBinder == null) {
                    zzdn = null;
                }
                else {
                    final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    if (queryLocalInterface instanceof zzdn) {
                        zzdn = (zzdn)queryLocalInterface;
                    }
                    else {
                        zzdn = new zzdl(strongBinder);
                    }
                }
                zzaqx.zzc(parcel);
                this.zzm(zzdn);
                parcel2.writeNoException();
                break;
            }
            case 7: {
                final float zzf = this.zzf();
                parcel2.writeNoException();
                parcel2.writeFloat(zzf);
                break;
            }
            case 6: {
                final float zzg = this.zzg();
                parcel2.writeNoException();
                parcel2.writeFloat(zzg);
                break;
            }
            case 5: {
                zzh = this.zzh();
                parcel2.writeNoException();
                parcel2.writeInt(zzh);
                break;
            }
            case 4: {
                final boolean zzq = this.zzq();
                parcel2.writeNoException();
                zzaqx.zzd(parcel2, zzq);
                break;
            }
            case 3: {
                final boolean zzh2 = zzaqx.zzh(parcel);
                zzaqx.zzc(parcel);
                this.zzj(zzh2);
                parcel2.writeNoException();
                break;
            }
            case 2: {
                this.zzk();
                parcel2.writeNoException();
                break;
            }
            case 1: {
                this.zzl();
                parcel2.writeNoException();
                break;
            }
        }
        return true;
    }
}
