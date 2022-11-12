// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zah extends k0
{
    public final ListenerHolder.ListenerKey c;
    
    public zah(final ListenerHolder.ListenerKey c, final TaskCompletionSource taskCompletionSource) {
        super(4, taskCompletionSource);
        this.c = c;
    }
    
    @Override
    public final /* bridge */ void d(final zaad zaad, final boolean b) {
    }
    
    @Override
    public final boolean f(final zabq zabq) {
        final zaci zaci = zabq.u().get(this.c);
        return zaci != null && zaci.a.f();
    }
    
    @Override
    public final Feature[] g(final zabq zabq) {
        final zaci zaci = zabq.u().get(this.c);
        if (zaci == null) {
            return null;
        }
        return zaci.a.c();
    }
    
    public final void h(final zabq zabq) throws RemoteException {
        final zaci zaci = zabq.u().remove(this.c);
        if (zaci != null) {
            zaci.b.b(zabq.s(), super.b);
            zaci.a.a();
            return;
        }
        super.b.e((Object)Boolean.FALSE);
    }
}
