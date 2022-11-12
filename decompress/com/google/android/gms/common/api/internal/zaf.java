// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zaf extends k0
{
    public final zaci c;
    
    public zaf(final zaci c, final TaskCompletionSource taskCompletionSource) {
        super(3, taskCompletionSource);
        this.c = c;
    }
    
    @Override
    public final /* bridge */ void d(final zaad zaad, final boolean b) {
    }
    
    @Override
    public final boolean f(final zabq zabq) {
        return this.c.a.f();
    }
    
    @Override
    public final Feature[] g(final zabq zabq) {
        return this.c.a.c();
    }
    
    public final void h(final zabq zabq) throws RemoteException {
        this.c.a.d(zabq.s(), super.b);
        final ListenerHolder.ListenerKey b = this.c.a.b();
        if (b != null) {
            zabq.u().put(b, this.c);
        }
    }
}
