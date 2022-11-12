// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class v0 implements Runnable
{
    final LifecycleCallback a;
    final String b;
    final zzb c;
    
    v0(final zzb c, final LifecycleCallback a, final String b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        final zzb c = this.c;
        if (zzb.a(c) > 0) {
            final LifecycleCallback a = this.a;
            Bundle bundle;
            if (zzb.b(c) != null) {
                bundle = zzb.b(c).getBundle(this.b);
            }
            else {
                bundle = null;
            }
            a.f(bundle);
        }
        if (zzb.a(this.c) >= 2) {
            this.a.j();
        }
        if (zzb.a(this.c) >= 3) {
            this.a.h();
        }
        if (zzb.a(this.c) >= 4) {
            this.a.k();
        }
        if (zzb.a(this.c) >= 5) {
            this.a.g();
        }
    }
}
