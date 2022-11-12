// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.util;

import android.os.StrictMode$ThreadPolicy;
import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzcfi;
import android.os.StrictMode$ThreadPolicy$Builder;
import android.os.StrictMode;
import java.util.concurrent.Callable;
import android.content.Context;

public final class zzcb
{
    @Deprecated
    public static Object a(final Context context, final Callable callable) {
        try {
            final StrictMode$ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            try {
                StrictMode.setThreadPolicy(new StrictMode$ThreadPolicy$Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
                return callable.call();
            }
            finally {
                StrictMode.setThreadPolicy(threadPolicy);
            }
        }
        finally {
            final Throwable t;
            zzcfi.zzh("Unexpected exception.", t);
            zzbyx.zza(context).zzd(t, "StrictModeUtil.runWithLaxStrictMode");
            return null;
        }
    }
}
