// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzda extends zzaqw implements zzdb
{
    public zzda() {
        super("com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
    }
    
    public static zzdb M0(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
        if (queryLocalInterface instanceof zzdb) {
            return (zzdb)queryLocalInterface;
        }
        return new zzcz(binder);
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n == 1) {
            this.zze();
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
