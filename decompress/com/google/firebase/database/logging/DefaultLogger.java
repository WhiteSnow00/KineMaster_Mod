// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.logging;

import java.util.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DefaultLogger implements Logger
{
    private final Set<String> a;
    private final Level b;
    
    public DefaultLogger(final Level b, final List<String> list) {
        if (list != null) {
            this.a = new HashSet<String>(list);
        }
        else {
            this.a = null;
        }
        this.b = b;
    }
    
    @Override
    public void a(final Level level, final String s, String c, final long n) {
        if (this.g(level, s)) {
            c = this.c(level, s, c, n);
            final int n2 = DefaultLogger$a.a[level.ordinal()];
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            throw new RuntimeException("Should not reach here!");
                        }
                        this.d(s, c);
                    }
                    else {
                        this.f(s, c);
                    }
                }
                else {
                    this.h(s, c);
                }
            }
            else {
                this.e(s, c);
            }
        }
    }
    
    @Override
    public Level b() {
        return this.b;
    }
    
    protected String c(final Level level, final String s, final String s2, final long n) {
        final Date date = new Date(n);
        final StringBuilder sb = new StringBuilder();
        sb.append(date.toString());
        sb.append(" [");
        sb.append(level);
        sb.append("] ");
        sb.append(s);
        sb.append(": ");
        sb.append(s2);
        return sb.toString();
    }
    
    protected void d(final String s, final String s2) {
        System.out.println(s2);
    }
    
    protected void e(final String s, final String s2) {
        System.err.println(s2);
    }
    
    protected void f(final String s, final String s2) {
        System.out.println(s2);
    }
    
    protected boolean g(final Level level, final String s) {
        return level.ordinal() >= this.b.ordinal() && (this.a == null || level.ordinal() > Level.DEBUG.ordinal() || this.a.contains(s));
    }
    
    protected void h(final String s, final String s2) {
        System.out.println(s2);
    }
}
