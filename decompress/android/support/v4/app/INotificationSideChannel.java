// 
// Decompiled by Procyon v0.6.0
// 

package android.support.v4.app;

import android.os.Parcel;
import android.os.Binder;
import android.os.IBinder;
import android.app.Notification;
import android.os.RemoteException;
import android.os.IInterface;

public interface INotificationSideChannel extends IInterface
{
    void cancel(final String p0, final int p1, final String p2) throws RemoteException;
    
    void cancelAll(final String p0) throws RemoteException;
    
    void notify(final String p0, final int p1, final String p2, final Notification p3) throws RemoteException;
    
    public static class Default implements INotificationSideChannel
    {
        public IBinder asBinder() {
            return null;
        }
        
        @Override
        public void cancel(final String s, final int n, final String s2) throws RemoteException {
        }
        
        @Override
        public void cancelAll(final String s) throws RemoteException {
        }
        
        @Override
        public void notify(final String s, final int n, final String s2, final Notification notification) throws RemoteException {
        }
    }
    
    public abstract static class Stub extends Binder implements INotificationSideChannel
    {
        public Stub() {
            this.attachInterface((IInterface)this, "android.support.v4.app.INotificationSideChannel");
        }
        
        public static INotificationSideChannel asInterface(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            if (queryLocalInterface != null && queryLocalInterface instanceof INotificationSideChannel) {
                return (INotificationSideChannel)queryLocalInterface;
            }
            return new Proxy(binder);
        }
        
        public static INotificationSideChannel getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
        
        public static boolean setDefaultImpl(final INotificationSideChannel sDefaultImpl) {
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
                parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                final String string = parcel.readString();
                int1 = parcel.readInt();
                final String string2 = parcel.readString();
                Notification notification;
                if (parcel.readInt() != 0) {
                    notification = (Notification)Notification.CREATOR.createFromParcel(parcel);
                }
                else {
                    notification = null;
                }
                this.notify(string, int1, string2, notification);
                return true;
            }
            if (int1 == 2) {
                parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                this.cancel(parcel.readString(), parcel.readInt(), parcel.readString());
                return true;
            }
            if (int1 == 3) {
                parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                this.cancelAll(parcel.readString());
                return true;
            }
            if (int1 != 1598968902) {
                return super.onTransact(int1, parcel, parcel2, n);
            }
            parcel2.writeString("android.support.v4.app.INotificationSideChannel");
            return true;
        }
        
        private static class Proxy implements INotificationSideChannel
        {
            public static INotificationSideChannel sDefaultImpl;
            private IBinder a;
            
            Proxy(final IBinder a) {
                this.a = a;
            }
            
            public IBinder asBinder() {
                return this.a;
            }
            
            @Override
            public void cancel(final String s, final int n, final String s2) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(s);
                    obtain.writeInt(n);
                    obtain.writeString(s2);
                    if (!this.a.transact(2, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancel(s, n, s2);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
            
            @Override
            public void cancelAll(final String s) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(s);
                    if (!this.a.transact(3, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancelAll(s);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
            
            public String getInterfaceDescriptor() {
                return "android.support.v4.app.INotificationSideChannel";
            }
            
            @Override
            public void notify(final String s, final int n, final String s2, final Notification notification) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(s);
                    obtain.writeInt(n);
                    obtain.writeString(s2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(1, obtain, (Parcel)null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().notify(s, n, s2, notification);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
        }
    }
}
