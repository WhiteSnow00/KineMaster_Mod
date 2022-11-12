// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.connection;

import java.util.HashMap;
import java.util.Map;
import com.google.firebase.database.logging.Logger;
import com.google.firebase.database.logging.LogWrapper;

class Connection implements WebsocketConnection.Delegate
{
    private static long f;
    private HostInfo a;
    private WebsocketConnection b;
    private Delegate c;
    private State d;
    private final LogWrapper e;
    
    public Connection(final ConnectionContext connectionContext, final HostInfo a, final String s, final Delegate c, final String s2, final String s3) {
        final long f = Connection.f;
        Connection.f = 1L + f;
        this.a = a;
        this.c = c;
        final Logger f2 = connectionContext.f();
        final StringBuilder sb = new StringBuilder();
        sb.append("conn_");
        sb.append(f);
        this.e = new LogWrapper(f2, "Connection", sb.toString());
        this.d = State.REALTIME_CONNECTING;
        this.b = new WebsocketConnection(connectionContext, a, s, s3, (WebsocketConnection.Delegate)this, s2);
    }
    
    private void e(final long n, final String s) {
        if (this.e.f()) {
            this.e.b("realtime connection established", new Object[0]);
        }
        this.d = State.REALTIME_CONNECTED;
        this.c.k(n, s);
    }
    
    private void f(final String s) {
        if (this.e.f()) {
            this.e.b("Connection shutdown command received. Shutting down...", new Object[0]);
        }
        this.c.b(s);
        this.c();
    }
    
    private void g(final Map<String, Object> map) {
        if (this.e.f()) {
            final LogWrapper e = this.e;
            final StringBuilder sb = new StringBuilder();
            sb.append("Got control message: ");
            sb.append(map.toString());
            e.b(sb.toString(), new Object[0]);
        }
        try {
            final String s = map.get("t");
            if (s != null) {
                if (s.equals("s")) {
                    this.f(map.get("d"));
                }
                else if (s.equals("r")) {
                    this.j(map.get("d"));
                }
                else if (s.equals("h")) {
                    this.i((Map<String, Object>)map.get("d"));
                }
                else if (this.e.f()) {
                    final LogWrapper e2 = this.e;
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Ignoring unknown control message: ");
                    sb2.append(s);
                    e2.b(sb2.toString(), new Object[0]);
                }
            }
            else {
                if (this.e.f()) {
                    final LogWrapper e3 = this.e;
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Got invalid control message: ");
                    sb3.append(map.toString());
                    e3.b(sb3.toString(), new Object[0]);
                }
                this.c();
            }
        }
        catch (final ClassCastException ex) {
            if (this.e.f()) {
                final LogWrapper e4 = this.e;
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("Failed to parse control message: ");
                sb4.append(ex.toString());
                e4.b(sb4.toString(), new Object[0]);
            }
            this.c();
        }
    }
    
    private void h(final Map<String, Object> map) {
        if (this.e.f()) {
            final LogWrapper e = this.e;
            final StringBuilder sb = new StringBuilder();
            sb.append("received data message: ");
            sb.append(map.toString());
            e.b(sb.toString(), new Object[0]);
        }
        this.c.e(map);
    }
    
    private void i(final Map<String, Object> map) {
        final long longValue = map.get("ts");
        this.c.h((String)map.get("h"));
        final String s = (String)map.get("s");
        if (this.d == State.REALTIME_CONNECTING) {
            this.b.y();
            this.e(longValue, s);
        }
    }
    
    private void j(final String s) {
        if (this.e.f()) {
            final LogWrapper e = this.e;
            final StringBuilder sb = new StringBuilder();
            sb.append("Got a reset; killing connection to ");
            sb.append(this.a.b());
            sb.append("; Updating internalHost to ");
            sb.append(s);
            e.b(sb.toString(), new Object[0]);
        }
        this.c.h(s);
        this.d(DisconnectReason.SERVER_RESET);
    }
    
    private void l(final Map<String, Object> map, final boolean b) {
        if (this.d != State.REALTIME_CONNECTED) {
            this.e.b("Tried to send on an unconnected connection", new Object[0]);
        }
        else {
            if (b) {
                this.e.b("Sending data (contents hidden)", new Object[0]);
            }
            else {
                this.e.b("Sending data: %s", map);
            }
            this.b.v(map);
        }
    }
    
    @Override
    public void a(final boolean b) {
        this.b = null;
        if (!b && this.d == State.REALTIME_CONNECTING) {
            if (this.e.f()) {
                this.e.b("Realtime connection failed", new Object[0]);
            }
        }
        else if (this.e.f()) {
            this.e.b("Realtime connection lost", new Object[0]);
        }
        this.c();
    }
    
    @Override
    public void b(final Map<String, Object> map) {
        try {
            final String s = map.get("t");
            if (s != null) {
                if (s.equals("d")) {
                    this.h((Map<String, Object>)map.get("d"));
                }
                else if (s.equals("c")) {
                    this.g((Map<String, Object>)map.get("d"));
                }
                else if (this.e.f()) {
                    final LogWrapper e = this.e;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Ignoring unknown server message type: ");
                    sb.append(s);
                    e.b(sb.toString(), new Object[0]);
                }
            }
            else {
                if (this.e.f()) {
                    final LogWrapper e2 = this.e;
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to parse server message: missing message type:");
                    sb2.append(map.toString());
                    e2.b(sb2.toString(), new Object[0]);
                }
                this.c();
            }
        }
        catch (final ClassCastException ex) {
            if (this.e.f()) {
                final LogWrapper e3 = this.e;
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to parse server message: ");
                sb3.append(ex.toString());
                e3.b(sb3.toString(), new Object[0]);
            }
            this.c();
        }
    }
    
    public void c() {
        this.d(DisconnectReason.OTHER);
    }
    
    public void d(final DisconnectReason disconnectReason) {
        final State d = this.d;
        final State realtime_DISCONNECTED = State.REALTIME_DISCONNECTED;
        if (d != realtime_DISCONNECTED) {
            if (this.e.f()) {
                this.e.b("closing realtime connection", new Object[0]);
            }
            this.d = realtime_DISCONNECTED;
            final WebsocketConnection b = this.b;
            if (b != null) {
                b.k();
                this.b = null;
            }
            this.c.n(disconnectReason);
        }
    }
    
    public void k() {
        if (this.e.f()) {
            this.e.b("Opening a connection", new Object[0]);
        }
        this.b.t();
    }
    
    public void m(final Map<String, Object> map, final boolean b) {
        final HashMap hashMap = new HashMap();
        hashMap.put("t", "d");
        hashMap.put("d", map);
        this.l(hashMap, b);
    }
    
    public interface Delegate
    {
        void b(final String p0);
        
        void e(final Map<String, Object> p0);
        
        void h(final String p0);
        
        void k(final long p0, final String p1);
        
        void n(final DisconnectReason p0);
    }
    
    public enum DisconnectReason
    {
        private static final DisconnectReason[] $VALUES;
        
        OTHER, 
        SERVER_RESET;
    }
    
    private enum State
    {
        private static final State[] $VALUES;
        
        REALTIME_CONNECTED, 
        REALTIME_CONNECTING, 
        REALTIME_DISCONNECTED;
    }
}
