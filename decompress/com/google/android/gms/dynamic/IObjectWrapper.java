// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.internal.common.zzb;
import android.os.IInterface;

public interface IObjectWrapper extends IInterface
{
    public abstract static class Stub extends zzb implements IObjectWrapper
    {
        public Stub() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }
        
        public static IObjectWrapper M0(final IBinder binder) {
            if (binder == null) {
                return null;
            }
            final IInterface queryLocalInterface = binder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof IObjectWrapper) {
                return (IObjectWrapper)queryLocalInterface;
            }
            return new com.google.android.gms.dynamic.zzb(binder);
        }
    }
}
