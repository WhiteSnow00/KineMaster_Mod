// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.IInterface;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.IBinder;
import com.google.android.gms.internal.base.zaa;

public final class zam extends zaa
{
    zam(final IBinder binder) {
        super(binder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }
    
    public final IObjectWrapper M0(final IObjectWrapper objectWrapper, final zax zax) throws RemoteException {
        final Parcel zaa = this.zaa();
        zac.zae(zaa, (IInterface)objectWrapper);
        zac.zad(zaa, (Parcelable)zax);
        final Parcel zab = this.zab(2, zaa);
        final IObjectWrapper m0 = IObjectWrapper.Stub.M0(zab.readStrongBinder());
        zab.recycle();
        return m0;
    }
}
