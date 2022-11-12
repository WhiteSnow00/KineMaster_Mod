// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzfvj;
import com.google.android.gms.internal.ads.zzcfy;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.internal.ads.zzcfh;
import android.content.Context;

public final class zzd
{
    public static void a(final Context context) {
        if (!zzcfh.zzk(context)) {
            return;
        }
        if (!zzcfh.zzm()) {
            final zzfvj zzb = new k(context).zzb();
            zzcfi.zzi("Updating ad debug logging enablement.");
            zzcfy.zza(zzb, "AdDebugLogUpdater.updateEnablement");
        }
    }
}
