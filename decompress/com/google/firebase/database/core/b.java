// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.core;

import com.google.firebase.database.connection.ConnectionTokenProvider;

public final class b implements Runnable
{
    public final ConnectionTokenProvider.GetTokenCallback a;
    public final String b;
    
    public b(final ConnectionTokenProvider.GetTokenCallback a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void run() {
        Context.Context$a.b(this.a, this.b);
    }
}
