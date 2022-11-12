// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.connection;

import com.google.firebase.database.tubesock.WebSocketMessage;
import java.io.EOFException;
import com.google.firebase.database.tubesock.WebSocketException;
import com.google.firebase.database.tubesock.WebSocketEventHandler;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.net.URI;
import com.google.firebase.database.tubesock.WebSocket;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import com.google.firebase.database.util.JsonMapper;
import com.google.firebase.database.logging.Logger;
import com.google.firebase.database.logging.LogWrapper;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import com.google.firebase.database.connection.util.StringListReader;

class WebsocketConnection
{
    private static long l;
    private c a;
    private boolean b;
    private boolean c;
    private long d;
    private StringListReader e;
    private Delegate f;
    private ScheduledFuture<?> g;
    private ScheduledFuture<?> h;
    private final ConnectionContext i;
    private final ScheduledExecutorService j;
    private final LogWrapper k;
    
    public WebsocketConnection(final ConnectionContext i, final HostInfo hostInfo, final String s, final String s2, final Delegate f, final String s3) {
        this.b = false;
        this.c = false;
        this.d = 0L;
        this.i = i;
        this.j = i.e();
        this.f = f;
        final long l = WebsocketConnection.l;
        WebsocketConnection.l = 1L + l;
        final Logger f2 = i.f();
        final StringBuilder sb = new StringBuilder();
        sb.append("ws_");
        sb.append(l);
        this.k = new LogWrapper(f2, "WebSocket", sb.toString());
        this.a = this.m(hostInfo, s, s2, s3);
    }
    
    static ScheduledFuture a(final WebsocketConnection websocketConnection) {
        return websocketConnection.h;
    }
    
    static boolean b(final WebsocketConnection websocketConnection, final boolean b) {
        return websocketConnection.b = b;
    }
    
    static LogWrapper c(final WebsocketConnection websocketConnection) {
        return websocketConnection.k;
    }
    
    static void d(final WebsocketConnection websocketConnection) {
        websocketConnection.u();
    }
    
    static ScheduledExecutorService e(final WebsocketConnection websocketConnection) {
        return websocketConnection.j;
    }
    
    static void f(final WebsocketConnection websocketConnection, final String s) {
        websocketConnection.o(s);
    }
    
    static void g(final WebsocketConnection websocketConnection) {
        websocketConnection.s();
    }
    
    static void h(final WebsocketConnection websocketConnection) {
        websocketConnection.l();
    }
    
    static c i(final WebsocketConnection websocketConnection) {
        return websocketConnection.a;
    }
    
    private void j(final String s) {
        this.e.a(s);
        final long d = this.d - 1L;
        this.d = d;
        if (d == 0L) {
            try {
                this.e.i();
                final Map<String, Object> a = JsonMapper.a(this.e.toString());
                this.e = null;
                if (this.k.f()) {
                    final LogWrapper k = this.k;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("handleIncomingFrame complete frame: ");
                    sb.append(a);
                    k.b(sb.toString(), new Object[0]);
                }
                this.f.b(a);
            }
            catch (final ClassCastException ex) {
                final LogWrapper i = this.k;
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Error parsing frame (cast error): ");
                sb2.append(this.e.toString());
                i.c(sb2.toString(), ex);
                this.k();
                this.w();
            }
            catch (final IOException ex2) {
                final LogWrapper j = this.k;
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Error parsing frame: ");
                sb3.append(this.e.toString());
                j.c(sb3.toString(), ex2);
                this.k();
                this.w();
            }
        }
    }
    
    private void l() {
        if (!this.b && !this.c) {
            if (this.k.f()) {
                this.k.b("timed out on connect", new Object[0]);
            }
            this.a.close();
        }
    }
    
