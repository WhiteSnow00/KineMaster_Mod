// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.offline.buffering;

import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import androidx.work.ListenableWorker;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbtw;
import com.google.android.gms.ads.internal.client.zzaw;
import androidx.work.WorkerParameters;
import android.content.Context;
import com.google.android.gms.internal.ads.zzbxk;
import com.google.android.gms.common.annotation.KeepForSdk;
import androidx.work.Worker;

@KeepForSdk
public class OfflineNotificationPoster extends Worker
{
    private final zzbxk g;
    
    public OfflineNotificationPoster(final Context context, final WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.g = zzaw.a().j(context, (zzbtz)new zzbtw());
    }
    
    @Override
    public final a doWork() {
        final String i = this.getInputData().i("uri");
        final String j = this.getInputData().i("gws_query_id");
        try {
            this.g.zzg(ObjectWrapper.q1(this.getApplicationContext()), i, j);
            return ListenableWorker.a.c();
        }
        catch (final RemoteException ex) {
            return ListenableWorker.a.a();
        }
    }
}
