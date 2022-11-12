// 
// Decompiled by Procyon v0.6.0
// 

package p2;

import java.util.Iterator;
import android.util.Log;
import android.net.Network;
import v2.l;
import android.net.ConnectivityManager$NetworkCallback;
import java.util.Collection;
import java.util.ArrayList;
import android.net.ConnectivityManager;
import v2.f;
import java.util.HashSet;
import android.content.Context;
import java.util.Set;

final class s
{
    private static volatile s d;
    private final c a;
    final Set<p2.c.a> b;
    private boolean c;
    
    private s(final Context context) {
        this.b = new HashSet<p2.c.a>();
        this.a = (c)new d(f.a((f.b<ConnectivityManager>)new f.b<ConnectivityManager>(this, context) {
            final Context a;
            final s b;
            
            public ConnectivityManager a() {
                return (ConnectivityManager)this.a.getSystemService("connectivity");
            }
            
            @Override
            public /* bridge */ Object get() {
                return this.a();
            }
        }), new p2.c.a(this) {
            final s a;
            
            @Override
            public void a(final boolean b) {
                Object o = this.a;
                synchronized (o) {
                    final ArrayList list = new ArrayList(this.a.b);
                    monitorexit(o);
                    o = list.iterator();
                    while (((Iterator)o).hasNext()) {
                        ((a)((Iterator)o).next()).a(b);
                    }
                }
            }
        });
    }
    
    static s a(final Context context) {
        if (s.d == null) {
            synchronized (s.class) {
                if (s.d == null) {
                    s.d = new s(context.getApplicationContext());
                }
            }
        }
        return s.d;
    }
    
    private void b() {
        if (!this.c) {
            if (!this.b.isEmpty()) {
                this.c = this.a.b();
            }
        }
    }
    
    private void c() {
        if (this.c) {
            if (this.b.isEmpty()) {
                this.a.a();
                this.c = false;
            }
        }
    }
    
    void d(final p2.c.a a) {
        synchronized (this) {
            this.b.add(a);
            this.b();
        }
    }
    
    void e(final p2.c.a a) {
        synchronized (this) {
            this.b.remove(a);
            this.c();
        }
    }
    
    private interface c
    {
        void a();
        
        boolean b();
    }
    
    private static final class d implements c
    {
        boolean a;
        final p2.c.a b;
        private final f.b<ConnectivityManager> c;
        private final ConnectivityManager$NetworkCallback d;
        
        d(final f.b<ConnectivityManager> c, final p2.c.a b) {
            this.d = new ConnectivityManager$NetworkCallback() {
                final d a;
                
                private void b(final boolean b) {
                    l.v(new Runnable(this, b) {
                        final boolean a;
                        final s$d$a b;
                        
                        @Override
                        public void run() {
                            this.b.a(this.a);
                        }
                    });
                }
                
                void a(final boolean a) {
                    l.b();
                    final d a2 = this.a;
                    final boolean a3 = a2.a;
                    a2.a = a;
                    if (a3 != a) {
                        a2.b.a(a);
                    }
                }
                
                public void onAvailable(final Network network) {
                    this.b(true);
                }
                
                public void onLost(final Network network) {
                    this.b(false);
                }
            };
            this.c = c;
            this.b = b;
        }
        
        @Override
        public void a() {
            this.c.get().unregisterNetworkCallback(this.d);
        }
        
        @Override
        public boolean b() {
            this.a = (this.c.get().getActiveNetwork() != null);
            try {
                this.c.get().registerDefaultNetworkCallback(this.d);
                return true;
            }
            catch (final RuntimeException ex) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register callback", (Throwable)ex);
                }
                return false;
            }
        }
    }
}
