// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.wrappers;

import com.google.android.gms.common.util.PlatformVersion;
import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class InstantApps
{
    private static Context a;
    private static Boolean b;
    
    @KeepForSdk
    public static boolean a(final Context context) {
        synchronized (InstantApps.class) {
            final Context applicationContext = context.getApplicationContext();
            final Context a = InstantApps.a;
            if (a != null) {
                final Boolean b = InstantApps.b;
                if (b != null) {
                    if (a == applicationContext) {
                        return b;
                    }
                }
            }
            InstantApps.b = null;
            if (PlatformVersion.i()) {
                InstantApps.b = applicationContext.getPackageManager().isInstantApp();
            }
            else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    InstantApps.b = Boolean.TRUE;
                }
                catch (final ClassNotFoundException ex) {
                    InstantApps.b = Boolean.FALSE;
                }
            }
            InstantApps.a = applicationContext;
            return InstantApps.b;
        }
    }
}
