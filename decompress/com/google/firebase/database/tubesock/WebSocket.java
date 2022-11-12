// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.tubesock;

import javax.net.ssl.SSLSocket;
import java.util.Iterator;
import java.io.OutputStream;
import java.util.Locale;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.DataInputStream;
import javax.net.ssl.HttpsURLConnection;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import java.io.File;
import java.net.UnknownHostException;
import java.io.IOException;
import com.google.firebase.database.logging.Logger;
import java.util.Map;
import com.google.firebase.database.connection.ConnectionContext;
import java.util.concurrent.Executors;
import com.google.firebase.database.logging.LogWrapper;
import java.net.URI;
import java.net.Socket;
import java.util.concurrent.ThreadFactory;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;

public class WebSocket
{
    private static final AtomicInteger l;
    private static final Charset m;
    private static ThreadFactory n;
    private static ThreadInitializer o;
    private volatile State a;
    private volatile Socket b;
    private WebSocketEventHandler c;
    private final URI d;
    private final String e;
    private final c f;
    private final d g;
    private final b h;
    private final LogWrapper i;
    private final int j;
    private final Thread k;
    
    static {
        l = new AtomicInteger(0);
        m = Charset.forName("UTF-8");
        WebSocket.n = Executors.defaultThreadFactory();
        WebSocket.o = new ThreadInitializer() {
            @Override
            public void a(final Thread thread, final String name) {
                thread.setName(name);
            }
        };
    }
    
    public WebSocket(final ConnectionContext connectionContext, final URI d, final String s, final Map<String, String> map) {
        this.a = State.NONE;
        this.b = null;
        this.c = null;
        final int incrementAndGet = WebSocket.l.incrementAndGet();
        this.j = incrementAndGet;
        this.k = j().newThread(new Runnable(this) {
            final WebSocket a;
            
            @Override
            public void run() {
                WebSocket.a(this.a);
            }
        });
        this.d = d;
        this.e = connectionContext.g();
        final Logger f = connectionContext.f();
        final StringBuilder sb = new StringBuilder();
        sb.append("sk_");
        sb.append(incrementAndGet);
        this.i = new LogWrapper(f, "WebSocket", sb.toString());
        this.h = new b(d, s, map);
        this.f = new c(this);
        this.g = new d(this, "TubeSock", incrementAndGet);
    }
    
    static void a(final WebSocket webSocket) {
        webSocket.n();
    }
    
    private void d() {
        synchronized (this) {
            if (this.a == State.DISCONNECTED) {
                return;
            }
            this.f.h();
            this.g.i();
            if (this.b != null) {
                try {
                    this.b.close();
                }
                catch (final Exception ex) {
                    this.c.b(new WebSocketException("Failed to close", ex));
                }
            }
            this.a = State.DISCONNECTED;
            this.c.c();
        }
    }
    
