// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import java.util.HashMap;
import c2.b;
import java.util.Map;

final class p
{
    private final Map<b, j<?>> a;
    private final Map<b, j<?>> b;
    
    p() {
        this.a = new HashMap<b, j<?>>();
        this.b = new HashMap<b, j<?>>();
    }
    
    private Map<b, j<?>> b(final boolean b) {
        Map<b, j<?>> map;
        if (b) {
            map = this.b;
        }
        else {
            map = this.a;
        }
        return map;
    }
    
    j<?> a(final b b, final boolean b2) {
        return this.b(b2).get(b);
    }
    
    void c(final b b, final j<?> j) {
        this.b(j.p()).put(b, j);
    }
    
    void d(final b b, final j<?> j) {
        final Map<b, j<?>> b2 = this.b(j.p());
        if (j.equals(b2.get(b))) {
            b2.remove(b);
        }
    }
}
