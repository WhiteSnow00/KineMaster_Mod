// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.RemoteException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;

public interface IGmsCallbacks extends IInterface
{
    void G(final int p0, final IBinder p1, final Bundle p2) throws RemoteException;
    
    void W0(final int p0, final IBinder p1, final zzj p2) throws RemoteException;
    
    void a(final int p0, final Bundle p1) throws RemoteException;
}
