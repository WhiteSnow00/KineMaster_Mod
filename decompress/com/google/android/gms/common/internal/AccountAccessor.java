// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import android.os.RemoteException;
import android.util.Log;
import android.os.Binder;
import android.accounts.Account;

public class AccountAccessor extends Stub
{
    @KeepForSdk
    public static Account p1(final IAccountAccessor accountAccessor) {
        Account account = null;
        final Account account2 = null;
        if (accountAccessor != null) {
            final long clearCallingIdentity = Binder.clearCallingIdentity();
            while (true) {
                try {
                    try {
                        final Account zzb = accountAccessor.zzb();
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        account = zzb;
                    }
                    finally {}
                }
                catch (final RemoteException ex) {
                    Log.w("AccountAccessor", "Remote account accessor probably died");
                    final Account zzb = account2;
                    continue;
                }
                break;
            }
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
        return account;
    }
    
    public final boolean equals(final Object o) {
        throw null;
    }
    
    public final Account zzb() {
        throw null;
    }
}
