// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

public final class h
{
    private String a;
    
    h(final r0 r0) {
    }
    
    public static a b() {
        return new a(null);
    }
    
    static /* bridge */ void c(final h h, final String a) {
        h.a = a;
    }
    
    public String a() {
        return this.a;
    }
    
    public static final class a
    {
        private String a;
        
        a(final q0 q0) {
        }
        
        public h a() {
            final String a = this.a;
            if (a != null) {
                final h h = new h(null);
                com.android.billingclient.api.h.c(h, a);
                return h;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }
        
        public a b(final String a) {
            this.a = a;
            return this;
        }
    }
}
