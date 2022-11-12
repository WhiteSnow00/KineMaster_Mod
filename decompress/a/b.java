// 
// Decompiled by Procyon v0.6.0
// 

package a;

import android.os.Parcel;
import android.os.IBinder;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.IInterface;

public interface b extends IInterface
{
    boolean F0(final a.a p0) throws RemoteException;
    
    boolean J0(final long p0) throws RemoteException;
    
    boolean O0(final a.a p0, final Bundle p1) throws RemoteException;
    
    public abstract static class a extends Binder implements b
    {
        public static b M0(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
            if (queryLocalInterface != null && queryLocalInterface instanceof b) {
                return (b)queryLocalInterface;
            }
            return new b.a.a(binder);
        }
        
        public static b p1() {
            return b.a.a.b;
        }
        
        private static class a implements b
        {
            public static b b;
            private IBinder a;
            
            a(final IBinder a) {
                this.a = a;
            }
            
            @Override
            public boolean F0(final a.a a) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    IBinder binder;
                    if (a != null) {
                        binder = ((IInterface)a).asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    final IBinder a2 = this.a;
                    boolean b = false;
                    if (!a2.transact(3, obtain, obtain2, 0) && a.b.a.p1() != null) {
                        return a.b.a.p1().F0(a);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        b = true;
                    }
                    return b;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public boolean J0(final long n) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    obtain.writeLong(n);
                    final IBinder a = this.a;
                    boolean b = false;
                    if (!a.transact(2, obtain, obtain2, 0) && a.b.a.p1() != null) {
                        return a.b.a.p1().J0(n);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        b = true;
                    }
                    return b;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            @Override
            public boolean O0(final a.a a, final Bundle bundle) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    IBinder binder;
                    if (a != null) {
                        binder = ((IInterface)a).asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    boolean b = true;
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    }
                    else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(10, obtain, obtain2, 0) && a.b.a.p1() != null) {
                        return a.b.a.p1().O0(a, bundle);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        b = false;
                    }
                    return b;
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            public IBinder asBinder() {
                return this.a;
            }
        }
    }
}
