// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth;

import android.os.IBinder;
import android.os.Bundle;
import android.accounts.Account;

public final class zzg implements a
{
    public final Account a;
    public final String b;
    public final Bundle c;
    
    public zzg(final Account a, final String b, final Bundle c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public final Object a(final IBinder binder) {
        return zzl.f(this.a, this.b, this.c, binder);
    }
}
