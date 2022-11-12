// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Parcelable;
import com.google.android.gms.internal.common.zzc;
import android.os.Parcel;
import android.os.IBinder;
import com.google.android.gms.internal.common.zzb;
import android.os.RemoteException;
import android.accounts.Account;
import android.os.IInterface;

public interface IAccountAccessor extends IInterface
{
    Account zzb() throws RemoteException;
    
    public abstract static class Stub extends zzb implements IAccountAccessor
    {
        public Stub() {
            super("com.google.android.gms.common.internal.IAccountAccessor");
        }
        
        public static IAccountAccessor M0(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof IAccountAccessor) {
                return (IAccountAccessor)queryLocalInterface;
            }
            return new zzv(binder);
        }
        
        protected final boolean zza(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
            if (n == 2) {
                final Account zzb = this.zzb();
                parcel2.writeNoException();
                zzc.zze(parcel2, (Parcelable)zzb);
                return true;
            }
            return false;
        }
    }
}
