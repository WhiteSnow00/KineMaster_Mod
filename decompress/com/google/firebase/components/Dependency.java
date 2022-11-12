// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.components;

public final class Dependency
{
    private final Class<?> a;
    private final int b;
    private final int c;
    
    private Dependency(final Class<?> clazz, final int b, final int c) {
        this.a = Preconditions.c(clazz, "Null dependency anInterface.");
        this.b = b;
        this.c = c;
    }
    
    public static Dependency a(final Class<?> clazz) {
        return new Dependency(clazz, 0, 2);
    }
    
    private static String b(final int n) {
        if (n == 0) {
            return "direct";
        }
        if (n == 1) {
            return "provider";
        }
        if (n == 2) {
            return "deferred";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unsupported injection: ");
        sb.append(n);
        throw new AssertionError((Object)sb.toString());
    }
    
    @Deprecated
    public static Dependency h(final Class<?> clazz) {
        return new Dependency(clazz, 0, 0);
    }
    
    public static Dependency i(final Class<?> clazz) {
        return new Dependency(clazz, 0, 1);
    }
    
    public static Dependency j(final Class<?> clazz) {
        return new Dependency(clazz, 1, 0);
    }
    
    public static Dependency k(final Class<?> clazz) {
        return new Dependency(clazz, 1, 1);
    }
    
    public static Dependency l(final Class<?> clazz) {
        return new Dependency(clazz, 2, 0);
    }
    
    public Class<?> c() {
        return this.a;
    }
    
    public boolean d() {
        return this.c == 2;
    }
    
    public boolean e() {
        return this.c == 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean b = o instanceof Dependency;
        boolean b3;
        final boolean b2 = b3 = false;
        if (b) {
            final Dependency dependency = (Dependency)o;
            b3 = b2;
            if (this.a == dependency.a) {
                b3 = b2;
                if (this.b == dependency.b) {
                    b3 = b2;
                    if (this.c == dependency.c) {
                        b3 = true;
                    }
                }
            }
        }
        return b3;
    }
    
    public boolean f() {
        final int b = this.b;
        boolean b2 = true;
        if (b != 1) {
            b2 = false;
        }
        return b2;
    }
    
    public boolean g() {
        return this.b == 2;
    }
    
    @Override
    public int hashCode() {
        return ((this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b) * 1000003 ^ this.c;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.a);
        sb.append(", type=");
        final int b = this.b;
        String s;
        if (b == 1) {
            s = "required";
        }
        else if (b == 0) {
            s = "optional";
        }
        else {
            s = "set";
        }
        sb.append(s);
        sb.append(", injection=");
        sb.append(b(this.c));
        sb.append("}");
        return sb.toString();
    }
}
