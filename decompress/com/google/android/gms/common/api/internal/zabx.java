// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.net.Uri;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;

public final class zabx extends BroadcastReceiver
{
    Context a;
    private final zabw b;
    
    public zabx(final zabw b) {
        this.b = b;
    }
    
    public final void a(final Context a) {
        this.a = a;
    }
    
    public final void b() {
        synchronized (this) {
            final Context a = this.a;
            if (a != null) {
                a.unregisterReceiver((BroadcastReceiver)this);
            }
            this.a = null;
        }
    }
    
    public final void onReceive(final Context context, final Intent intent) {
        final Uri data = intent.getData();
        String schemeSpecificPart;
        if (data != null) {
            schemeSpecificPart = data.getSchemeSpecificPart();
        }
        else {
            schemeSpecificPart = null;
        }
        if ("com.google.android.gms".equals(schemeSpecificPart)) {
            this.b.a();
            this.b();
        }
    }
}
