// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.RemoteException;
import android.os.IInterface;

public interface zze extends IInterface
{
    void c(final boolean p0) throws RemoteException;
    
    void g1(final zzb p0, final String p1) throws RemoteException;
    
    void h1(final zzb p0, final Account p1) throws RemoteException;
}
