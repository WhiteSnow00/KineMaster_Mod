// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzct extends zzaqw implements zzcu
{
    public zzct() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }
    
    public static zzcu M0(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        if (queryLocalInterface instanceof zzcu) {
            return (zzcu)queryLocalInterface;
        }
        return new zzcs(binder);
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            final String zzf = this.zzf();
            parcel2.writeNoException();
            parcel2.writeString(zzf);
        }
        else {
            final String zze = this.zze();
            parcel2.writeNoException();
            parcel2.writeString(zze);
        }
        return true;
    }
}
