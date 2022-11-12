// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import android.os.Parcel;
import android.os.IBinder;
import android.os.Binder;
import android.os.RemoteException;
import android.os.IInterface;

public interface t extends IInterface
{
    int B0(final s p0, final String p1) throws RemoteException;
    
    void g0(final int p0, final String[] p1) throws RemoteException;
    
    void o1(final s p0, final int p1) throws RemoteException;
    
    public abstract static class a extends Binder implements t
    {
        public a() {
            this.attachInterface((IInterface)this, "androidx.room.IMultiInstanceInvalidationService");
        }
        
        public static t M0(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            if (queryLocalInterface != null && queryLocalInterface instanceof t) {
                return (t)queryLocalInterface;
            }
            return new t.a.a(binder);
        }
        
        public static t p1() {
            return t.a.a.b;
        }
        
        public IBinder asBinder() {
            return (IBinder)this;
        }
        
        public boolean onTransact(int b0, final Parcel parcel, final Parcel parcel2, final int n) throws RemoteException {
            if (b0 == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                b0 = this.B0(s.a.M0(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(b0);
                return true;
            }
            if (b0 == 2) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                this.o1(s.a.M0(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (b0 == 3) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                this.g0(parcel.readInt(), parcel.createStringArray());
                return true;
            }
            if (b0 != 1598968902) {
                return super.onTransact(b0, parcel, parcel2, n);
            }
            parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
            return true;
        }
        
        private static class a implements t
        {
            public static t b;
            private IBinder a;
            
            a(final IBinder a) {
                this.a = a;
            }
            
            @Override
            public int B0(final s s, final String s2) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    IBinder binder;
                    if (s != null) {
                        binder = ((IInterface)s).asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeString(s2);
                    if (!this.a.transact(1, obtain, obtain2, 0) && t.a.p1() != null) {
                        return t.a.p1().B0(s, s2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
            
            public IBinder asBinder() {
                return this.a;
            }
            
            @Override
            public void g0(final int n, final String[] array) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeInt(n);
                    obtain.writeStringArray(array);
                    if (!this.a.transact(3, obtain, (Parcel)null, 1) && t.a.p1() != null) {
                        t.a.p1().g0(n, array);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
            
            @Override
            public void o1(final s s, final int n) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                final Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    IBinder binder;
                    if (s != null) {
                        binder = ((IInterface)s).asBinder();
                    }
                    else {
                        binder = null;
                    }
                    obtain.writeStrongBinder(binder);
                    obtain.writeInt(n);
                    if (!this.a.transact(2, obtain, obtain2, 0) && t.a.p1() != null) {
                        t.a.p1().o1(s, n);
                        return;
                    }
                    obtain2.readException();
                }
                finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
