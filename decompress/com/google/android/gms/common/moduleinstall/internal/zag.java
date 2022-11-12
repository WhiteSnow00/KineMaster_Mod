// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import android.os.RemoteException;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;
import android.os.Parcel;
import com.google.android.gms.internal.base.zab;

public abstract class zag extends zab implements zah
{
    public zag() {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallStatusListener");
    }
    
    protected final boolean zaa(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n == 1) {
            final ModuleInstallStatusUpdate moduleInstallStatusUpdate = (ModuleInstallStatusUpdate)zac.zaa(parcel, (Parcelable$Creator)ModuleInstallStatusUpdate.CREATOR);
            zac.zab(parcel);
            this.c1(moduleInstallStatusUpdate);
            return true;
        }
        return false;
    }
}
