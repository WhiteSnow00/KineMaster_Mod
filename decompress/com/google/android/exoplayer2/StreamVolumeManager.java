// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import android.content.Intent;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Log;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.google.android.exoplayer2.util.Assertions;
import android.media.AudioManager;
import android.os.Handler;
import android.content.Context;

final class StreamVolumeManager
{
    private final Context a;
    private final Handler b;
    private final Listener c;
    private final AudioManager d;
    private b e;
    private int f;
    private int g;
    private boolean h;
    
    public StreamVolumeManager(Context applicationContext, final Handler b, final Listener c) {
        applicationContext = applicationContext.getApplicationContext();
        this.a = applicationContext;
        this.b = b;
        this.c = c;
        final AudioManager d = Assertions.i(applicationContext.getSystemService("audio"));
        this.d = d;
        this.f = 3;
        this.g = f(d, 3);
        this.h = e(d, this.f);
        final b e = new b(null);
        final IntentFilter intentFilter = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
        try {
            applicationContext.registerReceiver((BroadcastReceiver)e, intentFilter);
            this.e = e;
        }
        catch (final RuntimeException ex) {
            Log.j("StreamVolumeManager", "Error registering stream volume receiver", ex);
        }
    }
    
    static Handler a(final StreamVolumeManager streamVolumeManager) {
        return streamVolumeManager.b;
    }
    
    static void b(final StreamVolumeManager streamVolumeManager) {
        streamVolumeManager.i();
    }
    
    private static boolean e(final AudioManager audioManager, final int n) {
        if (Util.a >= 23) {
            return audioManager.isStreamMute(n);
        }
        return f(audioManager, n) == 0;
    }
    
    private static int f(final AudioManager audioManager, final int n) {
        try {
            return audioManager.getStreamVolume(n);
        }
        catch (final RuntimeException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not retrieve stream volume for stream type ");
            sb.append(n);
            Log.j("StreamVolumeManager", sb.toString(), ex);
            return audioManager.getStreamMaxVolume(n);
        }
    }
    
    private void i() {
        final int f = f(this.d, this.f);
        final boolean e = e(this.d, this.f);
        if (this.g != f || this.h != e) {
            this.g = f;
            this.h = e;
            this.c.w(f, e);
        }
    }
    
    public int c() {
        return this.d.getStreamMaxVolume(this.f);
    }
    
    public int d() {
        int streamMinVolume;
        if (Util.a >= 28) {
            streamMinVolume = this.d.getStreamMinVolume(this.f);
        }
        else {
            streamMinVolume = 0;
        }
        return streamMinVolume;
    }
    
    public void g() {
        final b e = this.e;
        if (e != null) {
            try {
                this.a.unregisterReceiver((BroadcastReceiver)e);
            }
            catch (final RuntimeException ex) {
                Log.j("StreamVolumeManager", "Error unregistering stream volume receiver", ex);
            }
            this.e = null;
        }
    }
    
    public void h(final int f) {
        if (this.f == f) {
            return;
        }
        this.f = f;
        this.i();
        this.c.k(f);
    }
    
    public interface Listener
    {
        void k(final int p0);
        
        void w(final int p0, final boolean p1);
    }
    
    private final class b extends BroadcastReceiver
    {
        final StreamVolumeManager a;
        
        private b(final StreamVolumeManager a) {
            this.a = a;
        }
        
        b(final StreamVolumeManager streamVolumeManager, final StreamVolumeManager$a object) {
            this(streamVolumeManager);
        }
        
        public static void a(final StreamVolumeManager streamVolumeManager) {
            b(streamVolumeManager);
        }
        
        private static void b(final StreamVolumeManager streamVolumeManager) {
            StreamVolumeManager.b(streamVolumeManager);
        }
        
        public void onReceive(final Context context, final Intent intent) {
            StreamVolumeManager.a(this.a).post((Runnable)new t1(this.a));
        }
    }
}
