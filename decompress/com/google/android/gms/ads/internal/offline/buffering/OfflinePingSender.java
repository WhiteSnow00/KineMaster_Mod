// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.offline.buffering;

import android.os.RemoteException;
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
public class OfflinePingSender extends Worker
{
    private final zzbxk g;
    
    public OfflinePingSender(final Context context, final WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.g = zzaw.a().j(context, (zzbtz)new zzbtw());
    }
    
    @Override
    public final a doWork() {
        try {
            this.g.zzf();
            return ListenableWorker.a.c();
        }
        catch (final RemoteException ex) {
            return ListenableWorker.a.a();
        }
    }
}