    private c m(final HostInfo hostInfo, String b, final String s, final String s2) {
        if (b == null) {
            b = hostInfo.b();
        }
        final URI a = HostInfo.a(b, hostInfo.d(), hostInfo.c(), s2);
        final HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", this.i.h());
        hashMap.put("X-Firebase-GMPID", this.i.b());
        hashMap.put("X-Firebase-AppCheck", s);
        return (c)new d(new WebSocket(this.i, a, null, hashMap), null);
    }
    
    private String n(final String s) {
        while (true) {
            if (s.length() > 6) {
                break Label_0025;
            }
            try {
                final int int1 = Integer.parseInt(s);
                if (int1 > 0) {
                    this.p(int1);
                }
                return null;
                this.p(1);
                return s;
            }
            catch (final NumberFormatException ex) {
                continue;
            }
            break;
        }
    }
    
    private void o(String n) {
        if (!this.c) {
            this.u();
            if (this.q()) {
                this.j(n);
            }
            else {
                n = this.n(n);
                if (n != null) {
                    this.j(n);
                }
            }
        }
    }
    
    private void p(final int n) {
        this.d = n;
        this.e = new StringListReader();
        if (this.k.f()) {
            final LogWrapper k = this.k;
            final StringBuilder sb = new StringBuilder();
            sb.append("HandleNewFrameCount: ");
            sb.append(this.d);
            k.b(sb.toString(), new Object[0]);
        }
    }
    
    private boolean q() {
        return this.e != null;
    }
    
    private Runnable r() {
        return new Runnable(this) {
            final WebsocketConnection a;
            
            @Override
            public void run() {
                if (WebsocketConnection.i(this.a) != null) {
                    WebsocketConnection.i(this.a).a("0");
                    WebsocketConnection.d(this.a);
                }
            }
        };
    }
    
    private void s() {
        if (!this.c) {
            if (this.k.f()) {
                this.k.b("closing itself", new Object[0]);
            }
            this.w();
        }
        this.a = null;
        final ScheduledFuture<?> g = this.g;
        if (g != null) {
            g.cancel(false);
        }
    }
    
    private void u() {
        if (!this.c) {
            final ScheduledFuture<?> g = this.g;
            if (g != null) {
                g.cancel(false);
                if (this.k.f()) {
                    final LogWrapper k = this.k;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Reset keepAlive. Remaining: ");
                    sb.append(this.g.getDelay(TimeUnit.MILLISECONDS));
                    k.b(sb.toString(), new Object[0]);
                }
            }
            else if (this.k.f()) {
                this.k.b("Reset keepAlive", new Object[0]);
            }
            this.g = this.j.schedule(this.r(), 45000L, TimeUnit.MILLISECONDS);
        }
    }
    
    private void w() {
        this.c = true;
        this.f.a(this.b);
    }
    
    private static String[] x(final String s, final int n) {
        final int length = s.length();
        int i = 0;
        if (length <= n) {
            return new String[] { s };
        }
        final ArrayList list = new ArrayList();
        while (i < s.length()) {
            final int n2 = i + n;
            list.add(s.substring(i, Math.min(n2, s.length())));
            i = n2;
        }
        return list.toArray(new String[list.size()]);
    }
    
    public void k() {
        if (this.k.f()) {
            this.k.b("websocket is being closed", new Object[0]);
        }
        this.c = true;
        this.a.close();
        final ScheduledFuture<?> h = this.h;
        if (h != null) {
            h.cancel(true);
        }
        final ScheduledFuture<?> g = this.g;
        if (g != null) {
            g.cancel(true);
        }
    }
    
    public void t() {
        this.a.connect();
        this.h = this.j.schedule(new Runnable(this) {
            final WebsocketConnection a;
            
            @Override
            public void run() {
                WebsocketConnection.h(this.a);
            }
        }, 30000L, TimeUnit.MILLISECONDS);
    }
    
