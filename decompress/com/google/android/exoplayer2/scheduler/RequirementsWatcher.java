// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.scheduler;

import android.net.NetworkCapabilities;
import android.net.Network;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager$NetworkCallback;
import com.google.android.exoplayer2.util.Assertions;
import android.net.ConnectivityManager;
import com.google.android.exoplayer2.util.Util;
import android.os.Handler;
import android.content.Context;

public final class RequirementsWatcher
{
    private final Context a;
    private final Listener b;
    private final Requirements c;
    private final Handler d;
    private b e;
    private int f;
    private c g;
    
    public RequirementsWatcher(final Context context, final Listener b, final Requirements c) {
        this.a = context.getApplicationContext();
        this.b = b;
        this.c = c;
        this.d = Util.y();
    }
    
    static void a(final RequirementsWatcher requirementsWatcher) {
        requirementsWatcher.e();
    }
    
    static Handler b(final RequirementsWatcher requirementsWatcher) {
        return requirementsWatcher.d;
    }
    
    static c c(final RequirementsWatcher requirementsWatcher) {
        return requirementsWatcher.g;
    }
    
    static void d(final RequirementsWatcher requirementsWatcher) {
        requirementsWatcher.g();
    }
    
    private void e() {
        final int c = this.c.c(this.a);
        if (this.f != c) {
            this.f = c;
            this.b.a(this, c);
        }
    }
    
    private void g() {
        if ((this.f & 0x3) == 0x0) {
            return;
        }
        this.e();
    }
    
    private void h() {
        Assertions.e(this.a.getSystemService("connectivity")).registerDefaultNetworkCallback((ConnectivityManager$NetworkCallback)(this.g = new c(null)));
    }
    
    private void k() {
        Assertions.e(this.a.getSystemService("connectivity")).unregisterNetworkCallback((ConnectivityManager$NetworkCallback)Assertions.e(this.g));
        this.g = null;
    }
    
    public Requirements f() {
        return this.c;
    }
    
    public int i() {
        this.f = this.c.c(this.a);
        final IntentFilter intentFilter = new IntentFilter();
        if (this.c.j()) {
            if (Util.a >= 24) {
                this.h();
            }
            else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.c.e()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.c.h()) {
            if (Util.a >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            }
            else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        if (this.c.l()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        final b e = new b(null);
        this.e = e;
        this.a.registerReceiver((BroadcastReceiver)e, intentFilter, (String)null, this.d);
        return this.f;
    }
    
    public void j() {
        this.a.unregisterReceiver((BroadcastReceiver)Assertions.e(this.e));
        this.e = null;
        if (Util.a >= 24 && this.g != null) {
            this.k();
        }
    }
    
    public interface Listener
    {
        void a(final RequirementsWatcher p0, final int p1);
    }
    
    private class b extends BroadcastReceiver
    {
        final RequirementsWatcher a;
        
        private b(final RequirementsWatcher a) {
            this.a = a;
        }
        
        b(final RequirementsWatcher requirementsWatcher, final RequirementsWatcher$a object) {
            this(requirementsWatcher);
        }
        
        public void onReceive(final Context context, final Intent intent) {
            if (!this.isInitialStickyBroadcast()) {
                RequirementsWatcher.a(this.a);
            }
        }
    }
    
    private final class c extends ConnectivityManager$NetworkCallback
    {
        private boolean a;
        private boolean b;
        final RequirementsWatcher c;
        
        private c(final RequirementsWatcher c) {
            this.c = c;
        }
        
        c(final RequirementsWatcher requirementsWatcher, final RequirementsWatcher$a object) {
            this(requirementsWatcher);
        }
        
        public static void a(final c c) {
            c.c();
        }
        
        public static void b(final c c) {
            c.d();
        }
        
        private void c() {
            if (RequirementsWatcher.c(this.c) != null) {
                RequirementsWatcher.a(this.c);
            }
        }
        
        private void d() {
            if (RequirementsWatcher.c(this.c) != null) {
                RequirementsWatcher.d(this.c);
            }
        }
        
        private void e() {
            RequirementsWatcher.b(this.c).post((Runnable)new a(this));
        }
        
        private void f() {
            RequirementsWatcher.b(this.c).post((Runnable)new com.google.android.exoplayer2.scheduler.b(this));
        }
        
        public void onAvailable(final Network network) {
            this.e();
        }
        
        public void onBlockedStatusChanged(final Network network, final boolean b) {
            if (!b) {
                this.f();
            }
        }
        
        public void onCapabilitiesChanged(final Network network, final NetworkCapabilities networkCapabilities) {
            final boolean hasCapability = networkCapabilities.hasCapability(16);
            if (this.a && this.b == hasCapability) {
                if (hasCapability) {
                    this.f();
                }
            }
            else {
                this.a = true;
                this.b = hasCapability;
                this.e();
            }
        }
        
        public void onLost(final Network network) {
            this.e();
        }
    }
}
