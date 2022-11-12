// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import android.os.Message;
import android.os.Handler$Callback;
import android.os.Looper;
import android.os.Handler;

class v
{
    private boolean a;
    private final Handler b;
    
    v() {
        this.b = new Handler(Looper.getMainLooper(), (Handler$Callback)new a());
    }
    
    void a(final s<?> s, final boolean b) {
        synchronized (this) {
            if (!this.a && !b) {
                this.a = true;
                s.b();
                this.a = false;
            }
            else {
                this.b.obtainMessage(1, (Object)s).sendToTarget();
            }
        }
    }
    
    private static final class a implements Handler$Callback
    {
        a() {
        }
        
        public boolean handleMessage(final Message message) {
            if (message.what == 1) {
                ((s)message.obj).b();
                return true;
            }
            return false;
        }
    }
}
