// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzbqr;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.internal.ads.zzbmo;
import com.google.android.gms.internal.ads.zzbml;
import com.google.android.gms.internal.ads.zzbra;
import com.google.android.gms.internal.ads.zzbme;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbmb;
import com.google.android.gms.internal.ads.zzbly;
import android.os.RemoteException;
import android.os.IInterface;

public interface zzbo extends IInterface
{
    zzbl zze() throws RemoteException;
    
    void zzf(final zzbly p0) throws RemoteException;
    
    void zzg(final zzbmb p0) throws RemoteException;
    
    void zzh(final String p0, final zzbmh p1, final zzbme p2) throws RemoteException;
    
    void zzi(final zzbra p0) throws RemoteException;
    
    void zzj(final zzbml p0, final zzq p1) throws RemoteException;
    
    void zzk(final zzbmo p0) throws RemoteException;
    
    void zzl(final zzbf p0) throws RemoteException;
    
    void zzm(final AdManagerAdViewOptions p0) throws RemoteException;
    
    void zzn(final zzbqr p0) throws RemoteException;
    
    void zzo(final zzbko p0) throws RemoteException;
    
    void zzp(final PublisherAdViewOptions p0) throws RemoteException;
    
    void zzq(final zzcd p0) throws RemoteException;
}
