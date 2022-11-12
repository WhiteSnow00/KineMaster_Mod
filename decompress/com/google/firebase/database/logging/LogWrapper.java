// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.logging;

import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;

public class LogWrapper
{
    private final Logger a;
    private final String b;
    private final String c;
    
    public LogWrapper(final Logger logger, final String s) {
        this(logger, s, null);
    }
    
    public LogWrapper(final Logger a, final String b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private static String d(final Throwable t) {
        final StringWriter stringWriter = new StringWriter();
        t.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
    
    private long g() {
        return System.currentTimeMillis();
    }
    
    private String h(final String s, final Object... array) {
        String s2 = s;
        if (array.length > 0) {
            s2 = String.format(s, array);
        }
        if (this.c != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.c);
            sb.append(" - ");
            sb.append(s2);
            s2 = sb.toString();
        }
        return s2;
    }
    
    public void a(String s, final Throwable t, final Object... array) {
        if (this.f()) {
            final String s2 = s = this.h(s, array);
            if (t != null) {
                final StringBuilder sb = new StringBuilder();
                sb.append(s2);
                sb.append("\n");
                sb.append(d(t));
                s = sb.toString();
            }
            this.a.a(Logger.Level.DEBUG, this.b, s, this.g());
        }
    }
    
    public void b(final String s, final Object... array) {
        this.a(s, null, array);
    }
    
    public void c(String string, final Throwable t) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.h(string, new Object[0]));
        sb.append("\n");
        sb.append(d(t));
        string = sb.toString();
        this.a.a(Logger.Level.ERROR, this.b, string, this.g());
    }
    
    public void e(final String s) {
        this.a.a(Logger.Level.INFO, this.b, this.h(s, new Object[0]), this.g());
    }
    
    public boolean f() {
        return this.a.b().ordinal() <= Logger.Level.DEBUG.ordinal();
    }
    
    public void i(final String s) {
        this.j(s, null);
    }
    
    public void j(String s, final Throwable t) {
        final String s2 = s = this.h(s, new Object[0]);
        if (t != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s2);
            sb.append("\n");
            sb.append(d(t));
            s = sb.toString();
        }
        this.a.a(Logger.Level.WARN, this.b, s, this.g());
    }
}
