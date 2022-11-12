// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.Message;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class zzd implements Parcelable
{
    public static final Parcelable$Creator<zzd> CREATOR;
    Messenger a;
    IMessengerCompat b;
    
    static {
        CREATOR = (Parcelable$Creator)new b();
    }
    
    public zzd(final IBinder binder) {
        this.a = new Messenger(binder);
    }
    
    public final IBinder a() {
        final Messenger a = this.a;
        IBinder binder;
        if (a != null) {
            binder = a.getBinder();
        }
        else {
            binder = ((IInterface)this.b).asBinder();
        }
        return binder;
    }
    
    public final void b(final Message message) throws RemoteException {
        final Messenger a = this.a;
        if (a != null) {
            a.send(message);
            return;
        }
        this.b.u0(message);
    }
    
    public final int describeContents() {
        return 0;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        try {
            return this.a().equals(((zzd)o).a());
        }
        catch (final ClassCastException ex) {
            return false;
        }
    }
    
    @Override
    public final int hashCode() {
        return this.a().hashCode();
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final Messenger a = this.a;
        if (a != null) {
            parcel.writeStrongBinder(a.getBinder());
            return;
        }
        parcel.writeStrongBinder(((IInterface)this.b).asBinder());
    }
}
