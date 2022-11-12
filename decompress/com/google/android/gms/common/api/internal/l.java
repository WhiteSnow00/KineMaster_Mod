// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Scope;
import java.util.Set;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

final class l extends p
{
    private final ArrayList b;
    final zaaw c;
    
    public l(final zaaw c, final ArrayList b) {
        super(this.c = c, null);
        this.b = b;
    }
    
    public final void a() {
        final zaaw c = this.c;
        zaaw.u(c).y.p = zaaw.y(c);
        final ArrayList b = this.b;
        for (int size = b.size(), i = 0; i < size; ++i) {
            final Api.Client client = (Api.Client)b.get(i);
            final zaaw c2 = this.c;
            client.getRemoteService(zaaw.w(c2), zaaw.u(c2).y.p);
        }
    }
}
