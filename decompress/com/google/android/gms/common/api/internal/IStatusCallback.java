// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.Parcelable$Creator;
import com.google.android.gms.internal.base.zac;
import android.os.Parcel;
import com.google.android.gms.internal.base.zab;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import android.os.IInterface;

public interface IStatusCallback extends IInterface
{
    void C0(final Status p0) throws RemoteException;
    
    public abstract static class Stub extends zab implements IStatusCallback
    {
        public Stub() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }
        
        protected final boolean zaa(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
            if (n == 1) {
                final Status status = (Status)zac.zaa(parcel, (Parcelable$Creator)Status.CREATOR);
                zac.zab(parcel);
                this.C0(status);
                return true;
            }
            return false;
        }
    }
}
