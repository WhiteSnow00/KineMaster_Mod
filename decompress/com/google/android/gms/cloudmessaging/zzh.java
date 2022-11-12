// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.os.Messenger;
import android.content.Context;
import android.os.RemoteException;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import java.util.concurrent.TimeUnit;

public final class zzh implements Runnable
{
    public final c a;
    
    public zzh(final c a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        final c a = this.a;
        while (true) {
            synchronized (a) {
                if (a.a != 2) {
                    return;
                }
                if (a.d.isEmpty()) {
                    a.f();
                    return;
                }
                final f f = a.d.poll();
                a.e.put(f.a, (Object)f);
                zzs.e(a.f).schedule(new zzk(a, f), 30L, TimeUnit.SECONDS);
                monitorexit(a);
                if (Log.isLoggable("MessengerIpcClient", 3)) {
                    final String value = String.valueOf(f);
                    final StringBuilder sb = new StringBuilder(value.length() + 8);
                    sb.append("Sending ");
                    sb.append(value);
                    Log.d("MessengerIpcClient", sb.toString());
                }
                final Context a2 = zzs.a(a.f);
                final Messenger b = a.b;
                final Message obtain = Message.obtain();
                obtain.what = f.c;
                obtain.arg1 = f.a;
                obtain.replyTo = b;
                final Bundle data = new Bundle();
                data.putBoolean("oneWay", f.b());
                data.putString("pkg", a2.getPackageName());
                data.putBundle("data", f.d);
                obtain.setData(data);
                try {
                    a.c.a(obtain);
                }
                catch (final RemoteException ex) {
                    a.a(2, ex.getMessage());
                }
            }
        }
    }
}
