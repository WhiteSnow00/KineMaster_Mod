// 
// Decompiled by Procyon v0.6.0
// 

package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzu;
import java.util.List;
import java.util.concurrent.Callable;

final class z implements Callable
{
    final String a;
    final p b;
    final d c;
    
    z(final d c, final String a, final p b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final /* bridge */ Object call() throws Exception {
        final u0 f = d.F(this.c, this.a);
        if (f.b() != null) {
            this.b.a(f.a(), f.b());
        }
        else {
            this.b.a(f.a(), (List<Purchase>)zzu.zzl());
        }
        return null;
    }
}
