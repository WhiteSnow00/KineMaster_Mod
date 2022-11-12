// 
// Decompiled by Procyon v0.6.0
// 

package k1;

import android.net.Network;
import android.content.Intent;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager$NetworkCallback;
import o1.a;
import android.content.Context;
import e1.h;
import android.net.ConnectivityManager;
import i1.b;

public class e extends d<i1.b>
{
    static final String j;
    private final ConnectivityManager g;
    private b h;
    private a i;
    
    static {
        j = h.f("NetworkStateTracker");
    }
    
    public e(final Context context, final o1.a a) {
        super(context, a);
        this.g = (ConnectivityManager)super.b.getSystemService("connectivity");
        if (j()) {
            this.h = new b();
        }
        else {
            this.i = new a();
        }
    }
    
    private static boolean j() {
        return true;
    }
    
    @Override
    public /* bridge */ Object b() {
        return this.h();
    }
    
    @Override
    public void e() {
        if (j()) {
            try {
                e1.h.c().a(e.j, "Registering network callback", new Throwable[0]);
                this.g.registerDefaultNetworkCallback((ConnectivityManager$NetworkCallback)this.h);
                return;
            }
            catch (final SecurityException ex) {}
            catch (final IllegalArgumentException ex2) {}
            final SecurityException ex;
            e1.h.c().b(e.j, "Received exception while registering network callback", ex);
        }
        else {
            e1.h.c().a(e.j, "Registering broadcast receiver", new Throwable[0]);
            super.b.registerReceiver((BroadcastReceiver)this.i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }
    
    @Override
    public void f() {
        if (j()) {
            try {
                e1.h.c().a(e.j, "Unregistering network callback", new Throwable[0]);
                this.g.unregisterNetworkCallback((ConnectivityManager$NetworkCallback)this.h);
                return;
            }
            catch (final SecurityException ex) {}
            catch (final IllegalArgumentException ex2) {}
            final SecurityException ex;
            e1.h.c().b(e.j, "Received exception while unregistering network callback", ex);
        }
        else {
            e1.h.c().a(e.j, "Unregistering broadcast receiver", new Throwable[0]);
            super.b.unregisterReceiver((BroadcastReceiver)this.i);
        }
    }
    
    i1.b g() {
        final NetworkInfo activeNetworkInfo = this.g.getActiveNetworkInfo();
        boolean b = true;
        final boolean b2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        final boolean i = this.i();
        final boolean a = androidx.core.net.a.a(this.g);
        if (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) {
            b = false;
        }
        return new i1.b(b2, i, a, b);
    }
    
    public i1.b h() {
        return this.g();
    }
    
    boolean i() {
        boolean b = true;
        try {
            final NetworkCapabilities networkCapabilities = this.g.getNetworkCapabilities(this.g.getActiveNetwork());
            if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
                b = false;
            }
            return b;
        }
        catch (final SecurityException ex) {
            e1.h.c().b(e.j, "Unable to validate active network", ex);
            return false;
        }
    }
    
    private class a extends BroadcastReceiver
    {
        final e a;
        
        a(final e a) {
            this.a = a;
        }
        
        public void onReceive(final Context context, final Intent intent) {
            if (intent != null) {
                if (intent.getAction() != null) {
                    if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                        e1.h.c().a(e.j, "Network broadcast received", new Throwable[0]);
                        final e a = this.a;
                        a.d(a.g());
                    }
                }
            }
        }
    }
    
    private class b extends ConnectivityManager$NetworkCallback
    {
        final e a;
        
        b(final e a) {
            this.a = a;
        }
        
        public void onCapabilitiesChanged(final Network network, final NetworkCapabilities networkCapabilities) {
            e1.h.c().a(e.j, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            final e a = this.a;
            a.d(a.g());
        }
        
        public void onLost(final Network network) {
            e1.h.c().a(e.j, "Network connection lost", new Throwable[0]);
            final e a = this.a;
            a.d(a.g());
        }
    }
}
