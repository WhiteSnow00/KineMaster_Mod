// 
// Decompiled by Procyon v0.6.0
// 

package a;

import android.os.Parcel;
import android.os.IBinder;
import android.os.Binder;
import android.net.Uri;
import android.os.RemoteException;
import android.os.Bundle;
import android.os.IInterface;

public interface a extends IInterface
{
    void Q(final String p0, final Bundle p1) throws RemoteException;
    
    void a1(final int p0, final Bundle p1) throws RemoteException;
    
    void j1(final String p0, final Bundle p1) throws RemoteException;
    
    void l1(final Bundle p0) throws RemoteException;
    
    void m1(final int p0, final Uri p1, final boolean p2, final Bundle p3) throws RemoteException;
    
    Bundle u(final String p0, final Bundle p1) throws RemoteException;
    
    public abstract static class a extends Binder implements a.a
    {
        public a() {
            this.attachInterface((IInterface)this, "android.support.customtabs.ICustomTabsCallback");
        }
        
        public IBinder asBinder() {
            return (IBinder)this;
        }
        
        public boolean onTransact(int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
            if (n == 1598968902) {
                parcel2.writeString("android.support.customtabs.ICustomTabsCallback");
                return true;
            }
            boolean b = false;
            Bundle bundle = null;
            Bundle bundle2 = null;
            final Bundle bundle3 = null;
            final Bundle bundle4 = null;
            final Bundle bundle5 = null;
            final Bundle bundle6 = null;
            switch (n) {
                default: {
                    return super.onTransact(n, parcel, parcel2, n2);
                }
                case 7: {
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                    final String string = parcel.readString();
                    Bundle bundle7 = bundle6;
                    if (parcel.readInt() != 0) {
                        bundle7 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    final Bundle u = this.u(string, bundle7);
                    parcel2.writeNoException();
                    if (u != null) {
                        parcel2.writeInt(1);
                        u.writeToParcel(parcel2, 1);
                    }
                    else {
                        parcel2.writeInt(0);
                    }
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                    n = parcel.readInt();
                    Uri uri;
                    if (parcel.readInt() != 0) {
                        uri = (Uri)Uri.CREATOR.createFromParcel(parcel);
                    }
                    else {
                        uri = null;
                    }
                    if (parcel.readInt() != 0) {
                        b = true;
                    }
                    if (parcel.readInt() != 0) {
                        bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.m1(n, uri, b, bundle);
                    parcel2.writeNoException();
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                    final String string2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.j1(string2, bundle2);
                    parcel2.writeNoException();
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                    Bundle bundle8 = bundle3;
                    if (parcel.readInt() != 0) {
                        bundle8 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.l1(bundle8);
                    parcel2.writeNoException();
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                    final String string3 = parcel.readString();
                    Bundle bundle9 = bundle4;
                    if (parcel.readInt() != 0) {
                        bundle9 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.Q(string3, bundle9);
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                    n = parcel.readInt();
                    Bundle bundle10 = bundle5;
                    if (parcel.readInt() != 0) {
                        bundle10 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.a1(n, bundle10);
                    parcel2.writeNoException();
                    return true;
                }
            }
        }
    }
}
