// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;
import com.google.android.gms.signin.internal.zac;

final class n extends zac
{
    private final WeakReference a;
    
    n(final zaaw zaaw) {
        this.a = new WeakReference((T)zaaw);
    }
    
    public final void s(final zak zak) {
        final zaaw zaaw = (zaaw)this.a.get();
        if (zaaw == null) {
            return;
        }
        com.google.android.gms.common.api.internal.zaaw.u(zaaw).p(new m(this, zaaw, zaaw, zak));
    }
}
