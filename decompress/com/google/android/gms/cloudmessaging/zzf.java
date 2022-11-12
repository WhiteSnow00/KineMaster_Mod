// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import android.os.Message;
import android.os.Handler$Callback;

public final class zzf implements Handler$Callback
{
    public final c a;
    
    public zzf(final c a) {
        this.a = a;
    }
    
    public final boolean handleMessage(final Message message) {
        final c a = this.a;
        final int arg1 = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            final StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(arg1);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (a) {
            final f f = (f)a.e.get(arg1);
            if (f == null) {
                final StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(arg1);
                Log.w("MessengerIpcClient", sb2.toString());
                monitorexit(a);
            }
            else {
                a.e.remove(arg1);
                a.f();
                monitorexit(a);
                final Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    f.c(new zzq(4, "Not supported by GmsCore", null));
                }
                else {
                    f.a(data);
                }
            }
            return true;
        }
    }
}
