// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

public final class s
{
    private final String a;
    
    s(final a a, final b1 b1) {
        this.a = s.a.c(a);
    }
    
    public static a a() {
        return new a(null);
    }
    
    public final String b() {
        return this.a;
    }
    
    public static class a
    {
        private String a;
        
        a(final a1 a1) {
        }
        
        static /* bridge */ String c(final a a) {
            return a.a;
        }
        
        public s a() {
            if (this.a != null) {
                return new s(this, null);
            }
            throw new IllegalArgumentException("Product type must be set");
        }
        
        public a b(final String a) {
            this.a = a;
            return this;
        }
    }
}
