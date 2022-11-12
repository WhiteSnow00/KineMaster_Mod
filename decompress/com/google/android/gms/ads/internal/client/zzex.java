// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzcbl;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzcbr;
import com.google.android.gms.internal.ads.zzcbg;
import com.google.android.gms.internal.ads.zzcba;
import android.os.RemoteException;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzcfb;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzcbk;
import com.google.android.gms.internal.ads.zzcbc;

public final class zzex extends zzcbc
{
    private static void M0(final zzcbk zzcbk) {
        zzcfi.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzcfb.zza.post((Runnable)new zzew(zzcbk));
    }
    
    public final Bundle zzb() throws RemoteException {
        return new Bundle();
    }
    
    public final zzdh zzc() {
        return null;
    }
    
    public final zzcba zzd() {
        return null;
    }
    
    public final String zze() throws RemoteException {
        return "";
    }
    
    public final void zzf(final zzl zzl, final zzcbk zzcbk) throws RemoteException {
        M0(zzcbk);
    }
    
    public final void zzg(final zzl zzl, final zzcbk zzcbk) throws RemoteException {
        M0(zzcbk);
    }
    
    public final void zzh(final boolean b) {
    }
    
    public final void zzi(final zzdb zzdb) throws RemoteException {
    }
    
    public final void zzj(final zzde zzde) {
    }
    
    public final void zzk(final zzcbg zzcbg) throws RemoteException {
    }
    
    public final void zzl(final zzcbr zzcbr) {
    }
    
    public final void zzm(final IObjectWrapper objectWrapper) throws RemoteException {
    }
    
    public final void zzn(final IObjectWrapper objectWrapper, final boolean b) {
    }
    
    public final boolean zzo() throws RemoteException {
        return false;
    }
    
    public final void zzp(final zzcbl zzcbl) throws RemoteException {
    }
}
