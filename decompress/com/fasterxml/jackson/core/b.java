// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.io.a;

public abstract class b
{
    protected int a;
    protected int b;
    
    protected b() {
    }
    
    public final int a() {
        int b;
        if ((b = this.b) < 0) {
            b = 0;
        }
        return b;
    }
    
    public abstract String b();
    
    public final int c() {
        return this.b + 1;
    }
    
    public final boolean d() {
        final int a = this.a;
        boolean b = true;
        if (a != 1) {
            b = false;
        }
        return b;
    }
    
    public final boolean e() {
        return this.a == 2;
    }
    
    public final boolean f() {
        return this.a == 0;
    }
    
    public String g() {
        final int a = this.a;
        if (a == 0) {
            return "root";
        }
        if (a == 1) {
            return "Array";
        }
        if (a != 2) {
            return "?";
        }
        return "Object";
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(64);
        final int a = this.a;
        if (a != 0) {
            if (a != 1) {
                sb.append('{');
                final String b = this.b();
                if (b != null) {
                    sb.append('\"');
                    com.fasterxml.jackson.core.io.a.a(sb, b);
                    sb.append('\"');
                }
                else {
                    sb.append('?');
                }
                sb.append('}');
            }
            else {
                sb.append('[');
                sb.append(this.a());
                sb.append(']');
            }
        }
        else {
            sb.append("/");
        }
        return sb.toString();
    }
}
