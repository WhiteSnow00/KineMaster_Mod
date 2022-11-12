// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.IStatusCallback;
import android.os.RemoteException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.IInterface;
import com.google.android.gms.internal.base.zac;
import android.os.IBinder;
import com.google.android.gms.internal.base.zaa;

public final class zaf extends zaa
{
    zaf(final IBinder binder) {
        super(binder, "com.google.android.gms.common.moduleinstall.internal.IModuleInstallService");
    }
    
    public final void M0(final zae zae, final ApiFeatureRequest apiFeatureRequest) throws RemoteException {
        final Parcel zaa = this.zaa();
        zac.zae(zaa, (IInterface)zae);
        zac.zad(zaa, (Parcelable)apiFeatureRequest);
        this.zac(1, zaa);
    }
    
    public final void p1(final zae zae, final ApiFeatureRequest apiFeatureRequest) throws RemoteException {
        final Parcel zaa = this.zaa();
        zac.zae(zaa, (IInterface)zae);
        zac.zad(zaa, (Parcelable)apiFeatureRequest);
        this.zac(3, zaa);
    }
    
    public final void q1(final zae zae, final ApiFeatureRequest apiFeatureRequest, final zah zah) throws RemoteException {
        final Parcel zaa = this.zaa();
        zac.zae(zaa, (IInterface)zae);
        zac.zad(zaa, (Parcelable)apiFeatureRequest);
        zac.zae(zaa, (IInterface)zah);
        this.zac(2, zaa);
    }
    
    public final void r1(final IStatusCallback statusCallback, final ApiFeatureRequest apiFeatureRequest) throws RemoteException {
        final Parcel zaa = this.zaa();
        zac.zae(zaa, (IInterface)statusCallback);
        zac.zad(zaa, (Parcelable)apiFeatureRequest);
        this.zac(4, zaa);
    }
    
    public final void s1(final IStatusCallback statusCallback, final zah zah) throws RemoteException {
        final Parcel zaa = this.zaa();
        zac.zae(zaa, (IInterface)statusCallback);
        zac.zae(zaa, (IInterface)zah);
        this.zac(6, zaa);
    }
}
