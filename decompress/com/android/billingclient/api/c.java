// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;

public abstract class c
{
    public static a g(final Context context) {
        return new a(context, null);
    }
    
    public abstract void a(final com.android.billingclient.api.a p0, final b p1);
    
    public abstract void b(final h p0, final i p1);
    
    public abstract void c();
    
    public abstract int d();
    
    public abstract boolean e();
    
    public abstract g f(final Activity p0, final f p1);
    
    public abstract void h(final r p0, final n p1);
    
    @Deprecated
    public abstract void i(final String p0, final o p1);
    
    public abstract void j(final s p0, final p p1);
    
    public abstract void k(final e p0);
    
    public static final class a
    {
        private volatile boolean a;
        private final Context b;
        private volatile q c;
        
        a(final Context b, final j1 j1) {
            this.b = b;
        }
        
        public c a() {
            if (this.b == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            if (this.c == null) {
                throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            }
            if (!this.a) {
                throw new IllegalArgumentException("Support for pending purchases must be enabled. Enable this by calling 'enablePendingPurchases()' on BillingClientBuilder.");
            }
            if (this.c != null) {
                return new d(null, this.a, this.b, this.c, null);
            }
            return new d(null, this.a, this.b, null);
        }
        
        public a b() {
            this.a = true;
            return this;
        }
        
        public a c(final q c) {
            this.c = c;
            return this;
        }
    }
}
