// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.backends;

import java.util.Objects;
import com.google.android.datatransport.runtime.time.Clock;
import android.content.Context;

final class c extends CreationContext
{
    private final Context a;
    private final Clock b;
    private final Clock c;
    private final String d;
    
    c(final Context a, final Clock b, final Clock c, final String d) {
        Objects.requireNonNull(a, "Null applicationContext");
        this.a = a;
        Objects.requireNonNull(b, "Null wallClock");
        this.b = b;
        Objects.requireNonNull(c, "Null monotonicClock");
        this.c = c;
        Objects.requireNonNull(d, "Null backendName");
        this.d = d;
    }
    
    @Override
    public Context b() {
        return this.a;
    }
    
    @Override
    public String c() {
        return this.d;
    }
    
    @Override
    public Clock d() {
        return this.c;
    }
    
    @Override
    public Clock e() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o instanceof CreationContext) {
            final CreationContext creationContext = (CreationContext)o;
            if (!this.a.equals(creationContext.b()) || !this.b.equals(creationContext.e()) || !this.c.equals(creationContext.d()) || !this.d.equals(creationContext.c())) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return (((this.a.hashCode() ^ 0xF4243) * 1000003 ^ this.b.hashCode()) * 1000003 ^ this.c.hashCode()) * 1000003 ^ this.d.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CreationContext{applicationContext=");
        sb.append(this.a);
        sb.append(", wallClock=");
        sb.append(this.b);
        sb.append(", monotonicClock=");
        sb.append(this.c);
        sb.append(", backendName=");
        sb.append(this.d);
        sb.append("}");
        return sb.toString();
    }
}
