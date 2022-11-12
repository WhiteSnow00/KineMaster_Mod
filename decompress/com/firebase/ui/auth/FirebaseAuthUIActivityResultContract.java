// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth;

import android.content.Context;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import android.content.Intent;
import c.a;

public class FirebaseAuthUIActivityResultContract extends a<Intent, FirebaseAuthUIAuthenticationResult>
{
    @Override
    public Intent createIntent(final Context context, final Intent intent) {
        return intent;
    }
    
    @Override
    public /* bridge */ Intent createIntent(final Context context, final Object o) {
        return this.createIntent(context, (Intent)o);
    }
    
    @Override
    public FirebaseAuthUIAuthenticationResult parseResult(final int n, final Intent intent) {
        return new FirebaseAuthUIAuthenticationResult(n, IdpResponse.fromResultIntent(intent));
    }
    
    @Override
    public /* bridge */ Object parseResult(final int n, final Intent intent) {
        return this.parseResult(n, intent);
    }
}
