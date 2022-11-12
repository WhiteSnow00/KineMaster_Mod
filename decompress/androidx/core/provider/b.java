// 
// Decompiled by Procyon v0.6.0
// 

package androidx.core.provider;

import android.os.Looper;
import android.os.Handler;

class b
{
    static Handler a() {
        Handler handler;
        if (Looper.myLooper() == null) {
            handler = new Handler(Looper.getMainLooper());
        }
        else {
            handler = new Handler();
        }
        return handler;
    }
}