    private Socket f() {
        final String scheme = this.d.getScheme();
        final String host = this.d.getHost();
        final int port = this.d.getPort();
        if (scheme != null && scheme.equals("ws")) {
            int n;
            if ((n = port) == -1) {
                n = 80;
            }
            try {
                return new Socket(host, n);
            }
            catch (final IOException ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("error while creating socket to ");
                sb.append(this.d);
                throw new WebSocketException(sb.toString(), ex);
            }
            catch (final UnknownHostException ex2) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("unknown host: ");
                sb2.append(host);
                throw new WebSocketException(sb2.toString(), ex2);
            }
        }
        Label_0386: {
            if (scheme == null || !scheme.equals("wss")) {
                break Label_0386;
            }
            int n2;
            if ((n2 = port) == -1) {
                n2 = 443;
            }
            SSLSessionCache sslSessionCache = null;
            try {
                if (this.e != null) {
                    sslSessionCache = new SSLSessionCache(new File(this.e));
                }
            }
            catch (final IOException ex3) {
                this.i.a("Failed to initialize SSL session cache", ex3, new Object[0]);
                sslSessionCache = sslSessionCache;
            }
            try {
                final Socket socket = SSLCertificateSocketFactory.getDefault(60000, sslSessionCache).createSocket(host, n2);
                if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, ((SSLSocket)socket).getSession())) {
                    return socket;
                }
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("Error while verifying secure socket to ");
                sb3.append(this.d);
                throw new WebSocketException(sb3.toString());
            }
            catch (final IOException ex4) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("error while creating secure socket to ");
                sb4.append(this.d);
                throw new WebSocketException(sb4.toString(), ex4);
            }
            catch (final UnknownHostException ex5) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("unknown host: ");
                sb5.append(host);
                throw new WebSocketException(sb5.toString(), ex5);
            }
        }
        final StringBuilder sb6 = new StringBuilder();
        sb6.append("unsupported protocol: ");
        sb6.append(scheme);
        throw new WebSocketException(sb6.toString());
    }
    
    static ThreadInitializer i() {
        return WebSocket.o;
    }
    
    static ThreadFactory j() {
        return WebSocket.n;
    }
    
    private void n() {
        try {
            final Socket f = this.f();
            synchronized (this) {
                this.b = f;
                if (this.a == State.DISCONNECTED) {
                    try {
                        this.b.close();
                        this.b = null;
                        monitorexit(this);
                        this.c();
                        return;
                    }
                    catch (final IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                monitorexit(this);
                final DataInputStream dataInputStream = new DataInputStream(f.getInputStream());
                final OutputStream outputStream = f.getOutputStream();
                outputStream.write(this.h.c());
                byte[] array = new byte[1000];
                final ArrayList<String> list = new ArrayList<String>();
                int i = 0;
                int n = 0;
                while (i == 0) {
                    final int read = dataInputStream.read();
                    if (read == -1) {
                        throw new WebSocketException("Connection closed before handshake was complete");
                    }
                    array[n] = (byte)read;
                    ++n;
                    if (array[n - 1] == 10 && array[n - 2] == 13) {
                        final String s = new String(array, WebSocket.m);
                        if (s.trim().equals("")) {
                            i = 1;
                        }
                        else {
                            list.add(s.trim());
                        }
                        array = new byte[1000];
                        n = 0;
                    }
                    else {
                        if (n != 1000) {
                            continue;
                        }
                        final String s2 = new String(array, WebSocket.m);
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Unexpected long line in handshake: ");
                        sb.append(s2);
                        throw new WebSocketException(sb.toString());
                    }
                }
                this.h.f(list.get(0));
                list.remove(0);
                final HashMap<String, String> hashMap = new HashMap<String, String>();
                final Iterator<String> iterator = list.iterator();
                while (iterator.hasNext()) {
                    final String[] split = iterator.next().split(": ", 2);
                    final String s3 = split[0];
                    final Locale us = Locale.US;
                    hashMap.put(s3.toLowerCase(us), split[1].toLowerCase(us));
                }
                this.h.e(hashMap);
                this.g.h(outputStream);
                this.f.g(dataInputStream);
                this.a = State.CONNECTED;
                this.g.d().start();
                this.c.d();
                this.f.f();
            }
        }
        catch (final WebSocketException ex2) {
            final WebSocketException ex3 = ex2;
            final WebSocket webSocket = this;
            final WebSocketEventHandler webSocketEventHandler = webSocket.c;
            final WebSocketException ex4 = ex3;
            webSocketEventHandler.b(ex4);
        }
        finally {
            final WebSocketEventHandler c = this.c;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("error while connecting: ");
            final Throwable t;
            sb2.append(t.getMessage());
            c.b(new WebSocketException(sb2.toString(), t));
            return;
        }
        try {
            final WebSocketException ex2;
            final WebSocketException ex3 = ex2;
            final WebSocket webSocket = this;
            final WebSocketEventHandler webSocketEventHandler = webSocket.c;
            final WebSocketException ex4 = ex3;
            webSocketEventHandler.b(ex4);
        }
        finally {
            this.c();
        }
    }
    
    private void o(final byte b, final byte[] array) {
        synchronized (this) {
            if (this.a != State.CONNECTED) {
                this.c.b(new WebSocketException("error while sending data: not connected"));
            }
            else {
                try {
                    this.g.g(b, true, array);
                }
                catch (final IOException ex) {
                    this.c.b(new WebSocketException("Failed to send frame", ex));
                    this.c();
                }
            }
        }
    }
    
    private void q() {
        try {
            this.a = State.DISCONNECTING;
            this.g.i();
            this.g.g((byte)8, true, new byte[0]);
        }
        catch (final IOException ex) {
            this.c.b(new WebSocketException("Failed to send close frame", ex));
        }
    }
    
    public void b() throws InterruptedException {
        if (this.g.d().getState() != Thread.State.NEW) {
            this.g.d().join();
        }
        this.h().join();
    }
    
    public void c() {
        synchronized (this) {
            final int n = WebSocket$c.a[this.a.ordinal()];
            if (n == 1) {
                this.a = State.DISCONNECTED;
                return;
            }
            if (n == 2) {
                this.d();
                return;
            }
            if (n == 3) {
                this.q();
                return;
            }
            if (n == 4) {
                return;
            }
            if (n != 5) {
                return;
            }
        }
    }
    
    public void e() {
        synchronized (this) {
            if (this.a != State.NONE) {
                this.c.b(new WebSocketException("connect() already called"));
                this.c();
                return;
            }
            final ThreadInitializer i = i();
            final Thread h = this.h();
            final StringBuilder sb = new StringBuilder();
            sb.append("TubeSockReader-");
            sb.append(this.j);
            i.a(h, sb.toString());
            this.a = State.CONNECTING;
            this.h().start();
        }
    }
    
    WebSocketEventHandler g() {
        return this.c;
    }
    
    Thread h() {
        return this.k;
    }
    
    void k(final WebSocketException ex) {
        this.c.b(ex);
        if (this.a == State.CONNECTED) {
            this.c();
        }
        this.d();
    }
    
    void l() {
        this.d();
    }
    
    void m(final byte[] array) {
        synchronized (this) {
            this.o((byte)10, array);
        }
    }
    
    public void p(final String s) {
        synchronized (this) {
            this.o((byte)1, s.getBytes(WebSocket.m));
        }
    }
    
    public void r(final WebSocketEventHandler c) {
        this.c = c;
    }
    
    private enum State
    {
        private static final State[] $VALUES;
        
        CONNECTED, 
        CONNECTING, 
        DISCONNECTED, 
        DISCONNECTING, 
        NONE;
    }
}
