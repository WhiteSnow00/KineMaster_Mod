// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import android.os.RemoteException;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.api.Status;
import android.os.IInterface;

public interface zae extends IInterface
{
    void R0(final Status p0, final ModuleInstallResponse p1) throws RemoteException;
    
    void T0(final Status p0, final ModuleAvailabilityResponse p1) throws RemoteException;
    
    void e1(final Status p0) throws RemoteException;
    
    void t(final Status p0, final ModuleInstallIntentResponse p1) throws RemoteException;
}
