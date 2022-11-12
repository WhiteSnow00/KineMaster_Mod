// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

public final class zabv extends zaag
{
    private final GoogleApi c;
    
    public zabv(final GoogleApi c) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.c = c;
    }
    
    @Override
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T h(final T t) {
        return this.c.doRead(t);
    }
    
    @Override
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T i(final T t) {
        return this.c.doWrite(t);
    }
    
    @Override
    public final Context l() {
        return this.c.getApplicationContext();
    }
    
    @Override
    public final Looper m() {
        return this.c.getLooper();
    }
    
    @Override
    public final void r(final zada zada) {
    }
}
