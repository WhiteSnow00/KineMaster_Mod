// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzbtz;
import android.content.Context;
import com.google.android.gms.internal.ads.zzbtw;
import com.google.android.gms.ads.internal.client.zzaw;
import android.content.Intent;
import com.google.android.gms.common.annotation.KeepForSdk;
import android.app.IntentService;

@KeepForSdk
public class AdService extends IntentService
{
    public AdService() {
        super("AdService");
    }
    
    protected final void onHandleIntent(final Intent intent) {
        try {
            zzaw.a().j((Context)this, (zzbtz)new zzbtw()).zze(intent);
        }
        catch (final RemoteException ex) {
            zzcfi.zzg("RemoteException calling handleNotificationIntent: ".concat(ex.toString()));
        }
    }
}
