// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.ads.zzaqx;
import android.os.Parcel;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzaqw;

public abstract class zzdd extends zzaqw implements zzde
{
    public zzdd() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }
    
    public static zzde M0(final IBinder binder) {
        if (binder == null) {
            return null;
        }
        final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        if (queryLocalInterface instanceof zzde) {
            return (zzde)queryLocalInterface;
        }
        return new zzdc(binder);
    }
    
    protected final boolean zzbI(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n == 1) {
            final zzs zzs = (zzs)zzaqx.zza(parcel, (Parcelable$Creator)com.google.android.gms.ads.internal.client.zzs.CREATOR);
            zzaqx.zzc(parcel);
            this.Y0(zzs);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
