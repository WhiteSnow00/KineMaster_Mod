// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.auth.api.signin.internal.zbm;
import com.google.android.gms.tasks.Task;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.internal.zbn;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import android.app.Activity;

public final class GoogleSignIn
{
    private GoogleSignIn() {
    }
    
    public static GoogleSignInClient a(final Activity activity, final GoogleSignInOptions googleSignInOptions) {
        return new GoogleSignInClient(activity, Preconditions.k(googleSignInOptions));
    }
    
    public static GoogleSignInClient b(final Context context, final GoogleSignInOptions googleSignInOptions) {
        return new GoogleSignInClient(context, Preconditions.k(googleSignInOptions));
    }
    
    public static GoogleSignInAccount c(final Context context) {
        return zbn.c(context).a();
    }
    
    public static Task<GoogleSignInAccount> d(final Intent intent) {
        final GoogleSignInResult d = zbm.d(intent);
        final GoogleSignInAccount a = d.a();
        if (d.getStatus().P1() && a != null) {
            return (Task<GoogleSignInAccount>)Tasks.e((Object)a);
        }
        return (Task<GoogleSignInAccount>)Tasks.d((Exception)ApiExceptionUtil.a(d.getStatus()));
    }
}
