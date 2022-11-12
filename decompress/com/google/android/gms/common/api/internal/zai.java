// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Status;
import android.os.RemoteException;

public abstract class zai
{
    public final int a;
    
    public zai(final int a) {
        this.a = a;
    }
    
    static /* bridge */ Status e(final RemoteException ex) {
        final StringBuilder sb = new StringBuilder();
        sb.append(ex.getClass().getSimpleName());
        sb.append(": ");
        sb.append(ex.getLocalizedMessage());
        return new Status(19, sb.toString());
    }
    
    public abstract void a(final Status p0);
    
    public abstract void b(final Exception p0);
    
    public abstract void c(final zabq p0) throws DeadObjectException;
    
    public abstract void d(final zaad p0, final boolean p1);
}
