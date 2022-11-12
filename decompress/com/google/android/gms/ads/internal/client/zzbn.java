// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbly;
import com.google.android.gms.internal.ads.zzbmb;
import com.google.android.gms.internal.ads.zzbme;
import com.google.android.gms.internal.ads.zzbmh;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzbml;
import com.google.android.gms.internal.ads.zzbmo;
import com.google.android.gms.internal.ads.zzbra;
import android.os.IInterface;
import com.google.android.gms.internal.ads.zzblx;
import com.google.android.gms.internal.ads.zzbma;
import com.google.android.gms.internal.ads.zzbmd;
import com.google.android.gms.internal.ads.zzbmg;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzbmk;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzbmn;
import com.google.android.gms.internal.ads.zzbqr;
import com.google.android.gms.internal.ads.zzbqz;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.ads.zzaqx;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzbn extends zzaqw implements zzbo
{
    public zzbn() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        zzbf zzbf = null;
        final zzcd zzcd = null;
        switch (n) {
            default: {
                return false;
            }
            case 15: {
                final AdManagerAdViewOptions adManagerAdViewOptions = (AdManagerAdViewOptions)zzaqx.zza(parcel, (Parcelable$Creator)AdManagerAdViewOptions.CREATOR);
                zzaqx.zzc(parcel);
                this.zzm(adManagerAdViewOptions);
                parcel2.writeNoException();
                break;
            }
            case 14: {
                final zzbra zzb = zzbqz.zzb(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                this.zzi(zzb);
                parcel2.writeNoException();
                break;
            }
            case 13: {
                final zzbqr zzbqr = (zzbqr)zzaqx.zza(parcel, com.google.android.gms.internal.ads.zzbqr.CREATOR);
                zzaqx.zzc(parcel);
                this.zzn(zzbqr);
                parcel2.writeNoException();
                break;
            }
            case 10: {
                final zzbmo zzb2 = zzbmn.zzb(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                this.zzk(zzb2);
                parcel2.writeNoException();
                break;
            }
            case 9: {
                final PublisherAdViewOptions publisherAdViewOptions = (PublisherAdViewOptions)zzaqx.zza(parcel, (Parcelable$Creator)PublisherAdViewOptions.CREATOR);
                zzaqx.zzc(parcel);
                this.zzp(publisherAdViewOptions);
                parcel2.writeNoException();
                break;
            }
            case 8: {
                final zzbml zzb3 = zzbmk.zzb(parcel.readStrongBinder());
                final zzq zzq = (zzq)zzaqx.zza(parcel, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zzq.CREATOR);
                zzaqx.zzc(parcel);
                this.zzj(zzb3, zzq);
                parcel2.writeNoException();
                break;
            }
            case 7: {
                final IBinder strongBinder = parcel.readStrongBinder();
                zzcd zzcd2;
                if (strongBinder == null) {
                    zzcd2 = zzcd;
                }
                else {
                    final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (queryLocalInterface instanceof zzcd) {
                        zzcd2 = (zzcd)queryLocalInterface;
                    }
                    else {
                        zzcd2 = new zzcd(strongBinder);
                    }
                }
                zzaqx.zzc(parcel);
                this.zzq(zzcd2);
                parcel2.writeNoException();
                break;
            }
            case 6: {
                final zzbko zzbko = (zzbko)zzaqx.zza(parcel, com.google.android.gms.internal.ads.zzbko.CREATOR);
                zzaqx.zzc(parcel);
                this.zzo(zzbko);
                parcel2.writeNoException();
                break;
            }
            case 5: {
                final String string = parcel.readString();
                final zzbmh zzb4 = zzbmg.zzb(parcel.readStrongBinder());
                final zzbme zzb5 = zzbmd.zzb(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                this.zzh(string, zzb4, zzb5);
                parcel2.writeNoException();
                break;
            }
            case 4: {
                final zzbmb zzb6 = zzbma.zzb(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                this.zzg(zzb6);
                parcel2.writeNoException();
                break;
            }
            case 3: {
                final zzbly zzb7 = zzblx.zzb(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                this.zzf(zzb7);
                parcel2.writeNoException();
                break;
            }
            case 2: {
                final IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    final IInterface queryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (queryLocalInterface2 instanceof zzbf) {
                        zzbf = (zzbf)queryLocalInterface2;
                    }
                    else {
                        zzbf = new zzbd(strongBinder2);
                    }
                }
                zzaqx.zzc(parcel);
                this.zzl(zzbf);
                parcel2.writeNoException();
                break;
            }
            case 1: {
                final zzbl zze = this.zze();
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)zze);
                break;
            }
        }
        return true;
    }
}
