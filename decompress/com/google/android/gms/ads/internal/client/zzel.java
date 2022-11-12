// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import com.google.android.gms.internal.ads.zzcfi;
import android.os.RemoteException;
import android.os.IBinder;
import com.google.android.gms.dynamic.ObjectWrapper;
import android.content.Context;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zzel extends RemoteCreator
{
    public zzel() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }
    
    public final zzcm a(Context m0) {
        final RemoteCreatorException ex = null;
        try {
            m0 = (RemoteCreatorException)this.getRemoteCreatorInstance((Context)m0).M0(ObjectWrapper.q1(m0), 221310000);
            if (m0 == null) {
                m0 = ex;
            }
            else {
                final IInterface queryLocalInterface = ((IBinder)m0).queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
                if (queryLocalInterface instanceof zzcm) {
                    m0 = (RemoteCreatorException)queryLocalInterface;
                }
                else {
                    m0 = (RemoteCreatorException)new zzck((IBinder)m0);
                }
            }
            return (zzcm)m0;
        }
        catch (final RemoteCreatorException m0) {}
        catch (final RemoteException ex2) {}
        zzcfi.zzk("Could not get remote MobileAdsSettingManager.", (Throwable)m0);
        return null;
    }
    
    @Override
    protected final Object getRemoteCreator(final IBinder binder) {
        Object o;
        if (binder == null) {
            o = null;
        }
        else {
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
            if (queryLocalInterface instanceof zzcn) {
                o = queryLocalInterface;
            }
            else {
                o = new zzcn(binder);
            }
        }
        return o;
    }
}
