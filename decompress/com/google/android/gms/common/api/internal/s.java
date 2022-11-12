// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class s extends zabw
{
    private final WeakReference a;
    
    s(final zabe zabe) {
        this.a = new WeakReference((T)zabe);
    }
    
    @Override
    public final void a() {
        final zabe zabe = (zabe)this.a.get();
        if (zabe == null) {
            return;
        }
        com.google.android.gms.common.api.internal.zabe.x(zabe);
    }
}
