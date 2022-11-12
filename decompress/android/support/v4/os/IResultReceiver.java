// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.os;

import android.os.Parcel;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.Bundle;
import android.os.IInterface;

public interface IResultReceiver extends IInterface
{
    void send(final int p0, final Bundle p1) throws RemoteException;
    
    public static class Default implements IResultReceiver
    {
        public IBinder asBinder() {
            return null;
        }
        
        @Override
        public void send(final int n, final Bundle bundle) throws RemoteException {
        }
    }
    
    public abstract static class Stub extends Binder implements IResultReceiver
    {
        public Stub() {
            this.attachInterface((IInterface)this, "android.support.v4.os.IResultReceiver");
        }
        
        public static IResultReceiver asInterface(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface != null && queryLocalInterface instanceof IResultReceiver) {
                return (IResultReceiver)queryLocalInterface;
            }
            return new Proxy(binder);
        }
        
        public static IResultReceiver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
        
        public static boolean setDefaultImpl(final IResultReceiver sDefaultImpl) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (sDefaultImpl != null) {
                Proxy.sDefaultImpl = sDefaultImpl;
                return true;
            }
            return false;
        }
        
        public IBinder asBinder() {
            return (IBinder)this;
        }
        
        public boolean onTransact(int int1, final Parcel parcel, final Parcel parcel2, final int n) throws RemoteException {
            if (int1 == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                int1 = parcel.readInt();
                Bundle bundle;
                if (parcel.readInt() != 0) {
                    bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                }
                else {
                    bundle = null;
                }
                this.send(int1, bundle);
                return true;
            }
            if (int1 != 1598968902) {
                return super.onTransact(int1, parcel, parcel2, n);
            }
            parcel2.writeString("android.support.v4.os.IResultReceiver");
            return true;
        }
        
        private static class Proxy implements IResultReceiver
        {
            public static IResultReceiver sDefaultImpl;
            private IBinder a;
            
            Proxy(final IBinder a) {
                this.a = a;
            }
            
            public IBinder asBinder() {
                return this.a;
            }
            
            public String getInterfaceDescriptor() {
                return "android.support.v4.os.IResultReceiver";
            }
            
            @Override
            public void send(final int n, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.os.IResultReceiver");
                    obtain.writeInt(n);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(1, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().send(n, bundle);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
        }
    }
}
