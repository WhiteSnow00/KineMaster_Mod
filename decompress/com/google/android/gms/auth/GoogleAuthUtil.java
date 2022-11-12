// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.auth;

import java.io.IOException;
import android.content.Context;

public final class GoogleAuthUtil extends zzl
{
    private GoogleAuthUtil() {
    }
    
    @Deprecated
    public static String c(final Context context, final String s, final String s2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzl.c(context, s, s2);
    }
    
    @Deprecated
    public static void d(final Context context, final String s) {
        zzl.d(context, s);
    }
}
