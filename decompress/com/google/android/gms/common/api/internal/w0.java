// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class w0 implements Runnable
{
    final LifecycleCallback a;
    final String b;
    final zzd c;
    
    w0(final zzd c, final LifecycleCallback a, final String b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        final zzd c = this.c;
        if (zzd.g4(c) > 0) {
            final LifecycleCallback a = this.a;
            Bundle bundle;
            if (zzd.h4(c) != null) {
                bundle = zzd.h4(c).getBundle(this.b);
            }
            else {
                bundle = null;
            }
            a.f(bundle);
        }
        if (zzd.g4(this.c) >= 2) {
            this.a.j();
        }
        if (zzd.g4(this.c) >= 3) {
            this.a.h();
        }
        if (zzd.g4(this.c) >= 4) {
            this.a.k();
        }
        if (zzd.g4(this.c) >= 5) {
            this.a.g();
        }
    }
}
