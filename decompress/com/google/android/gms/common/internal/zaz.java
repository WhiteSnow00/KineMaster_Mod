// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.dynamic.ObjectWrapper;
import android.view.View;
import android.content.Context;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zaz extends RemoteCreator
{
    private static final zaz a;
    
    static {
        a = new zaz();
    }
    
    private zaz() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }
    
    public static View a(final Context context, final int n, final int n2) throws RemoteCreatorException {
        final zaz a = zaz.a;
        try {
            return (View)ObjectWrapper.p1(((zam)a.getRemoteCreatorInstance(context)).M0(ObjectWrapper.q1(context), new zax(1, n, n2, null)));
        }
        catch (final Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not get button with size ");
            sb.append(n);
            sb.append(" and color ");
            sb.append(n2);
            throw new RemoteCreatorException(sb.toString(), ex);
        }
    }
    
    public final Object getRemoteCreator(final IBinder binder) {
        Object o;
        if (binder == null) {
            o = null;
        }
        else {
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            if (queryLocalInterface instanceof zam) {
                o = queryLocalInterface;
            }
            else {
                o = new zam(binder);
            }
        }
        return o;
    }
}
