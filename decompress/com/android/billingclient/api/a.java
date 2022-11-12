// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

public final class a
{
    private String a;
    
    a(final n0 n0) {
    }
    
    public static a b() {
        return new a(null);
    }
    
    static /* bridge */ void c(final a a, final String a2) {
        a.a = a2;
    }
    
    public String a() {
        return this.a;
    }
    
    public static final class a
    {
        private String a;
        
        a(final t t) {
        }
        
        public com.android.billingclient.api.a a() {
            final String a = this.a;
            if (a != null) {
                final com.android.billingclient.api.a a2 = new com.android.billingclient.api.a(null);
                com.android.billingclient.api.a.c(a2, a);
                return a2;
            }
            throw new IllegalArgumentException("Purchase token must be set");
        }
        
        public a b(final String a) {
            this.a = a;
            return this;
        }
    }
}
