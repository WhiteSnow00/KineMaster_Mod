// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.os.Parcel;
import android.os.IBinder;
import android.os.Binder;
import android.os.RemoteException;
import android.os.Message;
import android.os.IInterface;

interface IMessengerCompat extends IInterface
{
    void u0(final Message p0) throws RemoteException;
    
    public static class Impl extends Binder implements IMessengerCompat
    {
        public IBinder asBinder() {
            throw null;
        }
        
        public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
            throw null;
        }
        
        public void u0(final Message message) throws RemoteException {
            throw null;
        }
    }
    
    public static class Proxy implements IMessengerCompat
    {
        private final IBinder a;
        
        public IBinder asBinder() {
            return this.a;
        }
        
        @Override
        public void u0(final Message message) throws RemoteException {
            final Parcel obtain = Parcel.obtain();
            obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
            obtain.writeInt(1);
            message.writeToParcel(obtain, 0);
            try {
                this.a.transact(1, obtain, (Parcel)null, 1);
            }
            finally {
                obtain.recycle();
            }
        }
    }
}
