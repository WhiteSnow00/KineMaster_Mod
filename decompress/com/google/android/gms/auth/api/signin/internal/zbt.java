// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.UidVerifier;
import android.os.Binder;
import android.content.Context;

public final class zbt extends zbo
{
    private final Context a;
    
    public zbt(final Context a) {
        this.a = a;
    }
    
    private final void M0() {
        if (UidVerifier.a(this.a, Binder.getCallingUid())) {
            return;
        }
        final int callingUid = Binder.getCallingUid();
        final StringBuilder sb = new StringBuilder();
        sb.append("Calling UID ");
        sb.append(callingUid);
        sb.append(" is not Google Play services.");
        throw new SecurityException(sb.toString());
    }
    
    public final void h() {
        this.M0();
        zbn.c(this.a).d();
    }
    
    public final void r() {
        this.M0();
        final Storage b = Storage.b(this.a);
        final GoogleSignInAccount c = b.c();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.w;
        if (c != null) {
            googleSignInOptions = b.d();
        }
        final GoogleSignInClient b2 = GoogleSignIn.b(this.a, googleSignInOptions);
        if (c != null) {
            b2.c();
            return;
        }
        b2.signOut();
    }
}
