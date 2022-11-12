// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import android.os.IBinder;
import android.os.Binder;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.os.RemoteException;
import android.os.IInterface;

public interface IGmsServiceBroker extends IInterface
{
    @KeepForSdk
    void y0(final IGmsCallbacks p0, final GetServiceRequest p1) throws RemoteException;
    
    public abstract static class Stub extends Binder implements IGmsServiceBroker
    {
        public Stub() {
            this.attachInterface((IInterface)this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }
        
        @KeepForSdk
        @CanIgnoreReturnValue
        public IBinder asBinder() {
            return (IBinder)this;
        }
        
        public final boolean onTransact(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
            if (n > 16777215) {
                return super.onTransact(n, parcel, parcel2, n2);
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            final IBinder strongBinder = parcel.readStrongBinder();
            GetServiceRequest getServiceRequest = null;
            IGmsCallbacks gmsCallbacks;
            if (strongBinder == null) {
                gmsCallbacks = null;
            }
            else {
                final IInterface queryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                if (queryLocalInterface instanceof IGmsCallbacks) {
                    gmsCallbacks = (IGmsCallbacks)queryLocalInterface;
                }
                else {
                    gmsCallbacks = new zzaa(strongBinder);
                }
            }
            if (n == 46) {
                if (parcel.readInt() != 0) {
                    getServiceRequest = (GetServiceRequest)GetServiceRequest.CREATOR.createFromParcel(parcel);
                }
                this.y0(gmsCallbacks, getServiceRequest);
                Preconditions.k(parcel2);
                parcel2.writeNoException();
                return true;
            }
            if (n == 47) {
                if (parcel.readInt() != 0) {
                    final zzaj zzaj = (zzaj)com.google.android.gms.common.internal.zzaj.CREATOR.createFromParcel(parcel);
                }
                throw new UnsupportedOperationException();
            }
            parcel.readInt();
            if (n != 4) {
                parcel.readString();
                if (n != 1) {
                    Label_0457: {
                        if (n != 2 && n != 23 && n != 25 && n != 27) {
                            if (n != 30) {
                                if (n == 34) {
                                    parcel.readString();
                                    throw new UnsupportedOperationException();
                                }
                                if (n == 41 || n == 43 || n == 37 || n == 38) {
                                    break Label_0457;
                                }
                                switch (n) {
                                    default: {
                                        throw new UnsupportedOperationException();
                                    }
                                    case 19: {
                                        parcel.readStrongBinder();
                                        if (parcel.readInt() != 0) {
                                            final Bundle bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                                            throw new UnsupportedOperationException();
                                        }
                                        throw new UnsupportedOperationException();
                                    }
                                    case 10: {
                                        parcel.readString();
                                        parcel.createStringArray();
                                        throw new UnsupportedOperationException();
                                    }
                                    case 9: {
                                        parcel.readString();
                                        parcel.createStringArray();
                                        parcel.readString();
                                        parcel.readStrongBinder();
                                        parcel.readString();
                                        if (parcel.readInt() != 0) {
                                            final Bundle bundle2 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                                            throw new UnsupportedOperationException();
                                        }
                                        throw new UnsupportedOperationException();
                                    }
                                    case 20: {
                                        break;
                                    }
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                    case 18: {
                                        break Label_0457;
                                    }
                                }
                            }
                            parcel.createStringArray();
                            parcel.readString();
                            if (parcel.readInt() != 0) {
                                final Bundle bundle3 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                                throw new UnsupportedOperationException();
                            }
                            throw new UnsupportedOperationException();
                        }
                    }
                    if (parcel.readInt() != 0) {
                        final Bundle bundle4 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                }
                else {
                    parcel.readString();
                    parcel.createStringArray();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                        final Bundle bundle5 = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                }
            }
            throw new UnsupportedOperationException();
        }
    }
}
