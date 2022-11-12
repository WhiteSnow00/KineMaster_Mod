// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzcfl;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcfm;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzbtz;
import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbyz;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zzk extends RemoteCreator
{
    private zzbyz a;
    
    @VisibleForTesting
    public zzk() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }
    
    public final zzbs a(Context m0, zzq queryLocalInterface, final String s, final zzbtz zzbtz, final int n) {
        zzbhy.zzc((Context)m0);
        final boolean booleanValue = (boolean)zzay.c().zzb(zzbhy.zzib);
        final RemoteCreatorException ex = null;
        final RemoteCreatorException ex2 = null;
        if (booleanValue) {
            try {
                final IBinder m2 = ((zzbt)zzcfm.zzb((Context)m0, "com.google.android.gms.ads.ChimeraAdManagerCreatorImpl", (zzcfk)zzj.a)).M0(ObjectWrapper.q1(m0), (zzq)queryLocalInterface, s, zzbtz, 221310000, n);
                if (m2 == null) {
                    m0 = ex2;
                    return (zzbs)m0;
                }
                queryLocalInterface = (NullPointerException)m2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (queryLocalInterface instanceof zzbs) {
                    queryLocalInterface = (NullPointerException)(m0 = (RemoteCreatorException)queryLocalInterface);
                }
                else {
                    queryLocalInterface = (NullPointerException)(m0 = (RemoteCreatorException)new zzbq(m2));
                }
                return (zzbs)m0;
            }
            catch (final NullPointerException queryLocalInterface) {}
            catch (final RemoteException queryLocalInterface) {}
            catch (final zzcfl zzcfl) {}
            (this.a = zzbyx.zza((Context)m0)).zzd((Throwable)queryLocalInterface, "AdManagerCreator.newAdManagerByDynamiteLoader");
            zzcfi.zzl("#007 Could not call remote method.", (Throwable)queryLocalInterface);
            m0 = ex2;
            return (zzbs)m0;
        }
        try {
            m0 = (RemoteCreatorException)this.getRemoteCreatorInstance((Context)m0).M0(ObjectWrapper.q1(m0), (zzq)queryLocalInterface, s, zzbtz, 221310000, n);
            if (m0 == null) {
                m0 = ex;
            }
            else {
                final IInterface queryLocalInterface2 = ((IBinder)m0).queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (queryLocalInterface2 instanceof zzbs) {
                    m0 = (RemoteCreatorException)queryLocalInterface2;
                }
                else {
                    m0 = (RemoteCreatorException)new zzbq((IBinder)m0);
                }
            }
            return (zzbs)m0;
        }
        catch (final RemoteCreatorException m0) {}
        catch (final RemoteException ex3) {}
        zzcfi.zzf("Could not create remote AdManager.", (Throwable)m0);
        return null;
    }
    
    @Override
    protected final Object getRemoteCreator(final IBinder binder) {
        Object o;
        if (binder == null) {
            o = null;
        }
        else {
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
            if (queryLocalInterface instanceof zzbt) {
                o = queryLocalInterface;
            }
            else {
                o = new zzbt(binder);
            }
        }
        return o;
    }
}
