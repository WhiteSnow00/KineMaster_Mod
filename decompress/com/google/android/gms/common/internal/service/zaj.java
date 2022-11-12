// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.internal.base.zac;
import android.os.Parcel;
import com.google.android.gms.internal.base.zab;

public abstract class zaj extends zab implements zak
{
    public zaj() {
        super("com.google.android.gms.common.internal.service.ICommonCallbacks");
    }
    
    protected final boolean zaa(int int1, final Parcel parcel, final Parcel parcel2, final int n) throws RemoteException {
        if (int1 == 1) {
            int1 = parcel.readInt();
            zac.zab(parcel);
            this.H0(int1);
            return true;
        }
        return false;
    }
}
