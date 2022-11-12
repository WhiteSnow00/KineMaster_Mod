// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbyd;
import com.google.android.gms.internal.ads.zzbyg;
import com.google.android.gms.internal.ads.zzbit;
import com.google.android.gms.internal.ads.zzcaq;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbyc;
import com.google.android.gms.internal.ads.zzbyf;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzcap;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzbch;
import android.os.Parcelable$Creator;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzbr extends zzaqw implements zzbs
{
    public zzbr() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }
    
    public static zzbs zzac(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        if (queryLocalInterface instanceof zzbs) {
            return (zzbs)queryLocalInterface;
        }
        return new zzbq(binder);
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        zzbi zzbi = null;
        final zzde zzde = null;
        final zzbw zzbw = null;
        final zzcd zzcd = null;
        final zzbc zzbc = null;
        final zzbz zzbz = null;
        final zzbf zzbf = null;
        final zzcg zzcg = null;
        switch (n) {
            default: {
                return false;
            }
            case 45: {
                final IBinder strongBinder = parcel.readStrongBinder();
                zzcg zzcg2;
                if (strongBinder == null) {
                    zzcg2 = zzcg;
                }
                else {
                    final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
                    if (queryLocalInterface instanceof zzcg) {
                        zzcg2 = (zzcg)queryLocalInterface;
                    }
                    else {
                        zzcg2 = new zzce(strongBinder);
                    }
                }
                zzaqx.zzc(parcel);
                this.zzJ(zzcg2);
                parcel2.writeNoException();
                break;
            }
            case 44: {
                final IObjectWrapper m0 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                this.zzW(m0);
                parcel2.writeNoException();
                break;
            }
            case 43: {
                final zzl zzl = (zzl)zzaqx.zza(parcel, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zzl.CREATOR);
                final IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    final IInterface queryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoadCallback");
                    if (queryLocalInterface2 instanceof zzbi) {
                        zzbi = (zzbi)queryLocalInterface2;
                    }
                    else {
                        zzbi = new zzbg(strongBinder2);
                    }
                }
                zzaqx.zzc(parcel);
                this.zzy(zzl, zzbi);
                parcel2.writeNoException();
                break;
            }
            case 42: {
                final IBinder strongBinder3 = parcel.readStrongBinder();
                zzde zzde2;
                if (strongBinder3 == null) {
                    zzde2 = zzde;
                }
                else {
                    final IInterface queryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
                    if (queryLocalInterface3 instanceof zzde) {
                        zzde2 = (zzde)queryLocalInterface3;
                    }
                    else {
                        zzde2 = new zzdc(strongBinder3);
                    }
                }
                zzaqx.zzc(parcel);
                this.zzP(zzde2);
                parcel2.writeNoException();
                break;
            }
            case 41: {
                final zzdh zzk = this.zzk();
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)zzk);
                break;
            }
            case 40: {
                final zzbci zze = zzbch.zze(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                this.zzH(zze);
                parcel2.writeNoException();
                break;
            }
            case 39: {
                final zzw zzw = (zzw)zzaqx.zza(parcel, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zzw.CREATOR);
                zzaqx.zzc(parcel);
                this.zzI(zzw);
                parcel2.writeNoException();
                break;
            }
            case 38: {
                final String string = parcel.readString();
                zzaqx.zzc(parcel);
                this.zzR(string);
                parcel2.writeNoException();
                break;
            }
            case 37: {
                final Bundle zzd = this.zzd();
                parcel2.writeNoException();
                zzaqx.zzf(parcel2, (Parcelable)zzd);
                break;
            }
            case 36: {
                final IBinder strongBinder4 = parcel.readStrongBinder();
                zzbw zzbw2;
                if (strongBinder4 == null) {
                    zzbw2 = zzbw;
                }
                else {
                    final IInterface queryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    if (queryLocalInterface4 instanceof zzbw) {
                        zzbw2 = (zzbw)queryLocalInterface4;
                    }
                    else {
                        zzbw2 = new zzbu(strongBinder4);
                    }
                }
                zzaqx.zzc(parcel);
                this.zzE(zzbw2);
                parcel2.writeNoException();
                break;
            }
            case 35: {
                final String zzt = this.zzt();
                parcel2.writeNoException();
                parcel2.writeString(zzt);
                break;
            }
            case 34: {
                final boolean zzh = zzaqx.zzh(parcel);
                zzaqx.zzc(parcel);
                this.zzL(zzh);
                parcel2.writeNoException();
                break;
            }
            case 33: {
                final zzbf zzi = this.zzi();
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)zzi);
                break;
            }
            case 32: {
                final zzbz zzj = this.zzj();
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)zzj);
                break;
            }
            case 31: {
                final String zzr = this.zzr();
                parcel2.writeNoException();
                parcel2.writeString(zzr);
                break;
            }
            case 30: {
                final zzdo zzdo = (zzdo)zzaqx.zza(parcel, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zzdo.CREATOR);
                zzaqx.zzc(parcel);
                this.zzK(zzdo);
                parcel2.writeNoException();
                break;
            }
            case 29: {
                final zzfg zzfg = (zzfg)zzaqx.zza(parcel, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zzfg.CREATOR);
                zzaqx.zzc(parcel);
                this.zzU(zzfg);
                parcel2.writeNoException();
                break;
            }
            case 26: {
                final zzdk zzl2 = this.zzl();
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)zzl2);
                break;
            }
            case 25: {
                final String string2 = parcel.readString();
                zzaqx.zzc(parcel);
                this.zzT(string2);
                parcel2.writeNoException();
                break;
            }
            case 24: {
                final zzcaq zzb = zzcap.zzb(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                this.zzS(zzb);
                parcel2.writeNoException();
                break;
            }
            case 23: {
                final boolean zzY = this.zzY();
                parcel2.writeNoException();
                zzaqx.zzd(parcel2, zzY);
                break;
            }
            case 22: {
                final boolean zzh2 = zzaqx.zzh(parcel);
                zzaqx.zzc(parcel);
                this.zzN(zzh2);
                parcel2.writeNoException();
                break;
            }
            case 21: {
                final IBinder strongBinder5 = parcel.readStrongBinder();
                zzcd zzcd2;
                if (strongBinder5 == null) {
                    zzcd2 = zzcd;
                }
                else {
                    final IInterface queryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    if (queryLocalInterface5 instanceof zzcd) {
                        zzcd2 = (zzcd)queryLocalInterface5;
                    }
                    else {
                        zzcd2 = new zzcd(strongBinder5);
                    }
                }
                zzaqx.zzc(parcel);
                this.zzab(zzcd2);
                parcel2.writeNoException();
                break;
            }
            case 20: {
                final IBinder strongBinder6 = parcel.readStrongBinder();
                zzbc zzbc2;
                if (strongBinder6 == null) {
                    zzbc2 = zzbc;
                }
                else {
                    final IInterface queryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    if (queryLocalInterface6 instanceof zzbc) {
                        zzbc2 = (zzbc)queryLocalInterface6;
                    }
                    else {
                        zzbc2 = new zzba(strongBinder6);
                    }
                }
                zzaqx.zzc(parcel);
                this.zzC(zzbc2);
                parcel2.writeNoException();
                break;
            }
            case 19: {
                final zzbit zzb2 = zzbis.zzb(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                this.zzO(zzb2);
                parcel2.writeNoException();
                break;
            }
            case 18: {
                final String zzs = this.zzs();
                parcel2.writeNoException();
                parcel2.writeString(zzs);
                break;
            }
            case 15: {
                final zzbyg zzb3 = zzbyf.zzb(parcel.readStrongBinder());
                final String string3 = parcel.readString();
                zzaqx.zzc(parcel);
                this.zzQ(zzb3, string3);
                parcel2.writeNoException();
                break;
            }
            case 14: {
                final zzbyd zzb4 = zzbyc.zzb(parcel.readStrongBinder());
                zzaqx.zzc(parcel);
                this.zzM(zzb4);
                parcel2.writeNoException();
                break;
            }
            case 13: {
                final zzq zzq = (zzq)zzaqx.zza(parcel, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zzq.CREATOR);
                zzaqx.zzc(parcel);
                this.zzF(zzq);
                parcel2.writeNoException();
                break;
            }
            case 12: {
                final zzq zzg = this.zzg();
                parcel2.writeNoException();
                zzaqx.zzf(parcel2, (Parcelable)zzg);
                break;
            }
            case 11: {
                this.zzA();
                parcel2.writeNoException();
                break;
            }
            case 10: {
                parcel2.writeNoException();
                break;
            }
            case 9: {
                this.zzX();
                parcel2.writeNoException();
                break;
            }
            case 8: {
                final IBinder strongBinder7 = parcel.readStrongBinder();
                zzbz zzbz2;
                if (strongBinder7 == null) {
                    zzbz2 = zzbz;
                }
                else {
                    final IInterface queryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    if (queryLocalInterface7 instanceof zzbz) {
                        zzbz2 = (zzbz)queryLocalInterface7;
                    }
                    else {
                        zzbz2 = new zzbx(strongBinder7);
                    }
                }
                zzaqx.zzc(parcel);
                this.zzG(zzbz2);
                parcel2.writeNoException();
                break;
            }
            case 7: {
                final IBinder strongBinder8 = parcel.readStrongBinder();
                zzbf zzbf2;
                if (strongBinder8 == null) {
                    zzbf2 = zzbf;
                }
                else {
                    final IInterface queryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    if (queryLocalInterface8 instanceof zzbf) {
                        zzbf2 = (zzbf)queryLocalInterface8;
                    }
                    else {
                        zzbf2 = new zzbd(strongBinder8);
                    }
                }
                zzaqx.zzc(parcel);
                this.zzD(zzbf2);
                parcel2.writeNoException();
                break;
            }
            case 6: {
                this.zzB();
                parcel2.writeNoException();
                break;
            }
            case 5: {
                this.zzz();
                parcel2.writeNoException();
                break;
            }
            case 4: {
                final zzl zzl3 = (zzl)zzaqx.zza(parcel, (Parcelable$Creator)zzl.CREATOR);
                zzaqx.zzc(parcel);
                final boolean zzaa = this.zzaa(zzl3);
                parcel2.writeNoException();
                zzaqx.zzd(parcel2, zzaa);
                break;
            }
            case 3: {
                final boolean zzZ = this.zzZ();
                parcel2.writeNoException();
                zzaqx.zzd(parcel2, zzZ);
                break;
            }
            case 2: {
                this.zzx();
                parcel2.writeNoException();
                break;
            }
            case 1: {
                final IObjectWrapper zzn = this.zzn();
                parcel2.writeNoException();
                zzaqx.zzg(parcel2, (IInterface)zzn);
                break;
            }
        }
        return true;
    }
}
