// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import androidx.work.b;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.internal.ads.zzcfi;
import androidx.work.d;
import androidx.work.NetworkType;
import androidx.work.ListenableWorker;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import androidx.work.c;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import e1.n;
import androidx.work.a;
import android.content.Context;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class WorkManagerUtil extends zzbq
{
    @UsedByReflection("This class must be instantiated reflectively so that the default class loader can be used.")
    public WorkManagerUtil() {
    }
    
    private static void M0(Context applicationContext) {
        try {
            applicationContext = applicationContext.getApplicationContext();
            n.e(applicationContext, new a.b().a());
        }
        catch (final IllegalStateException ex) {}
    }
    
    public final void zze(final IObjectWrapper objectWrapper) {
        final Context context = ObjectWrapper.p1(objectWrapper);
        M0(context);
        try {
            final n d = n.d(context);
            d.a("offline_ping_sender_work");
            d.b(((d.a<B, c>)((d.a<c.a, W>)((d.a<c.a, W>)new c.a(OfflinePingSender.class)).e(new e1.a.a().b(NetworkType.CONNECTED).a())).a("offline_ping_sender_work")).b());
        }
        catch (final IllegalStateException ex) {
            zzcfi.zzk("Failed to instantiate WorkManager.", (Throwable)ex);
        }
    }
    
    public final boolean zzf(final IObjectWrapper objectWrapper, final String s, final String s2) {
        final Context context = ObjectWrapper.p1(objectWrapper);
        M0(context);
        final c c = ((d.a<B, c>)((d.a<c.a, W>)((d.a<c.a, W>)((d.a<c.a, W>)new c.a(OfflineNotificationPoster.class)).e(new e1.a.a().b(NetworkType.CONNECTED).a())).f(new b.a().d("uri", s).d("gws_query_id", s2).a())).a("offline_notification_work")).b();
        try {
            n.d(context).b(c);
            return true;
        }
        catch (final IllegalStateException ex) {
            zzcfi.zzk("Failed to instantiate WorkManager.", (Throwable)ex);
            return false;
        }
    }
}
