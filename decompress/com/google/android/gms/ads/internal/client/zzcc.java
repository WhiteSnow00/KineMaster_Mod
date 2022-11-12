// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbxu;
import com.google.android.gms.internal.ads.zzcan;
import com.google.android.gms.internal.ads.zzcdz;
import com.google.android.gms.internal.ads.zzblk;
import com.google.android.gms.internal.ads.zzbxk;
import com.google.android.gms.internal.ads.zzcbd;
import com.google.android.gms.internal.ads.zzble;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbpj;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.dynamic.IObjectWrapper;
import android.os.IInterface;

public interface zzcc extends IInterface
{
    zzbpj I0(final IObjectWrapper p0, final zzbtz p1, final int p2, final zzbpg p3) throws RemoteException;
    
    zzble P(final IObjectWrapper p0, final IObjectWrapper p1) throws RemoteException;
    
    zzcbd Q0(final IObjectWrapper p0, final String p1, final zzbtz p2, final int p3) throws RemoteException;
    
    zzbs S0(final IObjectWrapper p0, final zzq p1, final String p2, final int p3) throws RemoteException;
    
    zzbxk V(final IObjectWrapper p0, final zzbtz p1, final int p2) throws RemoteException;
    
    zzbo c0(final IObjectWrapper p0, final String p1, final zzbtz p2, final int p3) throws RemoteException;
    
    zzbs f(final IObjectWrapper p0, final zzq p1, final String p2, final zzbtz p3, final int p4) throws RemoteException;
    
    zzbs f1(final IObjectWrapper p0, final zzq p1, final String p2, final zzbtz p3, final int p4) throws RemoteException;
    
    zzblk n1(final IObjectWrapper p0, final IObjectWrapper p1, final IObjectWrapper p2) throws RemoteException;
    
    zzcdz o(final IObjectWrapper p0, final zzbtz p1, final int p2) throws RemoteException;
    
    zzbs p(final IObjectWrapper p0, final zzq p1, final String p2, final zzbtz p3, final int p4) throws RemoteException;
    
    zzcan z(final IObjectWrapper p0, final zzbtz p1, final int p2) throws RemoteException;
    
    zzcm zzg(final IObjectWrapper p0, final int p1) throws RemoteException;
    
    zzbxu zzl(final IObjectWrapper p0) throws RemoteException;
}
