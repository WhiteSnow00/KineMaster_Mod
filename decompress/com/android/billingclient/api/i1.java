// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import android.content.IntentFilter;
import android.content.Context;

final class i1
{
    private final Context a;
    private final h1 b;
    
    i1(final Context a, final q q, final d1 d1) {
        this.a = a;
        this.b = new h1(this, q, d1, null);
    }
    
    i1(final Context a, final s0 s0) {
        this.a = a;
        this.b = new h1(this, null, null);
    }
    
    static /* bridge */ h1 a(final i1 i1) {
        return i1.b;
    }
    
    final s0 b() {
        h1.a(this.b);
        return null;
    }
    
    final q c() {
        return h1.b(this.b);
    }
    
    final void d() {
        this.b.d(this.a);
    }
    
    final void e() {
        final IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        intentFilter.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.b.c(this.a, intentFilter);
    }
}
