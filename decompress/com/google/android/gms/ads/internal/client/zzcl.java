// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbqm;
import java.util.List;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbql;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzcl extends zzaqw implements zzcm
{
    public zzcl() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        switch (n) {
            default: {
                return false;
            }
            case 16: {
                final IBinder strongBinder = parcel.readStrongBinder();
                zzcy zzcy;
                if (strongBinder == null) {
                    zzcy = null;
                }
                else {
                    final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
                    if (queryLocalInterface instanceof zzcy) {
                        zzcy = (zzcy)queryLocalInterface;
                    }
                    else {
                        zzcy = new zzcw(strongBinder);
                    }
                }
                zzaqx.zzc(parcel);
                this.zzl(zzcy);
                parcel2.writeNoException();
                break;
            }
            case 15: {
                this.zzi();
                parcel2.writeNoException();
                break;
            }
            case 14: {
                final zzfa zzfa = (zzfa)zzaqx.zza(parcel, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zzfa.CREATOR);
                zzaqx.zzc(parcel);
                this.zzs(zzfa);
                parcel2.writeNoException();
                break;
            }
            case 13: {
                final List zzg = this.zzg();
                parcel2.writeNoException();
                parcel2.writeTypedList(zzg);
                break;
            }
            case 12: {
                final zzbqm zzc = zzbql.zzc(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                this.zzr(zzc);
                parcel2.writeNoException();
                break;
            }
            case 11: {
                final zzbtz zzf = zzbty.zzf(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                this.zzn(zzf);
                parcel2.writeNoException();
                break;
            }
            case 10: {
                final String string = parcel.readString();
                zzaqx.zzc(parcel);
                this.zzh(string);
                parcel2.writeNoException();
                break;
            }
            case 9: {
                final String zzf2 = this.zzf();
                parcel2.writeNoException();
                parcel2.writeString(zzf2);
                break;
            }
            case 8: {
                final boolean zzt = this.zzt();
                parcel2.writeNoException();
                zzaqx.zzd(parcel2, zzt);
                break;
            }
            case 7: {
                final float zze = this.zze();
                parcel2.writeNoException();
                parcel2.writeFloat(zze);
                break;
            }
            case 6: {
                final String string2 = parcel.readString();
                final IObjectWrapper m0 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                this.zzk(string2, m0);
                parcel2.writeNoException();
                break;
            }
            case 5: {
                final IObjectWrapper m2 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                final String string3 = parcel.readString();
                zzaqx.zzc(parcel);
                this.zzm(m2, string3);
                parcel2.writeNoException();
                break;
            }
            case 4: {
                final boolean zzh = zzaqx.zzh(parcel);
                zzaqx.zzc(parcel);
                this.zzo(zzh);
                parcel2.writeNoException();
                break;
            }
            case 3: {
                final String string4 = parcel.readString();
                zzaqx.zzc(parcel);
                this.zzq(string4);
                parcel2.writeNoException();
                break;
            }
            case 2: {
                final float float1 = parcel.readFloat();
                zzaqx.zzc(parcel);
                this.zzp(float1);
                parcel2.writeNoException();
                break;
            }
            case 1: {
                this.zzj();
                parcel2.writeNoException();
                break;
            }
        }
        return true;
    }
}
