// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.account;

import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.auth.zzb;

public abstract class zzd extends zzb implements zze
{
    public static zze M0(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.auth.account.IWorkAccountService");
        if (queryLocalInterface instanceof zze) {
            return (zze)queryLocalInterface;
        }
        return new zzc(binder);
    }
}
