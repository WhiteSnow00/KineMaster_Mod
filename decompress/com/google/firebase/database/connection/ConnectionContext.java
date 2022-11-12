// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.connection;

import com.google.firebase.database.logging.Logger;
import java.util.concurrent.ScheduledExecutorService;

public class ConnectionContext
{
    private final ScheduledExecutorService a;
    private final ConnectionTokenProvider b;
    private final ConnectionTokenProvider c;
    private final Logger d;
    private final boolean e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    
    public ConnectionContext(final Logger d, final ConnectionTokenProvider b, final ConnectionTokenProvider c, final ScheduledExecutorService a, final boolean e, final String f, final String g, final String h, final String i) {
        this.d = d;
        this.b = b;
        this.c = c;
        this.a = a;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    public ConnectionTokenProvider a() {
        return this.c;
    }
    
    public String b() {
        return this.h;
    }
    
    public ConnectionTokenProvider c() {
        return this.b;
    }
    
    public String d() {
        return this.f;
    }
    
    public ScheduledExecutorService e() {
        return this.a;
    }
    
    public Logger f() {
        return this.d;
    }
    
    public String g() {
        return this.i;
    }
    
    public String h() {
        return this.g;
    }
    
    public boolean i() {
        return this.e;
    }
}
