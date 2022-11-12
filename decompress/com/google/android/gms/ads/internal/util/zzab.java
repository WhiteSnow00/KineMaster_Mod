// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.media.AudioManager;
import android.content.Context;

public final class zzab
{
    private boolean a;
    private float b;
    
    public zzab() {
        this.a = false;
        this.b = 1.0f;
    }
    
    public static float b(final Context context) {
        final AudioManager audioManager = (AudioManager)context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        final int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        final int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return streamVolume / (float)streamMaxVolume;
    }
    
    private final boolean f() {
        synchronized (this) {
            return this.b >= 0.0f;
        }
    }
    
    public final float a() {
        synchronized (this) {
            if (this.f()) {
                return this.b;
            }
            return 1.0f;
        }
    }
    
    public final void c(final boolean a) {
        synchronized (this) {
            this.a = a;
        }
    }
    
    public final void d(final float b) {
        synchronized (this) {
            this.b = b;
        }
    }
    
    public final boolean e() {
        synchronized (this) {
            return this.a;
        }
    }
}
