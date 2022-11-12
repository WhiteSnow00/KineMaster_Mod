// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth.api.credentials;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import android.app.Activity;

@Deprecated
public class Credentials
{
    public static CredentialsClient a(final Activity activity, final CredentialsOptions credentialsOptions) {
        return new CredentialsClient(activity, credentialsOptions);
    }
    
    public static CredentialsClient b(final Context context) {
        return new CredentialsClient(context, CredentialsOptions.e);
    }
    
    public static CredentialsClient c(final Context context, final CredentialsOptions credentialsOptions) {
        return new CredentialsClient(context, credentialsOptions);
    }
}
