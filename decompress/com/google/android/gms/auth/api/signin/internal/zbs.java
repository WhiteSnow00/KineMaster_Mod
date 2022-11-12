// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.IInterface;
import com.google.android.gms.internal.auth_api.zbc;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import android.os.IBinder;
import com.google.android.gms.internal.auth_api.zba;

public final class zbs extends zba
{
    zbs(final IBinder binder) {
        super(binder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }
    
    public final void M0(final zbr zbr, final GoogleSignInOptions googleSignInOptions) throws RemoteException {
        final Parcel zba = this.zba();
        zbc.zbd(zba, (IInterface)zbr);
        zbc.zbc(zba, (Parcelable)googleSignInOptions);
        this.zbb(103, zba);
    }
    
    public final void p1(final zbr zbr, final GoogleSignInOptions googleSignInOptions) throws RemoteException {
        final Parcel zba = this.zba();
        zbc.zbd(zba, (IInterface)zbr);
        zbc.zbc(zba, (Parcelable)googleSignInOptions);
        this.zbb(102, zba);
    }
    
    public final void q1(final zbr zbr, final GoogleSignInOptions googleSignInOptions) throws RemoteException {
        final Parcel zba = this.zba();
        zbc.zbd(zba, (IInterface)zbr);
        zbc.zbc(zba, (Parcelable)googleSignInOptions);
        this.zbb(101, zba);
    }
}
