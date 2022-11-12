// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.RemoteException;
import android.os.Parcel;
import android.os.IBinder;

final class j implements IGmsServiceBroker
{
    private final IBinder a;
    
    j(final IBinder a) {
        this.a = a;
    }
    
    public final IBinder asBinder() {
        return this.a;
    }
    
    @Override
    public final void y0(final IGmsCallbacks gmsCallbacks, final GetServiceRequest getServiceRequest) throws RemoteException {
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder binder;
            if (gmsCallbacks != null) {
                binder = ((IInterface)gmsCallbacks).asBinder();
            }
            else {
                binder = null;
            }
            obtain.writeStrongBinder(binder);
            if (getServiceRequest != null) {
                obtain.writeInt(1);
                zzm.a(getServiceRequest, obtain, 0);
            }
            else {
                obtain.writeInt(0);
            }
            this.a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        }
        finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