    public void v(final Map<String, Object> map) {
        this.u();
        try {
            final String[] x = x(JsonMapper.c(map), 16384);
            if (x.length > 1) {
                final c a = this.a;
                final StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(x.length);
                a.a(sb.toString());
            }
            for (int i = 0; i < x.length; ++i) {
                this.a.a(x[i]);
            }
        }
        catch (final IOException ex) {
            final LogWrapper k = this.k;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to serialize message: ");
            sb2.append(map.toString());
            k.c(sb2.toString(), ex);
            this.w();
        }
    }
    
    public void y() {
    }
    
    public interface Delegate
    {
        void a(final boolean p0);
        
        void b(final Map<String, Object> p0);
    }
    
    private interface c
    {
        void a(final String p0);
        
        void close();
        
        void connect();
    }
    
    private class d implements c, WebSocketEventHandler
    {
        private WebSocket a;
        final WebsocketConnection b;
        
        private d(final WebsocketConnection b, final WebSocket a) {
            this.b = b;
            (this.a = a).r(this);
        }
        
        d(final WebsocketConnection websocketConnection, final WebSocket webSocket, final WebsocketConnection$a runnable) {
            this(websocketConnection, webSocket);
        }
        
        private void f() {
            this.a.c();
            try {
                this.a.b();
            }
            catch (final InterruptedException ex) {
                WebsocketConnection.c(this.b).c("Interrupted while shutting down websocket threads", ex);
            }
        }
        
        @Override
        public void a(final String s) {
            this.a.p(s);
        }
        
        @Override
        public void b(final WebSocketException ex) {
            WebsocketConnection.e(this.b).execute(new Runnable(this, ex) {
                final WebSocketException a;
                final d b;
                
                @Override
                public void run() {
                    if (this.a.getCause() != null && this.a.getCause() instanceof EOFException) {
                        WebsocketConnection.c(this.b.b).b("WebSocket reached EOF.", new Object[0]);
                    }
                    else {
                        WebsocketConnection.c(this.b.b).a("WebSocket error.", this.a, new Object[0]);
                    }
                    WebsocketConnection.g(this.b.b);
                }
            });
        }
        
        @Override
        public void c() {
            WebsocketConnection.e(this.b).execute(new Runnable(this) {
                final d a;
                
                @Override
                public void run() {
                    if (WebsocketConnection.c(this.a.b).f()) {
                        WebsocketConnection.c(this.a.b).b("closed", new Object[0]);
                    }
                    WebsocketConnection.g(this.a.b);
                }
            });
        }
        
        @Override
        public void close() {
            this.a.c();
        }
        
        @Override
        public void connect() {
            try {
                this.a.e();
            }
            catch (final WebSocketException ex) {
                if (WebsocketConnection.c(this.b).f()) {
                    WebsocketConnection.c(this.b).a("Error connecting", ex, new Object[0]);
                }
                this.f();
            }
        }
        
        @Override
        public void d() {
            WebsocketConnection.e(this.b).execute(new Runnable(this) {
                final d a;
                
                @Override
                public void run() {
                    WebsocketConnection.a(this.a.b).cancel(false);
                    WebsocketConnection.b(this.a.b, true);
                    if (WebsocketConnection.c(this.a.b).f()) {
                        WebsocketConnection.c(this.a.b).b("websocket opened", new Object[0]);
                    }
                    WebsocketConnection.d(this.a.b);
                }
            });
        }
        
        @Override
        public void e(final WebSocketMessage webSocketMessage) {
            final String a = webSocketMessage.a();
            if (WebsocketConnection.c(this.b).f()) {
                final LogWrapper c = WebsocketConnection.c(this.b);
                final StringBuilder sb = new StringBuilder();
                sb.append("ws message: ");
                sb.append(a);
                c.b(sb.toString(), new Object[0]);
            }
            WebsocketConnection.e(this.b).execute(new Runnable(this, a) {
                final String a;
                final d b;
                
                @Override
                public void run() {
                    WebsocketConnection.f(this.b.b, this.a);
                }
            });
        }
    }
}
