// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import android.os.Parcel;
import com.google.android.gms.internal.auth_api.zbb;

public abstract class zbo extends zbb implements zbp
{
    public zbo() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }
    
    protected final boolean zba(final int n, final Parcel parcel, final Parcel parcel2, final int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            this.h();
        }
        else {
            this.r();
        }
        return true;
    }
}
