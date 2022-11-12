// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzbb extends zzaqw implements zzbc
{
    public zzbb() {
        super("com.google.android.gms.ads.internal.client.IAdClickListener");
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n == 1) {
            this.zzb();
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
