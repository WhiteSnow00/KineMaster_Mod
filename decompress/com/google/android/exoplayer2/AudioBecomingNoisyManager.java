// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Handler;
import android.content.Context;

final class AudioBecomingNoisyManager
{
    private final Context a;
    private final a b;
    private boolean c;
    
    public AudioBecomingNoisyManager(final Context context, final Handler handler, final EventListener eventListener) {
        this.a = context.getApplicationContext();
        this.b = new a(handler, eventListener);
    }
    
    static boolean a(final AudioBecomingNoisyManager audioBecomingNoisyManager) {
        return audioBecomingNoisyManager.c;
    }
    
    public void b(final boolean b) {
        if (b && !this.c) {
            this.a.registerReceiver((BroadcastReceiver)this.b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.c = true;
        }
        else if (!b && this.c) {
            this.a.unregisterReceiver((BroadcastReceiver)this.b);
            this.c = false;
        }
    }
    
    public interface EventListener
    {
        void t();
    }
    
    private final class a extends BroadcastReceiver implements Runnable
    {
        private final EventListener a;
        private final Handler b;
        final AudioBecomingNoisyManager c;
        
        public a(final AudioBecomingNoisyManager c, final Handler b, final EventListener a) {
            this.c = c;
            this.b = b;
            this.a = a;
        }
        
        public void onReceive(final Context context, final Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.b.post((Runnable)this);
            }
        }
        
        public void run() {
            if (AudioBecomingNoisyManager.a(this.c)) {
                this.a.t();
            }
        }
    }
}
