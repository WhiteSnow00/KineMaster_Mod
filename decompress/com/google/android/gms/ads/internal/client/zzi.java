// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import com.google.android.gms.internal.ads.zzcfi;
import android.os.RemoteException;
import android.os.IBinder;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbtz;
import android.content.Context;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zzi extends RemoteCreator
{
    public zzi() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }
    
    public final zzbo a(Context zze, final String s, final zzbtz zzbtz) {
        final RemoteCreatorException ex = null;
        try {
            zze = (RemoteCreatorException)this.getRemoteCreatorInstance((Context)zze).zze(ObjectWrapper.q1(zze), s, zzbtz, 221310000);
            if (zze == null) {
                zze = ex;
            }
            else {
                final IInterface queryLocalInterface = ((IBinder)zze).queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                if (queryLocalInterface instanceof zzbo) {
                    zze = (RemoteCreatorException)queryLocalInterface;
                }
                else {
                    zze = (RemoteCreatorException)new zzbm((IBinder)zze);
                }
            }
            return (zzbo)zze;
        }
        catch (final RemoteCreatorException zze) {}
        catch (final RemoteException ex2) {}
        zzcfi.zzk("Could not create remote builder for AdLoader.", (Throwable)zze);
        return null;
    }
    
    @Override
    protected final Object getRemoteCreator(final IBinder binder) {
        Object o;
        if (binder == null) {
            o = null;
        }
        else {
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
            if (queryLocalInterface instanceof zzbp) {
                o = queryLocalInterface;
            }
            else {
                o = new zzbp(binder);
            }
        }
        return o;
    }
}
