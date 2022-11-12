// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport;

import java.util.Objects;

final class a<T> extends Event<T>
{
    private final Integer a;
    private final T b;
    private final Priority c;
    
    a(final Integer a, final T b, final Priority c) {
        this.a = a;
        Objects.requireNonNull(b, "Null payload");
        this.b = b;
        Objects.requireNonNull(c, "Null priority");
        this.c = c;
    }
    
    @Override
    public Integer a() {
        return this.a;
    }
    
    @Override
    public T b() {
        return this.b;
    }
    
    @Override
    public Priority c() {
        return this.c;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof Event) {
            final Event event = (Event)o;
            final Integer a = this.a;
            if (a == null) {
                if (event.a() != null) {
                    return false;
                }
            }
            else if (!a.equals(event.a())) {
                return false;
            }
            if (this.b.equals(event.b()) && this.c.equals(event.c())) {
                return b;
            }
            b = false;
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        final Integer a = this.a;
        int hashCode;
        if (a == null) {
            hashCode = 0;
        }
        else {
            hashCode = a.hashCode();
        }
        return ((hashCode ^ 0xF4243) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Event{code=");
        sb.append(this.a);
        sb.append(", payload=");
        sb.append(this.b);
        sb.append(", priority=");
        sb.append(this.c);
        sb.append("}");
        return sb.toString();
    }
}
