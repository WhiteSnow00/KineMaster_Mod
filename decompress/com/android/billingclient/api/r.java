// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import java.util.Iterator;
import java.util.Collection;
import java.util.List;
import com.google.android.gms.internal.play_billing.zzu;

public final class r
{
    private final zzu a;
    
    r(final a a, final z0 z0) {
        this.a = r.a.c(a);
    }
    
    public static a a() {
        return new a(null);
    }
    
    public final zzu b() {
        return this.a;
    }
    
    public final String c() {
        return ((List<b>)this.a).get(0).c();
    }
    
    public static class a
    {
        private zzu a;
        
        a(final w0 w0) {
        }
        
        static /* bridge */ zzu c(final a a) {
            return a.a;
        }
        
        public r a() {
            return new r(this, null);
        }
        
        public a b(final List<b> list) {
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("Product list cannot be empty.");
            }
            final Iterator iterator = list.iterator();
            boolean b = false;
            boolean b2 = false;
            while (iterator.hasNext()) {
                final b b3 = (b)iterator.next();
                b |= b3.c().equals("inapp");
                b2 |= b3.c().equals("subs");
            }
            if (b && b2) {
                throw new IllegalArgumentException("All products should be of the same product type.");
            }
            this.a = zzu.zzk((Collection)list);
            return this;
        }
    }
    
    public static class b
    {
        private final String a;
        private final String b;
        
        b(final a a, final y0 y0) {
            this.a = a.d(a);
            this.b = a.e(a);
        }
        
        public static a a() {
            return new a(null);
        }
        
        public final String b() {
            return this.a;
        }
        
        public final String c() {
            return this.b;
        }
        
        public static class a
        {
            private String a;
            private String b;
            
            a(final x0 x0) {
            }
            
            static /* bridge */ String d(final a a) {
                return a.a;
            }
            
            static /* bridge */ String e(final a a) {
                return a.b;
            }
            
            public b a() {
                if (this.a == null) {
                    throw new IllegalArgumentException("Product id must be provided.");
                }
                if (this.b != null) {
                    return new b(this, null);
                }
                throw new IllegalArgumentException("Product type must be provided.");
            }
            
            public a b(final String a) {
                this.a = a;
                return this;
            }
            
            public a c(final String b) {
                this.b = b;
                return this;
            }
        }
    }
}
