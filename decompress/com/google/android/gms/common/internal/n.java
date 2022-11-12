// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.util.Log;
import android.os.Message;
import android.os.Handler$Callback;

final class n implements Handler$Callback
{
    final o a;
    
    n(final o a, final zzp zzp) {
        this.a = a;
    }
    
    public final boolean handleMessage(final Message message) {
        final int what = message.what;
        if (what != 0) {
            if (what != 1) {
                return false;
            }
            synchronized (o.m(this.a)) {
                final zzn zzn = (zzn)message.obj;
                final m m = o.m(this.a).get(zzn);
                if (m != null && m.a() == 3) {
                    final String value = String.valueOf(zzn);
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(value);
                    Log.e("GmsClientSupervisor", sb.toString(), (Throwable)new Exception());
                    ComponentName componentName;
                    if ((componentName = m.b()) == null) {
                        componentName = zzn.b();
                    }
                    ComponentName componentName2;
                    if ((componentName2 = componentName) == null) {
                        componentName2 = new(android.content.ComponentName.class)();
                        final String d = zzn.d();
                        Preconditions.k(d);
                        new ComponentName(d, "unknown");
                    }
                    m.onServiceDisconnected(componentName2);
                }
                return true;
            }
        }
        synchronized (o.m(this.a)) {
            final zzn zzn2 = (zzn)message.obj;
            final m i = o.m(this.a).get(zzn2);
            if (i != null && i.i()) {
                if (i.j()) {
                    i.g("GmsClientSupervisor");
                }
                o.m(this.a).remove(zzn2);
            }
            return true;
        }
    }
}
