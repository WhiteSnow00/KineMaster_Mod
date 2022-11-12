// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie;

import java.util.Arrays;

public final class l<V>
{
    private final V a;
    private final Throwable b;
    
    public l(final V a) {
        this.a = a;
        this.b = null;
    }
    
    public l(final Throwable b) {
        this.b = b;
        this.a = null;
    }
    
    public Throwable a() {
        return this.b;
    }
    
    public V b() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof l)) {
            return false;
        }
        final l l = (l)o;
        return (this.b() != null && this.b().equals(l.b())) || (this.a() != null && l.a() != null && this.a().toString().equals(this.a().toString()));
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[] { this.b(), this.a() });
    }
}
