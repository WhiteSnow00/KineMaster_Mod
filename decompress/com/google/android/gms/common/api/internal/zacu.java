// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.BiConsumer;

public final class zacu implements RemoteCall
{
    public final BiConsumer a;
    
    @Override
    public final void accept(final Object o, final Object o2) {
        this.a.accept(o, o2);
    }
}
