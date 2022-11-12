// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import java.util.concurrent.ScheduledExecutorService;
import com.google.firebase.database.connection.ConnectionTokenProvider;

public final class a implements ConnectionTokenProvider
{
    public final TokenProvider a;
    public final ScheduledExecutorService b;
    
    public a(final TokenProvider a, final ScheduledExecutorService b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void a(final boolean b, final GetTokenCallback getTokenCallback) {
        Context.a(this.a, this.b, b, getTokenCallback);
    }
}
