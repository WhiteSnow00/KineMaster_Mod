// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

final class o extends BroadcastReceiver
{
    final zzs a;
    
    o(final zzs a, final zzq zzq) {
        this.a = a;
    }
    
    public final void onReceive(final Context context, final Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            zzs.z(this.a, true);
            return;
        }
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            zzs.z(this.a, false);
        }
    }
}
