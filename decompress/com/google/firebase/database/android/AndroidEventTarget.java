// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.android;

import android.os.Looper;
import android.os.Handler;
import com.google.firebase.database.core.EventTarget;

public class AndroidEventTarget implements EventTarget
{
    private final Handler a;
    
    public AndroidEventTarget() {
        this.a = new Handler(Looper.getMainLooper());
    }
    
    @Override
    public void a() {
    }
    
    @Override
    public void b(final Runnable runnable) {
        this.a.post(runnable);
    }
}
