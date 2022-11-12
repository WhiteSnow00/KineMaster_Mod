// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth;

import android.os.Bundle;
import java.io.IOException;
import com.google.android.gms.internal.auth.zze;
import android.os.IBinder;
import android.accounts.Account;

public final class zzf implements a
{
    public final Account a;
    
    @Override
    public final Object a(final IBinder binder) {
        final Bundle zzf = zze.zzb(binder).zzf(this.a);
        if (zzf != null) {
            return zzf;
        }
        throw new IOException("Service call returned null.");
    }
}
