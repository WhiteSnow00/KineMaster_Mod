// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class DataHolderNotifier<L> implements Notifier<L>
{
    private final DataHolder a;
    
    @KeepForSdk
    @Override
    public final void a(final L l) {
        this.c(l, this.a);
    }
    
    @KeepForSdk
    @Override
    public void b() {
        try (final DataHolder a = this.a) {}
    }
    
    @KeepForSdk
    protected abstract void c(final L p0, final DataHolder p1);
}
