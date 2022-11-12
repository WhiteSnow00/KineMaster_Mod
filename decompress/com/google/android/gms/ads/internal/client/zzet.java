// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzcfb;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;
import java.util.List;
import java.util.Collections;
import com.google.android.gms.internal.ads.zzbqm;

public final class zzet extends zzcl
{
    private zzbqm a;
    
    final void zzb() {
        final zzbqm a = this.a;
        if (a != null) {
            try {
                a.zzb((List)Collections.emptyList());
            }
            catch (final RemoteException ex) {
                zzcfi.zzk("Could not notify onComplete event.", (Throwable)ex);
            }
        }
    }
    
    public final float zze() throws RemoteException {
        return 1.0f;
    }
    
    public final String zzf() {
        return "";
    }
    
    public final List zzg() throws RemoteException {
        return Collections.emptyList();
    }
    
    public final void zzh(final String s) throws RemoteException {
    }
    
    public final void zzi() {
    }
    
    public final void zzj() throws RemoteException {
        zzcfi.zzg("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzcfb.zza.post((Runnable)new zzes(this));
    }
    
    public final void zzk(final String s, final IObjectWrapper objectWrapper) throws RemoteException {
    }
    
    public final void zzl(final zzcy zzcy) {
    }
    
    public final void zzm(final IObjectWrapper objectWrapper, final String s) throws RemoteException {
    }
    
    public final void zzn(final zzbtz zzbtz) throws RemoteException {
    }
    
    public final void zzo(final boolean b) throws RemoteException {
    }
    
    public final void zzp(final float n) throws RemoteException {
    }
    
    public final void zzq(final String s) throws RemoteException {
    }
    
    public final void zzr(final zzbqm a) throws RemoteException {
        this.a = a;
    }
    
    public final void zzs(final zzfa zzfa) throws RemoteException {
    }
    
    public final boolean zzt() throws RemoteException {
        return false;
    }
}
