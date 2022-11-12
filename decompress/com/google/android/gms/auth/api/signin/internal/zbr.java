// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import android.os.IInterface;

public interface zbr extends IInterface
{
    void D(final GoogleSignInAccount p0, final Status p1) throws RemoteException;
    
    void N0(final Status p0) throws RemoteException;
    
    void zbc(final Status p0) throws RemoteException;
}
