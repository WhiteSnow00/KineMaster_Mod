// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import android.content.Intent;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyCallback$DisplayInfoListener;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import java.util.Iterator;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Looper;
import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import android.os.Handler;

public final class NetworkTypeObserver
{
    private static NetworkTypeObserver e;
    private final Handler a;
    private final CopyOnWriteArrayList<WeakReference<Listener>> b;
    private final Object c;
    private int d;
    
    private NetworkTypeObserver(final Context context) {
        this.a = new Handler(Looper.getMainLooper());
        this.b = new CopyOnWriteArrayList<WeakReference<Listener>>();
        this.c = new Object();
        this.d = 0;
        final IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver((BroadcastReceiver)new c(null), intentFilter);
    }
    
    public static void a(final NetworkTypeObserver networkTypeObserver, final Listener listener) {
        networkTypeObserver.h(listener);
    }
    
    static int b(final Context context) {
        return g(context);
    }
    
    static void c(final NetworkTypeObserver networkTypeObserver, final int n) {
        networkTypeObserver.k(n);
    }
    
    public static NetworkTypeObserver d(final Context context) {
        synchronized (NetworkTypeObserver.class) {
            if (NetworkTypeObserver.e == null) {
                NetworkTypeObserver.e = new NetworkTypeObserver(context);
            }
            return NetworkTypeObserver.e;
        }
    }
    
    private static int e(final NetworkInfo networkInfo) {
        switch (networkInfo.getSubtype()) {
            default: {
                return 6;
            }
            case 20: {
                int n;
                if (Util.a >= 29) {
                    n = 9;
                }
                else {
                    n = 0;
                }
                return n;
            }
            case 18: {
                return 2;
            }
            case 13: {
                return 5;
            }
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 17: {
                return 4;
            }
            case 1:
            case 2: {
                return 3;
            }
        }
    }
    
    private static int g(final Context context) {
        final ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
        int type = 0;
        if (connectivityManager == null) {
            return 0;
        }
        try {
            final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            final int n = type = 1;
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    type = activeNetworkInfo.getType();
                    if (type != 0) {
                        if (type == 1) {
                            return 2;
                        }
                        if (type != 4 && type != 5) {
                            if (type == 6) {
                                return 5;
                            }
                            if (type != 9) {
                                return 8;
                            }
                            return 7;
                        }
                    }
                    return e(activeNetworkInfo);
                }
                type = n;
            }
            return type;
        }
        catch (final SecurityException ex) {
            return type;
        }
    }
    
    private void h(final Listener listener) {
        listener.a(this.f());
    }
    
    private void j() {
        for (final WeakReference weakReference : this.b) {
            if (weakReference.get() == null) {
                this.b.remove(weakReference);
            }
        }
    }
    
    private void k(final int d) {
        Object c = this.c;
        synchronized (c) {
            if (this.d == d) {
                return;
            }
            this.d = d;
            monitorexit(c);
            for (final WeakReference weakReference : this.b) {
                c = weakReference.get();
                if (c != null) {
                    ((Listener)c).a(d);
                }
                else {
                    this.b.remove(weakReference);
                }
            }
        }
    }
    
    public int f() {
        synchronized (this.c) {
            return this.d;
        }
    }
    
    public void i(final Listener listener) {
        this.j();
        this.b.add(new WeakReference<Listener>(listener));
        this.a.post((Runnable)new com.google.android.exoplayer2.util.c(this, listener));
    }
    
    public interface Listener
    {
        void a(final int p0);
    }
    
    private static final class b
    {
        public static void a(final Context context, final NetworkTypeObserver networkTypeObserver) {
            try {
                final TelephonyManager telephonyManager = Assertions.e(context.getSystemService("phone"));
                final a a = new a(networkTypeObserver);
                telephonyManager.registerTelephonyCallback(context.getMainExecutor(), (TelephonyCallback)a);
                telephonyManager.unregisterTelephonyCallback((TelephonyCallback)a);
            }
            catch (final RuntimeException ex) {
                NetworkTypeObserver.c(networkTypeObserver, 5);
            }
        }
        
        private static final class a extends TelephonyCallback implements TelephonyCallback$DisplayInfoListener
        {
            private final NetworkTypeObserver a;
            
            public a(final NetworkTypeObserver a) {
                this.a = a;
            }
            
            public void onDisplayInfoChanged(final TelephonyDisplayInfo telephonyDisplayInfo) {
                final int overrideNetworkType = telephonyDisplayInfo.getOverrideNetworkType();
                int n = 5;
                final boolean b = overrideNetworkType == 3 || overrideNetworkType == 4 || overrideNetworkType == 5;
                final NetworkTypeObserver a = this.a;
                if (b) {
                    n = 10;
                }
                NetworkTypeObserver.c(a, n);
            }
        }
    }
    
    private final class c extends BroadcastReceiver
    {
        final NetworkTypeObserver a;
        
        private c(final NetworkTypeObserver a) {
            this.a = a;
        }
        
        c(final NetworkTypeObserver networkTypeObserver, final NetworkTypeObserver$a object) {
            this(networkTypeObserver);
        }
        
        public void onReceive(final Context context, final Intent intent) {
            final int b = NetworkTypeObserver.b(context);
            if (Util.a >= 31 && b == 5) {
                NetworkTypeObserver.b.a(context, this.a);
            }
            else {
                NetworkTypeObserver.c(this.a, b);
            }
        }
    }
}
