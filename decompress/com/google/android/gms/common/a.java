// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import android.util.Log;
import android.os.Message;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.internal.base.zau;

final class a extends zau
{
    private final Context a;
    final GoogleApiAvailability b;
    
    public a(final GoogleApiAvailability b, final Context context) {
        this.b = b;
        Looper looper;
        if (Looper.myLooper() == null) {
            looper = Looper.getMainLooper();
        }
        else {
            looper = Looper.myLooper();
        }
        super(looper);
        this.a = context.getApplicationContext();
    }
    
    public final void handleMessage(final Message message) {
        final int what = message.what;
        if (what != 1) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Don't know how to handle this message: ");
            sb.append(what);
            Log.w("GoogleApiAvailability", sb.toString());
            return;
        }
        final int i = this.b.i(this.a);
        if (this.b.m(i)) {
            this.b.t(this.a, i);
        }
    }
}
