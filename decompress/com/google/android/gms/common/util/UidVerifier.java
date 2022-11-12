// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.util;

import com.google.android.gms.common.wrappers.Wrappers;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.GoogleSignatureVerifier;
import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class UidVerifier
{
    private UidVerifier() {
    }
    
    @KeepForSdk
    public static boolean a(final Context context, final int n) {
        if (!b(context, n, "com.google.android.gms")) {
            return false;
        }
        final PackageManager packageManager = context.getPackageManager();
        try {
            return GoogleSignatureVerifier.a(context).b(packageManager.getPackageInfo("com.google.android.gms", 64));
        }
        catch (final PackageManager$NameNotFoundException ex) {
            if (Log.isLoggable("UidVerifier", 3)) {
                Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }
    
    @KeepForSdk
    public static boolean b(final Context context, final int n, final String s) {
        return Wrappers.a(context).h(n, s);
    }
}
