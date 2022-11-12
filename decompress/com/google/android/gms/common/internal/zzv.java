// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import android.os.Parcel;
import com.google.android.gms.internal.common.zzc;
import android.accounts.Account;
import android.os.IBinder;
import com.google.android.gms.internal.common.zza;

public final class zzv extends zza implements IAccountAccessor
{
    zzv(final IBinder binder) {
        super(binder, "com.google.android.gms.common.internal.IAccountAccessor");
    }
    
    public final Account zzb() throws RemoteException {
        final Parcel zzB = this.zzB(2, this.zza());
        final Account account = (Account)zzc.zza(zzB, Account.CREATOR);
        zzB.recycle();
        return account;
    }
}
