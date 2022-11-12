// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;
import android.content.Context;
import javax.annotation.concurrent.GuardedBy;

public final class zzag
{
    private static final Object a;
    @GuardedBy
    private static boolean b;
    private static String c;
    private static int d;
    
    static {
        a = new Object();
    }
    
    public static int a(final Context context) {
        b(context);
        return zzag.d;
    }
    
    private static void b(final Context context) {
        synchronized (zzag.a) {
            if (zzag.b) {
                return;
            }
            zzag.b = true;
            final String packageName = context.getPackageName();
            final PackageManagerWrapper a = Wrappers.a(context);
            try {
                final Bundle metaData = a.c(packageName, 128).metaData;
                if (metaData == null) {
                    return;
                }
                zzag.c = metaData.getString("com.google.app.id");
                zzag.d = metaData.getInt("com.google.android.gms.version");
            }
            catch (final PackageManager$NameNotFoundException ex) {
                Log.wtf("MetadataValueReader", "This should never happen.", (Throwable)ex);
            }
        }
    }
}
