// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.util;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.auth.api.credentials.Credentials;
import android.app.Activity;
import com.google.android.gms.auth.api.credentials.CredentialsOptions;
import com.google.android.gms.auth.api.credentials.CredentialsClient;
import android.content.Context;

public final class GoogleApiUtils
{
    private GoogleApiUtils() {
        throw new AssertionError((Object)"No instance for you!");
    }
    
    public static CredentialsClient getCredentialsClient(final Context context) {
        final CredentialsOptions b = new CredentialsOptions.Builder().c().b();
        if (context instanceof Activity) {
            return Credentials.a((Activity)context, b);
        }
        return Credentials.c(context, b);
    }
    
    public static boolean isPlayServicesAvailable(final Context context) {
        return GoogleApiAvailability.q().i(context) == 0;
    }
}
