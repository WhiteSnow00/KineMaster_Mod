// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;

public final class zzeg extends zzct
{
    private final String a;
    private final String b;
    
    public zzeg(final String a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    public final String zze() throws RemoteException {
        return this.a;
    }
    
    public final String zzf() throws RemoteException {
        return this.b;
    }
}
