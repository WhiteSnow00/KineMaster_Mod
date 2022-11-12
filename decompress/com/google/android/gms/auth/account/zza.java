// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.account;

import android.os.RemoteException;
import android.accounts.Account;
import com.google.android.gms.internal.auth.zzc;
import android.os.Parcel;
import com.google.android.gms.internal.auth.zzb;

public abstract class zza extends com.google.android.gms.internal.auth.zzb implements zzb
{
    public zza() {
        super("com.google.android.gms.auth.account.IWorkAccountCallback");
    }
    
    protected final boolean zza(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            this.B(zzc.zze(parcel));
        }
        else {
            this.e0((Account)zzc.zza(parcel, Account.CREATOR));
        }
        return true;
    }
}
