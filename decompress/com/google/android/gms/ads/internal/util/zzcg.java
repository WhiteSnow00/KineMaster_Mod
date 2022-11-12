// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbhy;
import java.util.Iterator;
import android.content.IntentFilter;
import java.util.ArrayList;
import android.content.Intent;
import java.util.WeakHashMap;
import android.content.Context;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import android.content.BroadcastReceiver;

public final class zzcg
{
    @GuardedBy
    private final BroadcastReceiver a;
    @GuardedBy
    private final Map b;
    private boolean c;
    private boolean d;
    private Context e;
    
    public zzcg() {
        this.c = false;
        this.b = new WeakHashMap();
        this.a = new l(this);
    }
    
    static /* bridge */ void a(final zzcg zzcg, final Context context, final Intent intent) {
        zzcg.e(context, intent);
    }
    
    private final void e(final Context context, final Intent intent) {
        synchronized (this) {
            final ArrayList list = new ArrayList();
            for (final Map.Entry<K, IntentFilter> entry : this.b.entrySet()) {
                if (entry.getValue().hasAction(intent.getAction())) {
                    list.add(entry.getKey());
                }
            }
            for (int size = list.size(), i = 0; i < size; ++i) {
                ((BroadcastReceiver)list.get(i)).onReceive(context, intent);
            }
        }
    }
    
    public final void b(final Context e) {
        synchronized (this) {
            if (this.c) {
                return;
            }
            if ((this.e = e.getApplicationContext()) == null) {
                this.e = e;
            }
            zzbhy.zzc(this.e);
            this.d = (boolean)zzay.c().zzb(zzbhy.zzcR);
            final IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.e.registerReceiver(this.a, intentFilter);
            this.c = true;
        }
    }
    
    public final void c(final Context context, final BroadcastReceiver broadcastReceiver, final IntentFilter intentFilter) {
        synchronized (this) {
            if (this.d) {
                this.b.put(broadcastReceiver, intentFilter);
                return;
            }
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }
    
    public final void d(final Context context, final BroadcastReceiver broadcastReceiver) {
        synchronized (this) {
            if (this.d) {
                this.b.remove(broadcastReceiver);
                return;
            }
            context.unregisterReceiver(broadcastReceiver);
        }
    }
}
