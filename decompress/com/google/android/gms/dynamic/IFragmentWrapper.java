// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamic;

import android.os.Parcelable;
import com.google.android.gms.internal.common.zzc;
import android.os.Parcel;
import com.google.android.gms.internal.common.zzb;
import android.os.Bundle;
import android.os.RemoteException;
import android.content.Intent;
import android.os.IInterface;

public interface IFragmentWrapper extends IInterface
{
    void D0(final Intent p0) throws RemoteException;
    
    void G0(final Intent p0, final int p1) throws RemoteException;
    
    void m0(final boolean p0) throws RemoteException;
    
    void s0(final boolean p0) throws RemoteException;
    
    boolean zzA() throws RemoteException;
    
    int zzb() throws RemoteException;
    
    int zzc() throws RemoteException;
    
    Bundle zzd() throws RemoteException;
    
    IFragmentWrapper zze() throws RemoteException;
    
    IFragmentWrapper zzf() throws RemoteException;
    
    IObjectWrapper zzg() throws RemoteException;
    
    IObjectWrapper zzh() throws RemoteException;
    
    IObjectWrapper zzi() throws RemoteException;
    
    String zzj() throws RemoteException;
    
    void zzk(final IObjectWrapper p0) throws RemoteException;
    
    void zzn(final boolean p0) throws RemoteException;
    
    void zzo(final boolean p0) throws RemoteException;
    
    void zzr(final IObjectWrapper p0) throws RemoteException;
    
    boolean zzs() throws RemoteException;
    
    boolean zzt() throws RemoteException;
    
    boolean zzu() throws RemoteException;
    
    boolean zzv() throws RemoteException;
    
    boolean zzw() throws RemoteException;
    
    boolean zzx() throws RemoteException;
    
    boolean zzy() throws RemoteException;
    
    boolean zzz() throws RemoteException;
    
    public abstract static class Stub extends zzb implements IFragmentWrapper
    {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }
        
        protected final boolean zza(int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
            switch (n) {
                default: {
                    return false;
                }
                case 27: {
                    final IObjectWrapper m0 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                    zzc.zzb(parcel);
                    this.zzr(m0);
                    parcel2.writeNoException();
                    break;
                }
                case 26: {
                    final Intent intent = (Intent)zzc.zza(parcel, Intent.CREATOR);
                    n = parcel.readInt();
                    zzc.zzb(parcel);
                    this.G0(intent, n);
                    parcel2.writeNoException();
                    break;
                }
                case 25: {
                    final Intent intent2 = (Intent)zzc.zza(parcel, Intent.CREATOR);
                    zzc.zzb(parcel);
                    this.D0(intent2);
                    parcel2.writeNoException();
                    break;
                }
                case 24: {
                    final boolean zzg = zzc.zzg(parcel);
                    zzc.zzb(parcel);
                    this.zzo(zzg);
                    parcel2.writeNoException();
                    break;
                }
                case 23: {
                    final boolean zzg2 = zzc.zzg(parcel);
                    zzc.zzb(parcel);
                    this.zzn(zzg2);
                    parcel2.writeNoException();
                    break;
                }
                case 22: {
                    final boolean zzg3 = zzc.zzg(parcel);
                    zzc.zzb(parcel);
                    this.s0(zzg3);
                    parcel2.writeNoException();
                    break;
                }
                case 21: {
                    final boolean zzg4 = zzc.zzg(parcel);
                    zzc.zzb(parcel);
                    this.m0(zzg4);
                    parcel2.writeNoException();
                    break;
                }
                case 20: {
                    final IObjectWrapper m2 = IObjectWrapper.Stub.M0(parcel.readStrongBinder());
                    zzc.zzb(parcel);
                    this.zzk(m2);
                    parcel2.writeNoException();
                    break;
                }
                case 19: {
                    final boolean zzA = this.zzA();
                    parcel2.writeNoException();
                    zzc.zzc(parcel2, zzA);
                    break;
                }
                case 18: {
                    final boolean zzz = this.zzz();
                    parcel2.writeNoException();
                    zzc.zzc(parcel2, zzz);
                    break;
                }
                case 17: {
                    final boolean zzy = this.zzy();
                    parcel2.writeNoException();
                    zzc.zzc(parcel2, zzy);
                    break;
                }
                case 16: {
                    final boolean zzx = this.zzx();
                    parcel2.writeNoException();
                    zzc.zzc(parcel2, zzx);
                    break;
                }
                case 15: {
                    final boolean zzw = this.zzw();
                    parcel2.writeNoException();
                    zzc.zzc(parcel2, zzw);
                    break;
                }
                case 14: {
                    final boolean zzv = this.zzv();
                    parcel2.writeNoException();
                    zzc.zzc(parcel2, zzv);
                    break;
                }
                case 13: {
                    final boolean zzu = this.zzu();
                    parcel2.writeNoException();
                    zzc.zzc(parcel2, zzu);
                    break;
                }
                case 12: {
                    final IObjectWrapper zzi = this.zzi();
                    parcel2.writeNoException();
                    zzc.zzf(parcel2, (IInterface)zzi);
                    break;
                }
                case 11: {
                    final boolean zzt = this.zzt();
                    parcel2.writeNoException();
                    zzc.zzc(parcel2, zzt);
                    break;
                }
                case 10: {
                    n = this.zzc();
                    parcel2.writeNoException();
                    parcel2.writeInt(n);
                    break;
                }
                case 9: {
                    final IFragmentWrapper zzf = this.zzf();
                    parcel2.writeNoException();
                    zzc.zzf(parcel2, (IInterface)zzf);
                    break;
                }
                case 8: {
                    final String zzj = this.zzj();
                    parcel2.writeNoException();
                    parcel2.writeString(zzj);
                    break;
                }
                case 7: {
                    final boolean zzs = this.zzs();
                    parcel2.writeNoException();
                    zzc.zzc(parcel2, zzs);
                    break;
                }
                case 6: {
                    final IObjectWrapper zzh = this.zzh();
                    parcel2.writeNoException();
                    zzc.zzf(parcel2, (IInterface)zzh);
                    break;
                }
                case 5: {
                    final IFragmentWrapper zze = this.zze();
                    parcel2.writeNoException();
                    zzc.zzf(parcel2, (IInterface)zze);
                    break;
                }
                case 4: {
                    n = this.zzb();
                    parcel2.writeNoException();
                    parcel2.writeInt(n);
                    break;
                }
                case 3: {
                    final Bundle zzd = this.zzd();
                    parcel2.writeNoException();
                    zzc.zze(parcel2, (Parcelable)zzd);
                    break;
                }
                case 2: {
                    final IObjectWrapper zzg5 = this.zzg();
                    parcel2.writeNoException();
                    zzc.zzf(parcel2, (IInterface)zzg5);
                    break;
                }
            }
            return true;
        }
    }
}
