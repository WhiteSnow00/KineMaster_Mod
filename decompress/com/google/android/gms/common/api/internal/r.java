// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.os.Message;
import android.os.Looper;
import com.google.android.gms.internal.base.zau;

final class r extends zau
{
    final zabe a;
    
    r(final zabe a, final Looper looper) {
        this.a = a;
        super(looper);
    }
    
    public final void handleMessage(final Message message) {
        final int what = message.what;
        if (what == 1) {
            zabe.y(this.a);
            return;
        }
        if (what != 2) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unknown message id: ");
            sb.append(what);
            Log.w("GoogleApiClientImpl", sb.toString());
            return;
        }
        zabe.x(this.a);
    }
}
