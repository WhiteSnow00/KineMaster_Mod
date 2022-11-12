// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzb;

public final class g
{
    private int a;
    private String b;
    
    public static a c() {
        return new a(null);
    }
    
    static /* bridge */ void d(final g g, final String b) {
        g.b = b;
    }
    
    static /* bridge */ void e(final g g, final int a) {
        g.a = a;
    }
    
    public String a() {
        return this.b;
    }
    
    public int b() {
        return this.a;
    }
    
    @Override
    public String toString() {
        final String zzl = zzb.zzl(this.a);
        final String b = this.b;
        final StringBuilder sb = new StringBuilder();
        sb.append("Response Code: ");
        sb.append(zzl);
        sb.append(", Debug Message: ");
        sb.append(b);
        return sb.toString();
    }
    
    public static class a
    {
        private int a;
        private String b;
        
        a(final o0 o0) {
            this.b = "";
        }
        
        public g a() {
            final g g = new g();
            com.android.billingclient.api.g.e(g, this.a);
            com.android.billingclient.api.g.d(g, this.b);
            return g;
        }
        
        public a b(final String b) {
            this.b = b;
            return this;
        }
        
        public a c(final int a) {
            this.a = a;
            return this;
        }
    }
}
