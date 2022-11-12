// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Parcel;
import com.google.android.gms.internal.common.zzb;
import android.os.RemoteException;
import android.os.IInterface;

public interface ICancelToken extends IInterface
{
    void cancel() throws RemoteException;
    
    public abstract static class Stub extends zzb implements ICancelToken
    {
        public Stub() {
            super("com.google.android.gms.common.internal.ICancelToken");
        }
        
        protected final boolean zza(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
            if (n == 2) {
                this.cancel();
                return true;
            }
            return false;
        }
    }
}
