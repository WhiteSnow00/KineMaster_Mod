// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.connection;

import java.util.Map;

public final class a implements j
{
    public final PersistentConnectionImpl a;
    public final boolean b;
    
    public a(final PersistentConnectionImpl a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final void a(final Map map) {
        PersistentConnectionImpl.q(this.a, this.b, map);
    }
}
