// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.account;

import android.os.Parcelable;
import android.accounts.Account;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.Parcel;
import android.os.IBinder;
import com.google.android.gms.internal.auth.zza;

public final class zzc extends zza implements zze
{
    zzc(final IBinder binder) {
        super(binder, "com.google.android.gms.auth.account.IWorkAccountService");
    }
    
    public final void c(final boolean b) throws RemoteException {
        final Parcel zza = this.zza();
        com.google.android.gms.internal.auth.zzc.zzb(zza, b);
        this.zzc(1, zza);
    }
    
    public final void g1(final zzb zzb, final String s) throws RemoteException {
        final Parcel zza = this.zza();
        com.google.android.gms.internal.auth.zzc.zzd(zza, (IInterface)zzb);
        zza.writeString(s);
        this.zzc(2, zza);
    }
    
    public final void h1(final zzb zzb, final Account account) throws RemoteException {
        final Parcel zza = this.zza();
        com.google.android.gms.internal.auth.zzc.zzd(zza, (IInterface)zzb);
        com.google.android.gms.internal.auth.zzc.zzc(zza, (Parcelable)account);
        this.zzc(3, zza);
    }
}
