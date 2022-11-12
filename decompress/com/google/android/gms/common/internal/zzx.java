// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.RemoteException;
import android.os.Parcel;
import android.os.IBinder;
import com.google.android.gms.internal.common.zza;

public final class zzx extends zza implements zzz
{
    zzx(final IBinder binder) {
        super(binder, "com.google.android.gms.common.internal.ICertData");
    }
    
    public final int zzc() throws RemoteException {
        final Parcel zzB = this.zzB(2, this.zza());
        final int int1 = zzB.readInt();
        zzB.recycle();
        return int1;
    }
    
    public final IObjectWrapper zzd() throws RemoteException {
        final Parcel zzB = this.zzB(1, this.zza());
        final IObjectWrapper m0 = IObjectWrapper.Stub.M0(zzB.readStrongBinder());
        zzB.recycle();
        return m0;
    }
}
