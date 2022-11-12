// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

final class l extends BroadcastReceiver
{
    final zzcg a;
    
    l(final zzcg a) {
        this.a = a;
    }
    
    public final void onReceive(final Context context, final Intent intent) {
        zzcg.a(this.a, context, intent);
    }
}
