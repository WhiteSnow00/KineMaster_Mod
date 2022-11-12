// 
// Decompiled by Procyon v0.6.0
// 

package androidx.room;

import android.os.Parcel;
import android.os.IBinder;
import android.os.Binder;
import android.os.RemoteException;
import android.os.IInterface;

public interface s extends IInterface
{
    void m(final String[] p0) throws RemoteException;
    
    public abstract static class a extends Binder implements s
    {
        public a() {
            this.attachInterface((IInterface)this, "androidx.room.IMultiInstanceInvalidationCallback");
        }
        
        public static s M0(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            if (queryLocalInterface != null && queryLocalInterface instanceof s) {
                return (s)queryLocalInterface;
            }
            return new s.a.a(binder);
        }
        
        public static s p1() {
            return s.a.a.b;
        }
        
        public IBinder asBinder() {
            return (IBinder)this;
        }
        
        public boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
            if (n == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
                this.m(parcel.createStringArray());
                return true;
            }
            if (n != 1598968902) {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            parcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
            return true;
        }
        
        private static class a implements s
        {
            public static s b;
            private IBinder a;
            
            a(final IBinder a) {
                this.a = a;
            }
            
            public IBinder asBinder() {
                return this.a;
            }
            
            @Override
            public void m(final String[] array) throws RemoteException {
                final Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    obtain.writeStringArray(array);
                    if (!this.a.transact(1, obtain, (Parcel)null, 1) && s.a.p1() != null) {
                        s.a.p1().m(array);
                    }
                }
                finally {
                    obtain.recycle();
                }
            }
        }
    }
}
