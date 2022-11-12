// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import java.io.File;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.connection.ConnectionTokenProvider;
import java.util.concurrent.ScheduledExecutorService;
import com.google.firebase.database.android.AndroidPlatform;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.FirebaseApp;
import java.util.List;
import com.google.firebase.database.logging.Logger;

public class Context
{
    protected Logger a;
    protected EventTarget b;
    protected TokenProvider c;
    protected TokenProvider d;
    protected RunLoop e;
    protected String f;
    protected List<String> g;
    protected String h;
    protected Logger.Level i;
    protected boolean j;
    protected long k;
    protected FirebaseApp l;
    private PersistenceManager m;
    private boolean n;
    private boolean o;
    private Platform p;
    
    public Context() {
        this.i = Logger.Level.INFO;
        this.k = 10485760L;
        this.n = false;
        this.o = false;
    }
    
    private void A() {
        synchronized (this) {
            this.p = new AndroidPlatform(this.l);
        }
    }
    
    private static void D(final TokenProvider tokenProvider, final ScheduledExecutorService scheduledExecutorService, final boolean b, final ConnectionTokenProvider.GetTokenCallback getTokenCallback) {
        tokenProvider.a(b, (TokenProvider.GetTokenCompletionListener)new TokenProvider.GetTokenCompletionListener(scheduledExecutorService, getTokenCallback) {
            final ScheduledExecutorService a;
            final ConnectionTokenProvider.GetTokenCallback b;
            
            public static void b(final ConnectionTokenProvider.GetTokenCallback getTokenCallback, final String s) {
                e(getTokenCallback, s);
            }
            
            public static void c(final ConnectionTokenProvider.GetTokenCallback getTokenCallback, final String s) {
                d(getTokenCallback, s);
            }
            
            private static void d(final ConnectionTokenProvider.GetTokenCallback getTokenCallback, final String s) {
                getTokenCallback.g(s);
            }
            
            private static void e(final ConnectionTokenProvider.GetTokenCallback getTokenCallback, final String s) {
                getTokenCallback.a(s);
            }
            
            @Override
            public void a(final String s) {
                this.a.execute(new b(this.b, s));
            }
            
            @Override
            public void g(final String s) {
                this.a.execute(new c(this.b, s));
            }
        });
    }
    
    private void G() {
        this.b.a();
        this.e.a();
    }
    
    private static ConnectionTokenProvider H(final TokenProvider tokenProvider, final ScheduledExecutorService scheduledExecutorService) {
        return new a(tokenProvider, scheduledExecutorService);
    }
    
    public static void a(final TokenProvider tokenProvider, final ScheduledExecutorService scheduledExecutorService, final boolean b, final ConnectionTokenProvider.GetTokenCallback getTokenCallback) {
        D(tokenProvider, scheduledExecutorService, b, getTokenCallback);
    }
    
    private String c(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Firebase/");
        sb.append("5");
        sb.append("/");
        sb.append(FirebaseDatabase.g());
        sb.append("/");
        sb.append(s);
        return sb.toString();
    }
    
    private void d() {
        Preconditions.l(this.d, "You must register an appCheckTokenProvider before initializing Context.");
    }
    
    private void e() {
        Preconditions.l(this.c, "You must register an authTokenProvider before initializing Context.");
    }
    
    private void f() {
        if (this.b == null) {
            this.b = this.u().a(this);
        }
    }
    
    private void g() {
        if (this.a == null) {
            this.a = this.u().b(this, this.i, this.g);
        }
    }
    
    private void h() {
        if (this.e == null) {
            this.e = this.p.g(this);
        }
    }
    
    private void i() {
        if (this.f == null) {
            this.f = "default";
        }
    }
    
    private void j() {
        if (this.h == null) {
            this.h = this.c(this.u().d(this));
        }
    }
    
    private ScheduledExecutorService p() {
        final RunLoop v = this.v();
        if (v instanceof DefaultRunLoop) {
            return ((DefaultRunLoop)v).c();
        }
        throw new RuntimeException("Custom run loops are not supported!");
    }
    
    private Platform u() {
        if (this.p == null) {
            this.A();
        }
        return this.p;
    }
    
    private void z() {
        this.g();
        this.u();
        this.j();
        this.f();
        this.h();
        this.i();
        this.e();
        this.d();
    }
    
    public boolean B() {
        return this.n;
    }
    
    public boolean C() {
        return this.j;
    }
    
    public PersistentConnection E(final HostInfo hostInfo, final PersistentConnection.Delegate delegate) {
        return this.u().f(this, this.n(), hostInfo, delegate);
    }
    
    public void F() {
        if (this.o) {
            this.G();
            this.o = false;
        }
    }
    
    protected void b() {
        if (!this.B()) {
            return;
        }
        throw new DatabaseException("Modifications to DatabaseConfig objects must occur before they are in use");
    }
    
    void k() {
        synchronized (this) {
            if (!this.n) {
                this.n = true;
                this.z();
            }
        }
    }
    
    public TokenProvider l() {
        return this.d;
    }
    
    public TokenProvider m() {
        return this.c;
    }
    
    public ConnectionContext n() {
        return new ConnectionContext(this.r(), H(this.m(), this.p()), H(this.l(), this.p()), this.p(), this.C(), FirebaseDatabase.g(), this.y(), this.l.p().c(), this.w().getAbsolutePath());
    }
    
    public EventTarget o() {
        return this.b;
    }
    
    public LogWrapper q(final String s) {
        return new LogWrapper(this.a, s);
    }
    
    public Logger r() {
        return this.a;
    }
    
    public long s() {
        return this.k;
    }
    
    PersistenceManager t(final String s) {
        final PersistenceManager m = this.m;
        if (m != null) {
            return m;
        }
        if (!this.j) {
            return new NoopPersistenceManager();
        }
        final PersistenceManager c = this.p.c(this, s);
        if (c != null) {
            return c;
        }
        throw new IllegalArgumentException("You have enabled persistence, but persistence is not supported on this platform.");
    }
    
    public RunLoop v() {
        return this.e;
    }
    
    public File w() {
        return this.u().e();
    }
    
    public String x() {
        return this.f;
    }
    
    public String y() {
        return this.h;
    }
}
