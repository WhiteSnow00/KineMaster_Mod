// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin;

import android.os.Parcelable$Creator;
import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

public final class zaa implements Comparator
{
    public static final zaa a;
    
    static {
        a = new zaa();
    }
    
    private zaa() {
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        final Scope scope = (Scope)o;
        final Scope scope2 = (Scope)o2;
        final Parcelable$Creator<GoogleSignInAccount> creator = GoogleSignInAccount.CREATOR;
        return scope.K1().compareTo(scope2.K1());
    }
}
